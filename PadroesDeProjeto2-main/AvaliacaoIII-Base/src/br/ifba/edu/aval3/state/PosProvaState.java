package br.ifba.edu.aval3.state;

/**
    Participante: ConcreteState subclasses
 **/
public class PosProvaState extends FaseProvaAdapter {
    public PosProvaState(BoletimProva boletim) {
        super(boletim);
    }

    @Override
    public Long getMinutosAtraso() {
        return boletim.minutoPartidaEfetivo - boletim.minutoPartidaPrevisto;
    }
}

