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

public final class ai extends c {
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
                j.moveTo(60.9f, 59.4f);
                j.lineTo(60.9f, 57.94639f);
                j.cubicTo(60.9f, 57.25818f, 60.19404f, 56.13006f, 59.57943f, 55.83026f);
                j.lineTo(42.59837f, 47.54712f);
                j.cubicTo(38.018623f, 45.31318f, 36.88672f, 39.90874f, 40.16801f, 36.019104f);
                j.lineTo(41.25261f, 34.733425f);
                j.cubicTo(42.906586f, 32.772804f, 44.4f, 28.693172f, 44.4f, 26.130558f);
                j.lineTo(44.4f, 21.000622f);
                j.cubicTo(44.4f, 16.364742f, 40.63677f, 12.6f, 36.0f, 12.6f);
                j.cubicTo(31.368927f, 12.6f, 27.6f, 16.365608f, 27.6f, 20.998741f);
                j.lineTo(27.6f, 26.127872f);
                j.cubicTo(27.6f, 28.696991f, 29.08724f, 32.76145f, 30.747236f, 34.728935f);
                j.lineTo(31.831833f, 36.01444f);
                j.cubicTo(35.119907f, 39.91158f, 33.975643f, 45.31095f, 29.402159f, 47.54276f);
                j.lineTo(12.421099f, 55.82933f);
                j.cubicTo(11.811051f, 56.127026f, 11.1f, 57.26603f, 11.1f, 57.94639f);
                j.lineTo(11.1f, 59.4f);
                j.lineTo(60.9f, 59.4f);
                j.close();
                j.moveTo(7.5f, 60.0f);
                j.lineTo(7.5f, 57.94639f);
                j.cubicTo(7.5f, 55.891125f, 8.994452f, 53.495724f, 10.842293f, 52.593998f);
                j.lineTo(27.823353f, 44.30743f);
                j.cubicTo(30.28613f, 43.10562f, 30.858778f, 40.443787f, 29.080336f, 38.33592f);
                j.lineTo(27.995739f, 37.050415f);
                j.cubicTo(25.788954f, 34.434856f, 24.0f, 29.548489f, 24.0f, 26.127872f);
                j.lineTo(24.0f, 20.998741f);
                j.cubicTo(24.0f, 14.37202f, 29.386068f, 9.0f, 36.0f, 9.0f);
                j.cubicTo(42.62742f, 9.0f, 48.0f, 14.378941f, 48.0f, 21.000622f);
                j.lineTo(48.0f, 26.130558f);
                j.cubicTo(48.0f, 29.547888f, 46.202797f, 34.44858f, 44.00426f, 37.054718f);
                j.lineTo(42.919662f, 38.340397f);
                j.cubicTo(41.151096f, 40.43685f, 41.703564f, 43.105194f, 44.176647f, 44.31153f);
                j.lineTo(61.157707f, 52.594673f);
                j.cubicTo(63.003605f, 53.49508f, 64.5f, 55.87551f, 64.5f, 57.94639f);
                j.lineTo(64.5f, 60.0f);
                j.cubicTo(64.5f, 61.656853f, 63.156853f, 63.0f, 61.5f, 63.0f);
                j.lineTo(10.5f, 63.0f);
                j.cubicTo(8.843145f, 63.0f, 7.5f, 61.656853f, 7.5f, 60.0f);
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
