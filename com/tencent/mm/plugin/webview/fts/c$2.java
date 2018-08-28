package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.g.a.qb;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$2 extends c<qb> {
    final /* synthetic */ c pOu;

    c$2(c cVar) {
        this.pOu = cVar;
        this.sFo = qb.class.getName().hashCode();
    }

    private boolean a(qb qbVar) {
        if ((qbVar instanceof qb) && qbVar.caJ.bIH == 2) {
            x.i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", new Object[]{qbVar.caJ.mediaId});
            if (this.pOu.pOo.containsKey(qbVar.caJ.mediaId)) {
                synchronized (this.pOu.pOo) {
                    int intValue = ((Integer) this.pOu.pOr.get(qbVar.caJ.mediaId)).intValue();
                    HashSet hashSet = (HashSet) this.pOu.pOo.get(qbVar.caJ.mediaId);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String str2 = "weixin://fts/sns?path=" + qbVar.caJ.path;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            jSONObject.put("src", str2);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.Bh(intValue).aV(0, jSONArray.toString());
                    this.pOu.pOo.remove(qbVar.caJ.mediaId);
                    this.pOu.pOr.remove(qbVar.caJ.mediaId);
                }
            }
        }
        return false;
    }
}
