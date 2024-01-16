package tn.tech.horizon.health_care.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileUtils {

    private static final int BUFFER_SIZE = 4 * 1024;

    public static byte[] compressFile(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            byte[] tmp = new byte[BUFFER_SIZE];
            while (!deflater.finished()) {
                int size = deflater.deflate(tmp);
                outputStream.write(tmp, 0, size);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la compression de l'image.", e);
        }
    }

    public static byte[] decompressFile(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            byte[] tmp = new byte[BUFFER_SIZE];
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la décompression de l'image.", e);
        }
    }
}
