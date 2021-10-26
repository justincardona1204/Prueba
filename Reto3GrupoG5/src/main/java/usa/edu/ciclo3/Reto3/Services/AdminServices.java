/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Admin;
import usa.edu.ciclo3.Reto3.Repository.AdminRepository;


/**
 *
 * @author justi
 */
@Repository
public class AdminServices {
    
     @Autowired
    private AdminRepository administrador;

    public List<Admin> getAdmins() {
        return administrador.getAdmins();
    }

    public Optional<Admin> getIdAdmin(int id) {
        return administrador.getIdAdmin(id);
    }

    public Admin saveAdmin(Admin objAd) {
        if (objAd.getId() == null) {
            return administrador.saveAdmin(objAd);
        } else {
            Optional<Admin> AdminAux = administrador.getIdAdmin(objAd.getId());

            if (AdminAux.isEmpty()) {
                return administrador.saveAdmin(objAd);
            } else {
                return objAd;
            }
        }
    }
    
    
}
