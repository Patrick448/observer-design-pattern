package ChatService;

import java.util.Observable;

public class Chat extends Observable {
    private String id;

    public Chat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void sendMessage(String message) {
        setChanged();
        notifyObservers(message);
    }
}
