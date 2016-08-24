/**
 * Created by Haritha on 8/15/2016.
 */
(function(){
    'use strict';
    angular.module('movieflix')
        .controller('AddCommentController', AddCommentController);
    AddCommentController.inject = ['movieService', '$location','$scope'];

    function AddCommentController(movieService, $location, $scope){
        var commentVm = this;
        commentVm.addComment = addComment;

        function addComment(){
            console.log('in add comment');
            commentVm.newComment.movie.movieId = $scope.movieId;
            movieService.addComment(commentVm.newComment)
                .then(function(data){
                    $location.path('/movies');
                },function(error){
                    console.log(error);
                })
        }
    }
})();