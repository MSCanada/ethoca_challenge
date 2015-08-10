function PayPalButton(inventory_list){
	var cnt=1;
	$('#form').remove();	
var f = document.createElement("form");
f.setAttribute('method',"post");
f.setAttribute('action',"https://www.sandbox.paypal.com/cgi-bin/webscr");
f.setAttribute('id',"form");
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
z.setAttribute('value',"msuhail@uwaterloo.ca");



f.appendChild(i);
f.appendChild(s);
f.appendChild(z);

angular.forEach(inventory_list, function(value, key) {
 if(value.quantity>0){
 	var p = document.createElement("input"); //input element, Submit button
p.setAttribute('type',"hidden");
p.setAttribute('name',"item_name_"+(cnt));
p.setAttribute('value',value.name);
f.appendChild(p);

var q = document.createElement("input"); //input element, Submit button
q.setAttribute('type',"hidden");
q.setAttribute('name',"quantity_"+(cnt));
q.setAttribute('value',value.quantity);
f.appendChild(q);

var t = document.createElement("input"); //input element, Submit button
t.setAttribute('type',"hidden");
t.setAttribute('name',"amount_"+(cnt++));
t.setAttribute('value',value.price);
f.appendChild(t);
 }
})
var t = document.createElement("button"); //input element, Submit button

t.setAttribute('value',"press");
t.className="btn btn-block btn-link";
f.appendChild(t);

//and some more input elements here
//and dont forget to add a submit button

document.getElementsByTagName('body')[0].appendChild(f);
$('.btn.btn-block.btn-link').append('<img src="https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif" />'); 

}