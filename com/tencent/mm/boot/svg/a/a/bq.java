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

public final class bq extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                float[] a = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-16777216);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(15.75f, 18.0f);
                j.lineTo(2.25f, 18.0f);
                j.cubicTo(1.008f, 18.0f, 0.0f, 16.992f, 0.0f, 15.75f);
                j.lineTo(0.0f, 2.25f);
                j.cubicTo(0.0f, 1.008f, 1.008f, 0.0f, 2.25f, 0.0f);
                j.lineTo(15.75f, 0.0f);
                j.cubicTo(16.992f, 0.0f, 18.0f, 1.008f, 18.0f, 2.25f);
                j.lineTo(18.0f, 15.75f);
                j.cubicTo(18.0f, 16.992f, 16.992f, 18.0f, 15.75f, 18.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a, 1.0f, 0.0f, 3.375f, 0.0f, 1.0f, 4.41f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(3.537f, 9.162f);
                j.cubicTo(7.7805f, 9.162f, 10.1025f, 5.643f, 10.1025f, 2.5965f);
                j.cubicTo(10.1025f, 2.4975f, 10.1025f, 2.3985f, 10.098f, 2.2995f);
                j.cubicTo(10.548f, 1.9755f, 10.9395f, 1.566f, 11.25f, 1.1025f);
                j.cubicTo(10.836f, 1.287f, 10.3905f, 1.4085f, 9.9225f, 1.467f);
                j.cubicTo(10.3995f, 1.1835f, 10.764f, 0.729f, 10.9395f, 0.189f);
                j.cubicTo(10.494f, 0.4545f, 9.999f, 0.6435f, 9.4725f, 0.747f);
                j.cubicTo(9.0495f, 0.297f, 8.451f, 0.018f, 7.7895f, 0.018f);
                j.cubicTo(6.516f, 0.018f, 5.481f, 1.053f, 5.481f, 2.3265f);
                j.cubicTo(5.481f, 2.5065f, 5.5035f, 2.682f, 5.5395f, 2.853f);
                j.cubicTo(3.6225f, 2.7585f, 1.9215f, 1.836f, 0.783f, 0.441f);
                j.cubicTo(0.585f, 0.783f, 0.4725f, 1.179f, 0.4725f, 1.602f);
                j.cubicTo(0.4725f, 2.403f, 0.882f, 3.1095f, 1.4985f, 3.5235f);
                j.cubicTo(1.1205f, 3.51f, 0.765f, 3.4065f, 0.4545f, 3.2355f);
                j.cubicTo(0.4545f, 3.2445f, 0.4545f, 3.2535f, 0.4545f, 3.267f);
                j.cubicTo(0.4545f, 4.383f, 1.251f, 5.319f, 2.304f, 5.5305f);
                j.cubicTo(2.1105f, 5.5845f, 1.908f, 5.6115f, 1.6965f, 5.6115f);
                j.cubicTo(1.548f, 5.6115f, 1.404f, 5.598f, 1.2645f, 5.571f);
                j.cubicTo(1.557f, 6.489f, 2.412f, 7.155f, 3.42f, 7.173f);
                j.cubicTo(2.628f, 7.794f, 1.6335f, 8.163f, 0.5535f, 8.163f);
                j.cubicTo(0.369f, 8.163f, 0.1845f, 8.154f, 0.0045f, 8.1315f);
                j.cubicTo(1.0215f, 8.7795f, 2.2365f, 9.162f, 3.537f, 9.162f);
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a4);
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
