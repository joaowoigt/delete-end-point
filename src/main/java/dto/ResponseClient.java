package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Account;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class ResponseClient {
    private UUID id;
    private String name;
    private String email;
    private List<Account> accountList;

    public ResponseClient(Client client) {
        this.id = client.getId();
        this.name = client.getNome();
        this.email = client.getEmail();
        this.accountList = client.getAccountList();
    }

    public static List<ResponseClient> toResponse(List<Client> clientList) {
        return clientList.stream().map(ResponseClient::new).collect(Collectors.toList());
    }
}
