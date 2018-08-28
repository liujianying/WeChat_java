package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import org.json.JSONObject;

public final class m {
    public static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        return true;
    }

    public static boolean a(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        a(context, imageView, str, str2, i, true, 0, 0);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        ((n) g.n(n.class)).getFTSImageLoader().a(imageView, str, str2, z, i2, i3);
        if (!bi.oW(str) || !bi.oW(str2)) {
            Bitmap a = ((n) g.n(n.class)).getFTSImageLoader().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(a.transparent);
                }
                ((n) g.n(n.class)).getFTSImageLoader().a(context, imageView, str, str2, z, i2, i3);
            } else {
                c.a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
        } else if (i <= 0 || (bi.oW(str) && bi.oW(str2))) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
    }

    public static String qm(int i) {
        int i2 = 0;
        switch (i) {
            case IX5WebViewClient.ERROR_TOO_MANY_REQUESTS /*-15*/:
                i2 = n.g.fts_header_mini_game;
                break;
            case IX5WebViewClient.ERROR_FILE /*-13*/:
                i2 = n.g.fts_header_we_app;
                break;
            case IX5WebViewClient.ERROR_FAILED_SSL_HANDSHAKE /*-11*/:
                i2 = n.g.fts_header_mobile_friend;
                break;
            case IX5WebViewClient.ERROR_TIMEOUT /*-8*/:
                i2 = n.g.fts_header_top_hits;
                break;
            case IX5WebViewClient.ERROR_IO /*-7*/:
                i2 = n.g.fts_header_focus_biz;
                break;
            case IX5WebViewClient.ERROR_CONNECT /*-6*/:
                i2 = n.g.fts_header_feature;
                break;
            case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                i2 = n.g.fts_header_game;
                break;
            case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                i2 = n.g.fts_header_contact;
                break;
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                i2 = n.g.fts_header_chatroom;
                break;
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
                i2 = n.g.fts_header_message;
                break;
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                i2 = n.g.fts_header_favorite;
                break;
        }
        if (i2 == 0) {
            return null;
        }
        return ad.getContext().getString(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(android.content.Context r9, java.util.List<com.tencent.mm.plugin.fts.a.a.f> r10, java.lang.String[] r11, com.tencent.mm.plugin.fts.a.a.g r12, android.text.TextPaint r13) {
        /*
        r3 = 0;
        r8 = 1;
        r0 = com.tencent.mm.plugin.fts.a.n.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.fts.a.n) r0;
        r1 = new com.tencent.mm.plugin.fts.ui.m$1;
        r1.<init>(r0);
        java.util.Arrays.sort(r11, r1);
        r4 = new android.text.SpannableStringBuilder;
        r4.<init>();
        r2 = r3;
    L_0x0018:
        r0 = r10.size();
        if (r2 >= r0) goto L_0x00a1;
    L_0x001e:
        r0 = r10.get(r2);
        r0 = (com.tencent.mm.plugin.fts.a.a.f) r0;
        r1 = r0.jrP;
        r5 = r11.length;
        if (r1 >= r5) goto L_0x0068;
    L_0x0029:
        r1 = r0.jrP;
        r5 = r11[r1];
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r1 != 0) goto L_0x0068;
    L_0x0033:
        r1 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r1 = com.tencent.mm.kernel.g.l(r1);
        r1 = (com.tencent.mm.plugin.messenger.foundation.a.i) r1;
        r1 = r1.FR();
        r1 = r1.Yg(r5);
        if (r1 == 0) goto L_0x0068;
    L_0x0045:
        r5 = r1.field_username;
        r6 = com.tencent.mm.model.s.a(r1, r5);
        r7 = r0.jru;
        switch(r7) {
            case 29: goto L_0x0090;
            case 30: goto L_0x008e;
            case 31: goto L_0x008c;
            case 32: goto L_0x009a;
            case 33: goto L_0x0093;
            case 34: goto L_0x007d;
            case 35: goto L_0x007b;
            case 36: goto L_0x0079;
            case 37: goto L_0x006c;
            default: goto L_0x0050;
        };
    L_0x0050:
        r1 = r0.jrR;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0068;
    L_0x0058:
        r1 = r0.jrR;
        r5 = r12.jrV;
        r1 = r1.contains(r5);
        if (r1 == 0) goto L_0x0068;
    L_0x0062:
        r1 = r0.jrT;
        r1 = r1 + 10;
        r0.jrT = r1;
    L_0x0068:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x006c:
        r1 = r1.wM();
        r1 = com.tencent.mm.plugin.fts.a.d.cS(r5, r1);
        r0.jrR = r1;
        r0.jrS = r6;
        goto L_0x0050;
    L_0x0079:
        r0.jrU = r8;
    L_0x007b:
        r0.jry = r8;
    L_0x007d:
        r5 = r1.field_nickname;
        r0.jrR = r5;
        r1 = r1.field_nickname;
        r1 = r1.equals(r6);
        if (r1 != 0) goto L_0x0050;
    L_0x0089:
        r0.jrS = r6;
        goto L_0x0050;
    L_0x008c:
        r0.jrU = r8;
    L_0x008e:
        r0.jry = r8;
    L_0x0090:
        r0.jrR = r6;
        goto L_0x0050;
    L_0x0093:
        r1 = r0.content;
        r0.jrR = r1;
        r0.jrS = r6;
        goto L_0x0050;
    L_0x009a:
        r1 = r1.csT;
        r0.jrR = r1;
        r0.jrS = r6;
        goto L_0x0050;
    L_0x00a1:
        r0 = new com.tencent.mm.plugin.fts.ui.m$2;
        r0.<init>();
        java.util.Collections.sort(r10, r0);
        r0 = 0;
        r1 = r3;
        r2 = r0;
    L_0x00ac:
        r0 = r10.size();
        if (r1 >= r0) goto L_0x0132;
    L_0x00b2:
        r0 = r12.jrX;
        r0 = r0.length;
        if (r1 >= r0) goto L_0x0132;
    L_0x00b7:
        r0 = com.tencent.mm.plugin.fts.ui.b.a.jvq;
        r0 = r0 + -100;
        r0 = (float) r0;
        r2 = r0 - r2;
        r0 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0132;
    L_0x00c4:
        r0 = r10.get(r1);
        r0 = (com.tencent.mm.plugin.fts.a.a.f) r0;
        r5 = r0.jrR;
        r6 = r13.getTextSize();
        r5 = com.tencent.mm.pluginsdk.ui.d.j.a(r9, r5, r6);
        r6 = r4.length();
        if (r6 <= 0) goto L_0x00e0;
    L_0x00da:
        r6 = ", ";
        r4.append(r6);
    L_0x00e0:
        r6 = new com.tencent.mm.plugin.fts.a.a.d;
        r6.<init>();
        r6.jrw = r5;
        r6.jrx = r12;
        r5 = r0.jry;
        r6.jry = r5;
        r5 = r0.jrU;
        r6.jrz = r5;
        r6.jrC = r2;
        r6.dug = r13;
        r2 = r0.jrS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x011c;
    L_0x00fd:
        r0 = r0.jrS;
        r2 = r13.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r9, r0, r2);
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r2[r3] = r0;
        r0 = "(";
        r2[r8] = r0;
        r0 = android.text.TextUtils.concat(r2);
        r6.jrD = r0;
        r0 = ")";
        r6.jrE = r0;
    L_0x011c:
        r0 = com.tencent.mm.plugin.fts.a.f.a(r6);
        r0 = r0.jrO;
        r4.append(r0);
        r0 = r4.toString();
        r2 = r13.measureText(r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ac;
    L_0x0132:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.m.a(android.content.Context, java.util.List, java.lang.String[], com.tencent.mm.plugin.fts.a.a.g, android.text.TextPaint):java.lang.CharSequence");
    }

    public static final void h(View view, boolean z) {
        if (z) {
            view.setBackgroundResource(n.c.comm_list_item_selector);
        } else {
            view.setBackgroundResource(n.c.comm_list_item_selector_no_divider);
        }
    }

    public static final void i(View view, boolean z) {
        if (z) {
            view.setBackgroundResource(n.c.list_item_normal);
        } else {
            view.setBackgroundResource(n.c.mm_trans);
        }
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt != 0) {
            return optInt;
        }
        if (str.equals(context.getString(n.g.search_education_article))) {
            return 2;
        }
        if (str.equals(context.getString(n.g.search_education_timeline))) {
            return 8;
        }
        if (str.equals(context.getString(n.g.search_education_biz_contact))) {
            return 1;
        }
        x.i("MicroMsg.FTS.FTSUIApiLogic", "option " + str + " no type");
        return optInt;
    }
}
