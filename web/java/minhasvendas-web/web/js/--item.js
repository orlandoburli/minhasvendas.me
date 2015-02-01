// Funcao que limpa as linhas selecionadas da grid
function limparSelecao() {
	$(".DataGridConsulta > table > tbody > tr").each(function(index) {
		$(this).attr("data-selected", "false");
		$(this).attr("class", "");
	});
}

// Retorna o id da linha selecionada
function getSelectedDataId() {
	var retorno = null;

	$(".DataGridConsulta > table > tbody > tr").each(function(index) {
		if ($(this).attr("data-selected") == "true") {
			retorno = $(this).attr("data-id");
		}
	});
	return retorno;
}

function getPageSize() {
	return parseInt($(".DataGridConsulta").attr("data-page-size"));
}

// Retorna a linha selecionada
function getSelectedIndex() {
	var retorno = -1;

	$(".DataGridConsulta > table > tbody > tr").each(function(index) {
		if ($(this).attr("data-selected") == "true") {
			retorno = index;
		}
	});
	return retorno;
}

// Altera a linha selecionada
function setSelectedIndex(selectedIndex) {
	limparSelecao();

	$(".DataGridConsulta > table > tbody > tr").each(function(index) {
		if (index == selectedIndex) {
			$(this).attr("data-selected", "true");
			$(this).attr("class", "btn-primary");
		}
	});
}

function loadDataGrid(funcaoSucesso) {
	// Se tiver alguma requisicao rolando, nao executa.
//	if ($.active > 0) {
//		return;
//	}
	
	console.log("Load grid...");

	blockConteudo(".DataGridConsulta");

	var paginaGrid = $(".DataGridConsulta").attr("data-page");
	var pageSize = $(".DataGridConsulta").attr("data-page-size");
	var pageNumber = $(".DataGridConsulta").attr("data-page-number");

	console.log("pageSize: " + pageSize);

	if (!pageNumber) {
		pageNumber = 1;
	}

	var params = {
		'PageNumber' : pageNumber,
		'PageSize' : pageSize
	};

	// Loop nos input's do form para enviar
	$("input,select").each(function(index) {
		params[$(this).attr("id")] = $(this).val();
		console.log($(this).attr("id") + ' = ' + $(this).val());
	});

	$.ajax({
		url : paginaGrid,
		type : 'POST',
		data : params,
		beforeSend : function(data) {
			// console.log("loading...");
		},
		success : function(data) {
			$(".DataGridConsulta").html(data);

			limparSelecao();

			setSelectedIndex(0);
			
			// Carrega as funcoes de componente
			loadJs("web/js/components.js");
			
			if (funcaoSucesso) {
				funcaoSucesso();
			}

			// FUNCOES DOS BOTOES DE NAVEGACAO

			// Selecao da grid
			$(".DataGridConsulta > table > tbody > tr").click(function() {
				// TODO - Funcionalidade default e de selecao unica, posso
				// implementar
				// ainda a selecao mutipla
				// Varre a tabela para limpar as selecoes

				limparSelecao();
				
				$(this).attr("data-selected", "true");
				$(this).attr("class", "btn-primary");
			});
			
			unBlockConteudo(".DataGridConsulta");
		},
		error : function(erro) {
			// Metronic.unblockUI('.DataGridConsulta');
			console.log("Erro no load ajax! " + erro);
			unBlockConteudo(".DataGridConsulta");
		}
	});
}
function primeiraPagina() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var pageNumber = $(".DataGridConsulta").attr("data-page-number");

	pageNumber = 1;

	$(".DataGridConsulta").attr("data-page-number", pageNumber);

	loadDataGrid();
}

function proximaPagina() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var pageNumber = $(".DataGridConsulta").attr("data-page-number");
	var pageCount = $(".DataGridConsulta table").attr("data-page-count");

	if (!$.isNumeric(pageCount)) {
		pageCount = 1;
	}

	if (!$.isNumeric(pageNumber)) {
		pageNumber = 1;
	}

	if (parseInt(pageNumber) < parseInt(pageCount)) {
		pageNumber = parseInt(pageNumber) + 1;

		$(".DataGridConsulta").attr("data-page-number", pageNumber);

		loadDataGrid();
	}
}

function ultimaPagina() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var pageNumber = $(".DataGridConsulta").attr("data-page-number");
	var pageCount = $(".DataGridConsulta table").attr("data-page-count");

	if (!$.isNumeric(pageCount)) {
		pageCount = 1;
	}

	if (!$.isNumeric(pageNumber)) {
		pageNumber = 1;
	}

	if (parseInt(pageNumber) < parseInt(pageCount)) {
		pageNumber = parseInt(pageCount);

		$(".DataGridConsulta").attr("data-page-number", pageNumber);

		loadDataGrid();
	}
}

function paginaAnterior() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var pageNumber = $(".DataGridConsulta").attr("data-page-number");
	var pageCount = $(".DataGridConsulta table").attr("data-page-count");

	if (!$.isNumeric(pageCount)) {
		pageCount = 1;
	}

	if (!$.isNumeric(pageNumber)) {
		pageNumber = 1;
	}

	if (parseInt(pageNumber) > 1) {
		pageNumber = parseInt(pageNumber) - 1;

		$(".DataGridConsulta").attr("data-page-number", pageNumber);

		loadDataGrid();
	}
}

function itemAnterior() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var index = getSelectedIndex();

	if (index > 0) {
		index = parseInt(index) - 1;
		setSelectedIndex(index);
	} else {
		paginaAnterior();
	}
}

function proximoItem() {
	// Se tiver alguma requisicao rolando, nao executa.
	if ($.active > 0) {
		return;
	}

	var index = getSelectedIndex();

	if (index < (getPageSize() - 1)) {
		index = parseInt(index) + 1;
		setSelectedIndex(index);
	} else {
		proximaPagina();
	}
}

var eventoTeclasConsulta = function(event) {
	switch (event.which) {

	case (KEY_NEXT):
		proximaPagina();
		break;

	case (KEY_PAGEDOWN):
		proximaPagina();
		break;

	case (KEY_PREVIOUS):
		paginaAnterior();
		break;

	case (KEY_PAGEUP):
		paginaAnterior();
		break;

	case (KEY_UP):
		itemAnterior();
		break;

	case (KEY_DOWN):
		proximoItem();
		break;

	case (KEY_ENTER):
		primeiraPagina();
		break;

	case (KEY_HOME):
		primeiraPagina();
		break;

	case (KEY_END):
		ultimaPagina();
		break;

	case (KEY_N):
		if (event.ctrlKey) {
			event.preventDefault();
			$(".BotaoNovo").click();
		}
		break;

	case (KEY_E):
		if (event.ctrlKey) {
			event.preventDefault();
			$(".BotaoEditar").click();
		}
		break;
	case (KEY_DEL):
		if (event.ctrlKey) {
			event.preventDefault();
			$(".BotaoExcluir").click();
		}
		break;
	}
};

$(document).ready(function() {

	$(document).off("keydown");

	// Verifica se e uma tela de consulta
	if ($(".DataGridConsulta")) {
		$(document).on("keydown", eventoTeclasConsulta);
	}

	// Foco no primeiro input (autofocus)
	$('input[autofocus]').focus();

	// Load automatico
	setTimeout(function() {
		loadDataGrid();
	}, 100);
});