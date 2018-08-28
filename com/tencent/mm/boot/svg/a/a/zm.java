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

public final class zm extends c {
    private final int height = 150;
    private final int width = 150;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 150;
            case 1:
                return 150;
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
                i3 = c.a(i2, looper);
                i3.setColor(-921103);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(150.0f, 0.0f);
                j.lineTo(150.0f, 150.0f);
                j.lineTo(0.0f, 150.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(-3552823);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(88.629036f, 47.177418f);
                j2.cubicTo(85.16202f, 47.177418f, 81.93403f, 48.098953f, 79.19355f, 49.66629f);
                j2.cubicTo(74.166534f, 52.543064f, 70.80645f, 57.627743f, 70.80645f, 63.427418f);
                j2.lineTo(70.80645f, 87.54032f);
                j2.cubicTo(70.80645f, 91.882744f, 66.58145f, 95.40323f, 61.370968f, 95.40323f);
                j2.cubicTo(56.159435f, 95.40323f, 51.935482f, 91.882744f, 51.935482f, 87.54032f);
                j2.cubicTo(51.935482f, 84.44968f, 54.080482f, 81.78363f, 57.193146f, 80.49831f);
                j2.cubicTo(57.4175f, 80.40605f, 57.645f, 80.317986f, 57.87879f, 80.2404f);
                j2.cubicTo(59.838226f, 79.45411f, 61.51879f, 77.97798f, 62.142582f, 76.26387f);
                j2.cubicTo(63.064114f, 73.73306f, 61.348953f, 71.68242f, 58.312824f, 71.68242f);
                j2.cubicTo(57.555885f, 71.68242f, 56.788467f, 71.810326f, 56.048306f, 72.04097f);
                j2.cubicTo(56.045162f, 72.042015f, 56.042015f, 72.04307f, 56.037823f, 72.04411f);
                j2.cubicTo(51.648228f, 73.304276f, 47.98411f, 76.067825f, 45.784595f, 79.67742f);
                j2.cubicTo(44.364033f, 82.01008f, 43.548386f, 84.68871f, 43.548386f, 87.54032f);
                j2.cubicTo(43.548386f, 96.500885f, 51.54339f, 103.79032f, 61.370968f, 103.79032f);
                j2.cubicTo(64.83798f, 103.79032f, 68.06597f, 102.86879f, 70.80645f, 101.30145f);
                j2.cubicTo(75.833466f, 98.424675f, 79.19355f, 93.34f, 79.19355f, 87.54032f);
                j2.lineTo(79.19355f, 63.427418f);
                j2.cubicTo(79.19355f, 59.085f, 83.4175f, 55.564518f, 88.629036f, 55.564518f);
                j2.cubicTo(93.839516f, 55.564518f, 98.064514f, 59.085f, 98.064514f, 63.427418f);
                j2.cubicTo(98.064514f, 66.65016f, 95.738144f, 69.42f, 92.40742f, 70.63403f);
                j2.cubicTo(90.25928f, 71.35427f, 88.49903f, 72.909035f, 87.828064f, 74.751045f);
                j2.cubicTo(86.91177f, 77.26927f, 88.618546f, 79.31153f, 91.641045f, 79.31153f);
                j2.cubicTo(92.325645f, 79.31153f, 93.01758f, 79.194115f, 93.691696f, 79.0033f);
                j2.cubicTo(93.80177f, 78.9729f, 93.910805f, 78.939354f, 94.01984f, 78.90685f);
                j2.cubicTo(98.383224f, 77.63936f, 102.02532f, 74.88419f, 104.214355f, 71.29032f);
                j2.cubicTo(105.63597f, 68.95871f, 106.451614f, 66.27903f, 106.451614f, 63.427418f);
                j2.cubicTo(106.451614f, 54.466854f, 98.45661f, 47.177418f, 88.629036f, 47.177418f);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
