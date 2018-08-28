package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.ays;

public final class f {
    public double bhC;
    public double bhD;
    public String kJA;
    public String kJB;
    public String kJC;
    public String kJD;
    public Addr kJE;
    public String kJF;
    public String kJG;
    public int kJH = -1;
    public String kJu;
    public String kJv;
    public String kJw;
    public String kJx;
    public String kJy;
    public String kJz;
    public String mName;
    public int type;

    public f(ays ays, String str) {
        this.mName = ays.jPe;
        this.kJu = ays.sbw;
        this.bhD = ays.rji;
        this.bhC = ays.rjj;
        this.kJv = ays.sbx;
        this.kJw = ays.lCN;
        this.kJx = ays.sby;
        this.kJy = ays.eJI;
        this.kJz = ays.eJJ;
        this.kJA = ays.ruY;
        this.kJB = ays.ruZ;
        this.kJC = ays.sbz;
        this.kJF = str;
        this.kJE = new Addr();
        this.kJE.dRH = this.kJu;
        this.kJE.dRJ = this.kJz;
        this.kJE.dRK = this.kJz;
        this.kJE.dRL = this.kJA;
        this.kJE.dRN = this.kJC;
        this.kJE.dRQ = this.mName;
        this.kJE.dRI = this.kJy;
        this.kJE.dRT = (float) ays.rji;
        this.kJE.dRS = (float) ays.rjj;
        this.type = 0;
    }
}
