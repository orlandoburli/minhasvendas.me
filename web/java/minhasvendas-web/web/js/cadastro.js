console.log("Carregando arquivo cadastro.js");

//var conteudoId = ".page-content-body";

var tempo = 250;

// Carrega uma pagina
function loadPage(pagina) {

	var params = {};

	$.ajax({
		url : pagina,
		type : 'GET',
		data : params,
		beforeSend : function(data) {
			console.log("loading...");
		},
		success : function(data) {
			$(conteudoId).html(data);

			// Carrega o js de consulta
			loadJs("web/js/consulta.js");

			// Foco no primeiro input (autofocus)
			$('input[autofocus],select[autofocus]').focus();
		},
		error : function(erro) {
			console.log("Erro no load ajax! " + erro);
		}
	});
}

// Carrega um arquivo .css
function loadCSS(href) {
	setTimeout(function() {
		var cssLink = $("<link>");
		$("head").append(cssLink); // IE hack: append before setting href

		cssLink.attr({
			rel : "stylesheet",
			type : "text/css",
			href : href
		}, tempo * 4);
	});
}

bindClickEvents();

// Funcao de salvar o registro
function salvar() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
	var paginaBase = paginaCadastro.split(".")[0];
	var operacao = $(".FormularioCadastro").attr("data-page-operacao");
	var paginaFinal = paginaBase + "." + operacao + "."
			+ paginaCadastro.split(".")[1];

	var params = {
		'operacao' : operacao
	};

	// Loop nos input's do form para enviar
	console.log("Parametros do metodo salvar");

	$("input,select,textarea").each(function(index) {
		params[$(this).attr("id")] = $(this).val();
		console.log($(this).attr("id") + ' = ' + $(this).val());
	});

	$.ajax({
		url : paginaFinal,
		type : 'POST',
		data : params,
		beforeSend : function(data) {
			// console.log("loading...");
		},
		success : function(data) {

			var retorno = $.parseJSON(data);

			if (retorno.sucesso) {
				mensagemInfo(retorno.mensagem);

				setTimeout(function() {
					voltar();
				}, 100);

			} else {
				mensagemErro(retorno.mensagem);
				$("#" + retorno.fieldFocus).focus();
			}

		},
		error : function(erro) {
			console.log("Erro no load ajax! " + erro);
		}
	});
}

// Funcao de excluir o registro
function excluirOld() {
	// confirmacaoModal("Confirma a exclusão deste registro?", "Confirmação",
	// excluirConfirmado);
}

function excluir() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
	var paginaBase = paginaCadastro.split(".")[0];
	var operacao = "excluir";
	var paginaFinal = paginaBase + "." + operacao + "."
			+ paginaCadastro.split(".")[1];

	var params = {
		'operacao' : operacao
	};

	// Loop nos input's do form para enviar
	$("input,select").each(function(index) {
		params[$(this).attr("id")] = $(this).val();
	});

	$.ajax({
		url : paginaFinal,
		type : 'POST',
		data : params,
		beforeSend : function(data) {
			// console.log("loading...");
		},
		success : function(data) {

			var retorno = $.parseJSON(data);

			if (retorno.sucesso) {
				mensagemInfo(retorno.mensagem);
				voltar();
			} else {
				mensagemErro(retorno.mensagem);
				$("#" + retorno.fieldFocus).focus();
			}
		},
		error : function(erro) {
			console.log("Erro no load ajax! " + erro);
		}
	});
}

// Volta para a pagina de consulta
function voltar() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		console.log("kd???" + $.active)
		return;
	}

	// Forca esconder o modal - pode ter varios aqui...
	$('#selecao_imagem').modal('hide');

	var pageConsulta = $(".FormularioCadastro").attr("data-page-consulta");

	loadPage(pageConsulta);
	loadJs("web/js/consulta.js");
}

// Funcao das teclas de cadastro
var eventoTeclasCadastro = function(event) {

	switch (event.which) {

	case (KEY_ESC):
		event.preventDefault();
		voltar();
		break;

	case (KEY_S):
		if (event.ctrlKey) {
			event.preventDefault();
			salvar();
		}
		break;

	case (KEY_DEL):
		if (event.ctrlKey) {
			event.preventDefault();
			excluir();
		}
		break;
	}
};

// Funcao keydown para tratar as teclas de cadastro
$(document).ready(function() {
	$(document).off("keydown");

	// Verifica se e uma tela de cadastro
	if ($(".FormularioCadastro")) {
		$(document).on("keydown", eventoTeclasCadastro);
	}
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
			nextBox.select();
			event.preventDefault();
			return false;
		} else {
//			$(".BotaoSalvar").click();
		}
	}
}

function bindClickEvents() {
	$(".BotaoSalvar").bind("click", function() {
		salvar();
	});

	$(".BotaoExcluir").bind("click", function() {
		excluir();
	});

	$(".BotaoVoltar").bind("click", function() {
		voltar();
	})
}