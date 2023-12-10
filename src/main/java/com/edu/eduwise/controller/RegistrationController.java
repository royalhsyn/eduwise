package com.edu.eduwise.controller;

import com.edu.eduwise.dto.RegistrationDto;
import com.edu.eduwise.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("registration")
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegistrationDto dto) {
        service.register(dto);
    }

    @GetMapping("/resend")
    @PreAuthorize("permitAll()")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void resend(@RequestParam String email) {
        service.resend(email);
    }

    @GetMapping("/confirmation/{uuid}")
    public void confirmation(@PathVariable UUID uuid) {
        service.confirm(uuid);
    }
}

