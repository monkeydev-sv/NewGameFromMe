package gfx;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {
   private final static String PATH_TO_UNITS ="/sprites/units";
    private final Map<String, SpriteSet> units;

    public SpriteLibrary() {
        units = new HashMap<>();
        loadSpritesFromDisk();
    }
    private void loadSpritesFromDisk(){
String[]folderNames = getFolderNames();
for(String folderName: folderNames){
    SpriteSet spriteSet = new SpriteSet();
    String pathToFolder = PATH_TO_UNITS +"/"+ folderName;
    String[]sheetsInFolder = getSheetsInFolder(pathToFolder);
    for(String sheetsName: sheetsInFolder){
        spriteSet.addSheet(
                sheetsName.substring(0,sheetsName.length()-4),
                ImageUtils.loadImage(pathToFolder+"/"+ sheetsName));
    }
    units.put(folderName,spriteSet);


}

    }

    private String[] getSheetsInFolder(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file = new File(resource.getFile());
        return file.list((current,name)->new File(current,name).isFile());
    }


    private String[] getFolderNames() {
       URL resource = SpriteLibrary.class.getResource(SpriteLibrary.PATH_TO_UNITS);
       File file = new File(resource.getFile());
       return file.list((current,name)->new File(current,name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }
}

