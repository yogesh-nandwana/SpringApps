angular.module('todoApp').
factory('todoService', function($http,$q) {

	var todoService = {};
	
	todoService.login = function (user){
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

	todoService.getTodos = function() {
		var deferred = $q.defer();
		return $http.get('/todo')
		.then(function(response) {
			// promise is fulfilled
			deferred.resolve(response.data);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			// promise is returned
			return deferred.promise;
		});
	};

	todoService.updateTodo = function(changedTodo){
		var deferred = $q.defer();
		return $http.put('/todo',JSON.stringify(changedTodo))
		.then(function(response) {
			// promise is fulfilled
			deferred.resolve(response.status);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			// promise is returned
			return deferred.promise;
		});
	};

	todoService.isTodoExists = function(todoTextToCheckExistanceFor){
		var deferred = $q.defer();
		return $http.get('/todo/'+todoTextToCheckExistanceFor)
		.then(function(response) {
			// promise is fulfilled
			deferred.resolve(response.data);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			// promise is returned
			return deferred.promise;
		});
	};

	todoService.getLatestSrNo = function(){
		var deferred = $q.defer();
		return $http.get('/todo/srNo')
		.then(function(response) {
			// promise is fulfilled
			deferred.resolve(response.data);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			// promise is returned
			return deferred.promise;
		});
	};

	todoService.addTodo = function(todoToAdd){
		var deferred = $q.defer();
		return $http.post('/todo',JSON.stringify(todoToAdd))
		.then(function(response) {
			// promise is fulfilled
			//$log.debug(JSON.stringify(response.data));
			deferred.resolve(response.status);
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

	todoService.deleteTodo = function(todo){
		var deferred = $q.defer();
		return $http.delete('/todo/'+todo.srNo)
		.then(function(response) {
			// promise is fulfilled
			deferred.resolve(response.status);
			// promise is returned
			return deferred.promise;
		}, function(response) {
			// the following line rejects the promise 
			deferred.reject(response);
			// promise is returned
			return deferred.promise;
		});
	};

	return todoService;
});