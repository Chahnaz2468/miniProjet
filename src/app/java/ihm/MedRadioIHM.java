package ihm;

import controllers.ExamenController;
import controllers.MedRadioController;
import entities.Examen;
import entities.MedRadio;
import entities.TypeExamen;

import java.util.List;
import java.util.Scanner;

public class MedRadioIHM {
    private MedRadioController mrc;

    public MedRadioIHM(MedRadioController mrc) {
        this.mrc = mrc;
    }

    public MedRadioController getMrc() {
        return mrc;
    }

    public void setMrc(MedRadioController mrc) {
        this.mrc = mrc;
    }

    public void saisir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin radiologue: ");
        int id = sc.nextInt();
        System.out.println("donner le nom: ");
        String nom = sc.next();
        System.out.println("donner le prenom: ");
        String prenom = sc.next();
        System.out.println("donner le numero telephone: ");
        double num = sc.nextDouble();
        System.out.println("Veuillez saisir l'horraire: ");
        int horraire = sc.nextInt();
        System.out.println("Veuillez saisir combien d'année d'experience: ");
        int annexp = sc.nextInt();
        System.out.println("Veuillez saisir l'email: ");
        String email = sc.next();
        MedRadio medRadio = new MedRadio(id, nom, prenom, num, horraire, annexp, email);
        if (mrc.init(medRadio) == 1)
            System.out.println("Medecin radiologue ajouté avec succes ");
        else
            System.out.println("Erreur");
    }

    public void modifierHorraireMedRadio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin radiologue à modifier: ");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir le nouveau horraire du medecin radiologue: ");
        int horraire = sc.nextInt();
        if (mrc.modif(id, horraire) == 1)
            System.out.println("Modification faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void supprimerMedRadio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin radiologue à supprimer: ");
        int id = sc.nextInt();
        if (mrc.supp(id) == 1)
            System.out.println("Suppresion faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void afficherMedRadio() {
        List<MedRadio> medRadios = mrc.affich();
        if (medRadios == null || medRadios.isEmpty()) {
            System.out.println("Aucun medecin radiologue à afficher.");
            return;
        }

        for (MedRadio medRadio : medRadios) {
            System.out.println("Medecin radiologue:");
            System.out.println("  ID: " + medRadio.getId());
            System.out.println("  Nom: " + medRadio.getNom());
            System.out.println("  Prenom: " + medRadio.getPrenom());
            System.out.println("  Telephone: " + medRadio.getTelephone());
            System.out.println(" Horraire: " + medRadio.getHorraire());
            System.out.println("  Année d'experience: " + medRadio.getAnnexp());
            System.out.println("  Email: " + medRadio.getEmail());
            System.out.println("-----------------------------");
        }
    }

    public void findMedRadioById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du medecin radiologue à trouver: ");
        int id = sc.nextInt();
        MedRadio medRadio;
        if (mrc.find(id) == null)
            System.out.println("Erreur");
        else {
            medRadio = mrc.find(id);
            System.out.println("Medecin radiologue:");
            System.out.println("  ID: " + medRadio.getId());
            System.out.println("  Nom: " + medRadio.getNom());
            System.out.println("  Prenom: " + medRadio.getPrenom());
            System.out.println("  Telephone: " + medRadio.getTelephone());
            System.out.println(" Horraire: " + medRadio.getHorraire());
            System.out.println("  Année d'experience: " + medRadio.getAnnexp());
            System.out.println("  Email: " + medRadio.getEmail());
            System.out.println("-----------------------------");
        }
    }
}
