angular.module('todoApp').controller("loginController", function ($scope,$rootScope,$location,$log,loginService) {
	$scope.login = function () {
		var user = {
				userId:$scope.userId,
				password:$scope.pwd
		};
		loginService.login(user).then(function(data){
			if(data!="" && $scope.userId===data.userId){
				$rootScope.user = data;
				$log.info("Login successful for userId:"+data.userId+" and "+"isCreateAllowed:"+data.role.isCreateAllowed+",isDeleteAllowed:"+data.role.isDeleteAllowed +",isUpdateAllowed:"+data.role.isUpdateAllowed);
				$location.path("/todo");
			}else{
			$log.error("Login failed for userId:"+$scope.userId+ ",password:"+ $scope.pwd);
			$scope.errorMsg ="Invalid userId or password!";
			$location.path("/home");
		} 
	},function(error){
		$scope.errorMsg = "Failed while authentication!";
	});
		/*if ("todouser" === $scope.userId && "todopwd" === $scope.pwd) {
			$log.info("Login successful");
			$location.path("/todo");
		}else{
			$log.error("Login failed for userId:"+$scope.userId+ ",password:"+ $scope.pwd);
			$scope.errorMsg ="Invalid userId or password!";
			$location.path("/home");
		}*/
};
$scope.checkLoginBttn = function () {
	if ($scope.userId == null) {
		$scope.userIdErrMsg = "Please enter userId!";
		$scope.loginDisabled = true;
	} else if ($scope.pwd == null) {
		$scope.pwdErrMsg = "Please enter password!";
		$scope.loginDisabled = true;
	} else {
		$scope.loginDisabled = false;
		$scope.userIdErrMsg = null;
		$scope.pwdErrMsg = null;
	}
};
//$scope.checkLoginBttn();
});