package com.latoquemagique.pages;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.latoquemagique.util.Constants.CONNECT_HUBRISE_PAGE_URL;

@Path(CONNECT_HUBRISE_PAGE_URL)
public class ConnectHubrisePage {
    @Inject
    Template connect;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return connect.instance();
    }
}
