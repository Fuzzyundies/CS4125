/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import Business.Product.Product;
import Business.User.Observer;

/**
 *
 * @author neild
 */
public interface Subject {

    void registerObserver(Observer o);

    void unregisterObserver(Observer o);

    void notify(Product product);

}
