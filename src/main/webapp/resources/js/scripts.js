/**
 * Funções 
 */
jQuery.fn.ForceNumericOnly =
function()
{
    return this.each(function()
    {
        $(this).keydown(function(e)
        {
            var key = e.charCode || e.keyCode || 0;
            // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
            // home, end, period, and numpad decimal
            return (
                key == 8 || 
                key == 9 ||
                key == 13 ||
                key == 46 ||
                key == 110 ||
                key == 190 ||
                (key >= 35 && key <= 40) ||
                (key >= 48 && key <= 57) ||
                (key >= 96 && key <= 105));
        });
    });
};
erro = {
	add : function(campo, msg) {
		$(campo).parent().addClass("has-error");
		$(campo).siblings(".help-block").text(msg);
		$(campo).focus(function() {
			erro.clear(campo);
		});
	},

	clear : function(campo) {
		$(campo).parent().removeClass("has-error");
		$(campo).siblings(".help-block").text("");
	},

};

message = {

	success : function(msg) {
		alert = '<div class="alert alert-success" role="alert">'
				+ '<strong>Sucesso!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	info : function(msg) {
		alert = '<div class="alert alert-info" role="alert">'
				+ '<strong>Info!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	error : function(msg) {
		alert = '<div class="alert alert-danger" role="alert">'
				+ '<strong>Erro!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	clean : function() {
		$('div.alert').remove();
	},

	get : function(cod, param) {
		var url = "message?cod=" + cod;
		var retorno = null;
		if (param != null || param != "")
			url += "&param=" + param;
		$.ajax({
			url : url,
			type : 'GET',
			async : false,
			success : function(resp) {
				retorno = resp;
			}
		});
		return retorno;
	}
};