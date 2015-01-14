$(function(){
//    $("<script/>").attr('src', '/minhasvendas-assets/metro-ui/js/metro/metro-loader.js').appendTo($('head'));

	if ((document.location.host.indexOf('.dev') > -1) || (document.location.host.indexOf('modernui') > -1) ) {
        $("<script/>").attr('src', '/minhasvendas-assets/metro-ui/js/metro/metro-loader.js').appendTo($('head'));
    } else {
        $("<script/>").attr('src', '/minhasvendas-assets/metro-ui/js/metro/metro.min.js').appendTo($('head'));
    }
})