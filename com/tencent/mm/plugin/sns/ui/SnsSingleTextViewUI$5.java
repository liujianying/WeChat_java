package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class SnsSingleTextViewUI$5 implements d {
    final /* synthetic */ SnsSingleTextViewUI obr;

    SnsSingleTextViewUI$5(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.obr = snsSingleTextViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (SnsSingleTextViewUI.c(this.obr) != null && SnsSingleTextViewUI.c(this.obr).getText() != null) {
                    SnsSingleTextViewUI.d(this.obr).setText(SnsSingleTextViewUI.c(this.obr).getText());
                    h.bA(this.obr.mController.tml, this.obr.mController.tml.getString(j.app_copy_ok));
                    if (SnsSingleTextViewUI.a(this.obr) != null) {
                        int i2 = a.mOt;
                        a.f(2, bi.gd(SnsSingleTextViewUI.a(this.obr).field_snsId), bi.WK(SnsSingleTextViewUI.c(this.obr).getText().toString()));
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (SnsSingleTextViewUI.c(this.obr) != null && SnsSingleTextViewUI.c(this.obr).getText() != null) {
                    ch chVar = new ch();
                    com.tencent.mm.plugin.sns.i.a.a(chVar, SnsSingleTextViewUI.e(this.obr), SnsSingleTextViewUI.c(this.obr).getText());
                    chVar.bJF.activity = this.obr;
                    chVar.bJF.bJM = 18;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    return;
                }
                return;
            case 6:
                if (SnsSingleTextViewUI.c(this.obr) != null && SnsSingleTextViewUI.c(this.obr).getText() != null) {
                    Intent intent = new Intent();
                    n Nl = af.byo().Nl(SnsSingleTextViewUI.e(this.obr));
                    intent.putExtra("k_username", Nl == null ? "" : Nl.field_userName);
                    intent.putExtra("k_expose_msg_id", Nl == null ? Integer.valueOf(0) : Nl.bAK());
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bg.d.b(this.obr, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            case 14:
                if (SnsSingleTextViewUI.c(this.obr) != null && SnsSingleTextViewUI.c(this.obr).getText() != null) {
                    ap.o(af.byo().Nl(SnsSingleTextViewUI.e(this.obr)));
                    return;
                }
                return;
            case 16:
                if (SnsSingleTextViewUI.c(this.obr) != null && SnsSingleTextViewUI.c(this.obr).getText() != null) {
                    ap.p(af.byo().Nl(SnsSingleTextViewUI.e(this.obr)));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
