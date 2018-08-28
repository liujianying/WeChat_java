package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.account.ui.LanguagePreference.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e$b;
import com.tencent.mm.ui.e$i;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] mSn = v.mSn;
    private f eOE;
    private String eVK;
    private List<a> mSp;
    private boolean mSq = false;

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        Locale Wl = w.Wl(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                Wl = w.sGk;
                Locale.setDefault(Wl);
            } else {
                Wl = Locale.getDefault();
            }
        }
        w.a(settingsLanguageUI.getSharedPreferences(ad.chY(), 0), str);
        w.a(settingsLanguageUI, Wl);
        be.setProperty("system_property_key_locale", str);
        ad.a(com.tencent.mm.bq.a.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            b.ezn.q(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            return;
        }
        g.DF().a(new bg(new 3(settingsLanguageUI)), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e$i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_RELOAD_RESOURCES");
        intent.putExtra("tools_language", str);
        ad.getContext().sendBroadcast(intent);
        intent = new Intent();
        intent.setComponent(new ComponentName(e$b.tht, "com.tencent.mm.booter.MMReceivers$ExdeviceProcessReceiver"));
        intent.putExtra("exdevice_process_action_code_key", "action_reload_resources");
        intent.putExtra("exdevice_language", str);
        ad.getContext().sendBroadcast(intent);
        FontSelectorView.buk();
        com.tencent.mm.k.g.AU().dgP.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        b.ezn.q(intent, settingsLanguageUI);
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
        return -1;
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(i.settings_language_title);
        setBackBtn(new 1(this));
        a(0, getString(i.settings_language_save), new 2(this), s.b.tmX);
        this.mSq = getIntent().getBooleanExtra("not_auth_setting", false);
        this.eOE.removeAll();
        String[] stringArray = getResources().getStringArray(com.tencent.mm.plugin.setting.a.b.language_setting);
        this.eVK = w.e(getSharedPreferences(ad.chY(), 0));
        this.mSp = new ArrayList();
        while (i < mSn.length) {
            String str = mSn[i];
            this.mSp.add(new a(stringArray[i], "", str, this.eVK.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.mSp) {
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.eOE.a(languagePreference);
        }
        this.eOE.a(new PreferenceCategory(this));
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).eQG;
        if (aVar == null) {
            return false;
        }
        this.eVK = aVar.eQJ;
        for (a aVar2 : this.mSp) {
            aVar2.eQK = false;
        }
        aVar.eQK = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
