package com.lmorocho.paginasamarillas.Repositorio;

import com.lmorocho.paginasamarillas.Modelo.Empresa;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmpresa {

    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Empresa> xCategorias;

    static {
        empresas.add(new Empresa(1,"Limon & Brasas","Jiron PEZET Y MONEL 1799 - Lince, Lima",988663466,"hl4_lean14@hotmail.com","restaurantes","Limón y Brasas viene participando en grandes eventos gastronómicos tanto en el Perú como en el extranjero","limonbrasas"));
        empresas.add(new Empresa(2,"El Rancho Grande","Av. Trapiche Mz.C Lt.39 Comas, Lima",994033037,"hl4_lean14@hotmail.com","restaurantes","ervicio de calidad en almuerzos campestres para familia y empresas. Organización integral para eventos sociales.","ranchogrande"));
        empresas.add(new Empresa(3,"Chifa Kam Men","Av. República De Panamá 6271 - Miraflores, Lima",988663466,"hl4_lean14@hotmail.com","restaurantes","Chinese food. La tradición del buen gusto oriental.","kammen"));
        empresas.add(new Empresa(4,"Gran Parrillada Timbó","Av. Bolivar 944 - Pueblo Libre, Lima",988663466,"hl4_lean14@hotmail.com","restaurantes","Carnes a la parrilla, comida nacional e internacional, pollos al fogón, a la leña.","timbo"));
        empresas.add(new Empresa(5,"Chicharrones Don Lucho","Av. General Vivanco 1050 - Surco, Lima",988663466,"hl4_lean14@hotmail.com","restaurantes","Exquisitos sándwiches de chicharrón y pachamancas sin salir de Lima.","donlucho"));
        empresas.add(new Empresa(6,"José Antonio","Jiron Bernardo Monteagudo 200  Orrantia del Mar - Magdalena del Mar, Lima",988663466,"hl4_lean14@hotmail.com","restaurantes","¡El restaurante criollo de Lima!","joseantonio"));
        empresas.add(new Empresa(7,"Real Chicken","Jiron Víctor Andrés Belaunde 572  Urb. El Bosque - trujillo, La Libertad",44224970,"hl4_lean14@hotmail.com","restaurantes","Especialistas en pollos a la brasa. Servicio delivery.","realchiken"));
        empresas.add(new Empresa(8,"Gourmet Chicken","Av. Guillermo Billinghurst 527 - San Juan de Miraflores, Lima",933833393,"hl4_lean14@hotmail.com","restaurantes","Las mejores promociones en brasas, carnes, parrillas y criollo.","gourmetchiken"));
        empresas.add(new Empresa(9,"Pizzerías Presto","Calle Jerusalén 524  Cercado - Arequipa, Arequipa",54381111,"hl4_lean14@hotmail.com","restaurantes","Viva la pizza.","presto"));
        empresas.add(new Empresa(10,"Restaurant Cordano","Jiron Ancash 202 - Lima, Lima",4260072,"hl4_lean14@hotmail.com","restaurantes","Desde 1905, 111 años cumplidos. El restaurant más antiguo de Lima le ofrece variados platos criollos","cordano"));
    }

    public static List<Empresa> getEmpresas(){
        return empresas;
    }

    public static Empresa getEmpresaById(Integer id){
        for (Empresa empresa: empresas){
            if (empresa.getId().equals(id)){
                return empresa;
            }
        }
        return null;
    }

    public static List<Empresa> filtrarEmpresas(String categoria) {
        xCategorias = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if(empresa.getCategoria().equalsIgnoreCase(categoria)) {
                xCategorias.add(empresa);
            }
        }
        return xCategorias;
    }

}
