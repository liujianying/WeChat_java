package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    Timer bno;
    private int fFw = -1;
    private int fWA;
    boolean fWB = false;
    private JSONObject fWz;
    MMActivity fcq = null;
    l fcy = null;
    final Object mLock = new Object();
    long mStartTime = -1;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[]{jSONObject.toString()});
        this.fcy = lVar;
        this.fFw = i;
        this.fWz = jSONObject;
        this.fWB = false;
        this.fWA = this.fWz.optInt("time_limit", 1500);
        a(new 1(this));
    }

    final void tp(String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[]{str});
        if (this.fcy != null) {
            this.fcy.E(this.fFw, str);
        }
    }

    final void onSuccess() {
        Map hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.fWz.getJSONArray("aid_list");
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[]{this.fWz.toString(), jSONArray.toString(), Integer.valueOf(jSONArray.length())});
            for (int i = 0; i < r4; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            a.ajt();
            Intent intent = new Intent(this.fcq, HCEService.class);
            intent.putExtra("key_appid", this.fcy.mAppId);
            intent.putExtra("key_time_limit", this.fWA);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.a(new 3(this));
            this.fcq.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            4 4 = new 4(this);
            this.bno = new Timer();
            this.bno.schedule(4, 10000);
        } catch (Exception e) {
            hashMap.put("errCode", Integer.valueOf(13003));
            tp(f("fail: aid_list invalid", hashMap));
            c.aa(this.fcy.mAppId, 13003, -1);
        }
    }
}
