package org.example;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class AlumnoTest extends TestCase {
    public void test() {
        Set<Materia> sinCorrelativas = new HashSet<>();

        Materia am = new Materia();
        am.setCorrelativas(sinCorrelativas);

        Materia syo = new Materia();
        syo.setCorrelativas(sinCorrelativas);

        Materia am2 = new Materia();
        HashSet<Materia> correlativasam2 = new HashSet<>();
        correlativasam2.add(am);
        am2.setCorrelativas(correlativasam2);

        Materia ads = new Materia();
        HashSet<Materia> correlativasads = new HashSet<>();
        correlativasads.add(syo);
        ads.setCorrelativas(correlativasads);

        Materia dds = new Materia();
        HashSet<Materia> correlativasdds = new HashSet<>();
        correlativasdds.add(ads);
        dds.setCorrelativas(correlativasdds);

        Alumno mateo = new Alumno();
        HashSet<Materia> materiasAprobadas = new HashSet<>();
        materiasAprobadas.add(am);
        mateo.setMateriasAprobadas(materiasAprobadas);

        HashSet<Materia> materiasAInscribir = new HashSet<>();
        materiasAInscribir.add(am2);
        materiasAInscribir.add(syo);
        mateo.setMateriasAInscribir(materiasAInscribir);

        Alumno tomas = new Alumno();
        HashSet<Materia> materiasAprobadasTomas = new HashSet<>();
        materiasAprobadasTomas.add(am);
        materiasAprobadasTomas.add(syo);
        materiasAprobadasTomas.add(ads);
        tomas.setMateriasAprobadas(materiasAprobadasTomas);

        HashSet<Materia> materiasAInscribirTomas = new HashSet<>();
        materiasAInscribirTomas.add(am2);
        materiasAInscribirTomas.add(dds);
        tomas.setMateriasAInscribir(materiasAInscribirTomas);

        Alumno lucas = new Alumno();
        HashSet<Materia> materiasAprobadasLucas = new HashSet<>();
        materiasAprobadasLucas.add(am);
        lucas.setMateriasAprobadas(materiasAprobadasLucas);

        HashSet<Materia> materiasAInscribirLucas = new HashSet<>();
        materiasAInscribirLucas.add(am2);
        materiasAInscribirLucas.add(ads);
        lucas.setMateriasAInscribir(materiasAInscribirLucas);



//        Inscripcion siu = new Inscripcion();
        assertTrue(mateo.inscribirse());
        assertFalse(lucas.inscribirse());
        assertTrue(tomas.inscribirse());
    }
}