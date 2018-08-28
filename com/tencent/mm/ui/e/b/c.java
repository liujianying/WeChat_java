package com.tencent.mm.ui.e.b;

import android.graphics.drawable.Drawable;

public final class c {
    private static b utb = null;

    public static void a(b bVar) {
        utb = bVar;
    }

    public static Drawable gj(String str, String str2) {
        if (utb == null) {
            return null;
        }
        a cq = utb.cq(str, str2);
        if (cq instanceof Drawable) {
            return (Drawable) cq;
        }
        return null;
    }
}
