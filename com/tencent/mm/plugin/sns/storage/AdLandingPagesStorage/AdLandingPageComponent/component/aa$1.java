package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

class aa$1 implements Runnable {
    final /* synthetic */ String nFR;
    final /* synthetic */ aa nFS;

    aa$1(aa aaVar, String str) {
        this.nFS = aaVar;
        this.nFR = str;
    }

    public final void run() {
        ah.A(new 2(this, Html.fromHtml(this.nFR, new ImageGetter() {
            public final Drawable getDrawable(String str) {
                String eH = d.eH("adId", str);
                if (bi.oW(eH) || !FileOp.cn(eH)) {
                    d.b("adId", str, false, 0, new 1(this));
                    return null;
                }
                Drawable createFromPath = Drawable.createFromPath(eH);
                if (createFromPath == null) {
                    return createFromPath;
                }
                int intrinsicWidth;
                int i;
                if (createFromPath.getIntrinsicHeight() != 0) {
                    intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) aa.a(aa$1.this.nFS).duz)) / createFromPath.getIntrinsicHeight();
                } else {
                    intrinsicWidth = createFromPath.getIntrinsicWidth();
                }
                if (createFromPath.getIntrinsicHeight() != 0) {
                    i = (int) aa.a(aa$1.this.nFS).duz;
                } else {
                    i = createFromPath.getIntrinsicHeight();
                }
                createFromPath.setBounds(0, 0, intrinsicWidth, i);
                return createFromPath;
            }
        }, null)));
    }
}
