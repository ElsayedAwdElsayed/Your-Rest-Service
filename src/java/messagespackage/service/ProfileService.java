/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import messagespackage.database.DataBase;
import messagespackage.model.Profile;

/**
 *
 * @author elsayedawd
 */
public class ProfileService {
    private Map<String,Profile> profiles=DataBase.getProfiles();

    public ProfileService() {
        profiles.put("Elsayed",new Profile(1L,"Elsayed","Elsayed","Awd"));
    }
    
    public List<Profile> getAllProfiles()
    {
        return new ArrayList<Profile>(profiles.values());
    }
    public Profile getProfile(String profileName)
    {
        return profiles.get(profileName);
    }
    
    public Profile addProfile(Profile profile)
    {
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    
    public Profile updateProfile(Profile profile)
    {
        if (profile.getProfileName().isEmpty())
        {
            return null;
        }
        
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    
    public Profile removeProfile(String profileName)
    {
        return profiles.remove(profileName);
    }
}
