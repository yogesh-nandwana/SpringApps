angular.module('todoApp').
factory('loginService', function($http,$q) {

	var loginService = {};

	loginService.login = function (user){
		var deferred = $q.defer();
		return $http.post('/login',JSON.stringify(user))
		.then(function(response) {
			// promise is fulfilled
			//$log.debug(JSON.stringify(response.data));
			deferred.resolve(response.data);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			//$log.error('response status: '+response.status);
			// promise is returned
			return deferred.promise;
		});
	};

	return loginService;
});