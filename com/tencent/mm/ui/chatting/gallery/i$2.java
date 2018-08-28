package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class i$2 implements Runnable {
    final /* synthetic */ i tWK;
    final /* synthetic */ int tWL;

    i$2(i iVar, int i) {
        this.tWK = iVar;
        this.tWL = i;
    }

    public final void run() {
        x.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
        t.nZ(i.a(this.tWK));
        if (this.tWK.tTx != null) {
            OnClickListener 1;
            j cwO = this.tWK.tTx.cwO();
            cwO.cxz().tXa.stop();
            cwO.a(false, 0.0f);
            String string = this.tWK.tTx.tTy.getString(R.l.video_file_play_faile);
            if (this.tWL == -5103059 || this.tWL == -5103087) {
                string = this.tWK.tTx.tTy.getString(R.l.video_file_expired);
                1 = new 1(this);
            } else {
                1 = new 2(this);
            }
            h.a(this.tWK.tTx.tTy, string, this.tWK.tTx.tTy.getString(R.l.chatting_play_err), 1);
            this.tWK.tWt.clear();
            ImageGalleryUI.cxi();
        }
    }
}
