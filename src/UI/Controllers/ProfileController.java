/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

/**
 *
 * @author Eric Lambert
 */
import UI.UserInterfaces.ProfileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController 
{
    private ProfileView profile;
    
    public ProfileController(ProfileView profile)
    {
        this.profile = profile;
        //profile.addSubBtnListener(new subBtnListener());
        //profile.addHistBtnListener(new histBtnListener());
        //profile.addEditBtnListener(new editBtnListener());
        //profile.addHomeBtnListener(new homeBtnListener());
    }
}
