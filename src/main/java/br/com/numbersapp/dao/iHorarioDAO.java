package br.com.numbersapp.dao;
import br.com.numbersapp.model.Horario;
import java.util.List;

public interface iHorarioDAO {
    Horario save(Horario horario);
    Horario update(Horario horario);
    void deleteHorario(String dat, String hora);
    List<Horario> findAll();
}
