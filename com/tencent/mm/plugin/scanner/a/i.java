package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.y.g;
import java.util.Map;

public final class i {
    public static String a(Context context, a aVar) {
        g.a aVar2 = new g.a();
        aVar2.appId = vx(aVar.field_functionType);
        aVar2.title = aVar.field_title;
        aVar2.description = aVar.field_source;
        aVar2.type = 10;
        aVar2.url = aVar.field_shareurl;
        aVar2.action = "";
        aVar2.appName = n.K(context, aVar.field_type);
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.dwR = aVar.field_type;
        aVar2.dwS = n.c(aVar);
        return g.a.a(aVar2, null, null);
    }

    public static String vx(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static a bY(String str, int i) {
        if (bi.oW(str)) {
            return null;
        }
        int KP = n.KP(str);
        if (KP == 3) {
            if (str == null) {
                return null;
            }
            Map z;
            int i2;
            String str2;
            String str3 = "";
            if (str.startsWith("<productInfo")) {
                z = bl.z(str, "productInfo");
                i2 = 1;
                str2 = ".productInfo";
            } else {
                z = bl.z(str, "product");
                str2 = str3;
                i2 = 0;
            }
            if (z == null) {
                return null;
            }
            a aVar = new a();
            if (bi.oW((String) z.get(str2 + ".product.$type"))) {
                aVar.field_type = 0;
            } else {
                aVar.field_type = Integer.valueOf((String) z.get(str2 + ".product.$type")).intValue();
            }
            aVar.field_productid = bi.oV((String) z.get(str2 + ".product.id"));
            aVar.field_subtitle = bi.oV((String) z.get(str2 + ".product.subtitle"));
            aVar.field_shareurl = bi.oV((String) z.get(str2 + ".product.shareurl"));
            aVar.field_playurl = bi.oV((String) z.get(str2 + ".product.playurl"));
            aVar.field_xmlType = 3;
            aVar.field_title = bi.oV((String) z.get(str2 + ".product.title"));
            aVar.field_thumburl = bi.oV((String) z.get(str2 + ".product.thumburl"));
            aVar.field_source = bi.oV((String) z.get(str2 + ".product.source"));
            aVar.field_feedbackurl = bi.oV((String) z.get(str2 + ".product.feedbackurl"));
            aVar.field_extinfo = bi.oV((String) z.get(str2 + ".product.extinfo"));
            aVar.field_introtitle = bi.oV((String) z.get(str2 + ".product.introtitle"));
            aVar.field_introlink = bi.oV((String) z.get(str2 + ".product.introlink"));
            aVar.field_getaction = bi.getInt((String) z.get(str2 + ".product.getaction"), 0);
            aVar.field_certification = bi.oV((String) z.get(str2 + ".product.certification"));
            aVar.field_headerbackgroundurl = bi.oV((String) z.get(str2 + ".product.headerbackgroundurl"));
            aVar.field_headermask = bi.oV((String) z.get(str2 + ".product.headermask"));
            aVar.field_detailurl = bi.oV((String) z.get(str2 + ".product.detailurl"));
            aVar.field_certificationurl = bi.oV((String) z.get(str2 + ".product.certificationurl"));
            aVar.field_exposeurl = bi.oV((String) z.get(str2 + ".product.exposeurl"));
            aVar.mNX = a.m(z, str2 + ".product");
            aVar.o(z, str2 + ".product");
            String str4 = (String) z.get(str2 + ".functionType");
            if (bi.oW(str4)) {
                aVar.field_functionType = i;
            } else {
                aVar.field_functionType = Integer.valueOf(str4).intValue();
            }
            if (i2 != 0) {
                aVar.field_xml = str;
            } else {
                StringBuilder stringBuilder = new StringBuilder(GLIcon.TOP);
                stringBuilder.append("<productInfo>");
                stringBuilder.append(str);
                stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
                stringBuilder.append("</productInfo>");
                aVar.field_xml = stringBuilder.toString();
            }
            return aVar;
        } else if (KP != 4 || str == null) {
            return null;
        } else {
            Map z2 = bl.z(str, "search");
            if (z2 == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.field_xmlType = 4;
            aVar2.field_xml = str;
            aVar2.mNX = a.m(z2, ".search");
            return aVar2;
        }
    }
}
