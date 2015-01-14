<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../header-title.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="portlet box blue-hoki">
		
			<div class="portlet-title">
				<div class="caption">
					<i class="fa "></i>${subtitulo}
				</div>
			</div>
			
			<div class="portlet-body form FormularioCadastro FormularioGeral" data-page-consulta="clienteconsulta.action" data-page-operacao="${operacao}" data-page-cadastro="clientecadastro.action">
				<form class="form-horizontal" action="#" role="form">
					<div class="form-body">
						<input id="idCliente" type="hidden" value="${ vo.idCliente }" />
						<input id="idEmpresa" type="hidden" value="${ vo.idEmpresa }" />
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Nome</label>
							<div class="col-sm-7">
								<input id="nome" type="text" autofocus="autofocus" class="form-control input-circle" value="${ vo.nome }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Email</label>
							<div class="col-sm-7">
								<input id="email" type="text" class="form-control input-circle" value="${ vo.email }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Data de nascimento</label>
							<div class="col-sm-3">
								<input id="dataNascimento" type="text"   class="form-control input-circle" value="<fmt:formatDate value="${ vo.dataNascimento.time }" pattern="dd/MM/yyyy"/>" data-field-type="date"/>
							</div>
						
							<label class="col-sm-1 control-label text-right">Fone 1</label>
							<div class="col-sm-3">
								<input id="fone1" type="text" class="form-control input-circle" value="${ vo.fone1 }" data-field-type="fone" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Fone 2</label>
							<div class="col-sm-3">
								<input id="fone2" type="text"   class="form-control input-circle" value="${ vo.fone2 }" data-field-type="fone" />
							</div>
							
							<label class="col-sm-1 control-label text-right">Fone 3</label>
							<div class="col-sm-3">
								<input id="fone3" type="text"   class="form-control input-circle" value="${ vo.fone3 }" data-field-type="fone" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Cep</label>
							<div class="col-sm-3">
								<input id="cep" type="text"   class="form-control input-circle" value="${ vo.cep }" data-field-type="cep" />
							</div>
							
							<label class="col-sm-1 control-label text-right">Bairro</label>
							<div class="col-sm-3">
								<input id="bairro" type="text"   class="form-control input-circle" value="${ vo.bairro }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Endereço</label>
							<div class="col-sm-4">
								<input id="endereco" type="text"   class="form-control input-circle" value="${ vo.endereco }" />
							</div>
							
							<label class="col-sm-1 control-label text-right">Número</label>
							<div class="col-sm-2">
								<input id="numero" type="text"   class="form-control input-circle" value="${ vo.numero }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Complemento</label>
							<div class="col-sm-7">
								<input id="complemento" type="text"   class="form-control input-circle" value="${ vo.complemento }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Cidade</label>
							<div class="col-sm-4">
								<input id="cidade" type="text"   class="form-control input-circle" value="${ vo.cidade }" />
							</div>
							
							<label class="col-sm-1 control-label text-right">UF</label>
							<div class="col-sm-2">
								<input id="uf" type="text"   class="form-control input-circle" value="${ vo.uf }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label text-right">Categoria</label>
							<div class="col-sm-7">
								<select id="idCategoriaCliente" class="form-control input-circle" >
									<option>[SELECIONE A CATEGORIA DO CLIENTE]</option>
									<c:forEach items="${categorias}" var="categoria">
										<option <c:if test="${vo.idCategoriaCliente == categoria.idCategoria }">selected="selected"</c:if> value="${categoria.idCategoria}">${categoria.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<%@include file="../../botoes-cadastro.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

 <script type="text/javascript" >

        $(document).ready(function() {

            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {

                //Nova variável com valor do campo "cep".
                var cep = $(this).val();

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{5}-?[0-9]{3}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("//viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#endereco").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                mensagemErro("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        mensagemErro("Formato de CEP inválido.");
                    }
                } //end if.
            });
        });

    </script>