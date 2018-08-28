package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static LinkedList<xb> p(JSONArray jSONArray) {
        LinkedList<xb> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    xb xbVar = new xb();
                    xbVar.rCs = jSONObject.optString("favor_compose_id");
                    xbVar.rCt = jSONObject.optLong("show_favor_amount");
                    xbVar.rCu = jSONObject.optLong("show_pay_amount");
                    xbVar.rCv = jSONObject.optString("total_favor_amount");
                    xbVar.mwP = jSONObject.optString("favor_desc");
                    xbVar.rCw = jSONObject.optLong("compose_sort_flag");
                    xbVar.rqo = jSONObject.optString("extend_str");
                    xbVar.rkt = q(jSONObject.optJSONArray("favor_info_list"));
                    linkedList.add(xbVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    public static LinkedList<xc> q(JSONArray jSONArray) {
        LinkedList<xc> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    xc xcVar = new xc();
                    xcVar.rCJ = jSONObject.optString("business_receipt_no");
                    xcVar.rqo = jSONObject.optString("extend_str");
                    xcVar.rCD = jSONObject.optString("fav_desc");
                    xcVar.rCB = jSONObject.optLong("fav_id", 0);
                    xcVar.rCC = jSONObject.optString("fav_name");
                    xcVar.rCG = jSONObject.optString("fav_price");
                    xcVar.rCz = jSONObject.optLong("fav_property", 0);
                    xcVar.rCI = jSONObject.optInt("fav_scope_type", 0);
                    xcVar.rCy = jSONObject.optLong("fav_sub_type", 0);
                    xcVar.rCx = jSONObject.optLong("fav_type", 0);
                    xcVar.rCF = jSONObject.optString("favor_remarks");
                    xcVar.rCA = jSONObject.optString("favor_type_desc");
                    xcVar.rCE = jSONObject.optString("favor_use_manual");
                    xcVar.rCH = jSONObject.optString("real_fav_fee");
                    xcVar.rCK = jSONObject.optInt("unavailable");
                    linkedList.add(xcVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }
}
