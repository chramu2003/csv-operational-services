package za.co.techtest.interfaces.service;

import za.co.techtest.dto.EmployeeDetailsDto;
import za.co.techtest.exception.ServiceException;

import java.util.List;

/**
 * Created by rchennupati on 1/26/18.
 */
public interface ProcessCSVFileServiceInterface {

    public List<EmployeeDetailsDto> readCsvFile(String fileName) throws ServiceException;
}
