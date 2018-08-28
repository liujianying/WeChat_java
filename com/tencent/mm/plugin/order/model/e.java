package com.tencent.mm.plugin.order.model;

import android.support.design.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends i {
    public int hUg;
    private int kQJ;
    public List<d> lOA = null;
    public String lOB;
    public List<i> lOz = null;

    public e(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("Limit", "10");
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        F(hashMap);
    }

    public final int aBO() {
        return a$i.AppCompatTheme_radioButtonStyle;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        x.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.lOz = new LinkedList();
        try {
            this.hUg = jSONObject.getInt("TotalNum");
            this.kQJ = jSONObject.getInt("RecNum");
            this.lOB = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.lOM = jSONObject2.optInt("PayType");
                    iVar.lOE = jSONObject2.optString("Transid");
                    iVar.lOF = jSONObject2.optDouble("TotalFee");
                    iVar.lOG = jSONObject2.optString("GoodsName");
                    iVar.lOH = jSONObject2.optInt("CreateTime");
                    iVar.lOJ = jSONObject2.optInt("ModifyTime");
                    iVar.lOK = jSONObject2.optString("FeeType");
                    iVar.lOP = jSONObject2.optString("AppThumbUrl");
                    iVar.lOI = jSONObject2.optString("TradeStateName");
                    iVar.lOU = jSONObject2.optString("StatusColor");
                    iVar.lOV = jSONObject2.optString("FeeColor");
                    iVar.lOW = jSONObject2.optDouble("ActualPayFee");
                    iVar.lOX = jSONObject2.optString("BillId");
                    this.lOz.add(iVar);
                }
            }
            this.lOA = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.lOy = jSONObject3.optString("feetext");
                    this.lOA.add(dVar);
                    i2++;
                }
            }
        } catch (JSONException e) {
            x.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
        }
    }
}
