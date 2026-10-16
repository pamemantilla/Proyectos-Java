package ec.edu.ejercicios.abstraccion;

import java.util.Objects;

public class Pupitre {
    private final String codigo;
    private final String material;
    private final String color;
    private final boolean tieneCompartimento;
    private boolean ocupado;
    private String objetoGuardado;

    public Pupitre(String codigo, String material, String color, boolean tieneCompartimento) {
        this.codigo = Objects.requireNonNull(codigo).trim();
        this.material = Objects.requireNonNull(material).trim();
        this.color = Objects.requireNonNull(color).trim();
        this.tieneCompartimento = tieneCompartimento;
    }

    public void ocupar() {
        if (ocupado) {
            throw new IllegalStateException("El pupitre ya está ocupado");
        }
        ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }

    public void guardarObjeto(String objeto) {
        if (!tieneCompartimento) {
            throw new IllegalStateException("El pupitre no tiene compartimento");
        }
        objetoGuardado = Objects.requireNonNull(objeto).trim();
    }

    public String retirarObjeto() {
        String objeto = objetoGuardado;
        objetoGuardado = null;
        return objeto;
    }

    @Override
    public String toString() {
        return "Pupitre{" +
                "codigo='" + codigo + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", tieneCompartimento=" + tieneCompartimento +
                ", ocupado=" + ocupado +
                ", objetoGuardado='" + objetoGuardado + '\'' +
                '}';
    }
}
