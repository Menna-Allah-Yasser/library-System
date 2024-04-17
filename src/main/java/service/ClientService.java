package service;

import entity.Client;
import entity.User;
import repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {

    Scanner scanner = new Scanner(System.in);

    private ClientRepository clientRepository=new ClientRepository();
    public void addClient(){

        String fname , lname ,  email,  address;
        System.out.print("Enter Client first name : ");
        fname=scanner.next();
        System.out.println();

        System.out.print("Enter Client last name : ");
        lname=scanner.next();
        System.out.println();

        System.out.print("Enter Client E-mail : ");
        email=scanner.next();
        System.out.println();

        System.out.print("Enter Client address : ");
        address=scanner.next();
        System.out.println();

        Client client= new Client(fname , lname , email , address);
        clientRepository.insertClient(client);
        System.out.println("User inserted with name : "+ client.getFname() + " "+client.getLname() );
    }

    boolean isIDExist(Long id) {
        List<Long> IDs = clientRepository.AllIDs();

        for(Long i : IDs){
            if(i==id){
                return true;
            }
        }
        return false;
    }
}
