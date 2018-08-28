package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI extends MMPreference {
    private f eOE;
    private boolean gju;
    private long hXx;
    private int mRK;
    private CheckBoxPreference mSl;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = q.GG();
        if (bi.oW(this.username)) {
            this.username = q.GF();
        }
        this.eOE = this.tCL;
        this.hXx = q.GK();
        this.mRK = q.GL();
        initView();
        setBackBtn(new 1(this));
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(i.settings_username);
        this.eOE.ZZ("settings_my_username").setSummary(this.username);
        boolean z2 = (this.hXx & 16384) != 0;
        this.gju = z2;
        x.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[]{Boolean.valueOf(z2)});
        this.mSl = (CheckBoxPreference) this.eOE.ZZ("settings_show_username");
        this.mSl.tDr = false;
        CheckBoxPreference checkBoxPreference = this.mSl;
        if (z2) {
            z = false;
        }
        checkBoxPreference.qpJ = z;
        if (bi.oW(q.GH())) {
            this.mSl.setEnabled(false);
        }
        this.eOE.notifyDataSetChanged();
    }

    public final int Ys() {
        return k.settings_hide_username;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (!preference.mKey.equals("settings_show_username")) {
            return false;
        }
        if (!((CheckBoxPreference) preference).isChecked()) {
            z = true;
        }
        this.gju = z;
        btH();
        return true;
    }

    private void btH() {
        if (this.gju) {
            this.mSl.setSummary(getString(i.settings_show_username_open_hint));
        } else if (this.mSl.isEnabled()) {
            this.mSl.setSummary(getString(i.settings_show_username_close_hint));
        } else {
            this.mSl.setSummary(getString(i.settings_show_username_disable_hint));
        }
    }

    protected void onResume() {
        super.onResume();
        btH();
    }

    protected void onPause() {
        boolean z = false;
        int i = 1;
        super.onPause();
        x.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[]{Boolean.valueOf(this.gju)});
        if ((this.hXx & 16384) != 0) {
            z = true;
        }
        if (z != this.gju) {
            if (this.gju) {
                this.hXx |= 16384;
                this.mRK |= 512;
            } else {
                this.hXx &= -16385;
                this.mRK &= -513;
            }
            g.Ek();
            g.Ei().DT().set(147457, Long.valueOf(this.hXx));
            g.Ek();
            g.Ei().DT().set(40, Integer.valueOf(this.mRK));
            xt xtVar = new xt();
            xtVar.rDz = 46;
            if (this.gju) {
                i = 2;
            }
            xtVar.rDA = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new a(23, xtVar));
        }
    }
}
