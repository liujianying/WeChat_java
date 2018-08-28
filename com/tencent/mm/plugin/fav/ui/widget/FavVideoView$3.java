package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class FavVideoView$3 implements Runnable {
    final /* synthetic */ FavVideoView jfS;
    final /* synthetic */ String jfT;

    FavVideoView$3(FavVideoView favVideoView, String str) {
        this.jfS = favVideoView;
        this.jfT = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jfT)), "video/*");
        try {
            this.jfS.getContext().startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
            h.i(this.jfS.getContext(), i.favorite_no_match_msg, i.favorite_no_match_title);
        }
    }
}
