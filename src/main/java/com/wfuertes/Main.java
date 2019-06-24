package com.wfuertes;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.wfuertes.config.AppModule;
import com.wfuertes.dto.Bonus;
import com.wfuertes.dto.BonusReport;
import com.wfuertes.service.ReportPdfService;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new AppModule());
        final ReportPdfService reportPdfService = injector.getInstance(ReportPdfService.class);

        // Report data
        final BonusReport reportData = new BonusReport(
                "Person Jones",
                "jones@person.com",
                Arrays.asList(
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-01", "Description 001", BigDecimal.valueOf(1000)),
                        new Bonus("2019-06-10", "Description 002", BigDecimal.valueOf(2000)),
                        new Bonus("2019-06-15", "Description 003", BigDecimal.valueOf(3000)),
                        new Bonus("2019-06-20", "Description 004", BigDecimal.valueOf(4000))
                ));

        // Rendering to PDF
        final String reportPath = System.getProperty("java.io.tmpdir") + "/bonus-report.pdf";
        reportPdfService.renderPdf(reportPath, reportData);
    }
}
