package com.pdf.pdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

public class PdfCOnimagenes {
	public static void main(String[] args) {
		try {
			// Ruta del archivo PDF de salida
			String destino = "src/main/resources/imagen_ejemplo.pdf";

			// Ruta de la imagen (local o URL)
			String rutaImagen = "src/main/resources/images/logoTeide.jpg";

			// Crear documento PDF
			PdfWriter writer = new PdfWriter(destino);
			PdfDocument pdfDoc = new PdfDocument(writer);
			Document document = new Document(pdfDoc);

			// Crear la imagen
			ImageData imageData = ImageDataFactory.create(rutaImagen);
			Image imagen = new Image(imageData);

			// (Opcional) Redimensionar o alinear
			imagen.setWidth(300); // ancho en puntos
			imagen.setAutoScale(true); // escala automática al ancho disponible

			// Añadir imagen al documento
			document.add(imagen);

			// Cerrar el documento
			document.close();
			System.out.println("PDF creado con la imagen.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
