package us.siriusteam.uniadmin.utils;

import javafx.scene.text.Font;
import org.apache.commons.codec.binary.Base64;
import us.siriusteam.uniadmin.Models.UserModel;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

public class Utils {

    //Encriptar y desencriptar textos
    private static String Key = "U8QJ$HCApuPheTFhrhnSTRiFOYM15!oxJ$m&joPrYbDis6wT6j-p$$Dsr^Bc8$jSLQ$uJh6c8mkk@SW9CJrQy33CSv#t&KKhl8RT#";

    public static String Encript(String text){
        String base64EncryptedString = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfText = md.digest(Key.getBytes("UTF-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfText, 24);

            SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] plainTextBytes = text.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
        }catch (Exception ignored) {

        }
        return base64EncryptedString;
    }

    public static String Decrypt (String text) throws Exception{
        String base64EncryptedString = "";

        try{
            byte[] message = Base64.decodeBase64(text.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(Key.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");
        } catch (Exception ignored){

        }
        return  base64EncryptedString;
    }
    public static String getKey() {
        return Key;
    }


    //Obtener un usuario
    public static UserModel getUser(UUID uuid){
        return null;
    }

    /**
     * Carga una fuente desde el directorio proporcionado
      * @param path carpeta donde esta la fuente
     * @param nameOfFont nombre de la fuente ejemplo: 'font.ttf'
     * @return true si se cargo correctamente, de lo contrario retorna false
     */
    public static boolean loadFont(String path, String nameOfFont) throws IOException {
        File dir = new File(path);
        if(!dir.exists())dir.mkdir();

        File font = new File(path+File.separator+nameOfFont);
        if(!font.exists()){
            downloadFile("http://siriusteam.us/download/"+nameOfFont, nameOfFont, path);
        }

        Font.loadFont(new FileInputStream(font),12);
        return true;
    }

    /**
     * Descarga un archivo desde la url proporcionada.
     * @param url direccion donde esta alojado el archivo.
     * @param name nombre que tendra el archivo descargado.
     * @param dir direccion donde se gaurdara el archivo.
     */
    public static boolean downloadFile(String url, String name, String dir) throws IOException {
        File folder = new File(dir);
        if(!folder.exists()){
            if(!folder.mkdir()){
                return false; //No se pudo crear la carpeta
            }
        }

        InputStream in = null;
        OutputStream out = null;
        File file = new File(dir +File.separator+ name);
        URLConnection conn = new URL(url).openConnection();
        conn.connect();

        in = conn.getInputStream();
        out = new FileOutputStream(file);

        int b = 0;
        while (b != -1) {
            b = in.read();
            if (b != -1) {
                out.write(b);
            }
        }
        out.close();
        in.close();
        return true;
    }
}

