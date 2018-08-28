package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.g.a.ft;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$1 extends c<ft> {
    final /* synthetic */ c pOu;

    c$1(c cVar) {
        this.pOu = cVar;
        this.sFo = ft.class.getName().hashCode();
    }

    private boolean a(ft ftVar) {
        if (ftVar.bOq.bIH == 2) {
            x.i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[]{ftVar.bOq.bKg});
            if (this.pOu.pOp.containsKey(ftVar.bOq.bKg)) {
                synchronized (this.pOu.pOp) {
                    int intValue = ((Integer) this.pOu.pOs.get(ftVar.bOq.bKg)).intValue();
                    HashSet hashSet = (HashSet) this.pOu.pOp.get(ftVar.bOq.bKg);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String str2 = "weixin://fts/emoji?path=" + ftVar.bOr.path;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            jSONObject.put("src", str2);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.Bh(intValue).aV(0, jSONArray.toString());
                    this.pOu.pOp.remove(ftVar.bOq.bKg);
                    this.pOu.pOs.remove(ftVar.bOq.bKg);
                }
            }
        }
        return false;
    }
}
