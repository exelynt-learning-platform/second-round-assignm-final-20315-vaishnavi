package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;

	    // REGISTER
	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody User user){
	        String response = userService.register(user);
	        return ResponseEntity.status(201).body(response);
	    }
	    
	 // ✅ Login
	    @PostMapping("/login")
	    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
	        String token = authService.login(request);
	        return ResponseEntity.ok(new AuthResponse(token));
	    }  

}
