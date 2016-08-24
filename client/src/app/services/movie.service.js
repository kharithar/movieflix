/**
 * Created by Haritha on 8/12/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];

    function movieService($http, $q, CONFIG) {

        var movieSer = this;

        movieSer.getMovies = getMovies;
        movieSer.getMovie = getMovie;
        movieSer.addMovie = addMovie;
        movieSer.getMovieList = getMovieList;
        movieSer.deleteMovie = deleteMovie;
        movieSer.addComment = addComment;

        function getMovies(type) {
            console.log('in get movies service');
            return $http.get(CONFIG.API_HOST + '/movies/findByType/'+type)
                .then(successFn, errorFn);
        }
        function getMovieList() {
            console.log('in get movies service');
            return $http.get(CONFIG.API_HOST + '/movies')
                .then(successFn, errorFn);
        }

        function getMovie(movieId) {
            console.log('in movie detail service');
            return $http.get(CONFIG.API_HOST + '/movies/' + movieId)
                .then(successFn, errorFn);
        }

        function addMovie(movie) {
            console.log(movie);
            return $http.post(CONFIG.API_HOST + '/movies/create',movie)
                .then(successFn,errorFn);
        }

        function deleteMovie(movieId) {
            console.log('in movie delete service');
            return $http.get(CONFIG.API_HOST + '/movies/delete' + movieId)
                .then(successFn, errorFn);
        }

        function addComment(comment) {
            console.log(comment);
            return $http.post(CONFIG.API_HOST + '/comments/add',comment)
                .then(successFn,errorFn);
        }
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();