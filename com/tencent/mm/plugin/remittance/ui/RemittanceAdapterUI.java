package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String cYO = null;
    public int fdx;
    protected int kTw;
    public boolean myK = false;
    protected com.tencent.mm.plugin.wallet.a myL = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        this.fdx = getIntent().getIntExtra("scene", 0);
        this.cYO = getIntent().getStringExtra("receiver_name");
        this.kTw = getIntent().getIntExtra("pay_channel", -1);
        this.myL = com.tencent.mm.plugin.wallet.a.ac(getIntent());
        if (this.kTw == -1) {
            c cDK = cDK();
            if (cDK != null) {
                this.kTw = cDK.jfZ.getInt("pay_channel", -1);
            }
        }
        if (this.fdx == 1) {
            this.myK = true;
            brl();
        } else if (this.fdx == 3) {
            jr(580);
            if (getIntent() == null) {
                x.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                return;
            }
            com.tencent.mm.plugin.wallet_core.c.a aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            aVar.dox = "RemittanceProcess";
            a(aVar, true, false);
        } else if (this.fdx == 2) {
            if (bi.oW(this.cYO)) {
                x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.fdx);
                finish();
                return;
            }
            c(this.cYO, 31, null);
        } else if (this.fdx != 5 && this.fdx != 6) {
            c(null, 31, null);
        } else if (bi.oW(this.cYO)) {
            x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.fdx);
            finish();
        } else {
            String str = this.cYO;
            x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.fdx + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.myL, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.fdx);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.kTw);
            startActivity(intent);
            setResult(-1);
            finish();
        }
    }

    public void brl() {
        w wVar = new w(this.cYO, this.kTw);
        wVar.dox = "RemittanceProcess";
        a(wVar, false, false);
    }

    public void onDestroy() {
        if (this.fdx == 3) {
            js(580);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.myK) {
            x.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof w) {
            this.myK = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            h.bA(this, str);
            finish();
            return true;
        } else if (lVar instanceof w) {
            w wVar = (w) lVar;
            String str2 = wVar.myl;
            this.cYO = wVar.username;
            if (bi.oW(this.cYO) && bi.oW(str2)) {
                x.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.fdx);
                finish();
                return true;
            }
            if (this.fdx == 1) {
                if (wVar.scene == 33) {
                    this.myL = com.tencent.mm.plugin.wallet.a.cp(this.cYO, 2);
                    this.myL.aM(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.myL = com.tencent.mm.plugin.wallet.a.cp(this.cYO, 3);
                    this.myL.aM(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            Intent intent = new Intent();
            intent.putExtra("fee", wVar.hUL);
            intent.putExtra("desc", wVar.desc);
            intent.putExtra("scan_remittance_id", wVar.myc);
            intent.putExtra("receiver_true_name", e.abZ(wVar.myb));
            intent.putExtra("receiver_true_name_busi", wVar.mxM);
            intent.putExtra("receiver_tips", wVar.myd);
            intent.putExtra("rcvr_new_desc", wVar.mye);
            intent.putExtra("payer_desc", wVar.myf);
            intent.putExtra("rcvr_open_id", wVar.myl);
            intent.putExtra("mch_name", wVar.myi);
            intent.putExtra("mch_info", wVar.myo);
            intent.putExtra("mch_photo", wVar.myj);
            intent.putExtra("mch_type", wVar.mym);
            intent.putExtra("mch_time", wVar.myk);
            if (wVar.myh == 1) {
                intent.putExtra("busi_type", wVar.myh);
                intent.putExtra("rcvr_ticket", wVar.myg);
                intent.putExtra("rcvr_open_id", wVar.myl);
                intent.putExtra("get_pay_wifi", wVar.myn);
                if (wVar.myp != null) {
                    intent.putExtra("BusiRemittanceResp", wVar.myp);
                }
            }
            g.Ek();
            ab Yf = ((i) g.l(i.class)).FR().Yf(this.cYO);
            com.tencent.mm.aa.c.J(this.cYO, 3);
            if (Yf != null || this.cYO.equals("")) {
                c(this.cYO, wVar.scene, intent);
            } else {
                x.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                am.a.dBr.a(this.cYO, "", new 1(this, bi.VF(), wVar, intent));
            }
            return true;
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
            c(null, 31, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.fdx + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.myL, intent2);
        if (intent2.getIntExtra("busi_type", 0) == 1) {
            intent2.setClass(this, RemittanceBusiUI.class);
        } else {
            intent2.setClass(this, RemittanceUI.class);
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.fdx);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.kTw);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
