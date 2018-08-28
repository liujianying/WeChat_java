package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.go;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c$14 extends c<go> {
    final /* synthetic */ c jFM;

    c$14(c cVar) {
        this.jFM = cVar;
        this.sFo = go.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        go goVar = (go) bVar;
        s sVar;
        switch (goVar.bPJ.nc) {
            case 1:
                String str = goVar.bPJ.bPE;
                LinkedList linkedList = new LinkedList();
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = bi.getInt(jSONObject.optString("type"), 0);
                        int i2 = bi.getInt(jSONObject.optString("limit"), 0);
                        long j = bi.getLong(jSONObject.optString("lastLocalId"), -1);
                        int i3 = bi.getInt(jSONObject.optString("isUnread"), -1);
                        if (i2 > 0 && i2 <= 10000 && j >= 0 && i3 >= 0) {
                            Object b = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().b(i, j, i3, i2);
                            if (!bi.cX(b)) {
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = b.iterator();
                                while (it.hasNext()) {
                                    sVar = (s) it.next();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("localId", sVar.field_msgId);
                                    jSONObject2.put("content", sVar.field_rawXML);
                                    jSONArray.put(jSONObject2);
                                }
                                goVar.bPK.bPL = jSONArray.toString();
                                break;
                            }
                        }
                    } catch (JSONException e) {
                        x.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                        break;
                    }
                }
                break;
            case 2:
                com.tencent.mm.plugin.game.model.x.a(goVar);
                break;
            case 3:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                sVar = v.aUb();
                if (sVar != null) {
                    goVar.bPK.bPL = sVar.field_rawXML;
                    break;
                }
                break;
            case 4:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                v.aUc();
                break;
            case 5:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                sVar = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().dH(((Long) g.Ei().DT().get(a.sRB, Long.valueOf(0))).longValue());
                if (sVar == null || sVar.field_isHidden) {
                    sVar = null;
                }
                if (sVar != null) {
                    goVar.bPK.bPL = sVar.field_rawXML;
                    break;
                }
                break;
            case 6:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                sVar = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().dH(((Long) g.Ei().DT().get(a.sRB, Long.valueOf(0))).longValue());
                if (!(sVar == null || sVar.field_isHidden)) {
                    g.Ei().DT().a(a.sRB, Long.valueOf(0));
                    break;
                }
            case 9:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                sVar = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().dH(((Long) g.Ei().DT().get(a.sRC, Long.valueOf(0))).longValue());
                if (sVar != null) {
                    goVar.bPK.bPL = sVar.field_rawXML;
                    break;
                }
                break;
            case 10:
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSi();
                if (((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().dH(((Long) g.Ei().DT().get(a.sRC, Long.valueOf(0))).longValue()) != null) {
                    g.Ei().DT().a(a.sRC, Long.valueOf(0));
                    break;
                }
                break;
        }
        return false;
    }
}
