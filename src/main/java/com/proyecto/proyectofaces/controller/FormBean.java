package com.proyecto.proyectofaces.controller;

import com.proyecto.proyectofaces.modelo.Tarea;
import com.proyecto.proyectofaces.modelo.TareaImp;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
@Getter
@Setter
public class FormBean implements Serializable {

    private Tarea t;
    private TareaImp tareaImp;
    private int id = 0;
    private String nombre;
    private Date fechaMinima;
    private Date fecha;

    @PostConstruct
    public void init() {
        tareaImp = new TareaImp();
        fechaMinima = new Date();
    }

    public void agregar() {
        if (nombre != null && !nombre.isEmpty()) {
            id++;
            t = new Tarea(id, nombre, fecha, false);
            tareaImp.addTarea(t);

            // Limpiar los campos
            nombre = null;
            fecha = null;
        }
    }

    public void eliminar(int id) {
        if (tareaImp.findTarea(id) != null) {
            tareaImp.removeTarea(id);
        } else {
            System.out.println("No existe la tarea");
        }
    }

    public void actualizar(Tarea t) {
        t.setEditMode(!t.isEditMode());
        // Actualizar la tarea en el repositorio si se está saliendo del modo edición
        if (!t.isEditMode()) {
            tareaImp.updateTarea(t);
        }
    }

    public List<Tarea> getTareas() {
        return tareaImp.getTareas();
    }

    public String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            return sdf.format(date);
        }
        return "";
    }
}
