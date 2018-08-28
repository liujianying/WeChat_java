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

public final class api extends c {
    private final int height = 11;
    private final int width = 6;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 6;
            case 1:
                return 11;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-855310);
                e = c.a(e, 1.0f, 0.0f, -80.0f, 0.0f, 1.0f, -322.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 318.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, -1.0f, 0.0f, 98.0f, 0.0f, -1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(52.0f, 14.3125f);
                j.lineTo(51.30351f, 15.0f);
                j.lineTo(46.16417f, 9.9270115f);
                j.cubicTo(45.928337f, 9.694224f, 45.92587f, 9.314333f, 46.158653f, 9.078502f);
                j.cubicTo(46.16048f, 9.076652f, 46.16232f, 9.074814f, 46.16417f, 9.0729885f);
                j.lineTo(51.30351f, 4.0f);
                j.lineTo(52.0f, 4.6875f);
                j.lineTo(47.124554f, 9.5f);
                j.lineTo(52.0f, 14.3125f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
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
