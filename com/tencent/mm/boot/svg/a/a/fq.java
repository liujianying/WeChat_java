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

public final class fq extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-11048043);
                a2.setStrokeWidth(3.0f);
                Path j = c.j(looper);
                j.moveTo(1.5f, 4.5f);
                j.cubicTo(1.5f, 2.8431456f, 2.8431456f, 1.5f, 4.5f, 1.5f);
                j.lineTo(40.5f, 1.5f);
                j.cubicTo(42.156853f, 1.5f, 43.5f, 2.8431456f, 43.5f, 4.5f);
                j.lineTo(43.5f, 28.5f);
                j.cubicTo(43.5f, 30.156855f, 42.156853f, 31.5f, 40.5f, 31.5f);
                j.lineTo(4.5f, 31.5f);
                j.cubicTo(2.8431456f, 31.5f, 1.5f, 30.156855f, 1.5f, 28.5f);
                j.lineTo(1.5f, 4.5f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-11048043);
                j = c.j(looper);
                j.moveTo(6.0f, 17.0f);
                j.cubicTo(6.0f, 16.447716f, 6.4477153f, 16.0f, 7.0f, 16.0f);
                j.lineTo(11.0f, 16.0f);
                j.cubicTo(11.552285f, 16.0f, 12.0f, 16.447716f, 12.0f, 17.0f);
                j.lineTo(12.0f, 21.0f);
                j.cubicTo(12.0f, 21.552284f, 11.552285f, 22.0f, 11.0f, 22.0f);
                j.lineTo(7.0f, 22.0f);
                j.cubicTo(6.4477153f, 22.0f, 6.0f, 21.552284f, 6.0f, 21.0f);
                j.lineTo(6.0f, 17.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-11048043);
                Path j2 = c.j(looper);
                j2.moveTo(6.0f, 9.0f);
                j2.lineTo(39.0f, 9.0f);
                j2.lineTo(39.0f, 12.0f);
                j2.lineTo(6.0f, 12.0f);
                j2.lineTo(6.0f, 9.0f);
                j2.close();
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
