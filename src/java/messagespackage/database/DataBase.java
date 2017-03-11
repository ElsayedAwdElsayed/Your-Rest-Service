/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage.database;

import java.util.HashMap;
import java.util.Map;
import messagespackage.model.Message;
import messagespackage.model.Profile;

/**
 *
 * @author elsayedawd
 */
public class DataBase {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String , Profile> profiles = new HashMap<>(); //because we need profile names only  
    //for that not all the profiles that we need 
    public static Map<Long, Message> getMessages()
    {
        return messages;
    }
     public static Map<String , Profile> getProfiles()
    {
        return profiles;
    }

}
