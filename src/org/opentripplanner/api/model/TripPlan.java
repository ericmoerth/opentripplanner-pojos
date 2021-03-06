/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.api.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.opentripplanner.util.DateConstants;

/**
 * A TripPlan is a set of ways to get from point A to point B at time T.
 */
public class TripPlan {
	
	private static final String TAG = "OTP";
	
    /** 
     * The time and date of travel 
     */
	//TODO - fix datedeserializer
//	
//    public String date = null;
	public String date;
	public Date formatted_date;
    
    public void setDate(String d){
    	date = d;
    }
    
    public String getDate(){
//    	Log.v(TAG, "getDate TripPlan");
    	return date;
    }
    /**
     * The origin
     */
	
    public Place from = null;
    /**
     * The destination
     */
	
    public Place to = null;

    /** 
     * A list of possible itineraries. 
     */
    ///*@XmlElementWrapper(name="itineraries")*/
    //@SerializedName("itineraries")
    
    public List<Itinerary> itineraries = new ArrayList<Itinerary>();

    public TripPlan() {}
    
    public TripPlan(Place from, Place to, Date date) {
        this.from = from;
        this.to = to;
        this.formatted_date = date;
    }
    
    
    public void addItinerary(Itinerary itinerary) {
        this.itineraries.add(itinerary);
    }
    
    public Date getFormatted_date() {    	
    	SimpleDateFormat parser = 
    			new SimpleDateFormat(DateConstants.ISO_DATETIME_TIME_ZONE_FORMAT);
//    	Log.v(TAG, "setDate TripPlan");
    	try {
//    		Log.v(TAG, d);
    		formatted_date = parser.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return formatted_date;
	}
    
    public List<Itinerary> getItinerary() {
		return itineraries;
	}
    
    public void setItinerary(List<Itinerary> itinerary) {
		this.itineraries = itinerary;
	}
}
