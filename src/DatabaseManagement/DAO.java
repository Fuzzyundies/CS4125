/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManagement;

/**
 *
 * @author Benjamin Grimes
 */
public interface DAO 
{
    String select(Object o);
    
    boolean insert(Object o);
    
    boolean update(Object o);
    
    boolean delete(Object o);
}
