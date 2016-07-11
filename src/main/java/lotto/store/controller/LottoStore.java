package lotto.store.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;

/*@Entity // indicates that this is an Entity
@Cache  // Annotate your entity classes with @Cache to make them cacheable.
        // The cache is shared by all running instances of your application
        // and can both improve the speed and reduce the cost of your application.
        // Memcache requests are free and typically complete in a couple milliseconds.
        // Datastore requests are metered and typically complete in tens of milliseconds.
*/
@Entity
public class LottoStore {
	@com.googlecode.objectify.annotation.Id 
	public Long id;
	public String name;
	
	@JsonProperty("RTLRID")	private String RTLRID;
	@JsonProperty("RTLRSTRTELNO")	private String RTLRSTRTELNO;
	@JsonProperty("RECORDNO")	private int RECORDNO;
	@JsonProperty("LATITUDE")	private double LATITUDE;
	@JsonProperty("LONGITUDE")	private double LONGITUDE;
	@JsonProperty("DEAL645")	private String DEAL645;
	@JsonProperty("DEALSPEETO")	private String DEALSPEETO;
	@JsonProperty("DEAL520")	private String DEAL520;
	@JsonProperty("FIRMNM")				private String FIRMNM;
	@JsonProperty("BPLCLOCPLCDTLADRES")	private String BPLCLOCPLCDTLADRES;
	@JsonProperty("BPLCLOCPLC4")	private String BPLCLOCPLC4;
	@JsonProperty("BPLCLOCPLC3")	private String BPLCLOCPLC3;
	@JsonProperty("BPLCLOCPLC2")	private String BPLCLOCPLC2;
	@JsonProperty("BPLCLOCPLC1")	private String BPLCLOCPLC1;
	
	
	
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name ;
		
	}
}  


