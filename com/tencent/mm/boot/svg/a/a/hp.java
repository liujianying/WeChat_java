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

public final class hp extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                i2.setColor(-16777216);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -53.0f, 0.0f, 1.0f, -446.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 53.0f, 0.0f, 1.0f, 446.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(1275068416);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(67.5f, 0.0f);
                j.cubicTo(104.77922f, 0.0f, 135.0f, 30.22078f, 135.0f, 67.5f);
                j.cubicTo(135.0f, 104.77922f, 104.77922f, 135.0f, 67.5f, 135.0f);
                j.cubicTo(30.22078f, 135.0f, 0.0f, 104.77922f, 0.0f, 67.5f);
                j.cubicTo(0.0f, 30.22078f, 30.22078f, 0.0f, 67.5f, 0.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.9f);
                j = c.j(looper);
                j.moveTo(67.5f, 3.449997f);
                j.cubicTo(102.87384f, 3.449997f, 131.55f, 32.12616f, 131.55f, 67.5f);
                j.cubicTo(131.55f, 102.87384f, 102.87384f, 131.55f, 67.5f, 131.55f);
                j.cubicTo(32.12616f, 131.55f, 3.449997f, 102.87384f, 3.449997f, 67.5f);
                j.cubicTo(3.449997f, 32.12616f, 32.12616f, 3.449997f, 67.5f, 3.449997f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-1);
                j = c.j(looper);
                j.moveTo(89.24534f, 69.888115f);
                j.lineTo(58.42176f, 90.100464f);
                j.cubicTo(57.10284f, 90.96533f, 55.332527f, 90.59726f, 54.467655f, 89.278336f);
                j.cubicTo(54.16254f, 88.81304f, 54.0f, 88.26875f, 54.0f, 87.71235f);
                j.lineTo(54.0f, 47.287655f);
                j.cubicTo(54.0f, 45.710457f, 55.278572f, 44.431885f, 56.85577f, 44.431885f);
                j.cubicTo(57.412178f, 44.431885f, 57.956467f, 44.594425f, 58.42176f, 44.89954f);
                j.lineTo(89.24534f, 65.111885f);
                j.cubicTo(90.564255f, 65.97676f, 90.932335f, 67.74707f, 90.06746f, 69.06599f);
                j.cubicTo(89.85269f, 69.39351f, 89.57285f, 69.67335f, 89.24534f, 69.888115f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
