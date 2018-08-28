package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class m implements e, a {
    private ag handler;
    public Map<String, Set<a>> huO = new HashMap();
    public HashMap<String, String> huP = new HashMap();
    private String huQ;
    public v huR;

    public m() {
        g.Eh().dpP.a(563, (e) this);
        this.handler = new ag(Looper.getMainLooper());
    }

    public final void a(String str, a aVar) {
        synchronized (this.huO) {
            try {
                if (this.huO.get(str) != null) {
                    ((Set) this.huO.get(str)).remove(aVar);
                }
            } catch (Exception e) {
            }
        }
        synchronized (this.huP) {
            this.huP.remove(str);
        }
    }

    private void a(String str, boolean z, ArrayList<la> arrayList) {
        this.handler.post(new 1(this, str, z, arrayList));
    }

    public final boolean a(String str, String str2, a aVar) {
        int i;
        x.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", str, str2);
        this.huQ = str;
        synchronized (this.huO) {
            if (!this.huO.containsKey(str)) {
                this.huO.put(str, new HashSet());
            }
            if (!((Set) this.huO.get(str)).contains(aVar)) {
                ((Set) this.huO.get(str)).add(aVar);
            }
        }
        synchronized (this.huP) {
            if (!TextUtils.isEmpty(str2)) {
                this.huP.put(str, str2);
            }
        }
        c OB = c.OB();
        if (OB == null) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            i = 0;
        } else {
            OB.b(this);
            i = 1;
        }
        if (i == 0) {
            x.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
            return false;
        }
        if (this.huR != null) {
            g.Eh().dpP.c(this.huR);
        }
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.huR = null;
        String str2 = ((v) lVar).hxc;
        x.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", str2, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ArrayList arrayList = ((v) lVar).hxd;
            String str3 = "MicroMsg.CardShopLBSManager";
            String str4 = "onSceneEnd, respShopList size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            x.d(str3, str4, objArr);
            a(str2, true, arrayList);
            return;
        }
        x.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
        a(str2, false, null);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        Set set;
        c OB = c.OB();
        if (OB != null) {
            OB.c(this);
        }
        x.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2));
        synchronized (this.huO) {
            set = (Set) this.huO.get(this.huQ);
        }
        if (set == null || set.size() == 0) {
            x.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
            return false;
        }
        String str;
        synchronized (this.huP) {
            str = (String) this.huP.get(this.huQ);
        }
        l vVar = new v(this.huQ, f, f2, str);
        if (g.Eh().dpP.a(vVar, 0)) {
            this.huR = vVar;
        } else {
            x.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
            a(this.huQ, false, null);
        }
        return true;
    }
}
