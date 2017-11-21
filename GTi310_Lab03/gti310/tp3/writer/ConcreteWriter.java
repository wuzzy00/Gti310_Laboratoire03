package gti310.tp3.writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import sun.text.normalizer.UTF16;
/**
 * Cette classe permet de faire l'écriture des chemin dans le fichier
 * de sortie
 * @author Julien Labrosse
 *
 */
public class ConcreteWriter implements Writer<ArrayList<String>> {
	@Override
/**
 * Cette methode permet d'écrire dans le fichier de sortie
 */
	public void write(String filename, ArrayList<String>[] test) {
		boolean verif = verification(filename, test);
		if (verif) {
			try {
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
				for (int i = 0; i < test.length; i++) {
					if (i != 0) {
						writer.newLine();
					}
					for (String path : test[i]) {
						writer.write(path + " ");
					}
				}
				writer.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
/**
 * Cette classe permet de vérifier les parametres
 * @param filename
 * @param test
 * @return boolean
 */
	private boolean verification(String filename, ArrayList<String>[] test) {
		if (!filename.contains(".txt")) {
			System.err.println("entrez un fichier de distination ");
			return false;
		}
		if (test[0].isEmpty()) {
			System.err.println("Aucun chemin trouver");
			return false;
		}
		return true;
	}
}
