package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 30;
    public static final String NAME = "previewImage";
    private final int fVe = 524288;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        lVar.E(i, a(c(lVar), d(lVar), lVar.mAppId, jSONObject));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        pVar.E(i, a(pVar.mContext, pVar, pVar.mAppId, jSONObject));
    }

    private String a(Context context, p pVar, String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray == null) {
            return f("fail:no url", null);
        }
        int i;
        int intValue;
        String[] strArr = new String[optJSONArray.length()];
        for (i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.optString(i);
        }
        Object opt = jSONObject.opt("current");
        if (opt instanceof Integer) {
            intValue = ((Integer) opt).intValue();
        } else if (opt instanceof String) {
            intValue = 0;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (opt.equals(strArr[i2])) {
                    intValue = i2;
                }
            }
        } else {
            intValue = 0;
        }
        for (i = 0; i < strArr.length; i++) {
            if (bi.oV(strArr[i]).startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, strArr[i]);
                if (itemByLocalId != null) {
                    strArr[i] = itemByLocalId.dDG;
                } else {
                    strArr[i] = "";
                }
            }
        }
        String[] strArr2 = new String[strArr.length];
        i = 0;
        while (i < strArr.length) {
            if (strArr[i] == null || !strArr[i].startsWith("data:image/")) {
                strArr2[i] = strArr[i];
            } else {
                String str2 = strArr[i];
                strArr2[i] = TextUtils.isEmpty(str2) ? "" : tP(str2.substring(str2.indexOf("base64,") + 7).trim());
            }
            i++;
        }
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < strArr2.length) {
            if (!(strArr2[i] == null || strArr[i] == null || strArr2[i].equals(strArr[i]))) {
                arrayList.add(strArr2[i]);
            }
            i++;
        }
        String[] strArr3 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (!(context instanceof MMActivity)) {
            return f("fail", null);
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", strArr2[intValue]);
        intent.putExtra("urlList", strArr2);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("shouldShowScanQrCodeMenu", true);
        intent.putExtra("scanQrCodeGetA8KeyScene", 44);
        intent.putExtra("scanCodeTypes", new int[]{5});
        intent.putExtra("scanResultCodeTypes", new int[]{22});
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 6);
        bundle.putString("stat_app_id", str);
        bundle.putString("stat_url", pVar.getURL());
        intent.putExtra("_stat_obj", bundle);
        intent.setClassName(context, context.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
        try {
            if (intent.getExtras().toString().length() > 524288) {
                x.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[]{Integer.valueOf(intent.getExtras().toString().length())});
                return f("fail:data too large", null);
            }
            ((MMActivity) context).geJ = new 1(this, strArr3);
            com.tencent.mm.bg.d.a(context, "subapp", ".ui.gallery.GestureGalleryUI", intent, 65535 & hashCode(), false);
            return f("ok", null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiPreviewImage", e, "JsApiPreviewImage get size error", new Object[0]);
            return f("fail", null);
        }
    }

    private static String tP(String str) {
        String str2;
        Throwable th;
        FileOutputStream fileOutputStream;
        byte[] decode = Base64.decode(str, 0);
        if (decode == null || decode.length == 0) {
            return "";
        }
        File file = new File(ad.getContext().getCacheDir(), "preview_" + System.currentTimeMillis() + "_" + str.hashCode());
        FileOutputStream fileOutputStream2 = null;
        try {
            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
            try {
                fileOutputStream3.write(decode);
                try {
                    fileOutputStream3.close();
                } catch (IOException e) {
                }
                return file.getAbsolutePath();
            } catch (Exception e2) {
                fileOutputStream2 = fileOutputStream3;
                str2 = "";
                if (fileOutputStream2 != null) {
                    return str2;
                }
                try {
                    fileOutputStream2.close();
                    return str2;
                } catch (IOException e3) {
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            str2 = "";
            if (fileOutputStream2 != null) {
                return str2;
            }
            try {
                fileOutputStream2.close();
                return str2;
            } catch (IOException e32) {
                return str2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }
}
