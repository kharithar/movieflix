(function() {
  'use strict';

  angular.module('movieflix')
    .controller('UsersController', UsersController);

  UsersController.$inject = ['userService'];

  function UsersController(userService) {
    var usersVm = this;

    usersVm.changeSort = changeSort;
    usersVm.deleteUser = deleteUser;

    init();

    function init() {
      console.log('UsersController');

      usersVm.sorter = {
        by: 'firstName',
        reverse: false
      };

      userService
        .getUsers()
        .then(function(users) {
          usersVm.users = users;
        }, function(error) {
          console.log(error);
        });
    }

    function deleteUser(id) {
        userService.deleteUser(id)
            .then(function(u){
                return u.id === id;
            },function(error) {
                console.log(error);
      });
    }

    function changeSort(prop) {
      usersVm.sorter.by = prop;
      usersVm.sorter.reverse = !usersVm.sorter.reverse;
    }
  }

})();