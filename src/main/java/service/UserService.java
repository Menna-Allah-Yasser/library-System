package service;

import entity.User;
import repository.UserRepository;

import java.util.Scanner;

public class UserService {

   private UserRepository userRepository = new UserRepository();

    Scanner scanner = new Scanner(System.in);

   public void addUser(){

       String fname , lname , pass;
       System.out.print("Enter your first name : ");
       fname=scanner.next();

       System.out.print("Enter your last name : ");
       lname=scanner.next();

       System.out.print("Enter your password : ");
       pass=scanner.next();

       User user= new User(fname , lname , pass);
       userRepository.insertUser(user);
       System.out.println("User inserted with name : "+ user.getFname() + " "+user.getLname() );
   }

   public boolean authentication(){
       String pass;
       Long id;

       System.out.print("Enter your id : ");
       id=scanner.nextLong();

       System.out.print("Enter your pass : ");
       pass=scanner.next();

       String returnPass = userRepository.getPassById(id);
       if(pass.equals(returnPass)){
           System.out.println("Welcome To Library Management System !!");
           return true;
       }
       else{
           System.out.println("Password is WRONG !!");
           return false;
       }


   }


}
