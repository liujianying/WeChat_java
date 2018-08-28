package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI extends MMPreference {
    private String cXR = "";
    private f eOE;
    private boolean mRu = false;
    private boolean mRv = false;

    public final int Ys() {
        return k.settings_about_timeline;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        bqd bqd = new bqd();
        if (n.nky != null) {
            bqd = n.nky.Lv(this.cXR);
        }
        if (bqd == null) {
            x.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = bqd.sod;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.mRv = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.mRv) {
                    checkBoxPreference.qpJ = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.qpJ = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        String str = preference.mKey;
        if (str.equals("timline_outside_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            d.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            d.b(this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            this.mRv = !this.mRv;
            if (n.nky != null) {
                n.nky.aQ(this.cXR, this.mRv);
            }
            this.mRu = true;
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mRu && n.nky != null) {
            bqd aR = n.nky.aR(this.cXR, this.mRv);
            if (aR != null) {
                x.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + aR.toString());
                ((i) g.l(i.class)).FQ().b(new a(51, aR));
            }
        }
    }

    protected final void initView() {
        this.eOE = this.tCL;
        setMMTitle(com.tencent.mm.plugin.setting.a.i.settings_pirvate_timeline);
        setBackBtn(new 1(this));
        this.cXR = q.GF();
    }
}
