package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(p pVar, ImageView imageView, JSONObject jSONObject) {
        Bitmap bitmap = null;
        if (imageView != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("iconPath");
                if (!TextUtils.isEmpty(string)) {
                    if (string.startsWith("wxfile://")) {
                        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, string);
                        if (!(itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.dDG))) {
                            String str = itemByLocalId.dDG;
                            if (!str.startsWith("file://")) {
                                str = "file://" + str;
                            }
                            bitmap = b.Ka().a(str, null);
                        }
                    } else if (string.startsWith("https://") || string.startsWith("http://")) {
                        bitmap = b.Ka().a(string, null);
                        if (bitmap == null) {
                            b.Ka().a(imageView, string, null, null);
                        }
                    } else {
                        bitmap = o.j(pVar.fdO, string);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        imageView.setImageBitmap(null);
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            } catch (JSONException e) {
            }
        }
    }

    public static void a(TextView textView, JSONObject jSONObject) {
        if (textView != null && jSONObject != null) {
            String string;
            try {
                string = jSONObject.getString("color");
                if (!bi.oW(string)) {
                    textView.setTextColor(f.vO(string));
                }
            } catch (JSONException e) {
            }
            try {
                textView.setTextSize(0, f.ae((float) jSONObject.getDouble("fontSize")));
            } catch (JSONException e2) {
            }
            try {
                string = jSONObject.getString("textAlign");
                if ("left".equals(string)) {
                    textView.setGravity(3);
                } else if ("center".equals(string)) {
                    textView.setGravity(1);
                } else if ("right".equals(string)) {
                    textView.setGravity(5);
                }
            } catch (JSONException e3) {
            }
            try {
                string = jSONObject.getString("fontWeight");
                if ("bold".equals(string)) {
                    textView.getPaint().setFakeBoldText(true);
                } else if ("normal".equals(string)) {
                    textView.getPaint().setFakeBoldText(false);
                }
            } catch (JSONException e4) {
            }
            int a = f.a(jSONObject, "lineHeight", Math.round(textView.getTextSize() * 1.2f));
            if (textView instanceof com.tencent.mm.plugin.appbrand.widget.f) {
                ((com.tencent.mm.plugin.appbrand.widget.f) textView).setLineHeight(a);
            }
            try {
                string = jSONObject.getString("lineBreak");
                if ("ellipsis".equals(string)) {
                    textView.setEllipsize(TruncateAt.END);
                    textView.setSingleLine(true);
                } else if ("clip".equals(string)) {
                    textView.setSingleLine(true);
                } else if ("break-word".equals(string)) {
                    textView.setSingleLine(false);
                } else if ("break-all".equals(string)) {
                    textView.setSingleLine(false);
                }
            } catch (JSONException e5) {
            }
            try {
                textView.setText(jSONObject.getString("content"));
            } catch (JSONException e6) {
            }
        }
    }
}
