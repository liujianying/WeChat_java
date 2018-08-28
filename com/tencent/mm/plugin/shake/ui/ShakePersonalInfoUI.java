package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI extends MMPreference {
    private f eOE;

    public final int Ys() {
        return R.o.shake_settings_pref_personal_info;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        a.ezo.vl();
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.shake_item_setting);
        this.eOE = this.tCL;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("shake_item_sound");
        au.HU();
        if (c.DT().get(4112, null) == null) {
            au.HU();
            c.DT().set(4112, Boolean.valueOf(true));
        }
        au.HU();
        checkBoxPreference.qpJ = bi.c((Boolean) c.DT().get(4112, null));
        setBackBtn(new 1(this));
        if (!com.tencent.mm.an.c.Qf()) {
            this.eOE.aaa("shake_item_shake_music_list");
        }
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (au.HX()) {
            a.ezo.vl();
        }
        if (this.eOE.ZZ("shake_item_shake_tv_list") == null) {
            x.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            return;
        }
        if (bi.getInt(g.AU().G("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        x.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + z);
        if (!z && !af.exd) {
            this.eOE.bw("shake_item_shake_tv_list", true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str = preference.mKey;
        if ("shake_item_default_bgimg".equals(str)) {
            au.HU();
            c.DT().set(4110, Boolean.valueOf(true));
            h.bA(this, getResources().getString(R.l.shake_settings_laert_reset_bg_ok));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            l.a(this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            au.HU();
            boolean c = bi.c((Boolean) c.DT().get(4112, null));
            au.HU();
            c.DT().set(4112, Boolean.valueOf(!c));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(R.l.shake_item_history_list));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(R.l.shake_tv_msg_center_title));
            startActivity(intent);
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.Gb()).append("custom_shake_img_filename.jpg").toString());
                    a.ezn.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    au.HU();
                    c.DT().set(4110, Boolean.valueOf(false));
                    au.HU();
                    c.DT().set(4111, stringExtra);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
