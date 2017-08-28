var myfirstApp=angular.module("MyFirstApp",['ngGrid']);



//Controller Configuration
myfirstApp.controller('myFirstAppController',['$scope','$http',function($scope,$http){


$scope.services = [
                 {name:'red', shade:'dark'},
                 {name:'green', shade:'light'},
                 {name:'blue', shade:'dark'}
               ];

$scope.service = $scope.services[2]; // red	
	
$scope.filterOptions = {
	filterText: ''
};
	
$scope.searchbyname=function() {
	$http.get("http://localhost:8080/services/BaseRequest/getName")
	.success(function(response) {
		$scope.userInformationList = response;
	});
};

$scope.gridOptions = { 
	data: 'userInformationList',
	filterOptions: $scope.filterOptions
};

$scope.filterName = function() {
	if(angular.isDefined($scope.name) && $scope.name !== null) {
     $scope.filterOptions.filterText = $scope.name;
	}
	else if(angular.isDefined($scope.origin) && $scope.origin !== null){
		$scope.filterOptions.filterText = $scope.origin;	
	}
	else if(angular.isDefined($scope.destination) && $scope.destination !== null){
		$scope.filterOptions.filterText = $scope.destination;	
	}
 };

}]);