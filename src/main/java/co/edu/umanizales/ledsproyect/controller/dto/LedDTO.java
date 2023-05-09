package co.edu.umanizales.ledsproyect.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor

public class LedDTO {
    private int id;
    private boolean state;

}
