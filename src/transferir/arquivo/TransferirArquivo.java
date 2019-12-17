package transferir.arquivo;

import java.io.File;
import java.io.IOException;

public class TransferirArquivo {

	public static void main(String[] args) {
		while (true) {
			final String caminhoPasta = "C:\\app\\brasil\\integracao\\cmb\\a550\\tipo9";
			final File pastaIntegracao = new File(caminhoPasta);
			final String[] arquivosIntegracao = pastaIntegracao.list();

			for (String arquivoIntegracao : arquivosIntegracao) {

				System.out.println("Integrando arquivo: " + arquivoIntegracao);
				final String caminhoArquivo = pastaIntegracao.getAbsolutePath() + File.separator + arquivoIntegracao;
				final String caminhoDestino = "C:\\app\\brasil\\integracao\\ajius\\a550\\tipo9" + File.separator
						+ arquivoIntegracao;

				final File arquivo = new File(caminhoArquivo);
				final File destino = new File(caminhoDestino);

				if (arquivo.canRead() && destino.getParentFile().canRead() && destino.getParentFile().canWrite()) {
					try {
						System.out.println("Copiando arquivo para: " + destino);
						FileUtils.copyFile(arquivo, destino);

						if (destino.exists()) {
							System.out.println("Removendo arquivo: " + arquivo);
							FileUtils.delete(arquivo);
						} else {
							System.out.println("Destino do arquivo nao encontrado: " + destino);
						}
					} catch (IOException e) {
						System.out.println(
								"Erro ao copiar arquivo [" + caminhoArquivo + "] para [" + caminhoDestino + "].");
						System.out.println(e);
						FileUtils.delete(destino);
					}
				} else {
					System.out.println("Problema de leitura/escrita no caminho [" + caminhoArquivo + "].");
					System.out.println("Problema de leitura/escrita no caminho [" + caminhoDestino + "].");
				}
				System.out.println("Integrando do arquivo concluida.");
			}
		}
	}

}
