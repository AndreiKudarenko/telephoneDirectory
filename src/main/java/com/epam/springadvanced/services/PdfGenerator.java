package com.epam.springadvanced.services;

import com.epam.springadvanced.dto.PhoneNumberData;
import com.epam.springadvanced.dto.SubscriberData;
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

    public ByteArrayInputStream convertSubscriberToPdf(List<SubscriberData> subscribers) throws DocumentException {
        PdfPTable table = createSubscriberTable();
        for (SubscriberData sub : subscribers) {
            fillTable(sub, table);
        }
        ByteArrayOutputStream out = getByteArrayOutputStream(table);
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream convertSubscriberToPdf(SubscriberData subscriber) throws DocumentException {
        PdfPTable table = createSubscriberTable();
        fillTable(subscriber, table);
        ByteArrayOutputStream out = getByteArrayOutputStream(table);
        return new ByteArrayInputStream(out.toByteArray());
    }

    private ByteArrayOutputStream getByteArrayOutputStream(PdfPTable table) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();
        document.add(table);
        document.close();
        return out;
    }

    private PdfPTable createSubscriberTable() {

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        addColumn("Name", table);
        addColumn("Phone - ProviderCompany", table);
        return table;
    }

    private void addColumn(String name, PdfPTable table) {
        PdfPCell hcell;
        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        hcell = new PdfPCell(new Phrase(name, headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
    }

    private void fillTable(SubscriberData subscriber, PdfPTable table) {
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(subscriber.getName()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setPaddingLeft(5);
        table.addCell(cell);

        StringBuilder stringBuilder = new StringBuilder();
        subscriber.getNumbers().forEach(num -> stringBuilder.append(num.getNumber() + " - " + num.getProviderCompanyData().getName() + "\n"));
        cell = new PdfPCell(new Phrase(stringBuilder.toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);
    }
}

