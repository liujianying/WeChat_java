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
import com.tencent.smtt.sdk.WebView;

public final class tg extends c {
    private final int height = 6;
    private final int width = 14;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 6;
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2500135);
                Path j = c.j(looper);
                j.moveTo(2.0f, 1.0f);
                j.lineTo(12.0f, 1.0f);
                j.cubicTo(12.552284f, 1.0f, 13.0f, 1.4477153f, 13.0f, 2.0f);
                j.lineTo(13.0f, 4.0f);
                j.cubicTo(13.0f, 4.5522847f, 12.552284f, 5.0f, 12.0f, 5.0f);
                j.lineTo(2.0f, 5.0f);
                j.cubicTo(1.4477153f, 5.0f, 1.0f, 4.5522847f, 1.0f, 4.0f);
                j.lineTo(1.0f, 2.0f);
                j.cubicTo(1.0f, 1.4477153f, 1.4477153f, 1.0f, 2.0f, 1.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
