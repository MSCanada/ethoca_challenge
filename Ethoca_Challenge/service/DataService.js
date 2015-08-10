app.service("dataService", function($http) {

var inventoryList;

this.getInventory_List=function(){
try {
if((localStorage.inventorylist)=="" || (localStorage.inventorylist)==null)	{
return inventoryList;
}
else{
	inventoryList=JSON.parse(localStorage.inventorylist);
return JSON.parse(localStorage.inventorylist);

}
}
catch(err) {
	
}
}

this.addItem=function(index,quantity){
inventoryList[index].quantity=inventoryList[index].quantity+quantity;
localStorage.inventorylist=JSON.stringify(inventoryList);

}



this.HTTPCall=function(){
var deferred=$.Deferred();
$http.get("https://ethocacart.herokuapp.com/Inventory.htm").success(function(response){
	inventoryList=response;
	console.log(inventoryList);
	//localStorage.inventorylist=JSON.stringify(inventoryList);
	deferred.resolve();
})
return deferred.promise();
};



this.gettotalitem=function(){
	var totalitem=0;
angular.forEach(this.getInventory_List(), function(value, key) {
  totalitem=totalitem+value.quantity;
})
return totalitem;
}

this.gettotalprice=function(){
	var totalprice=0;
angular.forEach(this.getInventory_List(), function(value, key) {
  totalprice=totalprice+(value.quantity*value.price);
});

return totalprice;
}

this.saveinventory=function(inventory_List){
	
	localStorage.inventorylist=JSON.stringify(inventory_List);
}


this.clearItems=function(){
angular.forEach(inventoryList, function(value, key) {
value.quantity=0;
localStorage.inventorylist=JSON.stringify(inventoryList);

})
}

this.modal=function(index){
	var modal_title=inventoryList[index].name;
	var modal_body=inventoryList[index].description;
	var image_url=inventoryList[index].ImageURL;
	console.log(modal_title);
	console.log(modal_body);
	$('.modal-title').text(modal_title);
	$('.modal-body span').text(modal_body);
	$(".modal-body img").attr("src",image_url);
	$('#myModal').modal('show');



}


 
});



