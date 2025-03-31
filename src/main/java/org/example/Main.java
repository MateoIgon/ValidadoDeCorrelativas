package org.example;
import java.util.HashSet;
import java.util.Set;

class Alumno {
    private Set<Materia> materiasAprobadas;
    private Set<Materia> materiasAInscribir;

    public Alumno() {
        this.materiasAprobadas = new HashSet<>();
        this.materiasAInscribir = new HashSet<>();
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(Set<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Set<Materia> getMateriasAInscribir() {
        return materiasAInscribir;
    }

    public void setMateriasAInscribir(Set<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }

    public boolean inscribirse() {
        Inscripcion inscripcion = new Inscripcion();
        boolean resultado = inscripcion.aprobada(this);
        return resultado;
    }
}

class Materia {
    private Set<Materia> correlativas;

    public Materia() {
        this.correlativas = new HashSet<>();
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(Set<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}

class Inscripcion {
    public boolean aprobada(Alumno alumnoSolicitante) {
        Set<Materia> materiasAprobadas = alumnoSolicitante.getMateriasAprobadas();
        Set<Materia> materiasSolicitadas = alumnoSolicitante.getMateriasAInscribir();
        Set<Materia> correlativasNecesarias = new HashSet<>();
        Set<Materia> procesadas = new HashSet<>();

        for (Materia materia : materiasSolicitadas) {
            agregarCorrelativas(materia, correlativasNecesarias, procesadas);
        }

        return materiasAprobadas.containsAll(correlativasNecesarias);
    }

    private void agregarCorrelativas(Materia materia, Set<Materia> correlativasNecesarias, Set<Materia> procesadas) {
        if (procesadas.contains(materia)) return;

        procesadas.add(materia);
        correlativasNecesarias.addAll(materia.getCorrelativas());

        for (Materia correlativa : materia.getCorrelativas()) {
            agregarCorrelativas(correlativa, correlativasNecesarias, procesadas);
        }
    }
}
