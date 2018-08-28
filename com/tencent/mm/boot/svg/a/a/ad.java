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

public final class ad extends c {
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
                i2.setColor(-16777216);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(31.508831f, 53.4f);
                j.lineTo(61.5f, 53.4f);
                j.cubicTo(61.997055f, 53.4f, 62.4f, 52.997055f, 62.4f, 52.5f);
                j.lineTo(62.4f, 16.5f);
                j.cubicTo(62.4f, 16.002943f, 61.997055f, 15.6f, 61.5f, 15.6f);
                j.lineTo(10.5f, 15.6f);
                j.cubicTo(10.002944f, 15.6f, 9.6f, 16.002943f, 9.6f, 16.5f);
                j.lineTo(9.6f, 52.5f);
                j.cubicTo(9.6f, 52.997055f, 10.002944f, 53.4f, 10.5f, 53.4f);
                j.lineTo(24.6f, 53.4f);
                j.lineTo(24.6f, 60.30883f);
                j.lineTo(31.508831f, 53.4f);
                j.close();
                j.moveTo(26.12132f, 63.87868f);
                j.cubicTo(24.949747f, 65.050255f, 23.050253f, 65.050255f, 21.87868f, 63.87868f);
                j.cubicTo(21.31607f, 63.31607f, 21.0f, 62.55301f, 21.0f, 61.75736f);
                j.lineTo(21.0f, 57.0f);
                j.lineTo(10.5f, 57.0f);
                j.cubicTo(8.014719f, 57.0f, 6.0f, 54.985283f, 6.0f, 52.5f);
                j.lineTo(6.0f, 16.5f);
                j.cubicTo(6.0f, 14.014719f, 8.014719f, 12.0f, 10.5f, 12.0f);
                j.lineTo(61.5f, 12.0f);
                j.cubicTo(63.985283f, 12.0f, 66.0f, 14.014719f, 66.0f, 16.5f);
                j.lineTo(66.0f, 52.5f);
                j.cubicTo(66.0f, 54.985283f, 63.985283f, 57.0f, 61.5f, 57.0f);
                j.lineTo(33.0f, 57.0f);
                j.lineTo(26.12132f, 63.87868f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
