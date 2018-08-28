package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class a$1 implements b {
    final /* synthetic */ g fAR;

    public a$1(g gVar) {
        this.fAR = gVar;
    }

    public final Typeface bR(String str) {
        Typeface typeface = null;
        x.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[]{str});
        if (str == null || str.length() == 0) {
            return typeface;
        }
        String g;
        if (str.startsWith("wxfile://")) {
            g = g(this.fAR, str);
        } else {
            g = h(this.fAR, str);
        }
        if (g == null) {
            return typeface;
        }
        try {
            return Typeface.createFromFile(g);
        } catch (Exception e) {
            x.e("MBFontManagerRegistry", "Create typeface from file failed. pkgPath = [%s], filePath = [%s]", new Object[]{str, g});
            return typeface;
        }
    }

    private static String g(g gVar, String str) {
        try {
            File rb = gVar.fcw.rb(str);
            if (rb != null) {
                return rb.getAbsolutePath();
            }
            x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[]{str});
            return null;
        } catch (Exception e) {
            x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[]{str});
            return null;
        }
    }

    private static String h(g gVar, String str) {
        String str2 = null;
        try {
            return ao.f(gVar, str);
        } catch (Exception e) {
            x.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[]{str});
            return str2;
        }
    }
}
