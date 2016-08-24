/**
 * Created by Haritha on 8/13/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('AddMovieController', AddMovieController);
    AddMovieController.inject = ['movieService', '$location'];

    function AddMovieController(movieService, $location, $scope){
        var addMovieVm = this;
        addMovieVm.addMovie = addMovie;
        init();
        function init() {

        }
        function addMovie(){
            movieService.addMovie(addMovieVm.newMovie)
                .then(function(data){
                    $location.path('/movies');
                },function(error){
                    console.log(error);
                })
        }
    }
})();