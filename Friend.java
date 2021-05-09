import java.util.ArrayList;

public class Friend {
    String name;
    ArrayList<String> chat = new ArrayList();

    Friend(String name){
        this.name = name;
    }

    public void write(String message){
        chat.add(message);
    }

    public String showChat(){
        int lines = 0;
        String newlines = "";
        String log = "";

        for (int i = 0; i < 20; i++) {
            newlines += "\n";
        }

        for (int i = chat.size()-1; i >= 0 ; i--) {
            log = chat.get(i) +"\n"+log;
            lines++;
            if (lines>4) break;
        }

        return newlines+log;
    }

}
