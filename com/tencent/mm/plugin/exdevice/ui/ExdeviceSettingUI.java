package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ExdeviceSettingUI extends MMPreference implements e {
    int bWA = -1;
    private final String iFQ = "notify_rank";
    private final String iFR = "notify_like";
    private final String iFS = "join_rank";
    boolean iFT;
    private ProgressDialog iFU;
    private CheckBoxPreference iFV;
    private CheckBoxPreference iFW;
    private CheckBoxPreference iFX;
    private boolean iFY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.kB(38);
        au.DF().a(1044, this);
        this.iFV = (CheckBoxPreference) this.tCL.ZZ("notify_rank");
        this.iFW = (CheckBoxPreference) this.tCL.ZZ("notify_like");
        this.iFX = (CheckBoxPreference) this.tCL.ZZ("join_rank");
        au.HU();
        Integer num = (Integer) c.DT().get(397310, Integer.valueOf(0));
        x.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[]{num});
        if (num == null || num.intValue() == 0) {
            this.iFT = false;
            this.iFV.qpJ = true;
            this.iFW.qpJ = true;
            this.iFX.qpJ = true;
            this.tCL.notifyDataSetChanged();
            this.iFU = p.show(this, "", "", true, false);
        } else {
            this.iFT = true;
            this.bWA = num.intValue();
            aIm();
        }
        au.DF().a(new n(2, 0), 0);
        setMMTitle(R.l.regbyfacebook_reg_setpwd_setnow);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceSettingUI.this.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(1044, this);
        if (this.iFU != null && this.iFU.isShowing()) {
            this.iFU.dismiss();
        }
        if (this.iFT) {
            if (this.iFV.isChecked()) {
                this.bWA |= 1;
            } else {
                this.bWA &= -2;
            }
            if (this.iFW.isChecked()) {
                this.bWA |= 2;
            } else {
                this.bWA &= -3;
            }
            if (this.iFX.isChecked()) {
                this.bWA |= 8;
            } else {
                this.bWA &= -9;
            }
            au.HU();
            c.DT().set(397310, Integer.valueOf(this.bWA));
            x.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[]{Integer.valueOf(this.bWA)});
            au.DF().a(new n(1, this.bWA), 0);
        }
    }

    public final int Ys() {
        return R.o.exdevice_setting_pref;
    }

    private void aIm() {
        boolean z;
        boolean z2 = true;
        this.iFV.qpJ = (this.bWA & 1) == 1;
        CheckBoxPreference checkBoxPreference = this.iFW;
        if ((this.bWA & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.qpJ = z;
        CheckBoxPreference checkBoxPreference2 = this.iFX;
        if ((this.bWA & 8) != 8) {
            z2 = false;
        }
        checkBoxPreference2.qpJ = z2;
        this.tCL.notifyDataSetChanged();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            n nVar = (n) lVar;
            if (nVar.opType != 2) {
                x.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[]{Integer.valueOf(nVar.opType)});
                return;
            }
            if (this.iFU != null && this.iFU.isShowing()) {
                runOnUiThread(new 2(this));
            }
            this.iFT = true;
            if (this.bWA == nVar.iyc) {
                x.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[]{Integer.valueOf(this.bWA)});
                return;
            }
            this.bWA = nVar.iyc;
            x.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[]{Integer.valueOf(this.bWA)});
            au.HU();
            c.DT().set(397310, Integer.valueOf(this.bWA));
            if (!this.iFY) {
                aIm();
                return;
            }
            return;
        }
        if (this.iFU != null && this.iFU.isShowing()) {
            runOnUiThread(new 3(this));
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[]{preference.mKey});
        if (preference.mKey.equals("black_contact_list")) {
            com.tencent.mm.bg.d.A(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.iFY = true;
        }
        return false;
    }
}
