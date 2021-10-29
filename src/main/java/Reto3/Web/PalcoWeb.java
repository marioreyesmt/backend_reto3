/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Web;

import Reto3.Modelo.Palco;
import Reto3.Servicios.ServiciosPalco;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author escritorio1
 */
@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PalcoWeb {
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo reto 3";
    }

    @Autowired
    private ServiciosPalco servicio;
    @GetMapping("all")
    public List <Palco> getPalco(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Palco> getOrthesis(@PathVariable("id") int idPalco) {
        return servicio.getPalco(idPalco);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Palco save(@RequestBody Palco palco) {
        return servicio.save(palco);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Palco update(@RequestBody Palco palco) {
        return servicio.update(palco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int palcoId) {
        return servicio.deletePalco(palcoId);
    }
}
