package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ab extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(18.0f, 37.5f);
                j.cubicTo(18.0f, 39.9849f, 15.9849f, 42.0f, 13.5f, 42.0f);
                j.cubicTo(11.0151f, 42.0f, 9.0f, 39.9849f, 9.0f, 37.5f);
                j.cubicTo(9.0f, 35.0142f, 11.0151f, 33.0f, 13.5f, 33.0f);
                j.cubicTo(15.9849f, 33.0f, 18.0f, 35.0142f, 18.0f, 37.5f);
                j.close();
                j.moveTo(34.5f, 33.0f);
                j.cubicTo(36.9849f, 33.0f, 39.0f, 35.0142f, 39.0f, 37.5f);
                j.cubicTo(39.0f, 39.9849f, 36.9849f, 42.0f, 34.5f, 42.0f);
                j.cubicTo(32.0151f, 42.0f, 30.0f, 39.9849f, 30.0f, 37.5f);
                j.cubicTo(30.0f, 35.0142f, 32.0151f, 33.0f, 34.5f, 33.0f);
                j.close();
                j.moveTo(55.5f, 33.0f);
                j.cubicTo(57.9849f, 33.0f, 60.0f, 35.0142f, 60.0f, 37.5f);
                j.cubicTo(60.0f, 39.9849f, 57.9849f, 42.0f, 55.5f, 42.0f);
                j.cubicTo(53.0151f, 42.0f, 51.0f, 39.9849f, 51.0f, 37.5f);
                j.cubicTo(51.0f, 35.0142f, 53.0151f, 33.0f, 55.5f, 33.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
