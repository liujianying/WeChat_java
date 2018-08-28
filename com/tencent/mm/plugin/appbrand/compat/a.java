package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.compat.a.a$a;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

final class a implements com.tencent.mm.plugin.appbrand.compat.a.a {
    a() {
    }

    public final void S(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, context.getString(R.l.app_brand_nearby_list_title));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 3);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final void T(Context context, String str) {
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("geta8key_scene", 41);
        putExtra.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, context.getString(R.l.app_brand_launcher_head_wxagame));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 4);
        } else {
            context.startActivity(putExtra);
        }
    }

    public final Intent cp(Context context) {
        Intent adR = ((f) g.l(f.class)).adR();
        adR.setClass(context, AppBrandSearchUI.class);
        adR.putExtra("key_trust_url", true);
        adR.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, context.getString(R.l.app_brand_fts_search_wxapp));
        adR.putExtra("searchbar_tips", context.getString(R.l.app_brand_fts_search_wxapp));
        adR.putExtra("KRightBtn", true);
        adR.putExtra("ftsneedkeyboard", true);
        adR.putExtra("ftsType", 64);
        adR.putExtra("ftsbizscene", 201);
        Map adS = ((f) g.l(f.class)).adS();
        String JK = b.JK();
        adS.put("WASessionId", JK);
        adR.putExtra("rawUrl", ((f) g.l(f.class)).v(adS));
        adR.putExtra("key_load_js_without_delay", true);
        adR.addFlags(67108864);
        adR.putExtra("key_session_id", JK);
        String str = "key_search_input_hint";
        Object obj = g.Ei().DT().get(com.tencent.mm.storage.aa.a.sVA, null);
        String str2 = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
        adR.putExtra(str, str2);
        return adR;
    }

    public final void a(com.tencent.mm.y.g.a aVar, String str, String str2, String str3, byte[] bArr) {
        l.a(aVar, str, str2, str3, null, bArr);
    }

    public final View c(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.i.layout_appbrand_share_page_preview_footer, viewGroup, false);
    }

    public final String cq(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.settings_plugins_installing);
    }

    public final String cr(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.settings_plugins_install);
    }

    public final String cs(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.settings_plugins_installed);
    }

    public final String ct(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context.getString(R.l.settings_plugins_uninstalled);
    }

    public final int adu() {
        hm hmVar = new hm();
        com.tencent.mm.sdk.b.a.sFg.m(hmVar);
        return hmVar.bQR.bQS;
    }

    public final void a(a$a a_a) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new akf();
        aVar.dIH = new akg();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        aVar.dIF = 1926;
        aVar.dII = 0;
        aVar.dIJ = 0;
        v.a(aVar.KT(), new 1(this, a_a), true);
    }
}
