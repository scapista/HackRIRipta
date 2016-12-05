package DataClasses;

import Common.HelperMethods;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by scapista on 12/3/16.
 * +
 * + Priority:
 * + 1. build failing
 * + 2. function not working
 * + 3. nice to have but would optimize
 * + 4. nice to have no benefit
 * + 5. future state
 */

public class tripUpdates {
    private String route_id = "-9999";
    private String trip_id = "-9999";
    private String vehicle_id = "-9999";
    private String timestamp = "-9999";;
    private String trip_start_dt = "-9999";
    private String trip_start_time = "-9999";
    private List<stopUpdates> arrStopUpdates;
    private int schedule_relationship= -9999;
    private String filename= "-9999";
    private int stopSize;

    public String getRoute_id() {
        return route_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTrip_start_dt() {
        return trip_start_dt;
    }

    public String getTrip_start_time() {
        return trip_start_time;
    }

    public List<stopUpdates> getArrStopUpdates() {
        return arrStopUpdates;
    }

    public int getSchedule_relationship() {
        return schedule_relationship;
    }

    public String getFilename() {
        return filename;
    }

    public int getStopSize() {
        return stopSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("tripupdatesString");
        System.out.println(arrStopUpdates.size());
        for(int i = 0; i < arrStopUpdates.size(); i++) {
            sb.append(route_id +
                    "|" + trip_id +
                    "|" + vehicle_id +
                    "|" + timestamp +
                    "|" + trip_start_dt +
                    "|" + trip_start_time +
                    "|" + filename);
            sb.append(arrStopUpdates.get(i).getStops());
        }
        System.out.println("tripupdatesString2");
        return sb.toString();
    }

    public void printStrings(){

        for(int i = 0 ; i < arrStopUpdates.size(); i++) {
            System.out.print(toString());
            System.out.print("---------");
            System.out.println(arrStopUpdates.get(i).getStops());
        }
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setTrip_start_dt(String trip_start_dt) {
        this.trip_start_dt = trip_start_dt;
    }

    public void setTrip_start_time(String trip_start_time) {
        this.trip_start_time = trip_start_time;
    }



    public void setSchedule_relationship(int schedule_relationship) {
        this.schedule_relationship = schedule_relationship;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setStopSize(int i){
        this.stopSize = i;
    }

    public void setStopUpdates (JSONArray arrStops){
        //System.out.println("here");
        for(int i = 0 ; i < arrStops.length()-1; i++){
                stopUpdates su = new stopUpdates(arrStops.getJSONObject(i), String.valueOf(i));
                System.out.print(su.getStops());
        }
        System.out.print("setStopUpdates");
        setStopSize(arrStops.length());
    }

}
