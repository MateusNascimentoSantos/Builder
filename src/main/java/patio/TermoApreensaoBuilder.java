package patio;

import java.time.LocalDate;

public class TermoApreensaoBuilder {

    private TermoApreensao termo;

    public TermoApreensaoBuilder() {
        termo = new TermoApreensao();
    }

    public TermoApreensao build() {
        if (termo.getPlaca().equals("")) {
            throw new IllegalArgumentException("Placa inválida");
        }
        if (termo.getMotivo().equals("")) {
            throw new IllegalArgumentException("Motivo inválido");
        }
        if (termo.getNomeCondutor() != null && termo.getCpfCondutor() == null) {
            throw new IllegalArgumentException("CPF do condutor obrigatório quando o condutor é informado");
        }
        return termo;
    }

    public TermoApreensaoBuilder setPlaca(String placa) {
        termo.setPlaca(placa);
        return this;
    }

    public TermoApreensaoBuilder setMotivo(String motivo) {
        termo.setMotivo(motivo);
        return this;
    }

    public TermoApreensaoBuilder setDataApreensao(LocalDate dataApreensao) {
        termo.setDataApreensao(dataApreensao);
        return this;
    }

    public TermoApreensaoBuilder setAgenteResponsavel(String agenteResponsavel) {
        termo.setAgenteResponsavel(agenteResponsavel);
        return this;
    }

    public TermoApreensaoBuilder setNumeroAutoInfracao(String numeroAutoInfracao) {
        termo.setNumeroAutoInfracao(numeroAutoInfracao);
        return this;
    }

    public TermoApreensaoBuilder setMarca(String marca) {
        termo.setMarca(marca);
        return this;
    }

    public TermoApreensaoBuilder setModelo(String modelo) {
        termo.setModelo(modelo);
        return this;
    }

    public TermoApreensaoBuilder setCor(String cor) {
        termo.setCor(cor);
        return this;
    }

    public TermoApreensaoBuilder setAnoFabricacao(int anoFabricacao) {
        termo.setAnoFabricacao(anoFabricacao);
        return this;
    }

    public TermoApreensaoBuilder setChassi(String chassi) {
        termo.setChassi(chassi);
        return this;
    }

    public TermoApreensaoBuilder setRenavam(String renavam) {
        termo.setRenavam(renavam);
        return this;
    }

    public TermoApreensaoBuilder setQuilometragem(int quilometragem) {
        termo.setQuilometragem(quilometragem);
        return this;
    }

    public TermoApreensaoBuilder setNomeCondutor(String nomeCondutor) {
        termo.setNomeCondutor(nomeCondutor);
        return this;
    }

    public TermoApreensaoBuilder setCpfCondutor(String cpfCondutor) {
        termo.setCpfCondutor(cpfCondutor);
        return this;
    }

    public TermoApreensaoBuilder setVaga(String vaga) {
        termo.setVaga(vaga);
        return this;
    }

    public TermoApreensaoBuilder setObservacoes(String observacoes) {
        termo.setObservacoes(observacoes);
        return this;
    }
}
