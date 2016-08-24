/**
 * Created by Haritha on 8/12/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('MovieListController',MovieListController);

    MovieListController.$inject=['movieService', '$location','$routeParams'];

    function MovieListController(movieService, $location, $routeParams) {
        var movieListVm = this;

        console.log('out of get movies');
        init();

        function init() {
            var userInfo;
            movieListVm.filterFields = [
                {
                    code: 'genre',
                    desc : 'Genre'
                },
                {
                    code : 'year',
                    desc : 'Year'
                }
            ];
            movieListVm.searchInput = '';
            movieListVm.filter = movieListVm.filterFields[0];
            /**if ($window.sessionStorage["userInfo"]) {
                userInfo = JSON.parse($window.sessionStorage["userInfo"]);
            }
            if (userInfo) {
            }*/
            movieListVm.sorter = {
                    sortBy: 'imdbRating.rating',
                    sortOrder: false
            };
             console.log('in get movies');
             getMovies();

        }
        function getMovieList(){
            movieService.getMovieList()
                .then(function (data) {
                    movieListVm.movies = data;
                }, function (error) {
                    console.log(error);
                })
        }
        function getMovies() {
            movieService.getMovies($routeParams.type)
                .then(function (data) {
                    movieListVm.movies = data;
                }, function (error) {
                    console.log(error);
                })
        }

        function deleteMovie() {
            movieService.deleteMovie($routeParams.id)
                .then(function (data) {
                    getMovies();
                }, function (error) {
                    console.log(error);
                })
        }
            console.log('out of get movies..');

    }
})();
