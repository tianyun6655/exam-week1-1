package untils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tianyun chen on 6/3/2016.
 */
public class FileUntils {

    public static boolean CheckFileInSandBox(Context context,String name)
    {
            File[] files = context.getFilesDir().listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].getName().equals(name))
            {
                return  true;
            }

        }
        return false;
    }

    public static void copyAssetsToSandBox(Context context, InputStream inputStream)
    {
        File fosto = new File(context.getFilesDir().getAbsolutePath()+"/javascript.html");
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(fosto);
            byte bt[] = new byte[1024];
            int c;
            while((c=inputStream.read(bt))>0)
            {
                fileOutputStream.write(bt,0,c);
                Log.d("untils",c+"");

            }
            inputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
