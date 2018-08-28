package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.ui.a.a;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$2 implements a {
    final /* synthetic */ MMSightEditUI llg;

    MMSightEditUI$2(MMSightEditUI mMSightEditUI) {
        this.llg = mMSightEditUI;
    }

    public final void beR() {
        x.i("MicroMsg.MMSightEditUI", "onEditFinish");
        try {
            MMSightEditUI.b(this.llg);
            if (MMSightEditUI.c(this.llg) != null) {
                MMSightEditUI.c(this.llg).l(false, "");
                MMSightEditUI.c(this.llg).release();
                MMSightEditUI.d(this.llg);
            }
            Bitmap mZ = d.mZ(MMSightEditUI.e(this.llg));
            if (mZ != null) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (d.a(mZ.getWidth(), mZ.getHeight(), MMSightEditUI.f(this.llg).dQS, pInt, pInt2)) {
                    mZ = Bitmap.createScaledBitmap(mZ, pInt.value, pInt2.value, true);
                }
                x.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(mZ.getWidth()), Integer.valueOf(mZ.getHeight())});
                c.a(mZ, 80, CompressFormat.JPEG, MMSightEditUI.g(this.llg), true);
                Intent intent = new Intent();
                intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.e(this.llg));
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.g(this.llg));
                this.llg.setResult(-1, intent);
                this.llg.finish();
                return;
            }
            x.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightEditUI", e, "save video thumb error", new Object[0]);
            Toast.makeText(this.llg, f.mmsight_clip_failed, 1).show();
            this.llg.finish();
        }
    }

    public final void beS() {
        x.i("MicroMsg.MMSightEditUI", "onExitEdit");
        if (MMSightEditUI.c(this.llg) != null) {
            MMSightEditUI.c(this.llg).l(true, "");
            MMSightEditUI.c(this.llg).release();
            MMSightEditUI.d(this.llg);
        }
        this.llg.finish();
    }

    public final void onError() {
        if (MMSightEditUI.c(this.llg) != null) {
            MMSightEditUI.c(this.llg).release();
            MMSightEditUI.d(this.llg);
        }
        ah.A(new 1(this));
    }
}
