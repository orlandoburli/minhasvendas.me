/**
 * Controle de componentes
 */

$('.tooltips').tooltip();

// Funcao para input's numericos - Formata e coloca a mascara
$("input[data-field-type='number']").each(function() {
	var decimais = $(this).attr("data-field-precision");

	var valueNumber = parseFloat($(this).val());
	valueNumber = valueNumber * (Math.pow(10, decimais));
	
	valueNumber = parseInt(valueNumber);
	
	$(this).val(valueNumber);

	$(this).priceFormat({
		clearPrefix : true,
		prefix : '',
		centsSeparator : ',',
		thousandsSeparator : '',
		centsLimit : parseInt(decimais)
	});
});

$("input[data-field-type='cpf']").mask("000.000.000-00");

$("input[data-field-type='date']").mask("00/00/0000");

$("input[data-field-type='cep']").mask("00000-000");

//mascara dos telefones
var maskCpfCnpj = function(val) {
	return val.replace(/\D/g, '').length <= 11 ? '000.000.000-00'
			: '00.000.000/0000-00';
}, optionsCpfCnpj = {
	onKeyPress : function(val, e, field, options) {
		field.mask(maskCpfCnpj.apply({}, arguments), options);
	}
};

$("input[data-field-type='cpfcnpj']").mask(maskCpfCnpj, optionsCpfCnpj);

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
									if (debug) {
										console.log("Erro no load ajax! " + erro + ", " + status + ", " + text);	
									}
								}
							});
						},
						minLenght : 1,
						select : function(event, ui) {
							$(this).attr("data-value", ui.item ? ui.item.id : "");
						},
						open : function() {
							$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
						},
						close : function() {
							$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
						}
					});
		});

function itemFormatResult(item) {
    return item.label;
}

function itemFormatSelection(item) {
    return item.label;
}

function adicionarRapido(dados, urlRapido, inputRetorno) {
	if (debug) {
		console.log("Cadastro rapido em \"" + urlRapido + "\" para o valor \"" + dados + "\"");
	}
	var params = {
		operacao : 'rapido',
		term : dados
	};

	// Loop nos input's do form para enviar
	if (debug) {
		console.log("Parametros do metodo rapido");	
	}

	$.ajax({
		url : urlRapido,
		type : 'POST',
		data : params,
		beforeSend : function(data) {
			if (debug) {
				console.log("executando \"rapido\"...");	
			}
		},
		success : function(data) {

			var retorno = $.parseJSON(data);

			if (retorno.sucesso) {
				mensagemInfo(retorno.mensagem);
				
				if (debug) {
					console.log(retorno);
				}
				
				// Seta o retorno
				$("#" + inputRetorno).select2("val", retorno.objeto[inputRetorno]);
				$("#" + inputRetorno).select2("close");
				
				if (debug) {
					console.log("Fim...");
				}
				
			} else {
				mensagemErro(retorno.mensagem);
				$("#" + retorno.fieldFocus).focus();
			}

		},
		error : function(erro) {
			if (debug) {
				console.log("Erro no load ajax! " + erro);
			}
		}
	});
}

