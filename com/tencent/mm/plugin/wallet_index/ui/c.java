package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.ann;
import java.util.ArrayList;
import java.util.List;

public final class c {
    String iiv = null;
    int lQa;
    public int mCount = 1;
    public String pCK = null;
    public String pCL = null;
    public anm pCP;
    public ann pCQ;
    public String pDh = null;
    public ArrayList<String> pDk = new ArrayList();
    public ArrayList<String> pDl = new ArrayList();
    public String pDm = null;
    public int pDn = 0;
    List<String> pDo = new ArrayList();
    boolean pDp = false;
    public String pDq;
    public String pDr;

    public final boolean bRe() {
        return this.lQa == 2;
    }

    public final l a(com.tencent.mm.plugin.wallet_index.b.a.c cVar, boolean z) {
        int i = z ? 2 : 1;
        if (!this.pDp) {
            return new com.tencent.mm.wallet_core.c.l(cVar.iiv, i, this.lQa, this.mCount, cVar.pCI, cVar.pCJ, cVar.ogj, cVar.pCK, cVar.pCL);
        }
        if (!bRe()) {
            this.pCP.rQk = cVar.ogj;
            this.pCP.rQh = cVar.pCI;
            this.pCP.lPj = cVar.pCL;
            this.pCP.rFe = cVar.pCK;
            this.pCP.lRl = cVar.iiv;
            this.pCP.rQj = cVar.pCJ;
        }
        return new g(this.lQa, i, cVar.iiv, this.pCQ, this.pCP);
    }
}
