$('.product-quantity button').on('click', function(){
    var pt = $(this).val();
    var sl = $(this).parent().find('input').val();
    if(pt == '+'){
        sl++;
    }
    else{
        if(sl > 1)
            sl--;
    }
    $(this).parent().find('input').val(sl);
});

$('.search').on('click', function(){
    $('.search-bar').css('margin-right', 0);
});

$('.close').on('click', function(){
    $('.search-bar').css('margin-right', '-500px');
});


function cart(productId, productQuantity){
	productQuantity = parseInt(productQuantity);
	let data = {
		productId : productId,
		quantity: productQuantity,
	};
	$.ajax({
		url: "/ajax/cart",
		type: "post",
		contentType:"application/json",
		data: JSON.stringify(data),
		dataType: "json",
		success: function(jsonResult) {
			$( "#cartIndex" ).html(jsonResult.totalItems);
			$([document.documentElement, document.body]).animate({
			    scrollTop: 0
			}, 200);
		},
		error: function(jqXhr, textStatus, errorMessage) {
		}
	});
}

/**
contact
 */

$('#contact').on('click', function(){
	var email = $(this).parent().parent().find('input').val();
	let data = {
		email : email	
	};
	$.ajax({
		url: "/ajax/contact",
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: "json",
		success: function(){
			$(this).parent().parent().find('input').val("");
		},
	});
});