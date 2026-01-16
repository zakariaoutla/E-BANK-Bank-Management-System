public class Account {
    protected int numberCompte;
    protected double balance;
    Client client;

    public Account(int numberCompte, double balance, Client client){
        this.numberCompte = numberCompte;
        this.balance = balance;
        this.client = client;
    }

    public int getNumberCompte(){
        return numberCompte;
    }

    public void setNumberCompte( int numberCompte){

        this.numberCompte = numberCompte;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){

        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "numberCompte=" + numberCompte +
                ", balance=" + balance +
                '}';
    }
}
