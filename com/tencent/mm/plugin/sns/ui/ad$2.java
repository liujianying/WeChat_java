package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;

class ad$2 implements OnClickListener {
    final /* synthetic */ ad nPa;

    ad$2(ad adVar) {
        this.nPa = adVar;
    }

    public final void onClick(View view) {
        if (FileOp.cn(this.nPa.videoPath)) {
            int width;
            int height;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                width = view.getWidth();
                height = view.getHeight();
            } else {
                height = 0;
                width = 0;
            }
            Intent intent = new Intent(this.nPa.bGc, SnsOnlineVideoActivity.class);
            intent.putExtra("intent_videopath", this.nPa.videoPath);
            intent.putExtra("intent_thumbpath", this.nPa.bOX);
            intent.putExtra("intent_isad", false);
            intent.putExtra("intent_ispreview", true);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            this.nPa.bGc.startActivity(intent);
            this.nPa.bGc.overridePendingTransition(0, 0);
            return;
        }
        x.i("MicroMsg.SightWidget", "click videopath is not exist " + this.nPa.videoPath);
    }
}
