angular.module('employeeApp.services', []).factory('employeeService', function($http) {

    var employeeList = {};
    employeeList.retrieveEmployeeList = function () {
            return $http({
                method: "GET",
                url: "http://localhost:8080/csv-operational-services/restapi/v0/csvfile/getrecordlist"
            });
        }
        return employeeList;
    });
