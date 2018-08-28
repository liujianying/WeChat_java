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

public final class je extends c {
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
                a.setColor(-372399);
                Path j = c.j(looper);
                j.moveTo(23.608564f, 16.294855f);
                j.cubicTo(30.359621f, 11.0934105f, 38.818558f, 8.0f, 48.0f, 8.0f);
                j.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                j.cubicTo(88.0f, 57.181442f, 84.906586f, 65.64038f, 79.70515f, 72.39143f);
                j.lineTo(84.18377f, 76.870056f);
                j.lineTo(78.52691f, 82.52691f);
                j.lineTo(13.473088f, 17.473087f);
                j.lineTo(19.129942f, 11.816234f);
                j.lineTo(23.608564f, 16.294855f);
                j.close();
                j.moveTo(73.98854f, 66.67483f);
                j.cubicTo(77.77166f, 61.41938f, 80.0f, 54.969917f, 80.0f, 48.0f);
                j.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                j.cubicTo(41.030083f, 16.0f, 34.58062f, 18.228338f, 29.325169f, 22.011461f);
                j.lineTo(34.35946f, 27.04575f);
                j.cubicTo(38.28203f, 24.48706f, 42.967354f, 23.0f, 48.0f, 23.0f);
                j.cubicTo(61.807117f, 23.0f, 73.0f, 34.192883f, 73.0f, 48.0f);
                j.cubicTo(73.0f, 53.032646f, 71.51294f, 57.71797f, 68.954254f, 61.64054f);
                j.lineTo(73.98854f, 66.67483f);
                j.close();
                j.moveTo(63.110573f, 55.796864f);
                j.cubicTo(64.31804f, 53.461494f, 65.0f, 50.810387f, 65.0f, 48.0f);
                j.cubicTo(65.0f, 38.61116f, 57.38884f, 31.0f, 48.0f, 31.0f);
                j.cubicTo(45.189613f, 31.0f, 42.538506f, 31.681961f, 40.203136f, 32.889427f);
                j.lineTo(63.110573f, 55.796864f);
                j.close();
                j.moveTo(13.10976f, 28.42347f);
                j.lineTo(19.044928f, 34.358635f);
                j.cubicTo(17.091997f, 38.496666f, 16.0f, 43.120808f, 16.0f, 48.0f);
                j.cubicTo(16.0f, 65.67311f, 30.326887f, 80.0f, 48.0f, 80.0f);
                j.cubicTo(52.879192f, 80.0f, 57.503334f, 78.908005f, 61.641365f, 76.95507f);
                j.lineTo(67.57653f, 82.890236f);
                j.cubicTo(61.789757f, 86.14411f, 55.11161f, 88.0f, 48.0f, 88.0f);
                j.cubicTo(25.90861f, 88.0f, 8.0f, 70.09139f, 8.0f, 48.0f);
                j.cubicTo(8.0f, 40.88839f, 9.855887f, 34.210243f, 13.10976f, 28.42347f);
                j.close();
                j.moveTo(24.40442f, 39.71813f);
                j.lineTo(31.075333f, 46.38904f);
                j.cubicTo(31.025488f, 46.91932f, 31.0f, 47.456684f, 31.0f, 48.0f);
                j.cubicTo(31.0f, 57.38884f, 38.61116f, 65.0f, 48.0f, 65.0f);
                j.cubicTo(48.543316f, 65.0f, 49.08068f, 64.97451f, 49.61096f, 64.92467f);
                j.lineTo(56.28187f, 71.59558f);
                j.cubicTo(53.689934f, 72.50529f, 50.90274f, 73.0f, 48.0f, 73.0f);
                j.cubicTo(34.192883f, 73.0f, 23.0f, 61.807117f, 23.0f, 48.0f);
                j.cubicTo(23.0f, 45.09726f, 23.49471f, 42.310066f, 24.40442f, 39.71813f);
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
