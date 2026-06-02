package com.votacion.infrastructure.entrypoint.rest;

import com.votacion.infrastructure.adapter.IUsuarioRepository;
import com.votacion.infrastructure.adapter.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String clave = credenciales.get("clave");

        UsuarioEntity usuario = usuarioRepository.findByEmail(email);

        if (usuario == null || !passwordEncoder.matches(clave, usuario.getClave())) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Credenciales incorrectas");
            return ResponseEntity.status(401).body(error);
        }

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Login exitoso");
        respuesta.put("usuario", usuario.getNombre());
        respuesta.put("rol", usuario.getRol());
        return ResponseEntity.ok(respuesta);
    }
}
