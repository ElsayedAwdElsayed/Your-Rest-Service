/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import messagespackage.database.DataBase;
import messagespackage.model.Profile;
import messagespackage.service.ProfileService;

/**
 *
 * @author elsayedawd
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {
 
    private  ProfileService profileService=new ProfileService();
    
    @GET
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @POST
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profile_name}")
    public Profile updateMessage(@PathParam("profile_name") String profile_name, Profile profile) {
        profile.setProfileName(profile_name);
        return profileService.updateProfile(profile);
    }

    @GET
    @Path("/{profile_name}")
    public Profile getProfile(@PathParam("profile_name") String profile_name) {
        return profileService.getProfile(profile_name);
    }

    @DELETE
    @Path("/{profile_name}")
    public void deleteMessage(@PathParam("profile_name") String profile_name) {
        profileService.removeProfile(profile_name);
    }
}
