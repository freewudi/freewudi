import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class test {

    /**
     * 获取所有的文件和文件夹
     *
     * @param filepath 路径
     */
    public static List<File> getAllFile(String filepath) {
        List<File> allFiles = new ArrayList<>();
        findFolder(new File(filepath), allFiles);
        return allFiles;
    }

    /**
     * 递归
     *
     * @param file
     * @param allFiles
     */
    private static void findFolder(File file, List<File> allFiles) {
        if (file.isDirectory()) {
            allFiles.add(file);
            File[] files = file.listFiles();
            for (File f : files) {
                findFolder(f, allFiles);
            }
        } else {
            allFiles.add(file);
        }
    }
    public static void main(String[] args) {
        List<File> files = test.getAllFile("C:\\Users\\zc\\Desktop\\保险文件\\材料");
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }

}
