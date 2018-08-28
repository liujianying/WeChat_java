package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class k {

    /* renamed from: com.tencent.mm.plugin.emoji.e.k$2 */
    static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity bAl;
        final /* synthetic */ String fYD;
        final /* synthetic */ String ges;
        final /* synthetic */ String igm;
        final /* synthetic */ String igo;
        final /* synthetic */ String igp;
        final /* synthetic */ int igq;
        final /* synthetic */ String igr;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.igo = str;
            this.igp = str2;
            this.fYD = str3;
            this.igq = i;
            this.igm = str4;
            this.ges = str5;
            this.igr = str6;
            this.bAl = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.igo;
                String str3 = this.igp;
                String str4 = this.fYD;
                int i2 = this.igq;
                String str5 = this.igm;
                String str6 = this.ges;
                String str7 = this.igr;
                x.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                WXDesignerSharedObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                o.Pe();
                Bitmap jz = c.jz(str7);
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

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String ic = u.ic("emoje_stroe");
        u.Hx().v(ic, true).p("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", ic);
        d.c(context, "sns", ".ui.SnsUploadUI", intent);
    }

    public static void cZ(Context context) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
        d.b(context, ".ui.transmit.SelectConversationUI", intent, 2002);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        g.b(mMActivity.mController, str2, str4, str3, "", mMActivity.getString(R.l.app_send), new 3(str, i, i2, str2, str3, str4, str5, i3, str6, mMActivity));
    }
}
