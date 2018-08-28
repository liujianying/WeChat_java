package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class SnsSightPlayerUI$9$1 implements Runnable {
    final /* synthetic */ String fYI;
    final /* synthetic */ Bitmap mtk;
    final /* synthetic */ 9 obf;

    SnsSightPlayerUI$9$1(9 9, Bitmap bitmap, String str) {
        this.obf = 9;
        this.mtk = bitmap;
        this.fYI = str;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.obf.obb.findViewById(f.videoplayer_maskview);
        if (imageView != null) {
            imageView.setImageBitmap(this.mtk);
            imageView.setVisibility(0);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.fYI)), "video/*");
        try {
            this.obf.obb.mController.tml.startActivity(Intent.createChooser(intent, this.obf.obb.mController.tml.getString(j.favorite_video)));
        } catch (Exception e) {
            x.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
            h.i(this.obf.obb.mController.tml, j.favorite_no_match_msg, j.favorite_no_match_title);
        }
    }
}
