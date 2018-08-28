package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.b;

class j$2 implements OnClickListener {
    final /* synthetic */ j tXq;

    j$2(j jVar) {
        this.tXq = jVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof bd)) {
            bd bdVar = (bd) view.getTag();
            a.a(a.a.tFI, bdVar);
            r nW = t.nW(bdVar.field_imgPath);
            bri bri = nW.enV;
            if (bri != null && !ai.oW(bri.dyJ)) {
                int i;
                o.Ta();
                String nL = s.nL(bdVar.field_imgPath);
                Intent intent = new Intent();
                intent.putExtra("IsAd", false);
                intent.putExtra("KStremVideoUrl", bri.dyJ);
                intent.putExtra("KThumUrl", bri.dyO);
                intent.putExtra("KThumbPath", nL);
                intent.putExtra("KMediaId", "fakeid_" + bdVar.field_msgId);
                intent.putExtra("KMediaVideoTime", bri.rBq);
                intent.putExtra("KMediaTitle", bri.dyL);
                intent.putExtra("StreamWording", bri.dyM);
                intent.putExtra("StremWebUrl", bri.dyN);
                String str = bdVar.field_talker;
                boolean endsWith = str.endsWith("@chatroom");
                nL = endsWith ? com.tencent.mm.model.bd.iB(bdVar.field_content) : str;
                intent.putExtra("KSta_StremVideoAduxInfo", bri.dyP);
                intent.putExtra("KSta_StremVideoPublishId", bri.dyQ);
                intent.putExtra("KSta_SourceType", 1);
                String str2 = "KSta_Scene";
                if (endsWith) {
                    i = b.tFR.value;
                } else {
                    i = b.tFQ.value;
                }
                intent.putExtra(str2, i);
                intent.putExtra("KSta_FromUserName", nL);
                intent.putExtra("KSta_ChatName", str);
                intent.putExtra("KSta_MsgId", bdVar.field_msgSvrId);
                intent.putExtra("KSta_SnsStatExtStr", nW.bZN);
                if (endsWith) {
                    intent.putExtra("KSta_ChatroomMembercount", m.gK(str));
                }
                d.b(this.tXq.tTU.tTy.mController.tml, "sns", ".ui.VideoAdPlayerUI", intent);
            } else if (bri != null && !bi.oW(bri.dyM) && !bi.oW(bri.dyN)) {
                x.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + bri.dyN);
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", nW.bZN);
                intent2.putExtra("jsapiargs", bundle);
                intent2.putExtra("rawUrl", bri.dyN);
                intent2.putExtra("useJs", true);
                au.DF().a(new c("", 18, 5, "", 2, -1), 0);
                new ag(Looper.getMainLooper()).post(new 1(this, intent2));
            }
        }
    }
}
