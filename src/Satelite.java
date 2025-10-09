import java.util.*;
/**********
 * 
 * Class' name: Satellite
 * Author's name: Marcos
 * Creation date: 27/9/2025
 * Class version: First version.
 * Class description: This class represents a satellite with different ttributes.
 * 
 * 
 ***********/
class Satellite implements DefineTipeT{
    private String object_name; //Name or identification number of the satellite.
    private String object_id; //Year of release, release number in that year and a letter to indicate the different parts.
    private String epoch; //Time that the coordinates of the satellite are measured.
    private double mean_motion; //Number of orbits that satellite completes around the Earth.
    private double eccentricity; //How elliptical the satellite's orbit is?
    private double inclination; //The angle between the orbital plane and the Earth's equator.
    private double ra_of_asc_node;
    private double arg_of_pericenter;
    private double mean_anomaly;
    private int ephemeris_type;
    private String classification_type;
    private int norad_cat_id;
    private int element_set_no;
    private int rev_at_epoch;
    private String bstar;
    private String mean_motion_dot;
    private int mean_motion_ddot;
    private String separator; //This is the character that separates the different attributes of a satellite.
    /********
     * 
     * Method's name: Satellite.
     * Name of the original author: Marcos
     * Description on the method: It is the constructor method, it creates the object Satellite with a separator. This object will be prepared for receiving the data later.
     * Calling arguments: There is a separator that will be used for dividing the information of the satellite in its different arguments.
     * Return value: there is not a return value.
     * Required files: You do not need files for using this method.
     * 
     */
    public Satellite(String separator){
        this.separator=separator;
    }
    /********
     * 
     * Method's name: ReadData
     * Name of the original author: Marcos
     * Description on the method: This method gives the introduced data to the satellite.
     * Calling arguments: There is a string with the information of a satellite with its attributes separated by a separator.
     * Return value: there is not a return value.
     * Required files: You do not need files for using this method.
     * 
     */
    public void readData(String line){
        String[]a = line.split(separator);
        object_name = a[0];
        object_id = a[1];
        epoch = a[2];
        mean_motion = String.valueOf(a[3]);
        eccentricity = String.valueOf(a[4]);
        inclination = String.valueOf(a[5]);
        ra_of_asc_node = String.valueOf(a[6]);
        arg_of_pericenter = String.valueOf(a[7]);
        mean_anomaly = String.valueOf(a[8]);
        ephemeris_type = String.valueOf(a[9]);
        classification_type = a[10];
        norad_cat_id = String.valueOf(a[11]);
        element_set_no = String.valueOf(a[12]);
        rev_at_epoch = String.valueOf(a[13]);
        bstar = a[14];
        mean_motion_dot = a[15];
        mean_motion_ddot = String.valueOf(a[16]);
    }
    /********
     * 
     * Method's name: getObject_nameFast
     * Name of the original author: Marcos
     * Description on the method: The function gives the name of the satellite if it completes more than 10 loops in its orbit in a day.
     * Calling arguments: There is no arguments.
     * Return value: The function can return the name of a satellite.
     * Required files: You do not need a file for this function.
     * 
     *********/
    public String getObject_nameFast(){
        String a;
        if(mean_motion>10){
            a=object_name+"\n";
        }else{
            a="";
        }
        return a;
    }
    /********
     * 
     * Method's name: toString
     * Name of the original author: Marcos
     * Description on the method: This method show the information of a satellite.
     * Calling arguments: There is no arguments.
     * Return value: The function returns the information of a satellite.
     * Required files: You do not need a file for this function.
     * 
     *********/
    public String toString(){
        return "Name: "+object_name+"\tID: "+object_id+"\tEpoch: "+epoch+"\tMean motion: "+mean_motion+"\tEccentricity: "+eccentricity+
        "\nInclination: "+inclination+"\tRa of asc node: "+ra_of_asc_node+"\tArg of pericenter: "+arg_of_pericenter+"\tMean anomaly: "+mean_anomaly+
        "\nEphemeris type: "+ephemeris_type+"\tClassification type: "+classification_type+"\tNorad cat ID: "+norad_cat_id+"\tElement set no: "+element_set_no+
        "\nRev at epoch: "+rev_at_epoch+"\tBstar: "+bstar+"\tMean motion dot: "+mean_motion_dot+"\tMean motion ddot: "+mean_motion_ddot;
    }
}
