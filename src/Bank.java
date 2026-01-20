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
       System.out.println("Entre Numéro de client: ");
       int numroClient = Input.nextInt();

       Client c = new Client(name, numroClient);
       clients.add(c);
       System.out.println("Le client a été ajouté avec succés");

   }

   public void creatAccount(Scanner Input){
       int numberCompte;
       double balance;
       Client client = null;
       boolean findAccount = false;
       System.out.println("Entre Numéro de client: ");
       int n = Input.nextInt();
       for(Client c : clients){
           if(n == c.getNumroClient()){
               client = c;
               break;
           }
       }
       if (client == null){
           System.out.println("Ce client n'existe pas");
           return;
       }
       System.out.println("Entre Numéro de compte: ");
       numberCompte = Input.nextInt();
       for(Account acc: accounts){
           if(numberCompte == acc.getNumberCompte()){
               findAccount = true;
               break;
           }
       }

       if(findAccount){
           System.out.println("Ce compte existe déja");
           return;
       }
       System.out.println("Entre Solde initial: ");
       balance = Input.nextDouble();
       Input.nextLine();
       Account a = new Account(numberCompte, balance,client);
       accounts.add(a);
       System.out.println("Le Account a été Créer avec succés");
   }


   public void showAccount(){
       for (Account a : accounts){
           System.out.println("==============================================");
           System.out.println("name: "+ a.getClient().getName());
           System.out.println("Number account: "+ a.getNumberCompte());
           System.out.println("sold: " + a.getBalance()+ " DH");
           System.out.println("==============================================");

       }
   }

   public void ConsulteSold(Scanner Input) {
       boolean soldCon = false;
       System.out.println("Entre Numéro de compte: ");
       int cs = Input.nextInt();
       Input.nextLine();
       for (Account acc : accounts) {
           if (cs == acc.getNumberCompte()) {
               soldCon = true;
               break;
           }

       }

       for (Account account : accounts){
           if (soldCon){
               System.out.println("================== Sold ========================");
               System.out.println("Number compte: " + account.getNumberCompte());
               System.out.println("Balance compte: " + account.getBalance());
               System.out.println("==============================================");
           }

       }
       if (!soldCon){
           System.out.println("Ce compte n'existe pas");
       }
   }

   public void deposeSold(Scanner Input){
       boolean depoSold = false;
       System.out.println("Entre Numéro de compte: ");
       double depSold = Input.nextDouble();
       for (Account acc : accounts){
           if(depSold == acc.getNumberCompte()){
               depoSold = true;
               break;
           }
       }
       for (Account account: accounts){
           if (depoSold){
               System.out.println("Entrez le montant que vous souhaitez déposer : ");
               double newSold = Input.nextDouble();
               if (newSold <=0){
                   System.out.println("Impossible d'entrer un montant négatif");
               }else {
                   account.depose(newSold);
               }
           }
       }
       if (!depoSold){
           System.out.println("Ce compte n'existe pas");
       }

   }

   public void retirerSold(Scanner Input){
       boolean retireSold = false;
       System.out.println("Entre Numéro de compte: ");
       double depSold = Input.nextDouble();
       for (Account acc : accounts){
           if(depSold == acc.getNumberCompte()){
               retireSold = true;
               break;
           }
       }
       for (Account account: accounts){
           if (retireSold){
               System.out.println("Entrez le montant que vous souhaitez retirer : ");
               double newSold = Input.nextDouble();
               if (newSold<= account.getBalance()){
                   account.retirer(newSold);
               }else {
                   System.out.println("Sold insuffisant pour effectuer le retrait.");
               }
           }
       }
       if (!retireSold){
           System.out.println("Ce compte n'existe pas");
       }
   }




    @Override
    public String toString() {
        return "Bank{" +
                "name='" + nameBank + '\'' +
                '}';
    }
}
