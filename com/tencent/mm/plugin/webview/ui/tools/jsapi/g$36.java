package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

class g$36 extends c<dm> {
    final /* synthetic */ g qiK;

    g$36(g gVar) {
        this.qiK = gVar;
        this.sFo = dm.class.getName().hashCode();
    }

    private boolean a(dm dmVar) {
        if (dmVar != null && (dmVar instanceof dm)) {
            System.currentTimeMillis();
            g.n(this.qiK);
            g.a(this.qiK, System.currentTimeMillis());
            String str = dmVar.bLn.bLl;
            int i = dmVar.bLn.bLo;
            int i2 = dmVar.bLn.bLp & 65535;
            double d = dmVar.bLn.bLr;
            double d2 = dmVar.bLn.bLq;
            x.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[]{str + "," + i + "," + i2 + "," + d});
            String str2 = str + "," + i + "," + i2;
            boolean z = false;
            List<anf> list;
            Iterator it;
            anh anh;
            if (g.o(this.qiK).containsKey(str2)) {
                list = (List) g.p(this.qiK).get(str + "," + i);
                if (list != null) {
                    for (anf anf : list) {
                        if (anf != null && anf.rPU != null && !anf.rPU.isEmpty()) {
                            it = anf.rPU.iterator();
                            while (it.hasNext()) {
                                anh = (anh) it.next();
                                if (i2 >= anh.rPV && i2 <= anh.rPW) {
                                    z = true;
                                    continue;
                                    break;
                                }
                            }
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            } else {
                ane ane = new ane();
                ane.fMk = str;
                ane.major = i;
                ane.minor = i2;
                g.o(this.qiK).put(str2, ane);
                if (g.p(this.qiK).containsKey(str + "," + i)) {
                    list = (List) g.p(this.qiK).get(str + "," + i);
                    if (list != null) {
                        for (anf anf2 : list) {
                            boolean z2;
                            if (!(anf2 == null || anf2.rPU == null || anf2.rPU.isEmpty())) {
                                Iterator it2 = anf2.rPU.iterator();
                                while (it2.hasNext()) {
                                    anh = (anh) it2.next();
                                    if (i2 >= anh.rPV && i2 <= anh.rPW) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            z2 = z;
                            if (z2) {
                                z = z2;
                                break;
                            }
                            z = z2;
                        }
                    }
                }
                if (!z) {
                    g.q(this.qiK).add(ane);
                    String str3 = null;
                    if (!(g.k(this.qiK) == null || g.k(this.qiK).mcy == null)) {
                        Object obj = g.k(this.qiK).mcy.get("url");
                        str3 = bi.oV(g.r(this.qiK).RE(obj != null ? obj.toString() : ""));
                    }
                    if (!g.s(this.qiK)) {
                        g.a(this.qiK, true);
                        i iVar = new i(g.q(this.qiK), bi.oV(str3));
                        g.q(this.qiK).clear();
                        au.DF().a(1704, new 1(this, iVar));
                        au.DF().a(iVar, 0);
                    }
                }
            }
            x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[]{String.valueOf(z) + "," + str2});
            try {
                if (g.qib != -1) {
                    e eVar = g.a(this.qiK, g.qib).pRY;
                    if (eVar != null && z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uuid", str);
                        bundle.putInt("major", i);
                        bundle.putInt("minor", i2);
                        bundle.putDouble("accuracy", d2);
                        bundle.putDouble("rssi", d);
                        bundle.putFloat("heading", g.t(this.qiK));
                        eVar.c(40002, bundle);
                    }
                }
            } catch (RemoteException e) {
                x.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[]{g.o(this.qiK).get(str2), Integer.valueOf(g.o(this.qiK).size())});
        }
        return false;
    }
}
