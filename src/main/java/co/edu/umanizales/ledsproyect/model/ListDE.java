package co.edu.umanizales.ledsproyect.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ListDE {
    private NodeDE head;
    private NodeDE tail;
    private int size;
    private List<Led> leds = new ArrayList<>();
}
