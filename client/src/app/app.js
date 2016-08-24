(function() {
  'use strict';

  angular
    .module('movieflix', ['ngMessages','ngRoute'])
    .config(moduleConfig)
      .run();
  moduleConfig.$inject=['$routeProvider'];
  function moduleConfig($routeProvider) {
console.log($routeProvider);
    $routeProvider
      .when('/users', {
        templateUrl: 'app/views/users.tmpl.html',
        controller: 'UsersController',
        controllerAs: 'usersVm'
      })
      .when('/users/:id', {
        templateUrl: 'app/views/user-detail.tmpl.html',
        controller: 'UserDetailController',
        controllerAs: 'userDetailVm'
      })
      .when('/add-user', {
        templateUrl: 'app/views/add-user.tmpl.html',
        controller: 'AddUserController',
        controllerAs: 'addUserVm'
        })
        .when('/user-login', {
          templateUrl: 'app/views/user-login.tmpl.html',
          controller: 'UserLoginController',
          controllerAs: 'userLoginVm'
        })
        .when('/delete-user/:id', {
          templateUrl: 'app/views/users.tmpl.html',
          controller: 'DeleteUserController',
          controllerAs: 'deleteUsersVm'
        })
      .when('/movies/:type', {
        templateUrl: 'app/views/movies.tmpl.html',
        controller: 'MovieListController',
        controllerAs: 'movieListVm'
      })
        .when('/movies', {
          templateUrl: 'app/views/movies.tmpl.html',
          controller: 'MovieListController',
          controllerAs: 'movieListVm'
        })
      .when('/add-movie', {
        templateUrl: 'app/views/add-movie.tmpl.html',
        controller: 'AddMovieController',
        controllerAs: 'addMovieVm'
        })
      .when('/movie-detail/:id', {
        templateUrl: 'app/views/movie-detail.tmpl.html',
        controller: 'MovieDetailController',
        controllerAs: 'movieVm'
        })
        .when('/add-comment',{
        templateUrl: 'app/views/add-comment.tmpl.html',
        controller: 'AddCommentController',
        controllerAs: 'commentVm'
    })
        .when('/welcome',{
          templateUrl: 'app/views/welcome.tmpl.html'
        })
      .otherwise({
        redirectTo: '/add-user'
      });
  }

})();