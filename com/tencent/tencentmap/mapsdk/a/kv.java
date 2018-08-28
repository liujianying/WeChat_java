package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class kv {
    private static int a = 0;

    public static void a(Context context) {
        synchronized (kv.class) {
            a = r.a(context).w();
        }
    }

    public static void a(Context context, int i) {
        synchronized (kv.class) {
            a = i;
            r.a(context).m(i);
        }
    }

    public static int a() {
        int i;
        synchronized (kv.class) {
            i = a;
        }
        return i;
    }
}
