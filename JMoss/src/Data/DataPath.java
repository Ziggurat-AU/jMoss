package Data;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataPath {
    public String sysPath;
    public String dataPath;
    public DataPath(){
        Path currentRelativePath = Paths.get("");
        sysPath = currentRelativePath.toAbsolutePath().toString();
        dataPath = sysPath + "/jMoss/src/Data";
    }
}

