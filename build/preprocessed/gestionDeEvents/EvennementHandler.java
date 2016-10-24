package gestionDeEvents;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class EvennementHandler extends DefaultHandler{
    private Vector evennements;
    int Id_event  = 0;
    
   
String TitreTag = "close" ;
   String dateTag = "close" ; 
    String typeTag = "close";
  String descriptionTag= "close";
   String etatTag = "close";
  String idSalleTag= "close";


    public EvennementHandler() {
        evennements = new Vector();
    }

    public evennement[] getEvents() {
        evennement[] evennementss = new evennement[evennements.size()];
        evennements.copyInto(evennementss);
        return evennementss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private evennement currentEvent;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            currentEvent = new evennement();
         //   2ème methode pour parser les attributs
         //   currentPersonne.setId_event(attributes.getValue("Id_event"));
            currentEvent.setDate(attributes.getValue("date"));
            currentEvent.setDescription(attributes.getValue("description"));
             currentEvent.setEtat(attributes.getValue("etat"));
              currentEvent.setTitre(attributes.getValue("Titre"));
               currentEvent.setType(attributes.getValue("type")); 
                       currentEvent.setIdSalle(attributes.getValue("idSalle"));
                       
            /****/
            
//        } else if (qName.equals("Id_event")) {
//            Id_event = "open";
        } else if (qName.equals("date")) {
            dateTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        }
        else if (qName.equals("etat")) {
            etatTag = "open";
        }
        else if (qName.equals("Titre")) {
           TitreTag = "open";
        }
         else if (qName.equals("type")) {
           typeTag = "open";
        }
         else if (qName.equals("idSalle")) {
           idSalleTag = "open";
        }
        
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            evennements.addElement(currentEvent);
            currentEvent = null;
            //        } else if (qName.equals("Id_event")) {
//            Id_event = "open";
        } else if (qName.equals("date")) {
            dateTag = "close";
        } else if (qName.equals("description")) {
            descriptionTag = "close";
        }
        else if (qName.equals("etat")) {
            etatTag = "close";
        }
        else if (qName.equals("Titre")) {
           TitreTag = "close";
        }
         else if (qName.equals("type")) {
           typeTag = "close";
        }
         else if (qName.equals("idSalle")) {
           idSalleTag = "close";
        }
        
       
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentEvent != null) {
            // don't forget to trim excess spaces from the ends of the string
//            if (Id_event.equals("open")) {
//                String id = new String(ch, start, length).trim();
//                currentPersonne.setId(id);
//            } else
                if (TitreTag.equals("open")) {
                String titre = new String(ch, start, length).trim();
                currentEvent.setTitre(titre);
            } else
                    if (dateTag.equals("open")) {
                String date = new String(ch, start, length).trim();
                currentEvent.setDate(date);
            }
                 else
                    if (typeTag.equals("open")) {
                String type = new String(ch, start, length).trim();
                currentEvent.setDate(type);
            }
                else
                    if (descriptionTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentEvent.setDate(desc);
            }
                else
                    if (etatTag.equals("open")) {
                String etat = new String(ch, start, length).trim();
                currentEvent.setDate(etat);
            }
        
              
                
        }
    }
    
}
