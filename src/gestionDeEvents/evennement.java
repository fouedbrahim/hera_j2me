/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionDeEvents;

/**
 *
 * @author Foued ben brahim
 */
public class evennement {
    
  private int Id_event ;
  private String Titre ;
  private String date ; 
   private String type ;
   private String description;
   private String etat ;
   private String idSalle;

    public evennement( String Titre, String type) {
       
        this.Titre = Titre;
     
        this.type = type;
       
    }

    public int getId_event() {
        return Id_event;
    }

    public void setId_event(int Id_event) {
        this.Id_event = Id_event;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String toString() {
        return "evennement{" + "Id_event=" + Id_event + ", Titre=" + Titre + ", date=" + date + ", type=" + type + ", description=" + description + ", etat=" + etat + ", idSalle=" + idSalle + '}';
    }

    public evennement() {
    }
     evennement getEvents() {
        return null;
    }

   
   
 

}
