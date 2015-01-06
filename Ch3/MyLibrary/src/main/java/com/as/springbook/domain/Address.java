package com.as.springbook.domain;

public interface Address {

	 /**
     * <p>Address is a collection of fields share by client, 
     * staff, and library. Embedding/Inheriting it is doable, but
     * adds an unnecessary complexity to the schema.</p>
     * 
     */
	
    public Long getId();
    public void setId(Long id);

    public String getName();
    public void setName(String name);

    public String getAddress();
    public void setAddress(String address);

    public String getStreet();
    public void setStreet(String street);

    public String getPostalCode();
    public void setPostalCode(String postalCode);

    public String getTown();
    public void setTown(String town);

    public String getPhone();
    public void setPhone(String phone);

    public Double getCity();
    public void setCity(String city);

    public Double getPrefecture();
    public void setPrefecture(String prefecture);

}
