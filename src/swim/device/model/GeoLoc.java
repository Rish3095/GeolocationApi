package swim.device.model;

import swim.transit.model.Tag;

@Tag("agency")
public class GeoLoc {
	
	private String latitude = "";
	private String longitude = "";
	private int device_id = -1;
	private int index = 0;
	
	public GeoLoc() {
		
	}
	
	public GeoLoc(String latitude, String longitude, int index,int device_id) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.index = index;
		this.device_id = device_id;
	}
	
	public String getLatitude() {
		return this.latitude;
	}
	
	public String getLongitude() {
		return this.longitude;
	}
	
	public int getDeviceId() {
		return this.device_id;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String getUri() {
		return "/device/"+this.getDeviceId();
	}
}
