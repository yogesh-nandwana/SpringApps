angular.module('todoApp', ['ngRoute'])
.config(function($routeProvider){
	$routeProvider.
	when('/home', {
		templateUrl: '/views/loginWithBootstrap.html',
		controller: 'loginController'
	}).
	when('/todos', {
		templateUrl: '/views/todo.html',
		controller: 'todoController'
	}).
	otherwise({
		redirectTo: '/home'
	});
});