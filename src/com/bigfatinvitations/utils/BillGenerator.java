package com.bigfatinvitations.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class BillGenerator {

	
	//private String fileName=new CreatePdf()+"";  
	  private static Font tittle1 = new Font(Font.FontFamily.HELVETICA, 14,
	      Font.BOLD);
	  private static Font tittle2 = new Font(Font.FontFamily.HELVETICA, 12,
		      Font.BOLD);
	  private static Font con = new Font(Font.FontFamily.COURIER, 11,
		      Font.NORMAL);
	  private static Font conNote = new Font(Font.FontFamily.COURIER, 10,
		      Font.NORMAL);
	  private static Font refc = new Font(Font.FontFamily.COURIER, 6,
		      Font.NORMAL);
	  private int responseLength;
	  
	  
	  public  InputStream createPdf(String form)
	  {
		  System.out.println("hello World");
		  Document document = new Document();
	      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	      InputStream inputStream=null;
			/*try {
			      
			      PdfWriter.getInstance(document, buffer);
			      document.open();
			      addMetaData(document);
			      addContent(document,form);
			      document.close();
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
			    byte[] bytes = null;
				bytes = buffer.toByteArray();
				responseLength=bytes.length;
				if (bytes != null) {
					inputStream = new ByteArrayInputStream(bytes);
				}
			    System.out.println("success");
			    */return inputStream;
	  }
	  private static void addMetaData(Document document) {
		    document.addTitle("Form1c");
		    document.addSubject("Using iText");
		    document.addKeywords("Form1c, PDF, iText");
		    document.addAuthor("Lars Vogel");
		    document.addCreator("Lars Vogel");
		  }
	  private static void addContent(Document document,String form) throws DocumentException {
		  	
		  	 Paragraph heading = new Paragraph(13,"FORM-1C\n(Prescribed under rule 3)", tittle1);
			 heading.setAlignment(Element.ALIGN_CENTER);
			 document.add(heading);
			 Paragraph line = new Paragraph();
			 addEmptyLine(line, 1);
			 document.add(line);
			 Paragraph headLine=new Paragraph(15,"Application for permission to construct, extent or take into use any building as a factory\n ",tittle2);
			 document.add(headLine);
			 String s;
			 line = new Paragraph();
			 addEmptyLine(line, 1);
			 document.add(line);
			 s="Date:"+DateFormat.getDateInstance(DateFormat.SHORT).format(new Date())+"                                                                                           Signature of Applicant";
			 Paragraph footer=new Paragraph(s,tittle2);
			 document.add(footer);	
			 document.add(line);
			 s="Note: This application shall be accompanied by the following documents:\n";
			 Paragraph note=new Paragraph(14,s,conNote);
			 document.add(note);
			 line = new Paragraph();
			 addEmptyLine(line, 1);
			 document.add(line);
			 s="(a) A flow chart of the manufacturing process supplemented by a brief description of";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="    process in its various stages.";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="(b) Plans, in triplicate, drawn to scale, showing __";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="    (i) The site of the factory and immediate surrounding including adjacent building ";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="        another structures, roads, drains etc. and ";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="    (ii)The plans, elevation and necessary cross sections of the various building, ";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="        indicating all relevant details relating to natural lighting,ventilation and";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="        means of escape in case of fire. The plan shall also clearly indicate the ";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="        position of the plant and machinery aisles and passage ways and ";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
			 s="(c) Such other particulars as the Chief inspector may require.";
			 note=new Paragraph(14,s,conNote);
			 document.add(note);
	  }
	  private static void addEmptyLine(Paragraph paragraph, int number) {
		    for (int i = 0; i < number; i++) {
		      paragraph.add(new Paragraph(" "));
		    }
		  }
	  public void setResponseLength(int responseLength) {
			this.responseLength = responseLength;
		}

		public int getResponseLength() {
			return responseLength;
		}
}
