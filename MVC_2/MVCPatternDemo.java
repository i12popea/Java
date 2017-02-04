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

   public void ActualizarModelos()
   {
      Scanner teclado = new Scanner(System.in);
      System.out.print("Hay " + modelos.length + " registros. Elija de 0 a " + (modelos.length - 1) + "\n");
      int valor;
      String contenido;
      valor = teclado.nextInt();
      teclado.nextLine();
      if(valor >= 0 && valor < modelos.length)
      {
         Persona persona = new Persona();
         System.out.print("Nombre de la persona: ");
         contenido = teclado.nextLine();
         persona.setNombre(contenido);
         System.out.print("Apellidos de la persona: ");
         contenido = teclado.nextLine();
         persona.setApellidos(contenido);
         System.out.print("Direccion de la persona: ");
         contenido = teclado.nextLine();
         persona.setDireccion(contenido);
         System.out.print("Fecha de nacimiento de la persona: ");
         contenido = teclado.nextLine();
         persona.setFechaNac(contenido);

         modelos[valor] = persona;
      }
   }

   public void CargarFichero(String nombreFich)
   {
      Fichero fichero = new Fichero();
      modelos = fichero.LeerFichero(nombreFich);
   }

   public void GrabarFichero(String nombreFich)
   {
      Fichero fichero = new Fichero();
      fichero.EscribirFichero(nombreFich, modelos);
   }

   public static void main(String[] args) {

      MVCPatternDemo mvc = new MVCPatternDemo();
      String nombreFich = "info.dat";
      Scanner teclado = new Scanner(System.in);
      int valor;

      do{
         System.out.print("Elija una opcion entre 1 y 6\n");
         System.out.print("(1) Cargar un fichero de texto\n");
         System.out.print("(2) Grabar un fichero de texto\n");
         System.out.print("(3) Crear numero de registros\n");
         System.out.print("(4) Crear registros de personas\n");
         System.out.print("(5) Visualizar registros\n");
         System.out.print("(6) Actualizar registro\n");
         System.out.print("(7) Salir\n");
         valor = teclado.nextInt();

         if(valor == 1)
         {
            mvc.CargarFichero(nombreFich);
         }
         if(valor == 2)
         {
            mvc.GrabarFichero(nombreFich);
         }
         if(valor == 3)
         {
            mvc.iniciar();
         }
         if(valor == 4)
         {
            mvc.CrearModelos();
         }
         if(valor == 5)
         {
            mvc.VisualizarModelos();
         }
         if(valor == 6)
         {
            mvc.ActualizarModelos();
         }
      }while(valor != 7);
   }
}
