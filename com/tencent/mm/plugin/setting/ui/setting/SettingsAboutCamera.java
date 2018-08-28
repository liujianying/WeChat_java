package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera extends MMPreference {
    private f eOE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int Ys() {
        return k.settings_pref_camera;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean booleanValue;
        boolean z = true;
        String str = preference.mKey;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            g.Ei().DT().a(a.sVp, Boolean.valueOf(!((Boolean) g.Ei().DT().get(a.sVp, Boolean.valueOf(true))).booleanValue()));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            booleanValue = ((Boolean) g.Ei().DT().get(a.sVr, Boolean.valueOf(true))).booleanValue();
            x DT = g.Ei().DT();
            a aVar = a.sVr;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            DT.a(aVar, Boolean.valueOf(booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            booleanValue = ((Boolean) g.Ei().DT().get(a.sVs, Boolean.valueOf(true))).booleanValue();
            x DT2 = g.Ei().DT();
            a aVar2 = a.sVs;
            if (booleanValue) {
                z = false;
            }
            DT2.a(aVar2, Boolean.valueOf(z));
        }
        return false;
    }

    protected final void initView() {
        this.eOE = this.tCL;
        setMMTitle(i.settings_photo_video);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAboutCamera.this.YC();
                SettingsAboutCamera.this.finish();
                return true;
            }
        });
        boolean booleanValue = ((Boolean) g.Ei().DT().get(a.sVp, Boolean.valueOf(true))).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_auto_mul_terminal_sync");
        checkBoxPreference.tDr = false;
        checkBoxPreference.qpJ = booleanValue;
        booleanValue = ((Boolean) g.Ei().DT().get(a.sVr, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_take_photo_auto_save_photo");
        checkBoxPreference.tDr = false;
        checkBoxPreference.qpJ = booleanValue;
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_take_photo_auto_save_video");
        checkBoxPreference.qpJ = ((Boolean) g.Ei().DT().get(a.sVs, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference.tDr = false;
        this.eOE.notifyDataSetChanged();
    }
}
