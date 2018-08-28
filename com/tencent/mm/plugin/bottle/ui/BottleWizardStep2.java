package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class BottleWizardStep2 extends MMPreference {
    private c hlA;

    public final int Ys() {
        return R.o.bottle_wizard_step2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.settings_personal_info);
        this.hlA = new c(this, this.tCL);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.app_nextstep), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.auq();
                bl IC = bl.IC();
                if (bi.a(Integer.valueOf(IC.sex), 0) <= 0) {
                    h.b(BottleWizardStep2.this.mController.tml, BottleWizardStep2.this.getString(R.l.bottle_settings_change_info_err_sex), BottleWizardStep2.this.getString(R.l.app_tip), true);
                } else if (bi.oW(IC.getProvince())) {
                    h.b(BottleWizardStep2.this.mController.tml, BottleWizardStep2.this.getString(R.l.bottle_settings_change_info_err_district), BottleWizardStep2.this.getString(R.l.app_tip), true);
                } else {
                    Intent intent = new Intent().setClass(BottleWizardStep2.this, BottleBeachUI.class);
                    intent.addFlags(67108864);
                    BottleWizardStep2.this.startActivity(intent);
                    BottleWizardStep2.this.finish();
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent().setClass(this, BottleWizardStep1.class);
        intent.addFlags(67108864);
        startActivity(intent);
        YC();
        finish();
    }

    public void onResume() {
        super.onResume();
        this.hlA.update();
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str.equals("settings_district")) {
            return this.hlA.aus();
        }
        if (str.equals("settings_signature")) {
            return this.hlA.aur();
        }
        return false;
    }
}
