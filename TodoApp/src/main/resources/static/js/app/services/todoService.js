angular.module('todoApp').
factory('todoService', function($http,$q) {

	var todoService = {};

	todoService.getTodos = function() {
		var deferred = $q.defer();
		return $http.get('/todos')
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
		return $http.put('/todos',changedTodo)
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
		return $http.get(`/todos/${todoTextToCheckExistanceFor}`) //using backtick ES6 here
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
		return $http.get('/todos/srno/max')
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
		return $http.post('/todos',todoToAdd)
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
		return $http.delete(`/todos/${todo.srNo}`) //using backtick ES6 here
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