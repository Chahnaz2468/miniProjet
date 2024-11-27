package ihm;

import controllers.TechController;
import entities.Technicien;

import java.util.List;
import java.util.Scanner;

public class TechIHM {
    private TechController tc;

    public TechIHM(TechController tc) {
        this.tc = tc;
    }

    public TechController getTc() {
        return tc;
    }

    public void setTc(TechController tc) {
        this.tc = tc;
    }

    public void saisir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du technicien: ");
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
        System.out.println("donner la specialité: ");
        String spe = sc.next();
        Technicien tech = new Technicien(id, nom, prenom, num, horraire, annexp, email,spe);
        if (tc.init(tech) == 1)
            System.out.println("Technicien ajouté avec succes ");
        else
            System.out.println("Erreur");
    }

    public void modifierHorraireTech() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du technicien à modifier: ");
        int id = sc.nextInt();
        System.out.println("Veuillez saisir le nouveau horraire du technicien: ");
        int horraire = sc.nextInt();
        if (tc.modif(id, horraire) == 1)
            System.out.println("Modification faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void supprimerTech() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du technicien à supprimer: ");
        int id = sc.nextInt();
        if (tc.supp(id) == 1)
            System.out.println("Suppresion faite avec succes ");
        else
            System.out.println("Erreur");
    }

    public void afficherTech() {
        List<Technicien> techs = tc.affich();
        if (techs == null || techs.isEmpty()) {
            System.out.println("Aucun technicien à afficher.");
            return;
        }

        for (Technicien tech : techs) {
            System.out.println("Technicien:");
            System.out.println("  ID: " + tech.getId());
            System.out.println("  Nom: " + tech.getNom());
            System.out.println("  Prenom: " + tech.getPrenom());
            System.out.println("  Telephone: " + tech.getTelephone());
            System.out.println(" Horraire: " + tech.getHorraire());
            System.out.println("  Année d'experience: " + tech.getAnnexp());
            System.out.println("  Email: " + tech.getEmail());
            System.out.println("-----------------------------");
        }
    }

    public void findTechById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir l'id du technicien à trouver: ");
        int id = sc.nextInt();
        Technicien tech;
        if (tc.find(id) == null)
            System.out.println("Erreur");
        else {
            tech = tc.find(id);
            System.out.println("Technicien:");
            System.out.println("  ID: " + tech.getId());
            System.out.println("  Nom: " + tech.getNom());
            System.out.println("  Prenom: " + tech.getPrenom());
            System.out.println("  Telephone: " + tech.getTelephone());
            System.out.println(" Horraire: " + tech.getHorraire());
            System.out.println("  Année d'experience: " + tech.getAnnexp());
            System.out.println("  Email: " + tech.getEmail());
            System.out.println("-----------------------------");
        }
    }
}
