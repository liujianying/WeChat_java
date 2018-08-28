package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.api.j;
import com.tencent.mm.c.g;
import com.tencent.mm.plugin.mmsight.ui.a.1;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements j {
    final /* synthetic */ 1 lpl;

    a$1$1(1 1) {
        this.lpl = 1;
    }

    public final void c(Exception exception) {
        x.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[]{exception});
    }

    public final void a(Bitmap bitmap, boolean z) {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[]{bitmap, Boolean.valueOf(z)});
        if (z) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            if (this.lpl.lpk.lpc == null || this.lpl.lpk.lpe) {
                if (this.lpl.lpk.lpe) {
                    ah.A(new 3(this));
                }
            } else if (this.lpl.lpk.loW <= 0 || this.lpl.lpk.loU <= 0 || this.lpl.lpk.loW > this.lpl.lpk.loU) {
                this.lpl.lpk.bKg = g.cu(this.lpl.lpk.videoPath);
                ah.A(new 2(this));
            } else {
                ah.A(new 1(this));
            }
        } else if (bitmap != null) {
            ah.A(new 4(this, bitmap));
        }
    }
}
