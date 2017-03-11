/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.hk2.api.Metadata;

/**
 *
 * @author elsayedawd
 */
@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    
    @GET
    @Path("annotions")
    public String getParamsUsingAnnoaations(@MatrixParam("param") String  matxricParam,@HeaderParam("customHeaderParam") String header  ,@CookieParam("name") String cookieParam)
    {
        return "matxrix  " + matxricParam + " custom Header_Param "+header + " cookie_Param " + cookieParam;
    }
    
    
    
}
