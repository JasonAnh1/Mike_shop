$('.delete').on('click', function(){
	$(this).closest('.container-product').remove();
});

function deleteCart(productId){
	let data = {
		productId : productId
	};
	$.ajax({
		url: "/ajax/deleteCart",
		type: "post",
		contentType:"application/json",
		data: JSON.stringify(data),
		dataType: "json",
		success: function(jsonResult) {
			$( "#cartIndex" ).html(jsonResult.totalItems);
			total();
		},
		error: function(jqXhr, textStatus, errorMessage) {
		}
	});
}

function nganSo(x){
    x = x.toString();
    var a = new Array();
    var dem = 0;
    for(let i = (x.length - 1); i >= 0; i--){
        if(dem == 3){
            a.push('.');
            dem = 0;
        }
        dem++;
        a.push(x[i]);
    }
    a.reverse();
    var y = "";
    for(let i = 0; i < a.length; i++){
        y += a[i];
    }
	y += ' đ';
    return y;
}

function total(){
    var total = 0;
    $('.sub-total').each(function(){
        var subTotal = $(this).text().trim();
		subTotal = subTotal.substring(0, subTotal.length - 2);
        subTotal = subTotal.replace(/\./g, '');
        subTotal = parseInt(subTotal);
		total += subTotal;
    });
    total = nganSo(total);
    $('.total').find('span').html(total);
}
total();


function changeQuantity(productId, price, t){
	var pt = $(t).val();
    var quantity = $(t).parent().find('input').val();
	if(pt == '+'){
		quantity++;
	}
	else if(quantity > 1){
		quantity--;
	}
	$(t).parent().find('input').val(quantity);
	$(t).closest('.content').find('.sub-total ').html(nganSo(quantity * price));
	total();
	let data = {
		productId : productId,
		quantity : quantity,
	};
	
	$.ajax({
		url: "/ajax/changeQuantity",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json",
		success: function(jsonResult) {
			$( "#cartIndex" ).html(jsonResult.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) {
		}
	});
}