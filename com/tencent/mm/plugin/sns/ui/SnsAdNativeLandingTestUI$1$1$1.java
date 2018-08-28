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
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.1.1;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsAdNativeLandingTestUI$1$1$1 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ 1 nTg;
    final /* synthetic */ Context val$context;

    SnsAdNativeLandingTestUI$1$1$1(1 1, String str, Context context) {
        this.nTg = 1;
        this.bAd = str;
        this.val$context = context;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = "test title";
            wXMediaMessage.description = "test desc";
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.canvasPageXml = "<xml></xml>";
            wXWebpageObject.webpageUrl = "http://www.baidu.com/";
            wXMediaMessage.mediaObject = wXWebpageObject;
            Bitmap bitmap = ad.getBitmap("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
            if (!(bitmap == null || bitmap.isRecycled())) {
                x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
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
            com.tencent.mm.sdk.b.a.sFg.m(otVar);
            if (!TextUtils.isEmpty(str)) {
                ow owVar = new ow();
                owVar.bZQ.bZR = this.bAd;
                owVar.bZQ.content = str;
                owVar.bZQ.type = s.hQ(this.bAd);
                owVar.bZQ.flags = 0;
                com.tencent.mm.sdk.b.a.sFg.m(owVar);
            }
            h.bA(this.val$context, this.val$context.getString(i$j.app_shared));
        }
    }
}
