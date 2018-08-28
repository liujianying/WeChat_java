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

public final class aan extends c {
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
                a.setColor(-16777216);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.5f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(3.6f, 5.1f);
                j2.lineTo(3.6f, 39.9f);
                j2.lineTo(56.4f, 39.9f);
                j2.lineTo(56.4f, 5.1f);
                j2.lineTo(3.6f, 5.1f);
                j2.close();
                j2.moveTo(0.0f, 4.5f);
                j2.cubicTo(-2.0290612E-16f, 2.8431458f, 1.3431457f, 1.5f, 3.0f, 1.5f);
                j2.lineTo(57.0f, 1.5f);
                j2.cubicTo(58.656853f, 1.5f, 60.0f, 2.8431458f, 60.0f, 4.5f);
                j2.lineTo(60.0f, 40.5f);
                j2.cubicTo(60.0f, 42.156853f, 58.656853f, 43.5f, 57.0f, 43.5f);
                j2.lineTo(3.0f, 43.5f);
                j2.cubicTo(1.3431457f, 43.5f, -2.7402583E-15f, 42.156853f, 0.0f, 40.5f);
                j2.lineTo(0.0f, 4.5f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(2.5124738f, 6.5230727f);
                j2.lineTo(25.253035f, 23.99735f);
                j2.cubicTo(28.055511f, 26.150826f, 31.955736f, 26.150826f, 34.758213f, 23.99735f);
                j2.lineTo(57.498775f, 6.5230727f);
                j2.lineTo(55.30527f, 3.6685066f);
                j2.lineTo(32.56471f, 21.142784f);
                j2.cubicTo(31.055685f, 22.30235f, 28.955564f, 22.30235f, 27.446539f, 21.142784f);
                j2.lineTo(4.7059765f, 3.6685066f);
                j2.lineTo(2.5124738f, 6.5230727f);
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
