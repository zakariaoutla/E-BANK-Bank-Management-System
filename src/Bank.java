import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String nameBank;
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();

   public Bank(String nameBank){

       this.nameBank = nameBank;
   }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public void addClient(Scanner Input){
       System.out.println("Entre name: ");
       String name = Input.nextLine();
       Input.nextLine();
       System.out.println("Entre Numéro de client: ");
       int numroClient = Input.nextInt();

       Client c = new Client(name, numroClient);
       clients.add(c);
       System.out.println("Le client a été ajouté avec succés");
   }

   public void creatAccount(Scanner Input){
       System.out.println("Entre Numéro de client: ");
       int n = Input.nextInt();
       for(Client c : clients){
           if(n == c.getNumroClient()){
               System.out.println("Entre Numéro de compte: ");
               int numberCompte = Input.nextInt();
               Input.nextLine();
               System.out.println("Entre Solde initial: ");
               double balance = Input.nextDouble();

               Account a = new Account(numberCompte, balance,c);
               accounts.add(a);
               System.out.println("Le Account a été Créer avec succés");
           }else{
               System.out.println("Ce client n'existe pas");
           }
       }

   }


   public void showAccount(){
       for (Account a : accounts){
           System.out.println("name: "+ a.getClient().getName());
           System.out.println("Number account: "+ a.getNumberCompte());
           System.out.println("sold: " + a.getBalance());
       }
   }





    @Override
    public String toString() {
        return "Bank{" +
                "name='" + nameBank + '\'' +
                '}';
    }
}
