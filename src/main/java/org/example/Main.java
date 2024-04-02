package org.example;
import java.util.List;
import java.util.ArrayList;
class Alumno{
    private ArrayList<Materia> materiasAprobadas;
    private ArrayList<Materia> materiasAInscribir;


    public Alumno() {
    }

    public ArrayList<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public ArrayList<Materia> getMateriasAInscribir() {
        return materiasAInscribir;
    }

    public void setMateriasAInscribir(ArrayList<Materia> materiasAInscribir) {
        this.materiasAInscribir = materiasAInscribir;
    }
}

class Materia{
    private ArrayList<Materia> correlativas;

    public Materia() {
        this.correlativas = new ArrayList<>();
    }

    public boolean tieneCorrelativas(){
        return correlativas.isEmpty();
    }
    public Materia(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public ArrayList<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}

class Inscripcion{
    public boolean aprobada(Alumno alumnoSolicitante){
        ArrayList<Materia> materiasAprobadasAlumno = alumnoSolicitante.getMateriasAprobadas();
        ArrayList<Materia> materiasSolicitadas = alumnoSolicitante.getMateriasAInscribir();
        for(Materia materia: materiasSolicitadas){
            if(!materia.tieneCorrelativas() && !materiasAprobadasAlumno.containsAll(materia.getCorrelativas())){
                return false;
            }
        }
        return true;
    }
}
