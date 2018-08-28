package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.a.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.protocal.c.cdb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

class d$g {
    public String bPL;
    public long dkB;
    public long pOP;
    public int scene;

    public d$g() {
        this.scene = 0;
        this.bPL = "";
        this.dkB = 0;
        this.pOP = 0;
    }

    public d$g(cdb cdb) {
        this.scene = 0;
        this.bPL = "";
        this.dkB = 0;
        this.pOP = 0;
        this.scene = HardCoderJNI.SCENE_RECEIVE_MSG;
        this.bPL = cdb.bPL;
        this.dkB = (long) cdb.djl;
        this.pOP = System.currentTimeMillis() / 1000;
    }

    public static d$g bTI() {
        au.HU();
        File file = new File(c.Ge(), Ae(HardCoderJNI.SCENE_RECEIVE_MSG));
        byte[] e = e.e(file.getAbsolutePath(), 0, (int) file.length());
        try {
            ask ask = new ask();
            ask.aG(e);
            d$g d_g = new d$g();
            try {
                d_g.scene = ask.otY;
                d_g.bPL = ask.rjK;
                d_g.dkB = ask.rUG;
                d_g.pOP = ask.rUF;
                return d_g;
            } catch (Exception e2) {
                return d_g;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    static String Ae(int i) {
        return "SearchGuide_" + i + "-" + w.fD(ad.getContext());
    }

    public final boolean bTJ() {
        return this.pOP + this.dkB <= System.currentTimeMillis() / 1000;
    }
}
