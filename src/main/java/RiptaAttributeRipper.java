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

import DBConnection.DBConnections;
import DataClasses.tripUpdates;

public class RiptaAttributeRipper {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        //String path = args[0];
        //System.out.println(path);
        /*for (String str : args) {

            System.out.println(str);
            //String file = "/Users/scapista/tmp/vehicleUpdates/20161114/vehicleUpdates20161114_220257940";
        }   */
        String file = "/Users/scapista/tmp/tripUpdates/20161111/tripUpdates20161111_230314038";
        DBConnections conn = new DBConnections(file);
    }
}
