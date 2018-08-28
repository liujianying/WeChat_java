package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.widget.g.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;

public final class a extends com.tencent.mm.plugin.appbrand.menu.a.a {
    public a() {
        super(l.gjF - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        CharSequence charSequence;
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        int i = l.gjF - 1;
        String str2 = appBrandSysConfig.bKC;
        int i2 = appBrandSysConfig.frm.fih;
        boolean z = pVar.gnz;
        CharSequence string = context.getString(j.app_brand_about_app_formatter, new Object[]{str2});
        str2 = com.tencent.mm.plugin.appbrand.appcache.a.jB(i2);
        if (bi.oW(str2)) {
            charSequence = string;
        } else {
            int g;
            int parseColor = Color.parseColor("#42000000");
            i2 = com.tencent.mm.bp.a.g(context, d.bottom_sheet_text_color);
            if (z) {
                parseColor = Color.parseColor("#80FFFFFF");
                g = com.tencent.mm.bp.a.g(context, d.white_text_color);
            } else {
                g = i2;
            }
            c cVar = new c(str2, com.tencent.mm.bp.a.fromDPToPix(context, 11), com.tencent.mm.bp.a.fromDPToPix(context, 11), com.tencent.mm.bp.a.fromDPToPix(context, 9), parseColor, com.tencent.mm.bp.a.fromDPToPix(context, 2));
            int b = cVar.b(null);
            int[] anG = com.tencent.mm.plugin.appbrand.ui.j.anG();
            int ad = com.tencent.mm.bp.a.ad(context, e.bottomsheet_list_text_size);
            TextPaint textPaint = new TextPaint(new Paint(g));
            textPaint.setTextSize((float) ad);
            CharSequence ellipsize = TextUtils.ellipsize(string, textPaint, (float) ((anG[0] - com.tencent.mm.bp.a.ad(context, e.bottomsheet_list_icon_padding)) - b), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize + str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(ad, false), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(g), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(cVar, ellipsize.length(), spannableStringBuilder.length(), 18);
            Object charSequence2 = spannableStringBuilder;
        }
        lVar.e(i, charSequence2);
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        if (appBrandSysConfig != null) {
            String str2 = "";
            if (com.tencent.mm.plugin.appbrand.a.qb(str) != null) {
                str2 = bi.oV(com.tencent.mm.plugin.appbrand.j.g(pVar.fdO).fdE);
            }
            com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.aju();
            WxaExposedParams$a wxaExposedParams$a = new WxaExposedParams$a();
            wxaExposedParams$a.appId = appBrandSysConfig.appId;
            wxaExposedParams$a.bJu = 3;
            wxaExposedParams$a.bVs = pVar.gns == null ? "" : pVar.gns.getPagePath();
            wxaExposedParams$a.fih = appBrandSysConfig.frm.fih;
            wxaExposedParams$a.fii = appBrandSysConfig.frm.fii;
            AppBrandProfileUI.a(context, appBrandSysConfig.bGy, str2, wxaExposedParams$a.aeo());
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 6, "", bi.VE(), 1, 0);
        }
    }
}
