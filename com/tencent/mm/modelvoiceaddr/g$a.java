package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public class g$a {
    public String data;
    public String eqP;
    public boolean eqQ;
    public boolean eqR;
    public int eqS;
    public int eqT;
    public int eqU;
    public boolean eqV;
    final /* synthetic */ g eqW;

    public g$a(g gVar) {
        this.eqW = gVar;
        long nextInt = 4294967295L & ((long) new Random(System.currentTimeMillis()).nextInt());
        long currentTimeMillis = ((4294967295L & System.currentTimeMillis()) << 32) | nextInt;
        if (currentTimeMillis < 0) {
            currentTimeMillis = Math.abs(currentTimeMillis);
        }
        x.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[]{Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(r2), Long.toBinaryString(r2), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), this.eqW.eqL, this.eqW.eqL + String.valueOf(currentTimeMillis)});
        this.eqP = r6;
        this.eqQ = false;
        this.eqR = false;
        this.eqS = Integer.MAX_VALUE;
        this.eqT = 0;
        this.eqU = -1;
        this.data = null;
        this.eqV = false;
    }
}
