package com.projeto.rocketseat.gestao_vagas.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Pattern(regexp = "^(?!.*\\s).*$", message = "O campo [username] não deve conter espaços")
    private String username;
    @Email(message = "O campo deve conter um email válido")
    private String email;
    @Length(min = 8, max = 38, message = "A senha deve conter entre 8 e 38 caracteres")
    private String senha;
    private String description;
    private String curriculum;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
