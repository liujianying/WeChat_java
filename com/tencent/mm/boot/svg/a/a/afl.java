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

public final class afl extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                i2.setColor(-15028967);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(31.45011f, 60.4841f);
                j.lineTo(32.711105f, 58.771122f);
                j.lineTo(32.711105f, 58.771122f);
                j.cubicTo(33.36593f, 57.881584f, 34.61788f, 57.69131f, 35.50742f, 58.346134f);
                j.cubicTo(35.51739f, 58.353477f, 35.527294f, 58.36091f, 35.53713f, 58.36843f);
                j.lineTo(49.747337f, 69.241776f);
                j.lineTo(49.747337f, 69.241776f);
                j.cubicTo(50.4887f, 69.80905f, 51.523895f, 69.78802f, 52.241604f, 69.19109f);
                j.lineTo(89.730385f, 38.011433f);
                j.lineTo(89.730385f, 38.011433f);
                j.cubicTo(90.52095f, 37.35392f, 91.68126f, 37.403004f, 92.41347f, 38.124935f);
                j.lineTo(93.147606f, 38.848774f);
                j.lineTo(93.147606f, 38.848774f);
                j.cubicTo(93.93415f, 39.624283f, 93.9431f, 40.89058f, 93.16759f, 41.677128f);
                j.cubicTo(93.16016f, 41.684666f, 93.152664f, 41.692146f, 93.14511f, 41.699566f);
                j.lineTo(52.450825f, 81.68274f);
                j.lineTo(52.450825f, 81.68274f);
                j.cubicTo(51.66292f, 82.45688f, 50.39664f, 82.44572f, 49.62251f, 81.657814f);
                j.cubicTo(49.618988f, 81.65423f, 49.615482f, 81.650635f, 49.611988f, 81.647026f);
                j.lineTo(31.623617f, 63.060673f);
                j.lineTo(31.623617f, 63.060673f);
                j.cubicTo(30.944754f, 62.35924f, 30.871418f, 61.270214f, 31.45011f, 60.4841f);
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
