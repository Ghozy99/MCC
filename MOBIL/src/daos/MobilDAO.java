/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IMobilDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.Mobil;

/**
 *
 * @author ghoza
 */
public class MobilDAO implements IMobilDAO {

    private Connection connection;

    public MobilDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Mobil> getAll() {
        List<Mobil> mobils = new LinkedList<>();
        String query = "SELECT * FROM MOBIL";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mobils.add(new Mobil(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobils;
    }

    @Override
    public Mobil getById(int car_id) {
        String query = "SELECT * FROM MOBIL WHERE CAR_ID =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, car_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Mobil(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public List<Mobil> search(String key) {
        List<Mobil> mobils = new ArrayList<Mobil>();
        String query = "SELECT * FROM MOBIL WHERE CAR_ID LIKE ? OR CAR_BRAND LIKE ? or CAR_ENGINE LIKE ? OR CAR_READY LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%".concat(key.concat("%")));
            preparedStatement.setString(2, "%".concat(key.concat("%")));
            preparedStatement.setString(3, "%".concat(key.concat("%")));
            preparedStatement.setString(4, "%".concat(key.concat("%")));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mobil m = new Mobil(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
                mobils.add(m);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return mobils;
    }

    @Override
    public Mobil insert(Mobil m) {
        String query = "INSERT INTO MOBIL(car_id, car_brand, car_engine, car_ready) values(SEQ_MOBIL.NEXTVAL, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, m.getBrand());
            preparedStatement.setInt(2, m.getEngine());
            preparedStatement.setString(3, m.getReady());
            preparedStatement.executeQuery();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Mobil update(Mobil m) {
        String query = "UPDATE MOBIL SET CAR_BRAND = ?, CAR_ENGINE = ?, CAR_READY = ? WHERE CAR_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, m.getBrand());
            preparedStatement.setInt(2, m.getEngine());
            preparedStatement.setString(3, m.getReady());
            preparedStatement.setInt(4, m.getId());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return m;
    }

    @Override
    public void delete(int car_id) {
        String query = "DELETE FROM MOBIL WHERE CAR_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, car_id);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println((affectedRows != 0)? "Berhasil Menghapus": 
                    "gagal menghapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
