function SaveContact(){
	let data = {
		name: jQuery("#name").val(),
		email: jQuery("#email").val(),
	};
	jQuery.ajax({
		url: "/ajax/contact",//action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		
		dataType: "json",
		success: function(jsonResult){
			alert("chuc mung"+ jsonResult.message.email);
		},
		error: function(jqXhr, textStatus,erroMessage){
			
		}
	});
}
function SaveNewsletter(){
	let data = {
		email: jQuery("#email").val(),
		
	};
	jQuery.ajax({
		url: "/ajax/index",//action
		type: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		
		dataType: "json",
		success: function(jsonResult){
			alert("chuc mung"+ jsonResult.message.email);
		},
		error: function(jqXhr, textStatus,erroMessage){
			
		}
	});
}
function deleteProduct(id){
    jQuery.ajax({
        url: "/admin/ajax/delete/product/"+id,
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        success: function (jsonValue){
            alert("Xóa thành công !!");
        },
        error: function(jqXhr, textStatus, errorMessage) {
           
                alert("Sản phẩm này đã không hoạt động !!");
            
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
/**Detail SaleOrder */
function detail(id){
	$.ajax({
		url: "/admin/ajax/detailSaleOrder/" + id,
		type: "POST",
		contentType: "application/json",
		success: function(jsonResult){
			$('#detailSaleOrder').html('');
			var i = 1;
			console.log(jsonResult);
			for(let item of jsonResult){
				let price = nganSo(item['price']);
				let detail = `
					<tr>
						<td>${i}</td>
						<td>
							<img src="/uploads/${item['path']}" width="100" height="100">
						</td>
						<td>${item['name']}</td>
						<td>${item['quantity']}</td>
						<td>${price}</td>
					</tr>
				`;
				i++;
				$('#detailSaleOrder').append(detail);
			}
		},
		error: function(){
			alert('loi');
		}
	});
}








