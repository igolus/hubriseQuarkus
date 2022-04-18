package com.latoquemagique.pages;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("redirect")
public class RedirectPage {
    @Inject
    Template redirect;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(String uri) {
        return redirect.data("redirectUrl", uri);
    }
}
