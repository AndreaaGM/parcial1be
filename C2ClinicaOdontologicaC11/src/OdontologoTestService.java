import dao.BD;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

public class OdontologoTestService {
    @Test
    public void mostrarOdontologos(){
        BD.crearTablas();
        OdontologoService odontologoService= new OdontologoService();
        odontologoService.buscarTodos();
    }
}
