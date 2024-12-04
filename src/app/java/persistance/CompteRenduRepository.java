package persistance;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import entities.Centre;
import entities.CompteRendu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CompteRenduRepository {
    static File file = new File("src/app/resources/CompteRenduData.json");
    private CompteRendu[] compteRendus = new CompteRendu[100];
    CentreRepository centreRepository = new CentreRepository();

    public CompteRenduRepository(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public CompteRendu[] getCompteRendus() {
        return compteRendus;
    }

    public void setCompteRendus(CompteRendu[] compteRendus) {
        this.compteRendus = compteRendus;
    }

    public void saveCompteRendus() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, compteRendus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCompteRendus() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (file.exists()) {
                compteRendus = mapper.readValue(file, new TypeReference<CompteRendu[]>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean saveCompteRenduAsPdf(CompteRendu compteRendu) {
        try {
            Centre centre = centreRepository.getCentre();

            String pdfFileName = "comptes_rendus/" + compteRendu.getPatient().getNom() + "_CompteRendu.pdf";
            File folder = new File("comptes_rendus");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            PdfWriter writer = new PdfWriter(pdfFileName);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            PdfFont helveticaBold = PdfFontFactory.createFont("Helvetica-Bold");
            PdfFont helveticaRegular = PdfFontFactory.createFont("Helvetica");
            document.add(new Paragraph("Centre : " + centre.getNom()).setFont(helveticaBold));
            document.add(new Paragraph("Adresse : " + centre.getAdresse()).setFont(helveticaRegular));
            document.add(new Paragraph("Téléphone : " + centre.getNumTel()).setFont(helveticaRegular));
            document.add(new Paragraph("----------------------------------------------------"));

            document.add(new Paragraph("Compte Rendu Médical"));
            document.add(new Paragraph("ID : " + compteRendu.getId()));
            document.add(new Paragraph("Patient : " + compteRendu.getPatient().getNom()));
            document.add(new Paragraph("Médecin Radiologue : " + compteRendu.getMedRadio().getNom()));
            document.add(new Paragraph("Contenu : " + compteRendu.getContenu()));

            document.add(new Paragraph("----------------------------------------------------"));
            document.add(new Paragraph("Centre " + centre.getNom() + " - Tous droits réservés").setFont(helveticaRegular));
            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
