package com.car_agency.car_agency.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.rmi.CORBA.Stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.car_agency.car_agency.entidades.auto;
import com.car_agency.car_agency.servicios.autoServices;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Controller
@RequestMapping("/")
public class autoController {
 
    @Autowired
    private autoServices autoServ;

    @GetMapping("/")
    public String paginaPrincipal(ModelMap model){

        List<auto> autos = autoServ.listarDatos();
        model.addAttribute("autos",autos);

        return "principal.html";
    }

    @GetMapping("lista")
    public String listarAutos(ModelMap model){

        List<auto> autos = autoServ.listarDatos();
        model.addAttribute("autos",autos);

        return "lista.html";
    }

    @PostMapping("lista/nuevo")
    public String guardarDatos(@RequestParam String name, String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image, List<MultipartFile> estilo1,List<MultipartFile> estilo2,List<MultipartFile> estilo3,MultipartFile portada) throws Exception{

       
        autoServ.guardarDatos(name,marca,precio,disenio,performance,exclusividad,image,estilo1,estilo2,estilo3,portada);
        return "redirect:../lista";

    }

    @PostMapping("lista/actualizar")
    public String actualizarDatos(String id,String name, String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image, List<MultipartFile> estilo1,List<MultipartFile> estilo2,List<MultipartFile> estilo3,MultipartFile portada) throws Exception{
        
        autoServ.modificarDatos(id, name,marca,precio,disenio,performance,exclusividad,image,estilo1,estilo2,estilo3,portada);
        return "redirect:../lista";
    }

    

/* 
    @PostMapping("lista/nuevo")
    public String guardarDatos(@RequestParam String name, String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image, MultipartFile estilo1,MultipartFile estilo2,MultipartFile estilo3,MultipartFile portada) throws Exception{

       
        autoServ.guardarDatos(name,marca,precio,disenio,performance,exclusividad,image,estilo1,estilo2,estilo3,portada);
        return "redirect:../lista";

    }

   @PostMapping("lista/actualizar")
    public String actualizarDatos(String id,String name, String marca,String precio,String disenio,String performance,String exclusividad, MultipartFile image, MultipartFile estilo1,MultipartFile estilo2,MultipartFile estilo3,MultipartFile portada) throws Exception{
        
        autoServ.modificarDatos(id, name,marca,precio,disenio,performance,exclusividad,image,estilo1,estilo2,estilo3,portada);
        return "redirect:../lista";
    }
*/   
    @PostMapping("lista/eliminar")
    public String eliminarDatos(String id){

        autoServ.eliminarDatos(id);
        return "redirect:../lista";
    }
    
    @GetMapping("auto/{id}")
    public ModelAndView autoDetalles(@PathVariable String id){
        
        auto car = autoServ.getOne(id);
        return new ModelAndView("auto").addObject("auto", car);

    }

    @GetMapping("estilo/{id}/{color}")
    public String autoColor(@PathVariable String id,@PathVariable String color) throws Exception{

        autoServ.modificarEstilo(id,color);      
        return "redirect: ../../../../auto/"+id+"#estilo";
    }


}
