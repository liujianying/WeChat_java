package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.cay;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbq;
import com.tencent.mm.protocal.d;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private int fsA;
    cbq fsB;
    i fsC;
    AtomicInteger fsD;
    long fsE;
    long fsF;
    long fsG;
    long fsH;
    AtomicInteger fsI;
    private boolean fsJ;
    private boolean fsK;
    final HashMap<String, Method> fsL;
    final HashMap<String, cbl> fsM;
    LinkedList<Pair<String, ValueCallback<String>>> fsN;
    final LinkedList<k> fsO;
    final Map<String, g> fsP;
    final LinkedList<cbe> fsQ;
    final HashMap<Integer, a> fsR;
    int fsS;
    long fsT;
    l fsw;
    final cay fsx;
    private String fsy;
    private int fsz;
    final Object mLock;
    private int mStatus;

    public h() {
        this.fsz = 0;
        this.fsA = 0;
        this.mStatus = 0;
        this.fsD = new AtomicInteger(0);
        this.fsE = 0;
        this.fsF = 0;
        this.fsH = System.currentTimeMillis();
        this.fsI = new AtomicInteger(0);
        this.fsL = new HashMap();
        this.fsM = new HashMap();
        this.fsN = new LinkedList();
        this.fsO = new LinkedList();
        this.fsP = new HashMap();
        this.fsQ = new LinkedList();
        this.fsR = new HashMap();
        this.mLock = new Object();
        this.fsS = 0;
        this.fsT = 0;
        this.fsx = new cay();
        this.fsx.rlO = d.qVN;
    }

    public final synchronized String aeu() {
        return this.fsy;
    }

    public final synchronized void sk(String str) {
        this.fsy = str;
    }

    public final synchronized int aev() {
        return this.fsz;
    }

    public final synchronized void jX(int i) {
        this.fsz = i;
    }

    public final synchronized int aew() {
        return this.fsA;
    }

    public final synchronized void jY(int i) {
        if (this.fsA < i) {
            this.fsA = i;
        }
    }

    public final synchronized void bE(int i, int i2) {
        if (this.fsA >= i && this.fsA <= i2) {
            this.fsA = i2;
        }
    }

    public final synchronized void setStatus(int i) {
        this.mStatus = i;
    }

    public final synchronized int getStatus() {
        return this.mStatus;
    }

    public final synchronized boolean isBusy() {
        return this.fsJ;
    }

    public final synchronized void cz(boolean z) {
        this.fsJ = z;
    }

    public final synchronized boolean hv() {
        return getStatus() == 3;
    }

    public final synchronized boolean aex() {
        return this.fsK;
    }

    public final synchronized void cA(boolean z) {
        this.fsK = z;
    }

    public final boolean aey() {
        return getStatus() == 4;
    }

    public final boolean aez() {
        return this.fsC.fsY == 3;
    }
}
