package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.File;

public class l {
    private static volatile l a;
    private String b;
    private String c = (this.e + File.separator + "vector.jar");
    private String d = (this.e + File.separator + "libtxmapengine.so");
    private String e;
    private String f;

    private l(Context context) {
        this.b = context.getDir("tencentMapTemp", 0).getAbsolutePath();
        this.e = context.getDir("tencentMapLib", 0).getAbsolutePath();
        this.f = context.getFilesDir().getAbsolutePath() + "/tencentMapSdk/assets/";
    }

    public static l a(Context context) {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l(context);
                }
            }
        }
        return a;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f;
    }
}
