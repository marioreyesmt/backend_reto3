/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Servicios;

import Reto3.Modelo.Palco;
import Reto3.Repositorio.PalcoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author escritorio1
 */
@Service
public class ServiciosPalco {
    @Autowired
    private PalcoRepositorio metodosCrud;
    
    public List<Palco> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Palco> getPalco(int idPalco){
        return metodosCrud.getPalco(idPalco);
    }
    
    public Palco save(Palco palco){
        if(palco.getId()==null){
            return metodosCrud.save(palco);
        }else{
            Optional<Palco> evt=metodosCrud.getPalco(palco.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(palco);
            }else{
                return palco;
            }
        }
    }
    public Palco update(Palco palco){
        if(palco.getId()!=null){
            Optional<Palco> e=metodosCrud.getPalco(palco.getId());
            if(!e.isEmpty()){
                if(palco.getName()!=null){
                    e.get().setName(palco.getName());
                }
                if(palco.getLocation()!=null){
                    e.get().setLocation(palco.getLocation());
                }
                if(palco.getCapacity()!=null){
                    e.get().setCapacity(palco.getCapacity());
                }
                if(palco.getDescription()!=null){
                    e.get().setDescription(palco.getDescription());
                }
                if(palco.getCategory()!=null){
                    e.get().setCategory(palco.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return palco;
            }
        }else{
            return palco;
        }
    }

    public boolean deletePalco(int palcoId) {
        Boolean aBoolean = getPalco(palcoId).map(palco -> {
            metodosCrud.delete(palco);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
