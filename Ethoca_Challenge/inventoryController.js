function inventoryController($scope,$http,dataService) {
dataService.value1=JSON.parse(localStorage.inventorylist);
	if(dataService.value1=="" || dataService.value1==null){
	
	$http
	.success(function(response){
		$scope.inventory_list=response;
		//console.log($scope.inventory_list);
	//console.log($scope.gettotalitem());
	
	});
}

else{
$scope.inventory_list=dataService.getInventoryList();
}

	$scope.addItem=function(index,quantity){
	$scope.inventory_list[index].quantity=$scope.inventory_list[index].quantity+quantity;
dataService.value1=$scope.inventory_list;
	}


$scope.gettotalitem=function(){
		var totalitem=0;
angular.forEach($scope.inventory_list, function(value, key) {
  totalitem=totalitem+value.quantity;
})
localStorage.inventorylist=$scope.inventory_list;
//console.log(localStorage.scope);
$scope.saveinventory();
return totalitem;
	}


$scope.gettotalprice=function(){
	var totalprice=0;
angular.forEach($scope.inventory_list, function(value, key) {
  totalprice=totalprice+(value.quantity*value.price);
});
$scope.createform();
return totalprice;
}




$scope.saveinventory=function(){
localStorage.inventorylist=JSON.stringify(dataService.value1);

};

$scope.createform=function(){
var f = document.createElement("form");
f.setAttribute('method',"post");
f.setAttribute('action',"https://www.sandbox.paypal.com/cgi-bin/webscr");

var i = document.createElement("input"); //input element, text
i.setAttribute('type',"hidden");
i.setAttribute('name',"cmd");
i.setAttribute('value',"_cart");

var s = document.createElement("input"); //input element, Submit button
s.setAttribute('type',"hidden");
s.setAttribute('name',"upload");
s.setAttribute('value',"1");

var z = document.createElement("input"); //input element, Submit button
z.setAttribute('type',"hidden");
z.setAttribute('name',"business");
z.setAttribute('value',"accounts@freelanceswitch.com");



f.appendChild(i);
f.appendChild(s);
f.appendChild(z);
angular.forEach($scope.inventory_list, function(value, key) {
 if(value.quantity>0){
 	var p = document.createElement("input"); //input element, Submit button
p.setAttribute('type',"hidden");
p.setAttribute('name',"item_name_"+(key+1));
p.setAttribute('value',value.name);
f.appendChild(p);

var q = document.createElement("input"); //input element, Submit button
q.setAttribute('type',"hidden");
q.setAttribute('name',"quantity_"+(key+1));
q.setAttribute('value',value.quantity);
f.appendChild(q);

var t = document.createElement("input"); //input element, Submit button
t.setAttribute('type',"hidden");
t.setAttribute('name',"amount_"+(key+1));
t.setAttribute('value',value.price);
f.appendChild(t);
 }
})
var t = document.createElement("input"); //input element, Submit button
t.setAttribute('type',"submit");

t.setAttribute('value',"press");
f.appendChild(t);
//and some more input elements here
//and dont forget to add a submit button

document.getElementsByTagName('body')[0].appendChild(f);
console.log(f);
}




}
 


