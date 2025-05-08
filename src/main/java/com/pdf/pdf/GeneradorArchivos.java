package com.pdf.pdf;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorArchivos extends JFrame {

	private JTextField nombreField, apellidoField, edadField;

	public GeneradorArchivos() {
		setTitle("Generador de Archivos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 2, 10, 10));
		setSize(400, 250);

		nombreField = new JTextField();
		apellidoField = new JTextField();
		edadField = new JTextField();

		add(new JLabel("Nombre:"));
		add(nombreField);
		add(new JLabel("Apellido:"));
		add(apellidoField);
		add(new JLabel("Edad:"));
		add(edadField);

		JButton pdfButton = new JButton("Generar PDF");
		JButton excelButton = new JButton("Generar Excel");
		JButton textButton = new JButton("Generar Fichero");

		add(pdfButton);
		add(excelButton);
		add(textButton);

		pdfButton.addActionListener(e -> generarPDF());
		excelButton.addActionListener(e -> generarExcel());
		textButton.addActionListener(e -> generarTexto());

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void generarPDF() {
		String nombre = nombreField.getText();
		String apellido = apellidoField.getText();
		String edad = edadField.getText();

		Document document = new Document();
		try {
			LocalDateTime fecha = LocalDateTime.now();
			String fechaString = fecha.toString();
			String arrayFechas[] = fechaString.split(":");
			String nombreARchivoPdf = "src/main/resources/pdfs/salida_" + arrayFechas[0] + arrayFechas[1]
					+ LocalDateTime.now() + ".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(nombreARchivoPdf));
			document.open();
			document.add(new Paragraph("Datos Personales"));
			document.add(new Paragraph("Nombre: " + nombre));
			document.add(new Paragraph("Apellido: " + apellido));
			document.add(new Paragraph("Edad: " + edad));
			JOptionPane.showMessageDialog(this, "PDF generado correctamente.");
		} catch (Exception e) {

			generarError(e.toString());

		} finally {
			document.close();
		}
	}

	private void generarExcel() {
		String nombre = nombreField.getText();
		String apellido = apellidoField.getText();
		String edad = edadField.getText();

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Datos");
		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("Nombre");
		row.createCell(1).setCellValue("Apellido");
		row.createCell(2).setCellValue("Edad");

		Row dataRow = sheet.createRow(1);
		dataRow.createCell(0).setCellValue(nombre);
		dataRow.createCell(1).setCellValue(apellido);
		dataRow.createCell(2).setCellValue(edad);

		try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/salida.xlsx")) {
			workbook.write(fileOut);
			workbook.close();
			JOptionPane.showMessageDialog(this, "Excel generado correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generarTexto() {
		String nombre = nombreField.getText();
		String apellido = apellidoField.getText();
		String edad = edadField.getText();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/salida.txt"))) {
			writer.write("Nombre: " + nombre + "\n");
			writer.write("Apellido: " + apellido + "\n");
			writer.write("Edad: " + edad + "\n");
			JOptionPane.showMessageDialog(this, "Fichero de texto generado correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generarError(String error) {

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("src/main/resources/logs/error" + LocalDate.now() + ".txt"))) {
			writer.write("Error: " + error + "\n");
			writer.write(error);
			JOptionPane.showMessageDialog(this, "Ha habido un error. Mira los logs.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Asegúrate de tener iText y Apache POI en el classpath
		SwingUtilities.invokeLater(GeneradorArchivos::new);
	}
}
