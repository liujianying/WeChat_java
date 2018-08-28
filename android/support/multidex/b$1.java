package android.support.multidex;

import java.io.File;
import java.io.FileFilter;

class b$1 implements FileFilter {
    final /* synthetic */ String ma;

    b$1(String str) {
        this.ma = str;
    }

    public final boolean accept(File file) {
        return !file.getName().startsWith(this.ma);
    }
}
