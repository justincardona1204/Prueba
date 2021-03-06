/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.edu.ciclo3.Reto3.Model.Reservation;
import usa.edu.ciclo3.Reto3.Services.ReservationServices;



/**
 *
 * @author justi
 */
@RestController
@RequestMapping("/api/Reservation") // /api/Reservation/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationServices objReservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return objReservationService.getReservations(); 
    }

    @GetMapping({"/id"})
    public Optional<Reservation> getIdReservation(@PathVariable("id") int id) {
        return objReservationService.getIdReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation objRe) {
        return objReservationService.saveReservation(objRe);
    }

    
}
