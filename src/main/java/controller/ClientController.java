package controller;

import service.ClientService;

public class ClientController {

    private ClientService  clientService = new ClientService();

    public void addClient(){
        clientService.addClient();
    }
}
