/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.User;

import Business.Product.Product;

/**
 *
 * @author neild
 */
public interface Observer {

    void update(Product product);
}