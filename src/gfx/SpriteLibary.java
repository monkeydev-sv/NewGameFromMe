package gfx;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibary {
   private final static String PATH_TO_UNITS ="/sprites/units";
    private Map<String, SpriteSet> units;

    public SpriteLibary() {
        units = new HashMap<>();
        loadSpritesFromDisk();
    }
    private void loadSpritesFromDisk(){
String[]folderNames = getFolderNames(PATH_TO_UNITS);
for(String folderName: folderNames){
    SpriteSet spriteSet = new SpriteSet();
    String pathToFolder = PATH_TO_UNITS +"/"+ folderName;
    String[]sheetsInFolder = getSheetsInFolder(pathToFolder);
    for(String sheetsName: sheetsInFolder){
        spriteSet.addSheet(
                sheetsName.substring(0,sheetsName.length()-4),
                ImageUtils.loadImage(pathToFolder+"/"+ sheetsName));
    }

}

    }

    private String[] getSheetsInFolder(String basePath) {
        URL resource = SpriteLibary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current,name)->new File(current,name).isFile());
    }


    private String[] getFolderNames(String basePath) {
       URL resource = SpriteLibary.class.getResource(basePath);
       File file = new File(resource.getFile());
       return file.list((current,name)->new File(current,name).isDirectory());
    }
}

