package co.edu.umanizales.ledsproyect.model;

import lombok.Data;

@Data

public class NodeDE {
    private Led data;
    private NodeDE next;
    private NodeDE prev;

    public NodeDE (Led data){this.data = data;}

}
