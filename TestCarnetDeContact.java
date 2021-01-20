package CarnetContact;

import java.util.Scanner;

public class TestCarnetDeContact {

	/**
	 * @author Renaud Vidal Création du tableau de contact de 30 entrées maximales
	 *         Ouverture du Scanner pour enregistrement du besion de l'utilisateur
	 *         initialisation du choix
	 */

	static String[][] Contact = new String[30][5]; // création du tableau
	static String prenom; // utlisation de variable statiques pour l'acces sur tout le programmes
	static String nom;// utlisation de variable statiques pour l'acces sur tout le programmes
	static String telephone;// utlisation de variable statiques pour l'acces sur tout le programmes
	static String adresse;// utlisation de variable statiques pour l'acces sur tout le programmes
	static Scanner scanner = new Scanner(System.in); // scanner Statiques
	static String elementTab = "--------------------"; // partie de tableau Statiques
	static String name = "NOM"; // En tetes de tableau Statiques
	static String secondname = "PRENOM";// En tetes de tableau Statiques
	static String adress = "ADRESSE";// En tetes de tableau Statiques
	static String tel = "TELEPHONE";// En tetes de tableau Statiques
	static String index = "INDEX";// En tetes de tableau Statiques
	static Scanner ChoixUtil = new Scanner(System.in);
	int choix;
	static boolean bouclePrincipale = true; // boucle de retour sur le menu choicMethode

	public static void AffichageEcranPrincipal() {

		/**
		 * @author Renaud Vidal Cette méthode permet d'afficher le menu principal
		 */

		System.out.println("Menu Carnet de contact");
		System.out.println("(1) - Ajouter un contact");
		System.out.println("(2) - Afficher un contact");
		System.out.println("(3) - Supprimer un contact");
		System.out.println("(4) - Modifier un contact");
		System.out.println("(5) - Rechercher un contact");
		System.out.println("(0) - Quitter le menu un contact");

		System.out.println("----------------------------------");

	}

	/**
	 * Cette méthode permet à l'utilisateur de choisir sa commande. Le choix est
	 * enregistré dans la variable Choix. Le switch case permet de lancer la méthode
	 * correspondante et de gérer les erreurs de saisies
	 */
	public static void ChoixMehode() {

		while (bouclePrincipale) {

			String choix = "";
			int choixNum = 0;
			boolean Error = true;

			while (Error == true) { // gestion des erreurs de frappes, lettres à la place de chiffres
				try {
					System.out.println("Entrez votre choix en utilisant un chiffre : ");
					choix = "";
					choix = ChoixUtil.nextLine(); // entrer la valeur choix
					choixNum = Integer.parseInt(choix); // transforamtion de la valeurs en integer
					Error = false; // si integer alors on sort de la boucle et on continue sur le string

				} catch (NumberFormatException e) { // dans le cas on on entre une lettre, je redemande un chiffre
					Error = true;

				}
			}

			switch (choixNum) {
			case 1: {
				Ajouter(); // ajouter un ou plusieurs contact
				return;
			}
			case 2: {
				AffichageInfos(); // affiche toutes les info du répertoire
				return;
			}
			case 3: {
				Supprimer(Contact); // supprime un contact
				return;
			}
			case 4: {
				Modifier(); // modifi un contact
				return;
			}
			case 5: {
				Recherche(); // recherche un contact
				return;
			}
			case 0: {
				Quitter(0); // quitte le programme
				return;
			}
			default: {
				System.out.println("Veuillez entrer un chiffre en 0 et 4: Vous venez d'entrer " + choix);
				bouclePrincipale = true; // boucle si utlisateur utlise un valeur differente de 0 à 5
			}
			}
		}
	}

