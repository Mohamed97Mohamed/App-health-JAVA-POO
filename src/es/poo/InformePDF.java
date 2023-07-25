package es.poo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InformePDF {
	
	/**Generacion del informe PDF
	 * 
	 * @param Usuario : String de método dameCadena con los datos del Usuario
	 * @param Actividades : String de método dameCadena con las actividades realizadas
	 * @param CambiosDePeso : String de método dameCadena con los cambios de peso
	 * @param Alias : Alias del usuario para ponerlo en el nombre del informe
	 * @throws FileNotFoundException : Cuando el archivo ya había sido creado y está abierto cuando se intenta crear
	 */
	
	public static void generacionPDF(String Usuario, String Actividades, String CambiosDePeso, String Alias) throws FileNotFoundException {
		
		Document document = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./informesPDF/InformePDF(" + Alias + ").pdf"));
			document.open();
			
			document.add(new Paragraph("Usuario:", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
			
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(105);
			table.setSpacingBefore(11f);
			table.setSpacingAfter(11f);
			float[] colWidth = {2f};
			table.setWidths(colWidth);
			
			PdfPCell c1 = new PdfPCell(new Paragraph(Usuario));
			table.addCell(c1);
			document.add(table);
			
			document.add(new Paragraph("Actividades:", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
			
			table = new PdfPTable(1);
			table.setWidthPercentage(105);
			table.setSpacingBefore(11f);
			table.setSpacingAfter(11f);
			table.setWidths(colWidth);
			
			c1 = new PdfPCell(new Paragraph(Actividades));
			table.addCell(c1);
			document.add(table);
			
			document.add(new Paragraph("Cambios de peso:", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.RED)));
			
			table = new PdfPTable(1);
			table.setWidthPercentage(105);
			table.setSpacingBefore(11f);
			table.setSpacingAfter(11f);
			table.setWidths(colWidth);
			
			c1 = new PdfPCell(new Paragraph(CambiosDePeso));
			table.addCell(c1);
			document.add(table);
			
			document.close();
			writer.close();
			
		}
		catch(DocumentException e) {
			e.printStackTrace();
		}
	}
}
