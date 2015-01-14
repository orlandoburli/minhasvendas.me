
var janelaAtiva = "";

var tempo = 250;
var isLoading = false;

$(function() {
	// Funcao principal de Login
	function entrar() {
		console.log("Entrando...");
		
		if ($("#email").val().length <= 0 || $("#senha").val().length <= 0) {
			mensagemErro("Informe o usu&aacute;rio / senha!");
			$("#email").focus();
		} else {
			var params = {
				'email' : $("#email").val(),
				'senha' : $("#senha").val(),
				'lembrarSenha' : $("#lembrarSenha").prop('checked') ? "1" : "0"
			};

			$.ajax({
				url : "login.login.action",
				type : "POST",
				data : params,

				beforeSend : function(data) {
					// debug("loading...");
				},

				success : function(data) {
					console.log(data);
					
					var retorno = $.parseJSON(data);
					
					if (retorno.sucesso) {
						finalLogin();
					} else {
						mensagemErro(retorno.mensagem);
						$("#login").focus();
					}
				},
				error : function(erro) {
					// debug("Erro no load ajax! " + erro);
				}
			});
		}
	}

	function finalLogin() {
		var isOk = false;
		
		blockUI("Aguarde, redirecionando...");
		
		window.setTimeout(function() {
			$(window).attr("location", "home.action");
		}, 1000);
	}

	// Clique do login - valida se preencheu usuario e senha
	$("#entrar").click(function() {
		entrar();
	});
	
	$("#teste").click(function() {
		blockUI();
	});

	// Exibe a mensagem de erro por 3 segundos
	function showMessage(messageText) {
		$("#form-mensagem").html(messageText);
		$("#form-mensagem").fadeIn(tempo);

		setTimeout(function() {
			$("#form-mensagem").fadeOut(tempo);
		}, 3000);
	}

	// Coloca o foco num componente, com um delay
	function focus(componenteId) {
		setTimeout(function() {
			$(componenteId).focus();
		}, tempo);
	}

	// 
	// Eventos de teclas dos inputs
	// 

	$("#email ").keydown(function(event) {
		if (event.which == 13) {
			$("#senha").focus();
		}
	});

	$("#senha").keydown(function(event) {
		if (event.which == 13) {
			$("#entrar").click();
		}
	});
	
	
});


