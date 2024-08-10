package com.sportreservation.optimisationdeslivraison.Service;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Repositories.PartnerRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private PartnerRepository partnerRepository;

    public void saveExcelData(MultipartFile file) {
        try {
            List<Partner> partners = excelToPartners(file.getInputStream());
            partnerRepository.saveAll(partners);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store excel data: " + e.getMessage());
        }
    }

    private List<Partner> excelToPartners(InputStream is) throws IOException {
        List<Partner> partners = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        int rowNumber = 0;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // Skip header
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }

            Partner partner = new Partner();
            partner.setPartnerName(currentRow.getCell(0).getStringCellValue());
            partner.setLatitude(currentRow.getCell(1).getNumericCellValue());
            partner.setLongitude(currentRow.getCell(2).getNumericCellValue());
            partner.setAmount(currentRow.getCell(3).getNumericCellValue());
            partner.setWeight(currentRow.getCell(4).getNumericCellValue());
            partner.setVolume((float) currentRow.getCell(5).getNumericCellValue());

            partners.add(partner);
        }
        workbook.close();
        return partners;
    }
}
