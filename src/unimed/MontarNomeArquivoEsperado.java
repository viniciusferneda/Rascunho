package unimed;

import com.google.common.base.Strings;

import java.util.Optional;

public class MontarNomeArquivoEsperado {

    public static void main(String[] args) {
        final Cabecalho cabecalho = new Cabecalho(Byte.valueOf("9"), Short.valueOf("976"), Short.valueOf("27"), Short.valueOf("1"), Short.valueOf("1"), "123", "");
        final StringBuilder nomeArquivoEsperado = new StringBuilder("ND");
        cabecalho.getTpArquivoNDC().ifPresent(nomeArquivoEsperado::append);
        nomeArquivoEsperado.append("_");
        cabecalho.getNumeroDoc1().ifPresent(nrDocumentoDoc1 -> {
            String documento1LastSeven = getDocumento1LastSeven(nrDocumentoDoc1);
            documento1LastSeven = Strings.padStart(documento1LastSeven, 7, '_');
            nomeArquivoEsperado.append(documento1LastSeven);
        });
        cabecalho.getTipoArquivoParcial().ifPresent(tpArquivoParcial -> {
            nomeArquivoEsperado.append("_");
            nomeArquivoEsperado.append(tpArquivoParcial);
        });
        nomeArquivoEsperado.append(".");
        cabecalho.getCodUnimedOrigem().ifPresent(cdUnimedOrigem -> {
            nomeArquivoEsperado.append(Strings.padStart(String.valueOf(cdUnimedOrigem), 3, '0'));
        });
        System.out.println(nomeArquivoEsperado.toString());
    }

    private static String getDocumento1LastSeven(String documento1) {
        String documento1LastSeven;
        if (documento1.length() > 7) {
            documento1LastSeven = documento1.substring(documento1.length() - 7);
        } else {
            documento1LastSeven = documento1;
        }
        return documento1LastSeven;
    }

    private static final class Cabecalho {

        private Optional<Byte> numeroVersaoTansacaoPtu = Optional.empty();
        private Optional<Short> codUnimedDestino = Optional.empty();
        private Optional<Short> codUnimedOrigem = Optional.empty();
        private Optional<Short> tpArquivoNDC = Optional.empty();
        private Optional<Short> tipoArquivoParcial = Optional.empty();
        private Optional<String> numeroDoc1 = Optional.empty();
        private Optional<String> numeroDoc2 = Optional.empty();

        public Cabecalho(Byte numeroVersaoTansacaoPtu, Short codUnimedDestino, Short codUnimedOrigem, Short tpArquivoNDC, Short tipoArquivoParcial, String numeroDoc1, String numeroDoc2) {
            this.numeroVersaoTansacaoPtu = Optional.of(numeroVersaoTansacaoPtu);
            this.codUnimedDestino = Optional.of(codUnimedDestino);
            this.codUnimedOrigem = Optional.of(codUnimedOrigem);
            this.tpArquivoNDC = Optional.of(tpArquivoNDC);
            this.tipoArquivoParcial = tipoArquivoParcial == null ? Optional.empty() : Optional.of(tipoArquivoParcial);
            this.numeroDoc1 = Optional.of(numeroDoc1);
            this.numeroDoc2 = Optional.of(numeroDoc2);
        }

        public Optional<Byte> getNumeroVersaoTansacaoPtu() {
            return numeroVersaoTansacaoPtu;
        }

        public Optional<Short> getCodUnimedDestino() {
            return codUnimedDestino;
        }

        public Optional<Short> getCodUnimedOrigem() {
            return codUnimedOrigem;
        }

        public Optional<Short> getTpArquivoNDC() {
            return tpArquivoNDC;
        }

        public Optional<Short> getTipoArquivoParcial() {
            return tipoArquivoParcial;
        }

        public Optional<String> getNumeroDoc1() {
            return numeroDoc1;
        }

        public Optional<String> getNumeroDoc2() {
            return numeroDoc2;
        }
    }
}
