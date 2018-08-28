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

public final class adl extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -166.0f, 0.0f, 1.0f, -265.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 166.0f, 0.0f, 1.0f, 265.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(838860800);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(45.0f, 0.0f);
                j.cubicTo(69.85281f, 0.0f, 90.0f, 20.147184f, 90.0f, 45.0f);
                j.cubicTo(90.0f, 69.85281f, 69.85281f, 90.0f, 45.0f, 90.0f);
                j.cubicTo(20.147184f, 90.0f, 0.0f, 69.85281f, 0.0f, 45.0f);
                j.cubicTo(0.0f, 20.147184f, 20.147184f, 0.0f, 45.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.0f);
                j = c.j(looper);
                j.moveTo(45.0f, 3.0f);
                j.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                j.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                j.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                j.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-1);
                j = c.j(looper);
                j.moveTo(57.0f, 42.0f);
                j.lineTo(63.43934f, 35.56066f);
                j.cubicTo(64.02512f, 34.974873f, 64.97488f, 34.974873f, 65.56066f, 35.56066f);
                j.cubicTo(65.841965f, 35.841965f, 66.0f, 36.223495f, 66.0f, 36.62132f);
                j.lineTo(66.0f, 53.37868f);
                j.cubicTo(66.0f, 54.207108f, 65.32843f, 54.87868f, 64.5f, 54.87868f);
                j.cubicTo(64.10217f, 54.87868f, 63.720646f, 54.720646f, 63.43934f, 54.43934f);
                j.lineTo(57.0f, 48.0f);
                j.lineTo(57.0f, 42.0f);
                j.close();
                j.moveTo(26.208f, 33.0f);
                j.lineTo(51.792f, 33.0f);
                j.cubicTo(53.011444f, 33.0f, 54.0f, 33.988556f, 54.0f, 35.208f);
                j.lineTo(54.0f, 54.792f);
                j.cubicTo(54.0f, 56.011444f, 53.011444f, 57.0f, 51.792f, 57.0f);
                j.lineTo(26.208f, 57.0f);
                j.cubicTo(24.988556f, 57.0f, 24.0f, 56.011444f, 24.0f, 54.792f);
                j.lineTo(24.0f, 35.208f);
                j.cubicTo(24.0f, 33.988556f, 24.988556f, 33.0f, 26.208f, 33.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
