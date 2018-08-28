package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$5 implements Runnable {
    final /* synthetic */ CollectMainUI hYN;
    final /* synthetic */ LinearLayout hYP;
    final /* synthetic */ boolean hYQ;

    CollectMainUI$5(CollectMainUI collectMainUI, LinearLayout linearLayout, boolean z) {
        this.hYN = collectMainUI;
        this.hYP = linearLayout;
        this.hYQ = z;
    }

    public final void run() {
        x.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[]{Integer.valueOf(this.hYP.getHeight()), Integer.valueOf(this.hYP.getWidth())});
        Bitmap createBitmap = Bitmap.createBitmap(this.hYP.getWidth(), this.hYP.getHeight(), Config.ARGB_8888);
        this.hYP.draw(new Canvas(createBitmap));
        try {
            String str = l.cfw() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
            c.a(createBitmap, 100, CompressFormat.PNG, str, false);
            if (this.hYQ) {
                Toast.makeText(this.hYN.mController.tml, this.hYN.getString(i.wallet_cropimage_saved, new Object[]{str}), 1).show();
            }
            l.a(str, this.hYN.mController.tml);
        } catch (Exception e) {
            x.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
        }
        this.hYN.hVW.setVisibility(8);
    }
}
