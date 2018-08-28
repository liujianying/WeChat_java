package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.al.b;
import com.tencent.mm.ao.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsPluginsUI extends MMPreference {
    private static int mTk = 1;
    private static HashMap<String, Integer> mTl = new 1();
    private f eOE;
    private boolean mTm;
    private boolean mTn;

    public final int Ys() {
        return k.settings_pref_plugins;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
        h.mEJ.h(14098, new Object[]{Integer.valueOf(5)});
        h.mEJ.h(12846, new Object[]{Integer.valueOf(mTk)});
        a.dBr.R("gh_43f2581f6fd6", "");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.settings_plugins);
        setBackBtn(new 2(this));
    }

    public void onResume() {
        PluginPreference pluginPreference;
        boolean z = false;
        super.onResume();
        this.eOE.removeAll();
        this.eOE.a(new PreferenceSmallCategory(this));
        List<PluginPreference> arrayList = new ArrayList();
        List<PluginPreference> arrayList2 = new ArrayList();
        boolean Hm = q.Hm();
        if (!Hm) {
            Hm = bi.getInt(g.AT().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!Hm) {
            x.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (Hm && d.QS("qqmail")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.KW("qqmail")) {
                pluginPreference.setTitle(pluginPreference.mQh);
                if ((q.GQ() & 1) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.PB()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.QS("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.KW("newsapp")) {
                pluginPreference.setTitle(pluginPreference.mQh);
                if ((q.GQ() & 524288) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.PB()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.KW("facebookapp")) {
            pluginPreference.setTitle(pluginPreference.mQh);
            if ((q.GQ() & 8192) == 0) {
                arrayList.add(pluginPreference);
            } else if (b.PA()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (d.QS("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.KW("masssendapp")) {
                pluginPreference.setTitle(pluginPreference.mQh);
                if ((q.GQ() & GLIcon.RIGHT) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        d.cfH();
        if (!b.Pz()) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.KW("voiceinputapp")) {
                pluginPreference.setTitle(pluginPreference.mQh);
                if ((q.GQ() & 33554432) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        String string = getString(i.exdevice_wechat_sport);
        pluginPreference.mQg = "gh_43f2581f6fd6";
        pluginPreference.mQh = string;
        pluginPreference.setKey("settings_plugins_list_#" + pluginPreference.mQg);
        pluginPreference.setTitle(pluginPreference.mQh);
        if (((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sport.b.b.class)).bFv()) {
            arrayList.add(pluginPreference);
        } else {
            arrayList2.add(pluginPreference);
        }
        com.tencent.mm.plugin.ab.a.bjk();
        this.mTn = c.ig(com.tencent.mm.ao.b.ebm);
        pluginPreference.mQl = this.mTn;
        String value = g.AT().getValue("LinkedinPluginClose");
        if (bi.oW(value) || Integer.valueOf(value).intValue() == 0) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.KW("linkedinplugin")) {
                pluginPreference2.setTitle(pluginPreference2.mQh);
                boolean z2 = (q.GQ() & 16777216) == 0;
                if (!bi.oW((String) com.tencent.mm.kernel.g.Ei().DT().get(286721, null))) {
                    z = true;
                }
                if (z2 && z) {
                    arrayList.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            PluginTextPreference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.tDi = com.tencent.mm.plugin.setting.a.h.setting_plugin_install;
            pluginTextPreference.EA(i.settings_plugins_installed_plugins);
            this.eOE.a(pluginTextPreference);
        }
        value = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sXd, "");
        Preference preference = null;
        for (PluginPreference pluginPreference3 : arrayList) {
            pluginPreference3.iRP = 255;
            if (value.contains(pluginPreference3.mQg)) {
                pluginPreference3.mQl = true;
                if (preference == null) {
                    preference = pluginPreference3;
                }
            }
            this.eOE.a(pluginPreference3);
        }
        this.eOE.a(new PreferenceSmallCategory(this));
        PluginTextPreference pluginTextPreference2 = new PluginTextPreference(this);
        pluginTextPreference2.tDi = com.tencent.mm.plugin.setting.a.h.setting_plugin_uninstall;
        pluginTextPreference2.EA(i.settings_plugins_uninstalled_plugins);
        this.eOE.a(pluginTextPreference2);
        if (arrayList2.isEmpty()) {
            this.eOE.a(new PluginEmptyTextPreference(this, i.settings_plugins_can_uninstalled));
        }
        for (PluginPreference pluginPreference32 : arrayList2) {
            pluginPreference32.iRP = 136;
            if (value.contains(pluginPreference32.mQg)) {
                pluginPreference32.mQl = true;
                if (preference == null) {
                    preference = pluginPreference32;
                }
            }
            this.eOE.a(pluginPreference32);
        }
        this.eOE.a(new PreferenceSmallCategory(this));
        if (preference != null) {
            setSelection(this.eOE.aab(preference.mKey));
        }
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str != null && str.equals("display_in_addr_book")) {
            com.tencent.mm.kernel.g.Ei().DT().set(35, Boolean.valueOf(((CheckBoxPreference) fVar.ZZ(str)).isChecked()));
            return true;
        } else if (!(preference instanceof PluginPreference)) {
            return false;
        } else {
            str = ((PluginPreference) preference).mQg;
            if ("feedsapp".equals(str) && this.mTm) {
                com.tencent.mm.kernel.g.Ei().DT().set(-2046825369, Boolean.valueOf(false));
            }
            Intent intent = new Intent();
            if ("gh_43f2581f6fd6".equals(str) && this.mTn) {
                com.tencent.mm.plugin.ab.a.bji();
                com.tencent.mm.ao.d.ih(com.tencent.mm.ao.b.ebm);
                intent.putExtra("key_from_wesport_plugin_newtips", true);
            }
            intent.putExtra("Contact_User", str);
            d.b(this, "profile", ".ui.ContactInfoUI", intent);
            h.mEJ.h(12846, new Object[]{mTl.get(str)});
            x.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[]{str, mTl.get(str)});
            return true;
        }
    }
}
