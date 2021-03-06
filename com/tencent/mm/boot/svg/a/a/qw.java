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

public final class qw extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i3 = c.a(i2, looper);
                i3.setColor(-11890462);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(30.23671f, 67.60445f);
                j2.cubicTo(27.256218f, 63.56331f, 25.517647f, 58.701523f, 25.517647f, 53.47059f);
                j2.cubicTo(25.517647f, 39.436058f, 38.032604f, 28.058823f, 53.47059f, 28.058823f);
                j2.cubicTo(68.90857f, 28.058823f, 81.42353f, 39.436058f, 81.42353f, 53.47059f);
                j2.cubicTo(81.42353f, 67.50512f, 68.90857f, 78.882355f, 53.47059f, 78.882355f);
                j2.cubicTo(48.763218f, 78.882355f, 44.327625f, 77.82453f, 40.43574f, 75.95611f);
                j2.cubicTo(39.550022f, 75.52946f, 38.487812f, 75.472984f, 37.545677f, 75.72808f);
                j2.cubicTo(35.13429f, 76.38291f, 30.31151f, 77.69258f, 30.31151f, 77.69258f);
                j2.cubicTo(29.714825f, 77.854614f, 29.361446f, 77.49743f, 29.521812f, 76.894905f);
                j2.cubicTo(29.521812f, 76.894905f, 30.542793f, 73.05886f, 31.053284f, 71.14084f);
                j2.cubicTo(31.415718f, 69.68475f, 30.940517f, 68.555336f, 30.23671f, 67.60445f);
                j2.close();
                j2.moveTo(53.75012f, 57.42353f);
                j2.cubicTo(55.757057f, 57.42353f, 57.384f, 55.78015f, 57.384f, 53.75294f);
                j2.cubicTo(57.384f, 51.72573f, 55.757057f, 50.08235f, 53.75012f, 50.08235f);
                j2.cubicTo(51.74318f, 50.08235f, 50.116234f, 51.72573f, 50.116234f, 53.75294f);
                j2.cubicTo(50.116234f, 55.78015f, 51.74318f, 57.42353f, 53.75012f, 57.42353f);
                j2.close();
                j2.moveTo(38.09647f, 57.42353f);
                j2.cubicTo(40.10341f, 57.42353f, 41.730354f, 55.78015f, 41.730354f, 53.75294f);
                j2.cubicTo(41.730354f, 51.72573f, 40.10341f, 50.08235f, 38.09647f, 50.08235f);
                j2.cubicTo(36.08953f, 50.08235f, 34.46259f, 51.72573f, 34.46259f, 53.75294f);
                j2.cubicTo(34.46259f, 55.78015f, 36.08953f, 57.42353f, 38.09647f, 57.42353f);
                j2.close();
                j2.moveTo(69.40376f, 57.42353f);
                j2.cubicTo(71.410706f, 57.42353f, 73.03764f, 55.78015f, 73.03764f, 53.75294f);
                j2.cubicTo(73.03764f, 51.72573f, 71.410706f, 50.08235f, 69.40376f, 50.08235f);
                j2.cubicTo(67.39683f, 50.08235f, 65.76988f, 51.72573f, 65.76988f, 53.75294f);
                j2.cubicTo(65.76988f, 55.78015f, 67.39683f, 57.42353f, 69.40376f, 57.42353f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
