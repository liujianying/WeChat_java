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

public final class s extends c {
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
                canvas.saveLayerAlpha(null, 230, 4);
                i2 = c.a(i2, looper);
                i2.setColor(1275068416);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(36.0f, 60.0f);
                j.cubicTo(22.745167f, 60.0f, 12.0f, 49.254833f, 12.0f, 36.0f);
                j.cubicTo(12.0f, 22.745167f, 22.745167f, 12.0f, 36.0f, 12.0f);
                j.cubicTo(49.254833f, 12.0f, 60.0f, 22.745167f, 60.0f, 36.0f);
                j.cubicTo(60.0f, 49.254833f, 49.254833f, 60.0f, 36.0f, 60.0f);
                j.close();
                j.moveTo(36.0f, 32.938873f);
                j.lineTo(27.061129f, 24.0f);
                j.lineTo(24.0f, 27.061129f);
                j.lineTo(32.938873f, 36.0f);
                j.lineTo(24.0f, 44.938873f);
                j.lineTo(27.061129f, 48.0f);
                j.lineTo(36.0f, 39.061127f);
                j.lineTo(44.938873f, 48.0f);
                j.lineTo(48.0f, 44.938873f);
                j.lineTo(39.061127f, 36.0f);
                j.lineTo(48.0f, 27.061129f);
                j.lineTo(44.938873f, 24.0f);
                j.lineTo(36.0f, 32.938873f);
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
