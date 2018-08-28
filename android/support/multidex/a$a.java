package android.support.multidex;

import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

final class a$a {
    static void a(ClassLoader classLoader, List<File> list) {
        int size = list.size();
        Field c = a.c(classLoader, "path");
        StringBuilder stringBuilder = new StringBuilder((String) c.get(classLoader));
        String[] strArr = new String[size];
        File[] fileArr = new File[size];
        ZipFile[] zipFileArr = new ZipFile[size];
        DexFile[] dexFileArr = new DexFile[size];
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            File file = (File) listIterator.next();
            String absolutePath = file.getAbsolutePath();
            stringBuilder.append(':').append(absolutePath);
            int previousIndex = listIterator.previousIndex();
            strArr[previousIndex] = absolutePath;
            fileArr[previousIndex] = file;
            zipFileArr[previousIndex] = new ZipFile(file);
            dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
        }
        c.set(classLoader, stringBuilder.toString());
        a.a(classLoader, "mPaths", strArr);
        a.a(classLoader, "mFiles", fileArr);
        a.a(classLoader, "mZips", zipFileArr);
        a.a(classLoader, "mDexs", dexFileArr);
    }
}
