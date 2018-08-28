package com.tencent.mm.plugin.nearlife.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class LogoImageView$1 extends ag {
    final /* synthetic */ LogoImageView lDZ;

    LogoImageView$1(LogoImageView logoImageView) {
        this.lDZ = logoImageView;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
            return;
        }
        Bitmap bitmap;
        Bitmap bs = c.bs(bArr);
        x.d("MicroMsg.LogoImageView", "filePath  %s", new Object[]{LogoImageView.a(this.lDZ) + g.u(LogoImageView.b(this.lDZ).getBytes())});
        e.b(r2, bArr, bArr.length);
        if (bs == null || LogoImageView.c(this.lDZ) <= 0 || LogoImageView.d(this.lDZ) <= 0) {
            bitmap = bs;
        } else {
            bitmap = c.a(bs, LogoImageView.d(this.lDZ), LogoImageView.c(this.lDZ), true, false);
        }
        this.lDZ.setImageBitmap(bitmap);
    }
}
