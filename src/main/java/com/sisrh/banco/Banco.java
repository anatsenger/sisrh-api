package com.sisrh.banco;

import java.util.ArrayList;
import java.util.List;
import com.sisrh.dto.Empregado;
import com.sisrh.dto.Solicitacao;

import java.util.Date;

public class Banco {

    private static List<Empregado> empregados = new ArrayList<>();

    private static List<Solicitacao> solicitacoes = new ArrayList<>();

    public static List<Solicitacao> listarSolicitacoes() {
        return solicitacoes;
    }

    static {
        empregados.add(new Empregado("210501", "Luigi Campos", new Date(), null, 1876));
        empregados.add(new Empregado("210502", "Marcela Ferreira", new Date(), null, 1762));
        empregados.add(new Empregado("210503", "Vicente Dahmer", new Date(), null, 14238));
    }

    public static List<Empregado> listarEmpregados() {
        return empregados;
    }

    public static Empregado buscarEmpregadoPorMatricula(String matricula) {
        for (Empregado emp : empregados) {
            if (emp.getMatricula().equals(matricula)) {
                return emp;
            }
        }
        return null;
    }
    
    public static Empregado incluirEmpregado(Empregado empregado) {
        empregados.add(empregado);
        return empregado;
    }

    public static Empregado alterarEmpregado(String matricula, Empregado empregadoAtualizado) throws Exception {

        Empregado empregadoExistente = buscarEmpregadoPorMatricula(matricula);

        if (empregadoExistente != null) {

            empregadoExistente.setNome(empregadoAtualizado.getNome());
            empregadoExistente.setAdmissao(empregadoAtualizado.getAdmissao());
            empregadoExistente.setDesligamento(empregadoAtualizado.getDesligamento());
            empregadoExistente.setSalario(empregadoAtualizado.getSalario());

            return empregadoExistente;
        } else {
            throw new Exception("Empregado com matrícula " + matricula + " não encontrado.");
        }
    }

    public static void excluirEmpregado(String matricula) {
        Empregado empregado = buscarEmpregadoPorMatricula(matricula);
        if (empregado != null) {
            empregados.remove(empregado);
        }
    }
    
        public static Solicitacao buscarSolicitacaoPorId(String id) {
        return solicitacoes.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public static Solicitacao incluirSolicitacao(Solicitacao solicitacao) {
        solicitacoes.add(solicitacao);
        return solicitacao;
    }

    public static Solicitacao alterarSolicitacao(String id, Solicitacao solicitacaoAtualizada) {
        for (Solicitacao solicitacao : solicitacoes) {
            if (solicitacao.getId().equals(id)) {
                solicitacao.setDescricao(solicitacaoAtualizada.getDescricao());
                solicitacao.setStatus(solicitacaoAtualizada.getStatus());
                solicitacao.setDataCriacao(solicitacaoAtualizada.getDataCriacao());
                return solicitacao;
            }
        }
        return null;
    }

    public static void excluirSolicitacao(String id) {
        solicitacoes.removeIf(solicitacao -> solicitacao.getId().equals(id));
    }        
}
