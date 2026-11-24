package patio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TermoApreensaoBuilderTest {

    @Test
    void deveRetornarExcecaoParaTermoSemPlaca() {
        try {
            TermoApreensaoBuilder builder = new TermoApreensaoBuilder();
            TermoApreensao termo = builder
                    .setMotivo("Licenciamento vencido")
                    .setCor("Prata")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Placa inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaTermoSemMotivo() {
        try {
            TermoApreensaoBuilder builder = new TermoApreensaoBuilder();
            TermoApreensao termo = builder
                    .setPlaca("ABC1C34")
                    .setCor("Prata")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Motivo inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaCondutorSemCpf() {
        try {
            TermoApreensaoBuilder builder = new TermoApreensaoBuilder();
            TermoApreensao termo = builder
                    .setPlaca("ABC1C34")
                    .setMotivo("Condutor sem habilitação")
                    .setNomeCondutor("João da Silva")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CPF do condutor obrigatório quando o condutor é informado", e.getMessage());
        }
    }

    @Test
    void deveRetornarTermoValido() {
        TermoApreensaoBuilder builder = new TermoApreensaoBuilder();
        TermoApreensao termo = builder
                .setPlaca("ABC1C34")
                .setMotivo("Licenciamento vencido")
                .build();

        assertNotNull(termo);
    }

    @Test
    void deveRetornarTermoComCondutorECpf() {
        TermoApreensaoBuilder builder = new TermoApreensaoBuilder();
        TermoApreensao termo = builder
                .setPlaca("ABC1C34")
                .setMotivo("Condutor sem habilitação")
                .setNomeCondutor("João da Silva")
                .setCpfCondutor("123.456.789-09")
                .build();

        assertEquals("João da Silva", termo.getNomeCondutor());
        assertEquals("123.456.789-09", termo.getCpfCondutor());
    }

    @Test
    void deveManterOsCamposInformadosNoBuilder() {
        TermoApreensao termo = new TermoApreensaoBuilder()
                .setPlaca("JKL9I76")
                .setMotivo("Estacionado em local proibido")
                .setDataApreensao(LocalDate.of(2026, 11, 24))
                .setMarca("Fiat")
                .setModelo("Uno")
                .setCor("Vermelho")
                .setAnoFabricacao(2012)
                .setQuilometragem(154000)
                .setVaga("B-17")
                .build();

        assertEquals("JKL9I76", termo.getPlaca());
        assertEquals("Estacionado em local proibido", termo.getMotivo());
        assertEquals(LocalDate.of(2026, 11, 24), termo.getDataApreensao());
        assertEquals("Fiat", termo.getMarca());
        assertEquals("Uno", termo.getModelo());
        assertEquals("Vermelho", termo.getCor());
        assertEquals(2012, termo.getAnoFabricacao());
        assertEquals(154000, termo.getQuilometragem());
        assertEquals("B-17", termo.getVaga());
    }

    @Test
    void deveDeixarCamposNaoInformadosVazios() {
        TermoApreensao termo = new TermoApreensaoBuilder()
                .setPlaca("ABC1C34")
                .setMotivo("Licenciamento vencido")
                .build();

        assertNull(termo.getChassi());
        assertNull(termo.getNomeCondutor());
        assertEquals(0, termo.getQuilometragem());
    }
}
