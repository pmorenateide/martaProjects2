package com.pdf.pdf;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;

public class EstilosPDFiText7 {
	public static void main(String[] args) {
		try {
			String destino = "estilos_itext7.pdf";
			File archivo = new File(destino);
//			archivo.getParentFile().mkdirs();

			PdfWriter writer = new PdfWriter(destino);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			// Fuentes
			PdfFont fontTitulo = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
			PdfFont fontSubtitulo = PdfFontFactory.createFont(StandardFonts.TIMES_ITALIC);
			PdfFont fontTexto = PdfFontFactory.createFont(StandardFonts.COURIER);

			// Título
			Paragraph titulo = new Paragraph("Título Principal").setFont(fontTitulo).setFontSize(20)
					.setFontColor(ColorConstants.BLUE).setTextAlignment(TextAlignment.CENTER);

			// Subtítulo
			Paragraph subtitulo = new Paragraph("Este es el subtítulo").setFont(fontSubtitulo).setFontSize(14)
					.setFontColor(ColorConstants.DARK_GRAY).setMarginTop(10).setMarginBottom(10);

			// Texto
			Paragraph texto = new Paragraph("Este es un párrafo con fuente Courier, tamaño 12, color negro.")
					.setFont(fontTexto).setFontSize(12).setFontColor(ColorConstants.BLACK)
					.setTextAlignment(TextAlignment.JUSTIFIED);

			// Agregar al documento
			document.add(titulo);
			document.add(subtitulo);
			document.add(texto);

			document.close();
			System.out.println("PDF con estilos creado usando iText 7.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
