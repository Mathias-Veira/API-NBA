package com.aulanosa.api.services.impl;

import com.aulanosa.api.dtos.AccesoDTO;
import com.aulanosa.api.dtos.UsuarioDTO;
import com.aulanosa.api.error.IdNotFoundException;
import com.aulanosa.api.error.IncompleteDataException;
import com.aulanosa.api.error.LoginException;
import com.aulanosa.api.error.UserExistsException;
import com.aulanosa.api.mappers.UsuarioMapper;
import com.aulanosa.api.models.Usuario;
import com.aulanosa.api.repositories.UsuarioRepository;
import com.aulanosa.api.services.UsuarioService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;

@Service
@Lazy
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    /**
     * Método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    @Override
    public UsuarioDTO comprobarAcceso(AccesoDTO accesoDTO) throws IncompleteDataException, LoginException, IdNotFoundException {
        if(StringUtils.isBlank(accesoDTO.getNombreUsuario())||StringUtils.isBlank(accesoDTO.getPasswordUsuario())){
            throw new IncompleteDataException("El nombre de usuario y contraseña son obligatorios y no pueden estar vacíos");
        }
        UsuarioDTO usuarioDTO = null;
        try {
            Usuario user = usuarioRepository.findByName(accesoDTO.getNombreUsuario());

            if(!user.equals(null)){
                Usuario usuario = user;
                if(usuario.getPasswordUsuario().equals(accesoDTO.getPasswordUsuario())){
                    usuarioDTO = UsuarioMapper.convertirADTO(usuario);
                }else{
                    //LoginException
                    throw new RuntimeException();
                }
            }else{
                //UserNotFoundException
                throw new InvalidDnDOperationException();
            }
        }catch (InvalidDnDOperationException exception){
            throw new IdNotFoundException("El usuario no existe");
        }catch (RuntimeException ex){
            throw new LoginException("Nombre de usuario o contraseña incorrectos");
        }catch (Exception e){
        }
        return usuarioDTO;
    }
    /**
     * Método que permite registrar un usuario a partir de la información indicada
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) throws IncompleteDataException, UserExistsException {
        UsuarioDTO user;
        if(StringUtils.isBlank(usuarioDTO.getNombreUsuario())||StringUtils.isBlank(usuarioDTO.getPasswordUsuario())){
            throw new IncompleteDataException("El nombre de usuario y contraseña son obligatorios y no pueden estar vacíos");
        }
        user = obtenerUsuario(usuarioDTO.getNombreUsuario());
        if(user != null){
            throw new UserExistsException("El usuario ya existe");
        }

        return UsuarioMapper.convertirADTO(usuarioRepository.save(UsuarioMapper.convertirAModelo(usuarioDTO)));
    }

    @Override
    public UsuarioDTO obtenerUsuario(String name) {
        if(usuarioRepository.findByName(name) == null){
            return null;
        }
        return UsuarioMapper.convertirADTO(usuarioRepository.findByName(name));
    }
}
