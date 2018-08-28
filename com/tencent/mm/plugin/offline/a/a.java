package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends m {
    private final b diG;
    private e diJ;
    private ArrayList<String> fXG;
    private String lJE;
    private String lJF;

    public final int getType() {
        return 606;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        afn afn = (afn) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(afn.rJv)) {
                    JSONObject jSONObject = new JSONObject(afn.rJv);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.lJF = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.c.a.uo(optInt);
                    com.tencent.mm.plugin.offline.c.a.up(optInt2);
                    x.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(afn.rJw)) {
                    Q(new JSONObject(afn.rJw));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ad.getContext().getString(i.wallet_data_err);
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    private void Q(JSONObject jSONObject) {
        this.lJE = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.fXG.add((String) jSONArray.get(i));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
        }
    }
}
