package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.h;

@a(3)
public class HoneyPayProxyUI extends HoneyPayBaseUI {
    private String kkc;
    private boolean klL;

    static /* synthetic */ void b(HoneyPayProxyUI honeyPayProxyUI, bdk bdk) {
        x.i(honeyPayProxyUI.TAG, "go to card detail");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.kkc);
        intent.putExtra("key_scene", 1);
        try {
            intent.putExtra("key_qry_response", bdk.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace(honeyPayProxyUI.TAG, e, "", new Object[0]);
        }
        honeyPayProxyUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(2876);
        jr(2613);
        this.klL = getIntent().getBooleanExtra("key_is_payer", false);
        this.kkc = getIntent().getStringExtra("key_card_no");
        x.i(this.TAG, "is payer: %s", new Object[]{Boolean.valueOf(this.klL)});
        if (this.klL) {
            x.i(this.TAG, "do qry payer detail");
            l lVar = new l(this.kkc);
            lVar.m(this);
            a(lVar, true, false);
            return;
        }
        m mVar = new m(this.kkc);
        mVar.m(this);
        a(mVar, true, false);
    }

    protected final void aWd() {
    }

    public void onDestroy() {
        super.onDestroy();
        js(2876);
        js(2613);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof l) {
            l lVar2 = (l) lVar;
            lVar2.a(new 3(this, lVar2)).b(new 2(this)).c(new h.a() {
                public final void g(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
                }
            });
        } else if (lVar instanceof m) {
            final m mVar = (m) lVar;
            mVar.a(new h.a() {
                public final void g(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
                    x.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[]{Integer.valueOf(mVar.kjN.rIz.state)});
                    if (mVar.kjN.rIz.state == 1) {
                        HoneyPayProxyUI.a(HoneyPayProxyUI.this, mVar.kjN);
                    } else {
                        HoneyPayProxyUI.b(HoneyPayProxyUI.this, mVar.kjN);
                    }
                    HoneyPayProxyUI.this.finish();
                }
            }).b(new 5(this)).c(new 4(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean aWj() {
        return true;
    }
}
