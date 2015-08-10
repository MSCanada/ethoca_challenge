function inventoryController($scope,dataService) {

dataService.HTTPCall().done(function(){
	//console.log(dataService.inventoryList);
	$scope.inventory_list=dataService.getInventory_List();
})

	$scope.addItem=function(index,quantity){
   dataService.addItem(index,quantity);
   
		}

$scope.gettotalitem=function(){
	return(dataService.gettotalitem());
	}

$scope.gettotalprice=function(){
	return(dataService.gettotalprice());
	}


$scope.saveinventory=function(){
dataService.saveinventory($scope.inventory_list);

};

$scope.modal=function(index){
	dataService.modal(index);
	}


}
 