	public static void Ajouter() {

		// initialiation d'une liste de deux dimensions
		// je crée plusiquer fois le tableau, ce n'est pas bon, il faut le créer dans le
		// main.
		// le passser en paramétre ou le mettre en static;
		// reourner le tableau ;

		System.out.println("Veuillez entrer les informations de contacts : ");

		int i = 0;
		Boolean boucle = true;

		while (boucle) {

			while (i < Contact.length && Contact[i][0] != null) {
				i++;
			}

			System.out.println();
			System.out.println("Contact n° " + i);

			System.out.println("Veuillez entrer le prénom : ");
			Contact[i][0] = scanner.nextLine();
			prenom = Contact[i][0];

			System.out.println("Veuillez entrer le nom : ");
			Contact[i][1] = scanner.nextLine();
			nom = Contact[i][1];

			while (true) {
				System.out.println("Veuillez entrer l'adresse email: ");
				Contact[i][2] = scanner.nextLine();

				if (isValidemail(Contact[i][2]) == true) {

					adresse = Contact[i][2];
					break;
				} else {
					System.out.println("Format de l'email incorrect");
					System.out.println();

				}
			}

			while (true) {
				System.out.println("Veuillez entrer le téléphone : ");
				Contact[i][3] = scanner.nextLine();

				if (isValidNumber(Contact[i][3]) == true) {

					telephone = Contact[i][3];
					break;
				} else {
					System.out.println("format de téléphone incorrect");
					// boucle = false;
					System.out.println();

				}
			}

			System.out.println("Vous venez d'enregistrer : ");
			System.out.printf(" %s + %s + %s + %s \n ", elementTab, elementTab, elementTab, elementTab);
			System.out.printf("|%-20s||%-20s||%-20s||%-20s|\n ", name, secondname, adress, tel);
			System.out.printf(" %s + %s + %s + %s \n ", elementTab, elementTab, elementTab, elementTab);
			System.out.printf("|%-20s||%-20s||%-20s||%-20s|\n ", prenom, nom, adresse, telephone);
			System.out.printf(" %s + %s + %s + %s \n ", elementTab, elementTab, elementTab, elementTab);

			System.out.println();
			System.out.println("Souhaitez intégrer un nouveau contact ? (oui / non) ");

			String ajout = scanner.nextLine();

			System.out.println();

			// String reponseUptoCase = ajout.toUpperCase();
			// permet dignorer le
			boolean retourmenu = true;
			while (retourmenu == true) {

				if (ajout.equalsIgnoreCase("OUI")) {
					System.out.println("Veuillez entrer les informations de contacts ");
					retourmenu = false;
					break;

				} else if (ajout.equalsIgnoreCase("NON")) {
					boucle = false;
					System.out.println();
					return;

				} else {
					System.out.println("Veillez entrer OUI ou NON svp ");
					ajout = scanner.nextLine();
					retourmenu = true;
				}
			}
		}

	}

	// si null je rajoute le contact sinon j'avance
	// on passser le tabelau en paramétre, rechercher la case null et retourne;

	public static void AffichageInfos() {

		// on invoque la méthode Print() qui est une methode pour l'affichage
		// des données du repertoire
		print();
		if (retourMenu() == true) {
			return;
		}

	}

