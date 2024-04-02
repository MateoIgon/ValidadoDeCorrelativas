package org.example;

import junit.framework.TestCase;

import java.util.List;
import java.util.ArrayList;

public class AlumnoTest extends TestCase {
    public void test() {
        ArrayList<Materia> sinCorrelativas = new ArrayList<>();

        Materia am = new Materia();
        am.setCorrelativas(sinCorrelativas);

        Materia syo = new Materia();
        syo.setCorrelativas(sinCorrelativas);

        Materia am2 = new Materia();
        ArrayList<Materia> correlativasam2 = new ArrayList<>();
        correlativasam2.add(am);
        am2.setCorrelativas(correlativasam2);

        Materia ads = new Materia();
        ArrayList<Materia> correlativasads = new ArrayList<>();
        correlativasads.add(syo);
        ads.setCorrelativas(correlativasads);

        Alumno mateo = new Alumno();
        ArrayList<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(am);
        mateo.setMateriasAprobadas(materiasAprobadas);

        ArrayList<Materia> materiasAInscribir = new ArrayList<>();
        materiasAInscribir.add(am2);
        materiasAInscribir.add(ads);
        mateo.setMateriasAInscribir(materiasAInscribir);

        Alumno tomas = new Alumno();
        ArrayList<Materia> materiasAprobadasTomas = new ArrayList<>();
        materiasAprobadasTomas.add(am);
        materiasAprobadasTomas.add(syo);
        tomas.setMateriasAprobadas(materiasAprobadasTomas);

        ArrayList<Materia> materiasAInscribirTomas = new ArrayList<>();
        materiasAInscribirTomas.add(am2);
        materiasAInscribirTomas.add(ads);
        tomas.setMateriasAInscribir(materiasAInscribirTomas);

        Inscripcion siu = new Inscripcion();
        assertFalse(siu.aprobada(mateo));
        assertTrue(siu.aprobada(tomas));
    }
}