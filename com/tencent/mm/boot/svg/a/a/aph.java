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

public final class aph extends c {
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(24.0f, 0.0f);
                j.lineTo(24.0f, 24.0f);
                j.lineTo(0.0f, 24.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2697514);
                Path j2 = c.j(looper);
                j2.moveTo(7.192773f, 3.9939027f);
                j2.lineTo(7.1886353f, 3.9915855f);
                j2.lineTo(10.872541f, 0.4449119f);
                j2.cubicTo(11.48871f, -0.14830397f, 12.485069f, -0.14830397f, 13.101239f, 0.4449119f);
                j2.lineTo(16.785145f, 3.9915855f);
                j2.lineTo(12.773489f, 6.238233f);
                j2.cubicTo(12.30153f, 6.5159087f, 11.69847f, 6.5159087f, 11.200291f, 6.238233f);
                j2.lineTo(7.201767f, 3.9989398f);
                j2.lineTo(7.214855f, 8.459637f);
                j2.cubicTo(7.214855f, 9.002367f, 6.913326f, 9.507231f, 6.4151464f, 9.784906f);
                j2.lineTo(2.3903806f, 12.00631f);
                j2.lineTo(1.0531621f, 7.1469893f);
                j2.cubicTo(0.83029234f, 6.3392057f, 1.3284718f, 5.5061793f, 2.167511f, 5.2916117f);
                j2.lineTo(7.192773f, 3.9939027f);
                j2.close();
                j2.moveTo(7.201767f, 20.00106f);
                j2.lineTo(11.200291f, 17.761766f);
                j2.cubicTo(11.69847f, 17.48409f, 12.30153f, 17.48409f, 12.786599f, 17.761766f);
                j2.lineTo(16.798254f, 20.008415f);
                j2.lineTo(13.101239f, 23.555088f);
                j2.cubicTo(12.485069f, 24.148304f, 11.48871f, 24.148304f, 10.872541f, 23.555088f);
                j2.lineTo(7.1886353f, 20.008415f);
                j2.lineTo(7.192773f, 20.006098f);
                j2.lineTo(2.167511f, 18.708387f);
                j2.cubicTo(1.3284718f, 18.49382f, 0.83029234f, 17.660793f, 1.0531621f, 16.85301f);
                j2.lineTo(2.4034905f, 12.00631f);
                j2.lineTo(6.428256f, 14.227715f);
                j2.cubicTo(6.913326f, 14.492769f, 7.214855f, 14.997633f, 7.214855f, 15.540363f);
                j2.lineTo(7.201767f, 20.00106f);
                j2.close();
                j2.moveTo(17.571743f, 14.215094f);
                j2.lineTo(21.59651f, 11.99369f);
                j2.lineTo(22.946838f, 16.84039f);
                j2.cubicTo(23.169708f, 17.648172f, 22.671528f, 18.4812f, 21.832489f, 18.695766f);
                j2.lineTo(16.798254f, 19.995792f);
                j2.lineTo(16.785145f, 15.527741f);
                j2.cubicTo(16.772036f, 14.997633f, 17.073565f, 14.492769f, 17.571743f, 14.215094f);
                j2.close();
                j2.moveTo(16.785145f, 8.459637f);
                j2.lineTo(16.798254f, 3.9915855f);
                j2.lineTo(21.832489f, 5.2916117f);
                j2.cubicTo(22.671528f, 5.5061793f, 23.169708f, 6.3392057f, 22.946838f, 7.1469893f);
                j2.lineTo(21.59651f, 11.99369f);
                j2.lineTo(17.571743f, 9.772285f);
                j2.cubicTo(17.073565f, 9.507231f, 16.772036f, 9.002367f, 16.785145f, 8.459637f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
