package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.k.g;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class k {
    public static void a(d dVar, Context context, boolean z) {
        int i = 4;
        if (dVar != null) {
            Intent intent;
            switch (dVar.field_type) {
                case 6:
                    String str = dVar.field_username;
                    au.HU();
                    ab Yg = c.FR().Yg(str);
                    if (Yg != null) {
                        Intent intent2 = new Intent();
                        if (a.gd(Yg.field_type) && Yg.ckW()) {
                            z.MY().kA(str);
                            if (dVar.field_distance.equals("1")) {
                                intent2.putExtra("Chat_User", str);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ezn.e(intent2, context);
                                return;
                            }
                        }
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bg.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                case 7:
                    Intent intent3 = new Intent();
                    i = 18;
                    if (z) {
                        i = 26;
                    }
                    intent3.putExtra("geta8key_scene", i);
                    intent3.putExtra("stastic_scene", 6);
                    intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                    intent3.putExtra("jsapiargs", bundle);
                    intent3.putExtra("rawUrl", dVar.field_username);
                    intent3.putExtra("srcUsername", dVar.field_distance);
                    com.tencent.mm.plugin.shake.a.ezn.j(intent3, context);
                    return;
                case 8:
                    intent = new Intent();
                    intent.setClass(context, TVInfoUI.class);
                    intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                    intent.putExtra("key_TV_come_from_shake", true);
                    context.startActivity(intent);
                    return;
                case 9:
                    gw gwVar = new gw();
                    gwVar.bQd.actionCode = 11;
                    gwVar.bQd.result = dVar.field_username;
                    gwVar.bQd.context = context;
                    gwVar.bJX = null;
                    com.tencent.mm.sdk.b.a.sFg.a(gwVar, Looper.myLooper());
                    return;
                case 10:
                    intent = new Intent();
                    intent.putExtra("key_product_id", dVar.field_username);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bg.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                    if (!z) {
                        i = 3;
                    }
                    a(dVar.field_distance, dVar.field_username, i, context);
                    return;
                case 13:
                    String str2 = dVar.field_username;
                    String str3 = dVar.field_reserved3;
                    int i2 = dVar.field_reserved2;
                    if (bi.oW(str2)) {
                        x.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                        return;
                    }
                    qu quVar = new qu();
                    quVar.cbq.userName = str2;
                    quVar.cbq.cbs = bi.aG(str3, "");
                    quVar.cbq.cbt = 0;
                    quVar.cbq.scene = 1039;
                    quVar.cbq.cbu = i2;
                    com.tencent.mm.sdk.b.a.sFg.m(quVar);
                    x.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", new Object[]{quVar.cbq.userName, quVar.cbq.cbs, Integer.valueOf(quVar.cbq.scene), Integer.valueOf(quVar.cbq.cbt), Integer.valueOf(quVar.cbq.cbu)});
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean vY(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean buA() {
        if (af.exd) {
            return true;
        }
        String value = g.AT().getValue("ShowShakeTV");
        x.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", new Object[]{value});
        if (bi.oW(value) || !value.equals("1")) {
            return false;
        }
        return true;
    }

    public static void a(String str, String str2, int i, Context context) {
        if (!bi.oW(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i2 = 16;
            if (i == 3 || i == 4) {
                i2 = 17;
            }
            intent.putExtra("translate_link_scene", i2);
            context.startActivity(intent);
            x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            h.mEJ.h(12108, new Object[]{bi.oV(str), Integer.valueOf(i), Integer.valueOf(1)});
        }
    }
}
