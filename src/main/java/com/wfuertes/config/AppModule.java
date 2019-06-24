package com.wfuertes.config;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.wfuertes.service.ReportPdfService;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Configuration.class)
                .toProvider(() -> {
                    Configuration cfg = new Configuration();
                    cfg.setClassForTemplateLoading(AppModule.class, "/reports");
                    cfg.setDefaultEncoding("UTF-8");
                    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                    return cfg;
                }).in(Scopes.SINGLETON);

        bind(ReportPdfService.class).in(Scopes.SINGLETON);
    }
}
