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

public final class akw extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                a.setColor(-2697514);
                Path j = c.j(looper);
                j.moveTo(12.0f, 0.0f);
                j.cubicTo(5.3716516f, 0.0f, 0.0f, 5.3716516f, 0.0f, 12.0f);
                j.cubicTo(0.0f, 18.628347f, 5.3716516f, 24.0f, 12.0f, 24.0f);
                j.cubicTo(18.628347f, 24.0f, 24.0f, 18.628347f, 24.0f, 12.0f);
                j.cubicTo(24.0f, 5.3716516f, 18.628347f, 0.0f, 12.0f, 0.0f);
                j.close();
                j.moveTo(12.148247f, 12.97082f);
                j.lineTo(18.91682f, 15.12273f);
                j.lineTo(18.506933f, 16.406258f);
                j.lineTo(10.797303f, 13.955056f);
                j.lineTo(10.797303f, 3.1551237f);
                j.lineTo(12.145618f, 3.1551237f);
                j.lineTo(12.145618f, 12.97082f);
                j.lineTo(12.148247f, 12.97082f);
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
