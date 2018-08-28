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

public final class aox extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(10.320658f, 10.199991f);
                j2.lineTo(12.757717f, 51.142605f);
                j2.cubicTo(12.833185f, 52.410458f, 13.88338f, 53.4f, 15.153477f, 53.4f);
                j2.lineTo(36.846523f, 53.4f);
                j2.cubicTo(38.11662f, 53.4f, 39.166817f, 52.410458f, 39.242283f, 51.142605f);
                j2.lineTo(41.679344f, 10.199991f);
                j2.lineTo(10.320658f, 10.199991f);
                j2.close();
                j2.moveTo(45.285713f, 10.199991f);
                j2.lineTo(42.835922f, 51.35651f);
                j2.cubicTo(42.647255f, 54.526142f, 40.021767f, 57.0f, 36.846523f, 57.0f);
                j2.lineTo(15.153477f, 57.0f);
                j2.cubicTo(11.978235f, 57.0f, 9.352747f, 54.526142f, 9.164078f, 51.35651f);
                j2.lineTo(6.714286f, 10.199991f);
                j2.lineTo(0.5f, 10.199991f);
                j2.lineTo(0.5f, 8.099991f);
                j2.cubicTo(0.5f, 7.2715635f, 1.1715729f, 6.599991f, 2.0f, 6.599991f);
                j2.lineTo(50.0f, 6.599991f);
                j2.cubicTo(50.828426f, 6.599991f, 51.5f, 7.2715635f, 51.5f, 8.099991f);
                j2.lineTo(51.5f, 10.199991f);
                j2.lineTo(45.285713f, 10.199991f);
                j2.close();
                j2.moveTo(32.0f, 8.1856706E-5f);
                j2.cubicTo(32.828426f, 8.1856706E-5f, 33.5f, 0.67165476f, 33.5f, 1.5000819f);
                j2.lineTo(33.5f, 3.6000726f);
                j2.lineTo(18.5f, 3.6000726f);
                j2.lineTo(18.5f, 1.5000819f);
                j2.cubicTo(18.5f, 0.67165476f, 19.171574f, 8.1856706E-5f, 20.0f, 8.1856706E-5f);
                j2.lineTo(32.0f, 8.1856706E-5f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j3 = c.j(looper);
                j3.moveTo(18.5f, 18.0f);
                j3.lineTo(22.100037f, 18.0f);
                j3.lineTo(23.600037f, 45.0f);
                j3.lineTo(20.0f, 45.0f);
                j3.lineTo(18.5f, 18.0f);
                j3.close();
                j3.moveTo(29.899963f, 18.0f);
                j3.lineTo(33.5f, 18.0f);
                j3.lineTo(32.0f, 45.0f);
                j3.lineTo(28.399963f, 45.0f);
                j3.lineTo(29.899963f, 18.0f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
