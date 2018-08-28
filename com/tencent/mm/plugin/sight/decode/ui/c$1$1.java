package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mm.plugin.ak.a.e;
import com.tencent.mm.plugin.ak.a.h;
import com.tencent.mm.plugin.sight.decode.ui.c.1;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1$1 implements Runnable {
    final /* synthetic */ String fYI;
    final /* synthetic */ Bitmap mtk;
    final /* synthetic */ 1 ndS;

    c$1$1(1 1, Bitmap bitmap, String str) {
        this.ndS = 1;
        this.mtk = bitmap;
        this.fYI = str;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.ndS.ndR.findViewById(e.videoplayer_maskview);
        imageView.setImageBitmap(this.mtk);
        imageView.setVisibility(0);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.fYI)), "video/*");
        try {
            this.ndS.ndR.getContext().startActivity(Intent.createChooser(intent, this.ndS.ndR.getContext().getString(h.app_video_for_icon)));
        } catch (Exception e) {
            x.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.i(this.ndS.ndR.getContext(), h.no_match_application_msg, h.no_match_application_title);
        }
    }
}
