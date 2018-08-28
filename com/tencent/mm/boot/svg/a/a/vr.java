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

public final class vr extends c {
    private final int height = 142;
    private final int width = 156;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 156;
            case 1:
                return 142;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16074);
                a.setStrokeWidth(3.0f);
                e = c.a(e, 1.0f, 0.0f, -7.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                float[] a3 = c.a(e, 0.89879405f, -0.43837115f, 38.56562f, 0.43837115f, 0.89879405f, -26.797539f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(40.230236f, 23.916641f);
                j.cubicTo(38.61875f, 23.330109f, 36.836906f, 24.160997f, 36.250374f, 25.77248f);
                j.lineTo(17.349888f, 77.70114f);
                j.cubicTo(16.763355f, 79.31262f, 17.594244f, 81.09447f, 19.205727f, 81.681f);
                j.lineTo(114.40827f, 116.331894f);
                j.cubicTo(116.01976f, 116.91843f, 117.8016f, 116.08754f, 118.38813f, 114.47605f);
                j.lineTo(137.28862f, 62.547394f);
                j.cubicTo(137.87515f, 60.93591f, 137.04427f, 59.154068f, 135.43279f, 58.567535f);
                j.lineTo(40.230236f, 23.916641f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                e = c.a(a3, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.9975641f, 0.06975647f, -3.3330553f, -0.06975647f, 0.9975641f, 4.58741f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(70.62369f, 11.053474f);
                j.cubicTo(77.98368f, 7.185715f, 85.850494f, 4.9624414f, 94.22412f, 4.3836527f);
                j.cubicTo(107.144844f, 4.298791f, 117.393005f, 8.295036f, 122.11308f, 16.470455f);
                j.cubicTo(131.97786f, 33.556744f, 113.96079f, 62.42713f, 81.87084f, 80.95428f);
                j.cubicTo(49.780895f, 99.481415f, 15.769872f, 100.64946f, 5.9050984f, 83.56317f);
                j.cubicTo(4.7292767f, 81.52658f, 3.9495778f, 79.32258f, 3.542618f, 76.98863f);
                j.cubicTo(2.9124768f, 71.98276f, 3.2068248f, 67.773384f, 4.425662f, 64.36051f);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
