package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static JSONObject a(jc jcVar) {
        if (jcVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            List list = jcVar.rkt;
            xc xcVar = new xc();
            jSONObject.put("favor_info_list", bU(list));
            list = jcVar.rku;
            xb xbVar = new xb();
            jSONObject.put("favor_compose_result_list", bV(list));
            jSONObject.put("default_fav_compose_id", jcVar.rkv);
            jSONObject.put("favor_resp_sign", jcVar.rkw);
            jSONObject.put("no_compose_wording", jcVar.rkx);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray bU(List<xc> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (xc a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    private static JSONObject a(xc xcVar) {
        if (xcVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fav_type", xcVar.rCx);
            jSONObject.put("fav_sub_type", xcVar.rCy);
            jSONObject.put("fav_property", xcVar.rCz);
            jSONObject.put("favor_type_desc", xcVar.rCA);
            jSONObject.put("fav_id", xcVar.rCB);
            jSONObject.put("fav_name", xcVar.rCC);
            jSONObject.put("fav_desc", xcVar.rCD);
            jSONObject.put("favor_use_manual", xcVar.rCE);
            jSONObject.put("favor_remarks", xcVar.rCF);
            jSONObject.put("fav_price", xcVar.rCG);
            jSONObject.put("real_fav_fee", xcVar.rCH);
            jSONObject.put("fav_scope_type", xcVar.rCI);
            jSONObject.put("business_receipt_no", xcVar.rCJ);
            jSONObject.put("unavailable", xcVar.rCK);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray bV(List<xb> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (xb a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    public static JSONObject a(xb xbVar) {
        if (xbVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("favor_compose_id", xbVar.rCs);
            List list = xbVar.rkt;
            xc xcVar = new xc();
            jSONObject.put("favor_info_list,", bU(list));
            jSONObject.put("show_favor_amount,", xbVar.rCt);
            jSONObject.put("show_pay_amount,", xbVar.rCu);
            jSONObject.put("total_favor_amount,", xbVar.rCv);
            jSONObject.put("favor_desc", xbVar.mwP);
            jSONObject.put("compose_sort_flag", xbVar.rCw);
            jSONObject.put("extend_str", xbVar.rqo);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    public static JSONObject a(ch chVar) {
        if (chVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", chVar.bVU);
            jSONObject.put("favor_compose_info", a(chVar.rcG));
            jSONObject.put("f2f_id", chVar.rcD);
            jSONObject.put("payok_checksign", chVar.rcF);
            jSONObject.put("receiver_openid", chVar.myl);
            jSONObject.put("receiver_username", chVar.rcH);
            jSONObject.put("scan_scene", chVar.mwQ);
            jSONObject.put("scene", chVar.scene);
            jSONObject.put("total_amount", chVar.rcI);
            jSONObject.put("trans_id", chVar.rcE);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }
}
