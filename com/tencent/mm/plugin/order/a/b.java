package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b implements ar {
    private static HashMap<Integer, d> cVM;
    private a hTD = new 3(this);
    private List<WeakReference<Object>> htB = new ArrayList();
    com.tencent.mm.plugin.order.model.b lNk = null;
    private com.tencent.mm.plugin.order.b.b lNl;
    private c lNm = null;
    private a lNn = new 2(this);
    private ag mHandler = new ag(Looper.getMainLooper());

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new 1());
        com.tencent.mm.wallet_core.a.i("ShowOrdersInfoProcess", a.class);
    }

    public static b bmn() {
        return (b) p.v(b.class);
    }

    public final void bmo() {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void auM() {
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        this.lNk = null;
        this.lNm = null;
    }

    public final void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b bmp() {
        g.Eg().Ds();
        if (bmn().lNl == null) {
            b bmn = bmn();
            g.Ek();
            bmn.lNl = new com.tencent.mm.plugin.order.b.b(g.Ei().dqq);
        }
        return bmn().lNl;
    }

    public static c bmq() {
        g.Eg().Ds();
        if (bmn().lNm == null) {
            bmn().lNm = new c();
        }
        return bmn().lNm;
    }

    public static String bav() {
        if (g.Eg().Dx()) {
            return com.tencent.mm.plugin.p.c.Gb() + "order";
        }
        return "";
    }
}
