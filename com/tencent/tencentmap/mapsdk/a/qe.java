package com.tencent.tencentmap.mapsdk.a;

import android.os.Environment;
import java.io.File;

public class qe {
    public static boolean a = false;
    public static final String b = (a() + "/js/nicolas/xkun/dynamic_map");

    public static String a() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = "/sdcard";
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.getPath();
        }
        return str;
    }
}
