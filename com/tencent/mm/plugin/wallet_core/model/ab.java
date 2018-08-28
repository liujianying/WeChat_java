package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab {
    public static void a(JSONObject jSONObject, int i) {
        x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard()");
        try {
            af afVar;
            JSONObject optJSONObject;
            Object obj;
            Bankcard bankcard;
            JSONObject optJSONObject2;
            Bankcard bankcard2;
            Object aG;
            k kVar;
            Bankcard bankcard3;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                o.setTimeStamp(String.valueOf(optLong));
            } else {
                x.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
            af afVar2 = new af();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
                afVar = null;
            } else {
                afVar2.field_is_reg = jSONObject2.getInt("is_reg");
                afVar2.field_true_name = jSONObject2.optString("true_name");
                afVar2.field_cre_type = jSONObject2.optInt("cre_type", -1);
                afVar2.field_main_card_bind_serialno = jSONObject2.optString("last_card_bind_serialno");
                afVar2.field_cre_name = jSONObject2.optString("cre_name");
                afVar2.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                afVar2.field_reset_passwd_flag = jSONObject2.optString("reset_passwd_flag");
                afVar2.field_find_passwd_url = jSONObject2.optString("reset_passwd_url");
                o.bOW();
                ag.Pc(afVar2.field_main_card_bind_serialno);
                afVar2.field_isDomesticUser = "2".equals(jSONObject2.optString("icard_user_flag", "2"));
                optJSONObject = jSONObject2.optJSONObject("touch_info");
                if (optJSONObject != null) {
                    afVar2.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
                    x.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is " + afVar2.field_is_open_touch);
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
                    afVar2.field_is_open_touch = o.bOW().bPu() ? 1 : 0;
                    x.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + afVar2.field_is_open_touch);
                }
                afVar2.field_lct_wording = jSONObject2.optString("lct_wording");
                afVar2.field_lct_url = jSONObject2.optString("lct_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + afVar2.field_lct_wording + ", field_lct_url:" + afVar2.field_lct_url);
                afVar2.field_lqt_state = jSONObject2.optInt("lqt_state", -1);
                optJSONObject = jSONObject2.optJSONObject("lqb_show_info");
                x.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", new Object[]{Integer.valueOf(afVar2.field_lqt_state), optJSONObject});
                if (optJSONObject != null) {
                    afVar2.field_is_show_lqb = optJSONObject.optInt("is_show_lqb");
                    afVar2.field_is_open_lqb = optJSONObject.optInt("is_open_lqb");
                    afVar2.field_lqb_open_url = optJSONObject.optString("lqb_open_url");
                }
                optJSONObject = jSONObject2.optJSONObject("lqt_cell_info");
                x.i("MicroMsg.WalletQueryBankcardParser", "lqt_cell_info: %s", new Object[]{optJSONObject});
                if (optJSONObject != null) {
                    afVar2.field_lqt_cell_is_show = optJSONObject.optInt("is_show_cell");
                    afVar2.field_lqt_cell_icon = optJSONObject.optString("cell_icon");
                    afVar2.field_lqt_cell_is_open_lqt = optJSONObject.optInt("is_open_lqt");
                    afVar2.field_lqt_cell_lqt_open_url = optJSONObject.optString("lqt_open_url");
                    afVar2.field_lqt_cell_lqt_title = optJSONObject.optString("lqt_title");
                    afVar2.field_lqt_cell_lqt_wording = optJSONObject.optString("lqt_wording");
                }
                if (zm(i) || i == 3 || i == 4) {
                    g.Ek();
                    g.Ei().DT().a(a.sYw, Integer.valueOf(afVar2.field_lqt_state));
                    g.Ek();
                    g.Ei().DT().a(a.sYx, afVar2.field_lct_wording);
                }
                afVar = afVar2;
            }
            afVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            afVar.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            x.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", new Object[]{Integer.valueOf(afVar.field_paymenu_use_new)});
            String optString = jSONObject.optString("support_bank_word");
            g.Ek();
            g.Ei().DT().a(a.sPz, bi.oV(optString));
            ArrayList s = s(jSONObject.optJSONArray("Array"));
            ArrayList t = t(jSONObject.optJSONArray("virtual_card_array"));
            JSONObject optJSONObject3 = jSONObject.optJSONObject("balance_info");
            String str = "MicroMsg.WalletQueryBankcardParser";
            String str2 = "Bankcard getBalance %s";
            Object[] objArr = new Object[1];
            if (optJSONObject3 == null) {
                optString = "";
            } else {
                obj = optJSONObject3;
            }
            objArr[0] = optString;
            x.i(str, str2, objArr);
            if (optJSONObject3 == null || optJSONObject3.length() <= 0) {
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
                bankcard = null;
            } else {
                boolean z;
                Bankcard bankcard4 = new Bankcard((byte) 0);
                a(bankcard4, optJSONObject3.optLong("balance_version", -1), optJSONObject3.optLong("time_out", 7200), optJSONObject3.optInt("avail_balance"));
                bankcard4.plV = ((double) optJSONObject3.optInt("avail_balance")) / 100.0d;
                bankcard4.plW = optJSONObject3.optString("balance_show_wording");
                bankcard4.plZ = optJSONObject3.optString("max_fetch_wording");
                bankcard4.pma = optJSONObject3.optString("avail_fetch_wording");
                bankcard4.plX = ((double) optJSONObject3.optInt("fetch_balance")) / 100.0d;
                bankcard4.field_cardType |= Bankcard.plL;
                bankcard4.field_bankcardType = optJSONObject3.optString("balance_bank_type");
                bankcard4.field_bindSerial = optJSONObject3.optString("balance_bind_serial");
                bankcard4.field_forbidWord = optJSONObject3.optString("balance_forbid_word");
                if (bi.oW(bankcard4.field_forbidWord)) {
                    bankcard4.field_bankcardState = 0;
                } else {
                    bankcard4.field_bankcardState = 8;
                }
                bankcard4.field_fetchArriveTime = optJSONObject3.optLong("fetch_arrive_time");
                bankcard4.field_mobile = optJSONObject3.optString("mobile");
                if (optJSONObject3.optInt("support_micropay", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bankcard4.field_support_micropay = z;
                x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + optJSONObject3.optInt("support_micropay", 0));
                bankcard4.plY = optJSONObject3.optString("balance_list_url");
                optString = ad.getContext().getString(i.wallet_balance_bank_name);
                bankcard4.field_desc = optString;
                bankcard4.field_bankName = optString;
                bankcard4.field_bankcardTail = "10000";
                bankcard4.field_forbid_title = optJSONObject3.optString("forbid_title");
                bankcard4.field_forbid_url = optJSONObject3.optString("forbid_url");
                optJSONObject2 = optJSONObject3.optJSONObject("balance_menu_info");
                if (optJSONObject2 != null) {
                    x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", new Object[]{optJSONObject2.toString()});
                    g.Ei().DT().a(a.sZr, optString);
                } else {
                    g.Ei().DT().a(a.sZr, "");
                }
                bankcard = bankcard4;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", new Object[]{Integer.valueOf(jSONObject.optInt("query_cache_time"))});
            optJSONObject2 = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2.optJSONObject("bind_newcard_switch");
                optJSONObject.optInt("forbid_bind_card");
                optJSONObject.optString("forbid_word");
            }
            g bOA = g.bOA();
            bOA.pmR = optJSONObject2;
            try {
                if (bOA.pmR != null) {
                    optJSONObject2 = bOA.pmR.optJSONObject("bind_newcard_switch");
                    bOA.pmQ = optJSONObject2.optInt("forbid_bind_card");
                    bOA.lMX = optJSONObject2.optString("forbid_word");
                } else {
                    bOA.pmQ = 0;
                    bOA.lMX = "";
                }
            } catch (Throwable e) {
                bOA.pmQ = 0;
                bOA.lMX = "";
                x.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e, "", new Object[0]);
            }
            x.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", new Object[]{bOA.pmR, Integer.valueOf(bOA.pmQ), bOA.lMX});
            JSONArray optJSONArray = jSONObject.optJSONArray("history_card_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
                bankcard2 = null;
            } else {
                bankcard2 = d.bOx().ae(optJSONArray.getJSONObject(0));
                bankcard2.field_cardType |= Bankcard.plM;
            }
            optJSONArray = jSONObject.optJSONArray("balance_notice");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
            if (optJSONArray != null) {
                aG = bi.aG(optJSONArray.toString(), "");
            } else {
                str = "";
            }
            if (optJSONArray2 != null) {
                obj = bi.aG(optJSONArray2.toString(), "");
            } else {
                obj = "";
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", new Object[]{aG, obj});
            g.Ek();
            g.Ei().DT().a(a.sPx, aG);
            g.Ek();
            g.Ei().DT().a(a.sPy, obj);
            g.Ek();
            g.Ei().DT().lm(true);
            optJSONObject2 = jSONObject.optJSONObject("bank_priority");
            List linkedList = new LinkedList();
            if (optJSONObject2 != null) {
                try {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("bankinfo_array");
                    if (optJSONArray3 != null) {
                        int length = optJSONArray3.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c cVar = new c();
                            JSONObject jSONObject3 = optJSONArray3.getJSONObject(i2);
                            cVar.lMW = jSONObject3.optString("bind_serial");
                            cVar.plH = jSONObject3.optString("polling_forbid_word");
                            linkedList.add(cVar);
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
                }
            }
            jSONObject.optString("query_order_time");
            optJSONObject2 = jSONObject.optJSONObject("loan_entry_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
                kVar = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
                kVar = new k();
                kVar.field_title = optJSONObject2.optString("title");
                kVar.field_loan_jump_url = optJSONObject2.optString("loan_jump_url");
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + kVar.field_loan_jump_url);
                kVar.field_is_show_entry = optJSONObject2.optInt("is_show_entry", 0);
                kVar.field_tips = optJSONObject2.optString("tips");
                kVar.field_is_overdue = optJSONObject2.optInt("is_overdue", 0);
                if (optJSONObject2.has("available_otb")) {
                    kVar.field_available_otb = e.e(optJSONObject2.optDouble("available_otb") / 100.0d, "CNY");
                }
                if (optJSONObject2.has("index")) {
                    kVar.field_red_dot_index = optJSONObject2.optInt("index");
                }
                x.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + kVar.field_red_dot_index + "  field_is_overdue:" + kVar.field_is_overdue + "  field_is_show_entry:" + kVar.field_is_show_entry);
            }
            optJSONObject2 = jSONObject.optJSONObject("fetch_info");
            b bVar = o.bOW().prE;
            x.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", new Object[]{bVar});
            if (optJSONObject2 != null) {
                bVar = a(optJSONObject2, true);
            } else {
                x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            optJSONObject2 = jSONObject.optJSONObject("lqt_info");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
                bankcard3 = null;
            } else {
                x.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", new Object[]{optJSONObject2.toString()});
                bankcard3 = new Bankcard((byte) 0);
                bankcard3.field_bankcardType = optJSONObject2.optString("lqt_bank_type");
                bankcard3.field_bindSerial = optJSONObject2.optString("lqt_bind_serial");
                bankcard3.field_bankName = optJSONObject2.optString("lqt_bank_name");
                bankcard3.plV = ((double) optJSONObject2.optLong("total_balance")) / 100.0d;
                bankcard3.plX = ((double) optJSONObject2.optLong("avail_balance")) / 100.0d;
                bankcard3.pmc = new e();
                bankcard3.pmc.lCU = optJSONObject2.optString("lqt_logo_url");
                bankcard3.field_forbidWord = optJSONObject2.optString("lqt_forbid_word");
                bankcard3.field_forbid_title = optJSONObject2.optString("forbid_title");
                bankcard3.field_forbid_url = optJSONObject2.optString("forbid_url");
                bankcard3.plW = optJSONObject2.optString("lqt_show_wording");
                bankcard3.field_mobile = optJSONObject2.optString("mobile");
                bankcard3.field_support_micropay = optJSONObject2.optInt("support_micropay", 0) == 1;
                bankcard3.field_cardType |= Bankcard.plO;
                if (bi.oW(bankcard3.field_bankName)) {
                    bankcard3.field_bankName = ad.getContext().getString(i.wallet_lqt_title);
                }
                bankcard3.field_desc = bankcard3.field_bankName;
                if (bi.oW(bankcard3.field_forbidWord)) {
                    bankcard3.field_bankcardState = 0;
                } else {
                    bankcard3.field_bankcardState = 8;
                }
            }
            o.bOW().a(afVar, s, t, bankcard, bankcard2, kVar, bVar, bankcard3, r11, i, linkedList);
        } catch (Throwable e22) {
            x.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e22.getMessage());
            x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e22, "", new Object[0]);
        }
    }

    public static boolean zm(int i) {
        if (i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }

    public static Bankcard a(fa faVar) {
        x.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", new Object[]{faVar});
        Bankcard bankcard = null;
        if (faVar != null) {
            boolean z;
            bankcard = new Bankcard((byte) 0);
            a(bankcard, faVar.rfN, (long) faVar.rfO, bi.getInt(faVar.rfJ, 0));
            bankcard.plV = ((double) bi.getInt(faVar.rfJ, 0)) / 100.0d;
            bankcard.plW = faVar.plW;
            bankcard.plZ = faVar.plZ;
            bankcard.pma = faVar.pma;
            bankcard.plX = ((double) bi.getInt(faVar.rfL, 0)) / 100.0d;
            bankcard.field_cardType |= Bankcard.plL;
            bankcard.field_bankcardType = faVar.rfF;
            bankcard.field_bindSerial = faVar.rfG;
            bankcard.field_forbidWord = faVar.rfH;
            if (bi.oW(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 0;
            } else {
                bankcard.field_bankcardState = 8;
            }
            bankcard.field_mobile = faVar.bTi;
            if (bi.getInt(faVar.rfM, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            bankcard.field_support_micropay = z;
            x.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + faVar.rfM);
            bankcard.plY = faVar.plY;
            String string = ad.getContext().getString(i.wallet_balance_bank_name);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = faVar.rfQ;
            bankcard.field_forbid_url = faVar.rfR;
            fb fbVar = faVar.rfT;
            if (fbVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", fbVar.rfU);
                    List<fc> list = fbVar.rfV;
                    JSONArray jSONArray = new JSONArray();
                    for (fc fcVar : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", fcVar.title);
                        jSONObject2.put("jump_type", fcVar.paB);
                        jSONObject2.put("jump_h5_url", fcVar.paC);
                        jSONObject2.put("tinyapp_username", fcVar.paD);
                        jSONObject2.put("tinyapp_path", fcVar.paE);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", new Object[]{e.getMessage()});
                }
                x.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", new Object[]{jSONObject.toString()});
                g.Ei().DT().a(a.sZr, jSONObject.toString());
            } else {
                g.Ei().DT().a(a.sZr, "");
            }
        }
        return bankcard;
    }

    public static b a(JSONObject jSONObject, boolean z) {
        int i = 0;
        if (jSONObject == null) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            return null;
        }
        x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.plA = jSONObject.optString("fetch_charge_title");
        x.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.plA);
        if (z) {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.oZS = jSONObject.optInt("is_cal_charge", 0);
            bVar.oZR = jSONObject.optInt("is_show_charge", 0);
            bVar.oZT = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.oZU = jSONObject.optDouble("min_charge_fee", 0.0d) / 100.0d;
            bVar.mxI = jSONObject.optDouble("remain_fee", 0.0d) / 100.0d;
            bVar.plC = jSONObject.optString("card_list_wording_title", "");
            bVar.plD = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                bVar.plE = b.ad(jSONObject.optJSONObject("withdraw_sector"));
            }
            x.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.oZS + " is_show_charge:" + bVar.oZR + " min_charge_fee:" + bVar.oZU + " remain_fee:" + bVar.mxI + " is_full_fetch_direct:" + bVar.oZT);
        } else {
            x.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.plB = new LinkedList();
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    b bVar2 = new b();
                    bVar2.aAL = optJSONObject.optString("key");
                    bVar2.value = optJSONObject.optString(DownloadSettingTable$Columns.VALUE);
                    x.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + bVar2.aAL + " , feeItem.value is " + bVar2.value);
                    if (!(TextUtils.isEmpty(bVar2.aAL) || TextUtils.isEmpty(bVar2.value))) {
                        bVar.plB.add(bVar2);
                    }
                } else {
                    x.e("MicroMsg.WalletQueryBankcardParser", "item index " + i + " is empty");
                }
                i++;
            }
            x.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.plB.size());
        }
        return bVar;
    }

    private static void a(Bankcard bankcard, long j, long j2, int i) {
        e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new 1(j2, j, i, bankcard));
    }

    private static ArrayList<Bankcard> s(JSONArray jSONArray) {
        x.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()");
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Bankcard ae = d.bOx().ae(jSONArray.getJSONObject(i));
                if (ae != null) {
                    d.d(ae);
                    arrayList.add(ae);
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Bankcard> t(JSONArray jSONArray) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.plK;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.plR = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = ad.getContext().getString(i.wallet_wxcredit_card_desc, new Object[]{bankcard.field_bankName, bankcard.field_bankcardTail});
                bankcard.pmc = new e();
                bankcard.pmc.lCU = jSONObject.getString("logo_url");
                bankcard.pmc.pmn = jSONObject.getString("background_logo_url");
                bankcard.pmc.pmo = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }
}
