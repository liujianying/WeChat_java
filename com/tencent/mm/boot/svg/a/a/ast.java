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

public final class ast extends c {
    private final int height = 30;
    private final int width = 17;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 17;
            case 1:
                return 30;
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
                a.setColor(-2601405);
                e = c.a(e, 1.0f, 0.0f, -754.0f, 0.0f, 1.0f, -1530.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 310.0f, 0.0f, 1.0f, 1513.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 444.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, -3.514718f, -0.70710677f, 0.70710677f, 8.485281f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(6.9852815f, -2.0147185f);
                j.lineTo(9.985281f, -2.0147185f);
                j.lineTo(9.985281f, 18.985281f);
                j.lineTo(6.9852815f, 18.985281f);
                j.lineTo(6.9852815f, -2.0147185f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, -12.707106f, 0.70710677f, -0.70710677f, 30.67767f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j2 = c.j(looper);
                j2.moveTo(6.9852815f, 10.985281f);
                j2.lineTo(9.985281f, 10.985281f);
                j2.lineTo(9.985281f, 31.985281f);
                j2.lineTo(6.9852815f, 31.985281f);
                j2.lineTo(6.9852815f, 10.985281f);
                j2.close();
                canvas.drawPath(j2, a);
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
