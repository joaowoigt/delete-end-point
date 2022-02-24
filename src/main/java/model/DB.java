package model;

import dto.RequestClient;

import java.util.*;

public class DB {
    private static List<Client> clients = new ArrayList<>();

    public void add(Client client) {
        DB.clients.add(client);
    }

    public List<Client> showClients() {
        return DB.clients;
    }

    public Client clientDetails(UUID id) throws Exception {
        Optional<Client> client = DB.clients.stream().filter(it ->
                Objects.equals(it.getId(), id)).findAny();
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    public Client editClient(UUID id, RequestClient requestClient) throws Exception {
        DB.clients.stream().filter(client -> Objects.equals(client.getId(), id))
                .forEach(client -> {
                    client.setNome(requestClient.getNome());
                    client.setEmail(requestClient.getEmail());
                    client.setPassword(requestClient.getSenha());
                });
        return clientDetails(id);
    }

    public void deleteClient(UUID id) throws Exception {
        Client deleteClient = clientDetails(id);
        clients.remove(deleteClient);
    }
}
