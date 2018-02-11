package za.co.techtest.restapi.v0;

import za.co.techtest.dto.EmployeeDetailsDto;
import za.co.techtest.exception.ServiceException;
import za.co.techtest.interfaces.service.ProcessCSVFileServiceInterface;
import za.co.techtest.service.ProcessCSVFileService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rchennupati on 1/26/18.
 */
@Path("v0/csvfile")
public class ProcessCSVFile {
    private static final Logger logger = Logger.getLogger(ProcessCSVFile.class.getName());

    @Path("getrecordlist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveRecordListFromCSVFile() {

        List<EmployeeDetailsDto> employeeDetailsDtoList = new ArrayList<EmployeeDetailsDto>();
        try{

            ProcessCSVFileServiceInterface csvFileService = new ProcessCSVFileService();
            employeeDetailsDtoList = csvFileService.readCsvFile("employeeDetails.csv");

       } catch(ServiceException se){
            logger.finest("Business: "+ se.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(se.getMessage()).build();
       } catch(Exception e){
            logger.finest("Exception: "+ e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        logger.info("Employee count before respond: "+ employeeDetailsDtoList.size());
        return Response.ok().entity(employeeDetailsDtoList).build();
    }
}
