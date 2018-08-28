package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ a iLA;
    final /* synthetic */ nc iLz;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, nc ncVar) {
        this.iLA = aVar;
        this.iLz = ncVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        x.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.iLz.bYc.bYd.TB(null);
        } else if (f.zZ()) {
            au.HN();
            b bVar = (b) bs.iK("plugin.extaccessories");
            if (bVar == null) {
                x.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                au.HN().a("plugin.extaccessories", bVar);
            }
            String str = System.currentTimeMillis();
            String str2 = (!au.HX() || bi.oW(str)) ? "" : bVar.dqp + "image/spen/spen_" + str;
            if (bi.oW(str2)) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.iLz.bYc.bYd.TB(null);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                c.a(bitmap, 55, CompressFormat.JPEG, str2, true);
                x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[]{str2});
                this.iLz.bYc.bYd.TB(str2);
            } catch (Throwable e) {
                x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.iLz.bYc.bYd.TB(null);
            }
        } else {
            x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.iLz.bYc.bYd.TB(null);
        }
    }
}
