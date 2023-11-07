package ChatService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatTest {

    @Test
    void shouldNotifyOneUser(){
        Chat chat = new Chat("001");
        User user = new User("Maria");
        user.addToChat(chat);
        chat.sendMessage("Olá");

        assertEquals("Maria, new message from 001: Olá", user.getLastNotification());
    }

    @Test
    void shouldNotNotifyOneUser(){
        Chat chat = new Chat("001");
        User user = new User("Maria");
        chat.sendMessage("Olá");

        assertEquals(null, user.getLastNotification());
    }

    @Test
    void shouldNotifyUsers(){
        Chat chat = new Chat("001");
        User user = new User("Maria");
        User user2 = new User("João");
        user.addToChat(chat);
        user2.addToChat(chat);
        chat.sendMessage("Olá");

        assertEquals("Maria, new message from 001: Olá", user.getLastNotification());
        assertEquals("João, new message from 001: Olá", user2.getLastNotification());
    }

    @Test
    void shouldNotifyUserFromChat1(){
        Chat chat = new Chat("001");
        Chat chat2 = new Chat("002");
        User user = new User("Maria");
        User user2 = new User("João");
        user.addToChat(chat);
        user2.addToChat(chat2);
        chat.sendMessage("Olá");

        assertEquals("Maria, new message from 001: Olá", user.getLastNotification());
        assertEquals(null, user2.getLastNotification());
    }
}