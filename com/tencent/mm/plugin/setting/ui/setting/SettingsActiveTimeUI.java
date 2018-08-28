package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean bGv = false;
    private f eOE;
    private Preference gYX;
    private Preference gYY;
    private int mRD;
    private int mRE;
    private int mRF;
    private int mRG;
    private boolean mRH = false;
    private final OnTimeSetListener mRI = new 2(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.settings_active_time);
        this.eOE = this.tCL;
        initView();
    }

    protected final void initView() {
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(k.settings_pref_active_time);
        this.gYY = this.eOE.ZZ("settings_active_begin_time");
        this.mRD = com.tencent.mm.k.f.Ar();
        this.mRE = com.tencent.mm.k.f.At();
        this.gYY.setSummary(f(this, this.mRD, this.mRE));
        this.gYX = this.eOE.ZZ("settings_active_end_time");
        this.mRF = com.tencent.mm.k.f.Aq();
        this.mRG = com.tencent.mm.k.f.As();
        this.gYX.setSummary(f(this, this.mRF, this.mRG));
        this.bGv = !com.tencent.mm.k.f.Ap();
        ((CheckBoxPreference) this.eOE.ZZ("settings_active_silence_time")).qpJ = this.bGv;
        if (this.bGv) {
            this.gYY.setEnabled(true);
            this.gYX.setEnabled(true);
        } else {
            this.gYY.setEnabled(false);
            this.gYX.setEnabled(false);
        }
        if (!this.bGv) {
            this.eOE.c(this.gYY);
            this.eOE.c(this.gYX);
        }
        this.eOE.bw("settings_active_time_full", true);
        this.eOE.notifyDataSetChanged();
        setBackBtn(new 1(this));
    }

    public final int Ys() {
        return k.settings_pref_active_time;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("settings_active_begin_time")) {
            this.mRH = true;
            showDialog(1);
            return true;
        } else if (preference.mKey.equals("settings_active_end_time")) {
            this.mRH = false;
            showDialog(1);
            return true;
        } else if (!preference.mKey.equals("settings_active_silence_time")) {
            return false;
        } else {
            boolean z;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_active_silence_time");
            if (checkBoxPreference.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            com.tencent.mm.k.f.bm(z);
            h hVar = h.mEJ;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(checkBoxPreference.isChecked() ? 1 : 2);
            hVar.h(11351, objArr);
            initView();
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                if (this.mRH) {
                    return new TimePickerDialog(this.mController.tml, this.mRI, this.mRD, this.mRE, false);
                }
                return new TimePickerDialog(this.mController.tml, this.mRI, this.mRF, this.mRG, false);
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1:
                if (this.mRH) {
                    ((TimePickerDialog) dialog).updateTime(this.mRD, this.mRE);
                    return;
                } else {
                    ((TimePickerDialog) dialog).updateTime(this.mRF, this.mRG);
                    return;
                }
            default:
                return;
        }
    }

    private static String f(Context context, int i, int i2) {
        String e = w.e(context.getSharedPreferences(ad.chY(), 0));
        String chP = w.chP();
        if (!e.equalsIgnoreCase("zh_CN") && (!e.equalsIgnoreCase("language_default") || !"zh_CN".equalsIgnoreCase(chP))) {
            return DateFormat.getTimeInstance(3, w.Wl(e)).format(new Time(i, i2, 0));
        }
        int i3;
        if (i > 12) {
            i3 = i - 12;
        } else {
            i3 = i;
        }
        return com.tencent.mm.pluginsdk.f.h.p(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    protected void onDestroy() {
        super.onDestroy();
        as.ha(2);
    }
}
