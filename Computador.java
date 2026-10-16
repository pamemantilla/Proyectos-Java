package ec.edu.ejercicios.encapsulamiento;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Computador {
    private final String marca;
    private final String modelo;
    private final String procesador;
    private final int memoriaRamGb;
    private final int almacenamientoTotalGb;
    private final Set<String> programasInstalados;
    private int almacenamientoDisponibleGb;
    private boolean encendido;

    public Computador(
            String marca,
            String modelo,
            String procesador,
            int memoriaRamGb,
            int almacenamientoTotalGb
    ) {
        this.marca = Objects.requireNonNull(marca).trim();
        this.modelo = Objects.requireNonNull(modelo).trim();
        this.procesador = Objects.requireNonNull(procesador).trim();
        if (memoriaRamGb <= 0 || almacenamientoTotalGb <= 0) {
            throw new IllegalArgumentException("La memoria y el almacenamiento deben ser mayores que cero");
        }
        this.memoriaRamGb = memoriaRamGb;
        this.almacenamientoTotalGb = almacenamientoTotalGb;
        this.almacenamientoDisponibleGb = almacenamientoTotalGb;
        this.programasInstalados = new LinkedHashSet<>();
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public void instalarPrograma(String programa, int espacioGb) {
        verificarEncendido();
        String nombre = Objects.requireNonNull(programa).trim();
        if (espacioGb <= 0 || espacioGb > almacenamientoDisponibleGb) {
            throw new IllegalArgumentException("No hay espacio suficiente para instalar el programa");
        }
        if (programasInstalados.add(nombre)) {
            almacenamientoDisponibleGb -= espacioGb;
        }
    }

    public void abrirPrograma(String programa) {
        verificarEncendido();
        if (!programasInstalados.contains(programa)) {
            throw new IllegalArgumentException("El programa no está instalado");
        }
    }

    public Set<String> getProgramasInstalados() {
        return Set.copyOf(programasInstalados);
    }

    private void verificarEncendido() {
        if (!encendido) {
            throw new IllegalStateException("El computador está apagado");
        }
    }

    @Override
    public String toString() {
        return "Computador{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", procesador='" + procesador + '\'' +
                ", memoriaRamGb=" + memoriaRamGb +
                ", almacenamientoTotalGb=" + almacenamientoTotalGb +
                ", almacenamientoDisponibleGb=" + almacenamientoDisponibleGb +
                ", programasInstalados=" + programasInstalados +
                ", encendido=" + encendido +
                '}';
    }
}
