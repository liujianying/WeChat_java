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

public final class aru extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(16.966213f, 24.12567f);
                j.lineTo(18.380426f, 25.539883f);
                j.lineTo(15.993941f, 27.926369f);
                j.cubicTo(14.794056f, 29.126255f, 14.782134f, 31.04559f, 15.949747f, 32.213203f);
                j.cubicTo(17.117361f, 33.380817f, 19.036695f, 33.368896f, 20.236582f, 32.16901f);
                j.lineTo(25.009554f, 27.396038f);
                j.cubicTo(26.20944f, 26.196152f, 26.221361f, 24.276817f, 25.053747f, 23.109203f);
                j.lineTo(26.46796f, 21.69499f);
                j.cubicTo(28.420582f, 23.647612f, 28.400795f, 26.833223f, 26.423767f, 28.810251f);
                j.lineTo(21.650795f, 33.58322f);
                j.cubicTo(19.673767f, 35.560253f, 16.488155f, 35.58004f, 14.535534f, 33.62742f);
                j.cubicTo(12.582912f, 31.674795f, 12.602699f, 28.489183f, 14.579728f, 26.512156f);
                j.lineTo(16.966213f, 24.12567f);
                j.close();
                j.moveTo(33.58322f, 21.650795f);
                j.lineTo(31.196737f, 24.037281f);
                j.lineTo(29.782524f, 22.623068f);
                j.lineTo(32.16901f, 20.236582f);
                j.cubicTo(33.368896f, 19.036695f, 33.380817f, 17.117361f, 32.213203f, 15.949747f);
                j.cubicTo(31.04559f, 14.782134f, 29.126255f, 14.794056f, 27.926369f, 15.993941f);
                j.lineTo(23.153399f, 20.766912f);
                j.cubicTo(21.953512f, 21.966799f, 21.94159f, 23.886133f, 23.109203f, 25.053747f);
                j.lineTo(21.69499f, 26.46796f);
                j.cubicTo(19.742369f, 24.515339f, 19.762156f, 21.329727f, 21.739183f, 19.3527f);
                j.lineTo(26.512156f, 14.579728f);
                j.cubicTo(28.489183f, 12.602699f, 31.674795f, 12.582912f, 33.62742f, 14.535534f);
                j.cubicTo(35.58004f, 16.488155f, 35.560253f, 19.673767f, 33.58322f, 21.650795f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
