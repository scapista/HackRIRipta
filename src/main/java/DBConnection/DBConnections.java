package DBConnection;

import Common.HelperMethods;
import DataClasses.vehicleUpdates;
import DataClasses.tripUpdates;
import de.bytefish.pgbulkinsert.util.PostgreSqlUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 * Created by scapista on 12/2/16.
 * +
 * + Priority:
 * + 1. build failing
 * + 2. function not working
 * + 3. nice to have but would optimize
 * + 4. nice to have no benefit
 * + 5. future state
 */

public class DBConnections {
    List<vehicleUpdates> vuBulkList = new ArrayList<vehicleUpdates>();
    List<tripUpdates> vTripList = new ArrayList<tripUpdates>();

    public DBConnections(String file){
        //vehicleUpdatesJSONParse(file);
        //vehicleinsert();
        tripUpdatesJSONParse(file);
    }

    private void vehicleUpdatesJSONParse(String file){
        try{
            JSONObject jsonObject = new JSONObject(HelperMethods.getJsonFromFile(file));
            JSONArray arr_results = jsonObject.getJSONArray("entity");
            for(int i = 0; i < arr_results.length(); i++){
                vehicleUpdates vu = new vehicleUpdates(file);
                JSONObject vehicles = arr_results.getJSONObject(i).getJSONObject("vehicle");

                vu.setVehicle_id(vehicles.getJSONObject("vehicle").getInt("id"));
                vu.setTrip_id(vehicles.getJSONObject("trip").getInt("trip_id"));
                vu.setRoute_id(vehicles.getJSONObject("trip").getInt("route_id"));
                vu.setTrip_start_dt(vehicles.getJSONObject("trip").getString("start_date"));
                vu.setTrip_start_time(vehicles.getJSONObject("trip").getString("start_time"));
                vu.setCurrent_status(vehicles.getInt("current_status"));
                vu.setBearing(vehicles.getJSONObject("position").getDouble("bearing"));
                vu.setLatitude(vehicles.getJSONObject("position").getDouble("latitude"));
                vu.setLongitude(vehicles.getJSONObject("position").getDouble("longitude"));
                vu.setSpeed(vehicles.getJSONObject("position").getDouble("speed"));
                vu.setStop_id(vehicles.getInt("stop_id"));
                vu.setTimestamp(vehicles.getInt("timestamp"));

                //System.out.println(vu.toString());

                HelperMethods.outputfile(vu.toString());
                vuBulkList.add(vu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void tripUpdatesJSONParse(String file) {
        try {
            JSONObject jsonObject = new JSONObject(HelperMethods.getJsonFromFile(file));
            JSONArray arr_results = jsonObject.getJSONArray("entity");
            for (int i = 0; i < arr_results.length(); i++) {
                tripUpdates tu = new tripUpdates();
                try {
                    tu.setRoute_id(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getString("route_id"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setSchedule_relationship(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getInt("schedule_relationship"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setTrip_start_dt(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getString("start_date"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setTrip_id(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getString("trip_id"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setVehicle_id(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("vehicle").getString("id"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setStopUpdates(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONArray("stop_time_update"));
                }catch (Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {tu.setTimestamp(arr_results.getJSONObject(i).getJSONObject("trip_update").optString("timestamp"));
                }catch(Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update").toString());
                    e.printStackTrace();
                }
                try {
                    tu.setTrip_start_dt(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getString("start_date"));
                }catch(Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }
                try {
                    tu.setTrip_start_time(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip").getString("start_time"));
                }catch(Exception e){
                    System.out.print(arr_results.getJSONObject(i).getJSONObject("trip_update")
                            .getJSONObject("trip"));
                    e.printStackTrace();
                }

                try{
                    tu.setFilename(file);
                } catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println("dbconn");

                try{
                    HelperMethods.outputfile(tu.toString());
                } catch (Exception e){
                    e.printStackTrace();
                }

                vTripList.add(tu);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void vehicleinsert(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://ripta.czcxkoytf0wq.us-west-2.rds.amazonaws.com:5432/revRipta",
                            "scapista", "ripta2016");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        vehicleBulkInserter bulkInsert = new vehicleBulkInserter();
        try {
            System.out.println("output");
            bulkInsert.saveAll(PostgreSqlUtils.getPGConnection(c), vuBulkList.stream());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
