/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Category;
import usa.edu.ciclo3.Reto3.Repository.CategoryRepository;

/**
 *
 * @author justi
 */
@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository repositorio;

    public List<Category> getCategorys() {
        return repositorio.getCategorys();
    }

    public Optional<Category> getIdCat(int id) {
        return repositorio.getIdCat(id);
    }

    public Category saveCategory(Category objC) {
        if (objC.getId() == null) {
            return repositorio.saveCategory(objC);
        } else {
            Optional<Category> catAux = repositorio.getIdCat(objC.getId());

            if (catAux.isEmpty()) {
                return repositorio.saveCategory(objC);
            } else {
                return objC;
            }
        }
    }
}
    
            
