//console.log("Carregando js da consulta");

// FUNCOES DA DATAGRID

$(function() {

	var tempo = 250;
	var conteudoId = "body";

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

	function loadDataGrid() {

		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}

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

	// FIM DAS FUNCOES DA DATAGRID

	$(".BotaoEditar").click(function() {
		editar();
	});

	$(".BotaoNovo").click(function() {
		novo();
	});

	$(".BotaoExcluir").click(function() {
		excluir();
	});

	$(".BotaoNavegacaoProximo").click(function() {
		proximaPagina();
	});

	$(".BotaoNavegacaoUltimo").click(function() {
		ultimaPagina();
	});

	$(".BotaoNavegacaoPrimeiro").click(function() {
		primeiraPagina();
	});

	$(".BotaoNavegacaoAnterior").click(function() {
		paginaAnterior();
	});

	$(".BotaoPesquisar").click(function() {
		loadDataGrid();
	});
	
	$("#somenteAtivos,#ParametroPesquisa,#PesquisarPor").change(function() {
		loadDataGrid();
	});

	function registroSelecionado() {
		if (getSelectedDataId() != null) {
			return true;
		} else {
			mensagemErro('Selecione um registro!');
			return false;
		}
	}

	function registroSelecionado2() {
		if (getSelectedDataId() != null) {
			return true;
		} else {
			return false;
		}
	}

	function novo() {
		
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}
		
		blockUI();

		var paginaCadastro = $(".DataGridConsulta").attr("data-detail-page");
		var paginaBase = paginaCadastro.split(".")[0];
		var paginaVisualizar = paginaBase + ".visualizar." + paginaCadastro.split(".")[1];

		var params = {
			'operacao' : 'inserir'
		};

		$.ajax({
			url : paginaVisualizar,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
			},
			success : function(data) {
			    var pageContentBody = $('.page-content-body');

			    pageContentBody.html(data);

				// Carrega o js de cadastros
				loadJs("web/js/cadastro.js");

				// Foco no primeiro input (autofocus)
				$('input[autofocus],select[autofocus]').focus();
				unBlockUI();
			},
			error : function(erro) {
				unBlockUI();
				console.log("Erro no load ajax! " + erro);
			}
		});
	}

	function editar() {
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}

		if (!registroSelecionado()) {
			return;
		}
		
		blockUI();

		var dados = getSelectedDataId();

		var paginaCadastro = $(".DataGridConsulta").attr("data-detail-page");
		var paginaBase = paginaCadastro.split(".")[0];
		var paginaVisualizar = paginaBase + ".visualizar." + paginaCadastro.split(".")[1];

		var params = {
			'operacao' : 'alterar'
		};

		var dadosSplit = dados.split("&");

		for (var i = 0; i < dadosSplit.length; i++) {
			var campo = dadosSplit[i].split("=")[0];
			var valor = dadosSplit[i].split("=")[1];
			params[campo] = valor;
		}

		$.ajax({
			url : paginaVisualizar,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
			},
			success : function(data) {
				var pageContentBody = $('.page-content-body');

			    pageContentBody.html(data);
			    
				// Carrega o js de cadastros
				loadJs("web/js/cadastro.js");

				// Foco no primeiro input (autofocus)
				$('input[autofocus],select[autofocus]').focus();
				
				unBlockUI();
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
				unBlockUI();
			}
		});
	}

	function acaoCustomizada(pagina) {
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}

		if (!registroSelecionado()) {
			return;
		}

		blockUI();
		
		var dados = getSelectedDataId();

		var params = { };

		var dadosSplit = dados.split("&");

		for (var i = 0; i < dadosSplit.length; i++) {
			var campo = dadosSplit[i].split("=")[0];
			var valor = dadosSplit[i].split("=")[1];
			params[campo] = valor;
		}

		$.ajax({
			url : pagina,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
			},
			success : function(data) {
				var pageContentBody = $('.page-content-body');

			    pageContentBody.html(data);

				if (pagina.indexOf("cadastro") > 0) {
					loadJs("web/js/cadastro.js");
				} else if (pagina.indexOf("consulta") > 0) {
					loadJs("web/js/consulta.js");
				}

				$('input[autofocus],select[autofocus]').focus();
				
				unBlockUI();
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
				unBlockUI();
			}
		});
	}

	function excluir() {
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}

		if (!registroSelecionado()) {
			return;
		}
		
		blockUI();
		
		var dados = getSelectedDataId();

		var paginaCadastro = $(".DataGridConsulta").attr("data-detail-page");
		var paginaBase = paginaCadastro.split(".")[0];
		var paginaExcluir = paginaBase + ".excluir." + paginaCadastro.split(".")[1];

		var params = {
			'operacao' : "excluir"
		};

		// Loop nos input's do form para enviar
		var dadosSplit = dados.split("&");

		for (var i = 0; i < dadosSplit.length; i++) {
			var campo = dadosSplit[i].split("=")[0];
			var valor = dadosSplit[i].split("=")[1];
			params[campo] = valor;
		}

		$.ajax({
			url : paginaExcluir,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
			},
			success : function(data) {

				unBlockUI();

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					mensagemInfo(retorno.mensagem);

					setTimeout(function() {
						loadDataGrid();
					}, 100);

				} else {
					mensagemErro(retorno.mensagem);
					$("#" + retorno.fieldFocus).focus();
				}
			},
			error : function(erro) {
				console.log("Erro no load ajax! " + erro);
				unBlockUI();
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

});