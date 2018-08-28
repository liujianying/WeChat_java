package com.tencent.map.lib.util;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public class b {
    private static LinkedHashMap<String, a> a = new LinkedHashMap();

    public static synchronized void a(String str, Bitmap bitmap) {
        synchronized (b.class) {
            if (a == null) {
                a = new LinkedHashMap();
            }
            a aVar;
            if (a.containsKey(str)) {
                aVar = (a) a.get(str);
                aVar.a++;
            } else {
                aVar = new a();
                aVar.b = bitmap;
                aVar.a = 1;
                a.put(str, aVar);
            }
        }
    }

    public static synchronized Bitmap a(String str) {
        Bitmap bitmap;
        synchronized (b.class) {
            if (a == null) {
                bitmap = null;
            } else {
                a aVar = (a) a.get(str);
                bitmap = aVar != null ? aVar.b : null;
            }
        }
        return bitmap;
    }

    public static synchronized void b(String str) {
        synchronized (b.class) {
            if (a != null) {
                a aVar = (a) a.get(str);
                if (aVar != null) {
                    aVar.a--;
                    if (aVar.a <= 0) {
                        a.remove(str);
                    }
                }
            }
        }
    }

    public static synchronized void a() {
        synchronized (b.class) {
            if (a != null) {
                a.clear();
            }
        }
    }
}
