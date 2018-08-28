package com.tencent.mm.plugin.account.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.account.a$c;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

class k$6 extends ClickableSpan {
    final /* synthetic */ MobileInputUI eSB;
    final /* synthetic */ k eSG;

    k$6(k kVar, MobileInputUI mobileInputUI) {
        this.eSG = kVar;
        this.eSB = mobileInputUI;
    }

    public final void onClick(View view) {
        bi.L(this.eSB, ad.getResources().getString(j.license_read_url, new Object[]{w.fD(this.eSB), w.chO(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.eSB.getResources().getColor(a$c.link_color));
        textPaint.setUnderlineText(true);
    }
}
