package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ass extends c {
    private final int height = 279;
    private final int width = 279;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -401.0f, 0.0f, 1.0f, -470.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 390.0f, 0.0f, 1.0f, 470.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2245500);
                Path j = c.j(looper);
                j.moveTo(279.0f, 141.22223f);
                j.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                j.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                j.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                j.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(69.47473f, 146.5967f);
                j.lineTo(75.88924f, 137.86859f);
                j.cubicTo(76.37983f, 137.20105f, 77.31869f, 137.0576f, 77.98622f, 137.5482f);
                j.cubicTo(77.99435f, 137.55417f, 78.0024f, 137.56023f, 78.01041f, 137.56635f);
                j.lineTo(115.591606f, 166.3702f);
                j.cubicTo(116.14801f, 166.79663f, 116.92558f, 166.78082f, 117.464195f, 166.33212f);
                j.lineTo(208.74998f, 90.283676f);
                j.cubicTo(209.34323f, 89.78945f, 210.21474f, 89.826324f, 210.76411f, 90.36889f);
                j.lineTo(216.78378f, 96.313896f);
                j.cubicTo(217.37321f, 96.89602f, 217.37914f, 97.84574f, 216.79703f, 98.43517f);
                j.cubicTo(216.79202f, 98.44024f, 216.78699f, 98.44527f, 216.78192f, 98.45026f);
                j.lineTo(117.6191f, 196.04128f);
                j.cubicTo(117.028656f, 196.62236f, 116.07894f, 196.61478f, 115.49785f, 196.02432f);
                j.cubicTo(115.49463f, 196.02106f, 115.491425f, 196.01776f, 115.488235f, 196.01447f);
                j.lineTo(69.6047f, 148.52728f);
                j.cubicTo(69.09662f, 148.00145f, 69.04172f, 147.18588f, 69.47473f, 146.5967f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
