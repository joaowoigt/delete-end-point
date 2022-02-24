package model;

import dto.ResponseClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private UUID id;
    private String nome;
    private String email;
    private String password;
    private List<Account> accountList;

}
