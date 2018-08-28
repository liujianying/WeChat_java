package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingRedesign extends MMPreference {
    private f eOE;
    private boolean mQO;

    public final int Ys() {
        return k.setting_redesign;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final void initView() {
        boolean z = false;
        setMMTitle("Redesign");
        this.eOE = this.tCL;
        this.mQO = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("redesign_actionbar");
        if (checkBoxPreference != null) {
            if (!this.mQO) {
                z = true;
            }
            checkBoxPreference.qpJ = z;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingRedesign.this.finish();
                SettingRedesign.this.refresh();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("redesign_actionbar")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
            } else {
                ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
            }
        }
        return false;
    }

    private void refresh() {
        if (this.mQO != ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            b.ezn.q(intent, this.mController.tml);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        refresh();
        return true;
    }
}
