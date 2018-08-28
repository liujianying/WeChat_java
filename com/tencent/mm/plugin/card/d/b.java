package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        x.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        h.mEJ.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }

    public static void ab(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
        } else if (context == null) {
            x.e("MicroMsg.CardActivityHelper", "context is null, err");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("force_get_contact", true);
            d.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }

    public static void ac(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
        } else if (!s.he(str)) {
            ab(context, str);
        } else if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("finish_direct", true);
            d.e(context, ".ui.chatting.ChattingUI", intent);
        }
    }

    public static void a(MMActivity mMActivity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        d.b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        d.b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, float f, float f2, String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        d.b((Context) mMActivity, "location", ".ui.RedirectUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, a aVar) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, aVar);
    }

    public static void a(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        d.b((Context) mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.awr());
        intent.putExtra("key_user_card_id", bVar.awq());
        intent.putExtra("key_card_code", bVar.awn().code);
        d.b((Context) mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        h.mEJ.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
    }

    public static boolean a(String str, pr prVar, int i, int i2) {
        if (prVar != null) {
            return e(str, prVar.rnv, prVar.rnw, i, i2);
        }
        x.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
        return false;
    }

    public static boolean e(String str, String str2, String str3, int i, int i2) {
        if (bi.oW(str2)) {
            x.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            return false;
        }
        qu quVar = new qu();
        quVar.cbq.userName = str2;
        quVar.cbq.cbs = bi.aG(str3, "");
        quVar.cbq.cbt = i2;
        if (i == 26) {
            quVar.cbq.scene = 1029;
        } else {
            quVar.cbq.scene = 1028;
        }
        quVar.cbq.bGG = str;
        quVar.cbq.cbx = true;
        com.tencent.mm.sdk.b.a.sFg.m(quVar);
        x.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[]{quVar.cbq.userName, quVar.cbq.cbs, Integer.valueOf(quVar.cbq.scene), Integer.valueOf(quVar.cbq.cbt)});
        return true;
    }
}
