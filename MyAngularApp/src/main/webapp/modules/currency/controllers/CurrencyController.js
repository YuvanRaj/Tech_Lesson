var myfirstApp = angular.module("MyFirstApp", [ 'ngGrid', 'finance3',
		'myServiceModule' ]);

myfirstApp.controller('GreetingController', [ '$scope', 'notify',
		function($scope, notify) {
			$scope.greeting = 'Hola!';
			$scope.callNotify = function(msg) {
				notify(msg);
			};
		} ]);


myfirstApp.directive('textEditor', function() {
	return {
		restrict : 'E',
		template : '<B>Hi Im ur Directive</B>'
	};
});


	     
// Controller Configuration
myfirstApp
		.controller(
				'myFirstAppController',
				[
						'$scope',
						'$http',
						'currencyConverter',
						function($scope, $http, currencyConverter) {

							// currency logic code
							this.qty = 1;
							this.cost = 2;
							this.inCurr = 'EUR';
							this.currencies = currencyConverter.currencies;

							this.total = function total(outCurr) {
								return currencyConverter.convert(this.qty
										* this.cost, this.inCurr, outCurr);
							};
							this.pay = function pay() {
								window.alert("Thanks!");
							};

							$scope.req = {};
							$scope.myAmount = 15696;

							$scope.services = [ {
								name : 'red',
								shade : 'dark'
							}, {
								name : 'green',
								shade : 'light'
							}, {
								name : 'blue',
								shade : 'dark'
							} ];

							$scope.service = $scope.services[2]; // red

							$scope.filterOptions = {
								filterText : '',
								useExternalFilter: true
							};
							
							$scope.names = ["Yuvaraj","Kholi","Dhoni"];

							$scope.findroot = function() {
								$http
										.post(
												"http://localhost:8080/services/BaseRequest/getRoot",
												$scope.req)
										.success(
												function(response) {
													$scope.userInformationList = response;
												});
							};

							$scope.searchbyname = function() {
								$http
										.get(
												"http://localhost:8080/services/BaseRequest/getName")
										.success(
												function(response) {
													$scope.userInformationList = response;
												});
							};
							
							$scope.searchbyod = function() {
								$http.post("http://localhost:8080/services/BaseRequest/getBookingInfo",$scope.req)
									.success(
									function(response) {
										$scope.bookingInfoList = response;
									});
							};

							$scope.calculatexpense = function() {
								$http
										.post(
												"http://localhost:8080/services/BaseRequest/getExpenses",
												$scope.req)
										.success(
												function(response) {
													$scope.userInformationList = response;
												});
							};

							$scope.gridOptions = {
								data : 'bookingInfoList',
								columnDefs: [{field: 'origin', displayName: 'Origin'},
						                     {field:'destination', displayName:'Destination'},
						                     {field:'arrivalDate',displayName:'ArrivalDate'}],
						        enablePinning: true,
								filterOptions : $scope.filterOptions
							};

							$scope.filterName = function() {
								if (angular.isDefined($scope.name)
										&& $scope.name !== null) {
									$scope.filterOptions.filterText = $scope.name;
								} else if (angular.isDefined($scope.origin)
										&& $scope.origin !== null) {
									$scope.filterOptions.filterText = $scope.origin;
								} else if (angular
										.isDefined($scope.destination)
										&& $scope.destination !== null) {
									$scope.filterOptions.filterText = $scope.destination;
								}
							};

						} ]);