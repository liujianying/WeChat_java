package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private f eOE;
    private Profession[] pjD = null;

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setMMTitle(i.wallet_select_profession_title);
        this.eOE = this.tCL;
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.mController.tml);
        preferenceTitleCategory.setTitle(getString(i.wallet_select_profession_tips));
        preferenceTitleCategory.setKey("title_category");
        this.eOE.a(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.pjD = new Profession[parcelableArrayExtra.length];
            for (i = 0; i < this.pjD.length; i++) {
                this.pjD[i] = (Profession) parcelableArrayExtra[i];
            }
        }
        if (this.pjD != null) {
            i = 0;
            for (Profession profession : this.pjD) {
                if (!(profession == null || bi.oW(profession.pkT))) {
                    Preference preference = new Preference(this.mController.tml);
                    preference.setTitle(profession.pkT);
                    preference.setKey("index_" + i);
                    this.eOE.a(preference);
                }
                i++;
            }
        }
        setBackBtn(new 1(this));
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.startsWith("index_")) {
            String[] split = preference.mKey.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.pjD[bi.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                x.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", new Object[]{preference.mKey, preference.getTitle()});
                setResult(0);
            }
            finish();
        }
        return true;
    }
}
