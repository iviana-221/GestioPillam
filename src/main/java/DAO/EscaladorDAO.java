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
    String sql = "INSERT INTO Escaladors (nom, alias, edat, nivell_maxim, nacionalitat) VALUES (?, ?, ?, ?, ?)";
    try (Connection con = gestorConexio.getConexion();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, e.getNom());
        pstmt.setString(2, e.getAlias());
        pstmt.setInt(3, e.getEdat());
        pstmt.setString(4, e.getNivellMaxim());
        pstmt.setString(5, e.getNacionalitat());
        pstmt.executeUpdate();
        System.out.println("Escalador guardat");
    } catch (SQLException ex) { ex.printStackTrace(); }
}

    @Override
    public void modificar(Escalador e) {
        String sql = "UPDATE Escaladors SET nom = ?, edat = ?, nivell_maxim = ? WHERE id = ?";
        try (Connection conn = gestorConexio.getConexio();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getNom());
            ps.setInt(2, e.getEdat());
            ps.setString(3, e.getNivellMaxim());
            ps.setInt(4, e.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Escaladors WHERE id = ?";
        try (Connection conn = gestorConexio.getConexio();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Escalador LlistarUn(int id) {
        String sql = "SELECT * FROM Escaladors WHERE id = ?";
        try (Connection conn = gestorConexio.getConexio();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Escalador(
                        rs.getString("alias"), rs.getInt("edat"),
                        rs.getString("nivell_maxim"), rs.getString("nom"),
                        rs.getString("nacionalitat")
                        );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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


    public List<Escalador> llistarPerNivellMaxim(String nivell) {
        List<Escalador> llista = new ArrayList<>();
        // SQL con filtro WHERE
        String sql = "SELECT * FROM Escaladors WHERE nivell_maxim = ?";

        try (Connection conn = gestorConexio.getConexio();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nivell);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    llista.add(new Escalador(
                            rs.getString("alias"), rs.getInt("edat"),
                            rs.getString("nivell_maxim"), rs.getString("nom"),
                            rs.getString("nacionalitat")
                    ));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al filtrar escaladors per nivell: " + ex.getMessage());
        }
        return llista;
    }










}
