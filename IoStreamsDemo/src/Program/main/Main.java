package Program.main;

//Stream
// 1. Direction : input or output
// 2. Data size : byte or char
// 3. Source : file, memory, socket, ....
// 4. Buffering


import java.io.*;

public class Main { //потоки вводу виводу
    public static void main(String[] args) {
        String file1 = "input.txt";
        String file2 = "output2.txt";
        String dir = System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + "files";

        File localDir = new File(dir);
        localDir.mkdir();
        //шляхи для файлів
        file1 = dir + System.getProperty("file.separator") + file1;
        file2 = dir + System.getProperty("file.separator") + file2;

        File in = new File(file1);
        if (!in.exists())
        {
            try {
                if(in.createNewFile())
                {
                    System.out.println("File was successfully created!");
                };
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //виклик методу для роботи з файлами
   //     copySmallFile(file1, file2);
   //    copyBigFile(file1, file2);
        copyBufferedFile(file1, file2);


        System.out.println("dir = " + dir);

    }
    //методи
    private static void copyBufferedFile(String file1, String file2) {
        try ( InputStream in = new FileInputStream(file1);
              OutputStream out = new FileOutputStream(file2);
              BufferedInputStream bin = new BufferedInputStream(in);
              BufferedOutputStream bout = new BufferedOutputStream(out);
                ){
            byte[] buf = new byte[10240];
            int readBytes = 0;
            while ((readBytes = bin.read(buf)) != -1) {
                bout.write(buf, 0, readBytes);
                bout.flush(); //викидає інформацію з буфера в поток, навіть коли буфер не заповнений.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void copyBigFile(String file1, String file2) {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(file1);
            out = new FileOutputStream(file2);

            byte[] buffer = new byte[10240];
            int readBytes = 0;

            while ( (readBytes = in.read(buffer)) != -1){
                out.write(buffer, 0, readBytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copySmallFile(String file1, String file2) {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(new File(file1));
            out = new FileOutputStream(new File(file2));

            byte[] buffer = new byte[in.available()]; //.available() зчитує розмір файлу
            int readBytes = in.read(buffer);

            out.write(buffer, 0, readBytes);
            System.out.println("File was successfully copied!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}