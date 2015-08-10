function purchaseController($scope,dataService) {

dataService.HTTPCall().done(function(){
	//console.log(dataService.inventoryList);
	$scope.inventory_list=dataService.getInventory_List();
	
})

	$scope.addItem=function(index,quantity){
   dataService.addItem(index,quantity);
   
		}

$scope.gettotalitem=function(){
	PayPalButton($scope.inventory_list);
	return(dataService.gettotalitem());

	}

$scope.gettotalprice=function(){
	return(dataService.gettotalprice());
	}


$scope.saveinventory=function(){
dataService.saveinventory($scope.inventory_list);
};


$scope.clearItems=function(){
dataService.clearItems();	

}


}
 


