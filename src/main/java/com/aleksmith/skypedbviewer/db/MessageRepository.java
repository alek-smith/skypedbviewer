package com.aleksmith.skypedbviewer.db;

import java.time.Instant;

import com.aleksmith.skypedbviewer.AppState;
import com.aleksmith.skypedbviewer.db.entity.Message;

public class MessageRepository implements Repository<Message> {

    private final AppState state;

    public MessageRepository(AppState state) {
        this.state = state;
    }

    public Message[] getMessagesByAuthor(String author) {
        return null;
    }

    public Message[] getMessagesByConversation(int convoId) {
        return null;
    }

    public Message[] getMessagesByTimestamp(Instant earliest, Instant latest) {
        earliest = earliest == null ? Instant.MIN : earliest;
        latest = latest == null ? Instant.MAX : latest;
        return null;
    }

    public Message[] getMessages(int convoId, String author, Instant earliest, Instant latest) {
        return null;
    }

}
