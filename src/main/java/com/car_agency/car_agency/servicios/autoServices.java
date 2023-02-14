package com.car_agency.car_agency.servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.car_agency.car_agency.entidades.auto;
import com.car_agency.car_agency.entidades.imagen;
import com.car_agency.car_agency.repositorios.autoRepository;

@Service
public class autoServices {
    
    @Autowired
    private autoRepository autoRepo;
    @Autowired
    private imagenServices imgServ;

    @Transactional
    public void guardarDatos(String name,String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image,List<MultipartFile> estilo1,List<MultipartFile> estilo2,List<MultipartFile> estilo3,MultipartFile portada) throws Exception{
        
        auto car = new auto();
        car.setName(name);
        car.setMarca(marca);
        car.setPrecio(precio);
        car.setDisenio(disenio);
        car.setPerformance(performance);
        car.setExclusividad(exclusividad);
        imagen Image = imgServ.guardar(image);
        car.setImg(Image);
        imagen Portada = imgServ.guardar(portada);
        car.setPortada(Portada);

        List<imagen> style1 = new ArrayList<imagen>();

                for (MultipartFile e1 : estilo1) {
                    style1.add(imgServ.guardar(e1));
                }
                car.setEstilo1(style1);
        
        List<imagen> style2 = new ArrayList<imagen>();

            for (MultipartFile e2 : estilo2) {
                    style2.add(imgServ.guardar(e2));
            }
            car.setEstilo2(style2);

        List<imagen> style3 = new ArrayList<imagen>();

            for (MultipartFile e3 : estilo3) {
                style3.add(imgServ.guardar(e3));
            }
            car.setEstilo3(style3);

        autoRepo.save(car);
        System.out.println("Guardado!!");
        
    }



/* 
    @Transactional
    public void guardarDatos(String name,String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image,MultipartFile estilo1,MultipartFile estilo2,MultipartFile estilo3,MultipartFile portada) throws Exception{
        
        auto car = new auto();
        car.setName(name);
        car.setMarca(marca);
        car.setPrecio(precio);
        car.setDisenio(disenio);
        car.setPerformance(performance);
        car.setExclusividad(exclusividad);
        imagen Image = imgServ.guardar(image);
        car.setImg(Image);
        imagen Portada = imgServ.guardar(portada);
        car.setPortada(Portada);
        imagen style1 = imgServ.guardar(estilo1);
        car.setEstilo1(style1);
        imagen style2 = imgServ.guardar(estilo2);
        car.setEstilo2(style2);
        imagen style3 = imgServ.guardar(estilo3);
        car.setEstilo3(style3);
        autoRepo.save(car);
        System.out.println("Guardado!!");
        
    }
*/
/*  @Transactional
    public void modificarDatos(String id ,String name,String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image,MultipartFile estilo1,MultipartFile estilo2,MultipartFile estilo3,MultipartFile portada) throws Exception{
        Optional <auto> respuesta = autoRepo.findById(id);
        System.out.println("Id:"+id);
        if (respuesta.isPresent()){

            auto car = respuesta.get();
            if (!name.isEmpty()){
                car.setName(name);
            }
            if(!image.isEmpty()){
                imagen Img = imgServ.guardar(image);
                car.setImg(Img);
            }
            if(!marca.isEmpty()){
                car.setMarca(marca);
            }
            if(!precio.isEmpty()){
                car.setPrecio(precio);
            }
            if(!disenio.isEmpty()){
                car.setDisenio(disenio);
            }
            if(!performance.isEmpty()){
                car.setPerformance(performance);
            }
            if(!exclusividad.isEmpty()){
                car.setExclusividad(exclusividad);
            }
            if(!estilo1.isEmpty()){
                imagen style1 = imgServ.guardar(estilo1);
                car.setEstilo1(style1);
            }
            if(!estilo2.isEmpty()){
                imagen style2 = imgServ.guardar(estilo2);
                car.setEstilo2(style2);
            }
            if(!estilo3.isEmpty()){
                imagen style3 = imgServ.guardar(estilo3);
                car.setEstilo3(style3);
            }
            autoRepo.save(car);
            System.out.println("Modificado!!");
        }
    }
*/ 

    @Transactional
    public void modificarDatos(String id ,String name,String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image,List<MultipartFile> estilo1,List<MultipartFile> estilo2,List<MultipartFile> estilo3,MultipartFile portada) throws Exception{
        Optional <auto> respuesta = autoRepo.findById(id);
        if (respuesta.isPresent()){

            auto car = respuesta.get();
            if (!name.isEmpty()){
                car.setName(name);
            }
            if(!image.isEmpty()){
                imagen Img = imgServ.guardar(image);
                car.setImg(Img);
            }
            if(!marca.isEmpty()){
                car.setMarca(marca);
            }
            if(!precio.isEmpty()){
                car.setPrecio(precio);
            }
            if(!disenio.isEmpty()){
                car.setDisenio(disenio);
            }
            if(!performance.isEmpty()){
                car.setPerformance(performance);
            }
            if(!exclusividad.isEmpty()){
                car.setExclusividad(exclusividad);
            }
            if(!estilo1.isEmpty()){

                List<imagen> style1 = new ArrayList<imagen>();

                for (MultipartFile e1 : estilo1) {
                    style1.add(imgServ.guardar(e1));
                }
                car.setEstilo1(style1);
                
            }
            if(!estilo2.isEmpty()){
                List<imagen> style2 = new ArrayList<imagen>();

                for (MultipartFile e2 : estilo2) {
                    style2.add(imgServ.guardar(e2));
                }
                car.setEstilo2(style2);
            }
            if(!estilo3.isEmpty()){
                List<imagen> style3 = new ArrayList<imagen>();

                for (MultipartFile e3 : estilo3) {
                    style3.add(imgServ.guardar(e3));
                }
                car.setEstilo3(style3);
            }
            autoRepo.save(car);
            System.out.println("Modificado!!");
        }
        
    }

    @Transactional
    public void modificarEstilo(String id,String color){

        Optional <auto> respuesta = autoRepo.findById(id);
        if (respuesta.isPresent()){

            auto car = respuesta.get();
            car.setColor(color);
            autoRepo.save(car);

        }


    }

    @Transactional
    public void eliminarDatos(String id){
        
        autoRepo.deleteById(id);
        System.out.println("Eliminado!!");
    }

    @Transactional
    public List<auto> listarDatos(){

        List<auto> autos = new ArrayList();
        autos = autoRepo.findAll();
        return autos;
    }

    public auto getOne(String id){
        return autoRepo.getOne(id);
    }

    public Optional<auto> findById(String id){

        return autoRepo.findById(id);
    }

    

}
