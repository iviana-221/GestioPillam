package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ViaGel extends Via {
    private String ancoratge;
    private List<Llarg> llargs;

    public ViaGel(LocalDateTime data, String estat, String grau, int idCreador, int idSector, String orientacio, String nom, String restriccions, String tipusRoc, String ancoratge) {
        super(data, estat, grau, idCreador, idSector, orientacio, nom, restriccions, tipusRoc);
        setAncoratge(ancoratge);
        this.llargs = new ArrayList<>();
    }

    public String getAncoratge() {
        return ancoratge;
    }

    public void setAncoratge(String ancoratge) {
        String regex = "^(friends|tascons|bagues|pitons|Tricams|BigBros)$";
        if (ancoratge == null || !ancoratge.matches(regex)) {
            throw new IllegalArgumentException("L'ancoratge de gel no és vàlid.");
        }
        this.ancoratge = ancoratge;
    }

    public List<Llarg> getLlargs() {
        return llargs;
    }

    public void afegirLlarg(Llarg llarg) {
        this.llargs.add(llarg);
    }
}