angular.module('TripComposer')
    .controller('appController', function ($scope, $http, $route)
    {
        $scope.message = "Type in echo and send request";

        data = [];

        $http.get('/show').success(function(res) {
            $scope.data = res;
        });

        $scope.sendRequest = function(data) {
            $http.get('/insert?echo=' + echo.value);

        $http.get('/show').success(function(res) {
           $scope.data = res;
        });

             $route.reload();
        };

    });