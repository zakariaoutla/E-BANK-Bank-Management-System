import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choiceInput = new Scanner(System.in);

        int choice = 0;
       try{


        do{
            System.out.println("Menu E-BANK");
            System.out.println("1.Ajoute un client");
            System.out.println("2.Créér un compte");
            System.out.println("3.Affiche les compte");
            System.out.println("4.Consulte le sold");
            System.out.println("5.Déposer de l'argent");
            System.out.println("6.Retirer de l'argent");
            System.out.println("7.Supprime un compte");
            System.out.println("0.Quittez");


            System.out.println("Entre choice: ");
            choice = choiceInput.nextInt();

            switch (choice){
                case 1:
                    System.out.println("======Ajoute un client======");
                    break;
                case 2:
                    System.out.println("======Créér un compte======");
                    break;
                case 3:
                    System.out.println("======Affiche les comptes======");
                    break;
                case 4:
                    System.out.println("======Consulte le sold======");
                    break;
                case 5:
                    System.out.println("======Déposer de l'argent======");
                    break;
                case 6:
                    System.out.println("=====Retirer de l'argent=====");
                    break;
                case 7:
                    System.out.println("=====Supprime un compte=====");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("======Entre valid choice======");
            }

        }while (choice !=0);
       }catch (InputMismatchException e){
           System.out.println("Invalid inpute");
       }
    }
}