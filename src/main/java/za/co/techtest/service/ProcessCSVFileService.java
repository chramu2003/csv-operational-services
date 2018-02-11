package za.co.techtest.service;

import za.co.techtest.dto.EmployeeDetailsDto;
import za.co.techtest.exception.ServiceException;
import za.co.techtest.interfaces.service.ProcessCSVFileServiceInterface;

import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by rchennupati on 1/26/18.
 */
public class ProcessCSVFileService implements ProcessCSVFileServiceInterface {
    private static final Logger logger = Logger.getLogger(ProcessCSVFileService.class.getName());
    public List<EmployeeDetailsDto> readCsvFile(String fileName) throws ServiceException {

        List<EmployeeDetailsDto> employeeList = new ArrayList<EmployeeDetailsDto>();

        try{
            logger.info("CSV file name: "+ fileName);
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            Stream<String> lines = Files.lines(path);
            lines.skip(1).forEach(line -> {populateRecord(line, employeeList);
            });
            lines.close();
            
        } catch (Exception e){
            throw new ServiceException(e);
        }
        logger.info("Employee count: "+ employeeList.size());
        return employeeList;
    }

    private void populateRecord(String csvRecord,  List<EmployeeDetailsDto> employeeList){

        logger.info("Split CSV record on space basis");
        String[] details = csvRecord.split("\\s");
        EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();

        employeeDetailsDto.setEmployeeNumber(details[0]);
        employeeDetailsDto.setFirstName(details[1]);
        employeeDetailsDto.setLastName(details[2]);
        employeeDetailsDto.setIdType(details[3]);
        employeeDetailsDto.setIdNumber(details[4]);
        employeeDetailsDto.setEmail(details[5]);

        employeeList.add(employeeDetailsDto);
    }
}
