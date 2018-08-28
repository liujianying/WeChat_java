package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wallet_core.ui.h.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class c {
    public static void a(final Context context, TextView textView) {
        boolean z = (context == null || textView == null) ? false : true;
        Assert.assertTrue(z);
        h hVar = new h(context);
        hVar.pvm = new a() {
            public final void onClick(View view) {
                x.i("MicroMsg.PayUUtil", "hy: user clicked the span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        };
        h hVar2 = new h(context);
        hVar2.pvm = new 2(context);
        String charSequence = context.getText(i.wallet_payu_start_introduction).toString();
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(hVar, 94, 115, 33);
        spannableString.setSpan(hVar2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
