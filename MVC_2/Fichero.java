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
			StringBuilder sb = new StringBuilder();

			while(bufferedInput.available() > 0)
			{
				dato = new String(bufferedInput.readUTF());
				sb.append(dato).append("\n");
			}
			bufferedInput.close();

			String fileAsString = sb.toString();
			//System.out.println("Contents : " + fileAsString);
			String[] temp = sb.toString().split("\n");

			cantidad = temp.length/4;
			personas = new Persona[cantidad];

			int indice = 0;
			for(int i = 0; i < personas.length; i++)
			{
				persona.setNombre(temp[indice]);
				persona.setApellidos(temp[indice + 1]);
				persona.setDireccion(temp[indice + 2]);
				persona.setFechaNac(temp[indice + 3]);
				personas[i] = persona;
				indice = indice + 4;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

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
