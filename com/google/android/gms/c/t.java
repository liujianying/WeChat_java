package com.google.android.gms.c;

import android.content.Context;
import java.util.regex.Pattern;

public final class t {
    private static Pattern aXL = null;

    public static boolean ar(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int dv(int i) {
        return i / 1000;
    }

    public static boolean dw(int i) {
        return (i % 1000) / 100 == 3;
    }
}
