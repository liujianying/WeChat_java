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

public final class hy extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-8683387);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(68.0f, 68.0f);
                j.lineTo(68.0f, 73.0f);
                j.cubicTo(62.75382f, 77.365776f, 55.755802f, 80.0f, 48.0f, 80.0f);
                j.cubicTo(43.030067f, 80.0f, 38.205288f, 78.816f, 34.0f, 77.0f);
                j.lineTo(48.0f, 52.0f);
                j.lineTo(44.0f, 48.0f);
                j.lineTo(36.0f, 48.0f);
                j.lineTo(28.0f, 40.0f);
                j.lineTo(44.0f, 24.0f);
                j.lineTo(38.0f, 18.0f);
                j.cubicTo(40.952587f, 16.616444f, 44.470387f, 16.0f, 48.0f, 16.0f);
                j.cubicTo(52.40803f, 16.0f, 56.485584f, 16.82889f, 60.0f, 18.0f);
                j.lineTo(60.0f, 24.0f);
                j.lineTo(64.0f, 28.0f);
                j.lineTo(73.0f, 28.0f);
                j.cubicTo(75.21601f, 30.406666f, 76.81651f, 33.097332f, 78.0f, 36.0f);
                j.lineTo(64.0f, 36.0f);
                j.lineTo(56.0f, 44.0f);
                j.lineTo(56.0f, 56.0f);
                j.lineTo(68.0f, 68.0f);
                j.close();
                j.moveTo(24.0f, 69.0f);
                j.cubicTo(19.024445f, 63.343204f, 16.0f, 55.91894f, 16.0f, 48.0f);
                j.cubicTo(16.0f, 46.501648f, 16.08311f, 45.241016f, 16.0f, 44.0f);
                j.lineTo(24.0f, 52.0f);
                j.lineTo(24.0f, 69.0f);
                j.close();
                j.moveTo(48.0f, 8.0f);
                j.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                j.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                j.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                j.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                j.lineTo(48.0f, 8.0f);
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
