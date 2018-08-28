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

public final class td extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16139513);
                Path j = c.j(looper);
                j.moveTo(100.0f, 50.346603f);
                j.cubicTo(100.0f, 22.265478f, 77.614815f, 0.0f, 49.382717f, 0.0f);
                j.cubicTo(22.385185f, 0.0f, 0.0f, 22.265478f, 0.0f, 50.346603f);
                j.cubicTo(0.0f, 77.19976f, 22.385185f, 99.46524f, 49.382717f, 99.46524f);
                j.cubicTo(77.614815f, 99.46524f, 100.0f, 77.19976f, 100.0f, 50.346603f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(26.066193f, 52.06067f);
                j.cubicTo(25.683428f, 51.666645f, 25.640087f, 50.985928f, 25.972504f, 50.536034f);
                j.lineTo(27.666462f, 48.243423f);
                j.cubicTo(27.997484f, 47.795414f, 28.617992f, 47.700703f, 29.062307f, 48.03942f);
                j.lineTo(41.715767f, 57.68571f);
                j.cubicTo(42.155647f, 58.021053f, 42.853935f, 58.00976f, 43.289238f, 57.64906f);
                j.lineTo(75.15912f, 31.240854f);
                j.cubicTo(75.58824f, 30.885271f, 76.25674f, 30.911966f, 76.65116f, 31.299417f);
                j.lineTo(78.11376f, 32.736153f);
                j.cubicTo(78.508675f, 33.12408f, 78.51484f, 33.745895f, 78.11964f, 34.132755f);
                j.lineTo(43.220352f, 68.2952f);
                j.cubicTo(42.828686f, 68.6786f, 42.199085f, 68.66812f, 41.81812f, 68.275955f);
                j.lineTo(26.066193f, 52.06067f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
