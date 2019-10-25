package com.epam.springadvanced.services;

import com.epam.springadvanced.entities.SubscriberModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfGenerator {
    public ByteArrayInputStream convertSubscriberToPdf(List<SubscriberModel> subscriberModels) throws DocumentException {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{1, 3, 3});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Id", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Name", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Population", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        for (SubscriberModel sub : subscriberModels) {

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(sub.getId()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(sub.getFirstName()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(sub.getSecondName())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(sub.getPhoneNumberModel())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setPaddingRight(5);
            table.addCell(cell);
        }

        PdfWriter.getInstance(document, out);
        document.open();
        document.add(table);

        document.close();


        return new ByteArrayInputStream(out.toByteArray());
    }
}

