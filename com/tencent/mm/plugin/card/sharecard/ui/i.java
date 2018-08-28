package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    MMActivity gKS;
    View hAr;
    TextView hAs;
    TextView hAt;
    private boolean hAu = false;
    private View hyK;

    public i(MMActivity mMActivity, View view) {
        this.gKS = mMActivity;
        this.hyK = view;
    }

    public final void aL() {
        Integer num = (Integer) am.axn().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || b.axI()) {
            this.hAr.setVisibility(8);
            return;
        }
        this.hAr.setVisibility(0);
        this.hAs.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.nF(10))) {
            this.hAs.setVisibility(8);
        } else {
            this.hAs.setVisibility(0);
            this.hAs.setText(shareCardInfo.nF(10));
        }
        if (TextUtils.isEmpty("")) {
            this.hAt.setVisibility(8);
            return;
        }
        this.hAt.setVisibility(0);
        this.hAt.setText("");
    }
}
