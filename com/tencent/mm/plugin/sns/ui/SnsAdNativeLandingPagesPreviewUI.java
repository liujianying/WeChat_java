package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.v;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ad.I(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Object stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        int i = intent.hasExtra("sns_landing_pages_canvasid") ? 1 : 0;
        long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        String stringExtra2 = intent.getStringExtra("sns_landing_pages_canvasid");
        String stringExtra3 = intent.getStringExtra("sns_landing_pages_canvas_ext");
        if (TextUtils.isEmpty(stringExtra)) {
            if (intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
                if (i == 1) {
                    stringExtra = i.bAE().k(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = i.bAE().h(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!f(intent, stringExtra)) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            b bVar;
            View findViewById = findViewById(f.progressbar);
            findViewById.setVisibility(0);
            b.a aVar = new b.a();
            b KT;
            if (i == 0 && longExtra > 0) {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[]{Long.valueOf(longExtra)});
                aVar.dIG = new yw();
                aVar.dIH = new yx();
                aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                aVar.dIF = 1286;
                KT = aVar.KT();
                ((yw) KT.dID.dIL).rEZ = longExtra;
                bVar = KT;
            } else if (i != 1 || bi.oW(stringExtra2)) {
                x.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                return;
            } else {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[]{stringExtra2});
                aVar.dIG = new afl();
                aVar.dIH = new afm();
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                aVar.dIF = 1890;
                KT = aVar.KT();
                afl afl = (afl) KT.dID.dIL;
                afl.rJs = stringExtra2;
                afl.rJt = stringExtra3;
                bVar = KT;
            }
            v.a(bVar, new 1(this, findViewById, i, stringExtra2, stringExtra3, longExtra, intent));
        } else if (!g(intent, stringExtra)) {
            finish();
        }
    }

    private static boolean f(Intent intent, String str) {
        if (!bi.oW(str) && ad.Nb(str)) {
            String Nc = ad.Nc(str);
            if (bi.oW(Nc)) {
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", Nc);
        }
        return true;
    }

    private boolean g(Intent intent, String str) {
        if (e.Nf(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            startActivity(intent);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
                return true;
            }
            overridePendingTransition(com.tencent.mm.plugin.sns.i.a.slide_right_in, com.tencent.mm.plugin.sns.i.a.slide_left_out);
            return true;
        }
        x.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + str);
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(com.tencent.mm.plugin.sns.i.a.slide_right_in, com.tencent.mm.plugin.sns.i.a.slide_left_out);
                return true;
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.sns_ad_native_landing_pages_preview_ui;
    }
}
