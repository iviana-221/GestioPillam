package Model;


public class Escalador {
    private int id;
    private String nom;
    private String alias;
    private int edat;
    private String nivellMaxim;
    private String Nacionalitat;

    public Escalador(String alias, int edat, String nivellMaxim, String nom,String Nacionalitat) {
        this.alias = alias;
        setEdat(edat);
        setNivellMaxim(nivellMaxim);
        this.nom = nom;
        this.Nacionalitat = Nacionalitat;
    }

    public String getNacionalitat() {
        return Nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        Nacionalitat = nacionalitat;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        if (edat >= 0 && edat <= 120) {
            this.edat = edat;
        } else {
            throw new IllegalArgumentException("L'edat ha de ser un valor entre 0 i 120.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivellMaxim() {
        return nivellMaxim;
    }
    public void setNivellMaxim(String nivellMaxim) {
        if (!nivellMaxim.matches("^([4-9][abc]?\\+?)$")) {
            throw new IllegalArgumentException("El nivell '" + nivellMaxim + "' no segueix el format oficial.");
        }
        this.nivellMaxim = nivellMaxim;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
