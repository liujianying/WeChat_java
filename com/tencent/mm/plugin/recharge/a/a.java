package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class a implements ar {
    private List<com.tencent.mm.plugin.recharge.model.a> mos = null;

    public static a bpV() {
        return (a) p.v(a.class);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.mov)) {
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> bpW = bpW();
        for (com.tencent.mm.plugin.recharge.model.a aVar2 : bpW) {
            if (aVar.mov.equals(aVar2.mov)) {
                if (bi.oW(aVar.name)) {
                    aVar.name = aVar2.name;
                }
                bpW.remove(aVar2);
                bpW.add(0, aVar);
                bP(bpW);
                return true;
            }
        }
        bpW.add(0, aVar);
        bP(bpW);
        return true;
    }

    public final void bP(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.mos = list;
        if (list == null || list.size() == 0) {
            this.mos = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.recharge.model.a bpY : this.mos) {
            jSONArray.put(bpY.bpY());
            x.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[]{bpY.name});
        }
        x.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        g.Ei().DT().set(270337, jSONArray.toString());
        g.Ei().DT().lm(true);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> bpW() {
        if (this.mos != null) {
            return this.mos;
        }
        this.mos = new LinkedList();
        String str = (String) g.Ei().DT().get(270337, null);
        if (bi.oW(str)) {
            x.i("MicroMsg.SubCoreRecharge", "empty history");
            return this.mos;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < Math.min(jSONArray.length(), 100); i++) {
                com.tencent.mm.plugin.recharge.model.a Z = com.tencent.mm.plugin.recharge.model.a.Z(jSONArray.getJSONObject(i));
                if (Z != null) {
                    this.mos.add(Z);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreRecharge", e, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < Math.min(split.length, 100); i2++) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        this.mos.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.mos.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
            }
        }
        x.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.mos.size());
        return this.mos;
    }

    public static com.tencent.mm.plugin.recharge.model.a bpX() {
        String str = (String) g.Ei().DT().get(6, null);
        if (bi.oW(str)) {
            return null;
        }
        return new com.tencent.mm.plugin.recharge.model.a(str, ad.getContext().getString(i.wallet_recharge_me), 3);
    }
}
