package com.proyecto.proyectofaces.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TareaImp {

    private List<Tarea> tareas = new ArrayList<>();


    public List<Tarea> getTareas() {

        return tareas;
    }

    public Tarea addTarea(Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }

    public Tarea findTarea(int id) {

        return tareas.stream().filter(e -> e.getIdTarea() == id).findFirst().orElse(null);

    }

    public void removeTarea(int id) {
        tareas.removeIf(x -> x.getIdTarea() == id);
    }

    public Tarea updateTarea(Tarea tarea) {

        tareas = tareas.stream().map(e -> (e.getIdTarea() == tarea.getIdTarea()) ? tarea : e).collect(Collectors.toList());
        return tarea;

    }
}
