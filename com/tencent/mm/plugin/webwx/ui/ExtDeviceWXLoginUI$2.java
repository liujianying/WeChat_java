package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aa.a;

class ExtDeviceWXLoginUI$2 implements OnClickListener {
    final /* synthetic */ ExtDeviceWXLoginUI qmq;

    ExtDeviceWXLoginUI$2(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        this.qmq = extDeviceWXLoginUI;
    }

    public final void onClick(View view) {
        if (ExtDeviceWXLoginUI.b(this.qmq) == 0) {
            if (ExtDeviceWXLoginUI.c(this.qmq)) {
                boolean z;
                boolean isChecked = ((CheckBox) this.qmq.findViewById(R.h.status_content_checkbox)).isChecked();
                ExtDeviceWXLoginUI.a(this.qmq, false);
                if (isChecked) {
                    au.HU();
                    c.DT().a(a.sUW, Boolean.valueOf(true));
                } else {
                    au.HU();
                    if (((Boolean) c.DT().get(a.sUW, Boolean.valueOf(true))).booleanValue()) {
                        ExtDeviceWXLoginUI.a(this.qmq, true);
                    }
                    au.HU();
                    c.DT().a(a.sUW, Boolean.valueOf(false));
                }
                ExtDeviceWXLoginUI extDeviceWXLoginUI = this.qmq;
                if (ExtDeviceWXLoginUI.c(this.qmq) && isChecked) {
                    z = true;
                } else {
                    z = false;
                }
                ExtDeviceWXLoginUI.b(extDeviceWXLoginUI, z);
                return;
            }
            ExtDeviceWXLoginUI.b(this.qmq, false);
        } else if (ExtDeviceWXLoginUI.b(this.qmq) == -2) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            intent.putExtra("from_album", false);
            intent.putExtra("show_intro", false);
            intent.setFlags(65536);
            d.b(this.qmq, "scanner", ".ui.BaseScanUI", intent);
            this.qmq.finish();
        }
    }
}
