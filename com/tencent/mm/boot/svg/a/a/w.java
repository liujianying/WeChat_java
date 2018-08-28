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

public final class w extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                i2.setColor(-16777216);
                i3 = c.a(i2, looper);
                i3.setColor(-16777216);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(72.0f, 0.0f);
                j.lineTo(72.0f, 72.0f);
                j.lineTo(0.0f, 72.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(i3, looper));
                canvas.restore();
                Paint a = c.a(i2, looper);
                a.setColor(-16777216);
                Path j2 = c.j(looper);
                j2.moveTo(34.0f, 59.313408f);
                j2.cubicTo(23.340136f, 58.30629f, 15.0f, 49.33082f, 15.0f, 38.407406f);
                j2.lineTo(15.0f, 26.185184f);
                j2.lineTo(15.0f, 37.0f);
                j2.lineTo(19.0f, 37.0f);
                j2.lineTo(19.0f, 37.851852f);
                j2.cubicTo(19.0f, 47.240692f, 26.611158f, 54.851852f, 36.0f, 54.851852f);
                j2.cubicTo(45.38884f, 54.851852f, 53.0f, 47.240692f, 53.0f, 37.851852f);
                j2.lineTo(53.0f, 37.0f);
                j2.lineTo(57.0f, 37.0f);
                j2.lineTo(57.0f, 26.185184f);
                j2.lineTo(57.0f, 38.407406f);
                j2.cubicTo(57.0f, 49.33082f, 48.659866f, 58.30629f, 38.0f, 59.313408f);
                j2.lineTo(38.0f, 62.95062f);
                j2.lineTo(34.0f, 62.95062f);
                j2.lineTo(34.0f, 59.313408f);
                j2.close();
                j2.moveTo(23.0f, 62.95062f);
                j2.lineTo(49.0f, 62.95062f);
                j2.lineTo(49.0f, 67.0f);
                j2.lineTo(23.0f, 67.0f);
                j2.lineTo(23.0f, 62.95062f);
                j2.close();
                j2.moveTo(36.0f, 6.259259f);
                j2.lineTo(36.0f, 6.259259f);
                j2.cubicTo(43.179703f, 6.259259f, 49.0f, 12.079557f, 49.0f, 19.25926f);
                j2.lineTo(49.0f, 37.802467f);
                j2.cubicTo(49.0f, 44.98217f, 43.179703f, 50.802467f, 36.0f, 50.802467f);
                j2.lineTo(36.0f, 50.802467f);
                j2.lineTo(36.0f, 50.802467f);
                j2.cubicTo(28.8203f, 50.802467f, 23.0f, 44.98217f, 23.0f, 37.802467f);
                j2.lineTo(23.0f, 19.25926f);
                j2.cubicTo(23.0f, 12.079557f, 28.8203f, 6.259259f, 36.0f, 6.259259f);
                j2.lineTo(36.0f, 6.259259f);
                j2.close();
                canvas.saveLayerAlpha(null, 76, 4);
                i3 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
