package actions;

import java.io.File;

public class FileMove {

	private static File arquivo;

	public static void MoveArquivo() {
		File origem = new File ( "C:\\Users\\priscila.siqueira\\Downloads\\jdk-13_windows-x64_bin.zip");
        File Destino = new File ("C:\\Users\\priscila.siqueira\\");
             
     arquivo = origem;
		// Move o arquivo para o novo diretorio
        boolean sucesso = arquivo.renameTo(new File(Destino, arquivo.getName()));
        if (sucesso) {
            System.out.println("Arquivo movido para '" + Destino.getAbsolutePath() + "'");
        } else {
            System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
                    + Destino.getAbsolutePath() + "'");
        }
    }
}


