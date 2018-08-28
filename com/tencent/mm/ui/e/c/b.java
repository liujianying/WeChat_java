package com.tencent.mm.ui.e.c;

import android.content.Context;

public final class b {
    private static a utc = null;

    public static void a(a aVar) {
        utc = aVar;
    }

    public static CharSequence c(CharSequence charSequence, int i) {
        if (utc != null) {
            return utc.c(charSequence, i);
        }
        return charSequence;
    }

    public static CharSequence d(Context context, CharSequence charSequence, float f) {
        if (utc != null) {
            return utc.b(charSequence, f);
        }
        return charSequence;
    }

    public static int bd(String str, int i) {
        if (utc != null) {
            return utc.bd(str, i);
        }
        return i;
    }
}
