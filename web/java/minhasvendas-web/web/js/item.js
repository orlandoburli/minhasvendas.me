var ItemHandler = function() {
	
	// Funcoes de manipulacao da grid de itens
	function adicionarItem() {
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}
		
		var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
		var paginaBase = paginaCadastro.split(".")[0];
		var operacao = "adicionaritem";
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];
		
		var params = {};
		
		$(".FormItens > div > input,select,textarea, .FormItens > div > div > input,select,textarea").each(function(index) {
			var val;
			
			if ($(this).hasClass("autocomplete")) {
				val = $(this).attr("data-value");
			} else {
				val = $(this).val();
			}
			
			params[$(this).attr("id")] = val;
		});
		
		if (debug) {
			console.log("Parâmetros de adicionaritem");
			console.log(params);
		}
		
		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) { },
			success : function(data) {

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					
					mensagemInfo(retorno.mensagem);
					
					limparCamposItem();
					
					loadDataGrid(function() {
						var input = getFirstInput();
						
						if ($(input).hasClass("select2")) {
							if (debug) {
								console.log("Select2 Focus on " + input);
							}
							setTimeout(function() {
								$(input).select2("open");	
							}, 500);
						} else {
							if (debug) {
								console.log("Input Focus on " + input);
							}
							$(input).focus();	
						}
					});

				} else {
					mensagemErro(retorno.mensagem);
					var input = "#" + retorno.fieldFocus;
					
					if ($(input).hasClass("select2")) {
						if (debug) {
							console.log("Select2 Focus on " + input);
						}
						$(input).select2("open");
					} else {
						if (debug) {
							console.log("Input Focus on " + input);
						}
						$(input).focus();	
					}
					
				}
			},
			error : function(erro) {
				if (debug) {
					console.log("Erro no load ajax! " + erro);	
				}
			}
		});
	}

	function alterarItem(oIndex) {
		// Se tiver alguma requisicao rolando, nao executa.
		
		var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
		var paginaBase = paginaCadastro.split(".")[0];
		var operacao = "alteraritem";
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];
		
		var params = {
			index : oIndex
		};
		
		// Este +1 e por causa do cabecalho, que também conta.
		var indexGrid = oIndex + 1;
		
		$(".DataGridItens tr:eq("+indexGrid+") ").find("input,select,textarea").each(function(index2) {
			
			var val;
			
			if ($(this).hasClass("autocomplete")) {
				val = $(this).attr("data-value");
			} else {
				val = $(this).val();
			}
			
			params[$(this).attr("id")] = val;
			
			if (debug) {
				console.log($(this).attr("id") + ' = ' + val);	
			}
		});

		if (debug) {
			console.log(params);
		}
		
		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) { },
			success : function(data) {

				var retorno = $.parseJSON(data);

				if (retorno.sucesso) {
					// Se deu certo, nao precisa avisar nada...
					if (debug) {
						console.log("Retorno de alteraritem");
						console.log(retorno);
					}
					
					// Dispara evento customizado
					$(".DataGridConsulta").trigger("load");
					
					try {
						// Procurar itens desabilitados para jogar o retorno
						$(".DataGridItens tr:eq("+indexGrid+") ").find("input:disabled,select:disabled,textarea:disabled").each(function(index2) {
							var id = $(this).attr("id");
							
							$(this).val(retorno.objeto[id]);
							
							// Formatacao de numeros
							if ($(this).attr("data-field-type") == "number") {
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
							}
						});
					} catch(error) {
						if (debug) {
							console.log(error);
						}
					}
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

	function limparCamposItem() {
		$(".FormItens > div > input,select,textarea, .FormItens > div > div > input,select,textarea").each(function(index) {
			var defaultValue = $(this).attr("data-default-value");
			
			$(this).val(defaultValue);
			
			if ($(this).hasClass("autocomplete")) {
				$(this).attr("data-value", defaultValue);
			}
		});
	}
	
	function getFirstInput() {
		var input;
		var continuar = true;
		$(".FormItens").find("input,select,textarea").each(function(index) {
			if (continuar) {
				if (debug) {
					console.log("Input: " + $(this).attr("id"));
				}
				input = $(this).attr("id");
				
				if (input.indexOf("auto") < 0) {
					continuar = false;	
				}
			}
		});
		
		if (debug) {
			console.log("First input: " + input);
		}
		
		return "#" + input;
	}

	// Altera a linha selecionada
	function loadDataGrid(funcaoSucesso) {
		if (debug) {
			console.log("Load grid...");	
		}

		blockConteudo(".DataGridConsulta");

		var paginaGrid = $(".DataGridConsulta").attr("data-page");

		var params = {};

		$.ajax({
			url : paginaGrid,
			type : 'POST',
			data : params,
			beforeSend : function(data) {
				if (debug) {
					console.log("loading...");
				}
			},
			success : function(data) {
				$(".DataGridConsulta").html(data);

				// Carrega as funcoes de componente
				loadJs("web/js/components.js");
				
				if (funcaoSucesso) {
					funcaoSucesso();
				}
				
				// Bind dos eventos de exclusao / alteracao
				
				bindItemEvents();

				unBlockConteudo(".DataGridConsulta");
				
				// Dispara evento customizado
				$(".DataGridConsulta").trigger("load");
			},
			error : function(erro) {
				unBlockConteudo(".DataGridConsulta");
				
				if (debug) {
					console.log("Erro no load ajax! " + erro);	
				}
			}
		});
	}

	function removerItem(indexParam) {
		
		if (!confirm("Confirma exclusão deste item?")) {
			return;
		}
		
		// Se tiver alguma requisicao rolando, nao executa.
		if ($.active > 0) {
			return;
		}
		
		var paginaCadastro = $(".FormularioCadastro").attr("data-page-cadastro");
		var paginaBase = paginaCadastro.split(".")[0];
		var operacao = "removeritem";
		var paginaFinal = paginaBase + "." + operacao + "." + paginaCadastro.split(".")[1];
		
		var params = {
			index : indexParam
		};
		
		$.ajax({
			url : paginaFinal,
			type : 'POST',
			data : params,
			beforeSend : function(data) { },
			success : function(data) {
				
				var retorno = $.parseJSON(data);
				
				if (retorno.sucesso) {
					mensagemInfo(retorno.mensagem);
					limparCamposItem();
					loadDataGrid();
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

	function bindItemEvents() {
		// Bind do clique do botao Remover Item
		$(".DataGridConsulta > table > tbody > tr").each(function(index) {
			var tr = $(this);
			var botao = $(this).find(".BotaoRemoverItem");
			
			botao.on("click", function() {
				removerItem(index);
			});
			
			$(tr).find("input,select,textarea").each(function(index2){
				$(this).on("blur", function() {
					alterarItem(index);
				});
			});
		});
	}
//
//	$(document).ready(function() {
//		
//		
//	});
	
	return {
		init: function(funcaoRefresh) {
			if (debug) {
				console.log("Método init de ItemHandler...");
			}
			
			$(document).off("keydown");

			$(".BotaoAdicionarItem").click(function() {
				adicionarItem();
			});
			
			// TODO Buscar ultimo input
			
			if (browser.mozilla) {
				$("#valorDesconto").on("keypress", keySalvar);
			} else {
				$("#valorDesconto").on("keydown", keySalvar);
			}

			function keySalvar(event) {
				if (event.keyCode == 13) {
					adicionarItem();
				}
			}
			
			// Bind Eventos de grid
			$(".DataGridConsulta").bind("load", funcaoRefresh);

			// Load automatico
			loadDataGrid();
		}
	};
}();

