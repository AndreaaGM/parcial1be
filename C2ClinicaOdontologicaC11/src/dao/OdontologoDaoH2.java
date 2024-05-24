package dao;

import model.Odontologo;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO ) VALUES(?,?,?)";
    private static final List<Odontologo> odontologos= new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {


    logger.info("inicando la operacion de guardado");
    Connection connection=null;
        try{
        connection= BD.getConnection();
        PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        psInsert.setInt(1, odontologo.getMatricula());
        psInsert.setString(2, odontologo.getNombre());
        psInsert.setString(3, odontologo.getApellido());
        psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
        odontologos.add(odontologo);
        ResultSet rs= psInsert.getGeneratedKeys();
        while (rs.next()){
            odontologo.setId(rs.getInt(1));

        }
            //System.out.println("ID: " + rs.getInt(1) + "Nombre: " + rs.getNString(2) + "Apellido: " + rs.getNString(3));



    }catch (Exception e){
        logger.warn(e.getMessage());
    }
        return odontologo;
    }
    @Override
    public Odontologo buscarPorID(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        for (Odontologo odontologo: odontologos) {
            System.out.println("ID: " + odontologo.getId() + "\nNombre: " + odontologo.getNombre() + "\nApellido: " + odontologo.getApellido() + "\nMatricula: " + odontologo.getMatricula());
        }
        return null;
    }

}
