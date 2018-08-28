package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static boolean xW(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private static HashMap<String, String> Jy(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("action");
        if (indexOf <= 0) {
            return null;
        }
        Object substring = str.substring(indexOf, str.length());
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        String[] split = substring.split("&");
        if (split == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3 != null && split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        return hashMap;
    }

    public static boolean aD(Context context, String str) {
        x.v("MicroMsg.MallUtil", "jumpToUrl:" + str);
        Intent intent = new Intent();
        HashMap Jy = Jy(str);
        if (Jy != null && !Jy.isEmpty()) {
            String str2 = (String) Jy.get("action");
            if (!TextUtils.isEmpty(str2) && xW(str2)) {
                switch (Integer.valueOf(str2).intValue()) {
                    case 1:
                        intent.putExtra("rawUrl", (String) Jy.get("3rdurl"));
                        intent.putExtra("showShare", false);
                        intent.putExtra("pay_channel", 1);
                        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        break;
                    case 2:
                        e.ab(context, (String) Jy.get("username"));
                        break;
                    case 3:
                        intent.putExtra("key_func_id", (String) Jy.get("functionid"));
                        intent.putExtra("key_scene", 1);
                        d.b(context, "mall", ".ui.MallIndexUI", intent);
                        break;
                    case 4:
                        intent.putExtra("key_product_id", (String) Jy.get("productid"));
                        intent.putExtra("key_product_scene", 5);
                        d.b(context, "product", ".ui.MallProductUI", intent);
                        break;
                }
            }
            x.e("MicroMsg.MallUtil", "jumpToUrl illegal action:" + str2);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.MallUtil", "jumpToUrl illegal url:" + str);
            return false;
        } else {
            aC(context, str);
        }
        return true;
    }

    public static void aE(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("key_product_id", str);
            intent.putExtra("key_product_scene", 5);
            d.b(context, "product", ".ui.MallProductUI", intent);
        }
    }

    public static void aC(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public static void a(Boolean bool, String str, String str2, String str3, String str4) {
        if (bool.booleanValue()) {
            h.mEJ.h(11030, new Object[]{str, "", str3, str4});
            return;
        }
        h.mEJ.h(11030, new Object[]{str, str2, str3, str4});
    }
}
