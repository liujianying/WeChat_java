package com.tencent.mm.t;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mm.bd.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a implements Cloneable {
    public static Paint dnA = new Paint();
    public static Paint dnB = new Paint();
    public static Paint dnC = new Paint();
    public static Paint dnD = new Paint();
    private static int dnt = ((int) ad.getResources().getDimension(c.box_line_width));
    private static int dnu = ((int) ad.getResources().getDimension(c.box_gird_width));
    public static float dnv = ad.getResources().getDimension(c.corner_width);
    public static float dnw = ad.getResources().getDimension(c.corner_length);
    public static Path dnx = new Path();
    public static Path dny = new Path();
    public static Paint dnz = new Paint();
    public static Rect ea = new Rect();
    public Rect bwl;
    public Rect dnE = new Rect();
    public Rect dnF = new Rect();
    public Matrix mMatrix = new Matrix();

    static {
        dnB.setColor(-16777216);
        dnz.setColor(-1);
        dnz.setStrokeWidth((float) dnt);
        dnz.setStyle(Style.STROKE);
        dnz.setAntiAlias(true);
        dnC.set(dnz);
        dnC.setStrokeWidth((float) dnu);
        dnD.set(dnz);
        dnD.setStrokeWidth(dnv);
        dnA.set(dnz);
        dnA.setStrokeWidth((float) (dnt * 7));
        dnA.setColor(549174203);
    }

    public a(Rect rect) {
        this.bwl = rect;
    }

    public static void gs(int i) {
        dnD.setAlpha(i);
        dnz.setAlpha(i);
        dnC.setAlpha((int) (0.7058824f * ((float) i)));
    }

    public static void gt(int i) {
        dnB.setAlpha((int) (0.9019608f * ((float) i)));
    }

    public final Object clone() {
        return super.clone();
    }
}
