package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.av;

public final class a {
    public String bKg = "";
    public String mediaId = "";
    public e nkK = null;
    public String nkR = "";
    public String nkS = "";
    public String nnX = "";
    public String nob = "";
    public ate noc;
    public boolean nsG = false;
    public boolean nsH = false;
    public int nsI = 0;
    public av nsJ;
    public float nsK = 0.0f;
    public String url = "";

    public a(String str) {
        this.mediaId = str;
    }

    public final boolean init() {
        this.nnX = an.s(af.getAccSnsPath(), this.mediaId);
        return true;
    }

    public final String byY() {
        if (this.nsI == 4) {
            return i.p(this.noc);
        }
        if (this.nsI == 6) {
            return i.q(this.noc);
        }
        return this.nsG ? i.n(this.noc) : i.m(this.noc);
    }

    public final String getPath() {
        if (!bi.oW(this.nkR)) {
            return this.nkR;
        }
        if (bi.oW(this.nnX)) {
            init();
        }
        return this.nnX;
    }
}
