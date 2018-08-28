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

public final class vu extends c {
    private final int height = 30;
    private final int width = 26;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 26;
            case 1:
                return 30;
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
                canvas.save();
                c.a(i3, looper).setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -174.0f, 0.0f, 1.0f, -448.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3684409);
                Path j = c.j(looper);
                j.moveTo(199.0f, 450.0f);
                j.cubicTo(199.55229f, 450.0f, 200.0f, 450.44772f, 200.0f, 451.0f);
                j.lineTo(200.0f, 477.0f);
                j.cubicTo(200.0f, 477.55228f, 199.55229f, 478.0f, 199.0f, 478.0f);
                j.lineTo(175.0f, 478.0f);
                j.cubicTo(174.44771f, 478.0f, 174.0f, 477.55228f, 174.0f, 477.0f);
                j.lineTo(174.0f, 451.0f);
                j.cubicTo(174.0f, 450.44772f, 174.44771f, 450.0f, 175.0f, 450.0f);
                j.lineTo(177.0f, 450.0f);
                j.cubicTo(177.55229f, 450.0f, 178.0f, 450.44772f, 178.0f, 451.0f);
                j.cubicTo(178.0f, 451.55228f, 177.55229f, 452.0f, 177.0f, 452.0f);
                j.lineTo(176.0f, 452.0f);
                j.lineTo(176.0f, 476.0f);
                j.lineTo(198.0f, 476.0f);
                j.lineTo(198.0f, 452.0f);
                j.lineTo(197.0f, 452.0f);
                j.cubicTo(196.44771f, 452.0f, 196.0f, 451.55228f, 196.0f, 451.0f);
                j.cubicTo(196.0f, 450.44772f, 196.44771f, 450.0f, 197.0f, 450.0f);
                j.lineTo(199.0f, 450.0f);
                j.close();
                j.moveTo(181.0f, 448.0f);
                j.cubicTo(181.55229f, 448.0f, 182.0f, 448.44772f, 182.0f, 449.0f);
                j.lineTo(182.0f, 453.0f);
                j.cubicTo(182.0f, 453.55228f, 181.55229f, 454.0f, 181.0f, 454.0f);
                j.cubicTo(180.44771f, 454.0f, 180.0f, 453.55228f, 180.0f, 453.0f);
                j.lineTo(180.0f, 449.0f);
                j.cubicTo(180.0f, 448.44772f, 180.44771f, 448.0f, 181.0f, 448.0f);
                j.close();
                j.moveTo(193.0f, 448.0f);
                j.cubicTo(193.55229f, 448.0f, 194.0f, 448.44772f, 194.0f, 449.0f);
                j.lineTo(194.0f, 453.0f);
                j.cubicTo(194.0f, 453.55228f, 193.55229f, 454.0f, 193.0f, 454.0f);
                j.cubicTo(192.44771f, 454.0f, 192.0f, 453.55228f, 192.0f, 453.0f);
                j.lineTo(192.0f, 449.0f);
                j.cubicTo(192.0f, 448.44772f, 192.44771f, 448.0f, 193.0f, 448.0f);
                j.close();
                j.moveTo(185.0f, 450.0f);
                j.lineTo(189.0f, 450.0f);
                j.cubicTo(189.55229f, 450.0f, 190.0f, 450.44772f, 190.0f, 451.0f);
                j.cubicTo(190.0f, 451.55228f, 189.55229f, 452.0f, 189.0f, 452.0f);
                j.lineTo(185.0f, 452.0f);
                j.cubicTo(184.44771f, 452.0f, 184.0f, 451.55228f, 184.0f, 451.0f);
                j.cubicTo(184.0f, 450.44772f, 184.44771f, 450.0f, 185.0f, 450.0f);
                j.close();
                j.moveTo(181.0f, 460.0f);
                j.lineTo(193.0f, 460.0f);
                j.cubicTo(193.55229f, 460.0f, 194.0f, 460.44772f, 194.0f, 461.0f);
                j.cubicTo(194.0f, 461.55228f, 193.55229f, 462.0f, 193.0f, 462.0f);
                j.lineTo(181.0f, 462.0f);
                j.cubicTo(180.44771f, 462.0f, 180.0f, 461.55228f, 180.0f, 461.0f);
                j.cubicTo(180.0f, 460.44772f, 180.44771f, 460.0f, 181.0f, 460.0f);
                j.close();
                j.moveTo(181.0f, 468.0f);
                j.lineTo(193.0f, 468.0f);
                j.cubicTo(193.55229f, 468.0f, 194.0f, 468.44772f, 194.0f, 469.0f);
                j.cubicTo(194.0f, 469.55228f, 193.55229f, 470.0f, 193.0f, 470.0f);
                j.lineTo(181.0f, 470.0f);
                j.cubicTo(180.44771f, 470.0f, 180.0f, 469.55228f, 180.0f, 469.0f);
                j.cubicTo(180.0f, 468.44772f, 180.44771f, 468.0f, 181.0f, 468.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
