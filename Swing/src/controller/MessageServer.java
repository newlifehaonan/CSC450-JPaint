package controller;

import model.Message;

import java.util.*;

public class MessageServer implements Iterable<Message> {

    Map<Integer, List<Message>> ServerMessages;
    List<Message> SelectedMessages;


    public MessageServer(){
        this.ServerMessages = new TreeMap<>();
        this.SelectedMessages = new ArrayList<>();

        ArrayList<Message> list = new ArrayList<>();

        list.add(new Message("Hello","My name is Harry! Nice to meet you!"));

        list.add(new Message("Dinner","Let go have a dinner tonight!"));

        list.add(new Message("GoodBye","Wish you have a wonderful day!"));

        ServerMessages.put(0,list);

        list = new ArrayList<Message>();

        list.add(new Message("Another email","Hello again, how's your day"));

        ServerMessages.put(1,list);


        list = new ArrayList<Message>();

        list.add(new Message("Another email2","Hello again, how's your day2"));

        list.add(new Message("Another email3","Hello again, how's your day3"));

        ServerMessages.put(3,list);


    }


    public void setSelectedServers(Set<Integer> servers) {

        SelectedMessages.clear();

        for(Integer serverId: servers) {



            if(ServerMessages.containsKey(serverId)) {
                SelectedMessages.addAll(ServerMessages.get(serverId));
            }
        }
    }

    public int getMessagecount() {
       return SelectedMessages.size();
    }

    @Override
    public Iterator<Message> iterator() {
        return new MessagesIterator(SelectedMessages);
    }
}

class MessagesIterator implements Iterator {

    private Iterator iterator;

    public MessagesIterator(List<Message> messages) {
        this.iterator = messages.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
