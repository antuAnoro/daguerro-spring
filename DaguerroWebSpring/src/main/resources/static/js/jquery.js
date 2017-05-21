$(".nav li").click(function(event){
	// Le quito la clase active al resto
	$(".nav li").removeClass("active");

	// Se lo pongo a mi elemento
	$(this).addClass("active");
}); 

