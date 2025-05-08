package com.pdf.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

public class PdfContablas {
	public static void main(String[] args) {
		try {
			PdfWriter writer = new PdfWriter("src/main/resources/tabla_itext.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			// Crear tabla con 3 columnas
			Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();

			// Encabezados
			table.addHeaderCell("Nombre");
			table.addHeaderCell("Edad");
			table.addHeaderCell("Ciudad");

			// Filas
			table.addCell("Ana");
			table.addCell("28");
			table.addCell("Madrid");

			table.addCell("Luis");
			table.addCell("35");
			table.addCell("Bogotá");

			table.addCell("Sofía");
			table.addCell("22");
			table.addCell("Buenos Aires");

			document.add(table);
			document.close();

			System.out.println("PDF con tabla creado (iText).");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}