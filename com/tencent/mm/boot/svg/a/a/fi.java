package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class fi extends c {
    private final int height = au.CTRL_INDEX;
    private final int width = au.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return au.CTRL_INDEX;
            case 1:
                return au.CTRL_INDEX;
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
                float[] a2 = c.a(e, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 47.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-8421505);
                a.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(14.789806f, 18.17482f);
                j.cubicTo(16.673128f, 8.137144f, 26.477371f, 0.0f, 36.695896f, 0.0f);
                j.lineTo(39.30462f, 0.0f);
                j.cubicTo(49.5197f, 0.0f, 59.32843f, 8.142699f, 61.21071f, 18.17482f);
                j.lineTo(61.332733f, 18.82518f);
                j.cubicTo(63.216057f, 28.862856f, 56.45908f, 37.0f, 46.242638f, 37.0f);
                j.lineTo(29.75788f, 37.0f);
                j.cubicTo(19.540527f, 37.0f, 12.785503f, 28.857302f, 14.667783f, 18.82518f);
                j.lineTo(14.789806f, 18.17482f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-8421505);
                j = c.j(looper);
                j.moveTo(0.0f, 58.108116f);
                j.lineTo(0.0f, 75.19188f);
                j.cubicTo(0.0f, 95.13586f, 17.01318f, 98.0f, 38.0f, 98.0f);
                j.cubicTo(58.991436f, 98.0f, 76.0f, 95.13384f, 76.0f, 75.19188f);
                j.lineTo(76.0f, 58.108116f);
                j.cubicTo(76.0f, 57.60916f, 75.98935f, 57.11257f, 75.96826f, 56.618538f);
                j.cubicTo(75.98917f, 56.4833f, 76.0f, 56.34498f, 76.0f, 56.20427f);
                j.lineTo(76.0f, 24.845732f);
                j.cubicTo(76.0f, 23.275345f, 74.65565f, 22.0f, 72.9973f, 22.0f);
                j.lineTo(3.0026984f, 22.0f);
                j.cubicTo(1.3513777f, 22.0f, 0.0f, 23.274078f, 0.0f, 24.845732f);
                j.lineTo(0.0f, 56.20427f);
                j.cubicTo(0.0f, 56.34515f, 0.010819831f, 56.48366f, 0.03171553f, 56.619087f);
                j.cubicTo(0.0106397765f, 57.112938f, 0.0f, 57.60935f, 0.0f, 58.108116f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 36.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-1);
                j = c.j(looper);
                j.moveTo(22.0f, 0.0f);
                j.cubicTo(34.150265f, 0.0f, 44.0f, 9.849735f, 44.0f, 22.0f);
                j.cubicTo(44.0f, 34.150265f, 34.150265f, 44.0f, 22.0f, 44.0f);
                j.cubicTo(9.849735f, 44.0f, 0.0f, 34.150265f, 0.0f, 22.0f);
                j.cubicTo(0.0f, 9.849735f, 9.849735f, 0.0f, 22.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-8421505);
                j = c.j(looper);
                j.moveTo(16.38889f, 15.111111f);
                j.cubicTo(16.38889f, 13.178115f, 15.045743f, 11.611111f, 13.388889f, 11.611111f);
                j.cubicTo(11.732035f, 11.611111f, 10.388889f, 13.178115f, 10.388889f, 15.111111f);
                j.cubicTo(10.388889f, 17.044107f, 11.732035f, 18.61111f, 13.388889f, 18.61111f);
                j.cubicTo(15.045743f, 18.61111f, 16.38889f, 17.044107f, 16.38889f, 15.111111f);
                j.close();
                j.moveTo(33.38889f, 15.111111f);
                j.cubicTo(33.38889f, 13.178115f, 32.045742f, 11.611111f, 30.38889f, 11.611111f);
                j.cubicTo(28.732035f, 11.611111f, 27.38889f, 13.178115f, 27.38889f, 15.111111f);
                j.cubicTo(27.38889f, 17.044107f, 28.732035f, 18.61111f, 30.38889f, 18.61111f);
                j.cubicTo(32.045742f, 18.61111f, 33.38889f, 17.044107f, 33.38889f, 15.111111f);
                j.close();
                j.moveTo(37.0f, 23.0f);
                j.cubicTo(36.36263f, 30.839403f, 29.890337f, 37.0f, 22.0f, 37.0f);
                j.cubicTo(14.109663f, 37.0f, 7.63737f, 30.839403f, 7.0f, 23.0f);
                j.lineTo(37.0f, 23.0f);
                j.lineTo(37.0f, 23.0f);
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
