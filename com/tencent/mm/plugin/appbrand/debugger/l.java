package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.mm.a.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.protocal.c.cbb;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.protocal.c.cbh;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbn;
import com.tencent.mm.protocal.c.cbo;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.protocal.c.cca;
import com.tencent.mm.protocal.c.ccb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class l {
    Timer bno;
    d fdP;
    h ftb;
    o fte;
    q ftg;
    private aa<Integer, Long> ftt = new aa(100);
    boolean ftu = false;
    private long ftv;
    LinkedList<k> ftw = new LinkedList();
    private final int ftx = Downloads.MIN_RETYR_AFTER;
    private int fty = 0;
    private long ftz = 0;
    Context mContext;

    public final void D(int i, String str) {
        cbc cbc = new cbc();
        cbc.sxn = i;
        cbc.bPu = str;
        a(p.a(cbc, this.ftb, "callInterfaceResult"));
    }

    private synchronized void aeB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ftb.fsQ.size()) {
                int aev = i2 == 0 ? this.ftb.aev() : ((cbe) this.ftb.fsQ.get(i2 - 1)).egS;
                i = ((cbe) this.ftb.fsQ.get(i2)).egS;
                if (aev - i != 1) {
                    bF(aev + 1, i - 1);
                }
                i = i2 + 1;
            }
        }
    }

    public final void bF(int i, int i2) {
        x.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i <= i2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.ftt.get(Integer.valueOf(i)) == null || currentTimeMillis - ((Long) this.ftt.get(Integer.valueOf(i))).longValue() >= 3000) {
                this.ftt.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                ccb ccb = new ccb();
                ccb.sxM = this.ftb.fsx;
                ccb.sxZ = i;
                ccb.sya = i2;
                this.fte.a(p.a(1005, ccb));
                this.ftb.fsH = System.currentTimeMillis();
                return;
            }
            x.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
        }
    }

    final void r(LinkedList<cbe> linkedList) {
        if (bi.cX(linkedList)) {
            x.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            return;
        }
        Iterator it = s(linkedList).iterator();
        while (it.hasNext()) {
            byte[] x;
            cbe cbe = (cbe) it.next();
            if (p.jZ(cbe.sjO)) {
                x = q.x(cbe.rwb.lR);
            } else {
                x = cbe.rwb.lR;
            }
            String str = cbe.category;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1680221061:
                    if (str.equals("callInterface")) {
                        obj = null;
                        break;
                    }
                    break;
                case -217209181:
                    if (str.equals("evaluateJavascriptResult")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3441010:
                    if (str.equals("ping")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 95766211:
                    if (str.equals("domOp")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1319027697:
                    if (str.equals("breakpoint")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            int i;
            switch (obj) {
                case null:
                    cbb cbb = (cbb) new cbb().aG(x);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[]{cbb.sxl, Integer.valueOf(cbb.sxn)});
                    String str2 = cbb.sxl;
                    LinkedList linkedList2 = cbb.sxm;
                    cbl cbl = (cbl) this.ftb.fsM.get(str2);
                    if (cbl != null) {
                        LinkedList linkedList3 = cbl.sxm;
                        if (linkedList2.size() >= linkedList3.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= linkedList3.size()) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Method method = (Method) this.ftb.fsL.get(str2);
                                    if (method == null) {
                                        x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                                        break;
                                    }
                                    Object invoke = linkedList4.size() == 0 ? method.invoke(this.fdP, new Object[0]) : linkedList4.size() == 1 ? method.invoke(this.fdP, new Object[]{linkedList4.get(0)}) : linkedList4.size() == 2 ? method.invoke(this.fdP, new Object[]{linkedList4.get(0), linkedList4.get(1)}) : linkedList4.size() == 3 ? method.invoke(this.fdP, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2)}) : linkedList4.size() == 4 ? method.invoke(this.fdP, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3)}) : linkedList4.size() == 5 ? method.invoke(this.fdP, new Object[]{linkedList4.get(0), linkedList4.get(1), linkedList4.get(2), linkedList4.get(3), linkedList4.get(4)}) : null;
                                    String valueOf = String.valueOf(invoke);
                                    if (!bi.oW(valueOf)) {
                                        D(cbb.sxn, valueOf);
                                    }
                                    m.a(str2, linkedList2, currentTimeMillis, cbb.boi(), valueOf == null ? 0 : valueOf.length());
                                    break;
                                }
                                if ("Number".equals(linkedList3.get(i2))) {
                                    linkedList4.add(Integer.valueOf((String) linkedList2.get(i2)));
                                } else if ("Boolean".equals(linkedList3.get(i2))) {
                                    linkedList4.add(Boolean.valueOf((String) linkedList2.get(i2)));
                                } else {
                                    linkedList4.add(linkedList2.get(i2));
                                }
                                i = i2 + 1;
                            }
                        } else {
                            x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
                            break;
                        }
                    }
                    x.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
                    break;
                case 1:
                    cbj cbj = (cbj) new cbj().aG(x);
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[]{Integer.valueOf(cbj.sxA)});
                    i = cbj.sxA;
                    String str3 = cbj.bPu;
                    a aVar = (a) this.ftb.fsR.remove(Integer.valueOf(i));
                    if (aVar == null) {
                        break;
                    }
                    ValueCallback valueCallback = aVar.fsu;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(str3);
                    }
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i + " ret: " + str3);
                    m.a(aVar, cbj.boi());
                    break;
                case 2:
                    cbn cbn = (cbn) new cbn().aG(x);
                    cbo cbo = new cbo();
                    cbo.sxD = cbn.sxD;
                    cbo.sxE = m.aeH();
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[]{Integer.valueOf(cbo.sxE)});
                    a(p.a(cbo, this.ftb, "pong"));
                    break;
                case 3:
                    cba cba = (cba) new cba().aG(x);
                    if (this.ftb.aex() != cba.sxj) {
                        if (cba.sxj) {
                            this.ftb.cA(true);
                        } else {
                            this.ftb.cA(false);
                        }
                        this.ftg.aeJ();
                        this.ftg.aeM();
                        break;
                    }
                    break;
                case 4:
                    cbh cbh = (cbh) new cbh().aG(x);
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
                    if (cbh.sxz == this.ftb.fsw.fdO.fcz.getCurrentPage().getCurrentPageView().hashCode()) {
                        this.ftb.fsw.a("remoteDebugCommand", cbh.sxy, null);
                        break;
                    } else {
                        x.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[]{Integer.valueOf(cbh.sxz), Integer.valueOf(this.ftb.fsw.fdO.fcz.getCurrentPage().getCurrentPageView().hashCode())});
                        break;
                    }
                default:
                    break;
            }
        }
        x.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.ftb.aev())});
        h hVar = this.ftb;
        hVar.fsT += (long) linkedList.size();
        aeB();
    }

    private synchronized LinkedList<cbe> s(LinkedList<cbe> linkedList) {
        LinkedList<cbe> linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList<cbe> linkedList3 = new LinkedList();
            Collection linkedList4 = new LinkedList();
            this.ftb.fsQ.addAll(linkedList);
            Collections.sort(this.ftb.fsQ, new Comparator<cbe>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    cbe cbe = (cbe) obj;
                    cbe cbe2 = (cbe) obj2;
                    return (cbe == null || cbe2 == null) ? 0 : cbe.egS - cbe2.egS;
                }
            });
            int aev = this.ftb.aev();
            Iterator it = this.ftb.fsQ.iterator();
            int i = aev;
            while (it.hasNext()) {
                cbe cbe = (cbe) it.next();
                if (cbe != null) {
                    if (cbe.egS > i) {
                        if (cbe.egS - i != 1) {
                            break;
                        }
                        linkedList3.add(cbe);
                        i = cbe.egS;
                    } else {
                        linkedList4.add(cbe);
                    }
                }
            }
            this.ftb.jX(i);
            this.ftb.fsQ.removeAll(linkedList3);
            this.ftb.fsQ.removeAll(linkedList4);
            x.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[]{Integer.valueOf(linkedList3.size())});
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    public final void a(k kVar) {
        if (!this.ftb.aez()) {
            synchronized (this.ftb.mLock) {
                if (System.currentTimeMillis() - this.ftb.fsE <= 16 || this.ftu) {
                    this.ftw.add(kVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (this.ftb.mLock) {
                        if (!this.ftu || currentTimeMillis - this.ftv >= 32) {
                            this.ftv = currentTimeMillis;
                            if (bi.cX(this.ftw)) {
                            } else {
                                this.ftu = true;
                                int currentTimeMillis2 = (int) (16 - (System.currentTimeMillis() - this.ftb.fsE));
                                if (currentTimeMillis2 <= 0) {
                                    currentTimeMillis2 = 16;
                                }
                                c.Em().h(new Runnable() {
                                    public final void run() {
                                        LinkedList linkedList = new LinkedList();
                                        synchronized (l.this.ftb.mLock) {
                                            linkedList.addAll(l.this.ftw);
                                            l.this.ftw.clear();
                                            l.this.ftu = false;
                                        }
                                        l.this.a(linkedList, true);
                                    }
                                }, (long) currentTimeMillis2);
                            }
                        }
                    }
                    return;
                }
            }
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(kVar);
        a(linkedList, true);
    }

    final synchronized void a(LinkedList<k> linkedList, boolean z) {
        a(linkedList, z, false);
    }

    private synchronized void a(LinkedList<k> linkedList, boolean z, boolean z2) {
        if (!bi.cX(linkedList)) {
            cbr cbr = new cbr();
            cbr.sxM = this.ftb.fsx;
            cbr.sxN = this.ftb.aev();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cbr.sxB.add(((k) it.next()).ftk);
            }
            cbd a = p.a(1006, cbr);
            if (!this.ftb.isBusy() || z2) {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                this.fte.a(a);
            } else {
                x.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                t(linkedList);
            }
            int i = a.nc;
            h hVar = this.ftb;
            hVar.fsE = System.currentTimeMillis();
            hVar.fsG = System.currentTimeMillis();
            if (!this.ftb.isBusy()) {
                this.fty = 0;
            }
            g gVar = new g();
            gVar.size = a.boi();
            gVar.fsv = System.currentTimeMillis();
            this.ftb.fsP.put(a.fMk, gVar);
        }
    }

    private synchronized void t(LinkedList<k> linkedList) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (!bi.cX(linkedList)) {
            this.ftb.fsO.addAll(linkedList);
        }
    }

    public final synchronized void aeC() {
        int i = 0;
        synchronized (this) {
            if (!this.ftb.isBusy()) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                Iterator it = this.ftb.fsO.iterator();
                while (it.hasNext()) {
                    int i2;
                    k kVar = (k) it.next();
                    if (currentTimeMillis - kVar.fsv > 5000) {
                        kVar.fsv = System.currentTimeMillis();
                        linkedList.add(kVar);
                        i2 = kVar.ftl + i;
                        if (((long) i2) >= 65536 || linkedList.size() > 800) {
                            x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                            a(linkedList, false);
                            linkedList.clear();
                            break;
                        }
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
                if (!bi.cX(linkedList)) {
                    x.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[]{Integer.valueOf(linkedList.size())});
                    a(linkedList, false);
                }
            }
        }
    }

    public final synchronized boolean aeD() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ftz < ((long) this.fty)) {
            z = false;
        } else {
            k kVar;
            this.ftz = currentTimeMillis;
            if (this.fty < Downloads.MIN_RETYR_AFTER) {
                this.fty += TbsLog.TBSLOG_CODE_SDK_BASE;
            } else {
                this.fty = 2000;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.ftb.fsO.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (currentTimeMillis - kVar.fsv > 5000) {
                    kVar.fsv = System.currentTimeMillis();
                    linkedList.add(kVar);
                    a(linkedList, false, true);
                    z = true;
                    break;
                }
            }
            if (this.ftb.fsO.size() > 0) {
                kVar = (k) this.ftb.fsO.get(0);
                kVar.fsv = System.currentTimeMillis();
                linkedList.add(kVar);
                a(linkedList, false, true);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void quit() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "quit");
        cca cca = new cca();
        cca.sxM = this.ftb.fsx;
        this.fte.a(p.a(1004, cca));
    }

    public final synchronized void bG(int i, int i2) {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        Collection linkedList = new LinkedList();
        Iterator it = this.ftb.fsO.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.ftk == null) {
                linkedList.add(kVar);
            } else if (kVar.ftk.egS >= i && kVar.ftk.egS <= i2) {
                linkedList.add(kVar);
            }
        }
        this.ftb.fsO.removeAll(linkedList);
    }

    public final synchronized void aeE() {
        x.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        Collection linkedList = new LinkedList();
        Iterator it = this.ftb.fsO.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.ftk == null) {
                linkedList.add(kVar);
            } else if (kVar.ftk.egS <= this.ftb.aew()) {
                linkedList.add(kVar);
            }
        }
        this.ftb.fsO.removeAll(linkedList);
    }

    public final void aeF() {
        x.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.bno != null) {
            this.bno.cancel();
        }
    }
}
