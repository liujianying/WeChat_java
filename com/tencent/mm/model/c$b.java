package com.tencent.mm.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;

class c$b implements Runnable {
    String bXS;
    String dAl;

    public c$b(String str, String str2) {
        this.bXS = str;
        this.dAl = str2;
    }

    public final void run() {
        if (!bi.oW(this.bXS) && !bi.oW(this.dAl)) {
            x.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.bXS + " to :" + this.dAl);
            if (f.zZ() && this.dAl.substring(0, e.bnE.length()).equals(e.bnE)) {
                j.q(this.bXS + "image/", this.dAl + "image/", true);
                j.q(this.bXS + "image2/", this.dAl + "image2/", true);
                j.q(this.bXS + "video/", this.dAl + "video/", true);
                j.q(this.bXS + "voice/", this.dAl + "voice/", true);
                j.q(this.bXS + "voice2/", this.dAl + "voice2/", true);
                j.q(this.bXS + "package/", this.dAl + "package/", true);
                j.q(this.bXS + "emoji/", this.dAl + "emoji/", true);
                j.q(this.bXS + "mailapp/", this.dAl + "mailapp/", true);
                j.q(this.bXS + "brandicon/", this.dAl + "brandicon/", true);
            }
        }
    }
}
