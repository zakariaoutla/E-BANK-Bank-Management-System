import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String nameBank;
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String nameBank) {
        this.nameBank = nameBank;
    }


    private Client findClient(int clientNumber) {
        for (Client c : clients) {
            if (c.getNumroClient() == clientNumber) {
                return c;
            }
        }
        return null;
    }

    private Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getNumberCompte() == accountNumber) {
                return acc;
            }
        }
        return null;
    }



    public void addClient(Scanner Input) {
        System.out.println("Entre name: ");
        String name = Input.nextLine();
        System.out.println("Entre Numéro de client: ");
        int numroClient = Input.nextInt();

        Client c = new Client(name, numroClient);
        clients.add(c);
        System.out.println("Le client a été ajouté avec succès");
    }

    public void creatAccount(Scanner Input) {
        System.out.println("Entre Numéro de client: ");
        int n = Input.nextInt();

        Client client = findClient(n);
        if (client == null) {
            System.out.println("Ce client n'existe pas");
            return;
        }

        System.out.println("Entre Numéro de compte: ");
        int numberCompte = Input.nextInt();

        if (findAccount(numberCompte) != null) {
            System.out.println("Ce compte existe déjà");
            return;
        }

        System.out.println("Entre Solde initial: ");
        double balance = Input.nextDouble();

        Account a = new Account(numberCompte, balance, client);
        accounts.add(a);
        System.out.println("Le compte a été créé avec succès");
    }

    public void showAccount() {
        if (accounts.isEmpty()) {
            System.out.println("Aucun compte");
        } else {
            for (Account a : accounts) {
                System.out.println("==============================================");
                System.out.println("Name: " + a.getClient().getName());
                System.out.println("Number account: " + a.getNumberCompte());
                System.out.println("Solde: " + a.getBalance() + " DH");
                System.out.println("==============================================");
            }
        }
    }

    public void ConsulteSold(Scanner Input) {
        System.out.println("Entre Numéro de compte: ");
        int cs = Input.nextInt();

        Account acc = findAccount(cs);

        if (acc != null) {
            System.out.println("================== Sold ========================");
            System.out.println("Number compte: " + acc.getNumberCompte());
            System.out.println("Balance compte: " + acc.getBalance());
            System.out.println("==============================================");
        } else {
            System.out.println("Ce compte n'existe pas");
        }
    }

    public void deposeSold(Scanner Input) {
        System.out.println("Entre Numéro de compte: ");
        int depSold = Input.nextInt();

        Account acc = findAccount(depSold);

        if (acc != null) {
            System.out.println("Entrez le montant que vous souhaitez déposer : ");
            double amount = Input.nextDouble();
            if (amount <= 0) {
                System.out.println("Impossible d'entrer un montant négatif");
            } else {
                acc.depose(amount);
                System.out.println("Le solde a été ajouté avec succès");
            }
        } else {
            System.out.println("Ce compte n'existe pas");
        }
    }

    public void retirerSold(Scanner Input) {
        System.out.println("Entre Numéro de compte: ");
        int num = Input.nextInt();

        Account acc = findAccount(num);

        if (acc != null) {
            System.out.println("Entrez le montant que vous souhaitez retirer : ");
            double amount = Input.nextDouble();
            if (amount <= acc.getBalance()) {
                acc.retirer(amount); // تأكد بلي عندك ميثود سميتها retirer فكلاس Account
                System.out.println("Le solde a été retiré avec succès");
            } else {
                System.out.println("Solde insuffisant.");
            }
        } else {
            System.out.println("Ce compte n'existe pas");
        }
    }

    public void supprimeCompte(Scanner Input) {
        System.out.println("Entre Numéro de compte: ");
        int num = Input.nextInt();

        Account acc = findAccount(num);

        if (acc != null) {
            accounts.remove(acc);
            System.out.println("Le compte a été supprimé avec succès");
        } else {
            System.out.println("Ce compte n'existe pas");
        }
    }


    public void transfertArgent(Scanner Input){
        System.out.println("Entre Numéro de compte: ");
        int ta = Input.nextInt();
        Account trAcc = findAccount(ta);

        if(trAcc !=null ){
            System.out.println("Entre le compte destinataire: ");
            int cd = Input.nextInt();
            Account rvAcc = findAccount(cd);
            if (rvAcc == null){
                System.out.println("had account mkaynch");
                return;
            }

            if(trAcc.getNumberCompte() == rvAcc.getNumberCompte()){
                System.out.println("Le même compte ne peut pas être envoyé");
                return;
            }


            System.out.println("Entre sold: ");
            double trsold = Input.nextDouble();
            if (trsold<=0){
                System.out.println("Impossible d'entrer un montant négatif");
            }else if(trAcc.getBalance()<trsold){
                System.out.println("sold insuffisant");
            }else {
                trAcc.retirer(trsold);
                rvAcc.depose(trsold);
                System.out.println("Numéro de compte: " + trAcc.getNumberCompte());
                System.out.println("New Balance : " + trAcc.getBalance());
            }



        }else {
            System.out.println("had account rah awa mkaynch");
        }

    }










    @Override
    public String toString() {
        return "Bank{" +
                "nameBank='" + nameBank + '\'' +
                ", clients=" + clients +
                ", accounts=" + accounts +
                '}';
    }
}