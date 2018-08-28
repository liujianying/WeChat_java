package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aa.c;
import com.tencent.mm.sdk.platformtools.x;

public class d$a implements Runnable {
    final /* synthetic */ d oQA;

    public d$a(d dVar) {
        this.oQA = dVar;
    }

    public final void run() {
        x.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
        Bitmap a = c.a(this.oQA.cYO, false, -1);
        if (a != null && this.oQA.oQr != null) {
            int i = 0;
            while (true) {
                if ((this.oQA.oQr.getHeight() == 0 || this.oQA.oQr.getWidth() == 0) && i < 10) {
                    try {
                        Thread.sleep(300);
                        i++;
                    } catch (InterruptedException e) {
                        x.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                        return;
                    }
                }
            }
            if (a.getHeight() <= a.getWidth() && a.getHeight() / 5 > 0 && ((int) (((double) a.getHeight()) * 0.6d)) > 0) {
                a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
            }
            a = com.tencent.mm.sdk.platformtools.c.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) this.oQA.oQr.getHeight())) / ((float) this.oQA.oQr.getWidth()))), true, false);
            if (a == null) {
                x.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                return;
            }
            try {
                a = com.tencent.mm.sdk.platformtools.c.e(a, 20);
                x.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                this.oQA.guJ.post(new 1(this, a));
            } catch (Exception e2) {
                x.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
            }
        }
    }
}
