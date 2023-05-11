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

    /*
    Verifico si la cabeza (head) no es nula.
Si la cabeza no es nula, procedo con los siguientes pasos. De lo contrario, salgo del método.
Inicializo una variable temporal (temp) con el valor de la cabeza.
Establezco la variable "pasos" en 1 para llevar un registro del número de pasos.
Declaro una variable "medium" para almacenar el valor medio.
Si el tamaño de la lista es impar (size % 2 != 0):
Calculo el valor medio sumando 1 al resultado de la división entera de size entre 2.
Inicio un bucle mientras el nodo temporal (temp) no sea nulo:
Verifico si el número de pasos es igual al valor medio:
Creo una variable temporal (tempNext) para almacenar el siguiente nodo.
Establezco el estado del Led en el nodo temporal actual (temp) como encendido (true).
Establezco la fecha de encendido del Led en el nodo temporal actual (temp) con la hora actual.
Inicio un bucle mientras el siguiente nodo temporal (tempNext) no sea nulo:
Espero durante 1 segundo.
Establezco el estado del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) como apagados (false).
Establezco la fecha de apagado del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) con la hora actual.
Actualizo el nodo temporal actual (temp) al nodo anterior (prev).
Actualizo el nodo temporal siguiente (tempNext) al nodo siguiente (next).
Establezco el estado del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) como encendidos (true).
Establezco la fecha de encendido del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) con la hora actual.
Incremento el número de pasos.
Actualizo el nodo temporal (temp) al siguiente nodo.
Si el tamaño de la lista es par (size % 2 == 0):
Calculo el valor medio dividiendo el tamaño de la lista entre 2.
Inicio un bucle mientras el nodo temporal (temp) no sea nulo:
Verifico si el número de pasos es igual al valor medio:
Creo una variable temporal (tempNext) para almacenar el siguiente nodo.
Establezco el estado del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) como encendidos (true).
Establezco la fecha de encendido del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) con la hora actual.
Inicio un bucle mientras el siguiente nodo temporal (tempNext) no sea nulo:
Espero durante 1 segundo.
Establezco el estado del Led en el nodo temporal actual (temp) y en el nodo temporal siguiente (tempNext) como apagados (false).
Establezco la fecha de apagado del Led en el nodo temporal actual (temp) y en el nodo temporal
     */

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
