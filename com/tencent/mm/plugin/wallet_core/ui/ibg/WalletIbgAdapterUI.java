package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(4);
        this.uYO.jr(1564);
        a(new b(), true, false);
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof b)) {
            int i3 = ((b) lVar).pjQ;
            String str2 = ((b) lVar).jumpUrl;
            x.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[]{str2, Integer.valueOf(i3)});
            if (i3 == 1) {
                boolean z;
                x.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[]{Integer.valueOf(u.a.cbE())});
                switch (u.a.cbE()) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        g.Ek();
                        if (((Boolean) g.Ei().DT().get(aa.a.sSV, Boolean.valueOf(false))).booleanValue()) {
                            Toast.makeText(this, getString(i.webview_tbs_downloading), 1).show();
                            u.a.eQ(this);
                            finish();
                        } else {
                            bQI();
                        }
                        z = false;
                        break;
                    default:
                        bQI();
                        z = false;
                        break;
                }
                if (z) {
                    Py(str2);
                    finish();
                }
            } else {
                Py(str2);
                finish();
            }
        } else {
            com.tencent.mm.wallet_core.a.c(this, null, 0);
        }
        return false;
    }

    public void onDestroy() {
        this.uYO.js(1564);
        super.onDestroy();
    }

    private void Py(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void bQI() {
        g.Ek();
        g.Ei().DT().a(aa.a.sSV, Boolean.valueOf(true));
        h.a(this, false, getString(i.webview_tbs_need_download), "", getString(i.webview_tbs_download_ok), getString(i.webview_tbs_download_cancel), new 1(this), new 2(this));
    }

    protected final int getLayoutId() {
        return -1;
    }
}
