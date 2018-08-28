package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.bl.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends i implements c {
    Bitmap hqv;
    private float qEJ;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.ccZ(), str);
        this.qEJ = 0.5f;
        this.hqv = null;
    }

    public b(String str, float f) {
        this(str);
        this.qEJ = f;
    }

    public final void jX(String str) {
        super.jX(str);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        a aVar = a.a.sCg;
        if (aVar != null) {
            bitmap = a.a.sCg.FK(this.tag);
        }
        if (bitmap != null) {
            a(canvas, bitmap);
            return;
        }
        if (this.qFD) {
            bitmap = this.lZs.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else {
            bitmap = this.lZs.cJ(this.tag);
        }
        if (bitmap != null) {
            bitmap = com.tencent.mm.sdk.platformtools.c.a(bitmap, false, this.qEJ * ((float) bitmap.getWidth()));
            if (aVar != null) {
                aVar.p(this.tag, bitmap);
            }
            a(canvas, bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
            if (this.hqv == null) {
                try {
                    this.hqv = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null));
                    this.hqv = com.tencent.mm.sdk.platformtools.c.a(this.hqv, false, this.qEJ * ((float) this.hqv.getWidth()));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                }
            }
            a(canvas, this.hqv);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.qFI > 1.0f || this.lkD) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, dvs);
    }
}
