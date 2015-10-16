angular.module('booksApp', [])
    .controller('BooksCtrl', function($scope, $http){
        $scope.books = [];

        $scope.findBooks = function () {
            $http.get("/books").success(function (data) {
                $scope.books = data;
            })
        };

        $scope.findBooks();

    });