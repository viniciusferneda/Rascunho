package transferir.arquivo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class FileUtils {

	/**
	 * Escreve o conteúdo do {@link ByteArrayOutputStream} no arquivo passado.
	 * Cria as pastas se necessário.
	 *
	 * @param temp
	 *            conteúdo a ser escrito.
	 * @param file
	 *            arquivo onde será escrito.
	 * @throws DiskSpaceException
	 *             caso não haja espaço em disco para escrever o arquivo.
	 * @throws IOException
	 */
	public static void writeFile(ByteArrayOutputStream temp, File file) throws IOException {
		File parentFile = file.getParentFile();
		parentFile.mkdirs();
		if (parentFile.getFreeSpace() <= temp.size()) {
			throw new IOException();
		}

		OutputStream out = new FileOutputStream(file);
		try {
			temp.writeTo(out);
			out.flush();
		} finally {
			out.close();
		}
	}

	/**
	 * Copia o arquivo.
	 *
	 * @param source
	 *            arquivo sendo copiado.
	 * @param target
	 *            destino da cópia.
	 * @throws IOException
	 */
	public static void copyFile(File source, File target) throws IOException {
		File targetParent = target.getParentFile();
		targetParent.mkdirs();

		if (source.length() > targetParent.getFreeSpace()) {
			throw new IOException();
		}

		FileInputStream entrada = new FileInputStream(source);
		FileOutputStream saida = new FileOutputStream(target);

		FileChannel canalEntrada = entrada.getChannel();
		FileChannel canalSaida = saida.getChannel();

		canalEntrada.transferTo(0, canalEntrada.size(), canalSaida);
		entrada.close();
		saida.flush();
		saida.close();
	}

	/**
	 * Deleta o arquivo e arquivos e pastas filhos, caso seja um diretório.
	 *
	 * @param file
	 *            o arquivo/pasta a ser deletado.
	 * @return se o arquivo foi deletado.
	 */
	public static boolean delete(File file) {
		if (file == null || !file.exists()) {
			return false;
		}
		if (file.isDirectory()) {
			try {
				for (File child : file.listFiles()) {
					delete(child);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return file.delete();
	}

	/**
	 * Deleta o arquivo passado, as pastas e arquivos filhos, e as pastas vazias
	 * superiores.
	 *
	 * @param file
	 *            o arquivo/pasta a ser deletado.
	 */
	public static void deleteEmptyFolders(File file) {
		if (!delete(file)) {
			return;
		}

		file = file.getParentFile();
		while (file.delete()) {
			file = file.getParentFile();
		}
	}

}
