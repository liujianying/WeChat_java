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

public final class jg extends c {
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
                i2.setColor(-16777216);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                Path j = c.j(looper);
                j.moveTo(48.0f, 80.0f);
                j.cubicTo(65.67311f, 80.0f, 80.0f, 65.67311f, 80.0f, 48.0f);
                j.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                j.cubicTo(30.326887f, 16.0f, 16.0f, 30.326887f, 16.0f, 48.0f);
                j.cubicTo(16.0f, 65.67311f, 30.326887f, 80.0f, 48.0f, 80.0f);
                j.close();
                j.moveTo(48.0f, 88.0f);
                j.cubicTo(25.90861f, 88.0f, 8.0f, 70.09139f, 8.0f, 48.0f);
                j.cubicTo(8.0f, 25.90861f, 25.90861f, 8.0f, 48.0f, 8.0f);
                j.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                j.cubicTo(88.0f, 70.09139f, 70.09139f, 88.0f, 48.0f, 88.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-15028967);
                j = c.j(looper);
                j.moveTo(48.0f, 65.0f);
                j.cubicTo(57.38884f, 65.0f, 65.0f, 57.38884f, 65.0f, 48.0f);
                j.cubicTo(65.0f, 38.61116f, 57.38884f, 31.0f, 48.0f, 31.0f);
                j.cubicTo(38.61116f, 31.0f, 31.0f, 38.61116f, 31.0f, 48.0f);
                j.cubicTo(31.0f, 57.38884f, 38.61116f, 65.0f, 48.0f, 65.0f);
                j.close();
                j.moveTo(48.0f, 73.0f);
                j.cubicTo(34.192883f, 73.0f, 23.0f, 61.807117f, 23.0f, 48.0f);
                j.cubicTo(23.0f, 34.192883f, 34.192883f, 23.0f, 48.0f, 23.0f);
                j.cubicTo(61.807117f, 23.0f, 73.0f, 34.192883f, 73.0f, 48.0f);
                j.cubicTo(73.0f, 61.807117f, 61.807117f, 73.0f, 48.0f, 73.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
