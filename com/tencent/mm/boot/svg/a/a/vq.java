package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class vq extends c {
    private final int height = 360;
    private final int width = 420;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 420;
            case 1:
                return 360;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(-16777216);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1203649);
                a.setStrokeWidth(6.0f);
                e = c.a(e, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                float[] a3 = c.a(e, 0.89879405f, -0.43837115f, 83.424065f, 0.43837115f, 0.89879405f, -56.94818f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(85.9481f, 53.707603f);
                j.cubicTo(82.400116f, 52.420452f, 78.47858f, 54.243134f, 77.18978f, 57.772533f);
                j.lineTo(36.844513f, 168.25905f);
                j.cubicTo(35.557407f, 171.78381f, 37.38146f, 175.68275f, 40.924824f, 176.96823f);
                j.lineTo(244.14565f, 250.69354f);
                j.cubicTo(247.69362f, 251.98068f, 251.61516f, 250.158f, 252.90396f, 246.6286f);
                j.lineTo(293.24924f, 136.14209f);
                j.cubicTo(294.53632f, 132.61732f, 292.71228f, 128.71838f, 289.1689f, 127.43291f);
                j.lineTo(85.9481f, 53.707603f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                e = c.a(a3, 1.0f, 0.0f, 49.096153f, 0.0f, 1.0f, 30.659575f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.9975641f, 0.06975647f, -7.0905256f, -0.06975647f, 0.9975641f, 9.791511f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(150.75441f, 23.51803f);
                j.cubicTo(166.46516f, 15.288756f, 183.25778f, 10.558386f, 201.13225f, 9.3269205f);
                j.cubicTo(228.71304f, 9.146363f, 250.58891f, 17.649012f, 260.66446f, 35.04352f);
                j.cubicTo(281.722f, 71.39732f, 243.26247f, 132.82368f, 174.76277f, 172.24313f);
                j.cubicTo(106.26306f, 211.66258f, 33.662613f, 214.14778f, 12.605114f, 177.79398f);
                j.cubicTo(10.095186f, 173.46082f, 8.430829f, 168.77145f, 7.5621266f, 163.8056f);
                j.cubicTo(6.2170177f, 153.1548f, 6.845338f, 144.19868f, 9.447086f, 136.93726f);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
