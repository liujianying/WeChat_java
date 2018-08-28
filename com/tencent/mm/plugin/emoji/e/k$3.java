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
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class k$3 implements a {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ int bpX;
    final /* synthetic */ String dEt;
    final /* synthetic */ String fYD;
    final /* synthetic */ String igi;
    final /* synthetic */ int igs;
    final /* synthetic */ String igt;
    final /* synthetic */ String igu;
    final /* synthetic */ int igv;
    final /* synthetic */ String igw;

    k$3(String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6, MMActivity mMActivity) {
        this.igi = str;
        this.bpX = i;
        this.igs = i2;
        this.dEt = str2;
        this.fYD = str3;
        this.igt = str4;
        this.igu = str5;
        this.igv = i3;
        this.igw = str6;
        this.bAl = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            String str2 = this.igi;
            int i2 = this.bpX;
            int i3 = this.igs;
            String str3 = this.dEt;
            String str4 = this.fYD;
            String str5 = this.igt;
            String str6 = this.igu;
            int i4 = this.igv;
            String str7 = this.igw;
            x.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = str3;
            wXMediaMessage.description = str4;
            WXEmojiPageSharedObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
            wXEmojiPageSharedObject.type = i2;
            wXEmojiPageSharedObject.tid = i3;
            wXEmojiPageSharedObject.title = str3;
            wXEmojiPageSharedObject.desc = str4;
            wXEmojiPageSharedObject.iconUrl = str5;
            wXEmojiPageSharedObject.secondUrl = str6;
            wXEmojiPageSharedObject.pageType = i4;
            wXEmojiPageSharedObject.url = str7;
            wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
            o.Pe();
            Bitmap jz = c.jz(str5);
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
            h.bA(this.bAl, this.bAl.getString(R.l.app_shared));
        }
    }
}
