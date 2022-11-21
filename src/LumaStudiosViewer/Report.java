package LumaStudiosViewer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * <h1>Report</h1>
 * Librería que permite realizar reportes
 *
 * <p>
 * Esta  librería nos permite generar reportes de las Movies, Series junto con sus chapters y libros
 * a  excepción de los magazines que tienen la restricción de no poderse visualizar

 */
public class Report {

    /**
     * <h2> Variables </h2>
     * {@code String nameFile} almacena el nombre del archivo/reporte
     * {@code String title} contiene el titulo que lleve el archivo/reporte
     * {@code String content} almacena el contenido del reporte
     * {@code String extension} contiene la extensión  del reporte
     */

    private String nameFile;

    private String title;

    private String content;

    private String extension;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    /**
     * <h1>Metodo makeReport</h1>
     * Este método  se encarga de generar reporte de texto plano.
     * A continuación  detallamos sus componentes:
     * {@code if} valida que {@code getNameFile()} {@code getTitle} {@code getContent()} obtenidos no sean nulos
     *
     * Posteriormente creamos el archivo y para ello hicimos lo siguiente
     * {@code File file = new File(getNameFile() + "." + getExtension())} Creamos un obj file. Recibimos el nombre y extensión  seteados
     *
     * {@code FileOutputStream fos = new FileOutputStream(file)} Escribimos los caracteres - Va a preparar el archivo para escribir bytes
     *
     * {@code OutputStreamWriter osw = new OutputStreamWriter(fos)} Convertir todos los bytes en el archivo - Convertir  el String de los bytes
     en caracteres
     *
     * {@code BufferedWriter bw = new BufferedWriter(osw)} Escribimos los elementos de una forma mas eficiente
     *
     * {@code bw.write(getContent())} Una vez escrito {@code bw.close()Debemos cerrarlo}
     */
    public void makeReport() {

        if ((getNameFile() != null) && (getTitle() != null) && (getContent() != null)) {
            // crear archivo
            try {
                File file = new File(getNameFile() + "." + getExtension()); //Manipular el archivo en forma de obj

                FileOutputStream fos = new FileOutputStream(file);

                OutputStreamWriter osw = new OutputStreamWriter(fos);

                BufferedWriter bw = new BufferedWriter(osw); // Escribir elementos mucho mas rapido
                bw.write(getContent());
                bw.close(); // Puede ocasionar errores si se deja abierto

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Ingresa los datos del archivo");
        }

    }

}