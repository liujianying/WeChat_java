package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class c$b implements Runnable {
    private HashMap<String, c$c> dTw;
    private String url;

    c$b(String str, HashMap<String, c$c> hashMap) {
        this.url = str;
        this.dTw = hashMap;
    }

    public final void run() {
        byte[] WY = bi.WY(this.url);
        if (WY == null) {
            x.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[]{this.url});
            return;
        }
        Bitmap bs;
        try {
            bs = c.bs(WY);
        } catch (Exception e) {
            x.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[]{this.url, e.getLocalizedMessage()});
            bs = null;
        }
        x.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[]{this.url});
        ah.A(new c$a(this.url, bs, this.dTw));
    }
}