$(".select2").each(function(index) {
	
	var nomeAtributo = $(this).attr("id");
	var sourceURL = $(this).attr("data-remote-source");
	var adicionarRapidoUrl = $(this).attr("data-cadastro-rapido");
	
	if (!adicionarRapidoUrl) {
		adicionarRapidoUrl = "";
	}

	$(this).select2({
        placeholder: "Digite para pesquisar...",
        minimumInputLength: 1,
        width: "resolve",
        ajax: {
            url: sourceURL,
            dataType: 'json',
            data: function (term, page) {
                return {
                    query: term
                };
            },
            results: function (data, page) {
            	return {
                    results: data.results
                };
            }
        },
        formatNoMatches: function(term) {
        	return "<span>Sem resultados para sua busca por \"" + term + "\" Clique <a href=\"javascript:void(0)\"  onclick=\"adicionarRapido('" + term + "', '" + adicionarRapidoUrl + "', '" + nomeAtributo + "');\">aqui</a> para adicionar.</span>";
        },
        formatSearching: function() {
        	return "Pesquisando...";
        },
        formatInputTooShort: function(term, minLength) {
        	var caracterString = "caracter";
        	if (minLength > 1) {
        		caracterString+= "es";
        	}
        	return "Informe pelo menos " + minLength + " "+caracterString+"  para iniciar a pesquisa.";
        },

        initSelection: function (element, callback) {
        	// Selecao unica
            var id = $(element).val();
            if (id !== "") {
                $.ajax(sourceURL, {
                    data: {
                        idSource : id
                    },
                    dataType: "json"
                }).done(function (data) {
                	if (debug) {
                		console.log(data);
                	}
                    callback(data.results[0]);
                });
            }
        },
        formatResult: itemFormatResult,
        formatSelection: itemFormatSelection,
        dropdownCssClass: "bigdrop", // apply css that makes the dropdown taller
        escapeMarkup: function (m) {
            return m;
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
textboxes = $(".FormularioCadastro").find("input:visible, select:visible, textarea:visible");

if (browser.mozilla) {
	$(textboxes).keypress(checkForEnter);
} else {
	$(textboxes).keydown(checkForEnter);
}

function checkForEnter(event) {
	if (event.keyCode == 13) {
		currentBoxNumber = textboxes.index(this);

		if (textboxes[currentBoxNumber + 1] != null) {
			if (debug) {
				console.log("Keydown em " + $(textboxes[currentBoxNumber]).attr("id"));
			}
			if ($(textboxes[currentBoxNumber]).attr("data-skip-enter") != "true") {
				nextBox = textboxes[currentBoxNumber + 1]
				nextBox.focus();
	//			nextBox.select();
				event.preventDefault();
				return false;
			}
		}
	}
}

/*     
 * Add collapse and remove events to boxes
 */
$("[data-widget='collapse']").click(function() {
    //Find the box parent        
    var box = $(this).parents(".box").first();
    //Find the body and the footer
    var bf = box.find(".box-body, .box-footer");
    if (!box.hasClass("collapsed-box")) {
        box.addClass("collapsed-box");
        //Convert minus into plus
        $(this).children(".fa-minus").removeClass("fa-minus").addClass("fa-plus");
        bf.slideUp();
    } else {
        box.removeClass("collapsed-box");
        //Convert plus into minus
        $(this).children(".fa-plus").removeClass("fa-plus").addClass("fa-minus");
        bf.slideDown();
    }
});

function formataInput(input) {
	if (!input) {
		return;
	}
	
	// Formatacao de numeros
	if ($(input).attr("data-field-type") == "number") {
		
		var decimais = $(input).attr("data-field-precision");

		var valueNumber = parseFloat($(input).val());
		
		valueNumber = valueNumber * (Math.pow(10, decimais));
		
		valueNumber = parseInt(valueNumber);
		
		$(input).val(valueNumber);

		$(input).priceFormat({
			clearPrefix : true,
			prefix : '',
			centsSeparator : ',',
			thousandsSeparator : '',
			centsLimit : parseInt(decimais)
		});
	}
}

$(document).ready(function() {
	// Para widgets que devem começar escondidos
	$(".init-collapsed").each(function(index) {
		var box = $(this);
	    //Find the body and the footer
	    var bf = box.find(".box-body, .box-footer");
	    
	    box.addClass("collapsed-box");
        //Convert minus into plus
        $(this).children(".fa-minus").removeClass("fa-minus").addClass("fa-plus");
        bf.slideUp();
	});
	
	if (debug) {
    	$("input,select,textarea").on("focus", function() {
    		console.log("Foco em " + $(this).attr("id"));
    	});        	
    }
});


