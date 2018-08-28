package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t extends i {
    public String htC;
    public String mTimeStamp;
    public String mwc;
    private int pjA;
    private int pjB;
    private int pjC;
    public Profession[] pjD;
    public List<ElementQuery> pjy;
    public ElementQuery pjz;

    public t(String str, String str2, PayInfo payInfo) {
        this(str, str2, payInfo, null, -1, -1, (byte) 0);
    }

    public t(String str, String str2, PayInfo payInfo, int i) {
        this(str, str2, payInfo, null, -1, i, (byte) 0);
    }

    public t(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(str, str2, payInfo, str3, i, i2, (byte) 0);
    }

    public t() {
        this(null, null, null, null, -1, -1, (byte) 0);
    }

    private t(String str, String str2, PayInfo payInfo, String str3, int i, int i2, byte b) {
        this.pjy = null;
        this.pjz = null;
        this.mTimeStamp = null;
        this.htC = null;
        this.mwc = null;
        this.pjA = 3;
        this.pjD = null;
        this.htC = str2;
        this.pjA = 3;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i2 > 0) {
            hashMap.put("realname_scene", String.valueOf(i2));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[]{Integer.valueOf(i2)});
        }
        if (i == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", "3");
        hashMap.put("token", str3);
        F(hashMap);
        if (p.cDb()) {
            hashMap2.put("uuid_for_bindcard", p.cDd());
            hashMap2.put("bindcard_scene", p.cDc());
        }
        aC(hashMap2);
    }

    public final int aBO() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pjy = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (bi.oW(this.mwc)) {
                str2 = optString;
            } else {
                str2 = this.mwc;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.dKT = jSONObject2;
                elementQuery.knE = jSONObject2.optString("bank_name");
                elementQuery.lMV = jSONObject2.optString("bank_type");
                elementQuery.pnu = jSONObject2.optString("bankacc_type_name");
                elementQuery.pnw = jSONObject2.optString("bank_phone");
                elementQuery.pnz = jSONObject2.optString("forbid_word");
                elementQuery.pny = jSONObject2.optString("bank_recommend_desc");
                elementQuery.pnx = jSONObject2.optString("bank_app_user_name");
                elementQuery.pnt = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.pnm = e.k(jSONObject2, "canModifyName");
                elementQuery.pnn = e.k(jSONObject2, "canModifyCreID");
                elementQuery.pnr = "0".equals(jSONObject2.optString("is_sure"));
                elementQuery.pno = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.pnp = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.pnl = jSONObject2.optString("time_stamp");
                elementQuery.pnq = jSONObject2.optString("uesr_name");
                elementQuery.pnv = jSONObject2.optString("bank_flag");
                elementQuery.pnA = e.k(jSONObject2, "needFirstName");
                elementQuery.pnB = e.k(jSONObject2, "needLastName");
                elementQuery.pnC = e.k(jSONObject2, "needCountry");
                elementQuery.pnD = e.k(jSONObject2, "needArea");
                elementQuery.pnE = e.k(jSONObject2, "needCity");
                elementQuery.pnF = e.k(jSONObject2, "needAddress");
                elementQuery.pnG = e.k(jSONObject2, "needZip");
                elementQuery.pnH = e.k(jSONObject2, "needPhone");
                elementQuery.pnI = e.k(jSONObject2, "needEmail");
                elementQuery.pnL = e.k(jSONObject2, "needShowProtocol");
                elementQuery.pnJ = jSONObject2.optString("support_cre_type");
                elementQuery.pjA = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.pjA == 1) {
                    if (!e.k(jSONObject2, "IsSaveYfq")) {
                        elementQuery.pns = 0;
                    } else if (e.k(jSONObject2, "canReturnYfq")) {
                        elementQuery.pns = 4;
                    } else {
                        elementQuery.pns = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.pns = 1;
                } else {
                    elementQuery.pns = 2;
                }
                CharSequence optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.pnO = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.pnO = true;
                } else if ("0".equals(optString2)) {
                    elementQuery.pnO = false;
                }
                elementQuery.plq = jSONObject2.optString("arrive_type");
                elementQuery.pnM = jSONObject2.optString("pre_auth_word");
                elementQuery.pnN = jSONObject2.optInt("support_foreign_mobile", 0);
                if (Bankcard.dY(this.pjA, elementQuery.pjA)) {
                    this.pjy.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.lMV)) {
                    this.pjz = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            q bPe = o.bPe();
            List list = this.pjy;
            bPe.pqQ = sparseArray;
            bPe.pjy = list;
            this.pjB = jSONObject.optInt("need_area");
            this.pjC = jSONObject.optInt("need_profession");
            if (!(this.pjz == null || this.pjz.pjA == 1)) {
                x.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
                this.pjB = 0;
                this.pjC = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.pjD = new Profession[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (bi.oW(optString3)) {
                            x.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
                        } else {
                            this.pjD[i2] = new Profession(optString3, optInt2);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
    }

    public final int If() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean bOl() {
        return this.pjB == 1;
    }

    public final boolean bOm() {
        return this.pjC == 1;
    }
}
