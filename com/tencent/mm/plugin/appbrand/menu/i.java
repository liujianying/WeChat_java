package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s$e;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

final class i extends a {
    i() {
        super(l.gjz - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (b.chp()) {
            lVar.e(this.gjO, context.getString(j.app_brand_show_debug_info));
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void a(Context context, p pVar, String str, k kVar) {
        String str2;
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        Object stringBuilder = new StringBuilder("!PKG_INFO!\n");
        WxaPkgWrappingInfo abP = WxaCommLibRuntimeReader.abP();
        stringBuilder.append("\n[lib.src] ");
        if (abP.fik) {
            stringBuilder.append(af.abU() ? "local(force)" : "local");
        } else {
            stringBuilder.append("cgi");
        }
        stringBuilder.append("\n[lib.ver] ").append(abP.fii);
        if (abP.fih != 0) {
            StringBuilder append = stringBuilder.append("  ");
            if (abP.fih == 0) {
                str2 = "";
            } else {
                str2 = bi.gb(abP.fij);
            }
            append.append(str2);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = appBrandSysConfig.frm;
        stringBuilder.append(10);
        stringBuilder.append("\n[app.version] ").append(wxaPkgWrappingInfo.fii);
        if (appBrandSysConfig.frm.fih != 0) {
            stringBuilder.append("  ").append(bi.gb(wxaPkgWrappingInfo.fij));
        }
        boolean z = !bi.cX(wxaPkgWrappingInfo.fil);
        stringBuilder.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            str2 = pVar.fdO.fcM.uB(pVar.getURL());
            stringBuilder.append(String.format(Locale.US, "  (%s)", new Object[]{str2}));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(s$e.LargePadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(context, null, textView, null);
    }
}
