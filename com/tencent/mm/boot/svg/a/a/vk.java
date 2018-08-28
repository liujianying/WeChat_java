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
import com.tencent.smtt.sdk.WebView;

public final class vk extends c {
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                canvas.save();
                c.a(i3, looper).setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -175.0f, 0.0f, 1.0f, -368.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-11048043);
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 339.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(179.0f, 40.0f);
                j.lineTo(179.0f, 30.0f);
                j.cubicTo(179.0f, 29.447716f, 179.44771f, 29.0f, 180.0f, 29.0f);
                j.cubicTo(180.55229f, 29.0f, 181.0f, 29.447716f, 181.0f, 30.0f);
                j.lineTo(181.0f, 40.0f);
                j.lineTo(191.0f, 40.0f);
                j.cubicTo(191.55229f, 40.0f, 192.0f, 40.447716f, 192.0f, 41.0f);
                j.cubicTo(192.0f, 41.552284f, 191.55229f, 42.0f, 191.0f, 42.0f);
                j.lineTo(181.0f, 42.0f);
                j.lineTo(181.0f, 52.0f);
                j.cubicTo(181.0f, 52.552284f, 180.55229f, 53.0f, 180.0f, 53.0f);
                j.cubicTo(179.44771f, 53.0f, 179.0f, 52.552284f, 179.0f, 52.0f);
                j.lineTo(179.0f, 42.0f);
                j.lineTo(169.0f, 42.0f);
                j.cubicTo(168.44771f, 42.0f, 168.0f, 41.552284f, 168.0f, 41.0f);
                j.cubicTo(168.0f, 40.447716f, 168.44771f, 40.0f, 169.0f, 40.0f);
                j.lineTo(179.0f, 40.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
