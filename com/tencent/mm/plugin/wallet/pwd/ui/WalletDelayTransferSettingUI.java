package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletDelayTransferSettingUI extends MMPreference implements e {
    private String cZH;
    private f eOE;
    private long hXx;
    private String mzm;
    private Preference pho;
    private Preference php;
    private Preference phq;
    private Preference phr;
    private String phs;
    private int pht = 0;

    public void onCreate(Bundle bundle) {
        boolean a;
        super.onCreate(bundle);
        this.eOE = this.tCL;
        this.eOE.addPreferencesFromResource(l.wallet_delay_transfer_setting_pref);
        g.Ek();
        this.hXx = ((Long) g.Ei().DT().get(147457, Long.valueOf(0))).longValue();
        initView();
        g.Ek();
        g.Eh().dpP.a(385, this);
        g.Ek();
        this.phs = (String) g.Ei().DT().get(a.sVk, "");
        g.Ek();
        this.cZH = (String) g.Ei().DT().get(a.sVj, "");
        g.Ek();
        this.mzm = (String) g.Ei().DT().get(a.sVm, "");
        g.Ek();
        this.pht = ((Integer) g.Ei().DT().get(a.sVn, Integer.valueOf(0))).intValue();
        if (bi.oW(this.phs) || bi.oW(this.cZH) || bi.oW(this.mzm)) {
            a = ae.a(true, null);
        } else {
            this.phr.setTitle(this.phs);
            setMMTitle(this.cZH);
            bNY();
            a = ae.a(false, null);
        }
        com.tencent.mm.wallet_core.ui.e.cDN();
        if (!a) {
            x.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            g.Ek();
            g.Eh().dpP.b(385, this);
        }
    }

    private void bNY() {
        if (this.pht != 1 || bi.oW(this.mzm)) {
            this.mController.removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, a$e.wallet_qanda_icon, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.l(WalletDelayTransferSettingUI.this.mController.tml, WalletDelayTransferSettingUI.this.mzm, false);
                    return false;
                }
            });
        }
    }

    protected final void initView() {
        this.pho = this.eOE.ZZ("wallet_transfer_realtime");
        this.php = this.eOE.ZZ("wallet_transfer_2h");
        this.phq = this.eOE.ZZ("wallet_transfer_24h");
        this.phr = this.eOE.ZZ("wallet_transfer_title_tips");
        bNZ();
        setBackBtn(new 2(this));
    }

    protected void onDestroy() {
        int i = 1;
        super.onDestroy();
        x.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[]{Long.valueOf(this.hXx)});
        if (!uL(16)) {
            i = uL(32) ? 2 : 0;
        }
        auq auq = new auq();
        auq.mEc = i;
        ((i) g.l(i.class)).FQ().b(new h.a(205, auq));
        g.Ek();
        g.Eh().dpP.b(385, this);
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if ("wallet_transfer_realtime".equals(str)) {
            this.hXx &= -17;
            this.hXx &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.hXx &= -33;
            this.hXx |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.hXx &= -17;
            this.hXx |= 32;
        }
        bNZ();
        g.Ek();
        g.Ei().DT().set(147457, Long.valueOf(this.hXx));
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof ae) {
            if (i == 0 && i2 == 0) {
                this.phs = ((ae) lVar).pjL;
                this.cZH = ((ae) lVar).pjK;
                this.mzm = ((ae) lVar).pjN;
                this.pht = ((ae) lVar).pjO;
                if (bi.oW(this.phs)) {
                    x.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.phr.setTitle(com.tencent.mm.plugin.wxpay.a.i.wallet_delay_transfer_setting_title_hardcode_tip);
                } else {
                    this.phr.setTitle(this.phs);
                }
                if (bi.oW(this.cZH)) {
                    x.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    setMMTitle(com.tencent.mm.plugin.wxpay.a.i.wallet_password_setting_delay_transfer_date);
                } else {
                    setMMTitle(this.cZH);
                }
                bNY();
            } else {
                x.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.phr.setTitle(com.tencent.mm.plugin.wxpay.a.i.wallet_delay_transfer_setting_title_hardcode_tip);
                setMMTitle(com.tencent.mm.plugin.wxpay.a.i.wallet_password_setting_delay_transfer_date);
            }
            this.eOE.notifyDataSetChanged();
            return;
        }
        x.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    }

    private boolean uL(int i) {
        return (this.hXx & ((long) i)) != 0;
    }

    private void bNZ() {
        if (uL(16)) {
            this.pho.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
            this.php.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_checked);
            this.phq.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
        } else if (uL(32)) {
            this.pho.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
            this.php.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
            this.phq.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_checked);
        } else {
            this.pho.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_checked);
            this.php.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
            this.phq.setWidgetLayoutResource(com.tencent.mm.plugin.wxpay.a.g.mm_preference_radio_unchecked);
        }
    }
}
