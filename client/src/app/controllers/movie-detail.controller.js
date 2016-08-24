/**
 * Created by Haritha on 8/12/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams','$scope'];

    function MovieDetailController(movieService, $routeParams,$scope) {
        var movieVm = this;
        movieVm.addComment = addComment;
        $scope.loading = false;

        init();

        function init() {
            console.log('in movie detail controller');
            movieService
                .getMovie($routeParams.id)
                .then(function(data) {
                    movieVm.movie = data;
                    $scope.movieId = data.movieId;
                    console.log($scope.movieId);
                }, function(error) {
                    console.log(error);
                });
            console.log('exit movie detail controller');
        }

        function addComment(){
            var movieId = null;
            console.log('in add comment');
            console.log($scope.movieId);
            console.log(movieVm.newComment.comments);
            movieVm.newComment.commentList($index).movie.movieId = $scope.movieId;
            movieService.addComment(movieVm.newComment.commentList)
                .then(function(data){
                    $location.path('/movies');
                },function(error){
                    console.log(error);
                })
        }
    }
})();