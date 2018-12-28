angular.module('todoApp', ['ngRoute'])
.config(function($routeProvider){
	$routeProvider.
	when('/home', {
		templateUrl: '/views/login1.html',
		controller: 'loginController'
	}).
	when('/todo', {
		templateUrl: '/views/todo.html',
		controller: 'todoController'
	}).
	otherwise({
		redirectTo: '/home'
	});
});