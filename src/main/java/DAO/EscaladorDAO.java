package DAO;

import Conexio.Conexio;
import Model.Escalador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EscaladorDAO implements GenericDAO<Escalador> {
    private final Conexio gestorConexio = new Conexio();

@Override
    public void registrar(Escalador e){

}

    @Override
    public void modificar(Escalador e){

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Escalador buscarPerId(int id) {
        return null;
    }

    @Override
    public List<Escalador> llistarTots() {
        List<Escalador> lista = new ArrayList<>();
        String sql = "SELECT * FROM Escaladors";
        try (Connection con = gestorConexio.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Escalador e = new Escalador(
                        rs.getString("alias"), rs.getInt("edat"),
                        rs.getString("nivell_maxim"), rs.getString("nom"),
                        rs.getString("nacionalitat")
                );
                e.setId(rs.getInt("id"));
                lista.add(e);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }










}
