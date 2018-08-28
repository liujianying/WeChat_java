package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class ah$3 extends w$a {
    final /* synthetic */ ah nQf;

    ah$3(ah ahVar) {
        this.nQf = ahVar;
    }

    public final void xh(int i) {
        x.d("MicroMsg.PicWidget", "I click");
        if (i < 0) {
            this.nQf.bCA();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.nQf.bGc, SnsUploadBrowseUI.class);
        intent.putExtra("sns_gallery_position", i);
        intent.putExtra("sns_gallery_temp_paths", this.nQf.nPY.nQj);
        this.nQf.bGc.startActivityForResult(intent, 7);
    }
}
