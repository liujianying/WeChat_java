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

public final class pr extends c {
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                e = c.a(e, 0.70710677f, 0.70710677f, -19.882248f, -0.70710677f, 0.70710677f, 48.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j2 = c.j(looper);
                j2.moveTo(50.0f, 24.0f);
                j2.lineTo(46.0f, 24.0f);
                j2.lineTo(46.0f, 46.0f);
                j2.lineTo(24.0f, 46.0f);
                j2.lineTo(24.0f, 50.0f);
                j2.lineTo(46.0f, 50.0f);
                j2.lineTo(46.0f, 72.0f);
                j2.lineTo(50.0f, 72.0f);
                j2.lineTo(50.0f, 50.0f);
                j2.lineTo(72.0f, 50.0f);
                j2.lineTo(72.0f, 46.0f);
                j2.lineTo(50.0f, 46.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.saveLayerAlpha(null, 76, 4);
                i2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
