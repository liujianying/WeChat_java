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

public final class art extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(30.698973f, 20.516636f);
                j.cubicTo(42.005985f, 11.434257f, 56.368374f, 6.0f, 72.0f, 6.0f);
                j.cubicTo(108.45079f, 6.0f, 138.0f, 35.549206f, 138.0f, 72.0f);
                j.cubicTo(138.0f, 87.63162f, 132.56575f, 101.99401f, 123.48336f, 113.301025f);
                j.lineTo(128.00285f, 117.82052f);
                j.lineTo(122.91169f, 122.91169f);
                j.lineTo(21.08831f, 21.088312f);
                j.lineTo(26.17948f, 15.997144f);
                j.lineTo(30.698973f, 20.516636f);
                j.close();
                j.moveTo(118.35804f, 108.1757f);
                j.cubicTo(126.15405f, 98.19952f, 130.8f, 85.64232f, 130.8f, 72.0f);
                j.cubicTo(130.8f, 39.525658f, 104.47434f, 13.200001f, 72.0f, 13.200001f);
                j.cubicTo(58.357685f, 13.200001f, 45.80049f, 17.845951f, 35.824303f, 25.641966f);
                j.lineTo(47.82981f, 37.647472f);
                j.cubicTo(54.664818f, 32.82958f, 63.00197f, 30.0f, 72.0f, 30.0f);
                j.cubicTo(95.19596f, 30.0f, 114.0f, 48.80404f, 114.0f, 72.0f);
                j.cubicTo(114.0f, 80.99803f, 111.170425f, 89.33518f, 106.35253f, 96.17018f);
                j.lineTo(118.35804f, 108.1757f);
                j.close();
                j.moveTo(101.16897f, 90.98663f);
                j.cubicTo(104.73026f, 85.52662f, 106.8f, 79.00501f, 106.8f, 72.0f);
                j.cubicTo(106.8f, 52.78049f, 91.21951f, 37.2f, 72.0f, 37.2f);
                j.cubicTo(64.99499f, 37.2f, 58.47338f, 39.269733f, 53.013367f, 42.83103f);
                j.lineTo(101.16897f, 90.98663f);
                j.close();
                j.moveTo(20.516634f, 30.698975f);
                j.lineTo(25.641964f, 35.824303f);
                j.cubicTo(17.845951f, 45.80049f, 13.200001f, 58.357685f, 13.200001f, 72.0f);
                j.cubicTo(13.200001f, 104.47434f, 39.525658f, 130.8f, 72.0f, 130.8f);
                j.cubicTo(85.64232f, 130.8f, 98.19951f, 126.15405f, 108.1757f, 118.35804f);
                j.lineTo(113.301025f, 123.48337f);
                j.cubicTo(101.99401f, 132.56575f, 87.63162f, 138.0f, 72.0f, 138.0f);
                j.cubicTo(35.549206f, 138.0f, 6.0f, 108.45079f, 6.0f, 72.0f);
                j.cubicTo(6.0f, 56.368374f, 11.434257f, 42.00599f, 20.516634f, 30.698975f);
                j.close();
                j.moveTo(37.647472f, 47.82981f);
                j.lineTo(42.831028f, 53.01337f);
                j.cubicTo(39.269733f, 58.473385f, 37.2f, 64.99499f, 37.2f, 72.0f);
                j.cubicTo(37.2f, 91.21951f, 52.78049f, 106.8f, 72.0f, 106.8f);
                j.cubicTo(79.00501f, 106.8f, 85.52662f, 104.73026f, 90.98663f, 101.16897f);
                j.lineTo(96.17019f, 106.35253f);
                j.cubicTo(89.33519f, 111.17042f, 80.99804f, 114.0f, 72.0f, 114.0f);
                j.cubicTo(48.80404f, 114.0f, 30.0f, 95.19596f, 30.0f, 72.0f);
                j.cubicTo(30.0f, 63.001965f, 32.82958f, 54.664814f, 37.647472f, 47.82981f);
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
