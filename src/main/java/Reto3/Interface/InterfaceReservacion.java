/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3.Interface;

import Reto3.Modelo.Reservacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author escritorio1
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
    
}
