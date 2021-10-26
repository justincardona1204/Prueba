/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Client;
import usa.edu.ciclo3.Reto3.Repository.ClientRepository;


/**
 *
 * @author justi
 */
@Service
public class ClientServices {
     @Autowired
    private ClientRepository cliente;

    public List<Client> getClients() {
        return cliente.getClients();
    }

    public Optional<Client> getIdClient(int id) {
        return cliente.getIdClient(id);
    }

    public Client saveClient(Client objCli) {
        if (objCli.getIdClient() == null) {
            return cliente.saveClient(objCli);
        } else {
            Optional<Client> clientAux = cliente.getIdClient(objCli.getIdClient());

            if (clientAux.isEmpty()) {
                return cliente.saveClient(objCli);
            } else {
                return objCli;
            }
        }
    }
    
    
}
