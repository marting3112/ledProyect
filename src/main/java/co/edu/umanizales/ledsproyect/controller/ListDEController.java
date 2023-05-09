package co.edu.umanizales.ledsproyect.controller;

import co.edu.umanizales.ledsproyect.controller.dto.LedDTO;
import co.edu.umanizales.ledsproyect.controller.dto.ResponseDTO;
import co.edu.umanizales.ledsproyect.model.Led;
import co.edu.umanizales.ledsproyect.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping(path = "/listdeleds")

public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getLeds() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getLeds().print(), null), HttpStatus.OK);
    }

    @PostMapping(path = "/add/{id}")
    public ResponseEntity<ResponseDTO> addLed(@PathVariable int id){

        listDEService.getLeds().addLed(new Led(id,false));
        return new ResponseEntity<>(new ResponseDTO(
                200, "la bombilla fue añadida", null), HttpStatus.OK);

    }


    @GetMapping(path = "/reiniciar")
    public ResponseEntity<ResponseDTO> reiniciar(){

        listDEService.getLeds().reiniciar();
        return new ResponseEntity<>(new ResponseDTO(
                200, "la bombillas reiniciaron su estado", null), HttpStatus.OK);

    }



}
