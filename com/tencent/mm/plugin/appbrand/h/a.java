package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.q.m;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class a implements h {
    public final CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<TextView> weakReference2) {
        com.tencent.mm.y.a.a gw = com.tencent.mm.y.a.a.gw(str);
        if (((Context) weakReference.get()) == null) {
            x.w("MicroMsg.WxaSubscribeMsgService", "context is null");
            return null;
        }
        String str2 = gw.content;
        if (bi.oW(str2)) {
            x.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
            return null;
        }
        String string = bundle.getString("conv_talker_username");
        int i = bundle.getInt("scene");
        long j = bundle.getLong("msg_sever_id");
        String string2 = bundle.getString("send_msg_username");
        CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new 1(this, gw, string, i, j, string2), str2.indexOf(gw.title), str2.indexOf(gw.title) + gw.title.length(), 17);
        x.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[]{Integer.valueOf(gw.dzS)});
        if (gw.dzS == 1) {
            return spannableString;
        }
        WxaAttributes rR = ((c) g.l(c.class)).rR(gw.username);
        String str3 = rR != null ? rR.field_brandIconURL : "";
        if (b.Ka().a(str3, null) == null) {
            b.Ka().a(new 2(this, weakReference2, weakReference, spannableString), str3, null);
            return TextUtils.concat(new CharSequence[]{a(r0, gw.dzT, null), spannableString});
        }
        return TextUtils.concat(new CharSequence[]{a(r0, gw.dzT, b.Ka().a(str3, null)), spannableString});
    }

    private static SpannableString a(Context context, int i, Bitmap bitmap) {
        Drawable drawable;
        if (bitmap == null) {
            drawable = context.getResources().getDrawable(i == 1 ? i.spannable_wxa_game_link_logo : i.spannable_app_brand_link_logo);
        } else {
            drawable = new BitmapDrawable(context.getResources(), bitmap);
        }
        drawable.setBounds(0, 0, m.aos(), m.aos());
        com.tencent.mm.plugin.appbrand.widget.g.b bVar = new com.tencent.mm.plugin.appbrand.widget.g.b(drawable);
        SpannableString spannableString = new SpannableString("@ ");
        spannableString.setSpan(bVar, 0, 1, 33);
        return spannableString;
    }
}
