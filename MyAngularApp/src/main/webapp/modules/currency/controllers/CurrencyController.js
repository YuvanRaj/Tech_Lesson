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
								filterText: "",
								useExternalFilter: false
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
							$scope.totalServerItems = 0;
						    $scope.pagingOptions = {
						        pageSizes: [250, 500, 1000],
						        pageSize: 250,
						        currentPage: 1
						    };
						    
						    $scope.setPagingData = function(data, page, pageSize){	
						        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
						        $scope.bookingInfoList = pagedData;
						        $scope.totalServerItems = data.length;
						        if (!$scope.$$phase) {
						            $scope.$apply();
						        }
						    };
						    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
						        setTimeout(function () {
						            var data;
						            if (searchText) {
						                var ft = searchText.toLowerCase();
						                $http.get('jsonFiles/largeLoad.json').success(function (largeLoad) {		
						                    data = largeLoad.filter(function(item) {
						                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
						                    });
						                    $scope.setPagingData(data,page,pageSize);
						                });            
						            } else {
						                $http.get('jsonFiles/largeLoad.json').success(function (largeLoad) {
						                    $scope.setPagingData(largeLoad,page,pageSize);
						                });
						            }
						        }, 100);
						    };
							
						    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
							
						    $scope.$watch('pagingOptions', function (newVal, oldVal) {
						        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
						          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
						        }
						    }, true);
						    $scope.$watch('filterOptions', function (newVal, oldVal) {
						        if (newVal !== oldVal) {
						          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
						        }
						    }, true);
						    
							$scope.gridOptions = {
								data : 'bookingInfoList',
								columnDefs: [{field: 'origin', displayName: 'Origin'},
						                     {field:'destination', displayName:'Destination'},
						                     {field:'arrivalDate',displayName:'ArrivalDate'}],
			                     enablePaging: true,
			             		 showFooter: true,
			                     totalServerItems: 'totalServerItems',
			                     pagingOptions: $scope.pagingOptions,
			                     filterOptions: $scope.filterOptions
							};

							
							$scope.filterName = function() {
								if (angular.isDefined($scope.req.origin)
										&& $scope.req.origin !== null) {
									$scope.filterOptions.filterText = $scope.req.origin;
								} else if (angular.isDefined($scope.req.destination)
										&& $scope.req.destination !== null) {
									$scope.filterOptions.filterText = $scope.req.destination;
								}
							};
							

						} ]);