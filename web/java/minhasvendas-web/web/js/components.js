/**
 * Controle de componentes
 */

$(function () {
  $('.tooltips').tooltip();
});

// Funcao para input's numericos - Formata e coloca a mascara
$("input[data-field-type='number']").each(function() {
	var decimais = $(this).attr("data-field-precision");

	var valueNumber = parseFloat($(this).val());
	valueNumber = valueNumber * (Math.pow(10, decimais));

	$(this).val(valueNumber);

	$(this).priceFormat({
		clearPrefix : true,
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '',
		centsLimit : parseInt(decimais)
	});
});

$("input[data-field-type='date']").mask("00/00/0000");

$("input[data-field-type='cep']").mask("00000-000");

var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC", "C",
		"C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran", "Groovy",
		"Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python",
		"Ruby", "Scala", "Scheme" ];

// autocomplete
$("input.autocomplete").each(
		function(index) {
			var sourceURL = $(this).attr("data-remote-source");

			$(this).change(function() {
				$(this).attr("data-value", "");
			});

			$(this).autocomplete(
					{
						source : function(request, response) {
							$.ajax({
								url : sourceURL,
								type : "POST",
								dataType : "json",
								data : {
									query : request.term
								},
								success : function(data) {
									response(data);
								},
								error : function(erro, status, text) {
									console.log("Erro no load ajax! " + erro
											+ ", " + status + ", " + text);
								}
							});
						},
						minLenght : 1,
						select : function(event, ui) {
							$(this).attr("data-value",
									ui.item ? ui.item.id : "");
						},
						open : function() {
							$(this).removeClass("ui-corner-all").addClass(
									"ui-corner-top");
						},
						close : function() {
							$(this).removeClass("ui-corner-top").addClass(
									"ui-corner-all");
						}
					});
		});

// mascara dos telefones
var maskBehavior = function(val) {
	return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000'
			: '(00) 0000-00009';
}, options = {
	onKeyPress : function(val, e, field, options) {
		field.mask(maskBehavior.apply({}, arguments), options);
	}
};

$("input[data-field-type='fone']").mask(maskBehavior, options);

// Funcao ENTER funcionar como TAB em input's
textboxes = $("input:visible, select:visible, textarea:visible");

if (browser.mozilla) {
	$(textboxes).keypress(checkForEnter);
} else {
	$(textboxes).keydown(checkForEnter);
}

function checkForEnter(event) {
	if (event.keyCode == 13) {
		currentBoxNumber = textboxes.index(this);

		if (textboxes[currentBoxNumber + 1] != null) {
			nextBox = textboxes[currentBoxNumber + 1]
			nextBox.focus();
//			nextBox.select();
			event.preventDefault();
			return false;
		} else {
			$(".BotaoSalvar").click();
		}
	}
}