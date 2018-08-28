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

public final class nd extends c {
    private final int height = 48;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 48;
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
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                e = c.a(e, 1.0f, 0.0f, -6.0f, 0.0f, 1.0f, -12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(28.926662f, 15.6f);
                j.lineTo(22.926662f, 24.6f);
                j.lineTo(9.6f, 24.6f);
                j.lineTo(9.6f, 56.4f);
                j.lineTo(62.4f, 56.4f);
                j.lineTo(62.4f, 24.6f);
                j.lineTo(49.073338f, 24.6f);
                j.lineTo(43.073338f, 15.6f);
                j.lineTo(28.926662f, 15.6f);
                j.close();
                j.moveTo(44.197224f, 12.0f);
                j.cubicTo(44.698753f, 12.0f, 45.167103f, 12.250651f, 45.4453f, 12.66795f);
                j.lineTo(51.0f, 21.0f);
                j.lineTo(63.0f, 21.0f);
                j.cubicTo(64.65685f, 21.0f, 66.0f, 22.343145f, 66.0f, 24.0f);
                j.lineTo(66.0f, 57.0f);
                j.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                j.lineTo(9.0f, 60.0f);
                j.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                j.lineTo(6.0f, 24.0f);
                j.cubicTo(6.0f, 22.343145f, 7.343146f, 21.0f, 9.0f, 21.0f);
                j.lineTo(21.0f, 21.0f);
                j.lineTo(26.5547f, 12.66795f);
                j.cubicTo(26.8329f, 12.250651f, 27.301247f, 12.0f, 27.802776f, 12.0f);
                j.lineTo(44.197224f, 12.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(36.0f, 48.0f);
                j.cubicTo(40.970562f, 48.0f, 45.0f, 43.970562f, 45.0f, 39.0f);
                j.cubicTo(45.0f, 34.029438f, 40.970562f, 30.0f, 36.0f, 30.0f);
                j.cubicTo(31.029438f, 30.0f, 27.0f, 34.029438f, 27.0f, 39.0f);
                j.cubicTo(27.0f, 43.970562f, 31.029438f, 48.0f, 36.0f, 48.0f);
                j.close();
                j.moveTo(36.0f, 51.6f);
                j.cubicTo(29.041212f, 51.6f, 23.4f, 45.958786f, 23.4f, 39.0f);
                j.cubicTo(23.4f, 32.041214f, 29.041212f, 26.4f, 36.0f, 26.4f);
                j.cubicTo(42.958786f, 26.4f, 48.6f, 32.041214f, 48.6f, 39.0f);
                j.cubicTo(48.6f, 45.958786f, 42.958786f, 51.6f, 36.0f, 51.6f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
