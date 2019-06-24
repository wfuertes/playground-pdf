package com.wfuertes.service;

import com.google.common.collect.ImmutableMap;
import com.wfuertes.config.MediaReplacedElementFactory;
import com.wfuertes.dto.BonusReport;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

public class ReportPdfService {

    private final Configuration freeMarker;

    @Inject
    public ReportPdfService(Configuration freeMarker) {
        this.freeMarker = freeMarker;
    }

    public void renderPdf(String bonusReportPath, BonusReport bonusReport) {
        try (final ByteArrayOutputStream templateOutput = new ByteArrayOutputStream();
             final FileOutputStream pdfOutput = new FileOutputStream(bonusReportPath)) {

            final Template template = freeMarker.getTemplate("bonus.ftl");
            template.process(ImmutableMap.builder()
                                         .put("report", bonusReport)
                                         .build(), new OutputStreamWriter(templateOutput));

            final ITextRenderer renderer = new ITextRenderer();
            renderer.getSharedContext()
                    .setReplacedElementFactory(new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));

            renderer.setDocumentFromString(new String(templateOutput.toByteArray()));
            renderer.layout();
            renderer.createPDF(pdfOutput, true);
        } catch (Exception err) {
            Logger.getAnonymousLogger().severe("Error when rendering report PDF: " + err.getLocalizedMessage());
            throw new RuntimeException((err));
        }
    }
}
