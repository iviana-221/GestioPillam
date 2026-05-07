package Model;

import java.time.LocalDate;

public class EscaladorViaNivell {
    private int idEscalador;
    private int idVia;
    private LocalDate dataAssolit;

    public EscaladorViaNivell(int idEscalador, int idVia, LocalDate dataAssolit) {
        this.idEscalador = idEscalador;
        this.idVia = idVia;
        this.dataAssolit = dataAssolit;
    }

    public int getIdEscalador() {
        return idEscalador;
    }

    public void setIdEscalador(int idEscalador) {
        this.idEscalador = idEscalador;
    }

    public int getIdVia() {
        return idVia;
    }

    public void setIdVia(int idVia) {
        this.idVia = idVia;
    }

    public LocalDate getDataAssolit() {
        return dataAssolit;
    }

    public void setDataAssolit(LocalDate dataAssolit) {
        this.dataAssolit = dataAssolit;
    }
}