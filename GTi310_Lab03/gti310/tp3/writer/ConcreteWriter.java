package gti310.tp3.writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import sun.text.normalizer.UTF16;
/**
 * Cette classe permet de faire l'écriture des chemin dans le fichier
 * de sortie
 * @author Julien Labrosse
 * @param <T>
 *
 */
public class ConcreteWriter<T> implements Writer<T> {
	
/**
 * Cette methode permet d'écrire dans le fichier de sortie
 * complexite : O(N)
 */
	public void write(String filename, T input) {
		@SuppressWarnings("unchecked")
		ArrayList<String>test = (ArrayList<String>) input;
		boolean verif = verification(filename, test);
		if (verif) {
			try {
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
				for (int i = 0; i < test.size(); i++) {
					if (i != 0) {
						writer.newLine();
					}
					System.out.println(test.get(i));
					writer.write(test.get(i));
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
	private boolean verification(String filename, ArrayList<String> test) {
		if (!filename.contains(".txt")) {
			System.err.println("entrez un fichier de distination ");
			return false;
		}
		if (test.isEmpty()) {
			System.err.println("Aucun chemin trouver");
			return false;
		}
		return true;
	}
}
