(function() {
  'use strict';

  angular
    .module('movieflix')
    .constant('CONFIG', {
      'API_HOST': 'http://localhost:8090/movieflix/api'
    });

})();