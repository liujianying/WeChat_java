package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends com.tencent.mm.ab.l implements k {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private b diG;
    private e diJ;
    public lt hUl;

    public l() {
        a aVar = new a();
        aVar.dIG = new ls();
        aVar.dIH = new lt();
        aVar.dIF = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1588;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hUl = (lt) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        x.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[]{this.hUl.url, this.hUl.plj, this.hUl.rpP});
        if (!bi.oW(this.hUl.url)) {
            g.Ek();
            g.Ei().DT().a(aa.a.sYo, this.hUl.url);
        }
        if (!bi.oW(this.hUl.plj)) {
            g.Ek();
            g.Ei().DT().a(aa.a.sYp, this.hUl.plj);
        }
        g.Ek();
        g.Ei().DT().a(aa.a.sYr, this.hUl.rpP);
        JSONObject a = a(this.hUl.rpO);
        JSONArray aJ = aJ(this.hUl.rpN);
        if (a != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[]{a.toString()});
            g.Ek();
            g.Ei().DT().a(aa.a.sYq, a.toString());
        }
        if (aJ != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[]{aJ.toString()});
            g.Ek();
            g.Ei().DT().a(aa.a.sYs, aJ.toString());
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    private static JSONArray aJ(List<atm> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = a((atm) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                return null;
            }
        }
        return jSONArray;
    }

    private static JSONObject a(atm atm) {
        int i = (atm == null || bi.oW(atm.bSc)) ? 0 : 1;
        if (i == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadSettingTable$Columns.TYPE, atm.type);
            jSONObject.put("wording", atm.bSc);
            jSONObject.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, atm.url);
            jSONObject.put("waapp_username", atm.rWQ);
            jSONObject.put("waapp_path", atm.rWR);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            return null;
        }
    }
}
