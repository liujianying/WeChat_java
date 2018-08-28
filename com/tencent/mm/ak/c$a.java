package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class c$a implements Runnable {
    private HashMap<String, c$c> dTw;
    private Bitmap dTx;
    private String url;

    public c$a(String str, Bitmap bitmap, HashMap<String, c$c> hashMap) {
        this.url = str;
        this.dTx = bitmap;
        this.dTw = hashMap;
    }

    public final void run() {
        o.Pe();
        c.h(this.url, this.dTx);
        if (this.dTw != null) {
            c$c c_c = (c$c) this.dTw.remove(this.url);
            if (c_c != null) {
                c_c.r(this.dTx);
            }
        }
        String str = "MicroMsg.CdnImageService";
        String str2 = "finish download post job, url[%s]";
        Object[] objArr = new Object[1];
        objArr[0] = this.url == null ? "null" : this.url;
        x.i(str, str2, objArr);
    }
}
