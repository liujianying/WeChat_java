package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.o;
import com.tencent.mm.aa.q;
import com.tencent.mm.aq.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map.Entry;

public class BottlePersonalInfoUI extends MMPreference implements c {
    private SharedPreferences duR;
    private HashMap<Integer, Integer> eGU = new HashMap();
    private f eOE;
    private c hlv;
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q.Kp().d(this);
        initView();
    }

    public void onDestroy() {
        a.ezo.vl();
        q.Kp().e(this);
        super.onDestroy();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(R.l.settings_title);
        this.eOE = this.tCL;
        this.eOE.addPreferencesFromResource(R.o.bottle_wizard_step2);
        this.duR = this.duR;
        this.status = com.tencent.mm.model.q.GJ();
        if (getIntent().getBooleanExtra("is_allow_set", true)) {
            this.hlv = new c(this, this.eOE);
        } else {
            f fVar = this.eOE;
            fVar.aaa("settings_sex");
            fVar.aaa("settings_district");
            fVar.aaa("settings_signature");
            fVar.aaa("bottle_settings_change_avatar_alert");
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("bottle_settings_show_at_main");
        if ((this.status & 32768) == 0) {
            z = false;
        }
        checkBoxPreference.qpJ = z;
        setBackBtn(new 1(this));
    }

    public void onResume() {
        HeadImgPreference headImgPreference = (HeadImgPreference) this.eOE.ZZ("bottle_settings_change_avatar");
        Bitmap a = com.tencent.mm.aa.c.a(ab.XV(com.tencent.mm.model.q.GF()), false, -1);
        if (a == null) {
            a = com.tencent.mm.aa.c.a(com.tencent.mm.model.q.GF(), false, -1);
        }
        if (a != null) {
            headImgPreference.O(a);
        }
        headImgPreference.mVS = new 3(this);
        if (this.hlv != null) {
            this.hlv.update();
        }
        super.onResume();
    }

    public void onPause() {
        c.auq();
        au.HU();
        com.tencent.mm.model.c.DT().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            au.HU();
            com.tencent.mm.model.c.FQ().b(new g(intValue, intValue2));
            x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
        super.onPause();
    }

    public final int Ys() {
        return R.o.bottle_settings_pref_personal_info;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.mKey;
        if (str.equals("bottle_settings_change_avatar")) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                l.a(this, 2, null);
                return true;
            }
            s.gH(this);
            return false;
        } else if (str.equals("settings_district")) {
            return this.hlv.aus();
        } else {
            if (str.equals("settings_signature")) {
                return this.hlv.aur();
            }
            if (str.equals("bottle_settings_show_at_main")) {
                boolean z = this.duR.getBoolean("bottle_settings_show_at_main", true);
                x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + z + " item value = 32768 functionId = 14");
                if (z) {
                    this.status |= 32768;
                } else {
                    this.status &= -32769;
                }
                if (z) {
                    i = 1;
                }
                this.eGU.put(Integer.valueOf(14), Integer.valueOf(i));
                return true;
            } else if (!str.equals("bottle_settings_clear_data")) {
                return false;
            } else {
                h.a(this.mController.tml, this.mController.tml.getString(R.l.contact_info_clear_data), "", this.mController.tml.getString(R.l.app_clear), this.mController.tml.getString(R.l.app_cancel), new 2(this), null);
                return true;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String d;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    au.HU();
                    d = l.d(applicationContext, intent, com.tencent.mm.model.c.Gb());
                    if (d != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", q.Kp().c(ab.XV(com.tencent.mm.model.q.GF()), true, false));
                        intent2.putExtra("CropImage_ImgPath", d);
                        a.ezn.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                au.HU();
                d = l.d(applicationContext, intent, com.tencent.mm.model.c.Gb());
                if (d != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", d);
                    intent2.putExtra("CropImage_ImgPath", d);
                    a.ezn.a((Activity) this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    d = intent.getStringExtra("CropImage_OutputPath");
                    if (d == null) {
                        x.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
                        return;
                    } else {
                        new o(this.mController.tml, d).b(2, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void jX(String str) {
        if (str != null && str.equals(ab.XV(com.tencent.mm.model.q.GF()))) {
            Bitmap decodeResource;
            Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
            if (a == null) {
                a = com.tencent.mm.aa.c.a(com.tencent.mm.model.q.GF(), false, -1);
            }
            if (a == null) {
                decodeResource = BitmapFactory.decodeResource(getResources(), R.g.default_avatar);
            } else {
                decodeResource = a;
            }
            ((HeadImgPreference) this.eOE.ZZ("bottle_settings_change_avatar")).O(decodeResource);
        }
    }
}
