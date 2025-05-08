package com.pdf.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class CrearPDF {
	public static void main(String[] args) {
		String destino = "src/main/resources/documento.pdf";

		try {
			PdfWriter escritor = new PdfWriter(destino);
			PdfDocument pdf = new PdfDocument(escritor);
			Document documento = new Document(pdf);

			documento.add(new Paragraph("¡Hola mundo desde Java con iText 7!"));
			documento.close();

			System.out.println("PDF creado en: " + destino);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
