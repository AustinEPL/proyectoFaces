package com.proyecto.proyectofaces.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class Tarea {





private int idTarea;
    private String nombre;
    private Date fecha;
    private boolean editMode;
}
