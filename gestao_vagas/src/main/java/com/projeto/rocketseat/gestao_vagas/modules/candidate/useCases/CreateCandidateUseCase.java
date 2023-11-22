package com.projeto.rocketseat.gestao_vagas.modules.candidate.useCases;

import com.projeto.rocketseat.gestao_vagas.exceptions.UserFoundException;
import com.projeto.rocketseat.gestao_vagas.modules.candidate.CandidateEntity;
import com.projeto.rocketseat.gestao_vagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Classe responsável pela lógica da criação de um candidato

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);

    }
}
