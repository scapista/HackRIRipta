package DBConnection;

import DataClasses.vehicleUpdates;
import de.bytefish.pgbulkinsert.PgBulkInsert;

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

public class vehicleBulkInserter extends PgBulkInsert<vehicleUpdates> {
   vehicleBulkInserter() {
       super("scapista", "stg_vehicle_updates");
/*
        mapInteger("vehicle_id", vehicleUpdates::getVehicle_id);
        mapInteger("trip_id", vehicleUpdates::getTrip_id);
        mapInteger("route_id", vehicleUpdates::getRoute_id);
        mapString("trip_start_dt", vehicleUpdates::getTrip_start_dt);
        mapString("trip_start_time", vehicleUpdates::getTrip_start_time);
        mapInteger("current_status", vehicleUpdates::getCurrent_status);
        mapDouble("bearing", vehicleUpdates::getBearing);
        mapDouble("latitude", vehicleUpdates::getLatitude);
        mapDouble("longitude", vehicleUpdates::getLongitude);
        mapDouble("speed", vehicleUpdates::getSpeed);
        mapInteger("stop_id", vehicleUpdates::getStop_id);
        mapInteger("timestamp", vehicleUpdates::getTimestamp);
        mapString("filename", vehicleUpdates::getFilename);
        */
    }
}
