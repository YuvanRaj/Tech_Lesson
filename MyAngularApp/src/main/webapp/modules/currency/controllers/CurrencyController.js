var myfirstApp=angular.module("MyFirstApp",['ngGrid','finance3']);



//Controller Configuration
myfirstApp.controller('myFirstAppController',['$scope','$http','currencyConverter',function($scope,$http,currencyConverter){


// currency logic code
this.qty = 1;
this.cost = 2;
this.inCurr = 'EUR';
this.currencies = currencyConverter.currencies;

this.total = function total(outCurr) {
return currencyConverter.convert(this.qty * this.cost, this.inCurr, outCurr);
};
this.pay = function pay() {
window.alert("Thanks!");
};

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