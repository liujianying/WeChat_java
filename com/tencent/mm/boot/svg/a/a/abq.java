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

public final class abq extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                e = c.a(e, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 54.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(4.0f);
                Path j = c.j(looper);
                j.moveTo(14.0f, 46.0f);
                j.lineTo(36.0f, 61.0f);
                j.lineTo(36.0f, 11.0f);
                j.lineTo(14.0f, 26.0f);
                j.lineTo(0.0f, 26.0f);
                j.lineTo(0.0f, 46.0f);
                j.lineTo(14.0f, 46.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(75.00751f, 72.117966f);
                j2.cubicTo(80.96203f, 61.445175f, 84.35507f, 49.148323f, 84.35507f, 36.058983f);
                j2.cubicTo(84.35507f, 22.969645f, 80.96203f, 10.672792f, 75.00751f, 0.0f);
                j2.lineTo(75.00751f, 0.0f);
                j2.lineTo(71.0f, 2.9665983f);
                j2.cubicTo(76.36485f, 12.796429f, 79.413895f, 24.071636f, 79.413895f, 36.058983f);
                j2.cubicTo(79.413895f, 48.046333f, 76.36485f, 59.321537f, 71.0f, 69.15137f);
                j2.lineTo(75.00751f, 72.117966f);
                j2.close();
                j2.moveTo(62.93931f, 63.29133f);
                j2.cubicTo(67.135056f, 55.157722f, 69.50414f, 45.92836f, 69.50414f, 36.145664f);
                j2.cubicTo(69.50414f, 26.36297f, 67.135056f, 17.133606f, 62.93931f, 9.0f);
                j2.lineTo(62.93931f, 9.0f);
                j2.lineTo(59.0f, 11.916111f);
                j2.cubicTo(62.71647f, 19.272243f, 64.81003f, 27.587996f, 64.81003f, 36.392723f);
                j2.cubicTo(64.81003f, 45.053913f, 62.784172f, 53.241943f, 59.180466f, 60.50881f);
                j2.lineTo(62.93931f, 63.29133f);
                j2.lineTo(62.93931f, 63.29133f);
                j2.close();
                j2.moveTo(51.07929f, 54.336704f);
                j2.cubicTo(53.565243f, 48.789673f, 54.94784f, 42.640472f, 54.94784f, 36.16835f);
                j2.cubicTo(54.94784f, 29.69623f, 53.565243f, 23.547031f, 51.07929f, 18.0f);
                j2.lineTo(51.07929f, 18.0f);
                j2.lineTo(47.0f, 21.019733f);
                j2.cubicTo(48.937286f, 25.685192f, 50.006668f, 30.801888f, 50.006668f, 36.16835f);
                j2.cubicTo(50.006668f, 41.534813f, 48.937286f, 46.651512f, 47.0f, 51.316967f);
                j2.lineTo(51.07929f, 54.336704f);
                j2.lineTo(51.07929f, 54.336704f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
