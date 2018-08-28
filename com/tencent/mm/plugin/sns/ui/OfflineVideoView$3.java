package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class OfflineVideoView$3 implements Runnable {
    final /* synthetic */ String jfT;
    final /* synthetic */ OfflineVideoView nPk;

    OfflineVideoView$3(OfflineVideoView offlineVideoView, String str) {
        this.nPk = offlineVideoView;
        this.jfT = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jfT)), "video/*");
        try {
            this.nPk.getContext().startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
            h.i(this.nPk.getContext(), i$j.favorite_no_match_msg, i$j.favorite_no_match_title);
        }
    }
}
