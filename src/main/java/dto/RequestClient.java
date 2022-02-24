package dto;

import lombok.Getter;
import lombok.Setter;
import model.Account;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RequestClient {
    private String nome;
    private String email;
    private String password;
    private String agency;
}
