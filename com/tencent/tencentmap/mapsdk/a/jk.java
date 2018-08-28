package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.d;

public class jk {
    static final String[] a = new String[]{"txmapengine", "txnavengine"};

    public static void a(Context context, String str) {
        try {
            System.loadLibrary(str);
            d.a("loadLibary:" + str + "  successful");
        } catch (UnsatisfiedLinkError e) {
            d.a("loadLibary:" + str + " result:" + jl.a(context, str));
        }
    }
}
