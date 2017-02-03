import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fichero {
	public static Persona[] LeerFichero(String nombre){
		Persona personas[] = new Persona[1];
		Persona persona = new Persona();
		int cantidad = 0;
		try
		{
			FileInputStream fileInput = new FileInputStream(nombre);
			DataInputStream bufferedInput = new DataInputStream(fileInput);
			String dato;
			while(bufferedInput.available() > 0)
			{
				personas = new Persona[cantidad + 1];

				dato = new String(bufferedInput.readUTF());
				persona.setNombre(dato);
//System.out.print(persona.getNombre() + "\n");
				//persona.setNombre("1");
//System.out.print(dato + "\n");
				dato = new String(bufferedInput.readUTF());
				persona.setApellidos(dato);
				//persona.setApellidos("2");
//System.out.print(dato + "\n");
				dato = new String(bufferedInput.readUTF());
				persona.setDireccion(dato);
				//persona.setDireccion("3");
//System.out.print(dato + "\n");
				//dato = bufferedInput.readUTF();
				dato = new String(bufferedInput.readUTF());
				persona.setFechaNac(dato);
				//persona.setFechaNac("4");
//System.out.print(dato + "\n");

				if(personas.length == 1)
					personas[0] = persona;
				else
					personas[personas.length - 1] = persona;
				cantidad++;
			}
			bufferedInput.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
//System.out.print(personas.length + "\n");
		return personas;
	}

	public static void EscribirFichero(String nombre, Persona[] personas){
		try
		{
			FileOutputStream fileOutput = new FileOutputStream(nombre);
			DataOutputStream bufferedOutput = new DataOutputStream(fileOutput);
			for(int i = 0; i < personas.length; i++)
			{
				bufferedOutput.writeUTF(personas[i].getNombre());
				bufferedOutput.writeUTF(personas[i].getApellidos());
				bufferedOutput.writeUTF(personas[i].getDireccion());
				bufferedOutput.writeUTF(personas[i].getFechaNac());
			}
			bufferedOutput.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
