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

public final class bh extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(11.269531f, 8.1875f);
                j.cubicTo(9.5703125f, 8.1875f, 8.46875f, 9.628906f, 8.46875f, 11.84375f);
                j.cubicTo(8.46875f, 14.046875f, 9.558594f, 15.4765625f, 11.2578125f, 15.4765625f);
                j.cubicTo(12.9921875f, 15.4765625f, 14.105469f, 14.0234375f, 14.105469f, 11.785156f);
                j.cubicTo(14.105469f, 9.582031f, 13.015625f, 8.1875f, 11.269531f, 8.1875f);
                j.close();
                j.moveTo(11.644531f, 2.0f);
                j.cubicTo(16.779823f, 2.0f, 21.019531f, 5.5273438f, 21.019531f, 10.71875f);
                j.cubicTo(21.019531f, 14.4453125f, 19.472656f, 16.835938f, 16.894531f, 16.835938f);
                j.cubicTo(15.5f, 16.835938f, 14.3984375f, 15.9921875f, 14.222656f, 14.6796875f);
                j.lineTo(14.140625f, 14.6796875f);
                j.cubicTo(13.613281f, 16.015625f, 12.5234375f, 16.753906f, 11.0703125f, 16.753906f);
                j.cubicTo(8.65625f, 16.753906f, 7.015625f, 14.761719f, 7.015625f, 11.808594f);
                j.cubicTo(7.015625f, 8.925781f, 8.6796875f, 6.9335938f, 11.0703125f, 6.9335938f);
                j.cubicTo(12.4296875f, 6.9335938f, 13.613281f, 7.671875f, 14.046875f, 8.8203125f);
                j.lineTo(14.128906f, 8.8203125f);
                j.lineTo(14.128906f, 7.1679688f);
                j.lineTo(15.488281f, 7.1679688f);
                j.lineTo(15.488281f, 13.871094f);
                j.cubicTo(15.488281f, 14.9375f, 16.050781f, 15.640625f, 17.117188f, 15.640625f);
                j.cubicTo(18.675781f, 15.640625f, 19.742188f, 13.847656f, 19.742188f, 10.6953125f);
                j.cubicTo(19.742188f, 6.21875f, 16.238195f, 3.1757047f, 11.644531f, 3.1757047f);
                j.cubicTo(7.0508666f, 3.1757047f, 3.2890625f, 6.5256376f, 3.2890625f, 11.7734375f);
                j.cubicTo(3.2890625f, 16.648184f, 7.303185f, 20.363281f, 11.7734375f, 20.363281f);
                j.cubicTo(13.355469f, 20.363281f, 14.8671875f, 20.164062f, 15.6640625f, 19.847656f);
                j.lineTo(15.6640625f, 21.007812f);
                j.cubicTo(14.714844f, 21.335938f, 13.332031f, 21.523438f, 11.761719f, 21.523438f);
                j.cubicTo(6.1979494f, 21.523438f, 2.0f, 17.325605f, 2.0f, 11.7265625f);
                j.cubicTo(2.0f, 6.127519f, 6.5092382f, 2.0f, 11.644531f, 2.0f);
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
