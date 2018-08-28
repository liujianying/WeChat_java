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

public final class oh extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(45.0513f, 58.846f);
                j.lineTo(48.5133f, 60.0f);
                j.lineTo(32.4863f, 60.0f);
                j.lineTo(35.9483f, 58.846f);
                j.lineTo(38.0003f, 58.162f);
                j.lineTo(38.0003f, 56.0f);
                j.lineTo(38.0003f, 52.0f);
                j.lineTo(43.0003f, 52.0f);
                j.lineTo(43.0003f, 56.0f);
                j.lineTo(43.0003f, 58.162f);
                j.lineTo(45.0513f, 58.846f);
                j.close();
                j.moveTo(35.0003f, 49.0f);
                j.lineTo(3.0003f, 49.0f);
                j.lineTo(3.0003f, 3.0f);
                j.lineTo(77.0003f, 3.0f);
                j.lineTo(77.0003f, 29.0f);
                j.lineTo(80.0003f, 29.0f);
                j.lineTo(80.0003f, 2.87f);
                j.cubicTo(80.0003f, 1.285f, 78.7143f, 0.0f, 77.1293f, 0.0f);
                j.lineTo(2.8713f, 0.0f);
                j.cubicTo(1.2893f, 0.0f, 3.0E-4f, 1.285f, 3.0E-4f, 2.87f);
                j.lineTo(3.0E-4f, 49.13f);
                j.cubicTo(3.0E-4f, 50.715f, 1.2853f, 52.0f, 2.8713f, 52.0f);
                j.lineTo(35.0003f, 52.0f);
                j.lineTo(35.0003f, 56.0f);
                j.lineTo(23.0003f, 60.0f);
                j.lineTo(23.0003f, 63.0f);
                j.lineTo(58.0003f, 63.0f);
                j.lineTo(58.0003f, 60.0f);
                j.lineTo(46.0003f, 56.0f);
                j.lineTo(46.0003f, 52.0f);
                j.lineTo(59.0003f, 52.0f);
                j.lineTo(59.0003f, 49.0f);
                j.lineTo(46.0003f, 49.0f);
                j.lineTo(35.0003f, 49.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 30.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(25.5f, 28.6132f);
                j.cubicTo(25.5f, 29.3782f, 24.881f, 30.0002f, 24.132f, 30.0002f);
                j.lineTo(4.868f, 30.0002f);
                j.cubicTo(4.11f, 30.0002f, 3.5f, 29.3872f, 3.5f, 28.6132f);
                j.lineTo(3.5f, 14.3872f);
                j.cubicTo(3.5f, 13.6222f, 4.119f, 13.0002f, 4.868f, 13.0002f);
                j.lineTo(24.132f, 13.0002f);
                j.cubicTo(24.89f, 13.0002f, 25.5f, 13.6122f, 25.5f, 14.3872f);
                j.lineTo(25.5f, 28.6132f);
                j.close();
                j.moveTo(9.0f, 5.4992f);
                j.cubicTo(9.0f, 4.3952f, 9.9f, 3.5002f, 10.992f, 3.5002f);
                j.lineTo(18.008f, 3.5002f);
                j.cubicTo(19.108f, 3.5002f, 20.0f, 4.3872f, 20.0f, 5.4992f);
                j.lineTo(20.0f, 10.0002f);
                j.lineTo(9.0f, 10.0002f);
                j.lineTo(9.0f, 5.4992f);
                j.close();
                j.moveTo(24.132f, 10.0002f);
                j.lineTo(23.0f, 10.0002f);
                j.lineTo(23.0f, 6.2542f);
                j.cubicTo(23.0f, 3.0742f, 20.423f, 0.5002f, 17.245f, 0.5002f);
                j.lineTo(11.755f, 0.5002f);
                j.cubicTo(8.582f, 0.5002f, 6.0f, 3.0762f, 6.0f, 6.2542f);
                j.lineTo(6.0f, 10.0002f);
                j.lineTo(4.868f, 10.0002f);
                j.cubicTo(2.459f, 10.0002f, 0.5f, 11.9682f, 0.5f, 14.3872f);
                j.lineTo(0.5f, 28.6132f);
                j.cubicTo(0.5f, 31.0422f, 2.45f, 33.0002f, 4.868f, 33.0002f);
                j.lineTo(24.132f, 33.0002f);
                j.cubicTo(26.541f, 33.0002f, 28.5f, 31.0322f, 28.5f, 28.6132f);
                j.lineTo(28.5f, 14.3872f);
                j.cubicTo(28.5f, 11.9582f, 26.55f, 10.0002f, 24.132f, 10.0002f);
                j.lineTo(24.132f, 10.0002f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
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