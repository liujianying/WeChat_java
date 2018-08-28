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

public final class adm extends c {
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
                e = c.a(e, 1.0f, 0.0f, -56.0f, 0.0f, 1.0f, -265.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 56.0f, 0.0f, 1.0f, 265.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(3.0f, 45.0f);
                j.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                j.lineTo(45.0f, 3.0f);
                j.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                j.lineTo(87.0f, 45.0f);
                j.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                j.lineTo(45.0f, 87.0f);
                j.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                j.lineTo(3.0f, 45.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(49.82215f, 67.367676f);
                j.lineTo(46.05924f, 63.60476f);
                j.cubicTo(50.438366f, 58.779804f, 53.118694f, 52.299812f, 53.118694f, 45.175297f);
                j.cubicTo(53.118694f, 38.068485f, 50.451668f, 31.60299f, 46.091843f, 26.781826f);
                j.lineTo(49.854874f, 23.018793f);
                j.cubicTo(55.13197f, 28.813019f, 58.363636f, 36.605614f, 58.363636f, 45.175297f);
                j.cubicTo(58.363636f, 53.76268f, 55.11861f, 61.56976f, 49.82215f, 67.367676f);
                j.close();
                j.moveTo(41.090847f, 58.63637f);
                j.lineTo(37.32728f, 54.872803f);
                j.cubicTo(39.788017f, 52.418816f, 41.31758f, 48.98096f, 41.31758f, 45.175297f);
                j.cubicTo(41.31758f, 41.38734f, 39.80221f, 37.96377f, 37.36156f, 35.512104f);
                j.lineTo(41.124847f, 31.748817f);
                j.cubicTo(44.482662f, 35.17379f, 46.56252f, 39.92448f, 46.56252f, 45.175297f);
                j.cubicTo(46.56252f, 50.443817f, 44.468616f, 55.20883f, 41.090847f, 58.63637f);
                j.close();
                j.moveTo(32.620003f, 50.165524f);
                j.lineTo(27.664072f, 45.209595f);
                j.lineTo(32.655266f, 40.2184f);
                j.cubicTo(33.950462f, 41.45147f, 34.761406f, 43.215885f, 34.761406f, 45.175297f);
                j.cubicTo(34.761406f, 47.152435f, 33.935726f, 48.931026f, 32.620003f, 50.165524f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
