package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class y extends i {
    public String ced;
    public String cee;
    public String cef;
    public String ceg;
    public String ceh;
    public String cei;
    public int cej;
    public String cek;
    public String cel;
    public String cem;
    public String cen;
    public String ceo;
    public LinkedList<String> cep;
    public ECardInfo ceq;
    public Map<String, String> lKr;
    public Map<String, String> peZ;
    public int scene;
    public String title;

    public y() {
        this(null, 0);
    }

    public y(String str, int i) {
        this.cei = "";
        this.cej = 0;
        this.cek = "";
        this.cel = "";
        this.cem = "";
        this.cen = "";
        this.ceo = "";
        this.title = "";
        this.cep = new LinkedList();
        this.scene = 0;
        this.lKr = new HashMap();
        this.scene = i;
        this.lKr.put("req_key", str);
        this.lKr.put("bind_query_scene", String.valueOf(i));
        k kVar = (k) g.l(k.class);
        this.lKr.put("is_root", "0");
        if (kVar != null) {
            this.lKr.put("is_device_open_touch", "1");
            Map aNq = kVar.aNq();
            if (aNq != null) {
                this.lKr.putAll(aNq);
            }
            x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
        } else {
            this.lKr.put("is_device_open_touch", "0");
            x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
        }
        F(this.lKr);
        this.peZ = new HashMap();
        g.Ek();
        String str2 = (String) g.Ei().DT().get(196612, null);
        g.Ek();
        String str3 = (String) g.Ei().DT().get(196613, null);
        this.peZ.put("bind_serial", str2);
        this.peZ.put("last_bind_serial", str3);
        aC(this.peZ);
    }

    public int aBO() {
        return 72;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            JSONObject optJSONObject;
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("real_name_info");
                x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[]{optJSONObject2.toString()});
                this.ced = optJSONObject2.optString("guide_flag");
                this.cee = optJSONObject2.optString("guide_wording");
                this.cef = optJSONObject2.optString("left_button_wording");
                this.ceg = optJSONObject2.optString("right_button_wording");
                this.ceh = optJSONObject2.optString("upload_credit_url");
                this.cei = optJSONObject2.optString("done_button_wording");
                this.cej = optJSONObject2.optInt("is_show_protocol", 0);
                this.cek = optJSONObject2.optString("left_protocol_wording");
                this.cel = optJSONObject2.optString("new_upload_credit_url");
                this.cem = optJSONObject2.optString("protocol_url");
                this.cen = optJSONObject2.optString("right_protocol_wording");
                this.ceo = optJSONObject2.optString("subtitle");
                this.title = optJSONObject2.optString("title");
                JSONArray optJSONArray = optJSONObject2.optJSONArray("upload_reasons");
                this.cep.clear();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.cep.add(optJSONArray.optString(i2));
                    }
                }
                if (optJSONObject2.has("ecard_info")) {
                    optJSONObject = optJSONObject2.optJSONObject("ecard_info");
                    this.ceq = new ECardInfo();
                    this.ceq.title = this.title;
                    this.ceq.pnf = new ArrayList(this.cep);
                    this.ceq.pnh = this.cem;
                    this.ceq.pni = this.cek;
                    this.ceq.pnj = this.cen;
                    this.ceq.png = this.cei;
                    this.ceq.pmY = optJSONObject.optInt("ecard_open_scene", 0);
                    this.ceq.bJV = optJSONObject.optString("ecard_type", "");
                    this.ceq.pmZ = optJSONObject.optInt("show_check_box", 0);
                    this.ceq.pna = optJSONObject.optInt("check_box_selected", 0);
                    this.ceq.pnb = optJSONObject.optString("check_box_left_wording", "");
                    this.ceq.pnc = optJSONObject.optString("check_box_right_wording", "");
                    this.ceq.pnd = optJSONObject.optString("check_box_url", "");
                    this.ceq.pne = optJSONObject.optInt("is_upload_credid", 0);
                    this.ceq.ceh = optJSONObject.optString("upload_credit_url", "");
                }
            }
            if (jSONObject.has("paymenu_array") && this.scene == 1) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("paymenu_array");
                if (optJSONArray2 != null) {
                    w.OY(optJSONArray2.toString());
                }
            }
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                o.setTimeStamp(String.valueOf(optLong));
            } else {
                x.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
            }
            ab.a(jSONObject, this.scene);
            if (ab.zm(this.scene) || this.scene == 1) {
                optJSONObject = jSONObject.optJSONObject("bind_card_menu");
                if (optJSONObject != null) {
                    x.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[]{optJSONObject.toString()});
                    g.Ek();
                    g.Ei().DT().a(a.sYt, optJSONObject.toString());
                } else {
                    g.Ek();
                    g.Ei().DT().a(a.sYt, "");
                }
            }
            k kVar = (k) g.l(k.class);
            if (kVar != null) {
                x.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
                kVar.aNj();
                kVar.eZ(com.tencent.mm.plugin.wallet_core.model.o.bOW().bPu());
                return;
            }
            x.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
        }
    }

    public int If() {
        return 1501;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
    }
}
