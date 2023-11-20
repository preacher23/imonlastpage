package com.verinite.bookstore.serviceimpl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.verinite.bookstore.entity.Delivery;
import com.verinite.bookstore.entity.Invoice;
import com.verinite.bookstore.entity.InvoiceDatabaseEntity;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.entity.PdfEntity;
import com.verinite.bookstore.repository.InvoiceDatabaseRepository;
import com.verinite.bookstore.repository.InvoiceRepo;
import com.verinite.bookstore.service.InvoicePDFService;
import com.verinite.bookstore.service.InvoiceService;

@Service
public class InvoiceImpl {
	static ByteArrayOutputStream baos = new ByteArrayOutputStream();
	static String PdfFileName = null;
	static int invNo = 0, payment_id = 0;
	@Autowired
	InvoiceRepo repo;

	public Invoice createPDF(List<PdfEntity> list, String username) {
		List<PdfEntity> dataList = list;
		String cname = null;
		String pincode = null, country = null, state = null, city = null, mobno = null;
		double totalAmnt = 0;
		Date ordate = null;
		List productDetails = new ArrayList<>();
		for (PdfEntity pdfEntity : dataList) {
			invNo = pdfEntity.getInvoice_id();
			cname = pdfEntity.getCustomer_name().toUpperCase();
			pincode = pdfEntity.getPincode();
			country = pdfEntity.getCountry();
			city = pdfEntity.getCity();
			state = pdfEntity.getState();
			totalAmnt = pdfEntity.getAmount();
			mobno = pdfEntity.getMobile_number();
			payment_id = pdfEntity.getPayment_id();
			ordate = pdfEntity.getOrdered_date();
		}
		PdfFileName = "GeneratedInvoice/BSINV" + payment_id + " " + username.toUpperCase() + ".pdf";
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(ordate);

		try {
			OutputStream file = new FileOutputStream(new File(PdfFileName));
			Document document = new Document();
			PdfWriter.getInstance(document, file);

			PdfPTable irdTable = new PdfPTable(2);
			irdTable.addCell(getIRDCell("Invoice No"));
			irdTable.addCell(getIRDCell("Invoice Date"));
			irdTable.addCell(getIRDCell("BSINV" + invNo)); // pass invoice number
			irdTable.addCell(getIRDCell(date)); // pass invoice date

			PdfPTable irhTable = new PdfPTable(3);
			irhTable.setWidthPercentage(100);

			irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
			irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
			irhTable.addCell(getIRHCell("Invoice", PdfPCell.ALIGN_RIGHT));
			irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
			irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
			PdfPCell invoiceTable = new PdfPCell(irdTable);
			invoiceTable.setBorder(0);
			irhTable.addCell(invoiceTable);

			FontSelector fs = new FontSelector();
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD);
			fs.addFont(font);
			Phrase bill = fs.process("Bill To"); // customer information
			Paragraph name = new Paragraph(cname);
			name.setIndentationLeft(20);
			Paragraph contact = new Paragraph(mobno);
			contact.setIndentationLeft(20);
			Paragraph address = new Paragraph(city + "\n" + state + "-" + pincode + "\n" + country);
			address.setIndentationLeft(20);

			PdfPTable billTable = new PdfPTable(6); // one page contains 15 records
			billTable.setWidthPercentage(100);
			billTable.setWidths(new float[] { 1, 2, 5, 2, 1, 2 });
			billTable.setSpacingBefore(30.0f);
			billTable.addCell(getBillHeaderCell("Index"));
			billTable.addCell(getBillHeaderCell("Order Id"));
			billTable.addCell(getBillHeaderCell("Book Title"));
			billTable.addCell(getBillHeaderCell("Unit Price"));
			billTable.addCell(getBillHeaderCell("Qty"));
			billTable.addCell(getBillHeaderCell("Amount"));
			int i = 1;
			for (PdfEntity pdfEntity : dataList) {
				billTable.addCell(getBillRowCell(i + ""));
				billTable.addCell(getBillRowCell("OD" + pdfEntity.getOrder_id()));
				billTable.addCell(getBillRowCell(pdfEntity.getBook_title()));
				billTable.addCell(getBillRowCell(pdfEntity.getBook_price() + ""));
				billTable.addCell(getBillRowCell(pdfEntity.getBook_qty() + ""));
				billTable.addCell(getBillRowCell((pdfEntity.getBook_price() * pdfEntity.getBook_qty()) + ""));
				i++;
			}

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			billTable.addCell(getBillRowCell(" "));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));
			billTable.addCell(getBillRowCell(""));

			PdfPTable validity = new PdfPTable(1);
			validity.setWidthPercentage(100);
			validity.addCell(getValidityCell(" "));
			validity.addCell(getValidityCell("Note"));
			validity.addCell(getValidityCell(" *Computer Gernarated Invoice no Siganture required *"));
			PdfPCell summaryL = new PdfPCell(validity);
			summaryL.setColspan(3);
			summaryL.setPadding(1.0f);
			billTable.addCell(summaryL);

			PdfPTable accounts = new PdfPTable(2);
			accounts.setWidthPercentage(100);
			accounts.addCell(getAccountsCell("Subtotal"));
			accounts.addCell(getAccountsCellR(totalAmnt + ""));
			accounts.addCell(getAccountsCell("Discount (0%)"));
			accounts.addCell(getAccountsCellR("0"));
			accounts.addCell(getAccountsCell("Tax(0%)"));
			accounts.addCell(getAccountsCellR("0"));
			accounts.addCell(getAccountsCell("Total"));
			accounts.addCell(getAccountsCellR(totalAmnt + ""));
			PdfPCell summaryR = new PdfPCell(accounts);
			summaryR.setColspan(3);
			billTable.addCell(summaryR);

			document.open();

			document.add(irhTable);
			document.add(bill);
			document.add(name);
			document.add(contact);
			document.add(address);
			document.add(billTable);
			document.close();
			file.close();
		

			System.out.println("Pdf created successfully..");

			File pdfFile = new File(PdfFileName);
			try {
				byte[] fileContent = Files.readAllBytes(pdfFile.toPath());

				String encodedPdf = Base64.getEncoder().encodeToString(fileContent);
				Invoice inv = new Invoice();
				inv.setEncodedPdf(encodedPdf.getBytes());
				inv.setPaymentId(payment_id);

				return inv;
			} catch (IOException e) {
				throw new IllegalStateException("could not read file " + PdfFileName, e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setHeader() {

	}

	public static PdfPCell getIRHCell(String text, int alignment) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 16);
		/* font.setColor(BaseColor.GRAY); */
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setPadding(5);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getIRDCell(String text) {
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		cell.setBorderColor(BaseColor.LIGHT_GRAY);
		return cell;
	}

	public static PdfPCell getBillHeaderCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		return cell;
	}

	public static PdfPCell getBillRowCell(String text) {
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		return cell;
	}

	public static PdfPCell getBillFooterCell(String text) {
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(5.0f);
		cell.setBorderWidthBottom(0);
		cell.setBorderWidthTop(0);
		return cell;
	}

	public static PdfPCell getValidityCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorder(0);
		return cell;
	}

	public static PdfPCell getAccountsCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorderWidthRight(0);
		cell.setBorderWidthTop(0);
		cell.setPadding(5.0f);
		return cell;
	}

	public static PdfPCell getAccountsCellR(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorderWidthLeft(0);
		cell.setBorderWidthTop(0);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(5.0f);
		cell.setPaddingRight(20.0f);
		return cell;
	}

	public static PdfPCell getdescCell(String text) {
		FontSelector fs = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		font.setColor(BaseColor.GRAY);
		fs.addFont(font);
		Phrase phrase = fs.process(text);
		PdfPCell cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorder(0);
		return cell;
	}

}
