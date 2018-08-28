package com.tencent.mm.plugin.collect.reward.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$8 implements Runnable {
    final /* synthetic */ QrRewardMainUI hWf;
    final /* synthetic */ ViewGroup hWi;
    final /* synthetic */ ImageView hWj;

    QrRewardMainUI$8(QrRewardMainUI qrRewardMainUI, ViewGroup viewGroup, ImageView imageView) {
        this.hWf = qrRewardMainUI;
        this.hWi = viewGroup;
        this.hWj = imageView;
    }

    public final void run() {
        x.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", new Object[]{Integer.valueOf(this.hWi.getHeight()), Integer.valueOf(this.hWi.getWidth())});
        Bitmap createBitmap = Bitmap.createBitmap(QrRewardMainUI.r(this.hWf).getWidth(), QrRewardMainUI.r(this.hWf).getHeight(), Config.ARGB_8888);
        QrRewardMainUI.r(this.hWf).draw(new Canvas(createBitmap));
        this.hWj.setImageBitmap(createBitmap);
        Bitmap createBitmap2 = Bitmap.createBitmap(this.hWi.getWidth(), this.hWi.getHeight(), Config.ARGB_8888);
        this.hWi.draw(new Canvas(createBitmap2));
        try {
            String str = l.cfw() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
            c.a(createBitmap2, 100, CompressFormat.PNG, str, false);
            Toast.makeText(this.hWf.mController.tml, this.hWf.getString(i.cropimage_saved, new Object[]{str}), 1).show();
            l.a(str, this.hWf.mController.tml);
        } catch (Exception e) {
            x.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + e.getMessage());
        }
        QrRewardMainUI.s(this.hWf).setVisibility(8);
        createBitmap2.recycle();
    }
}
