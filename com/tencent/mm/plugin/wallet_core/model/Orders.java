package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.a;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new 1();
    public static int ppu = 0;
    public static int ppv = 1;
    public String bOd = "";
    public String eGB = "0";
    public String ixy = "";
    public String lCU;
    public String lNV;
    public double mBj = 0.0d;
    public double mxE;
    public String nickname;
    public int pjA;
    public String plj;
    public long poN;
    public double poO = 0.0d;
    public int poP;
    public String poQ;
    public int poR;
    public String poS;
    public String poT;
    public String poU;
    public String poV;
    public int poW;
    public boolean poX = false;
    public String poY = "";
    public long poZ = 0;
    public String ppa = "";
    public String ppb;
    public Set<String> ppc = new HashSet();
    public int ppd = 0;
    public String ppe = "";
    public List<Commodity> ppf = new ArrayList();
    public f ppg = new f();
    public int pph = 0;
    public String ppi = "";
    public String ppj = "";
    public DeductInfo ppk;
    public long ppl;
    public long ppm;
    public int ppn = 0;
    public int ppo = 0;
    public int ppp = 0;
    public String ppq = "";
    public int ppr = 0;
    public int pps = 0;
    public ArrayList<ShowInfo> ppt = new ArrayList();
    public String token = "";
    public String username;

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new 1();
        public String bOe;
        public String desc;
        public double hUL = 0.0d;
        public String lNH;
        public String lNI;
        public String lNJ;
        public String lNK;
        public String lNM;
        public String lNO;
        public String lNP;
        public int lNR;
        public String lNT;
        public String lNV;
        public String lNW;
        public String lNy;
        public String lOa;
        public int poW;
        public String ppA;
        public String ppB;
        public String ppC;
        public RecommendTinyAppInfo ppD = null;
        public RemarksInfo ppE;
        public List<Promotions> ppF = new ArrayList();
        public boolean ppG = false;
        public a ppH = new a();
        public double ppw = 0.0d;
        public String ppx;
        public String ppy;
        public List<DiscountInfo> ppz = new ArrayList();

        public int describeContents() {
            return 0;
        }

        public Commodity(Parcel parcel) {
            this.lNH = parcel.readString();
            this.lNI = parcel.readString();
            this.lNJ = parcel.readString();
            this.lNK = parcel.readString();
            this.desc = parcel.readString();
            this.lNM = parcel.readString();
            this.hUL = parcel.readDouble();
            this.lNO = parcel.readString();
            this.lNP = parcel.readString();
            this.lNR = parcel.readInt();
            this.bOe = parcel.readString();
            this.lNT = parcel.readString();
            this.lNV = parcel.readString();
            this.lNW = parcel.readString();
            this.lNy = parcel.readString();
            this.ppy = parcel.readString();
            this.lOa = parcel.readString();
            parcel.readTypedList(this.ppz, DiscountInfo.CREATOR);
            this.ppA = parcel.readString();
            this.ppC = parcel.readString();
            this.ppD = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
            parcel.readTypedList(this.ppF, Promotions.CREATOR);
            this.ppE = (RemarksInfo) parcel.readParcelable(RemarksInfo.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.lNH);
            parcel.writeString(this.lNI);
            parcel.writeString(this.lNJ);
            parcel.writeString(this.lNK);
            parcel.writeString(this.desc);
            parcel.writeString(this.lNM);
            parcel.writeDouble(this.hUL);
            parcel.writeString(this.lNO);
            parcel.writeString(this.lNP);
            parcel.writeInt(this.lNR);
            parcel.writeString(this.bOe);
            parcel.writeString(this.lNT);
            parcel.writeString(this.lNV);
            parcel.writeString(this.lNW);
            parcel.writeString(this.lNy);
            parcel.writeString(this.ppy);
            parcel.writeString(this.lOa);
            parcel.writeTypedList(this.ppz);
            parcel.writeString(this.ppA);
            parcel.writeString(this.ppC);
            parcel.writeParcelable(this.ppD, 0);
            parcel.writeTypedList(this.ppF);
            parcel.writeParcelable(this.ppE, 0);
        }
    }

    public static Orders ah(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Orders orders = new Orders();
        try {
            orders.poN = bi.VF();
            orders.mBj = jSONObject.getDouble("total_fee") / 100.0d;
            orders.eGB = jSONObject.getString("num");
            orders.pjA = jSONObject.optInt("bank_card_tag", 1);
            orders.lNV = jSONObject.optString("fee_type", "");
            orders.mxE = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            orders.poO = jSONObject.optDouble("fetch_fee", 0.0d) / 100.0d;
            orders.poP = jSONObject.optInt("is_assign_userinfo_pay");
            orders.plj = jSONObject.optString("true_name");
            orders.poQ = jSONObject.optString("cre_id");
            orders.poR = jSONObject.optInt("ce_type");
            orders.poS = jSONObject.optString("assign_pay_info");
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            orders.ppl = jSONObject.optLong("free_fee");
            orders.ppm = jSONObject.optLong("remain_fee");
            orders.ppn = jSONObject.optInt("not_support_bind_card", 0);
            orders.ppo = jSONObject.optInt("not_support_retry", 0);
            int i = jSONObject.optInt("support_all_bank", 0) == 1 ? 1 : 0;
            if (i != 0) {
                orders.ppc = new HashSet();
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Commodity commodity = new Commodity();
                commodity.desc = jSONObject2.getString("desc");
                commodity.hUL = ((double) jSONObject2.getInt("fee")) / 100.0d;
                commodity.lNM = jSONObject2.optInt("count", 1);
                commodity.lNO = jSONObject2.getString("pay_status");
                commodity.lNT = jSONObject2.optString("buy_bank_name");
                commodity.lNP = jSONObject2.getString("pay_status_name");
                commodity.lNJ = jSONObject2.optString("spid");
                commodity.lNK = jSONObject2.optString("sp_name");
                commodity.lNR = jSONObject2.optInt("modify_timestamp");
                commodity.bOe = jSONObject2.getString("transaction_id");
                commodity.lNV = jSONObject2.optString("fee_type");
                if (bi.oW(orders.lNV)) {
                    orders.lNV = commodity.lNV;
                }
                commodity.lNW = jSONObject2.optString("appusername");
                commodity.lNy = jSONObject2.optString("app_telephone");
                orders.ppf.add(commodity);
                if (i == 0) {
                    orders.ppb = jSONObject2.optString("support_bank");
                    orders.ppc = OV(orders.ppb);
                }
            }
            if (jSONObject.has("is_open_fee_protocal")) {
                orders.poX = e.k(jSONObject, "is_open_fee_protocal");
            } else {
                orders.poX = Bankcard.dY(orders.pjA, 2);
            }
            orders.ppg = ai(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            if (optJSONObject == null) {
                x.e("MicroMsg.Orders", "bindqueryresp is null ");
            } else {
                optJSONObject = optJSONObject.optJSONObject("user_info");
                if (optJSONObject == null) {
                    x.e("MicroMsg.Orders", "user_info is null ");
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                    if (optJSONObject2 == null) {
                        x.e("MicroMsg.Orders", "touch_info is null ");
                    } else {
                        orders.ppd = ((k) g.l(k.class)).aNi() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                        orders.ppe = optJSONObject2.optString("touch_forbidword");
                        String optString = optJSONObject2.optString("touch_challenge");
                        boolean z = 1 == optJSONObject2.optInt("need_change_auth_key");
                        s.pqR.jgX = optString;
                        s.pqR.jgY = z;
                        x.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", new Object[]{Integer.valueOf(orders.ppd), optString, Boolean.valueOf(z)});
                    }
                }
            }
            orders.pph = jSONObject.optInt("needbindcardtoshowfavinfo");
            orders.ppi = jSONObject.optString("discount_wording");
            orders.ppj = jSONObject.optString("favor_rule_wording");
            a(orders, jSONObject.optJSONObject("entrustpayinfo"));
            return orders;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            return orders;
        }
    }

    private static f ai(JSONObject jSONObject) {
        f fVar = new f();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            x.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            return fVar;
        }
        int i;
        JSONArray optJSONArray;
        int i2;
        fVar.pdV = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        fVar.pdW = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        fVar.pdX = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        fVar.pdY = optJSONObject.optString("favorComposeId");
        fVar.peb = optJSONObject.optInt("useNaturalDefense");
        fVar.pec = optJSONObject.optString("discountWording");
        fVar.ped = optJSONObject.optString("favorRuleWording");
        fVar.pee = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        fVar.pef = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        fVar.peg = optJSONObject.optInt("isVariableFavor");
        fVar.peh = optJSONObject.optString("invariableFavorDesc");
        fVar.pei = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray2.length(); i++) {
            JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
            q qVar = new q();
            qVar.peI = jSONObject2.optInt("favType");
            qVar.peJ = jSONObject2.optInt("favSubType");
            qVar.peK = jSONObject2.optLong("favProperty");
            qVar.peL = jSONObject2.optString("favorTypeDesc");
            qVar.pdS = jSONObject2.optString("favId");
            qVar.peM = jSONObject2.optString("favName");
            qVar.peN = jSONObject2.optString("favDesc");
            qVar.pdT = jSONObject2.optString("favorUseManual");
            qVar.pdU = jSONObject2.optString("favorRemarks");
            qVar.peO = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            qVar.peP = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            qVar.peQ = jSONObject2.optInt("needBankPay");
            qVar.peR = jSONObject2.optString("bankNo");
            qVar.lNT = jSONObject2.optString("bankName");
            qVar.peS = jSONObject2.optString("bankLogoUrl");
            optJSONArray = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    qVar.peT.add(b.bi(optJSONArray.optString(i2).getBytes()));
                }
            }
            fVar.pdZ.add(qVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            fVar.pea = new com.tencent.mm.plugin.wallet.a.g();
            optJSONArray2 = optJSONObject2.optJSONArray("favorComposeInfo");
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= optJSONArray2.length()) {
                    break;
                }
                optJSONObject2 = optJSONArray2.getJSONObject(i2);
                h hVar = new h();
                hVar.pem = optJSONObject2.optString("faovrComposeId");
                hVar.pen = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                hVar.pdX = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                hVar.pee = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                hVar.pef = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                hVar.peg = optJSONObject2.optInt("isVariableFavor");
                hVar.peh = optJSONObject2.optString("invariableFavorDesc");
                hVar.pei = optJSONObject2.optString("variableFavorDesc");
                optJSONArray = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    com.tencent.mm.plugin.wallet.a.e eVar = new com.tencent.mm.plugin.wallet.a.e();
                    eVar.pdS = jSONObject3.optString("favId");
                    eVar.pdT = jSONObject3.optString("favorUseManual");
                    eVar.pdU = jSONObject3.optString("favorRemarks");
                    hVar.peo.add(eVar);
                }
                fVar.pea.pek.add(hVar);
                i = i2 + 1;
            }
        }
        a aVar = new a();
        optJSONObject = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject != null) {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray3 != null) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= optJSONArray3.length()) {
                        break;
                    }
                    com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
                    optJSONObject2 = optJSONArray3.getJSONObject(i2);
                    bVar.lMW = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            c cVar = new c();
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i);
                            cVar.mwP = optJSONObject3.optString("favor_desc");
                            cVar.pdQ = optJSONObject3.optInt("is_default_show", 0);
                            bVar.pdP.add(cVar);
                        }
                    }
                    aVar.pdN.add(bVar);
                    i = i2 + 1;
                }
            }
            JSONArray optJSONArray5 = optJSONObject.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                aVar.pdO = new com.tencent.mm.plugin.wallet.a.k();
                for (i = 0; i < optJSONArray5.length(); i++) {
                    l lVar = new l();
                    lVar.mwP = optJSONArray5.optJSONObject(i).optString("favor_desc");
                    aVar.pdO.pet.add(lVar);
                }
            }
        }
        fVar.pej = aVar;
        return fVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        if (jSONObject == null || orders == null) {
            x.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.poU = optJSONObject.optString("app_recommend_desc");
                    orders.poV = optJSONObject.optString("app_telephone");
                    orders.poW = optJSONObject.optInt("recommend_level", 2);
                    orders.ixy = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.poW;
                List<Commodity> list = orders.ppf;
                orders.poY = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.ppF = new ArrayList();
                        commodity.ppz = new ArrayList();
                        commodity.bOe = jSONObject2.getString("transaction_id");
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString("transaction_id");
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.bOe)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("extinfo");
                if (optJSONObject != null) {
                    orders.poZ = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.ppa = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
                orders.ppp = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.ppq = jSONObject.optString("pay_succ_btn_wording");
                orders.pps = jSONObject.optInt("is_jsapi_close_page");
                b(orders, jSONObject);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        commodity.lOa = jSONObject.optString("discount");
        commodity.lNO = jSONObject.getString("pay_status");
        commodity.lNP = jSONObject.getString("pay_status_name");
        commodity.lNT = jSONObject.optString("buy_bank_name");
        commodity.lNR = jSONObject.optInt("pay_timestamp");
        commodity.ppy = jSONObject.optString("card_tail");
        commodity.poW = i;
        commodity.ppA = jSONObject.optString("rateinfo");
        commodity.ppB = jSONObject.optString("discount_rateinfo");
        commodity.ppC = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.hUL = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.ppw = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.lNV = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            Promotions promotions = new Promotions();
            promotions.type = ppu;
            promotions.name = optJSONObject.optString("nickname");
            promotions.lNW = optJSONObject.optString("username");
            commodity.ppx = promotions.lNW;
            promotions.lRX = optJSONObject.optString("logo_round_url");
            promotions.url = optJSONObject.optString("subscribe_biz_url");
            if (!(bi.oW(promotions.name) || bi.oW(promotions.url))) {
                commodity.ppF.add(promotions);
                commodity.ppG = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Promotions promotions2 = new Promotions();
            promotions2.type = ppv;
            promotions2.lRX = jSONObject2.optString("icon");
            promotions2.name = jSONObject2.optString("wording");
            promotions2.url = jSONObject2.optString("url");
            promotions2.poG = jSONObject2.optString("btn_text");
            promotions2.ppS = jSONObject2.optInt("type");
            promotions2.title = jSONObject2.optString("title");
            promotions2.pji = jSONObject2.optLong("activity_id");
            promotions2.ppT = jSONObject2.optInt("activity_type", 0);
            promotions2.ppV = jSONObject2.optString("small_title");
            promotions2.ppU = jSONObject2.optInt("award_id");
            promotions2.poD = jSONObject2.optInt("send_record_id");
            promotions2.poE = jSONObject2.optInt("user_record_id");
            promotions2.ppW = jSONObject2.optString("activity_tinyapp_username");
            promotions2.ppX = jSONObject2.optString("activity_tinyapp_path");
            promotions2.poF = jSONObject2.optLong("activity_mch_id");
            promotions2.ppY = jSONObject2.optInt("activity_tinyapp_version");
            promotions2.ppZ = jSONObject2.optString("get_award_params");
            promotions2.pqa = jSONObject2.optString("query_award_status_params");
            a(promotions2, jSONObject2.optJSONObject("exposure_info"));
            commodity.ppF.add(promotions2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.ppH.text = optJSONObject.optString("text");
            commodity.ppH.url = optJSONObject.optString("url");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.ppR = optJSONObject2.optDouble("payment_amount");
                    discountInfo.mwP = optJSONObject2.optString("favor_desc");
                    commodity.ppz.add(discountInfo);
                }
                i2++;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject3 != null) {
            if (commodity.ppD == null) {
                commodity.ppD = new RecommendTinyAppInfo();
            }
            commodity.ppD.poI = optJSONObject3.optString("tinyapp_name");
            commodity.ppD.poJ = optJSONObject3.optString("tinyapp_logo");
            commodity.ppD.poK = optJSONObject3.optString("tinyapp_desc");
            commodity.ppD.paD = optJSONObject3.optString("tinyapp_username");
            commodity.ppD.paE = optJSONObject3.optString("tinyapp_path");
            commodity.ppD.poL = optJSONObject3.optString("activity_tinyapp_btn_text");
            commodity.ppD.pqc = optJSONObject3.optLong("activity_id");
            commodity.ppD.pqd = optJSONObject3.optLong("activity_type");
            commodity.ppD.pqe = optJSONObject3.optLong("award_id");
            commodity.ppD.pqf = optJSONObject3.optInt("send_record_id");
            commodity.ppD.pqg = optJSONObject3.optInt("user_record_id");
            commodity.ppD.pqh = optJSONObject3.optLong("activity_mch_id");
            commodity.ppD.poM = optJSONObject3.optInt("tinyapp_version");
        }
        optJSONObject3 = jSONObject.optJSONObject("remarks_info");
        if (optJSONObject3 != null) {
            if (commodity.ppE == null) {
                commodity.ppE = new RemarksInfo();
            }
            commodity.ppE.pqi = optJSONObject3.optString("remark_title");
            commodity.ppE.pqj = optJSONObject3.optString("remark_desc");
        }
    }

    public static void a(Promotions promotions, JSONObject jSONObject) {
        x.i("MicroMsg.Orders", "parseExposureInfo: %s", new Object[]{jSONObject});
        if (jSONObject == null) {
            promotions.pqb = null;
            return;
        }
        try {
            d.a.a.c cVar = new d.a.a.c();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.rxS = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    d.a.a.g gVar = new d.a.a.g();
                    gVar.lRX = jSONObject2.optString("logo");
                    gVar.vHo = jSONObject2.optString("award_name");
                    gVar.vHp = jSONObject2.optString("award_description");
                    gVar.vHq = jSONObject2.optString("background_img");
                    gVar.vHs = jSONObject2.optString("award_description_color");
                    gVar.vHr = jSONObject2.optString("award_name_color");
                    cVar.rxS.add(gVar);
                }
            }
            cVar.vGZ = jSONObject.optInt("is_query_others", 0);
            cVar.rvZ = jSONObject.optString("draw_lottery_params");
            cVar.rxT = jSONObject.optInt("is_show_btn");
            cVar.vHd = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                cVar.rxU = new d.a.a.a();
                cVar.rxU.vGR = optJSONObject.optString("btn_words");
                cVar.rxU.vGS = optJSONObject.optString("btn_color");
                cVar.rxU.vGT = optJSONObject.optInt("btn_op_type");
                cVar.rxU.url = optJSONObject.optString("url");
                cVar.rxU.rJm = optJSONObject.optString("get_lottery_params");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.rxU.vGU = new d.a.a.f();
                    cVar.rxU.vGU.sbY = optJSONObject.optString("activity_tinyapp_username");
                    cVar.rxU.vGU.sbZ = optJSONObject.optString("activity_tinyapp_path");
                    cVar.rxU.vGU.sca = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            cVar.rxR = jSONObject.optString("exposure_info_modify_params");
            cVar.vHa = jSONObject.optInt("user_opertaion_type");
            cVar.vHb = jSONObject.optInt("is_show_layer");
            optJSONObject = jSONObject.optJSONObject("layer_info");
            if (optJSONObject != null) {
                cVar.vHc = new d.a.a.e();
                cVar.vHc.vHf = optJSONObject.optString("layer_title");
                cVar.vHc.vHg = optJSONObject.optString("layer_logo");
                cVar.vHc.vHh = optJSONObject.optString("layer_type");
                cVar.vHc.vHi = optJSONObject.optString("layer_name");
                cVar.vHc.vHj = optJSONObject.optString("layer_description");
                cVar.vHc.vHk = optJSONObject.optInt("is_show_layer_btn");
                if (!bi.oW(optJSONObject.optString("voice_url"))) {
                    cVar.vHc.vHm = new b(optJSONObject.optString("voice_url").getBytes());
                }
                if (!bi.oW(optJSONObject.optString("voice_data"))) {
                    cVar.vHc.vHn = new b(optJSONObject.optString("voice_data").getBytes());
                }
                optJSONObject = optJSONObject.optJSONObject("layer_btn_info");
                if (optJSONObject != null) {
                    cVar.vHc.vHl = new d();
                    cVar.vHc.vHl.vGR = optJSONObject.optString("btn_words");
                    cVar.vHc.vHl.vGS = optJSONObject.optString("btn_color");
                    cVar.vHc.vHl.vGT = optJSONObject.optInt("btn_op_type");
                    cVar.vHc.vHl.rJm = optJSONObject.optString("get_lottery_params");
                    cVar.vHc.vHl.url = optJSONObject.optString("url");
                    optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                    if (optJSONObject != null) {
                        cVar.vHc.vHl.vGU = new d.a.a.f();
                        cVar.vHc.vHl.vGU.sbY = optJSONObject.optString("activity_tinyapp_username");
                        cVar.vHc.vHl.vGU.sbZ = optJSONObject.optString("activity_tinyapp_path");
                        cVar.vHc.vHl.vGU.sca = optJSONObject.optInt("activity_tinyapp_version");
                    }
                }
            }
            optJSONObject = jSONObject.optJSONObject("draw_lottery_info");
            if (optJSONObject != null) {
                cVar.vHe = new d.a.a.b();
                cVar.vHe.url = optJSONObject.optString("url");
                cVar.vHe.vGV = optJSONObject.optString("animation_wording");
                cVar.vHe.vGW = optJSONObject.optString("animation_wording_color");
                cVar.vHe.vGX = optJSONObject.optString("after_animation_wording");
                cVar.vHe.vGY = optJSONObject.optString("after_animation_wording_color");
                cVar.vHe.srY = optJSONObject.optInt("op_type");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.vHe.vGU = new d.a.a.f();
                    cVar.vHe.vGU.sbY = optJSONObject.optString("activity_tinyapp_username");
                    cVar.vHe.vGU.sbZ = optJSONObject.optString("activity_tinyapp_path");
                    cVar.vHe.vGU.sca = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            promotions.pqb = cVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "parseExposureInfo error: %s", new Object[]{e.getMessage()});
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        if (jSONObject != null) {
            x.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.ppk = new DeductInfo();
            orders.ppk.title = jSONObject.optString("contract_title");
            orders.ppk.desc = jSONObject.optString("contract_desc");
            orders.ppk.pgM = jSONObject.optInt("auto_deduct_flag", 0);
            orders.ppk.ppI = jSONObject.optString("contract_url");
            orders.ppk.ppK = jSONObject.optInt("is_select_pay_way", 0);
            orders.ppk.pgd = jSONObject.optInt("deduct_show_type", 0);
            orders.ppk.hwH = jSONObject.optString("button_wording", "");
            orders.ppk.pge = jSONObject.optString("deduct_rule_wording", "");
            orders.ppk.ppL = jSONObject.optString("open_deduct_wording", "");
            orders.ppk.ppM = jSONObject.optString("open_deduct_wording_color", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.ppk.ppJ = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString("value");
                        optJSONObject = optJSONObject.optJSONObject("value_attr");
                        if (optJSONObject != null) {
                            deductShowInfo.ppN = optJSONObject.optInt("link_type", 0);
                            deductShowInfo.ppO = optJSONObject.optString("link_weapp");
                            deductShowInfo.ppP = optJSONObject.optString("link_addr");
                            deductShowInfo.ppQ = optJSONObject.optString("link_url");
                        }
                        orders.ppk.ppJ.add(deductShowInfo);
                    } else {
                        x.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
                    }
                }
                return;
            }
            x.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + length);
            return;
        }
        x.i("MicroMsg.Orders", "parseDeductInfo json is null");
    }

    private static void b(Orders orders, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                orders.ppr = jSONObject.optInt("is_use_show_info", 0);
                x.i("MicroMsg.Orders", "is_use_show_info: %s", new Object[]{Integer.valueOf(orders.ppr)});
                JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    x.i("MicroMsg.Orders", "showInfo size: %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                    orders.ppt = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            ShowInfo showInfo = new ShowInfo();
                            showInfo.name = optJSONObject.optString("name");
                            showInfo.value = optJSONObject.optString("value");
                            showInfo.jLs = optJSONObject.optString("name_color");
                            showInfo.pqk = optJSONObject.optString("value_color");
                            optJSONObject = optJSONObject.optJSONObject("value_attr");
                            if (optJSONObject != null) {
                                showInfo.pql = optJSONObject.optInt("link_type");
                                showInfo.pqm = optJSONObject.optString("link_weapp");
                                showInfo.pqn = optJSONObject.optString("link_addr");
                                showInfo.pqo = optJSONObject.optString("link_url");
                                showInfo.pqp = optJSONObject.optInt("text_attr");
                            }
                            if (!bi.oW(showInfo.name) || !bi.oW(showInfo.value)) {
                                orders.ppt.add(showInfo);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Orders", e, "parseShowInfo error", new Object[0]);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.bOd).append("\n");
        stringBuilder.append("token").append(this.token).append("\n");
        stringBuilder.append("num").append(this.eGB).append("\n");
        stringBuilder.append("totalFee").append(this.mBj).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> OV(String str) {
        HashSet<String> hashSet = new HashSet();
        if (!bi.oW(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        this.poN = parcel.readLong();
        this.bOd = parcel.readString();
        this.token = parcel.readString();
        this.eGB = parcel.readString();
        this.mBj = parcel.readDouble();
        this.pjA = parcel.readInt();
        this.lNV = parcel.readString();
        this.mxE = parcel.readDouble();
        this.poO = parcel.readDouble();
        this.poP = parcel.readInt();
        this.plj = parcel.readString();
        this.poQ = parcel.readString();
        this.poR = parcel.readInt();
        this.poS = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.lCU = parcel.readString();
        this.poT = parcel.readString();
        this.poU = parcel.readString();
        this.poV = parcel.readString();
        this.poW = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.poX = z;
        this.poY = parcel.readString();
        this.ixy = parcel.readString();
        this.poZ = parcel.readLong();
        this.ppa = parcel.readString();
        parcel.readTypedList(this.ppf, Commodity.CREATOR);
        this.ppb = parcel.readString();
        this.ppc = OV(this.ppb);
        this.ppd = parcel.readInt();
        this.ppe = parcel.readString();
        this.ppk = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.ppn = parcel.readInt();
        this.ppo = parcel.readInt();
        this.pps = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.poN);
        parcel.writeString(this.bOd);
        parcel.writeString(this.token);
        parcel.writeString(this.eGB);
        parcel.writeDouble(this.mBj);
        parcel.writeInt(this.pjA);
        parcel.writeString(this.lNV);
        parcel.writeDouble(this.mxE);
        parcel.writeDouble(this.poO);
        parcel.writeInt(this.poP);
        parcel.writeString(this.plj);
        parcel.writeString(this.poQ);
        parcel.writeInt(this.poR);
        parcel.writeString(this.poS);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.lCU);
        parcel.writeString(this.poT);
        parcel.writeString(this.poU);
        parcel.writeString(this.poV);
        parcel.writeInt(this.poW);
        parcel.writeInt(this.poX ? 1 : 0);
        parcel.writeString(this.poY);
        parcel.writeString(this.ixy);
        parcel.writeLong(this.poZ);
        parcel.writeString(this.ppa);
        parcel.writeTypedList(this.ppf);
        parcel.writeString(this.ppb);
        parcel.writeInt(this.ppd);
        parcel.writeString(this.ppe);
        parcel.writeParcelable(this.ppk, 1);
        parcel.writeInt(this.ppn);
        parcel.writeInt(this.ppo);
        parcel.writeInt(this.pps);
    }
}
