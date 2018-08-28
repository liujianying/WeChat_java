package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;

public final class b {
    public static final int aJF = e.aJF;
    private static final b aJG = new b();

    b() {
    }

    public static int ae(Context context) {
        int ae = e.ae(context);
        return e.p(context, ae) ? 18 : ae;
    }

    public static void af(Context context) {
        e.af(context);
    }

    public static Intent di(int i) {
        return e.dj(i);
    }

    public static b oq() {
        return aJG;
    }

    public static boolean p(Context context, int i) {
        return e.p(context, i);
    }
}
