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

public final class tc extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-1686720);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(51.515152f, 100.0f);
                j.cubicTo(22.385763f, 100.0f, 0.0f, 77.614235f, 0.0f, 51.515152f);
                j.cubicTo(0.0f, 22.385763f, 22.385763f, 0.0f, 51.515152f, 0.0f);
                j.cubicTo(77.614235f, 0.0f, 100.0f, 22.385763f, 100.0f, 51.515152f);
                j.cubicTo(100.0f, 77.614235f, 77.614235f, 100.0f, 51.515152f, 100.0f);
                j.close();
                j.moveTo(45.567917f, 25.108103f);
                j.lineTo(47.272728f, 60.909092f);
                j.lineTo(54.545456f, 60.909092f);
                j.lineTo(56.250263f, 25.108103f);
                j.cubicTo(56.309967f, 23.85433f, 55.341984f, 22.789549f, 54.08821f, 22.729845f);
                j.cubicTo(54.052204f, 22.72813f, 54.01616f, 22.727272f, 53.98011f, 22.727272f);
                j.lineTo(47.838074f, 22.727272f);
                j.cubicTo(46.582882f, 22.727272f, 45.565346f, 23.744808f, 45.565346f, 25.0f);
                j.cubicTo(45.565346f, 25.036049f, 45.566204f, 25.072094f, 45.567917f, 25.108103f);
                j.close();
                j.moveTo(50.909092f, 76.818184f);
                j.cubicTo(53.921555f, 76.818184f, 56.363636f, 74.3761f, 56.363636f, 71.36364f);
                j.cubicTo(56.363636f, 68.35117f, 53.921555f, 65.90909f, 50.909092f, 65.90909f);
                j.cubicTo(47.89663f, 65.90909f, 45.454544f, 68.35117f, 45.454544f, 71.36364f);
                j.cubicTo(45.454544f, 74.3761f, 47.89663f, 76.818184f, 50.909092f, 76.818184f);
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
