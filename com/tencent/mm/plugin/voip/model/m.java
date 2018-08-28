package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;

public final class m {
    long beginTime = 0;
    public int oKQ;
    public int oKR;
    public int oKS;
    public int oKT;
    byte oKU;
    byte oKV;
    byte oKW;
    byte oKX;
    byte oKY;
    byte oKZ;
    long oLA;
    byte oLa;
    int oLb;
    public int oLc;
    public int oLd;
    public int oLe;
    public int oLf;
    public int oLg;
    public int oLh;
    public int oLi;
    int oLj;
    int oLk;
    int oLl;
    int oLm;
    int oLn;
    int oLo;
    int oLp;
    int oLq;
    public long oLr;
    long oLs;
    long oLt;
    long oLu;
    long oLv;
    public long oLw;
    long oLx;
    long oLy;
    long oLz;

    public m() {
        reset();
        bKg();
    }

    public final void bKf() {
        if (this.oLw == 0) {
            this.oLm = 0;
        } else {
            this.oLm = (int) (System.currentTimeMillis() - this.oLw);
        }
        a.eU("MicroMsg.VoipDailReport", "devin:answerInvite current:" + System.currentTimeMillis());
        a.eU("MicroMsg.VoipDailReport", "devin:answerInvite:" + this.oLm);
    }

    public final void reset() {
        this.beginTime = 0;
        this.oKQ = 0;
        this.oKR = 0;
        this.oKS = 0;
        this.oKT = 0;
        this.oKU = (byte) 0;
        this.oKV = (byte) 0;
        this.oKW = (byte) 0;
        this.oKX = (byte) 0;
        this.oKY = (byte) 0;
        this.oKZ = (byte) 0;
        this.oLa = (byte) 0;
        this.oLb = 0;
    }

    public final void bKg() {
        this.oLr = 0;
        this.oLv = 0;
        this.oLw = 0;
        this.oLx = 0;
        this.oLy = 0;
        this.oLz = 0;
        this.oLs = 0;
        this.oLt = 0;
        this.oLu = 0;
        this.oLc = 0;
        this.oLd = 0;
        this.oLe = 0;
        this.oLf = 0;
        this.oLg = 0;
        this.oLh = 0;
        this.oLi = 0;
        this.oLj = 0;
        this.oLk = 0;
        this.oLl = 0;
        this.oLm = 0;
        this.oLn = 0;
        this.oLo = 0;
        this.oLp = 0;
        this.oLq = 0;
    }

    public final String bKh() {
        return "," + this.oLa;
    }
}