	public static void print() {

		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);
		System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n ", index, name, secondname, adress, tel);
		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);

		for (int k = 0; k < Contact.length; k++) {
			if (Contact[k][0] != null) {
				System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n", k, Contact[k][0], Contact[k][1],
						Contact[k][2], Contact[k][3]);
				System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab,
						elementTab);

			}
		}
	}

	public static void Modifier() {

		int t = 0;
		String modification = "";
		boolean Error1 = true;
		Scanner scr = new Scanner(System.in);

		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);
		System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n ", index, name, secondname, adress, tel);
		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);

		for (int k = 0; k < Contact.length; k++) {
			if (Contact[k][0] != null) {
				System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n", k, Contact[k][0], Contact[k][1],
						Contact[k][2], Contact[k][3]);
				System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab,
						elementTab);
			}

		}

		while (Error1) { // gestion des erreurs de frappes, lettres à la place de chiffres
			try {
				System.out.println("Quels index souhaitez-vous modifier ? ");
				modification = "";
				modification = scanner.nextLine();
				t = Integer.parseInt(modification);
				Error1 = false; // si integer alors on sort de la boucle et on continue sur le string
			} catch (NumberFormatException y) { // dans le cas on on entre une lettre, je redemande un chiffre
				Error1 = true;

			}
		}

		System.out.println("Vous allez modifier : ");
		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);
		System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n ", index, name, secondname, adress, tel);
		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);
		System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n", t, Contact[t][0], Contact[t][1], Contact[t][2],
				Contact[t][3]);
		System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab, elementTab);

		System.out.println("Taper (1) pour modifier le nom ");
		System.out.println("Taper (2) pour modifier le prénom ");
		System.out.println("Taper (3) pour modifier le adresse ");
		System.out.println("Taper (4) pour modifier le téléphone ");

		while (t > 4) {
			System.out.println("Veuillez utiliser un index exitant  !! ");
			t = scanner.nextInt();
			System.out.println("Taper (1) pour modifier le nom ");
			System.out.println("Taper (2) pour modifier le prénom ");
			System.out.println("Taper (3) pour modifier le adresse ");
			System.out.println("Taper (4) pour modifier le téléphone ");
			System.out.println("Entrer votre réponse ici :  ");

		}

		String NouvelleValeur = "";
		int modifcation = scr.nextInt();

		switch (modifcation) {
		case 1: {

			System.out.println("Entrez la nouvelle valeur : ");
			NouvelleValeur = scr.nextLine();
			Contact[t][0] = NouvelleValeur;
			break;
		}
		case 2: {

			System.out.println("Entrez la nouvelle valeur : ");
			NouvelleValeur = scr.nextLine();
			Contact[t][1] = NouvelleValeur;
			break;
		}
		case 3: {

			while (true) {
				System.out.println("Veuillez entrer l'email : ");
				Contact[t][2] = scanner.nextLine();

				if (isValidemail(Contact[t][2]) == true) {

					NouvelleValeur = Contact[t][2];
					break;
				} else {
					System.out.println("Le format de l'email est incorrect");
					// boucle = false;
					System.out.println();

				}
			}

			break;
		}

		case 4: {

			while (true) {
				System.out.println("Veuillez entrer le téléphone : ");
				Contact[t][3] = scanner.nextLine();

				if (isValidNumber(Contact[t][3]) == true) {

					NouvelleValeur = Contact[t][3];
					break;
				} else {
					System.out.println("Le format de téléphone est incorrect");
					// boucle = false;
					System.out.println();

				}
			}

		}

		}
		AffichageInfos();

	}

	public static void Supprimer(String[][] Contact) {

		String recherche;
		Boolean contactfind = false;
		System.out.println("Quels contacts souhaitez-vous supprimer (Nom ou Prénom) ? ");
		recherche = scanner.nextLine();

		for (int b = 0; b < Contact.length; b++) {
			if (Contact[b][0] != null) {
				if (Contact[b][0].equals(recherche) || Contact[b][1].equals(recherche)) {

					Contact[b][0] = null;
					Contact[b][1] = null;
					Contact[b][2] = null;
					Contact[b][3] = null;
					contactfind = true;
					System.out.println("le contact " + recherche + " a bien été supprimé");

				}

			}
		}
		if (contactfind == false) {

			System.out.println("le contact " + recherche + " n'existe pas dans la base de donnnée");

		}
		AffichageInfos();

	}

	public static void Quitter(int b) {

		System.out.println("bye bye");
		scanner.close();
		b = 0;
		System.exit(0);

	}

	public static boolean retourMenu() {
		Scanner src1 = new Scanner(System.in);
		System.out.println("Appuyer sur la touche ENTRER pour revenir au menu");
		System.out.println();
		String retour = null;
		retour = src1.nextLine();
		if (retour.equals(null)) {
			return true;
		} else {
			return true;
		}

	}

	public static boolean isValidNumber(String telephone) {
		String regExp = "(0)[1-9][0-9]{8}";
		if (telephone.matches(regExp)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isValidemail(String email) {
		String regExpEmail = "^(.+)@(\\S+)$";
		if (email.matches(regExpEmail)) {
			return true;
		} else {
			return false;
		}

	}

	public static void Recherche() {

		String rechercheContact;
		System.out.println("Quels contacts souhaitez-vous rechercher (Nom ou Prénom) ? ");
		rechercheContact = scanner.nextLine();

		for (int b = 0; b < Contact.length; b++) {
			if (Contact[b][0] != null) {
				if (Contact[b][0].equals(rechercheContact) || Contact[b][1].equals(rechercheContact)) {
					System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab,
							elementTab);
					System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n ", index, name, secondname, adress, tel);
					System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab,
							elementTab);
					System.out.printf("|%-20s||%-20s||%-20s||%-20s||%-20s|\n", b, Contact[b][0], Contact[b][1],
							Contact[b][2], Contact[b][3]);
					System.out.printf("%s + %s + %s + %s + %s\n", elementTab, elementTab, elementTab, elementTab,
							elementTab);
				}
			}

		}
		retourMenu();

	}

}