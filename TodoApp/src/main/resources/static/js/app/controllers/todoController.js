angular.module('todoApp').controller("todoController", function ($scope,$log,todoService) {
	$scope.todos = [];
	$scope.todos  = todoService.getTodos().then(function(data){
		$scope.todos = data;
	},function(error){
		$scope.errorMsg = "No todos retrieved!";
	});

	$scope.enableAddButton = function () {
		$scope.disabled = $scope.todoText == null ? true : false
				if ($scope.disabled == false) {
					$scope.errorMsg = null;
				}
	};

	$scope.updateStatus = function (todo) {
		var index = $scope.todos.indexOf(todo);
		if (index > -1) {
			var markedTodo = $scope.todos[index];

			var newTodoToReplace = {
					"srNo": markedTodo.srNo,
					"text": markedTodo.text,
					"completed": 'Y',
					"cDate": new Date()
			};

			todoService.updateTodo(newTodoToReplace).then(function(status) {
				if(status!=200){
					$log.error("update failed!");
					$scope.errorMsg ="Status updation failed!";
				}else{
					markedTodo.completed = 'Y';
					markedTodo.cDate = new Date();
				}
			});
		} else {
			$scope.errorMsg = "Todo does not exist!";
		}
	};

	$scope.add = function () {
		var isExists = false;
		//var existingTodoTexts = $scope.todos.map((addedTodos) => addedTodos.text);
		todoService.isTodoExists($scope.todoText).then(function(result){
			if(!result){
				todoService.getLatestSrNo().then(function(data){
					var newTodo = {
							"srNo": data+1,
							"text": $scope.todoText,
							"completed": 'N',
							"cDate": ""
					};
					
					todoService.addTodo(newTodo).then(function(status){
						if(status==200){
							$scope.todos.push(newTodo);
							$scope.todoText = null;
					        $scope.enableAddButton();
						}else{
							$log.error("Todo creation failed!");
							$scope.errorMsg ="Todo creation failed!";
						}
					});
				});
			}else {
				$log.warn("Todo already exists!");
				$scope.errorMsg = "Todo already exists!";
				$scope.todoText = null;
		        $scope.enableAddButton();
			}
		});
	};
	
	$scope.delete = function (todo) {
		todoService.deleteTodo(todo).then(function(status){
			if(status==200){
				var index = $scope.todos.indexOf(todo);
				$scope.todos.splice(index, 1);
				$log.info("Todo with srNo "+todo.srNo + " deleted.");
			}else{
				$log.error("Todo with srNo "+todo.srNo + " could not be deleted.");
				$scope.errorMsg ="Todo deletion failed!"; 
			}
		});
	};
});