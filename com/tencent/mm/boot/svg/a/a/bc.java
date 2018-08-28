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

public final class bc extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-12822120);
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(16.972387f, 0.040298507f);
                j.lineTo(1.027612f, 0.040298507f);
                j.cubicTo(0.48358208f, 0.040298507f, 0.040298507f, 0.48358208f, 0.040298507f, 1.027612f);
                j.lineTo(0.040298507f, 16.972387f);
                j.cubicTo(0.040298507f, 17.516418f, 0.48358208f, 17.959702f, 1.027612f, 17.959702f);
                j.lineTo(9.611194f, 17.959702f);
                j.lineTo(9.611194f, 11.021642f);
                j.lineTo(7.2738805f, 11.021642f);
                j.lineTo(7.2738805f, 8.314925f);
                j.lineTo(9.611194f, 8.314925f);
                j.lineTo(9.611194f, 6.3201494f);
                j.cubicTo(9.611194f, 4.002985f, 11.028358f, 2.747015f, 13.090299f, 2.747015f);
                j.cubicTo(14.077612f, 2.747015f, 14.930597f, 2.8208954f, 15.179105f, 2.8544776f);
                j.lineTo(15.179105f, 5.272388f);
                j.lineTo(13.7485075f, 5.272388f);
                j.cubicTo(12.626865f, 5.272388f, 12.405224f, 5.802985f, 12.405224f, 6.588806f);
                j.lineTo(12.405224f, 8.314925f);
                j.lineTo(15.085074f, 8.314925f);
                j.lineTo(14.735821f, 11.021642f);
                j.lineTo(12.405224f, 11.021642f);
                j.lineTo(12.405224f, 17.966417f);
                j.lineTo(16.972387f, 17.966417f);
                j.cubicTo(17.516418f, 17.966417f, 17.959702f, 17.523134f, 17.959702f, 16.979105f);
                j.lineTo(17.959702f, 1.027612f);
                j.cubicTo(17.959702f, 0.47686568f, 17.523134f, 0.040298507f, 16.972387f, 0.040298507f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
