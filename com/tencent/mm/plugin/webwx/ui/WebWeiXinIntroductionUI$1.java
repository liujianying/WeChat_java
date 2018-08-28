package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class WebWeiXinIntroductionUI$1 implements OnClickListener {
    final /* synthetic */ WebWeiXinIntroductionUI qmH;

    WebWeiXinIntroductionUI$1(WebWeiXinIntroductionUI webWeiXinIntroductionUI) {
        this.qmH = webWeiXinIntroductionUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
        intent.putExtra("from_album", false);
        intent.putExtra("show_intro", false);
        intent.setFlags(65536);
        d.b(this.qmH, "scanner", ".ui.BaseScanUI", intent);
    }
}
