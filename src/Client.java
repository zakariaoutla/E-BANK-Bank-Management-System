public class Client extends Person {
    protected int numroClient;

    public Client(String name, int numroClient) {
        super(name);
        this.numroClient = numroClient;
    }


    public int getNumroClient(){
        return numroClient;
    }

    public void setNumroClient(int numroClient){
        this.numroClient = numroClient;
    }




}
