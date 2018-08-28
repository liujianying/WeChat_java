package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.j.1;
import java.io.File;

class j$1$1 implements Runnable {
    final /* synthetic */ String fYI;
    final /* synthetic */ 1 tXr;

    j$1$1(1 1, String str) {
        this.tXr = 1;
        this.fYI = str;
    }

    public final void run() {
        if (bi.oW(this.fYI)) {
            h.i(this.tXr.tXq.tTU.tTy, R.l.video_file_play_faile, R.l.chatting_play_err);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.fYI)), "video/*");
        try {
            this.tXr.tXq.tTU.tTy.startActivity(Intent.createChooser(intent, this.tXr.tXq.tTU.tTy.mController.tml.getString(R.l.favorite_video)));
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
            h.i(this.tXr.tXq.tTU.tTy, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
        }
    }
}
