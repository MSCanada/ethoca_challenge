var app=angular.module('ShoppingStore',[]);
 app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/index', {
        templateUrl: 'view/inventory_list.html',
        controller: inventoryController 
      }).
      when('/purchase', {
        templateUrl: 'view/purchase.html',
        controller: purchaseController
      }).
      otherwise({
        redirectTo: '/index'
      });
}]);


