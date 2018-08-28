package com.tencent.mm.plugin.account.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

class RegByMobileRegAIOUI$17 extends ClickableSpan {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$17(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void onClick(View view) {
        bi.L(this.eVb.mController.tml, this.eVb.getString(a$j.license_read_url, new Object[]{w.chP(), w.chO(), "setting", Integer.valueOf(0), Integer.valueOf(0)}));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.eVb.getResources().getColor(c.link_color));
        textPaint.setUnderlineText(true);
    }
}
