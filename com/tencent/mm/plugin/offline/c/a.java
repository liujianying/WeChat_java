package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.bk.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.offline.h;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import d.a.a.c;
import d.a.a.e;
import d.a.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static String htC = "";
    private static String lMG = "";
    public static String lMH = "";
    public static int lMI = 1;
    public static String lMJ = "";
    public static String lMK = "";
    public static String lML = "";
    public static int lMM = 1;
    public static int lMN = 0;
    public static long lMO = 0;
    public static boolean lMP = false;
    public static String lMQ = "";
    public static String lMR = "";
    private static Comparator<Bankcard> lMS = new Comparator<Bankcard>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Bankcard) obj).field_bindSerial.compareToIgnoreCase(((Bankcard) obj2).field_bindSerial);
        }
    };
    private static Comparator<a> lMT = new 6();

    public static class a {
        public int lMU;
        public String lMV;
        public String lMW;
        public String lMX;
    }

    public static boolean bly() {
        k.bkO();
        String uk = k.uk(196630);
        return uk != null && uk.equals("1");
    }

    public static boolean blz() {
        k.bkO();
        String uk = k.uk(196641);
        return uk != null && uk.equals("1");
    }

    public static Bankcard blA() {
        Bankcard bankcard;
        Object blI = blI();
        x.i("MicroMsg.WalletOfflineUtil", "step 1 getSelectedBindBankCard %s", new Object[]{blI});
        List jt = o.bOW().jt(true);
        int i = 0;
        while (!TextUtils.isEmpty(blI) && i < jt.size()) {
            bankcard = (Bankcard) jt.get(i);
            if (bankcard != null && blI.equals(bankcard.field_bindSerial)) {
                x.i("MicroMsg.WalletOfflineUtil", "step 2 micropay: %s, forbidword: %s", new Object[]{Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord});
                if (bankcard.field_support_micropay) {
                    return bankcard;
                }
            }
            i++;
        }
        x.i("MicroMsg.WalletOfflineUtil", "step 3 clear default bindserial");
        Ja("");
        bankcard = blC();
        if (bankcard == null || !bi.oW(bankcard.field_forbidWord)) {
            i = 0;
            while (i < jt.size()) {
                bankcard = (Bankcard) jt.get(i);
                if (bankcard == null || !bankcard.field_support_micropay || bankcard.bOs()) {
                    i++;
                } else {
                    x.i("MicroMsg.WalletOfflineUtil", "do change first card: %s", new Object[]{bankcard.field_bankcardType});
                    return bankcard;
                }
            }
            bankcard = o.bOW().paw;
            if (bankcard == null || !bankcard.field_support_micropay) {
                bankcard = o.bOW().prG;
                if (bankcard == null || !bankcard.field_support_micropay || !bi.oW(bankcard.field_forbidWord)) {
                    return null;
                }
                x.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
                return bankcard;
            }
            x.i("MicroMsg.WalletOfflineUtil", "do change balance: %s", new Object[]{bankcard.field_bankcardType});
            return bankcard;
        }
        x.i("MicroMsg.WalletOfflineUtil", "do change main card: %s", new Object[]{bankcard.field_bankcardType});
        return bankcard;
    }

    public static Bankcard blB() {
        Bankcard blA = blA();
        if (blA != null && blA.field_support_micropay && bi.oW(blA.field_forbidWord)) {
            return blA;
        }
        List jl = o.bOW().jl(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jl.size()) {
                return null;
            }
            blA = (Bankcard) jl.get(i2);
            if (blA != null && blA.field_support_micropay) {
                return blA;
            }
            i = i2 + 1;
        }
    }

    public static Bankcard blC() {
        Bankcard a = o.bOW().a(null, null, true, true);
        if (a == null) {
            x.e("MicroMsg.WalletOfflineUtil", "defaultBankcards == null");
        }
        return a;
    }

    public static int blD() {
        return o.bOW().jl(true).size();
    }

    public static List<Bankcard> gY(boolean z) {
        List<Bankcard> arrayList = new ArrayList();
        List jl = o.bOW().jl(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jl.size()) {
                Bankcard bankcard = (Bankcard) jl.get(i2);
                if (z) {
                    arrayList.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
                i = i2 + 1;
            } else {
                x.i("MicroMsg.WalletOfflineUtil", "getBindBankCardList() list size is " + arrayList.size());
                return arrayList;
            }
        }
    }

    public static List<Bankcard> blE() {
        List<Bankcard> arrayList = new ArrayList();
        List jt = o.bOW().jt(true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jt.size()) {
                arrayList.add((Bankcard) jt.get(i2));
                i = i2 + 1;
            } else {
                x.i("MicroMsg.WalletOfflineUtil", "getOfflineBindBankCardList() list size is " + arrayList.size());
                return arrayList;
            }
        }
    }

    public static int blF() {
        k.bkO();
        String uk = k.uk(196629);
        if (TextUtils.isEmpty(uk) || !xW(uk)) {
            return 0;
        }
        return Integer.valueOf(uk).intValue();
    }

    public static void uo(int i) {
        k.bkO();
        k.aw(196640, String.valueOf(i));
    }

    public static void up(int i) {
        k.bkO();
        k.aw(196642, String.valueOf(i));
    }

    public static String blG() {
        k.bkO();
        return k.uk(196632);
    }

    public static String blH() {
        k.bkO();
        return k.uk(196631);
    }

    public static void IZ(String str) {
        k.bkO();
        k.aw(196631, str);
    }

    public static void dY(Context context) {
        String chP = w.chP();
        if ("zh_CN".equals(chP)) {
            chP = context.getString(i.url_wallet_offline_user_guide_url);
        } else if ("zh_TW".equals(chP)) {
            chP = context.getString(i.url_wallet_offline_user_guide_url_tw);
        } else if ("zh_HK".equals(chP)) {
            chP = context.getString(i.url_wallet_offline_user_guide_url_hk);
        } else {
            chP = context.getResources().getString(i.url_wallet_offline_user_guide_url_en);
        }
        aC(context, chP);
    }

    private static void aC(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static boolean xW(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String blI() {
        k.bkO();
        return k.uk(196633);
    }

    public static void Ja(String str) {
        x.i("MicroMsg.WalletOfflineUtil", "setSelectBindSerial %s %s", new Object[]{str, bi.cjd().toString()});
        k.bkO();
        k.aw(196633, str);
    }

    public static void blJ() {
        x.i("MicroMsg.WalletOfflineUtil", "clear offline data");
        k.bkO();
        k.aw(196630, "0");
        k.bkO();
        k.aw(196626, "");
        k.bkO();
        k.aw(196627, "");
        k.bkO();
        k.aw(196628, "");
        k.bkO();
        k.aw(196617, "");
        k.bkO();
        k.aw(196632, "");
        k.bkO();
        k.aw(196641, "");
        k.bkO();
        k.aw(196647, "");
        k.bkO();
        k.aw(196649, "");
        n("", "", "", "");
        k.bkO();
        k.aw(196629, "0");
        IZ("");
        k.bkO();
        k.bkP().lKw = null;
        k.bkO();
        k.bkR();
        k.bkO();
        String uk = k.uk(196617);
        com.tencent.mm.wallet_core.c.a.cCW();
        com.tencent.mm.wallet_core.c.a.clearToken(uk);
        Je("");
        Jb("");
    }

    public static void a(Activity activity, f fVar) {
        x.i("MicroMsg.WalletOfflineUtil", "hy: whole pay msg coming. direct parse");
        if (fVar == null || fVar.lKL == null) {
            x.e("MicroMsg.WalletOfflineUtil", "order == null");
        } else if (blz()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_orders", fVar.lKL);
            bundle.putInt("key_pay_type", 2);
            if (fVar.ceB != null) {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(fVar.ceB.ced, fVar.ceB.cee, fVar.ceB.cef, fVar.ceB.ceg, fVar.ceB.ceh, 8);
                bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static Orders H(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Orders orders = new Orders();
        Commodity commodity = new Commodity();
        commodity.lNH = (String) map.get(".sysmsg.paymsg.user_roll.buy_uin");
        commodity.lNI = (String) map.get(".sysmsg.paymsg.user_roll.buy_name");
        commodity.lNJ = (String) map.get(".sysmsg.paymsg.user_roll.sale_uin");
        commodity.lNK = (String) map.get(".sysmsg.paymsg.user_roll.sale_name");
        commodity.bOe = (String) map.get(".sysmsg.paymsg.user_roll.trans_id");
        commodity.desc = (String) map.get(".sysmsg.paymsg.user_roll.goods_name");
        commodity.hUL = ((double) bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.pay_num"), -1)) / 100.0d;
        commodity.lNO = (String) map.get(".sysmsg.paymsg.user_roll.trade_state");
        commodity.lNP = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        commodity.lNT = (String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name");
        commodity.lOa = (String) map.get(".sysmsg.paymsg.user_roll.discount");
        commodity.lNR = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.modify_timestamp"), 0);
        commodity.lNV = (String) map.get(".sysmsg.paymsg.user_roll.fee_type");
        commodity.lNW = (String) map.get(".sysmsg.paymsg.user_roll.appusername");
        commodity.lNy = (String) map.get(".sysmsg.paymsg.user_roll.app_telephone");
        commodity.ppw = ((double) bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.buy_bank_name"), -1)) / 100.0d;
        Promotions promotions = new Promotions();
        promotions.name = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.nickname");
        promotions.lNW = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.username");
        promotions.type = Orders.ppu;
        commodity.ppx = promotions.lNW;
        promotions.lRX = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.logo_round_url");
        promotions.url = (String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.subscribe_biz_url");
        int i = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.subscribe_biz_info.recommend_level"), 1);
        commodity.poW = i;
        commodity.ppA = (String) map.get(".sysmsg.paymsg.user_roll.rateinfo");
        commodity.ppB = (String) map.get(".sysmsg.paymsg.user_roll.discount_rateinfo");
        commodity.ppC = (String) map.get(".sysmsg.paymsg.user_roll.original_feeinfo");
        if (!bi.oW(promotions.name)) {
            commodity.ppG = true;
            commodity.ppF.add(promotions);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 255) {
                break;
            }
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            Promotions promotions2 = new Promotions();
            if (i3 == 0) {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record.query_award_status_params");
            } else {
                str = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".icon");
                str2 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".wording");
                str3 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".url");
                str4 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".btn_text");
                str5 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".type");
                str6 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".title");
                str7 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_type");
                str8 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_id");
                str9 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".send_record_id");
                str10 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".award_id");
                str11 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".user_record_id");
                str12 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".small_title");
                str13 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_username");
                str14 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_path");
                str15 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_mch_id");
                str16 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".activity_tinyapp_version");
                str17 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".get_award_params");
                str18 = (String) map.get(".sysmsg.paymsg.user_roll.activity_info.record" + i3 + ".query_award_status_params");
            }
            if (bi.oW(str2)) {
                x.i("MicroMsg.WalletOfflineUtil", "hy: activity end. total size: %d", new Object[]{Integer.valueOf(i3 + 1)});
                break;
            }
            promotions2.lRX = str;
            promotions2.name = str2;
            promotions2.url = str3;
            promotions2.poG = str4;
            promotions2.type = Orders.ppv;
            promotions2.ppS = bi.getInt(str5, 0);
            promotions2.title = str6;
            promotions2.ppT = bi.getInt(str7, 0);
            promotions2.pji = bi.getLong(str8, 0);
            promotions2.poD = bi.getInt(str9, 0);
            promotions2.ppU = bi.getInt(str10, 0);
            promotions2.poE = bi.getInt(str11, 0);
            promotions2.ppV = str12;
            promotions2.ppW = str13;
            promotions2.ppX = str14;
            promotions2.poF = bi.getLong(str15, 0);
            promotions2.ppY = bi.getInt(str16, 0);
            promotions2.ppZ = str17;
            promotions2.pqa = str18;
            c b = b(map, i3);
            if (b != null) {
                promotions2.pqb = b;
            }
            commodity.ppF.add(promotions2);
            i2 = i3 + 1;
        }
        str = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.text");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.link_ativity_info.url");
        commodity.ppH.text = str;
        commodity.ppH.url = str2;
        str = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_name");
        str2 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_logo");
        str3 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_desc");
        str4 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_username");
        str5 = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_path");
        if (!(bi.oW(str) || bi.oW(str2) || bi.oW(str3) || bi.oW(str4))) {
            commodity.ppD = new RecommendTinyAppInfo();
            commodity.ppD.poI = str;
            commodity.ppD.poJ = str2;
            commodity.ppD.poK = str3;
            commodity.ppD.paD = str4;
            commodity.ppD.paE = str5;
            commodity.ppD.poL = (String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_tinyapp_btn_text");
            commodity.ppD.pqc = bi.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_id"), 0);
            commodity.ppD.pqd = bi.getLong((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_type"), 0);
            commodity.ppD.pqf = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.send_record_id"), 0);
            commodity.ppD.pqg = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.user_record_id"), 0);
            commodity.ppD.pqh = (long) bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.activity_mch_id"), 0);
            commodity.ppD.pqe = (long) bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.award_id"), 0);
            commodity.ppD.poM = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.tinyapp_info.tinyapp_version"), 0);
        }
        orders.ppf = new ArrayList();
        orders.ppf.add(commodity);
        orders.ppp = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_new_paid_succ_page"), 0);
        orders.ppq = (String) map.get(".sysmsg.paymsg.user_roll.pay_succ_btn_wording");
        orders.poY = (String) map.get(".sysmsg.paymsg.user_roll.trade_state_name");
        orders.poW = i;
        orders.bOd = (String) map.get(".sysmsg.req_key");
        a(orders, (Map) map);
        commodity.ppw = bi.getDouble((String) map.get(".sysmsg.paymsg.user_roll.original_total_fee"), -1.0d) / 100.0d;
        if (TextUtils.isEmpty((String) map.get(".sysmsg.paymsg.user_roll.discount_array.record.favor_desc"))) {
            x.e("MicroMsg.WalletOfflineUtil", ".sysmsg.paymsg.user_roll.discount_array.record.favor_desc value is empty");
        } else {
            int i4 = 0;
            while (true) {
                if (i4 == 0) {
                    str = "";
                } else {
                    str = String.valueOf(i4);
                }
                str3 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".favor_desc";
                str4 = ".sysmsg.paymsg.user_roll.discount_array.record" + str + ".payment_amount";
                if (TextUtils.isEmpty((CharSequence) map.get(str3)) || TextUtils.isEmpty((CharSequence) map.get(str4))) {
                    x.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
                } else {
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.mwP = (String) map.get(str3);
                    discountInfo.ppR = bi.getDouble((String) map.get(str4), 0.0d);
                    commodity.ppz.add(discountInfo);
                    i4++;
                }
            }
            x.e("MicroMsg.WalletOfflineUtil", "favor_desc_key is " + str3 + ", payment_amount_key is " + str4 + ", break");
        }
        return orders;
    }

    private static c b(Map<String, String> map, int i) {
        String str;
        if (i == 0) {
            str = ".sysmsg.paymsg.user_roll.activity_info.record.exposure_info.";
        } else {
            str = ".sysmsg.paymsg.user_roll.activity_info.record" + i + ".exposure_info.";
        }
        if (map == null) {
            return null;
        }
        String str2;
        c cVar = new c();
        cVar.vGZ = bi.getInt((String) map.get(str + "is_query_others"), 0);
        cVar.rvZ = (String) map.get(str + "draw_lottery_params");
        cVar.rxT = bi.getInt((String) map.get(str + "is_show_btn"), 0);
        d.a.a.a aVar = new d.a.a.a();
        String str3 = str + "btn_info.";
        aVar.vGR = (String) map.get(str3 + "btn_words");
        aVar.vGS = (String) map.get(str3 + "btn_color");
        aVar.vGT = bi.getInt((String) map.get(str3 + "btn_op_type"), 0);
        aVar.url = (String) map.get(str3 + SlookSmartClipMetaTag.TAG_TYPE_URL);
        aVar.rJm = (String) map.get(str3 + "get_lottery_params");
        str3 = str3 + "mini_app_info.";
        aVar.vGU = new d.a.a.f();
        aVar.vGU.sbY = (String) map.get(str3 + "activity_tinyapp_username");
        aVar.vGU.sbZ = (String) map.get(str3 + "activity_tinyapp_path");
        aVar.vGU.sca = bi.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
        if (!(bi.oW(aVar.vGR) && bi.oW(aVar.url) && bi.oW(aVar.rJm) && bi.oW(aVar.vGU.sbY) && bi.oW(aVar.vGU.sbZ))) {
            cVar.rxU = aVar;
        }
        cVar.vHa = bi.getInt((String) map.get(str + "user_opertaion_type"), 0);
        cVar.vHb = bi.getInt((String) map.get(str + "is_show_layer"), 0);
        cVar.vHd = (String) map.get(str + "background_img_whole");
        cVar.rxS = new LinkedList();
        for (int i2 = 0; i2 < WebView.NORMAL_MODE_ALPHA; i2++) {
            if (i2 == 0) {
                str2 = str + "single_exposure_info_list.record.";
            } else {
                str2 = str + "single_exposure_info_list.record" + i2 + ".";
            }
            g gVar = new g();
            gVar.lRX = (String) map.get(str2 + "logo");
            gVar.vHo = (String) map.get(str2 + "award_name");
            gVar.vHp = (String) map.get(str2 + "award_description");
            gVar.vHq = (String) map.get(str2 + "background_img");
            gVar.vHr = (String) map.get(str2 + "award_name_color");
            gVar.vHs = (String) map.get(str2 + "award_description_color");
            if (!(bi.oW(gVar.lRX) && bi.oW(gVar.vHo) && bi.oW(gVar.vHp) && bi.oW(gVar.vHq) && bi.oW(gVar.vHr) && bi.oW(gVar.vHs))) {
                cVar.rxS.add(gVar);
            }
            if (bi.oW(gVar.vHo) || bi.oW(gVar.vHp)) {
                break;
            }
        }
        cVar.vHc = new e();
        str2 = str + "layer_info.";
        cVar.vHc.vHf = (String) map.get(str2 + "layer_title");
        cVar.vHc.vHg = (String) map.get(str2 + "layer_logo");
        cVar.vHc.vHh = (String) map.get(str2 + "layer_type");
        cVar.vHc.vHi = (String) map.get(str2 + "layer_name");
        cVar.vHc.vHj = (String) map.get(str2 + "layer_description");
        cVar.vHc.vHk = bi.getInt((String) map.get(str2 + "is_show_layer_btn"), 0);
        cVar.vHc.vHl = new d.a.a.d();
        str3 = str2 + "layer_btn_info.";
        cVar.vHc.vHl.vGR = (String) map.get(str3 + "btn_words");
        cVar.vHc.vHl.vGS = (String) map.get(str3 + "btn_color");
        cVar.vHc.vHl.vGT = bi.getInt((String) map.get(str3 + "btn_op_type"), 0);
        cVar.vHc.vHl.rJm = (String) map.get(str3 + "get_lottery_params");
        cVar.vHc.vHl.url = (String) map.get(str3 + SlookSmartClipMetaTag.TAG_TYPE_URL);
        str3 = str3 + "mini_app_info.";
        cVar.vHc.vHl.vGU = new d.a.a.f();
        cVar.vHc.vHl.vGU.sbY = (String) map.get(str3 + "activity_tinyapp_username");
        cVar.vHc.vHl.vGU.sbZ = (String) map.get(str3 + "activity_tinyapp_path");
        cVar.vHc.vHl.vGU.sca = bi.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
        if (!bi.oW((String) map.get(str2 + "voice_url"))) {
            cVar.vHc.vHm = new b(((String) map.get(str2 + "voice_url")).getBytes());
        }
        if (!bi.oW((String) map.get(str2 + "voice_data"))) {
            cVar.vHc.vHn = new b(((String) map.get(str2 + "voice_data")).getBytes());
        }
        d.a.a.b bVar = new d.a.a.b();
        str3 = str + "draw_lottery_info.";
        bVar.url = (String) map.get(str3 + SlookSmartClipMetaTag.TAG_TYPE_URL);
        bVar.vGV = (String) map.get(str3 + "animation_wording");
        bVar.vGW = (String) map.get(str3 + "animation_wording_color");
        bVar.srY = bi.getInt((String) map.get(str3 + "op_type"), 0);
        bVar.vGX = (String) map.get(str3 + "after_animation_wording");
        bVar.vGY = (String) map.get(str3 + "after_animation_wording_color");
        str3 = str3 + "mini_app_info.";
        bVar.vGU = new d.a.a.f();
        bVar.vGU.sbY = (String) map.get(str3 + "activity_tinyapp_username");
        bVar.vGU.sbZ = (String) map.get(str3 + "activity_tinyapp_path");
        bVar.vGU.sca = bi.getInt((String) map.get(str3 + "activity_tinyapp_version"), 0);
        if (!(bi.oW(bVar.url) && bi.oW(bVar.vGV) && bi.oW(bVar.vGW) && bi.oW(bVar.vGU.sbY) && bi.oW(bVar.vGU.sbZ))) {
            cVar.vHe = bVar;
        }
        return cVar;
    }

    private static void a(Orders orders, Map<String, String> map) {
        if (map != null) {
            orders.ppr = bi.getInt((String) map.get(".sysmsg.paymsg.user_roll.is_use_show_info"), 0);
            String str = ".sysmsg.paymsg.user_roll.show_info.record.";
            orders.ppt = new ArrayList();
            for (int i = 0; i < WebView.NORMAL_MODE_ALPHA; i++) {
                String str2;
                if (i == 0) {
                    str2 = str;
                } else {
                    str2 = str + i + ".";
                }
                ShowInfo showInfo = new ShowInfo();
                showInfo.name = (String) map.get(str2 + "name");
                showInfo.value = (String) map.get(str2 + "value");
                showInfo.jLs = (String) map.get(str2 + "name_color");
                showInfo.pqk = (String) map.get(str2 + "value_color");
                str2 = str2 + "value_attr.";
                showInfo.pql = bi.getInt((String) map.get(str2 + "link_type"), 0);
                showInfo.pqm = (String) map.get(str2 + "link_weapp");
                showInfo.pqn = (String) map.get(str2 + "link_addr");
                showInfo.pqo = (String) map.get(str2 + "link_url");
                showInfo.pqp = bi.getInt((String) map.get(str2 + "text_attr"), 0);
                if (!bi.oW(showInfo.name) || !bi.oW(showInfo.value)) {
                    orders.ppt.add(showInfo);
                }
            }
        }
    }

    public static void a(Activity activity, String str, l lVar) {
        x.i("MicroMsg.WalletOfflineUtil", "hy: only transid coming. do old way");
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.WalletOfflineUtil", "transid == null");
        } else if (blz()) {
            Bundle bundle = new Bundle();
            if (lVar instanceof com.tencent.mm.plugin.offline.a.e) {
                Parcelable parcelable = ((com.tencent.mm.plugin.offline.a.e) lVar).lJN;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
            }
            bundle.putString("key_trans_id", str);
            bundle.putInt("key_pay_type", 2);
            if (activity instanceof WalletOfflineCoinPurseUI) {
                Intent intent = activity.getIntent();
                bundle.putString("key_appid", intent.getStringExtra("key_appid"));
                bundle.putInt("key_from_scene", intent.getIntExtra("key_from_scene", 0));
            }
            com.tencent.mm.wallet_core.a.a(activity, j.class, bundle);
        }
    }

    public static void e(Activity activity, int i) {
        a(activity, i, -1);
    }

    public static void a(Activity activity, int i, int i2) {
        PayInfo payInfo = new PayInfo();
        payInfo.bVZ = 5;
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 5);
        bundle.putInt("key_offline_add_fee", i);
        if (i2 >= 0) {
            bundle.putInt("key_entry_scene", i2);
        }
        if (!o.bOW().bPs()) {
            if (o.bOW().bPp()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            } else if (o.bOW().bPt()) {
                bundle.putBoolean("key_is_bind_bankcard", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.d.class, bundle);
                return;
            }
        }
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.offline.c.class, bundle);
    }

    public static void f(Activity activity, int i) {
        a(activity, "create", activity.getString(i.wallet_wx_offline_create_offline), 0, i);
    }

    private static void a(Activity activity, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("oper", str);
        bundle.putInt("offline_chg_fee", i);
        bundle.putString("pwd_tips", str2);
        if (i2 >= 0) {
            bundle.putInt("offline_from_scene", i2);
        }
        com.tencent.mm.wallet_core.a.a(activity, h.class, bundle);
    }

    public static void A(Activity activity) {
        a(activity, "freeze", activity.getString(i.wallet_wx_offline_freeze_content), 0, -1);
    }

    public static void B(Activity activity) {
        g(activity, -1);
    }

    public static void g(Activity activity, int i) {
        String str = "create";
        String str2 = "";
        k.bkO();
        String uk = k.uk(196640);
        int intValue = (TextUtils.isEmpty(uk) || !xW(uk)) ? 0 : Integer.valueOf(uk).intValue();
        a(activity, str, str2, intValue > 0 ? intValue * 100 : 20000, i);
    }

    public static void c(final Activity activity, String str) {
        com.tencent.mm.ui.base.h.a((Context) activity, false, str, "", activity.getString(i.wallet_wx_offline_recreate_offline_text), activity.getString(i.app_cancel), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.blJ();
                a.B(activity);
                activity.finish();
            }
        }, new 2(activity));
    }

    public static void blK() {
        k.bkO();
        k.aw(196643, "1");
    }

    public static void uq(int i) {
        k.bkO();
        k.aw(196644, String.valueOf(i));
    }

    public static int blL() {
        k.bkO();
        String uk = k.uk(196644);
        if (TextUtils.isEmpty(uk) || !xW(uk)) {
            return 0;
        }
        return Integer.valueOf(uk).intValue();
    }

    public static String blM() {
        if (!TextUtils.isEmpty(lMG)) {
            return lMG;
        }
        blP();
        if (TextUtils.isEmpty(lMG)) {
            x.e("MicroMsg.WalletOfflineUtil", "token is null");
        }
        return lMG;
    }

    public static void n(String str, String str2, String str3, String str4) {
        lMG = str;
        lMH = str2;
        lMJ = str3;
        lMK = str4;
        Jb(lMJ);
        com.tencent.mm.kernel.g.Eh().dpP.a(new bg(new 3()), 0);
    }

    public static String blN() {
        if (!TextUtils.isEmpty(lMH)) {
            return lMH;
        }
        blP();
        if (TextUtils.isEmpty(lMH)) {
            x.e("MicroMsg.WalletOfflineUtil", "offline_token_v2 is null");
        }
        return lMH;
    }

    public static String blO() {
        if (!TextUtils.isEmpty(lMJ)) {
            return lMJ;
        }
        if (TextUtils.isEmpty(lMJ)) {
            k.bkO();
            String uk = k.uk(196656);
            lMJ = uk;
            return uk;
        }
        if (TextUtils.isEmpty(lMJ)) {
            x.e("MicroMsg.WalletOfflineUtil", "offline_card_list is null");
        }
        return lMJ;
    }

    public static void Jb(String str) {
        k.bkO();
        k.aw(196656, str);
        lMJ = str;
    }

    private static void blP() {
        com.tencent.mm.kernel.g.Eh().dpP.a(new bg(new 4()), 0);
    }

    public static LinkedList<a> Jc(String str) {
        LinkedList<a> linkedList = null;
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        try {
            return n(new JSONArray(str));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            return linkedList;
        }
    }

    private static LinkedList<a> n(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                a aVar = new a();
                aVar.lMU = jSONObject.optInt("card_id");
                aVar.lMV = jSONObject.optString("bank_type");
                aVar.lMW = jSONObject.optString("bind_serial");
                aVar.lMX = jSONObject.optString("forbid_word");
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public static String blQ() {
        k.bkO();
        return k.uk(196647);
    }

    private static String blR() {
        k.bkO();
        return k.uk(196616);
    }

    public static void Jd(String str) {
        k.bkO();
        k.aw(196616, str);
    }

    public static void C(Activity activity) {
        com.tencent.mm.ui.base.h.bA(activity, activity.getResources().getString(i.wallet_wx_offline_create_success));
        if (!TextUtils.isEmpty(blR())) {
            aC(activity, blR());
        }
    }

    public static boolean blS() {
        int i = 0;
        List jl = o.bOW().jl(true);
        LinkedList Jc = Jc(blO());
        if (Jc == null || jl.size() != Jc.size()) {
            return false;
        }
        Collections.sort(Jc, lMT);
        Collections.sort(jl, lMS);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < Jc.size(); i2++) {
            stringBuilder.append(((a) Jc.get(i2)).lMW);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (i < jl.size()) {
            stringBuilder2.append(((Bankcard) jl.get(i)).field_bindSerial);
            i++;
        }
        return ac.ce(stringBuilder.toString()).equals(ac.ce(stringBuilder2.toString()));
    }

    private static String blT() {
        if (!TextUtils.isEmpty(lML)) {
            return lML;
        }
        k.bkO();
        String uk = k.uk(196615);
        lML = uk;
        return uk;
    }

    public static void Je(String str) {
        k.bkO();
        k.aw(196615, str);
        lML = str;
    }

    private static LinkedList<b> Jf(String str) {
        LinkedList<b> linkedList = null;
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        try {
            return o(new JSONArray(str));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletOfflineUtil", e, "", new Object[0]);
            return linkedList;
        }
    }

    private static LinkedList<b> o(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                b bVar = new b();
                bVar.lMV = jSONObject.optString("bank_type");
                bVar.lMY = jSONObject.optString("icon_url");
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }

    public static int blU() {
        k.bkO();
        String uk = k.uk(196649);
        if (TextUtils.isEmpty(uk) || !xW(uk)) {
            return 0;
        }
        return Integer.valueOf(uk).intValue();
    }

    public static boolean blV() {
        Object blG = blG();
        if (TextUtils.isEmpty(blG)) {
            return false;
        }
        if ((System.currentTimeMillis() / 1000) - Long.valueOf(blG).longValue() >= ((long) blU())) {
            return true;
        }
        return false;
    }

    public static String Jg(String str) {
        LinkedList Jf = Jf(blT());
        if (Jf == null) {
            return "";
        }
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Jf.size()) {
                return str2;
            }
            b bVar = (b) Jf.get(i2);
            if (bVar != null && str.equals(bVar.lMV)) {
                return bVar.lMY;
            }
            i = i2 + 1;
        }
    }

    public static String Jh(String str) {
        int i = 0;
        LinkedList Jc = Jc(blO());
        LinkedList Jf = Jf(blT());
        if (Jc == null || Jf == null || Jc.size() == 0 || Jf.size() == 0) {
            x.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() cardList == null || cardLogoList == null || cardList.size() == 0 || cardLogoList.size() == 0");
            return "";
        }
        Object obj;
        String str2 = "";
        for (int i2 = 0; i2 < Jc.size(); i2++) {
            a aVar = (a) Jc.get(i2);
            if (aVar != null && str.equals(aVar.lMW)) {
                obj = aVar.lMV;
                break;
            }
        }
        String obj2 = str2;
        if (TextUtils.isEmpty(obj2)) {
            x.e("MicroMsg.WalletOfflineUtil", "getBankLogoUrl() bank_type == null, can not find this bank_type");
            return "";
        }
        str2 = "";
        while (i < Jf.size()) {
            b bVar = (b) Jf.get(i);
            if (bVar != null && obj2.equals(bVar.lMV)) {
                return bVar.lMY;
            }
            i++;
        }
        return str2;
    }

    public static boolean dE(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.WalletOfflineUtil", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.WalletOfflineUtil", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.WalletOfflineUtil", "is in foreGround.");
        return true;
    }

    public static void Ji(String str) {
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sXm, str);
    }

    public static String blW() {
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sXm, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void Jj(String str) {
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sXX, str);
    }

    public static String blX() {
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sXX, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static void ur(int i) {
        if (i < 0) {
            i = 0;
        }
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sXY, Integer.valueOf(i));
    }

    public static int blY() {
        int intValue;
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sXY, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
        } else {
            intValue = 0;
        }
        if (intValue < 0) {
            return 0;
        }
        return intValue;
    }

    public static void Jk(String str) {
        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sXZ, str);
    }

    public static String blZ() {
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(com.tencent.mm.storage.aa.a.sXZ, "");
        if (obj != null) {
            return (String) obj;
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        if (!ao.isConnected(context)) {
            return -1;
        }
        if (ao.isWifi(context)) {
            return 1;
        }
        if (ao.is2G(context)) {
            return 2;
        }
        if (ao.is3G(context)) {
            return 3;
        }
        if (ao.is4G(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean bma() {
        Map ckq;
        boolean z = false;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100232");
        if (fJ.isValid()) {
            ckq = fJ.ckq();
            if (ckq.containsKey("open") && "1".equals(ckq.get("open"))) {
                x.e("MicroMsg.WalletOfflineUtil", "deprecated abtest 100232 enabled.");
            }
        }
        fJ = com.tencent.mm.model.c.c.Jx().fJ("100261");
        if (fJ.isValid()) {
            ckq = fJ.ckq();
            if (ckq.containsKey("open") && "1".equals(ckq.get("open"))) {
                z = true;
            }
        }
        x.i("MicroMsg.WalletOfflineUtil", "isPosEnabled: " + z);
        return z;
    }

    public static void Jl(String str) {
        x.i("MicroMsg.WalletOfflineUtil", "launch 3rd app: %s", new Object[]{str});
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
        if (bl == null) {
            x.w("MicroMsg.WalletOfflineUtil", "can not find app info");
            return;
        }
        Bundle bundle = new Bundle();
        Resp resp = new Resp();
        resp.errCode = 0;
        resp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = bl.field_packageName;
        args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(ad.getContext(), args);
    }
}
