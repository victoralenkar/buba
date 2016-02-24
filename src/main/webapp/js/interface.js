$(function(){
	
	// Add Class Active Menu
	$('header > div.container > div.row:last-child ul.nav li a.ui-menuitem-link').click(function() {
		$(this).addClass('active');
	});
	
});