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

public final class arv extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(72.0f, 124.8f);
                j.cubicTo(101.16064f, 124.8f, 124.8f, 101.16064f, 124.8f, 72.0f);
                j.cubicTo(124.8f, 42.839367f, 101.16064f, 19.2f, 72.0f, 19.2f);
                j.cubicTo(42.839367f, 19.2f, 19.2f, 42.839367f, 19.2f, 72.0f);
                j.cubicTo(19.2f, 101.16064f, 42.839367f, 124.8f, 72.0f, 124.8f);
                j.close();
                j.moveTo(72.0f, 132.0f);
                j.cubicTo(38.862915f, 132.0f, 12.0f, 105.137085f, 12.0f, 72.0f);
                j.cubicTo(12.0f, 38.862915f, 38.862915f, 12.0f, 72.0f, 12.0f);
                j.cubicTo(105.137085f, 12.0f, 132.0f, 38.862915f, 132.0f, 72.0f);
                j.cubicTo(132.0f, 105.137085f, 105.137085f, 132.0f, 72.0f, 132.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(72.0f, 106.8f);
                j.cubicTo(91.21951f, 106.8f, 106.8f, 91.21951f, 106.8f, 72.0f);
                j.cubicTo(106.8f, 52.78049f, 91.21951f, 37.2f, 72.0f, 37.2f);
                j.cubicTo(52.78049f, 37.2f, 37.2f, 52.78049f, 37.2f, 72.0f);
                j.cubicTo(37.2f, 91.21951f, 52.78049f, 106.8f, 72.0f, 106.8f);
                j.close();
                j.moveTo(72.0f, 114.0f);
                j.cubicTo(48.80404f, 114.0f, 30.0f, 95.19596f, 30.0f, 72.0f);
                j.cubicTo(30.0f, 48.80404f, 48.80404f, 30.0f, 72.0f, 30.0f);
                j.cubicTo(95.19596f, 30.0f, 114.0f, 48.80404f, 114.0f, 72.0f);
                j.cubicTo(114.0f, 95.19596f, 95.19596f, 114.0f, 72.0f, 114.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
