package org.design.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.design.model.MultiPartBody;
import org.design.model.UploadResponse;
import org.design.service.UploadService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("upload")
@Produces(MediaType.TEXT_PLAIN)
@Slf4j
public class UploadResource {

    @Inject
    UploadService uploadService;

    @GET
    @Path("excel-file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(@MultipartForm MultiPartBody multiPartBody) {

        return uploadService
                .uploadExcelFile(multiPartBody)
                .getResponse();

    }
}
