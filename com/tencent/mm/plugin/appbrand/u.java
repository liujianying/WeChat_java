package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ah.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashSet;
import java.util.Set;

public final class u extends a {
    public final int getType() {
        return 1;
    }

    public final void l(Context context, Intent intent) {
        Object obj;
        h.mEJ.a(443, 2, 1, false);
        String wO = c.wO(s.j(intent, "id"));
        String wO2 = c.wO(s.j(intent, "ext_info"));
        Object j = s.j(intent, "token");
        int a = s.a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(wO) || TextUtils.isEmpty(wO2) || TextUtils.isEmpty(j)) {
            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            obj = null;
        } else if (i.gr(wO)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            if (!j.equals(c.bU(wO2, stringBuilder.append(com.tencent.mm.kernel.a.Df()).toString()))) {
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    x.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    obj = null;
                } else {
                    Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                    if (stringSet == null || stringSet.isEmpty()) {
                        x.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                        obj = null;
                    } else {
                        Set hashSet = new HashSet();
                        for (String str2 : stringSet) {
                            hashSet.add(c.bU(wO2, str2));
                        }
                        if (!hashSet.contains(j)) {
                            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[]{j});
                            obj = null;
                        }
                    }
                }
            }
            if (b.chp() || a != 1) {
                qu quVar = new qu();
                quVar.cbq.appId = wO2;
                quVar.cbq.userName = wO;
                quVar.cbq.cbt = a;
                quVar.cbq.scene = 1023;
                quVar.cbq.cbx = true;
                quVar.cbq.context = context;
                quVar.cbq.cby = false;
                com.tencent.mm.sdk.b.a.sFg.m(quVar);
                if (quVar.cbr.cbD) {
                    x.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[]{wO});
                } else if (a == 1) {
                    Toast.makeText(context, j.app_brand_debug_app_from_share_card_can_not_open, 0).show();
                } else if (a == 2) {
                    Toast.makeText(context, j.app_brand_not_beta_pkg, 0).show();
                }
                Object j2 = s.j(intent, "digest");
                if (!TextUtils.isEmpty(j2)) {
                    WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(wO);
                    if (rR == null) {
                        x.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", new Object[]{wO});
                        obj = 1;
                    } else {
                        if (!j2.equals(com.tencent.mm.a.g.u((rR.field_nickname + rR.field_roundedSquareIconURL + rR.field_brandIconURL + rR.field_bigHeadURL).getBytes()))) {
                            x.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", new Object[]{wO});
                            if (context == null) {
                                x.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                            } else if (intent == null) {
                                x.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                            } else {
                                bs bsVar = new bs();
                                bsVar.bJc.username = wO;
                                com.tencent.mm.sdk.b.a.sFg.m(bsVar);
                                if (bsVar.bJd.bJe == null) {
                                    x.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[]{wO});
                                } else {
                                    str2 = TextUtils.isEmpty(bsVar.bJd.nickname) ? wO : bsVar.bJd.nickname;
                                    Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                                    intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
                                    intent2.putExtra("duplicate", false);
                                    intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                                    com.tencent.mm.plugin.base.model.b.p(context, intent2);
                                    x.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[]{wO});
                                }
                            }
                            ah.i(new 1(this, context, wO, a), 1000);
                        }
                    }
                }
                intent.putExtra(DownloadSettingTable$Columns.TYPE, 0);
                intent.putExtra("id", "");
                obj = 1;
            } else {
                x.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
                obj = null;
            }
        } else {
            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[]{wO});
            f.mDy.a(647, 1, 1, false);
            obj = null;
        }
        if (obj == null) {
            h.mEJ.a(443, 3, 1, false);
        }
    }
}
