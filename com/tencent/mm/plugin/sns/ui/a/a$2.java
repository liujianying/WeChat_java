package com.tencent.mm.plugin.sns.ui.a;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    final /* synthetic */ c nMg;
    final /* synthetic */ a oiE;

    a$2(a aVar, c cVar) {
        this.oiE = aVar;
        this.nMg = cVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        x.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[]{str});
        if (!bi.G(new String[]{(String) this.nMg.ojZ.getTag(), str}) && str.equals(d.eH("adId", (String) this.nMg.ojZ.getTag()))) {
            Bitmap decodeFile = com.tencent.mm.sdk.platformtools.c.decodeFile(str, null);
            if (decodeFile != null) {
                this.nMg.ojZ.setVisibility(0);
                this.nMg.oka.setImageBitmap(decodeFile);
                this.nMg.oka.setVisibility(0);
            }
        }
    }
}
