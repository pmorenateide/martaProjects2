package com.pdf.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class EstilosPDF {
	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/estilos.pdf"));
			document.open();

			// Fuentes
			Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
			Font fontSubtitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.ITALIC, BaseColor.DARK_GRAY);
			Font fontTexto = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);

			// Elementos con estilo
			Paragraph titulo = new Paragraph("Título del Documento", fontTitulo);
			titulo.setAlignment(Element.ALIGN_CENTER);

			Paragraph subtitulo = new Paragraph("Subtítulo con estilo", fontSubtitulo);
			subtitulo.setSpacingBefore(10);
			subtitulo.setSpacingAfter(10);

			Paragraph cuerpo = new Paragraph("Este es un párrafo de texto con estilo personalizado.", fontTexto);

			// Agregar al documento
			document.add(titulo);
			document.add(subtitulo);
			document.add(cuerpo);

			document.close();
			System.out.println("PDF creado con estilos.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
