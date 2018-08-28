package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.protocal.c.sw;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> xN(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            return;
        }
        shareCardInfo.field_card_id = xP(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = xP(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.hwa = A(optJSONObject);
        shareCardInfo.hvZ = B(optJSONObject2);
        shareCardInfo.hwb = C(optJSONObject3);
        if (shareCardInfo.hwa != null) {
            shareCardInfo.a(shareCardInfo.hwa);
        }
        if (shareCardInfo.hvZ != null) {
            lf lfVar = shareCardInfo.hvZ;
            shareCardInfo.hvZ = lfVar;
            try {
                shareCardInfo.field_cardTpInfoData = lfVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.hwb != null) {
            bng bng = shareCardInfo.hwb;
            shareCardInfo.hwb = bng;
            try {
                shareCardInfo.field_shareInfoData = bng.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    public static ArrayList<CardInfo> xO(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            return;
        }
        cardInfo.field_card_id = xP(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = xP(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.huZ = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.hwa = A(optJSONObject);
        cardInfo.hvZ = B(optJSONObject2);
        cardInfo.hwb = C(optJSONObject3);
        if (cardInfo.hvZ != null) {
            lf lfVar = cardInfo.hvZ;
            cardInfo.hvZ = lfVar;
            try {
                cardInfo.field_cardTpInfoData = lfVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            cardInfo.field_block_mask = Integer.toString(cardInfo.hvZ.rnN);
            cardInfo.field_card_type = cardInfo.hvZ.huV;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.hvZ.huU;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.hvZ.rol != null) {
                cardInfo.field_is_dynamic = cardInfo.hvZ.rol.rwc;
            }
        }
        if (cardInfo.hwa != null) {
            cardInfo.a(cardInfo.hwa);
            cardInfo.field_status = cardInfo.hwa.status;
        }
        if (cardInfo.hwb != null) {
            bng bng = cardInfo.hwb;
            cardInfo.hwb = bng;
            try {
                cardInfo.field_shareInfoData = bng.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            }
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    private static String xP(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return "";
        }
        return str;
    }

    private static kx A(JSONObject jSONObject) {
        LinkedList linkedList = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            return null;
        }
        kx kxVar = new kx();
        try {
            kxVar.status = jSONObject.optInt(DownloadInfo.STATUS);
            kxVar.rmV = jSONObject.optInt("init_balance");
            kxVar.rmW = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                kxVar.rmX = j(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                kxVar.rmY = j(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                kxVar.rmZ = j(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                kxVar.rna = linkedList;
            }
            kxVar.rnb = jSONObject.optInt("avail_num");
            kxVar.rnc = jSONObject.optInt("code_type");
            kxVar.code = jSONObject.optString("code");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                kxVar.rnd = k(optJSONArray3);
            }
            kxVar.rne = jSONObject.optLong("stock_num");
            kxVar.rnf = jSONObject.optInt("limit_num");
            kxVar.rng = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                kxVar.rnh = D(optJSONObject);
            }
            kxVar.rni = l(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                kxVar.rnj = D(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                kxVar.rnk = D(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                kxVar.rnl = D(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                kxVar.rnm = G(optJSONObject);
            }
            kxVar.rnn = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                kxVar.rno = D(optJSONObject);
            }
            kxVar.rnp = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                kxVar.rnq = D(optJSONObject);
            }
            kxVar.rnr = jSONObject.optBoolean("is_commom_card");
            kxVar.rns = jSONObject.optBoolean("is_location_authorized");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return kxVar;
    }

    private static LinkedList<lk> j(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<lk> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            lk lkVar = new lk();
            lkVar.title = jSONObject.optString("title");
            lkVar.huX = jSONObject.optString("sub_title");
            lkVar.hyz = jSONObject.optString("tips");
            lkVar.url = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            lkVar.roL = jSONObject.optLong("show_flag");
            lkVar.roM = jSONObject.optString("primary_color");
            lkVar.roN = jSONObject.optString("secondary_color");
            lkVar.lMY = jSONObject.optString("icon_url");
            lkVar.rnv = jSONObject.optString("app_brand_user_name");
            lkVar.rnw = jSONObject.optString("app_brand_pass");
            linkedList.add(lkVar);
        }
        return linkedList;
    }

    public static lf B(JSONObject jSONObject) {
        iu iuVar = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            return null;
        }
        lf lfVar = new lf();
        try {
            kz kzVar;
            bwx bwx;
            xk xkVar;
            ax axVar;
            lfVar.huU = jSONObject.optString("card_tp_id");
            lfVar.huW = jSONObject.optString("logo_url");
            lfVar.bPS = jSONObject.optString("appid");
            lfVar.rnD = jSONObject.optString("app_username");
            lfVar.rnE = jSONObject.optInt("card_category");
            lfVar.huV = jSONObject.optInt("card_type");
            lfVar.hwh = jSONObject.optString("brand_name");
            lfVar.title = jSONObject.optString("title");
            lfVar.huX = jSONObject.optString("sub_title");
            lfVar.dxh = jSONObject.optString("color");
            lfVar.hUy = jSONObject.optString("notice");
            lfVar.rnF = jSONObject.optString("service_phone");
            lfVar.rnI = jSONObject.optString("image_text_url");
            lfVar.rnJ = jSONObject.optString("source_icon");
            lfVar.bhd = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                lfVar.rnG = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                lfVar.rnH = k(optJSONArray);
            }
            lfVar.rnK = jSONObject.optInt("shop_count");
            lfVar.rnL = jSONObject.optString("limit_wording");
            lfVar.hwg = jSONObject.optString("card_type_name");
            lfVar.rnM = jSONObject.optString("h5_show_url");
            lfVar.rnN = jSONObject.optInt("block_mask");
            lfVar.rnO = jSONObject.optString("middle_icon");
            lfVar.rnP = jSONObject.optString("accept_wording");
            lfVar.rnQ = jSONObject.optLong("control_flag");
            lfVar.rnR = jSONObject.optString("advertise_wording");
            lfVar.rnS = jSONObject.optString("advertise_url");
            lfVar.rnT = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                kzVar = null;
            } else {
                kzVar = new kz();
                kzVar.type = optJSONObject.optInt(DownloadSettingTable$Columns.TYPE);
                kzVar.text = optJSONObject.optString("text");
                kzVar.url = optJSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                kzVar.mXw = optJSONObject.optInt("endtime");
                kzVar.create_time = optJSONObject.optInt("create_time");
                kzVar.rnt = optJSONObject.optString("thumb_url");
            }
            lfVar.rnU = kzVar;
            lfVar.rnV = jSONObject.optString("public_service_tip");
            lfVar.rnW = jSONObject.optString("primary_sub_title");
            lfVar.rnX = jSONObject.optInt("gen_type");
            lfVar.rnY = E(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                bwx = null;
            } else {
                int i;
                bsf F;
                bwx = new bwx();
                bwx.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    bwx.stj = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        F = F(optJSONArray2.optJSONObject(i));
                        if (F != null) {
                            bwx.stj.add(F);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    bwx.stk = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        F = F(optJSONArray2.optJSONObject(i));
                        if (F != null) {
                            bwx.stk.add(F);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    bwx.stl = k(optJSONArray3);
                }
            }
            lfVar.rnZ = bwx;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                xkVar = null;
            } else {
                xkVar = new xk();
                xkVar.text = optJSONObject.optString("text");
                xkVar.rDo = optJSONObject.optInt("follow");
                x.i("MicroMsg.CardInfoParser", "follow:" + xkVar.rDo + "　text:" + xkVar.text);
            }
            lfVar.roa = xkVar;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                axVar = null;
            } else {
                axVar = new ax();
                axVar.text = optJSONObject.optString("text");
                axVar.url = optJSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            }
            lfVar.rob = axVar;
            lfVar.roc = jSONObject.optInt("need_direct_jump", 0);
            lfVar.rod = jSONObject.optInt("is_acceptable", 0);
            lfVar.roe = jSONObject.optString("unacceptable_wording");
            lfVar.rof = jSONObject.optInt("has_hongbao", 0);
            lfVar.rog = jSONObject.optString("accept_ui_title");
            lfVar.roh = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                lfVar.roi = D(optJSONObject3);
            }
            lfVar.roj = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                lfVar.rok = D(optJSONObject3);
            }
            optJSONObject = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject != null) {
                sw swVar;
                if (optJSONObject == null) {
                    x.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    swVar = null;
                } else {
                    swVar = new sw();
                    swVar.rwc = optJSONObject.optBoolean("is_dynamic");
                    swVar.rwd = optJSONObject.optBoolean("can_refresh");
                    swVar.rwe = optJSONObject.optString("refresh_wording");
                    x.i("MicroMsg.CardInfoParser", "is_dynamic:" + swVar.rwc + "　can_refresh:" + swVar.rwd + "　refresh_wording:" + swVar.rwe);
                }
                lfVar.rol = swVar;
            }
            lfVar.rom = jSONObject.optBoolean("is_card_code_exposed");
            lfVar.ron = jSONObject.optInt("qrcode_correct_level");
            lfVar.roo = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            lfVar.rop = jSONObject.optBoolean("need_location");
            optJSONObject3 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    x.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    iuVar = new iu();
                    iuVar.name = optJSONObject3.optString("name");
                    iuVar.rjZ = optJSONObject3.optInt("report_time_interval", 0);
                    x.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", new Object[]{iuVar.name});
                }
                lfVar.roq = iuVar;
            }
            lfVar.ror = jSONObject.optString("biz_nickname");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return lfVar;
    }

    private static LinkedList<pr> k(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<pr> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            pr D = D(jSONArray.getJSONObject(i));
            if (D != null) {
                linkedList.add(D);
            }
        }
        return linkedList;
    }

    private static bng C(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            return null;
        }
        bng bng = new bng();
        bng.sli = jSONObject.optString("gift_msg_title");
        return bng;
    }

    private static LinkedList<ax> l(JSONArray jSONArray) {
        LinkedList<ax> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ax axVar = new ax();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    axVar.text = jSONObject.optString("text");
                    axVar.url = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                    linkedList.add(axVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    private static pr D(JSONObject jSONObject) {
        akz akz = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            return null;
        }
        pr prVar = new pr();
        prVar.title = jSONObject.optString("title");
        prVar.huY = jSONObject.optString("aux_title");
        prVar.huX = jSONObject.optString("sub_title");
        prVar.url = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        prVar.roL = jSONObject.optLong("show_flag");
        prVar.roM = jSONObject.optString("primary_color");
        prVar.roN = jSONObject.optString("secondary_color");
        prVar.lMY = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            } else {
                x.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[]{optJSONObject});
                akz = new akz();
                akz.qZT = o.cx(optJSONObject.optString("biz_uin"));
                akz.qZU = optJSONObject.optString("order_id");
            }
            prVar.rtT = akz;
        }
        prVar.rnv = jSONObject.optString("app_brand_user_name");
        prVar.rnw = jSONObject.optString("app_brand_pass");
        return prVar;
    }

    private static sd E(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            return null;
        }
        sd sdVar = new sd();
        sdVar.title = jSONObject.optString("title");
        sdVar.url = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        sdVar.desc = jSONObject.optString("abstract");
        sdVar.detail = jSONObject.optString("detail");
        sdVar.rvA = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    x.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            sdVar.rvz = linkedList;
        }
        return sdVar;
    }

    private static bsf F(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            return null;
        }
        bsf bsf = new bsf();
        bsf.tag = jSONObject.optString("tag");
        bsf.dxh = jSONObject.optString("color");
        return bsf;
    }

    private static se G(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            return null;
        }
        se seVar = new se();
        seVar.title = jSONObject.optString("title");
        seVar.huX = jSONObject.optString("sub_title");
        seVar.rvB = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
            return seVar;
        }
        try {
            seVar.rvC = k(optJSONArray);
            return seVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
            return seVar;
        }
    }
}
