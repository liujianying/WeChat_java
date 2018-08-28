package com.tencent.mm.plugin.emoji.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class k$1 implements a {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ String gtU;
    final /* synthetic */ String igi;
    final /* synthetic */ String igj;
    final /* synthetic */ String igk;
    final /* synthetic */ String igl;
    final /* synthetic */ String igm;
    final /* synthetic */ int ign;

    public k$1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
        this.igi = str;
        this.igj = str2;
        this.igk = str3;
        this.igl = str4;
        this.gtU = str5;
        this.igm = str6;
        this.ign = i;
        this.bAl = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            String str2 = this.igi;
            String str3 = this.igj;
            String str4 = this.igk;
            String str5 = this.igl;
            String str6 = this.gtU;
            String str7 = this.igm;
            int i2 = this.ign;
            x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = str4;
            wXMediaMessage.description = str5;
            WXEmojiSharedObject wXEmojiSharedObject = new WXEmojiSharedObject();
            wXEmojiSharedObject.packageflag = i2;
            wXEmojiSharedObject.packageid = str3;
            wXEmojiSharedObject.thumburl = str6;
            wXEmojiSharedObject.url = str7;
            wXMediaMessage.mediaObject = wXEmojiSharedObject;
            o.Pe();
            Bitmap jz = c.jz(str6);
            if (!(jz == null || jz.isRecycled())) {
                x.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                jz.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
            }
            ot otVar = new ot();
            otVar.bZE.bSg = wXMediaMessage;
            otVar.bZE.toUser = str2;
            otVar.bZE.bZF = 49;
            otVar.bZE.bZG = str2;
            otVar.bZE.bZH = "";
            com.tencent.mm.sdk.b.a.sFg.m(otVar);
            if (!TextUtils.isEmpty(str)) {
                ow owVar = new ow();
                owVar.bZQ.bZR = str2;
                owVar.bZQ.content = str;
                owVar.bZQ.type = s.hQ(str2);
                owVar.bZQ.flags = 0;
                com.tencent.mm.sdk.b.a.sFg.m(owVar);
            }
            h.mEJ.h(10993, new Object[]{Integer.valueOf(0), str3});
            com.tencent.mm.ui.base.h.bA(this.bAl, this.bAl.getString(R.l.app_shared));
        }
    }
}
