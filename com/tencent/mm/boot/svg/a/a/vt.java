package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.svg.c;

public final class vt extends c {
    private final int height = 120;
    private final int width = b.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return b.CTRL_INDEX;
            case 1:
                return 120;
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
                i2.setStrokeCap(Cap.ROUND);
                i2.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-25290);
                a.setStrokeWidth(2.0f);
                e = c.a(e, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.0f, 42.220886f);
                j.cubicTo(37.25718f, 26.622805f, 49.25718f, 25.956137f, 60.0f, 40.220886f);
                j.cubicTo(70.74282f, 54.485634f, 82.74282f, 55.152298f, 96.0f, 42.220886f);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(24.0f, 62.220886f);
                j.cubicTo(37.25718f, 46.622803f, 49.25718f, 45.95614f, 60.0f, 60.220886f);
                j.cubicTo(70.74282f, 74.485634f, 82.74282f, 75.1523f, 96.0f, 62.220886f);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(24.0f, 82.22089f);
                j.cubicTo(37.25718f, 66.6228f, 49.25718f, 65.95614f, 60.0f, 80.22089f);
                j.cubicTo(70.74282f, 94.485634f, 82.74282f, 95.1523f, 96.0f, 82.22089f);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
