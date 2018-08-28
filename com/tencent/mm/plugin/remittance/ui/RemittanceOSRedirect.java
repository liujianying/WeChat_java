package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String cYO = "";
    private int fdx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.fdx = getIntent().getIntExtra("scene", 0);
        this.cYO = getIntent().getStringExtra("receiver_name");
        if (this.fdx == 0) {
            x.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[]{Integer.valueOf(this.fdx)});
            finish();
        } else if (this.fdx == 5) {
            this.uYO.jr(1574);
            a(new z(q.GM()), true, true);
        } else if (this.fdx == 6) {
            this.uYO.jr(1301);
            a(new r(this.cYO), true, false);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return true;
    }

    public final void b(int i, int i2, String str, l lVar, boolean z) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof z) {
                z zVar = (z) lVar;
                x.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[]{zVar.myA});
                Intent intent = getIntent();
                if (zVar.hUw == 1) {
                    h.a(this, 2, this.cYO, 11, null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", zVar.hUw);
                    intent.putExtra("os_currencyuint", zVar.myA);
                    intent.putExtra("os_currencywording", zVar.myB);
                    intent.putExtra("os_notice", zVar.hUy);
                    intent.putExtra("os_notice_url", zVar.hUz);
                    startActivity(intent);
                }
                finish();
            } else if (lVar instanceof r) {
                r rVar = (r) lVar;
                Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.cYO = rVar.mxw;
                if (bi.oW(this.cYO)) {
                    x.e("MicroMsg.RemittanceOSRedirect", "empty username");
                    finish();
                }
                intent2.putExtra("scene", this.fdx);
                intent2.putExtra("fee", ((double) rVar.cfh) / 100.0d);
                intent2.putExtra("desc", rVar.desc);
                intent2.putExtra("scan_remittance_id", rVar.mxy);
                intent2.putExtra("receiver_name", rVar.mxw);
                intent2.putExtra("receiver_true_name", rVar.hUA);
                intent2.putExtra("receiver_nick_name", rVar.mxx);
                intent2.putExtra("hk_currency", rVar.hUw);
                intent2.putExtra("hk_currencyuint", rVar.hUx);
                intent2.putExtra("hk_notice", rVar.hUy);
                intent2.putExtra("hk_notice_url", rVar.hUz);
                int i3 = 32;
                x.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[]{Integer.valueOf(rVar.hUB)});
                if (rVar.hUB == 1) {
                    i3 = 33;
                }
                intent2.putExtra("pay_scene", i3);
                g.Ek();
                if (((i) g.l(i.class)).FR().Yf(this.cYO) != null) {
                    startActivity(intent2);
                    finish();
                    return;
                }
                x.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
                am.a.dBr.a(this.cYO, "", new 1(this, bi.VF(), intent2));
            }
        } else if (lVar instanceof z) {
            x.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[]{str});
            com.tencent.mm.ui.base.h.a(this, str, "", new 2(this));
        } else if (lVar instanceof r) {
            com.tencent.mm.ui.base.h.a(this, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RemittanceOSRedirect.this.finish();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.fdx == 5) {
            js(1574);
        } else if (this.fdx == 6) {
            js(1301);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
