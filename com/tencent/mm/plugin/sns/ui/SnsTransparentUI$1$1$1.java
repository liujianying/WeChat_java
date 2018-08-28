package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1.1;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class SnsTransparentUI$1$1$1 implements d$a {
    final /* synthetic */ String dho;
    final /* synthetic */ WXMediaMessage ofP;
    final /* synthetic */ 1 ofQ;

    SnsTransparentUI$1$1$1(1 1, WXMediaMessage wXMediaMessage, String str) {
        this.ofQ = 1;
        this.ofP = wXMediaMessage;
        this.dho = str;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            this.ofQ.ofO.ofM.nEi.put(this.ofQ.ofO.ofI, decodeFile);
            if (!(decodeFile == null || decodeFile.isRecycled())) {
                x.i("SnsTransparentUI", "thumb image is not null");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                this.ofP.thumbData = byteArrayOutputStream.toByteArray();
            }
            ot otVar = new ot();
            otVar.bZE.bSg = this.ofP;
            otVar.bZE.toUser = this.ofQ.bAd;
            otVar.bZE.bZF = 49;
            otVar.bZE.bZG = "";
            otVar.bZE.bZH = "";
            otVar.bZE.bZN = this.ofQ.ofO.ofL;
            a.sFg.m(otVar);
            if (!TextUtils.isEmpty(this.dho)) {
                ow owVar = new ow();
                owVar.bZQ.bZR = this.ofQ.bAd;
                owVar.bZQ.content = this.dho;
                owVar.bZQ.type = s.hQ(this.ofQ.bAd);
                owVar.bZQ.flags = 0;
                a.sFg.m(owVar);
            }
            h.bA(this.ofQ.val$context, this.ofQ.val$context.getString(j.app_shared));
            this.ofQ.ofO.ofM.finish();
        } catch (Exception e) {
            x.e("SnsTransparentUI", "this has a error : " + e.toString());
            this.ofQ.ofO.ofM.finish();
        }
    }
}
