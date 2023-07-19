package dk.sdu.cbse.managers;

import com.badlogic.gdx.files.FileHandleStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;       

public class JarFileHandleStream extends FileHandleStream {
    
    private JarFile jarF = null;
    private String jar;
    
    public JarFileHandleStream(String path){
        super(path);
        try{
            String[] args = path.split("!");
            jar = args[1].substring(1);
            
            String jarFilePath = args[0];
            jarF = new JarFile(jarFilePath);
        } catch (IOException ex){
            Logger.getLogger(JarFileHandleStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public InputStream read(){
        InputStream is = null;
        try{
            is = jarF.getInputStream(jarF.getEntry(jar));
        } catch (IOException ex){
            Logger.getLogger(JarFileHandleStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return is;
    }
    
    @Override
    public OutputStream write(boolean overwrite){
        return super.write(overwrite);
    }
}
