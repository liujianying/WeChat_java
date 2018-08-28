package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.protocal.c.bxd;
import java.util.LinkedList;

public abstract class a extends l {
    public String bWs;
    public int fdx;
    public int pKL;
    public String pKM;
    public Bundle pKN;
    public int tH;

    public abstract String JS();

    public abstract int JT();

    public final boolean bSI() {
        return this.tH == 0;
    }

    public void ak(LinkedList<bxd> linkedList) {
    }
}
