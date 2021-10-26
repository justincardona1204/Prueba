/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Reservation;
import usa.edu.ciclo3.Reto3.Repository.ReservationRepository;


/**
 *
 * @author justi
 */
@Service
public class ReservationServices {
      @Autowired
    private ReservationRepository reservacion;

    public List<Reservation> getReservations() {
        return reservacion.getReservations();
    }

    public Optional<Reservation> getIdreservation(int id) {
        return reservacion.getIdReservation(id);
    }

    public Reservation saveReservation(Reservation objRe) {
        if (objRe.getIdReservation() == null) {
            return reservacion.saveReservation(objRe);
        } else {
            Optional<Reservation> reservationAux = reservacion.getIdReservation(objRe.getIdReservation());

            if (reservationAux.isEmpty()) {
                return reservacion.saveReservation(objRe);
            } else {
                return objRe;
            }
        }
    }

    public Optional<Reservation> getIdReservation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
