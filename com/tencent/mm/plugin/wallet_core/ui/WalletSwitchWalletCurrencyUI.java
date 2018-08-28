package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private p pyA = null;
    private x pyB;
    private x pyC;
    private ListView pyy;
    private ArrayList<x> pyz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_switch_wallet_type);
        g.Ek();
        g.Ei().DT().a(a.sSo, Boolean.valueOf(true));
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.pyz = o.bOZ().bPT();
        if (this.pyz == null || this.pyz.size() == 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            jD(true);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            jD(false);
        }
        initView();
        setResult(0);
    }

    protected final void initView() {
        this.pyy = (ListView) findViewById(f.settings_wallet_type_list);
        this.pyA = new p(this, this.pyz);
        this.pyy.setAdapter(this.pyA);
        if (this.pyz != null && this.pyz.size() > 0) {
            this.pyA.mData = this.pyz;
            this.pyA.notifyDataSetChanged();
        }
        this.pyy.setOnItemClickListener(new 1(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.l) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.pyz = o.bOZ().bPT();
                this.pyA.mData = this.pyz;
                this.pyA.notifyDataSetChanged();
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.pyz == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                return false;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            return true;
        } else if (!(lVar instanceof p) || i != 0 || i2 != 0) {
            return false;
        } else {
            this.pyB.field_wallet_selected = 1;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.pyB.field_wallet_type + " " + this.pyB.field_wallet_tpa_country_mask);
            ap.ccb().reset();
            o.bOZ().c(this.pyB, new String[0]);
            x xVar = this.pyA.pyE;
            if (xVar != null) {
                xVar.field_wallet_selected = 0;
                o.bOZ().c(xVar, new String[0]);
            }
            g.Ek();
            g.Ei().DT().set(339975, Integer.valueOf(this.pyB.field_wallet_type));
            g.Ek();
            g.Ei().DT().a(a.sTs, Integer.valueOf(this.pyB.field_wallet_tpa_country_mask));
            if (q.GT()) {
                o.bOR();
                o.w(this, null);
            }
            setResult(-1);
            finish();
            return true;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_switch_wallet_kind;
    }

    private void jD(boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = " + z);
        a(new com.tencent.mm.plugin.wallet_core.c.l(), z, false);
    }

    public void onClick(View view) {
    }
}
