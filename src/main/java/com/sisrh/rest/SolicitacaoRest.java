package com.sisrh.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.annotations.Api;
import com.sisrh.banco.Banco;
import com.sisrh.dto.Solicitacao;

@Api
@Path("/solicitacao")
public class SolicitacaoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitacoes() {
        try {
            List<Solicitacao> solicitacoes = Banco.listarSolicitacoes();
            return Response.ok().entity(solicitacoes).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao listar solicitacoes!\" , \"detalhe\" :  \"" + e.getMessage() + "\"  }").build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterSolicitacao(@PathParam("id") String id) {
        try {
            Solicitacao solicitacao = Banco.buscarSolicitacaoPorId(id);
            if (solicitacao != null) {
                return Response.ok().entity(solicitacao).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao obter solicitacao!\" , \"detalhe\" :  \"" + e.getMessage() + "\"  }").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirSolicitacao(Solicitacao solicitacao) {
        try {
            Solicitacao sol = Banco.incluirSolicitacao(solicitacao);
            return Response.ok().entity(sol).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao incluir solicitacao!\" , \"detalhe\" :  \"" + e.getMessage() + "\"  }").build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarSolicitacao(@PathParam("id") String id, Solicitacao solicitacao) {
        try {
            Solicitacao solicitacaoExistente = Banco.buscarSolicitacaoPorId(id);
            if (solicitacaoExistente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
            }

            Solicitacao solicitacaoAlterada = Banco.alterarSolicitacao(id, solicitacao);

            return Response.ok().entity(solicitacaoAlterada).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na alteracao da solicitacao!\" , \"detalhe\" :  \"" + e.getMessage() + "\"  }").build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirSolicitacao(@PathParam("id") String id) {
        try {
            Solicitacao solicitacaoExistente = Banco.buscarSolicitacaoPorId(id);
            if (solicitacaoExistente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitacao nao encontrada!\" }").build();
            }

            Banco.excluirSolicitacao(id);
            return Response.ok().entity("{ \"mensagem\" : \"Solicitacao " + id + " excluida!\" }").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na exclusao da solicitacao!\" , \"detalhe\" :  \"" + e.getMessage() + "\"  }").build();
        }
    }
}
