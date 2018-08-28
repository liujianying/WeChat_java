package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.ak.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class CdnImageView$1 extends ag {
    final /* synthetic */ CdnImageView qIp;

    CdnImageView$1(CdnImageView cdnImageView) {
        this.qIp = cdnImageView;
    }

    public final void handleMessage(Message message) {
        String aG = bi.aG(message.getData().getString("k_url"), "");
        CdnImageView.a(this.qIp, bi.aG(CdnImageView.a(this.qIp), ""));
        if (bi.oW(CdnImageView.a(this.qIp)) && bi.oW(aG)) {
            this.qIp.setImageBitmap(null);
            this.qIp.setImageBitmapCompleted(null);
        } else if (CdnImageView.a(this.qIp).equals(aG)) {
            byte[] byteArray = message.getData().getByteArray("k_data");
            if (byteArray == null || byteArray.length == 0) {
                x.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bs = c.bs(byteArray);
            o.Pe();
            com.tencent.mm.ak.c.h(CdnImageView.a(this.qIp), bs);
            if (CdnImageView.b(this.qIp)) {
                CdnImageView.a(this.qIp, bs);
            }
            if (bs != null && CdnImageView.c(this.qIp) > 0 && CdnImageView.d(this.qIp) > 0) {
                bs = c.a(bs, CdnImageView.d(this.qIp), CdnImageView.c(this.qIp), true, false);
            }
            if (CdnImageView.e(this.qIp) && bs != null) {
                bs = c.a(bs, false, ((float) bs.getWidth()) * 0.5f);
            }
            if (bs != null) {
                this.qIp.setImageBitmap(bs);
            }
            this.qIp.setImageBitmapCompleted(bs);
        } else {
            x.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
        }
    }
}
