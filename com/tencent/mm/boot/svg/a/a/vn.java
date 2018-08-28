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
import com.tencent.smtt.sdk.WebView;

public final class vn extends c {
    private final int height = 120;
    private final int width = 140;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 140;
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
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
                float[] a2 = c.a(e, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(22.030169f, 30.0f);
                j.cubicTo(21.113115f, 70.0f, 41.103058f, 90.0f, 82.0f, 90.0f);
                j.cubicTo(79.92564f, 53.785316f, 59.935696f, 33.785316f, 22.030169f, 30.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                e = c.a(a2, -1.0f, 0.0f, 162.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(66.01508f, 48.0f);
                j.cubicTo(65.55656f, 68.0f, 75.55153f, 78.0f, 96.0f, 78.0f);
                j.cubicTo(94.96282f, 59.89266f, 84.96785f, 49.89266f, 66.01508f, 48.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
