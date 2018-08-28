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

public final class tj extends c {
    private final int height = 28;
    private final int width = 14;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 28;
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
                canvas.saveLayerAlpha(null, 83, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                e = c.a(e, -1.0f, 1.2246469E-16f, 13.0f, -1.2246469E-16f, -1.0f, 26.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(9.545941f, 17.419352f);
                j.lineTo(8.485281f, 18.480011f);
                j.lineTo(2.7063844f, 12.701114f);
                j.cubicTo(2.3162591f, 12.310988f, 2.3127985f, 11.681931f, 2.7063844f, 11.288345f);
                j.lineTo(8.485281f, 5.509448f);
                j.lineTo(9.545941f, 6.5701084f);
                j.lineTo(4.1213202f, 11.99473f);
                j.lineTo(9.545941f, 17.419352f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
