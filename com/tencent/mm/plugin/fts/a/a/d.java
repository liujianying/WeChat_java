package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class d {
    public TextPaint dug;
    public int jrA = a.jrH;
    public int jrB = Color.parseColor("#45C01A");
    public float jrC;
    public CharSequence jrD = "";
    public CharSequence jrE = "";
    public String jrF = "";
    public String jrG = "";
    public CharSequence jrw;
    public g jrx;
    public boolean jry;
    public boolean jrz;

    public static final d a(CharSequence charSequence, List<String> list) {
        return b(charSequence, bi.c(list, " "));
    }

    public static final d b(CharSequence charSequence, String str) {
        d dVar = new d();
        dVar.jrw = charSequence;
        dVar.jrx = g.ax(str, false);
        dVar.jry = false;
        dVar.jrz = false;
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar) {
        d dVar = new d();
        dVar.jrw = charSequence;
        dVar.jrx = gVar;
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2) {
        return a(charSequence, gVar, z, z2, 0.0f, null);
    }

    public static final d a(CharSequence charSequence, g gVar, float f, TextPaint textPaint) {
        return a(charSequence, gVar, false, false, f, textPaint);
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2, float f, TextPaint textPaint) {
        d dVar = new d();
        dVar.jrw = charSequence;
        dVar.jrx = gVar;
        dVar.jry = z;
        dVar.jrz = z2;
        dVar.jrC = f;
        dVar.dug = textPaint;
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2, TextPaint textPaint, CharSequence charSequence2, CharSequence charSequence3) {
        d dVar = new d();
        dVar.jrw = charSequence;
        dVar.jrx = gVar;
        dVar.jry = z;
        dVar.jrz = z2;
        dVar.jrC = 400.0f;
        dVar.dug = textPaint;
        dVar.jrD = charSequence2;
        dVar.jrE = charSequence3;
        return dVar;
    }

    public static final a a(CharSequence charSequence, List<String> list, int i, int i2) {
        d a = a(charSequence, (List) list);
        a.jrA = i;
        a.jrB = i2;
        return a;
    }
}
