package ChatService;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {

    private String name;
    private String lastNotification;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable chat, Object arg) {
        this.lastNotification = this.name + ", new message from " + ((Chat) chat).getId() + ": " + arg;
        // System.out.println(this.lastNotification);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNotification() {
        return lastNotification;
    }

    public void setLastNotification(String lastNotification) {
        this.lastNotification = lastNotification;
    }

    public void addToChat(Chat chat) {
        chat.addObserver(this);
    }
}
