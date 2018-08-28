package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class i$5 implements l {
    final /* synthetic */ i pPx;

    i$5(i iVar) {
        this.pPx = iVar;
    }

    public final void b(j jVar) {
        switch (jVar.bjW) {
            case -3:
            case -2:
            case -1:
                h.Bh(((Integer) i.e(this.pPx).jrq).intValue()).RH("");
                return;
            case 0:
                if (jVar.jsx == null || jVar.jsx.size() == 0) {
                    x.i("MicroMsg.FTS.WebSearchLogic", "local contact search size 0");
                    h.Bh(((Integer) i.e(this.pPx).jrq).intValue()).RH("");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    for (com.tencent.mm.plugin.fts.a.a.l lVar : jVar.jsx) {
                        if (lVar.type == 131072) {
                            jSONArray2.put(i.a(lVar, jVar.jrx));
                        }
                    }
                    jSONObject2.put("items", jSONArray2);
                    jSONObject2.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, ad.getContext().getString(R.l.fts_on_suggest_sns_title));
                    jSONObject2.put("count", jSONArray2.length());
                    jSONObject2.put("type", 3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put("ret", 0);
                    h.Bh(((Integer) i.e(this.pPx).jrq).intValue()).RH(jSONObject.toString());
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "onSearchDone", new Object[0]);
                    return;
                }
            default:
                return;
        }
    }
}
