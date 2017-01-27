public class PersonaController {
   private Persona model;
   private PersonaView view;

   public PersonaController(Persona model, PersonaView view){
      this.model = model;
      this.view = view;
   }

   public void setPersonaNombre(String nombre){
      model.setNombre(nombre);		
   }

   public String getPersonaNombre(){
      return model.getNombre();		
   }

   public void setPersonaApellidos(String apellidos){
      model.setApellidos(apellidos);		
   }

   public String getPersonaApellidos(){
      return model.getApellidos();		
   }

   public void setPersonaDireccion(String direccion){
      model.setDireccion(direccion);		
   }

   public String getPersonaDireccion(){
      return model.getDireccion();		
   }

   public void setPersonaFechaNac(String fechaNac){
      model.setFechaNac(fechaNac);		
   }

   public String getPersonaFechaNac(){
      return model.getFechaNac();		
   }

   public void updateView(){				
      view.printPersonaDetails(model.getNombre(), model.getApellidos(), model.getDireccion(), model.getFechaNac());
   }	
}
