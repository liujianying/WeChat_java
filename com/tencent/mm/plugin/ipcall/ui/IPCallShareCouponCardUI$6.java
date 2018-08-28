package com.tencent.mm.plugin.ipcall.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;

class IPCallShareCouponCardUI$6 extends ClickableSpan {
    final /* synthetic */ IPCallShareCouponCardUI kyi;
    final /* synthetic */ String kyn;

    IPCallShareCouponCardUI$6(IPCallShareCouponCardUI iPCallShareCouponCardUI, String str) {
        this.kyi = iPCallShareCouponCardUI;
        this.kyn = str;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.kyi.getResources().getColor(R.e.transparent));
        h.mEJ.h(13340, new Object[]{Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1)});
        com.tencent.mm.ui.base.h.b(this.kyi.mController.tml, this.kyn, this.kyi.getString(R.l.ipcall_share_coupon_promotion_title), true).a(R.l.ip_call_alter_tip_ok, new 1(this));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.kyi.getResources().getColor(R.e.link_color));
        textPaint.setUnderlineText(false);
    }
}
