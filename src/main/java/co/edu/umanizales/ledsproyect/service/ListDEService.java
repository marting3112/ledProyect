package co.edu.umanizales.ledsproyect.service;

import co.edu.umanizales.ledsproyect.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private ListDE leds;
    public ListDEService(){
        leds = new ListDE();
    }
}
