package cryptocurrencymappingservice.service;


import cryptocurrencymappingservice.domain.Role;
import cryptocurrencymappingservice.domain.response.AuthenticationResponse;
import cryptocurrencymappingservice.entity.AuthenticationRequest;
import cryptocurrencymappingservice.entity.RegisterRequest;
import cryptocurrencymappingservice.entity.User;
import cryptocurrencymappingservice.repository.UserRepository;
import cryptocurrencymappingservice.securityConfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest){
        var user = User.builder()
                .Id(UUID.randomUUID())
                .firstName(registerRequest.getFirstname())
                .emailId(registerRequest.getEmail())
                .lastName(registerRequest.getLastname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse authenticate (AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        var user = userRepository.findByEmailId(authenticationRequest.getEmail()).get();
        var jwttoken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwttoken).build();
    }
}
