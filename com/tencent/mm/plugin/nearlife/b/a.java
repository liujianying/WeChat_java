package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import java.util.LinkedList;

public final class a {
    public String bHD;
    public int csE;
    public int hcE;
    public String kJF;
    public String kJG;
    public String lCG;
    public float lCH;
    public int lCI;
    public LinkedList<Integer> lCJ = new LinkedList();
    public int lCK;
    public LinkedList<bhz> lCL = new LinkedList();
    public float lCM;
    public String lCN;
    public bhy lCO;
    public aqq lCP;

    public a(String str, aqq aqq) {
        this.kJF = str;
        this.lCG = aqq.lCG;
        this.bHD = aqq.bHD;
        this.lCH = aqq.lCH;
        this.lCI = aqq.lCI;
        this.lCJ = aqq.lCJ;
        this.lCK = aqq.lCK;
        this.lCL = aqq.lCL;
        this.lCM = aqq.lCM;
        this.lCN = aqq.lCN;
        this.hcE = aqq.hcE;
        this.lCO = aqq.lCO;
        this.csE = aqq.rTp;
        this.lCP = aqq;
    }
}
