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
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class zw extends c {
    private final int height = TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
    private final int width = TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
            case 1:
                return TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;
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
                i2.setColor(-855310);
                canvas.save();
                i2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(57.788662f, 79.0313f);
                j.lineTo(59.890873f, 81.133514f);
                j.lineTo(98.07464f, 42.94975f);
                j.lineTo(93.870224f, 38.745327f);
                j.lineTo(59.929096f, 72.686455f);
                j.lineTo(25.242641f, 38.0f);
                j.lineTo(21.0f, 42.24264f);
                j.lineTo(57.788662f, 79.0313f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
