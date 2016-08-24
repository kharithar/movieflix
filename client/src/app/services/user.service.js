(function() {
  'use strict';

  angular.module('movieflix')
    .service('userService', userService);

  userService.$inject = ['$http', '$q', 'CONFIG','$window'];

  function userService($http, $q, CONFIG,$window) {

    var self = this;

    self.getUsers = getUsers;
    self.getUserById = getUserById;
    self.addUser = addUser;
    self.findUser = findUser;
    //self.hasRole = hasRole;

    function getUsers() {
      return $http.get(CONFIG.API_HOST + '/users')
        .then(successFn, errorFn);
    }

    function getUserById(id) {
      return $http.get(CONFIG.API_HOST + '/users/' + id)
        .then(successFn, errorFn);
    }

    function addUser(user) {
      return $http.post(CONFIG.API_HOST + '/users/create',user)
          .then(successFn,errorFn);
    }

    function findUser(user) {
      console.log(user);
      var userInfo;
      return $http.post(CONFIG.API_HOST + '/users/login',user)
          .then(function(response){
            userInfo = {
              accessToken: response.data.token,
              userId: response.data.userId
            };
            $window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
            return response.data;
          },errorFn);
    }

    function deleteUser(id) {
      return $http.delete(CONFIG.API_HOST + '/users/delete/',id)
          .then(successFn,errorFn)
    }

    /**function hasRole(role) {
      console.log('in has role service');
      return $http.get(CONFIG.API_HOST + '/test/role/' + role)
          .then(function(response){
            console.log(response.data);
          },function(response) {
        return $q.reject('ERROR: ' + response.statusText);
      });
    }*/
    function successFn(response) {
      return response.data;
    }

    function errorFn(response) {
      return $q.reject('ERROR: ' + response.statusText);
    }
  }

})();