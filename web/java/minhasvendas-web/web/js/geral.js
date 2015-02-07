var debug = false;

if (location.href.indexOf("localhost") >= 0) {
	console.log("Debug ativado por localhost.");
	debug = true;
}

if (location.href.indexOf("debug") >= 0) {
	console.log("Debug ativado por parametro.");
	debug = true;
} 
if (location.href.indexOf("nodebug") >= 0) {
	debug = false;
}

var conteudoId = ".page-content-body";

var browser = {
	chrome : false,
	mozilla : false,
	opera : false,
	msie : false,
	safari : false
};

// Constantes de teclas de funcao

var KEY_UP = 38;
var KEY_DOWN = 40;
var KEY_NEXT = 39;
var KEY_PREVIOUS = 37;
var KEY_ENTER = 13;

var KEY_F3 = 114;
var KEY_F4 = 115;
var KEY_F5 = 116;
var KEY_F6 = 117;
var KEY_F7 = 118;
var KEY_F8 = 119;

var KEY_E = 69;
var KEY_N = 78;
var KEY_S = 83;
var KEY_DEL = 46;
var KEY_ESC = 27;

var KEY_END = 35;
var KEY_HOME = 36;
var KEY_PAGEUP = 33;
var KEY_PAGEDOWN = 34;

var DEBUG = 1;

function getTimeStamp() {
	var now = new Date();
	return ((now.getMonth() + 1)
			+ '/'
			+ (now.getDate())
			+ '/'
			+ now.getFullYear()
			+ " "
			+ now.getHours()
			+ ':'
			+ ((now.getMinutes() < 10) ? ("0" + now.getMinutes()) : (now
					.getMinutes())) + ':' + ((now.getSeconds() < 10) ? ("0" + now
			.getSeconds())
			: (now.getSeconds())));
}

function mensagem(oMensagem, tipo) {
	$.bootstrapGrowl(oMensagem, { type: tipo });
}

function mensagemInfo(oMensagem) {
	mensagem(oMensagem, 'info');
}

function mensagemErro(oMensagem) {
	mensagem(oMensagem, 'danger');
}

function loadJs(jsFile, funcaoSucesso, funcaoErro) {
	if (debug) {
		console.log("Carregando arquivo " + jsFile);	
	}
	
	$.getScript(jsFile).done(function(script, textStatus) {
		if (debug) {
			console.log("Arquivo " + jsFile + " carregado com sucesso.");	
		}
		if (funcaoSucesso) {
			funcaoSucesso();
		}
	}).fail(function(jqxhr, settings, exception) {
		if (debug) {
			console.log("Erro ao carregar js file " + jsFile+ " - Erro: " + exception);	
		}
		if (funcaoErro) {
			funcaoErro();
		}
	});
}

function blockUI(oMessage) {
	if (!oMessage) {
		oMessage = "Aguarde, processando...";
	}
	
	var msg = '<div class="loading-message"><img src="/minhasvendas-assets/bootstrap/3.3.1/img/loading-spinner-grey.gif" align=""/><span>&nbsp;&nbsp;' + oMessage + '</span></div>';
	
	$.blockUI({
		 message: msg,
		 css: { 
	         border: 'none', 
	         padding: '15px', 
	         backgroundColor: '#F7F7F7',
		 },
		 overlayCSS: {
             backgroundColor: '#000',
             opacity: 0.1, 
             cursor: 'wait'
         }
	 }); 
}

function blockConteudo(oComponente, oMessage) {
	if (debug) {
		console.log("Bloqueando " + oComponente);
	}
	
	if (!oComponente) {
		blockUI(oMessage);
		return false;
	}
	
	if (!oMessage) {
		oMessage = "Aguarde, processando...";
	}
	
	var msg = '<div class="loading-message"><img src="/minhasvendas-assets/bootstrap/3.3.1/img/loading-spinner-grey.gif" align=""/><span>&nbsp;&nbsp;' + oMessage + '</span></div>';
	
	$(oComponente).block({
		 message: msg,
		 css: { 
	         border: 'none', 
	         padding: '15px', 
	         backgroundColor: '#F7F7F7',
		 },
		 overlayCSS: {
             backgroundColor: '#000',
             opacity: 0.1, 
             cursor: 'wait'
         }
	 }); 
}

function unBlockUI() {
	$.unblockUI();
}

function unBlockConteudo(oComponente) {
	$(oComponente).unblock();
}