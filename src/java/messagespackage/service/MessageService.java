/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagespackage.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import messagespackage.database.DataBase;
import messagespackage.model.Message;

/**
 *
 * @author elsayedawd
 */
public class MessageService {
   private Map<Long,Message> messages=DataBase.getMessages();

    public MessageService() {
        messages.put(1L,new Message(1,"hello java","elsayed"));
        messages.put(2L,new Message(2,"hello NodeJs","ammar"));

    }
   
    public List<Message> getAllMessages() {
       
       return new ArrayList<>(messages.values());
    }
    public Message getMessage(Long id)
    {
     return messages.get(id);
    }
    public Message addMessage(Message message)
    {
        message.setId(messages.size()+1);  //to set Id to that message 
        messages.put(message.getId(), message);//add to data base the message_Id and Message itself 
        return  message;            
    }
     
    public Message updateMessage(Message message)
    {
        if(message.getId() <=0)
        {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }
    public Message removeMessage(Long id)
    {
        
      return   messages.remove(id);
        
    }
  public List<Message> getAllMessageForYear(int year)
      {
          List<Message> messageForYear=new ArrayList<>();
          Calendar calender=Calendar.getInstance();
          
          for (Message message:messages.values())       //loop over the message that we need 
          {
              calender.setTime(message.getCreated());   //override the time of the message 
              if(calender.get(Calendar.YEAR)==year)     //compare the messages with our messages 
              {
                  messageForYear.add(message);                 
              }
          }
          return messageForYear;
        
    }
            
            
    public List<Message> getAllMessagePaginated(int start,int size)
   {
        ArrayList<Message> list=new ArrayList<Message>(messages.values());
        if(start+size>list.size())
        return new ArrayList<Message>();
        return list.subList(start, start+size);
            
   }  
    
    
}
