package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.i.a;
import java.io.File;

class i$13 implements Runnable {
    final /* synthetic */ String jfT;
    final /* synthetic */ i tWK;

    i$13(i iVar, String str) {
        this.tWK = iVar;
        this.jfT = str;
    }

    public final void run() {
        if (this.tWK.tTx == null || this.tWK.tTx.cwO() == null || i.l(this.tWK) == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
            return;
        }
        this.tWK.tTx.cwO().a(false, 0.0f);
        if (!bi.oW(this.jfT)) {
            x.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", this.jfT);
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(this.jfT)), "video/*");
                this.tWK.tTx.tTy.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                h.i(this.tWK.tTx.tTy, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
            }
        }
        a aVar = (a) i.l(this.tWK).get(i.a(this.tWK));
        if (aVar != null && aVar.bGS != null) {
            this.tWK.FH(aVar.pos);
        }
    }
}
