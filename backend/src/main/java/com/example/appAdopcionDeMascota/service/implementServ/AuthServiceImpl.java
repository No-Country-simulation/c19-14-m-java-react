package com.example.appAdopcionDeMascota.service.implementServ;

import com.example.appAdopcionDeMascota.dto.AuthCreateUserRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginResponse;
import com.example.appAdopcionDeMascota.dto.AuthRegisterResponse;
import com.example.appAdopcionDeMascota.entity.Direccion;
import com.example.appAdopcionDeMascota.entity.User;
import com.example.appAdopcionDeMascota.exception.UserException;
import com.example.appAdopcionDeMascota.jwt.JwtUtils;
import com.example.appAdopcionDeMascota.repository.DireccionRepository;
import com.example.appAdopcionDeMascota.repository.UserRepository;
import com.example.appAdopcionDeMascota.service.interfaceServ.IAuthServcivce;
import com.example.appAdopcionDeMascota.utils.Estado;
import com.example.appAdopcionDeMascota.utils.Role;
import com.example.appAdopcionDeMascota.utils.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements IAuthServcivce , UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final DireccionRepository direccionRepository;
    private Long userId;

    @Override
    public AuthRegisterResponse createUser(AuthCreateUserRequest createUserRequest) {

        validateRole(createUserRequest.role());

        ArrayList<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(createUserRequest.role().name())));

        Direccion direccion = new Direccion();
        direccion = direccionRepository.save(createUserRequest.direccion());

        User user = new User();
        user = userRepository.save(User.builder()
                .nombre(createUserRequest.nombre())
                .apellido(createUserRequest.apellido())
                .imagen_url("default_image_url") // Colocar imagen por defecto
                .username(createUserRequest.username())
                .email(createUserRequest.email())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .status(Estado.ACTIVO.name())
                .telefono(createUserRequest.telefono())
                .edad(createUserRequest.edad())
                .direccion(direccion)
                .role(createUserRequest.role())
                .build());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), authorityList);
        String accessToken = jwtUtils.createToken(authentication , user.getUser_id());

        return new AuthRegisterResponse(user.getUser_id(),
                user.getNombre(),
                user.getApellido(),
                user.getImagen_url(),
                user.getUsername(),
                user.getTelefono(),
                user.getEdad(),
                user.getEmail(),
                user.getStatus(),
                user.getDireccion(),
                user.getRole(),
                accessToken);


    }

    @Override
    public AuthLoginResponse loginUser(AuthLoginRequest loginUserRequest) {

        Authentication authentication = this.authenticate(loginUserRequest.userEmail(), loginUserRequest.password());

        SecurityContextHolder.getContext().setAuthentication(authentication);



        String accessToken = jwtUtils.createToken(authentication , this.userId);

        return  new AuthLoginResponse( "User logged succesfully" , accessToken);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " does not exist"));

        this.userId = user.getUser_id();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // Añadir el rol del usuario
        authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(user.getRole().name())));

        return new UserDetailsImpl(
                user.getUser_id(),
                user.getEmail(),
                user.getPassword(),
                authorityList);
    }


    public Authentication authenticate(String userEmail, String password) {
        UserDetails userDetails = this.loadUserByUsername(userEmail);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid userEmail or Password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userEmail, userDetails.getPassword(), userDetails.getAuthorities());
    }


    public void validateRole(Role role) {
        if (role == Role.ADMIN || !EnumSet.of(Role.DONADOR, Role.INSTITUCION, Role.ADOPTADOR).contains(role)) {
            throw new UserException("Debe ingresar uno de los siguientes roles: INSTITUCION, DONADOR o ADOPTADOR" , HttpStatus.BAD_REQUEST);
        }
    }

}

