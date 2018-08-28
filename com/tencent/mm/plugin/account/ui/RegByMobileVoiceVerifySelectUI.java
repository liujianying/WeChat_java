package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements e {
    private f eOE;
    private a[] eVJ;
    private String eVK;

    public final void a(int i, int i2, String str, l lVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Ys() {
        return a$g.bindmcontact_voice_select_language;
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).eQG;
        if (aVar == null) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("voice_verify_language", aVar.eQH);
        bundle.putString("voice_verify_code", aVar.eQJ);
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
        return true;
    }

    protected final void initView() {
        YC();
        this.eVK = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle(j.bind_mcontact_voice_verify_select_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByMobileVoiceVerifySelectUI.this.YC();
                RegByMobileVoiceVerifySelectUI.this.finish();
                return true;
            }
        });
        this.eVJ = Zc();
        if (this.eVJ != null && this.eVJ.length > 0) {
            this.eOE.removeAll();
            this.eOE.a(new PreferenceCategory(this));
            for (a aVar : this.eVJ) {
                if (aVar.eQJ.equalsIgnoreCase(this.eVK)) {
                    aVar.eQK = true;
                }
                LanguagePreference languagePreference = new LanguagePreference(this);
                languagePreference.a(aVar);
                languagePreference.setKey(aVar.eQJ);
                this.eOE.a(languagePreference);
            }
        }
    }

    public static String pR(String str) {
        a[] Zc = Zc();
        String mk = b.mk(str);
        for (a aVar : Zc) {
            if (aVar.eQJ.equalsIgnoreCase(mk)) {
                return aVar.eQH;
            }
        }
        return "English";
    }

    private static a[] Zc() {
        String[] split = ad.getContext().getString(j.bind_mcontact_voice_verify_Languages).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        return aVarArr;
    }
}
