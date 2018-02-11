angular.module('employeeApp.controllers', []).controller('employeeController', ['$scope', 'employeeService', function ($scope, employeeService) {

    $scope.getEmployeeList = function () {
        console.log("Before calling rest service")

        employeeService.retrieveEmployeeList().success(function (response) {
            $scope.results = [];
            for (var i = 0; i < response.length; i++) {
                $scope.results.push(response[i]);
            }
        }).error(function (response) {
            console.log('response.error message statusCode=' + JSON.stringify(response));
            console.log('failed connecting to server');
        });
    };

    $scope.clearList = function () {
        $scope.results = [];
    };
}]);
