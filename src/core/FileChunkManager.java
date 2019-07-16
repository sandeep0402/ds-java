package core;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileChunkManager {
    private static final String FOLDER = "/home/sandeep/Workspaces/Others/ds-java/temp/";

    private static final String FILE_TO_READ = "test.txt";
    private static final String FILE_TO_WRITE = "CHUNK";

    public static void main(String[] args) throws IOException {
        FileChunkManager fileChunkManager =  new FileChunkManager();
        fileChunkManager.spitFileInChunks(new File(FOLDER + FILE_TO_READ));

        fileChunkManager.joinChunksToSingleFile(FILE_TO_WRITE);
    }

    private void joinChunksToSingleFile(String nameStartsWith) throws IOException {
        File root = new File(FOLDER);
        FilenameFilter beginswithm = new FilenameFilter() {
            public boolean accept(File directory, String filename) {
                return filename.startsWith(nameStartsWith);
            }
        };

        File[] files = root.listFiles(beginswithm);
        List<File> fileList = Arrays.asList(files);
        Collections.sort(Arrays.asList(files));
        for (File file: fileList)
        {
            System.out.println(file.getName());
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            saveFileChunk(data, FOLDER+ FILE_TO_WRITE +"_FINAL", true );
        }


    }

    private void spitFileInChunks(File file) throws IOException {
        FileInputStream is = new FileInputStream(file); //videorecorder stores video to file

        java.nio.channels.FileChannel fc = is.getChannel();
        java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(50);

        int chunkCount = 0;

        byte[] bytes;

        while (fc.read(bb) >= 0) {
            bb.flip();
            //save the part of the file into a chunk
            bytes = bb.array();
            saveFileChunk(bytes, FOLDER+ FILE_TO_WRITE + "." + String.format("%07d", chunkCount), false);//mRecordingFile is the (String)path to file
            chunkCount++;
            bb.clear();
        }
    }

    private void saveFileChunk(byte[] bytesToSave, String path, boolean append) throws IOException {
        FileOutputStream fOut = new FileOutputStream(path, append);
        try {
            System.out.println("Chunk "+path+", Data: "+ bytesToSave);
            fOut.write(bytesToSave);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fOut.close();
        }
    }

}
