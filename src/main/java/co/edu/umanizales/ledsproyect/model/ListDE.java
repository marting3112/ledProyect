package co.edu.umanizales.ledsproyect.model;

import co.edu.umanizales.ledsproyect.excepcion.ListDEExcepcion;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data

public class ListDE {
    private NodeDE head;
    private NodeDE tail;
    private int size;
    private List<Led> leds = new ArrayList<>();

    public void addLed(Led led) {
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

    public void reiniciar(){
        NodeDE temp = head;
        while (temp != null){
            temp.getData().setState(false);
            temp.getData().setDateOff(null);
            temp.getData().setDateOn(null);

            temp = temp.getNext();
        }

    }

    public void addToStart(Led led)  {
        NodeDE newNode = new NodeDE(led);
        if (head != null) {
            head.setPrev(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void addToEnd(Led led) {
        NodeDE newNode = new NodeDE(led);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public  void turnOnLight(){
        if (head != null) {
            NodeDE temp = head;
            int pasos = 1;
            int medium;
            if ((size%2)!=0){
                medium = (size / 2) + 1;
                while (temp!= null){

                    if (pasos == medium){
                        NodeDE tempNext = temp;
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null){

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrev();
                            tempNext= tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));



                        }
                    }
                    pasos++;
                    temp= temp.getNext();


                }




            } else{
                medium = size/2;

                while (temp!= null){
                    if (pasos == medium){
                        NodeDE tempNext = temp.getNext();
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                        tempNext.getData().setState(true);
                        tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                        while (tempNext.getNext() != null) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                            temp = temp.getPrev();
                            tempNext = tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));


                        }
                    }
                    pasos++;
                    temp= temp.getNext();

                }

            }

        }

    }
}
