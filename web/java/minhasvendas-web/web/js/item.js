/**
 * 
 */


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