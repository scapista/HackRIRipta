package DataClasses; /**
 * Created by scapista on 12/2/16.
 * +
 * + Priority:
 * + 1. build failing
 * + 2. function not working
 * + 3. nice to have but would optimize
 * + 4. nice to have no benefit
 * + 5. future state
 */



public class vehicleUpdates {
    private int vehicle_id = -9999;
    private int trip_id = -9999;
    private int route_id = -9999;
    private String trip_start_dt;
    private String trip_start_time ;
    private int current_status;
    private Double bearing;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private int stop_id;
    private int timestamp;
    private String filename;

    public vehicleUpdates(String file){
        setFilename(file);
    }

    //Start of getters
    public int getVehicle_id() {return vehicle_id; }
    public int getTrip_id() {return trip_id;}
    public int getRoute_id() {return route_id;}
    public String getTrip_start_dt() {return trip_start_dt;}
    public String getTrip_start_time() {return trip_start_time;}
    public int getCurrent_status() {return current_status;}
    public Double getBearing() {return bearing;}
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude;}
    public Double getSpeed() {return speed;}
    public int getStop_id() {return stop_id;}
    public int getTimestamp() {return timestamp;}
    public String getFilename() {return filename; }
    //end of getters

    //start of setters
    public void setVehicle_id(int vehicle_id) {this.vehicle_id = vehicle_id;  }
    public void setTrip_id(int trip_id) {this.trip_id = trip_id;}
    public void setRoute_id(int route_id) { this.route_id = route_id; }
    public void setTrip_start_dt(String trip_start_dt) {this.trip_start_dt = trip_start_dt;}
    public void setTrip_start_time(String trip_start_time) {this.trip_start_time = trip_start_time; }
    public void setCurrent_status(int current_status) {this.current_status = current_status;}
    public void setBearing(Double bearing) {this.bearing = bearing;}
    public void setLatitude(Double latitude) {this.latitude = latitude;}
    public void setLongitude(Double longitude) {this.longitude = longitude;}
    public void setSpeed(Double speed) {this.speed = speed; }
    public void setStop_id(int stop_id) { this.stop_id = stop_id; }
    public void setTimestamp(int timestamp){this.timestamp = timestamp;}
    public void setFilename(String filename) {this.filename = filename;}
    //end of setters

    @Override
    public String toString() {
        return
                vehicle_id +
                "|" + trip_id +
                "|" + route_id +
                "|" + trip_start_dt +
                "|" + trip_start_time +
                "|" + current_status +
                "|" + bearing +
                "|" + latitude +
                "|" + longitude +
                "|" + speed +
                "|" + stop_id +
                "|" + timestamp +
                "|" + filename +
                "\n";
    }


}
