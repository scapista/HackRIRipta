package DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

import static com.sun.tools.doclint.Entity.ge;

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

public class stopUpdates {
    private int arr_delay = -9999;
    private int arr_time = -9999;
    private int arr_uncertainty = -9999;
    private int dep_delay = -9999;
    private int dep_time = -9999;
    private int dep_uncertainty= -9999;
    private int schedule_relationship = -9999;
    private String stop_sequence;


    stopUpdates(JSONObject arrStopUpdates, String seq){
        try {

            //System.out.println(arrStopUpdates.getJSONObject("arrival").toString());
            setArr_delay(arrStopUpdates.getJSONObject("arrival").getInt("delay"));
            //System.out.println(arrStopUpdates.getJSONObject("arrival").getInt("delay"));
            setArr_time(arrStopUpdates.getJSONObject("arrival").getInt("time"));
            setArr_uncertainty(arrStopUpdates.getJSONObject("arrival").getInt("uncertainty"));
        } catch (JSONException js){
            System.out.print(js.getMessage());
            System.out.println(arrStopUpdates.toString());
        }
        catch (Exception e ){
            e.printStackTrace();
            System.out.println(arrStopUpdates.toString());
        }

        try {
            setDep_delay(arrStopUpdates.getJSONObject("departure").getInt("delay"));
            setDep_time(arrStopUpdates.getJSONObject("departure").getInt("time"));
            setDep_uncertainty(arrStopUpdates.getJSONObject("departure").getInt("uncertainty"));
        }
        catch (JSONException js){
            System.out.print(js.getMessage());
            System.out.println(arrStopUpdates.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(arrStopUpdates.toString());
        }
        setStop_sequence(seq);
        try {
            setSchedule_relationship(arrStopUpdates.getInt("schedule_relationship"));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(arrStopUpdates.toString());
        }
    }

    public void setArr_delay(int arr_delay) {
        this.arr_delay = arr_delay;
    }

    public void setArr_time(int arr_time) {
        this.arr_time = arr_time;
    }

    public void setArr_uncertainty(int arr_uncertainty) {
        this.arr_uncertainty = arr_uncertainty;
    }

    public void setDep_delay(int  dep_delay) {
        this.dep_delay = dep_delay;
    }

    public void setDep_time(int dep_time) {
        this.dep_time = dep_time;
    }

    public void setDep_uncertainty(int dep_uncertainty) {
        this.dep_uncertainty = dep_uncertainty;
    }

    public void setSchedule_relationship(int schedule_relationship) {
        this.schedule_relationship = schedule_relationship;
    }

    public void setStop_sequence(String stop_sequence) {
        this.stop_sequence = stop_sequence;
    }

    public int getArr_delay() {
        return arr_delay;
    }

    public int getArr_time() {
        return arr_time;
    }

    public int getArr_uncertainty() {
        return arr_uncertainty;
    }

    public int getDep_delay() {
        return dep_delay;
    }

    public int getDep_time() {
        return dep_time;
    }

    public int getDep_uncertainty() {
        return dep_uncertainty;
    }

    public int getSchedule_relationship() {
        return schedule_relationship;
    }

    public String getStop_sequence() {
        return stop_sequence;
    }

    public String getStops() {
        //System.out.println("stops");
        StringBuilder sb = new StringBuilder();
        try {
            try {
                sb.append(getArr_delay());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getArr_time());

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getArr_uncertainty());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getDep_delay());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getDep_time());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getDep_uncertainty());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getSchedule_relationship());

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sb.append("|");
                sb.append(getStop_sequence());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            sb.append("\n");
        }
        return sb.toString();
    }
}
