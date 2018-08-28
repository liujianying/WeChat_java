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

public final class adj extends c {
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -120.0f, 0.0f, 1.0f, -426.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 120.0f, 0.0f, 1.0f, 426.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-70474);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(44.0f, 22.271605f);
                j.cubicTo(44.0f, 9.849482f, 34.15052f, 0.0f, 21.728395f, 0.0f);
                j.cubicTo(9.849482f, 0.0f, 0.0f, 9.849482f, 0.0f, 22.271605f);
                j.cubicTo(0.0f, 34.15052f, 9.849482f, 44.0f, 21.728395f, 44.0f);
                j.cubicTo(34.15052f, 44.0f, 44.0f, 34.15052f, 44.0f, 22.271605f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-36352);
                a3.setStrokeWidth(3.0f);
                j = c.j(looper);
                j.moveTo(42.5f, 22.271605f);
                j.cubicTo(42.5f, 10.677909f, 33.32209f, 1.5f, 21.728395f, 1.5f);
                j.cubicTo(10.600406f, 1.5f, 1.5f, 10.756952f, 1.5f, 22.271605f);
                j.cubicTo(1.5f, 33.32209f, 10.677909f, 42.5f, 21.728395f, 42.5f);
                j.cubicTo(33.243046f, 42.5f, 42.5f, 33.399593f, 42.5f, 22.271605f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-36352);
                j = c.j(looper);
                j.moveTo(8.37882f, 23.270937f);
                j.cubicTo(8.197487f, 23.075033f, 8.176818f, 22.736786f, 8.330922f, 22.517902f);
                j.lineTo(9.380023f, 21.027798f);
                j.cubicTo(9.534904f, 20.80781f, 9.826069f, 20.761974f, 10.042893f, 20.935448f);
                j.lineTo(17.207075f, 26.667225f);
                j.cubicTo(17.418287f, 26.836208f, 17.750328f, 26.833344f, 17.961102f, 26.650051f);
                j.lineTo(35.820465f, 11.119163f);
                j.cubicTo(36.02569f, 10.940694f, 36.340633f, 10.949186f, 36.53349f, 11.148006f);
                j.lineTo(37.460594f, 12.103773f);
                j.cubicTo(37.649166f, 12.298171f, 37.65095f, 12.610968f, 37.46806f, 12.798857f);
                j.lineTo(17.922888f, 32.87793f);
                j.cubicTo(17.738441f, 33.067417f, 17.43909f, 33.059162f, 17.260582f, 32.86631f);
                j.lineTo(8.37882f, 23.270937f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
