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

public final class v extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                i2 = c.a(i2, looper);
                i2.setColor(-16777216);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(51.487274f, 48.305294f);
                j.lineTo(62.849243f, 59.667263f);
                j.lineTo(59.667263f, 62.849243f);
                j.lineTo(48.305294f, 51.487274f);
                j.cubicTo(44.15103f, 54.930374f, 38.817215f, 57.0f, 33.0f, 57.0f);
                j.cubicTo(19.745142f, 57.0f, 9.0f, 46.254856f, 9.0f, 33.0f);
                j.cubicTo(9.0f, 19.745142f, 19.745142f, 9.0f, 33.0f, 9.0f);
                j.cubicTo(46.254856f, 9.0f, 57.0f, 19.745142f, 57.0f, 33.0f);
                j.cubicTo(57.0f, 38.817215f, 54.930374f, 44.15103f, 51.487274f, 48.305294f);
                j.close();
                j.moveTo(52.54228f, 33.006664f);
                j.cubicTo(52.54228f, 22.237095f, 43.81185f, 13.506665f, 33.04228f, 13.506665f);
                j.cubicTo(22.272707f, 13.506665f, 13.542279f, 22.237095f, 13.542279f, 33.006664f);
                j.cubicTo(13.542279f, 43.776237f, 22.272707f, 52.506664f, 33.04228f, 52.506664f);
                j.cubicTo(43.81185f, 52.506664f, 52.54228f, 43.776237f, 52.54228f, 33.006664f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
