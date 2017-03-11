/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author elsayedawd
 */

@Path("/")
public class CommentResource {
    
    //default get for sub resource 
    @GET
    public String testSubResource()
    {
        return "sub resource has been called ";
    }
    @GET
    @Path("/{comment_Id}")
    public String getComment(@PathParam("message_Id") String message_Id,@PathParam("comment_Id") String comment_Id)
    {
        return "from message_Id :  "+message_Id+" to comment_Id "+comment_Id;
    }
}
