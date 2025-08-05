package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import java.util.function.Predicate;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.state.BoletimProva;

/**
 * ConcreteHandler
 * Classe condicional que verifica se a regra deve ser executada
 * de acordo com uma condição específica.
 */
public class RegraCondicional extends RegraApuracao {
    private Predicate<BoletimProva> condicao;
    private RegraApuracao regra;

    public RegraCondicional(Predicate<BoletimProva> condicao, RegraApuracao regra, RegraApuracao proxima) {
        super(proxima);
        this.condicao = condicao;
        this.regra = regra;
    }

    @Override
    protected Duration executarRegra(BoletimProva boletim, Duration tempo) throws DNFException, AtividadeNaoPermitidaException {
        if (condicao.test(boletim)) {
            return regra.apurar(boletim, tempo);
        }
        return tempo;
    }
}
