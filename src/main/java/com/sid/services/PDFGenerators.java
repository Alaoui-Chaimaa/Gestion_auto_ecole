package com.sid.services;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sid.entities.Candidat;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerators {
	private static Logger logger = LoggerFactory.getLogger(PDFGenerators.class);
	public static ByteArrayInputStream customersPDFReport(List<Candidat>candidats) {
		Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
try {
	
	PdfWriter.getInstance(document, out);
document.open();
	
// Add Text to PDF file ->
//Segment Code to add PDF text with iText
	Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	//Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
	Paragraph para = new Paragraph( "Liste des candidats", font);
	para.setAlignment(Element.ALIGN_CENTER);
	document.add(para);
	document.add(Chunk.NEWLINE);
	
	PdfPTable table = new PdfPTable(8);
	table.setWidthPercentage(99);
table.setSpacingBefore(0f);
table.setSpacingAfter(0f);

	// Add PDF Table Header ->
            Stream.of("nom", "cin","adresse","tel","numero_ministre","categorie_permis","date_inscription","prix")
	            .forEach(headerTitle -> {
		              PdfPCell header = new PdfPCell();
		              Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setBorderWidth(2);
		header.setPhrase(new Phrase(headerTitle, headFont));
		table.addCell(header);
	            });

for (Candidat candidat : candidats) {
                PdfPCell firstNameCell = new PdfPCell(new Phrase(candidat.getNom()));
firstNameCell.setPaddingLeft(4);
firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
firstNameCell.setFixedHeight(36f);
table.addCell(firstNameCell);

                PdfPCell cin = new PdfPCell(new Phrase(String.valueOf(candidat.getCin())));
cin.setVerticalAlignment(Element.ALIGN_MIDDLE);
cin.setHorizontalAlignment(Element.ALIGN_RIGHT);
cin.setPaddingRight(4);
table.addCell(cin);

                PdfPCell address = new PdfPCell(new Phrase(String.valueOf(candidat.getAdresse())));
address.setVerticalAlignment(Element.ALIGN_MIDDLE);
address.setHorizontalAlignment(Element.ALIGN_RIGHT);
address.setPaddingRight(4);
table.addCell(address);

                PdfPCell tele = new PdfPCell(new Phrase(String.valueOf(candidat.getTel())));
tele.setVerticalAlignment(Element.ALIGN_MIDDLE);
tele.setHorizontalAlignment(Element.ALIGN_RIGHT);
tele.setPaddingRight(4);
table.addCell(tele);

                PdfPCell numM = new PdfPCell(new Phrase(String.valueOf(candidat.getNumero_ministre())));
numM.setVerticalAlignment(Element.ALIGN_MIDDLE);
numM.setHorizontalAlignment(Element.ALIGN_RIGHT);
numM.setPaddingRight(4);
table.addCell(numM);

                PdfPCell categorie = new PdfPCell(new Phrase(String.valueOf(candidat.getCategorie_permis())));
categorie.setVerticalAlignment(Element.ALIGN_MIDDLE);
categorie.setHorizontalAlignment(Element.ALIGN_RIGHT);
categorie.setPaddingRight(4);
table.addCell(categorie);
                PdfPCell date_ins = new PdfPCell(new Phrase(String.valueOf(candidat.getDate_inscription())));
date_ins.setVerticalAlignment(Element.ALIGN_MIDDLE);
date_ins.setHorizontalAlignment(Element.ALIGN_RIGHT);
date_ins.setPaddingRight(4);
table.addCell(date_ins);
PdfPCell prix = new PdfPCell(new Phrase(String.valueOf(candidat.getPrix())));
prix .setVerticalAlignment(Element.ALIGN_MIDDLE);
prix .setHorizontalAlignment(Element.ALIGN_RIGHT);
prix .setPaddingRight(4);
table.addCell(prix );
                
            }
document.add(table);

document.close();
        }catch(DocumentException e) {
	logger.error(e.toString());
        }

		return new ByteArrayInputStream(out.toByteArray());
	}}


