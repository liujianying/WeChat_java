package com.tencent.mm.plugin.webview.ui.tools.bag;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import org.json.JSONException;
import org.json.JSONObject;

final class j$a {
    String bWP;
    long dRk;
    public int qcv;
    public int qcw;
    int scene;
    JSONObject uec;
    public String url;

    public j$a() {
        g.Ek();
        String str = (String) g.Ei().DT().get(a.taa, null);
        x.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[]{str});
        if (bi.oW(str)) {
            this.url = null;
            this.bWP = null;
            this.qcw = (com.tencent.mm.bp.a.fk(ad.getContext()) - b.qbm) - b.qbn;
            this.qcv = b.qbl + ad.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_init_top_margin);
            this.uec = new JSONObject();
            x.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[]{Integer.valueOf(this.qcw), Integer.valueOf(this.qcv)});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.url = jSONObject.getString("url");
            this.bWP = jSONObject.getString("icon");
            this.qcv = jSONObject.getInt("pos_y");
            this.qcw = jSONObject.getInt("pos_x");
            this.dRk = jSONObject.getLong("last_active_time");
            this.uec = jSONObject.getJSONObject("extras");
        } catch (JSONException e) {
            x.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[]{e});
        }
    }

    final void save() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", bi.oV(this.url));
            jSONObject.put("icon", bi.oV(this.bWP));
            jSONObject.put("pos_y", this.qcv);
            jSONObject.put("pos_x", this.qcw);
            jSONObject.put("last_active_time", this.dRk);
            jSONObject.put("extras", this.uec);
            String jSONObject2 = jSONObject.toString();
            g.Ek();
            g.Ei().DT().a(a.taa, jSONObject2);
        } catch (JSONException e) {
            x.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[]{e});
        }
    }
}
