package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private q kZX = new q();
    private PayInfo mpb = new PayInfo();
    private boolean pds = false;
    private String pdt;
    private int pdu = -1;
    private com.tencent.mm.plugin.wallet_core.c.a pdv = null;
    private boolean pdw = false;
    c pdx = new 3(this);
    private String token = null;

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        jr(580);
        this.kZX.pzb = new 1(this);
        this.pdt = getIntent().getStringExtra("key_import_key");
        this.pdu = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i = getIntent().getIntExtra("key_bind_scene", 13);
        }
        sz szVar = new sz();
        if (i == 4) {
            szVar.cdR.scene = 20;
        } else {
            szVar.cdR.scene = 13;
        }
        szVar.bJX = new 2(this);
        com.tencent.mm.sdk.b.a.sFg.m(szVar);
        com.tencent.mm.sdk.b.a.sFg.b(this.pdx);
        com.tencent.mm.wallet_core.c.q.fu(6, 0);
    }

    private void bNl() {
        this.mpb.bVZ = this.pdu;
        this.sy.putParcelable("key_pay_info", this.mpb);
        if (this.pdu == 2) {
            if (bi.oW(this.pdt)) {
                zK("");
                return;
            }
            x.d("MicroMsg.WalletBindUI", "importKey " + this.pdt);
            a(new com.tencent.mm.plugin.wallet.bind.a.c(this.pdt, this.mpb), true, false);
        } else if (this.pdu == 4) {
            p.GZ(4);
            if (getIntent() == null) {
                zK("");
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int intExtra = getIntent().getIntExtra("pay_channel", 0);
            if (this.pdu == 6) {
                this.pdv = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.pdv = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            a(this.pdv, true, false);
        } else if (this.pdu == 6) {
            bNm();
        } else {
            zf(this.pdu);
        }
    }

    private void zf(int i) {
        x.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bi.cjd().toString());
        Bundle bundle = this.sy;
        bundle.putParcelable("key_pay_info", this.mpb);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        com.tencent.mm.plugin.wallet.a.p.bNp();
        if (com.tencent.mm.plugin.wallet.a.p.bNq().bPr()) {
            x.i("MicroMsg.WalletBindUI", "user status invalid");
            if (i == 4) {
                a(new y(null, 20), true, false);
                return;
            } else {
                a(new y(null, 12), true, false);
                return;
            }
        }
        com.tencent.mm.plugin.wallet.a.p.bNp();
        if (com.tencent.mm.plugin.wallet.a.p.bNq().bPs()) {
            x.i("MicroMsg.WalletBindUI", "user status reg");
            this.pds = true;
            this.mpb.bVZ = this.pdu;
            bundle.putInt("key_bind_scene", this.mpb.bVZ);
            if (!bi.oW(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle, null);
            return;
        }
        x.i("MicroMsg.WalletBindUI", "user status unreg");
        this.pds = true;
        if (this.pdu >= 0) {
            this.mpb.bVZ = this.pdu;
        } else {
            this.mpb.bVZ = 1;
        }
        bundle.putInt("key_bind_scene", this.mpb.bVZ);
        com.tencent.mm.wallet_core.a.a(this, b.class, bundle, null);
    }

    private void bNm() {
        int i = 0;
        com.tencent.mm.plugin.wallet.a.p.bNp();
        if (com.tencent.mm.plugin.wallet.a.p.bNq().bPr()) {
            a(new y(null, 12), true, false);
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!bi.oW(str) && split.length >= 2) {
            int length = split.length;
            str = null;
            String str2 = null;
            while (i < length) {
                String str3 = split[i];
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
                i++;
            }
            if (!(bi.oW(str) || bi.oW(str2))) {
                com.tencent.mm.plugin.wallet.a.p.bNp();
                if (com.tencent.mm.plugin.wallet.a.p.bNq().Pb(str2)) {
                    Bundle bundle = new Bundle();
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", bundle, null);
                    return;
                }
            }
        }
        finish();
    }

    public void onResume() {
        if (this.pds) {
            finish();
        }
        super.onResume();
        this.kZX.onResume();
    }

    public void onPause() {
        super.onPause();
        this.kZX.onPause();
    }

    public void onDestroy() {
        js(580);
        com.tencent.mm.sdk.b.a.sFg.c(this.pdx);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.kZX.bcc();
            return;
        }
        this.kZX.cancel();
        finish();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            this.pds = true;
        }
        if (i != 0 || i2 != 0) {
            zK(str);
            return true;
        } else if (lVar instanceof y) {
            if (this.pdu == 6) {
                bNm();
            } else {
                bNl();
            }
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            com.tencent.mm.plugin.wallet.bind.a.c cVar = (com.tencent.mm.plugin.wallet.bind.a.c) lVar;
            Bundle bundle = this.sy;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.oZG == null || cVar.oZG.size() <= 0) {
                if (bi.oW(str)) {
                    str = getString(i.wallet_bind_import_fail);
                }
                h.a(this, str, null, false, new 6(this));
            } else {
                Bankcard bankcard = (Bankcard) cVar.oZG.get(0);
                if (bankcard.btA) {
                    h.a(this, i.wallet_card_import_exist, 0, false, new 5(this));
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.pcv);
                    bundle.putString("key_recommand_desc", cVar.pcw);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.pds = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a(this, b.class, bundle, new 4(this));
                }
            }
            return true;
        } else {
            if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                if (this.pdv == null || !this.pdv.equals(lVar)) {
                    p.cDe();
                } else {
                    f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
                    this.token = ((com.tencent.mm.plugin.wallet_core.c.a) lVar).blM();
                    zf(4);
                    return true;
                }
            }
            return false;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.pds);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.pds = bundle.getBoolean("key_is_jump", false);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean bbU() {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            return;
        }
        super.onNewIntent(intent);
        x.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            x.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            x.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
    }

    private void zK(String str) {
        if (bi.oW(str)) {
            str = getString(i.wallet_unknown_err);
        }
        h.a(this, str, null, false, new 7(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
