package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class n {

    public static class b {
        public String egr;

        public b(String str) {
            this.egr = str;
        }
    }

    public static String K(Context context, int i) {
        if (context == null || i < 0) {
            return "";
        }
        if (i == 0) {
            context.getString(R.l.scan_product_type_unknown);
        } else if (i == 1) {
            context.getString(R.l.scan_product_type_book);
        } else if (i == 2) {
            context.getString(R.l.scan_product_type_movie);
        } else if (i == 3) {
            context.getString(R.l.scan_product_type_cd);
        }
        return context.getString(R.l.scan_product_type_unknown);
    }

    public static int KP(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            return 1;
        }
        if (trim.startsWith("<url")) {
            return 2;
        }
        if (trim.startsWith("<product")) {
            return 3;
        }
        if (trim.startsWith("<search")) {
            return 4;
        }
        return 0;
    }

    public static c KQ(String str) {
        if (str == null) {
            return null;
        }
        Map z = bl.z(str, "user");
        if (z != null) {
            return new c(bi.oV((String) z.get(".user.username")), bi.oV((String) z.get(".user.nickname")));
        }
        return null;
    }

    public static b KR(String str) {
        if (str == null) {
            return null;
        }
        Map z = bl.z(str, "url");
        if (z != null) {
            return new b(bi.oV((String) z.get(".url.link")));
        }
        return null;
    }

    public static String c(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!bi.oW(aVar.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            stringBuilder.append("<id>" + bi.WS(aVar.field_productid) + "</id>");
            stringBuilder.append("<title>" + bi.WS(aVar.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + bi.WS(aVar.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + bi.WS(aVar.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + bi.WS(aVar.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + bi.WS(aVar.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + bi.WS(aVar.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + bi.WS(aVar.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + bi.WS(aVar.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + bi.WS(aVar.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + bi.WS(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + bi.WS(aVar.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + bi.WS(aVar.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + bi.WS(aVar.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            x.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            return "";
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            return aVar.field_xml;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(aVar.field_xml);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        return stringBuilder.toString();
    }

    public static int a(int i, String str, i iVar, int i2, a aVar, int i3, int i4, boolean z) {
        if (iVar == null || str == null || iVar.bsM() == null || iVar.bsM().getContext() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(str == null);
            x.e(str2, str3, objArr);
            return 2;
        }
        int KP = KP(str);
        x.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(KP)});
        Intent intent;
        if (KP == 1) {
            c KQ = KQ(str);
            if (KQ == null || bi.oW(KQ.username)) {
                x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                return 2;
            }
            au.HU();
            ab Yg = c.FR().Yg(KQ.username);
            if (Yg == null || ((int) Yg.dhP) <= 0) {
                iVar.bsM().a(KQ.username, 1, i3, i4, aVar);
                return 1;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", Yg.field_username);
            intent2.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.ezn.d(intent2, iVar.bsM().getContext());
            return 0;
        } else if (KP == 2) {
            b KR = KR(str);
            if (KR == null || bi.oW(KR.egr)) {
                x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                return 2;
            }
            x.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{KR.egr});
            if (i == 5) {
                ((e) g.l(e.class)).b(iVar.bsM().getContext(), KR.egr, z ? 1032 : 1025, null);
                return 0;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", KR.egr);
            intent.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.ezn.j(intent, iVar.bsM().getContext());
            return 0;
        } else if (KP == 3 || KP == 4) {
            x.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(i2), Boolean.valueOf(true)});
            intent = new Intent();
            intent.setClass(iVar.bsM().getContext(), ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", str);
            intent.putExtra("key_Product_funcType", i2);
            intent.putExtra("key_ProductUI_addToDB", true);
            intent.putExtra("key_need_add_to_history", true);
            intent.putExtra("key_is_from_barcode", true);
            iVar.bsM().getContext().startActivity(intent);
            return 0;
        } else {
            x.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            x.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str});
            return 2;
        }
    }
}
