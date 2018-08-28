package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s {
    private List<WeakReference<a>> htB = new ArrayList();
    public ArrayList<Long> lHE = new ArrayList();
    public b lKw = null;
    private HashSet<String> lKx = new HashSet();

    public s() {
        Object blH = a.blH();
        if (!TextUtils.isEmpty(blH)) {
            Map z = bl.z(blH, "sysmsg");
            if (z != null) {
                int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(G(z));
                }
            }
        }
        this.lHE.clear();
    }

    public final boolean el(long j) {
        if (this.lHE == null || this.lHE.size() == 0) {
            x.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
            return false;
        }
        for (int i = 0; i < this.lHE.size(); i++) {
            if (((Long) this.lHE.get(i)).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private void b(c cVar) {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null && aVar.a(cVar)) {
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.htB == null) {
            this.htB = new ArrayList();
        }
        if (aVar != null) {
            this.htB.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.htB != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.htB.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void IV(String str) {
        a.Ji("");
        a.Jk("");
        a.Jj("");
        Map z = bl.z(str, "sysmsg");
        if (z != null) {
            int i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            int i2 = bi.getInt((String) z.get(".sysmsg.paymsg.pay_cmd"), -1);
            String str2 = (String) z.get(".sysmsg.paymsg.req_key");
            a.Ji((String) z.get(".sysmsg.paymsg.ack_key"));
            a.ur(i);
            a.Jj(str2);
            int i3 = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            x.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + i3);
            x.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[]{Integer.valueOf(i3), str});
            c fVar;
            if (i3 >= 0 && i3 == 4) {
                b(G(z));
                a.IZ(str);
            } else if (i3 >= 0 && i3 == 5) {
                boolean z2;
                if (i2 == 1) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                    k.bkO();
                    k.bkR().df(4, 4);
                    z2 = false;
                } else {
                    z2 = true;
                }
                c eVar = new e(this);
                eVar.lKD = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                eVar.lKE = (String) z.get(".sysmsg.paymsg.cftretcode");
                eVar.lKF = (String) z.get(".sysmsg.paymsg.cftretmsg");
                eVar.lKG = (String) z.get(".sysmsg.paymsg.wxretcode");
                eVar.lKH = (String) z.get(".sysmsg.paymsg.wxretmsg");
                eVar.lKI = (String) z.get(".sysmsg.paymsg.error_detail_url");
                eVar.lKJ = true;
                eVar.lKJ = z2;
                b(eVar);
            } else if (i3 >= 0 && i3 == 6) {
                str2 = (String) z.get(".sysmsg.paymsg.transid");
                x.i("helios", "MSG_TYPE_ORDER trasid=" + str2);
                if (!bi.oW(str2)) {
                    g.Ek();
                    g.Ei().DT().a(aa.a.sUp, Boolean.valueOf(true));
                }
                x.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[]{str});
                fVar = new f(this);
                fVar.lKD = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.lKK = (String) z.get(".sysmsg.paymsg.transid");
                fVar.lKL = a.H(z);
                if (fVar.lKL.ppf.size() > 0) {
                    a.Jk(((Commodity) fVar.lKL.ppf.get(0)).bOe);
                }
                if (z.containsKey(".sysmsg.paymsg.real_name_info")) {
                    fVar.ceB = new h(this, z);
                }
                b(fVar);
            } else if (i3 >= 0 && i3 == 7) {
                o.bOW().aMk();
            } else if (i3 >= 0 && i3 == 8) {
                fVar = new g(this);
                fVar.lKD = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.lKM = (String) z.get(".sysmsg.paymsg.good_name");
                fVar.lKN = (String) z.get(".sysmsg.paymsg.total_fee");
                fVar.bQa = (String) z.get(".sysmsg.paymsg.req_key");
                fVar.id = (String) z.get(".sysmsg.paymsg.id");
                str2 = (String) z.get(".sysmsg.paymsg.confirm_type");
                x.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + fVar.lKO);
                if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
                    fVar.lKO = 0;
                } else {
                    fVar.lKO = 1;
                }
                b(fVar);
            } else if (i3 >= 0 && i3 == 10) {
                k.bkO();
                k.bkR().df(4, 4);
            } else if (i3 >= 0 && i3 == 20) {
                tb tbVar = new tb();
                tbVar.ceA.ceB = new h(this, z);
                com.tencent.mm.sdk.b.a.sFg.m(tbVar);
            } else if (i3 >= 0 && i3 == 23) {
                fVar = new d(this);
                fVar.lKD = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.bQa = (String) z.get(".sysmsg.paymsg.req_key");
                synchronized (this.lKx) {
                    if (this.lKx.contains(fVar.bQa)) {
                        x.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[]{fVar.bQa});
                        return;
                    }
                    this.lKx.add(fVar.bQa);
                    b(fVar);
                }
            } else if (i3 >= 0 && i3 == 24) {
                fVar = new d(this);
                fVar.lKD = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.bQa = (String) z.get(".sysmsg.paymsg.req_key");
                b(fVar);
            }
        }
    }

    private b G(Map<String, String> map) {
        if (this.lKw == null) {
            this.lKw = new b(this);
        }
        this.lKw.lKD = bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.lKw.lKA = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.lKw.lKB = (String) map.get(".sysmsg.paymsg.freezetype");
        this.lKw.lKC = (String) map.get(".sysmsg.paymsg.freezemsg");
        return this.lKw;
    }

    public final void IW(String str) {
        int i = bi.getInt((String) bl.z(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.lIR));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.lIQ));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.lIS));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.lIP));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.lIM));
        if (hashSet.contains(Integer.valueOf(i))) {
            g.Em().H(new 1(this));
        }
    }
}
