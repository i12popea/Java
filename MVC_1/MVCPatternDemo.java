import java.util.Scanner;

public class MVCPatternDemo {

   private Persona[] modelos;

   public void iniciar()
   {
      int numero;
      Scanner teclado = new Scanner(System.in);
      System.out.print("Numero de personas a crear: ");
      numero = teclado.nextInt();
      modelos = new Persona[numero];
   }

   private static Persona crearPersona()
   {
      Scanner teclado = new Scanner(System.in);
      String valor;
      Persona persona = new Persona();
      System.out.print("Nombre de la persona: ");
      valor = teclado.nextLine();
      persona.setNombre(valor);
      System.out.print("Apellidos de la persona: ");
      valor = teclado.nextLine();
      persona.setApellidos(valor);
      System.out.print("Direccion de la persona: ");
      valor = teclado.nextLine();
      persona.setDireccion(valor);
      System.out.print("Fecha de nacimiento de la persona: ");
      valor = teclado.nextLine();
      persona.setFechaNac(valor);
      return persona;
   }

   public void CrearModelos()
   {
      // Creamos los modelos
      for(int i = 0; i < modelos.length; i++)
      {
         System.out.print("Persona numero: " + (i + 1) + "\n");
         //fetch student record based on his roll no from the database
         Persona model = crearPersona();
         modelos[i] = model;
         System.out.print("\n");
      }
   }

   public void VisualizarModelos()
   {
      // Visualizamos los resultados
      for(int i = 0; i < modelos.length; i++)
      {
            //Create a view : to write student details on console
         PersonaView view = new PersonaView();

         PersonaController controller = new PersonaController(modelos[i], view);

         controller.updateView();
      }
   }

   public static void main(String[] args) {

      MVCPatternDemo mvc = new MVCPatternDemo();
      mvc.iniciar();

      mvc.CrearModelos();

      mvc.VisualizarModelos();
   }
}
