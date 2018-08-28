package com.tencent.mm.plugin.location.model;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class k$a implements a {
    private byte[] data;
    boolean kDd = true;
    private int kDe;
    private int kDf;
    final /* synthetic */ k kDg;
    private String mFilePath;
    String url = "";

    public k$a(k kVar, boolean z, String str, String str2) {
        this.kDg = kVar;
        this.kDd = z;
        this.kDe = kVar.w;
        this.kDf = kVar.h;
        this.url = str;
        while (this.kDe * this.kDf > 270000) {
            this.kDe = (int) (((double) this.kDe) / 1.2d);
            this.kDf = (int) (((double) this.kDf) / 1.2d);
        }
        this.mFilePath = str2;
        x.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[]{str, bi.aG(this.mFilePath, "")});
    }

    public final boolean Kr() {
        this.data = bi.WY(this.url);
        if (this.data != null) {
            e.b(this.mFilePath, this.data, this.data.length);
        }
        return true;
    }

    public final boolean Ks() {
        x.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.kDd);
        if (this.data != null) {
            k.a(this.kDg, true);
        } else if (!this.kDd) {
            k.a(this.kDg, false);
        } else if (this.kDg.kDc == null) {
            k.a(this.kDg, false);
        } else {
            this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.kDe), Integer.valueOf(this.kDf), Float.valueOf(this.kDg.kDc.dRT), Float.valueOf(this.kDg.kDc.dRS), Integer.valueOf(this.kDg.kDc.bSz)});
            this.kDg.dRY.c(new k$a(this.kDg, false, this.url, k.b(this.kDg.kDc)));
        }
        return false;
    }
}
