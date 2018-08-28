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

public final class aap extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(-14046139);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(i3, looper));
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(48.7577f, 15.974849f);
                j2.lineTo(27.774939f, 3.7349038f);
                j2.cubicTo(27.466654f, 3.5550714f, 26.53348f, 3.554993f, 26.225061f, 3.7349038f);
                j2.lineTo(5.2423f, 15.974849f);
                j2.lineTo(27.0f, 28.536663f);
                j2.lineTo(48.7577f, 15.974849f);
                j2.close();
                j2.moveTo(50.4f, 19.183588f);
                j2.lineTo(28.8f, 31.654354f);
                j2.lineTo(28.8f, 56.89739f);
                j2.lineTo(49.59719f, 44.765697f);
                j2.cubicTo(49.920998f, 44.57681f, 50.4f, 43.743988f, 50.4f, 43.37328f);
                j2.lineTo(50.4f, 19.183588f);
                j2.close();
                j2.moveTo(3.6f, 19.183588f);
                j2.lineTo(3.6f, 43.37328f);
                j2.cubicTo(3.6f, 43.73662f, 4.0836716f, 44.579533f, 4.402809f, 44.765697f);
                j2.lineTo(25.2f, 56.89739f);
                j2.lineTo(25.2f, 31.654354f);
                j2.lineTo(3.6f, 19.183588f);
                j2.close();
                j2.moveTo(24.411127f, 0.62529963f);
                j2.cubicTo(25.840921f, -0.20874764f, 28.160156f, -0.20811874f, 29.588873f, 0.62529963f);
                j2.lineTo(51.411125f, 13.354947f);
                j2.cubicTo(52.840923f, 14.188994f, 54.0f, 16.21864f, 54.0f, 17.856966f);
                j2.lineTo(54.0f, 43.37328f);
                j2.cubicTo(54.0f, 45.02563f, 52.839844f, 47.04188f, 51.411125f, 47.8753f);
                j2.lineTo(29.588873f, 60.604946f);
                j2.cubicTo(28.159079f, 61.438995f, 25.839844f, 61.438366f, 24.411127f, 60.604946f);
                j2.lineTo(2.5888736f, 47.8753f);
                j2.cubicTo(1.1590781f, 47.041252f, 0.0f, 45.01161f, 0.0f, 43.37328f);
                j2.lineTo(0.0f, 17.856966f);
                j2.cubicTo(0.0f, 16.204617f, 1.1601562f, 14.188366f, 2.5888736f, 13.354947f);
                j2.lineTo(24.411127f, 0.62529963f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
