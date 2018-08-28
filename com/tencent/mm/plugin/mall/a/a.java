package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends l implements k {
    private b diG;
    private e diJ;
    private String kXX;
    public ArrayList<MallFunction> kXY;
    public ArrayList<MallNews> kXZ;
    public ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> kYa;
    public SparseArray<String> kYb;
    public int kYc;

    public a(int i, String str) {
        this(i, str, null, null);
    }

    public a(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}));
    }

    private a(int i, String str, String str2, String str3) {
        List bPL;
        this.kXY = null;
        this.kXZ = null;
        this.kYa = null;
        this.kYb = null;
        this.kYc = 0;
        this.kYc = i;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aga();
        aVar.dIH = new agb();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.dIF = 495;
        aVar.dII = TbsListener$ErrorCode.HOST_CONTEXT_IS_NULL;
        aVar.dIJ = 1000000227;
        this.diG = aVar.KT();
        aga aga = (aga) this.diG.dID.dIL;
        aga.rJM = str;
        LinkedList linkedList = new LinkedList();
        if (bi.oW(str2)) {
            bPL = c.bPK().bPL();
        } else {
            List list;
            MallNews mallNews = (MallNews) c.bPK().psm.get(str2);
            if (mallNews == null || bi.oW(mallNews.bLe)) {
                list = null;
            } else {
                bPL = new ArrayList();
                bPL.add(mallNews.bLe);
                list = bPL;
            }
            bPL = list;
        }
        if (bPL != null && bPL.size() > 0) {
            String str4;
            String str5 = "";
            Iterator it = bPL.iterator();
            while (true) {
                str4 = str5;
                if (!it.hasNext()) {
                    break;
                }
                str5 = (String) it.next();
                bhz bhz = new bhz();
                bhz.VO(str5);
                linkedList.add(bhz);
                str5 = str4 + "; + " + str5;
            }
            x.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + str4);
        }
        aga.rJO = linkedList;
        aga.rJN = linkedList.size();
        if (bi.oW(str3)) {
            aga.jTB = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            aga.jTB = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        this.kXX = str2;
        x.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + aga.jTB);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            agb agb = (agb) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.kYc + " " + agb.rJP);
            try {
                if (!bi.oW(agb.rJP)) {
                    JSONObject jSONObject = new JSONObject(agb.rJP);
                    String optString = jSONObject.optString("pay_func_list");
                    this.kXY = com.tencent.mm.plugin.wallet_core.model.mall.b.x(new JSONArray(optString));
                    o.bPb().b(this.kYc, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"));
                    d.bbJ().kYg.clear();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 495;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
