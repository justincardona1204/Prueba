/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Room;
import usa.edu.ciclo3.Reto3.Repository.RoomRepository;

/**
 *
 * @author justi
 */
@Service
public class RoomServices {
     @Autowired
    private RoomRepository reposroom;

    public List<Room> getRooms() {
        return reposroom.getRooms();
    }

    public Optional<Room> getId(int id) {
        return reposroom.getId(id);
    }

    public Room saveRoom(Room objR) {
        if (objR.getId() == null) {
            return reposroom.saveRoom(objR);
        } else {
            Optional<Room> roomAux = reposroom.getId(objR.getId());

            if (roomAux.isEmpty()) {
                return reposroom.saveRoom(objR);
            } else {
                return objR;
            }
        }
    }
    
}
