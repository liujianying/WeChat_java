package com.tencent.mm.plugin.location.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class SimpleImageView$1 extends ag {
    final /* synthetic */ SimpleImageView kGp;

    SimpleImageView$1(SimpleImageView simpleImageView) {
        this.kGp = simpleImageView;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
            return;
        }
        Bitmap bitmap;
        Bitmap bs = c.bs(bArr);
        x.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[]{SimpleImageView.a(this.kGp) + g.u(SimpleImageView.b(this.kGp).getBytes())});
        e.b(r2, bArr, bArr.length);
        if (bs == null || SimpleImageView.c(this.kGp) <= 0 || SimpleImageView.d(this.kGp) <= 0) {
            bitmap = bs;
        } else {
            bitmap = c.a(bs, SimpleImageView.d(this.kGp), SimpleImageView.c(this.kGp), true, false);
        }
        this.kGp.setImageBitmap(bitmap);
    }
}
