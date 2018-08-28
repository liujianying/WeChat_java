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

public final class tb extends c {
    private final int height = 68;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 68;
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
                e = c.a(e, 1.1333333f, 0.0f, 0.0f, 0.0f, 1.1333333f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                Path j = c.j(looper);
                j.moveTo(24.0f, 6.0f);
                j.lineTo(24.0f, 13.582962f);
                j.cubicTo(24.0f, 16.068243f, 26.014719f, 18.082962f, 28.5f, 18.082962f);
                j.cubicTo(30.985281f, 18.082962f, 33.0f, 16.068243f, 33.0f, 13.582962f);
                j.lineTo(33.0f, 6.0f);
                j.cubicTo(36.54742f, 7.710701f, 39.0f, 11.381189f, 39.0f, 15.633177f);
                j.cubicTo(39.0f, 19.693186f, 36.763893f, 23.223017f, 33.473682f, 25.022778f);
                j.lineTo(33.473682f, 49.026318f);
                j.cubicTo(33.473682f, 51.773205f, 31.24689f, 54.0f, 28.5f, 54.0f);
                j.cubicTo(25.75311f, 54.0f, 23.526316f, 51.773205f, 23.526316f, 49.026318f);
                j.lineTo(23.526316f, 25.022778f);
                j.cubicTo(20.236107f, 23.223017f, 18.0f, 19.693186f, 18.0f, 15.633177f);
                j.cubicTo(18.0f, 11.381189f, 20.45258f, 7.710701f, 24.0f, 6.0f);
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
