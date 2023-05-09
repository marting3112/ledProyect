package co.edu.umanizales.ledsproyect.model;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data

public class ListDE {
    private NodeDE head;
    private int size;
    private List<Led> leds = new ArrayList<>();

    public void addLed(Led led) {

        int size = 0;

        if (head == null) {
            head = new NodeDE(led);
        } else {
            NodeDE newNode = new NodeDE(led);
            NodeDE current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
        size++;
    }

    public List <Led> print(){
        leds.clear();
        if (head != null){
            NodeDE temp = head;
            while (temp != null){
                leds.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return leds;
    }

}
