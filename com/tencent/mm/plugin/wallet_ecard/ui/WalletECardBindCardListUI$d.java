package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.x;

class WalletECardBindCardListUI$d implements b {
    TextView gsY;
    TextView hBv;
    final /* synthetic */ WalletECardBindCardListUI pCn;
    CdnImageView pCq;

    public WalletECardBindCardListUI$d(WalletECardBindCardListUI walletECardBindCardListUI, View view) {
        this.pCn = walletECardBindCardListUI;
        this.pCq = (CdnImageView) view.findViewById(f.bcard_bind_card_iv);
        this.gsY = (TextView) view.findViewById(f.bcard_bind_card_title_tv);
        this.hBv = (TextView) view.findViewById(f.bcard_bind_card_subtitle_tv);
    }

    public final void a(View view, ff ffVar) {
        if (ffVar != null) {
            this.pCq.setRoundCorner(true);
            this.pCq.setUrl(ffVar.rgd);
            this.gsY.setText(String.format("%s %s(%s)", new Object[]{ffVar.knE, ffVar.hFn, ffVar.rgb}));
            this.hBv.setText(String.format("%s", new Object[]{ffVar.pjw}));
            if (ffVar.rge) {
                x.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", new Object[]{ffVar.knE});
                view.setEnabled(false);
                this.gsY.setTextColor(this.pCn.getResources().getColor(c.big_line_color));
                this.hBv.setTextColor(this.pCn.getResources().getColor(c.big_line_color));
                return;
            }
            view.setEnabled(true);
            this.gsY.setTextColor(this.pCn.getResources().getColor(c.black));
            this.hBv.setTextColor(this.pCn.getResources().getColor(c.normal_color));
        }
    }
}
