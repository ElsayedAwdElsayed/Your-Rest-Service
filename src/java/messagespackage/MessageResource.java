/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import messagespackage.model.Message;
import messagespackage.service.MessageService;
/**
 *
 * @author elsayedawd
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MessageResource {

    MessageService messageService = new MessageService(); //has all operations that i need 

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size) {
        if(year>0)
        {
        return messageService.getAllMessageForYear(year);
        }
        if(start>=0 && size>=0)
        {
            return messageService.getAllMessagePaginated(start, size);
        }
        return messageService.getAllMessages();  //if not get all the message that you have  
    }

    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{message_Id}")
    public Message updateMessage(@PathParam("message_Id") Long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @GET
    @Path("/{message_Id}")
    public Message getMessage(@PathParam("message_Id") Long id) {
        return messageService.getMessage(id);
    }

    @DELETE
    @Path("/{message_Id}")
    public void deleteMessage(@PathParam("message_Id") Long id) {
        messageService.removeMessage(id);
    }
    
    @Path("/{message_Id}/comments")
    public CommentResource getAllComments()
    {
        return new CommentResource();
    }
}
