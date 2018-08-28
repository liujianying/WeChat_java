package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ String fYF;
    final /* synthetic */ b nHy;
    final /* synthetic */ String nHz;

    b$3(b bVar, String str, String str2, String str3) {
        this.nHy = bVar;
        this.dat = str;
        this.nHz = str2;
        this.fYF = str3;
    }

    public final void run() {
        float f = 1.0f;
        Bitmap bitmap = null;
        x.i("ContentFragment", "download bg ok path %s ", new Object[]{this.dat});
        try {
            if (b.d(this.nHy).nIh) {
                b.e(this.nHy);
                String eH = d.eH(this.nHz, this.fYF + "_blurimg");
                if (FileOp.cn(eH)) {
                    bitmap = BitmapFactory.decodeFile(eH);
                } else {
                    Bitmap decodeFile = c.decodeFile(this.dat, null);
                    if (decodeFile != null) {
                        n a;
                        if (decodeFile.getHeight() < b.f(this.nHy) || decodeFile.getWidth() < b.g(this.nHy)) {
                            f = Math.max((((float) b.g(this.nHy)) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) b.f(this.nHy))) / ((float) decodeFile.getHeight()));
                        }
                        Bitmap a2 = c.a(decodeFile, f, f);
                        try {
                            a2 = Bitmap.createBitmap(a2, (a2.getWidth() - b.g(this.nHy)) >>> 1, (a2.getHeight() - b.f(this.nHy)) >>> 1, b.g(this.nHy), b.f(this.nHy));
                        } catch (Throwable e) {
                            x.printErrStackTrace("ContentFragment", e, "", new Object[0]);
                            a2 = null;
                        }
                        if (a2 != null) {
                            a = a.a(a2, eH, Color.argb(140, 0, 0, 0), 180);
                        } else {
                            a = null;
                        }
                        if (a != null) {
                            bitmap = a.Fx();
                        }
                    }
                }
            } else {
                bitmap = c.decodeFile(this.dat, null);
            }
            ah.A(new 1(this, bitmap));
        } catch (Exception e2) {
            x.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e2.toString());
        }
    }
}
