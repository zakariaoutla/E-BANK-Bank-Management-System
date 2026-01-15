public class Account {
    private int numberCompte;
    private double balance;

    public Account(int numberCompte, double balance){
        this.numberCompte = numberCompte;
        this.balance = balance;
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

    @Override
    public String toString() {
        return "Account{" +
                "numberCompte=" + numberCompte +
                ", balance=" + balance +
                '}';
    }
}
