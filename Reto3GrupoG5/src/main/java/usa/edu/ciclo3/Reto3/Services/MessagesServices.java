/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Messages;
import usa.edu.ciclo3.Reto3.Repository.MessagesRepository;

/**
 *
 * @author justi
 */
@Service
public class MessagesServices {
    
     @Autowired
    private MessagesRepository mensajes;

    public List<Messages> getMessages() {
        return mensajes.getMessages();
    }

    public Optional<Messages> getIdMessage(int id) {
        return mensajes.getIdMessage(id);
    }

    public Messages saveMessages(Messages objMes) {
        if (objMes.getIdMessage() == null) {
            return mensajes.saveMessages(objMes);
        } else {
            Optional<Messages> messageAux = mensajes.getIdMessage(objMes.getIdMessage());

            if (messageAux.isEmpty()) {
                return mensajes.saveMessages(objMes);
            } else {
                return objMes;
            }
        }
    }
    
    
}
