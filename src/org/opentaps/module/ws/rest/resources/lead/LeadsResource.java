package org.opentaps.module.ws.rest.resources.lead;

import org.ofbiz.base.util.Debug;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Locale;
//import java.util.List;

import org.apache.wink.common.annotations.Workspace;

import org.opentaps.foundation.infrastructure.User;
import org.opentaps.foundation.service.ServiceException;
import org.opentaps.module.ws.rest.resources.common.CommonResource;
import org.opentaps.module.ws.rest.resources.common.CommonResponse;


@Path(LeadsResource.MAIN_URL)
@Workspace(workspaceTitle = "REST API", collectionTitle = "Leads")
public class LeadsResource extends CommonResource {

    private static String MODULE = LeadsResource.class.getName();
    public static final String MAIN_URL = "/leads";

    @Context HttpHeaders requestHeaders;

    public LeadsResource() {
        super();
    }


    @GET
    @Consumes({MediaType.WILDCARD})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_XML})
    public Response getLeads() {
        // TODO change to hasAccess(getCredentials(requestHeaders))
        if (!checkAccess(requestHeaders)) {
            CommonResponse response = new CommonResponse("error", "403 Forbidden.");
            return Response.status(Response.Status.FORBIDDEN).entity(response).build();
        }

        User assignedTo = user;

        try {
            LeadsServices leadsServices = new LeadsServices(infrastructure, assignedTo, Locale.getDefault());
            leadsServices.findLeads();
        } catch (ServiceException e) {
            // TODO catch here
        }

        CommonResponse response = new CommonResponse("success", "Everything is OK, you'll get leads soon.");
        return Response.status(Response.Status.OK).entity(response).build();
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_XML})
    public Response createLead(LeadAsset asset, @Context UriInfo uriInfo) {
        if (!checkAccess(requestHeaders)) {
            CommonResponse response = new CommonResponse("error", "403 Forbidden.");
            return Response.status(Response.Status.FORBIDDEN).entity(response).build();
        }

        LeadBean lead = asset.getLead();
/*
        if (lead == null) {
            Debug.logError("AK47 - The content of the lead is missing", MODULE);
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
            ResponseBean response = new ResponseBean("error", "403 Forbidden.");
            return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }
*/

        User assignedTo = user;

        try {
            assignedTo = getUser(lead.getAssignedTo());
        } catch (WebApplicationException e) {
            Debug.logError("Can't find user: " + e.getMessage(), MODULE);
            // TODO if used is not found, assign to API user, somebody has to be notified about that,
            // TODO return Notice/Warning message via API
        }

//        String assignedTo = lead.getAssignedTo();
//        User responsibleUser = getUser("alex");

        try {
            LeadsServices leadsServices = new LeadsServices(infrastructure, assignedTo, Locale.getDefault());
            leadsServices.createLead(lead);
        } catch (ServiceException e) {
            Debug.logError("Creation of a lead failure: " + e.getMessage(), MODULE);

            CommonResponse response = new CommonResponse("error", "Creation of a lead failure: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }

        Debug.logInfo("AK47 - lead ID: " + lead.getId(), MODULE);

//        URI location = uriInfo.getAbsolutePathBuilder().segment(lead.getId()).build();

//        ResponseBean response = new ResponseBean("success", "Lead has been created, new lead ID: " + lead.getId());
//        return Response.status(Response.Status.CREATED).entity(response).build();

        return Response.status(Response.Status.CREATED).entity(asset)
//            .location(location)
            .tag(new EntityTag(String.valueOf(lead.hashCode()))).build();
    }

}
