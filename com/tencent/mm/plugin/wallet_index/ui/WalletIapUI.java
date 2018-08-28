package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_index.c.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.k;

@a(7)
public class WalletIapUI extends MMActivity implements e {
    private Dialog gvJ;
    private c lSI = new 4(this);
    private boolean pDF = false;
    private b pDG;
    private d pDH = new 2(this);
    private c pDc;
    private d pDe = new 3(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.v("MicroMsg.WalletIapUI", "onCreate");
        g.Ek();
        g.Eh().dpP.a(422, this);
        g.Ek();
        g.Eh().dpP.a(com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.a(1130, this);
        g.Ek();
        g.Eh().dpP.a(1306, this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            this.gvJ = com.tencent.mm.wallet_core.ui.g.a(this, getString(i.app_waiting), new 1(this));
        }
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_mini_program", false);
        this.pDc = new c();
        this.pDc.pDp = booleanExtra;
        if (getIntent().getBooleanExtra("key_force_google", false) || q.GR()) {
            x.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.pDG = new a(this, this.pDc, this.pDe);
        } else {
            x.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.pDG = new f(this.pDc, this.lSI);
        }
        this.pDc.lQa = this.pDG.bRd();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        x.d("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        x.d("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.pDF) {
            this.pDF = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                x.d("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.pDG.b(this, true);
                return;
            }
            c cVar = this.pDc;
            String stringExtra = intent.getStringExtra("key_product_id");
            cVar.iiv = stringExtra;
            cVar.pDo.add(stringExtra);
            x.d("MicroMsg.IapData", "prepare pay product: " + stringExtra);
            this.pDc.pCL = intent.getStringExtra("key_price");
            this.pDc.pCK = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.pDc.mCount = intent.getIntExtra("key_count", 1);
            stringExtra = intent.getStringExtra("key_appid");
            String stringExtra3 = intent.getStringExtra("key_desc");
            String stringExtra4 = intent.getStringExtra("key_busiid");
            this.pDc.pDq = intent.getStringExtra("key_virtual_pay_sign");
            this.pDc.pDr = intent.getStringExtra("key_attach");
            g.Ek();
            o oVar = g.Eh().dpP;
            c cVar2 = this.pDc;
            int bRd = this.pDG.bRd();
            oVar.a(cVar2.pDp ? new d(bRd, stringExtra, cVar2.pCL, stringExtra3, cVar2.mCount, cVar2.pCK, stringExtra4, cVar2.pDq, cVar2.pDr) : new k(cVar2.iiv, cVar2.pCL, cVar2.pCK, cVar2.mCount, bRd, stringExtra2), 0);
        }
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        x.d("MicroMsg.WalletIapUI", "onDestroy");
        if (this.gvJ != null && this.gvJ.isShowing()) {
            this.gvJ.dismiss();
            this.gvJ = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : " + i2);
        if (this.pDG != null) {
            this.pDG.a(this, i, i2, intent);
            x.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            return;
        }
        x.e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(6, "");
        intent2.putExtra("key_err_code", aN.kjf);
        intent2.putExtra("key_err_msg", aN.kjg);
        intent2.putExtra("key_launch_ts", a.pDd);
        setResult(-1, intent2);
        finish();
    }

    public final void a(int i, int i2, String str, l lVar) {
        anm anm = null;
        boolean z = true;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd ErrType:" + i + ", errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.c.a aN = com.tencent.mm.plugin.wallet_index.c.a.aN(i2, str);
        int i3 = aN.kjf;
        String str2 = aN.kjg;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + lVar.getType() + " errCode:" + i3 + ",errMsg:" + str2);
        int type = lVar.getType();
        Intent intent;
        switch (type) {
            case com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX /*414*/:
            case 1306:
                boolean z2;
                c cVar = this.pDc;
                if (lVar instanceof com.tencent.mm.wallet_core.c.l) {
                    com.tencent.mm.wallet_core.c.l lVar2 = (com.tencent.mm.wallet_core.c.l) lVar;
                    cVar.iiv = lVar2.iiv;
                    cVar.pDm = lVar2.iix;
                    cVar.pDn = lVar2.pDn;
                    z2 = lVar2.errCode == 0;
                } else if (lVar instanceof com.tencent.mm.plugin.wallet_index.c.g) {
                    com.tencent.mm.plugin.wallet_index.c.g gVar = (com.tencent.mm.plugin.wallet_index.c.g) lVar;
                    cVar.iiv = gVar.bKk;
                    z2 = gVar.errCode == 0;
                } else {
                    z2 = false;
                }
                cVar.pDo.remove(cVar.iiv);
                if (z2) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.iiv + " OK");
                    cVar.pDk.add(cVar.iiv);
                    cVar.pDl.add(cVar.pDm);
                } else if (!cVar.iiv.startsWith("com.tencent.xin.wco")) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.iiv + " fail");
                } else if (cVar.pDn > 0) {
                    cVar.pDk.add(cVar.iiv);
                    cVar.pDl.add(cVar.pDm);
                    x.i("MicroMsg.IapData", "Verify " + cVar.iiv + " fail and cosume");
                    if (this.pDc.pDo.isEmpty()) {
                        x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                        if (this.pDc.pDk.isEmpty()) {
                            x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                            intent = new Intent();
                            intent.putExtra("key_err_code", i3);
                            intent.putExtra("key_err_msg", str2);
                            intent.putExtra("key_response_position", 3);
                            intent.putExtra("key_launch_ts", a.pDd);
                            setResult(-1, intent);
                            finish();
                            return;
                        }
                        x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.pDc.pDk.size() + ", Consume ...");
                        this.pDG.a(this, this.pDc.pDk, this.pDe, z);
                        return;
                    }
                    return;
                } else {
                    x.i("MicroMsg.IapData", "Verify " + cVar.iiv + " fail");
                }
                z = false;
                if (this.pDc.pDo.isEmpty()) {
                    x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                    if (this.pDc.pDk.isEmpty()) {
                        x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", a.pDd);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.pDc.pDk.size() + ", Consume ...");
                    this.pDG.a(this, this.pDc.pDk, this.pDe, z);
                    return;
                }
                return;
            case 422:
            case 1130:
                c cVar2 = this.pDc;
                com.tencent.mm.plugin.wallet_index.c.a aN2 = com.tencent.mm.plugin.wallet_index.c.a.aN(i3, str2);
                type = aN2.kjf;
                if (lVar instanceof k) {
                    k kVar = (k) lVar;
                    if (type == 0) {
                        bbq bbq;
                        if (cVar2.bRe()) {
                            ann ann;
                            bbq = (bbq) kVar.diG.dIE.dIL;
                            if (bbq != null) {
                                ann ann2 = new ann();
                                ann2.rQl = bbq.sdO;
                                ann2.rQm = bbq.sdP;
                                ann2.bVY = 5;
                                ann2.rQn = bbq.sdQ;
                                x.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + bbq.sdQ);
                                ann = ann2;
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
                                ann = null;
                            }
                            cVar2.pCQ = ann;
                        } else {
                            bbq = (bbq) kVar.diG.dIE.dIL;
                            if (bbq != null) {
                                anm = new anm();
                                anm.rFe = kVar.pCK;
                                anm.lRl = kVar.iiv;
                                anm.lPj = kVar.pCL;
                                anm.rQh = bbq.sdN;
                                x.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + bbq.sdN);
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
                            }
                            cVar2.pCP = anm;
                        }
                    }
                } else if (lVar instanceof d) {
                    d dVar = (d) lVar;
                    if (type == 0 && dVar.errCode == 0) {
                        cVar2.pCQ = dVar.pCQ;
                        cVar2.pCP = dVar.pCP;
                        if (cVar2.bRe()) {
                            if (cVar2.pCQ != null) {
                                cVar2.pDh = cVar2.pCQ.rQh;
                            } else {
                                x.e("MicroMsg.IapData", "iapWxPayData is null");
                            }
                        } else if (cVar2.pCP != null) {
                            cVar2.pDh = cVar2.pCP.rQh;
                        } else {
                            x.e("MicroMsg.IapData", "iapGoogleData is null");
                        }
                    }
                }
                if (aN2.kjf == 0) {
                    this.pDG.a(this, this.pDH);
                    return;
                }
                x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + aN2.kjf + " , errMsg: " + aN2.kjg);
                intent = new Intent();
                intent.putExtra("key_err_code", aN2.kjf);
                intent.putExtra("key_err_msg", aN2.kjg);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                return;
            default:
                x.w("MicroMsg.WalletIapUI", "get a wrong sceneType : " + type);
                return;
        }
    }

    public void finish() {
        x.i("MicroMsg.WalletIapUI", "finish");
        if (this.gvJ != null && this.gvJ.isShowing()) {
            this.gvJ.dismiss();
            this.gvJ = null;
        }
        if (this.pDG != null) {
            this.pDG.j(this);
        }
        g.Ek();
        g.Eh().dpP.b(422, this);
        g.Ek();
        g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.b(1130, this);
        g.Ek();
        g.Eh().dpP.b(1306, this);
        super.finish();
    }
}
