package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsTransparentUI$1$1 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ String ofN;
    final /* synthetic */ 1 ofO;
    final /* synthetic */ Context val$context;

    SnsTransparentUI$1$1(1 1, String str, String str2, Context context) {
        this.ofO = 1;
        this.ofN = str;
        this.bAd = str2;
        this.val$context = context;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = this.ofO.ofH;
            wXMediaMessage.description = this.ofO.ofJ;
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.canvasPageXml = this.ofN;
            wXWebpageObject.webpageUrl = this.ofO.ofK;
            wXMediaMessage.mediaObject = wXWebpageObject;
            if (SnsTransparentUI.a(this.ofO.ofM).containsKey(this.ofO.ofI)) {
                Bitmap bitmap = (Bitmap) SnsTransparentUI.a(this.ofO.ofM).get(this.ofO.ofI);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    x.i("SnsTransparentUI", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                ot otVar = new ot();
                otVar.bZE.bSg = wXMediaMessage;
                otVar.bZE.toUser = this.bAd;
                otVar.bZE.bZF = 49;
                otVar.bZE.bZG = "";
                otVar.bZE.bZH = "";
                otVar.bZE.bZN = this.ofO.ofL;
                com.tencent.mm.sdk.b.a.sFg.m(otVar);
                if (!TextUtils.isEmpty(str)) {
                    ow owVar = new ow();
                    owVar.bZQ.bZR = this.bAd;
                    owVar.bZQ.content = str;
                    owVar.bZQ.type = s.hQ(this.bAd);
                    owVar.bZQ.flags = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(owVar);
                }
                h.bA(this.val$context, this.val$context.getString(j.app_shared));
                this.ofO.ofM.finish();
                return;
            }
            ac.ce(this.ofO.ofI);
            d.b("adId", this.ofO.ofI, false, 1000000001, new 1(this, wXMediaMessage, str));
            return;
        }
        this.ofO.ofM.finish();
    }
}
