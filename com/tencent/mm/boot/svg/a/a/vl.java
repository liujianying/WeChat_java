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

public final class vl extends c {
    private final int height = 111;
    private final int width = 111;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 111;
            case 1:
                return 111;
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
                i2 = c.a(i2, looper);
                i2.setColor(-16074);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(55.5f, 0.0f);
                j.cubicTo(86.15181f, 0.0f, 111.0f, 24.848194f, 111.0f, 55.5f);
                j.cubicTo(111.0f, 86.15181f, 86.15181f, 111.0f, 55.5f, 111.0f);
                j.cubicTo(24.848194f, 111.0f, 0.0f, 86.15181f, 0.0f, 55.5f);
                j.cubicTo(0.0f, 24.848194f, 24.848194f, 0.0f, 55.5f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.0f);
                float[] a3 = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                float[] a5 = c.a(a3, 0.89879405f, -0.43837115f, 23.489042f, 0.43837115f, 0.89879405f, -15.173922f);
                f.reset();
                f.setValues(a5);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(22.994629f, 17.339851f);
                j.cubicTo(22.39213f, 17.121492f, 21.726933f, 17.43036f, 21.509315f, 18.025713f);
                j.lineTo(10.605188f, 47.85707f);
                j.cubicTo(10.388678f, 48.4494f, 10.695863f, 49.10536f, 11.295349f, 49.322624f);
                j.lineTo(66.219894f, 69.228455f);
                j.cubicTo(66.822395f, 69.446815f, 67.487595f, 69.13795f, 67.70521f, 68.542595f);
                j.lineTo(78.60934f, 38.711235f);
                j.cubicTo(78.82584f, 38.118908f, 78.51866f, 37.46295f, 77.919174f, 37.245686f);
                j.lineTo(22.994629f, 17.339851f);
                j.close();
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.ROUND);
                a4.setStrokeJoin(Join.MITER);
                a3 = c.a(a5, 1.0f, 0.0f, 13.269231f, 0.0f, 1.0f, 10.468085f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a4 = c.a(a4, looper);
                a3 = c.a(a3, 0.9975641f, 0.06975647f, -1.867919f, -0.06975647f, 0.9975641f, 2.5683162f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(39.538136f, 6.3106236f);
                j.cubicTo(43.65822f, 4.154688f, 48.062016f, 2.915408f, 52.74952f, 2.5927842f);
                j.cubicTo(59.98247f, 2.5454812f, 65.71933f, 4.7730365f, 68.3616f, 9.330113f);
                j.cubicTo(73.88385f, 18.854218f, 63.797997f, 34.946922f, 45.83423f, 45.274174f);
                j.cubicTo(27.870462f, 55.60143f, 8.831288f, 56.25251f, 3.3090456f, 46.728405f);
                j.cubicTo(2.6508272f, 45.59319f, 2.2143564f, 44.36465f, 1.9865427f, 43.06368f);
                j.cubicTo(1.6337932f, 40.273342f, 1.7985677f, 37.926987f, 2.4808657f, 36.02461f);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
