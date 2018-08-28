package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;

class IPCallShareCouponUI$5 extends ClickableSpan {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$5(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.kyP.getResources().getColor(R.e.transparent));
        String str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
        String fD = w.fD(ad.getContext());
        if (!bi.oW(fD)) {
            str = str + "&wechat_real_lang=" + fD;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.kyP, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.kyP.getResources().getColor(R.e.link_color));
        textPaint.setUnderlineText(false);
    }
}
