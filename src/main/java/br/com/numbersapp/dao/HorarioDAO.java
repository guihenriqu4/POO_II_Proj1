package br.com.numbersapp.dao;

import br.com.numbersapp.infra.BancoDeDados;
import br.com.numbersapp.model.Horario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorarioDAO implements iHorarioDAO{

    @Override
    public Horario save(Horario horario) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "INSERT INTO horario (dat, hora) values (?, ?)";
            assert connection != null;
            PreparedStatement psHorario = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psHorario.setDate(1, horario.getDat());
            psHorario.setTime(2, horario.getHora());
            psHorario.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return horario;
    }

    @Override
    public Horario update(Horario horario) {
        try(Connection connection = BancoDeDados.getConnection()){
            String sql = "UPTDATE horario SET dat = ?, hora = ? WHERE dat = ? AND hora = ?";
            assert connection != null;
            PreparedStatement psHorario = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psHorario.setDate(1, horario.getDat());
            psHorario.setTime(2, horario.getHora());
            psHorario.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return horario;
    }

    @Override
    public void deleteHorario(String dat, String hora) {
        try(Connection connection = BancoDeDados.getConnection()) {
            String sql = "DELETE FROM horario WHERE dat = ? AND hora = ?";
            assert connection != null;
            PreparedStatement psHorario = connection.prepareStatement(sql);
            psHorario.setString(1, dat);
            psHorario.setString(2, hora);
            psHorario.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Horario> findAll() {
        List<Horario> horarios = new ArrayList<>();
        String sql = "SELECT * FROM horario";
        try (Connection connection = BancoDeDados.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rsHorario = preparedStatement.executeQuery();
            while (rsHorario.next()) {
                Horario horario = new Horario();
                horario.setDat(rsHorario.getString("dat"));
                horario.setHora(rsHorario.getString("hora"));
                horarios.add(horario);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return horarios;
    }
}
