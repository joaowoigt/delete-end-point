package com.aula04.banco.banco.controller;

import dto.RequestClient;
import dto.ResponseClient;
import model.Account;
import model.AccountType;
import model.Client;
import model.DB;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    DB dataBase = new DB();
    Random random;

    @GetMapping
    public List<ResponseClient> clients() {
/*        List<Account> accounts = new ArrayList<>();
        Account account = new Account("1234", "123", AccountType.CONTA_CORRENTE);
        accounts.add(account);
        Client client1 = new Client(UUID.randomUUID(),
                "joao",
                "joaowoigt@gmail.com",
                "1234",
                accounts);
        Client client2 = new Client(UUID.randomUUID(),
                "Maria",
                "maria@gmail.com",
                "123456",
                accounts);
        Client client3 = new Client(UUID.randomUUID(),
                "Milleny",
                "milleny@gmail.com",
                "123456",
                accounts);
        dataBase.add(client1);
        dataBase.add(client2);
        dataBase.add(client3);*/
        return ResponseClient.toResponse(dataBase.showClients());
    }

    @PostMapping
    public ResponseEntity<ResponseClient> cadastraClient(
            @RequestBody RequestClient requestClient,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Account account = new Account(String.valueOf(random.nextInt()), requestClient.getAgencia(), AccountType.CONTA_CORRENTE);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        Client newClient = new Client(UUID.randomUUID(),
                requestClient.getNome(),
                requestClient.getEmail(),
                requestClient.getSenha(),
                accountList);
        dataBase.add(newClient);
        ResponseClient responseClient = new ResponseClient(newClient);
        URI uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.created(uri).body(responseClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseClient> clientDetails(@PathVariable UUID id) throws Exception {
        Client client = dataBase.clientDetails(id);
        return ResponseEntity.ok(new ResponseClient(client));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseClient> editClient(
            @PathVariable UUID id,
            @RequestBody RequestClient requestClient
    ) throws Exception {
        Client client = dataBase.editClient(id, requestClient);
        return ResponseEntity.ok(new ResponseClient(client));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(
            @PathVariable UUID id
    ) throws Exception {
        dataBase.deleteClient(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
