package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$6 extends ag {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$6(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void handleMessage(Message message) {
        h f;
        synchronized (BaseScanUI.n(this.mHS)) {
            f = BaseScanUI.f(this.mHS);
        }
        if (message == null) {
            x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler msg is null");
        } else if (BaseScanUI.w(this.mHS)) {
            x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler click too quick, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
        } else {
            BaseScanUI.d(this.mHS, true);
            if (BaseScanUI.h(this.mHS) != null) {
                if (BaseScanUI.x(this.mHS) == message.what) {
                    BaseScanUI.d(this.mHS, false);
                    return;
                }
                BaseScanUI.h(this.mHS).onPause();
                if (BaseScanUI.h(this.mHS).bsk() != null) {
                    BaseScanUI.h(this.mHS).bsk().ll();
                }
                BaseScanUI.h(this.mHS).onDestroy();
                BaseScanUI.a(this.mHS, null);
            }
            if (!BaseScanUI.a(this.mHS) || BaseScanUI.b(this.mHS)) {
                BaseScanUI.b(this.mHS, false);
            } else {
                BaseScanUI.b(this.mHS, true);
            }
            if (BaseScanUI.y(this.mHS) && message.what != 1) {
                Toast.makeText(this.mHS, R.l.scan_device_not_support, 0).show();
                BaseScanUI.z(this.mHS).setSelectedMode(1);
                BaseScanUI.d(this.mHS, false);
            } else if (this.mHS.isFinishing()) {
                x.w("MicroMsg.scanner.BaseScanUI", "selectScanModeHandler is invoke after ui was destroyed, msg.what=[%s]", new Object[]{Integer.valueOf(message.what)});
            } else {
                if (f != null) {
                    f.vF(message.what);
                }
                BaseScanUI.a(this.mHS, message.what);
                switch (message.what) {
                    case 1:
                        if (!BaseScanUI.A(this.mHS)) {
                            this.mHS.setMMTitle(R.l.scan_entry_qrcode_zbar);
                            BaseScanUI.a(this.mHS, new p(this.mHS, BaseScanUI.B(this.mHS), BaseScanUI.C(this.mHS), 0));
                            break;
                        }
                        this.mHS.setMMTitle(R.l.scan_entry_qrcode);
                        BaseScanUI.a(this.mHS, new p(this.mHS, BaseScanUI.B(this.mHS), BaseScanUI.C(this.mHS), 1));
                        break;
                    case 2:
                        this.mHS.setMMTitle(p.et(p.mOb, this.mHS.getString(R.l.scan_img_title)));
                        BaseScanUI.a(this.mHS, new k(this.mHS, BaseScanUI.B(this.mHS)));
                        break;
                    case 3:
                        this.mHS.setMMTitle(R.l.scan_entry_ocr);
                        BaseScanUI.a(this.mHS, new o(this.mHS, BaseScanUI.B(this.mHS)));
                        break;
                    case 4:
                        this.mHS.setMMTitle(R.l.scan_entry_qrcode_zbar);
                        BaseScanUI.a(this.mHS, new p(this.mHS, BaseScanUI.B(this.mHS), BaseScanUI.C(this.mHS), 2));
                        break;
                    case 5:
                        this.mHS.setMMTitle(R.l.scan_entry_street);
                        BaseScanUI.a(this.mHS, new q(this.mHS, BaseScanUI.B(this.mHS)));
                        boolean a = a.a(this.mHS, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
                        x.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[]{Boolean.valueOf(a), bi.cjd()});
                        break;
                    case 8:
                        this.mHS.setMMTitle(R.l.scan_entry_qrcode);
                        BaseScanUI.a(this.mHS, new p(this.mHS, BaseScanUI.B(this.mHS), BaseScanUI.C(this.mHS), 1));
                        break;
                }
                if (f != null && f.isOpen() && f.iOl) {
                    f.btg();
                    f.vH(1);
                }
                l.mFT.reset();
                BaseScanUI.q(this.mHS);
                BaseScanUI.d(this.mHS, false);
            }
        }
    }
}
