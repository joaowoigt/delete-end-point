package dto;

import com.aula04.banco.banco.utils.CPF;
import lombok.Getter;
import lombok.Setter;
import model.Account;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RequestClient {
    @NotNull(message = "nao")
    private String nome;
    private String email;
    @CPF
    private String cpf;
    private String password;
    private String agency;
}
