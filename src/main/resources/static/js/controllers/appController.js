angular.module('TripComposer')
    .controller('appController', function ($scope, $http, $route)
    {
        $scope.message = "Type in echo and send request";

        $scope.data = [];
        $scope.cities = "Click on rows to display corresponding cities"

        $http.get('/show').success(function(res) {
            $scope.data = res;
        });

        $scope.sendRequest = function() {
            $http.get('/insert?echo=' + echo.value).success(function(res) {

                echo.value = "";

                $http.get('/show').success(function(res) {
                    $scope.data = res;
                });
            });
        };

        $scope.showCities = function(data) {
            $http.post('/showCities?id=' + data).success(function(res) {
                $scope.cities = "";

                var i = 0;

                angular.forEach(res, function(item){
                    $scope.cities += item;
                    i++;

                    if (i != res.length) {
                    $scope.cities += ", ";
                    }

                });
            });
        }
    });