/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Repositorio;

import Reto3.Interface.InterfacePalco;
import Reto3.Modelo.Palco;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author escritorio1
 */
@Repository
public class PalcoRepositorio {
    @Autowired
    private InterfacePalco crud;
    

    public List<Palco> getAll(){
        return (List<Palco>) crud.findAll();       
    }
    
    public Optional <Palco> getPalco(int id){
        return crud.findById(id);
    }
    
    public Palco save(Palco palco){
        return crud.save(palco);
    }
     public void delete(Palco palco){
        crud.delete(palco);
    }
}
