/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Grimes
 */
public class CollectionPoint 
{
    private int id;
    private List<Locker> lockers;
    private String postCode;
    private String address;
    
    public CollectionPoint(int id, String postCode, String address)
    {
        this.id = id;
        lockers = new ArrayList<Locker>();
        this.postCode = postCode;
        this.address = address;
    }

    public int getId() 
    {
        return id;
    }

    public List<Locker> getLockers() 
    {
        return lockers;
    }

    public String getPostCode() 
    {
        return postCode;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setId(int id) 
    {
        // TODO implement validation for setID method
        this.id = id;
    }

    public void setPostCode(String postCode) 
    {
        // TODO implement validation for setPostCode method
        this.postCode = postCode;
    }

    public void setAddress(String address) 
    {
        // TODO implement validation for setAddress method
        this.address = address;
    }
    
    public void addLocker(Locker locker)
    {
        lockers.add(locker);
    }
}
