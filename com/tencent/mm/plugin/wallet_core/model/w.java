package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";
    public List<a> list = new LinkedList();

    public w() {
        g.Ek();
        String str = (String) g.Ei().DT().get(a.sXK, "");
        this.list.clear();
        if (!bi.oW(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.pqX = jSONObject.optInt("paymenu_jump_type");
                    aVar.pqY = jSONObject.optString("paymenu_jump_url");
                    aVar.pqZ = jSONObject.optString("paymenu_path");
                    aVar.pra = jSONObject.optString("paymenu_title");
                    aVar.prb = jSONObject.optString("paymenu_username");
                    this.list.add(aVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void OY(String str) {
        g.Ek();
        g.Ei().DT().a(a.sXK, str);
    }
}
