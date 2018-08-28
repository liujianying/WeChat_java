package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class OnlineVideoView$8 implements Runnable {
    final /* synthetic */ String jfT;
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$8(OnlineVideoView onlineVideoView, String str) {
        this.nPH = onlineVideoView;
        this.jfT = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jfT)), "video/*");
        try {
            this.nPH.getContext().startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
            h.i(this.nPH.getContext(), j.favorite_no_match_msg, j.favorite_no_match_title);
        }
    }
}
