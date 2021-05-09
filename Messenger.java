import java.util.ArrayList;
import java.util.Scanner;

public class Messenger {

    ArrayList<Friend> friends = new ArrayList();


    private String getFriends(){
        String friendsString = "\nFriends: \n";
        for (int i = 1; i <= friends.size(); i++) {
            friendsString +=  i+" "+friends.get(i-1).name+"\n";
        }
        return friendsString;
    }


    private int getChoise(){
        Scanner scanner = new Scanner(System.in);
        int choise = 999;
        try {
            choise =  scanner.nextInt();
        }
        catch( Exception e){
            System.out.println("Invalid choise. \n");
        }
        return choise;
    }

    private String getMessage(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private void menuChoises(int n){

        switch(n) {
            case 1:
                System.out.println("1 Friends \n2 Quit");
                break;

            case 2:
                System.out.println(getFriends());
                break;

            case 3:
                System.exit(0);
        }
    }


    public void menu(){
        System.out.println("Messenger app");

        menuChoises(1);

        switch(getChoise()){
            case 1:
                menuChoises(2);
                Friend friend = friends.get(getChoise()-1);
                System.out.println(friend.showChat());
                System.out.println("Write message: \n");
                String message = getMessage();

                while(!message.toLowerCase().equals("exit")) {
                    friend.write(message);
                    System.out.println(friend.showChat());
                    message = getMessage();
                }
                menu();
            case 2:
                menuChoises(3);

        }


    }


    public static void main(String[] args) {
        Messenger messenger = new Messenger();

        messenger.friends.add(new Friend("Eve"));
        messenger.friends.add(new Friend("Adam"));

        messenger.menu();

    }

}
