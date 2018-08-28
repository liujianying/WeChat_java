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

public final class ks extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.saveLayerAlpha(null, 76, 4);
                i2 = c.a(i2, looper);
                i2.setColor(-16777216);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(37.233665f, 33.873493f);
                j.lineTo(44.40146f, 41.041286f);
                j.lineTo(42.72137f, 42.72137f);
                j.lineTo(9.600087f, 9.600086f);
                j.lineTo(11.280172f, 7.92f);
                j.lineTo(15.06498f, 11.704807f);
                j.cubicTo(16.369446f, 10.304305f, 18.008224f, 9.2193365f, 19.854246f, 8.57697f);
                j.cubicTo(19.818567f, 8.363288f, 19.8f, 8.143812f, 19.8f, 7.92f);
                j.cubicTo(19.8f, 5.7329526f, 21.572952f, 3.96f, 23.76f, 3.96f);
                j.cubicTo(25.947048f, 3.96f, 27.72f, 5.7329526f, 27.72f, 7.92f);
                j.cubicTo(27.72f, 8.143812f, 27.701433f, 8.363288f, 27.665754f, 8.57697f);
                j.cubicTo(32.30823f, 10.192428f, 35.64f, 14.607125f, 35.64f, 19.8f);
                j.lineTo(35.64f, 27.72f);
                j.cubicTo(35.64f, 29.771164f, 36.171223f, 31.822327f, 37.233665f, 33.873493f);
                j.close();
                j.moveTo(36.239826f, 39.6f);
                j.lineTo(5.94f, 39.6f);
                j.cubicTo(9.9f, 35.64f, 11.88f, 31.68f, 11.88f, 27.72f);
                j.lineTo(11.88f, 19.8f);
                j.cubicTo(11.88f, 18.432533f, 12.111043f, 17.11903f, 12.536222f, 15.896395f);
                j.lineTo(36.239826f, 39.6f);
                j.close();
                j.moveTo(21.78f, 41.58f);
                j.lineTo(25.74f, 41.58f);
                j.lineTo(25.74f, 41.976f);
                j.cubicTo(25.74f, 43.069523f, 24.853523f, 43.956f, 23.76f, 43.956f);
                j.cubicTo(22.666475f, 43.956f, 21.78f, 43.069523f, 21.78f, 41.976f);
                j.lineTo(21.78f, 41.58f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
