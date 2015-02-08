$(function(){
    $("[data-load]").each(function(){
        $(this).load($(this).data("load"), function(){
        });
    });

    window.prettyPrint && prettyPrint();

    $(".history-back").on("click", function(e){
        e.preventDefault();
        history.back();
        return false;
    })
})


function headerPosition(){
    if ($(window).scrollTop() > $('header').height()) {
        $("header .navigation-bar")
            .addClass("fixed-top")
            .addClass(" shadow")
        ;
    } else {
        $("header .navigation-bar")
            .removeClass("fixed-top")
            .removeClass(" shadow")
        ;
    }
}

$(function() {
    if ($('nav > .side-menu').length > 0) {
        var side_menu = $('nav > .side-menu');
        var fixblock_pos = side_menu.position().top;
        $(window).scroll(function(){
            if ($(window).scrollTop() > fixblock_pos){
                side_menu.css({'position': 'fixed', 'top':'65px', 'z-index':'1000'});
            } else {
                side_menu.css({'position': 'static'});
            }
        })
    }
});

$(function() {
	if (debug) {
		console.log("Carregando minhasvendas.js ...");	
	}
    // Menu de navegacao

	$("a.ajax-link").click(function(e) {
		var dataLink = $(this).attr("href");
		
		if (dataLink != null && dataLink != '' && dataLink != 'javascript:;' && dataLink != '#') {
			e.preventDefault();
			loadDataLink(dataLink, this);

			if (debug) {
				console.log("carregando item " + dataLink)	
			}
		}
	});
    
	if (debug) {
		console.log("Fim do load de minhasvendas.js.");	
	}
});

$(window).scroll(function(){
    headerPosition();
});

// Funcao de load de tela no corpo da pagina
var tempo = 250;

function loadDataLink(dataLink, link) {
	if (dataLink == null || dataLink == "null" || dataLink == "" || dataLink == "#") {
		return;
	}
	
    var url = dataLink; //$(this).attr("href");
    
    var menuContainer = jQuery('.page-sidebar ul');
    var pageContent = $('.page-content');
    var pageContentBody = $('.page-content-body');

    var the = $(this);

    $.ajax({
        type: "GET",
        cache: false,
        url: url,
        dataType: "html",
        success: function (res) {

            pageContentBody.html(res);
            
            // Custom
			if (dataLink.indexOf("cadastro") > 0) {
				loadJs("web/js/cadastro.js");
			} else if (dataLink.indexOf("consulta") > 0) {
				loadJs("web/js/consulta.js");
			}
            
        },
        error: function (xhr, ajaxOptions, thrownError) {
            pageContentBody.html('<h4>Não foi possível carregar a página solicitada.<br/>'+thrownError+'</h4>');
        }
    });
}
