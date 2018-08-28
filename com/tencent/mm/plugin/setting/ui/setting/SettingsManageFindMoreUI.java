package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.al.b;
import com.tencent.mm.aq.l;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONObject;

public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> eGU = new HashMap();
    private long hXx;
    private HashMap<Integer, Integer> mSD = new HashMap();
    private HashMap<Integer, Integer> mSE = new HashMap();
    private int mSF;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hXx = q.GK();
        this.mSF = q.GQ();
        x.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", new Object[]{Long.valueOf(this.hXx), Integer.valueOf(this.mSF)});
        initView();
    }

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int Ys() {
        return k.settings_pref_manage_findmoreui;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 0;
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            String str = preference.mKey;
            x.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[]{str});
            int i2 = -1;
            if (str.equals("settings_sns_switch")) {
                r(checkBoxPreference.isChecked(), 32768);
                SharedPreferences sharedPreferences = getSharedPreferences(ad.chY(), 0);
                String string = sharedPreferences.getString(q.GF() + "_sns_entrance_disappear", "");
                if (!bi.oW(string) && string.startsWith("on")) {
                    if (checkBoxPreference.isChecked() && string.equals("on_close")) {
                        string = "on";
                    }
                    if (!checkBoxPreference.isChecked() && r1.equals("on")) {
                        string = "on_close";
                    }
                    sharedPreferences.edit().putString(q.GF() + "_sns_entrance_disappear", string).commit();
                }
                i2 = 0;
            } else if (str.equals("settings_scan_switch")) {
                c(checkBoxPreference.isChecked(), 1048576, 49);
                i2 = 1;
            } else if (str.equals("settings_search_switch")) {
                if (checkBoxPreference.isChecked()) {
                    c(checkBoxPreference.isChecked(), 2097152, 50);
                    i2 = 3;
                } else {
                    if (((i) g.l(i.class)).b(this, new 1(this, checkBoxPreference))) {
                        ah.i(new 2(this, checkBoxPreference), 500);
                    }
                    i2 = 3;
                }
            } else if (str.equals("settings_shopping_switch")) {
                i2 = 6;
                c(checkBoxPreference.isChecked(), 4194304, 51);
            } else if (str.equals("settings_game_switch")) {
                c(checkBoxPreference.isChecked(), 8388608, 52);
                com.tencent.mm.plugin.report.service.h.mEJ.a(848, checkBoxPreference.isChecked() ? 0 : 1, 1, false);
                i2 = 7;
            } else if (str.equals("settings_miniprogram_switch")) {
                i2 = 8;
                c(checkBoxPreference.isChecked(), 16777216, 53);
            } else if (str.equals("settings_wechatout_switch")) {
                i2 = 9;
                c(checkBoxPreference.isChecked(), 33554432, 54);
            } else if (str.equals("settings_shake_switch")) {
                i2 = 2;
                r(checkBoxPreference.isChecked(), 256);
            } else if (str.equals("settings_nearby_switch")) {
                i2 = 4;
                r(checkBoxPreference.isChecked(), 512);
            } else if (str.equals("settings_bottle_switch")) {
                i2 = 5;
                r(checkBoxPreference.isChecked(), 64);
            } else if (str.equals("settings_look_switch")) {
                ((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).bh("labs_browse", checkBoxPreference.isChecked());
                if (!checkBoxPreference.isChecked() && b.ml((String) g.Ei().DT().get(274436, null))) {
                    this.tCL.bw("settings_look_switch", true);
                }
                i2 = 10;
            }
            if (checkBoxPreference.isChecked()) {
                i = 1;
            }
            if (i2 >= 0) {
                this.mSE.put(Integer.valueOf(i2), Integer.valueOf(i));
            }
        }
        return true;
    }

    protected final void initView() {
        boolean z;
        boolean z2;
        String value;
        String bGp;
        setMMTitle(com.tencent.mm.plugin.setting.a.i.settings_manage_findmoreui);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsManageFindMoreUI.this.finish();
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_sns_switch");
        checkBoxPreference.tDr = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", new Object[]{Boolean.valueOf(vP(32768))});
        if (vP(32768)) {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(0), Integer.valueOf(1));
        } else {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(0), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_scan_switch");
        checkBoxPreference.tDr = false;
        if (vO(1048576)) {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(1), Integer.valueOf(0));
        } else {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(1), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_shake_switch");
        checkBoxPreference.tDr = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", new Object[]{Boolean.valueOf(vP(256))});
        if (vP(256)) {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(2), Integer.valueOf(1));
        } else {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(2), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_look_switch");
        checkBoxPreference.tDr = false;
        JSONObject PX = r.PX("discoverRecommendEntry");
        boolean RZ = ((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RZ("labs_browse");
        if (RZ) {
            if (((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RX("labs_browse")) {
                z = true;
            } else {
                z = false;
            }
            z2 = z;
        } else if (PX.optInt("entrySwitch") == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (b.ml((String) g.Ei().DT().get(274436, null))) {
            this.tCL.bw("settings_look_switch", true);
            z = false;
            z2 = false;
        } else {
            z = RZ;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z && z2) {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(10), Integer.valueOf(1));
        } else if (z) {
            this.tCL.bw("settings_look_switch", false);
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(10), Integer.valueOf(0));
        } else {
            this.tCL.bw("settings_look_switch", true);
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_search_switch");
        checkBoxPreference.tDr = false;
        if (vO(2097152)) {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(3), Integer.valueOf(0));
        } else {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(3), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_nearby_switch");
        checkBoxPreference.tDr = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", new Object[]{Boolean.valueOf(vP(512))});
        if (vP(512)) {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(4), Integer.valueOf(1));
        } else {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(4), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_bottle_switch");
        checkBoxPreference.tDr = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openFloatBottle %s", new Object[]{Boolean.valueOf(vP(64))});
        if (vP(64)) {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(5), Integer.valueOf(1));
        } else {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(5), Integer.valueOf(0));
        }
        if (w.chM()) {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigName");
        } else if (w.chN()) {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigIconUrl");
        com.tencent.mm.pluginsdk.f.f.b bVar = com.tencent.mm.pluginsdk.f.f.qBo;
        if (bVar != null) {
            bGp = bVar.bGp();
        } else {
            bGp = null;
        }
        if (bi.G(new String[]{value, value2, bGp})) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", new Object[]{Boolean.valueOf(z)});
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_shopping_switch");
        checkBoxPreference.tDr = false;
        if (z) {
            this.tCL.bw("settings_shopping_switch", false);
        } else {
            this.tCL.bw("settings_shopping_switch", true);
        }
        if (vO(4194304)) {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(6), Integer.valueOf(0));
        } else {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(6), Integer.valueOf(1));
        }
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_game_switch");
        checkBoxPreference.tDr = false;
        if (aSm == null || !aSm.aSd()) {
            this.tCL.bw("settings_game_switch", true);
        } else if (vO(8388608)) {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(7), Integer.valueOf(0));
        } else {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(7), Integer.valueOf(1));
        }
        pk pkVar = new pk();
        pkVar.cah.caj = true;
        com.tencent.mm.sdk.b.a.sFg.m(pkVar);
        x.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", new Object[]{Boolean.valueOf(pkVar.cai.cak)});
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_miniprogram_switch");
        checkBoxPreference.tDr = false;
        if (!pkVar.cai.cak) {
            this.tCL.bw("settings_miniprogram_switch", true);
        } else if (vO(16777216)) {
            checkBoxPreference.qpJ = false;
            this.mSD.put(Integer.valueOf(8), Integer.valueOf(0));
        } else {
            checkBoxPreference.qpJ = true;
            this.mSD.put(Integer.valueOf(8), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.tCL.ZZ("settings_wechatout_switch");
        if (com.tencent.mm.k.g.AT().getInt("WCOEntranceSwitch", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            checkBoxPreference.tDr = false;
            if (vO(33554432)) {
                checkBoxPreference.qpJ = false;
                this.mSD.put(Integer.valueOf(9), Integer.valueOf(0));
            } else {
                checkBoxPreference.qpJ = true;
                this.mSD.put(Integer.valueOf(9), Integer.valueOf(1));
            }
        } else {
            this.tCL.bw("settings_wechatout_switch", true);
        }
        Preference ZZ = this.tCL.ZZ("settings_switch_bottom_tip");
        if (b.ml((String) g.Ei().DT().get(274436, null))) {
            ZZ.setTitle(com.tencent.mm.plugin.setting.a.i.settings_manage_plugin_eu_hint);
        }
        this.tCL.notifyDataSetChanged();
    }

    private void c(boolean z, int i, int i2) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.hXx &= (long) (i ^ -1);
        } else {
            this.hXx |= (long) i;
        }
        this.eGU.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.hXx + ",pluginFlag:" + this.mSF);
        g.Ei().DT().set(147457, Long.valueOf(this.hXx));
        g.Ei().DT().set(34, Integer.valueOf(this.mSF));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            xt xtVar = new xt();
            xtVar.rDz = intValue;
            xtVar.rDA = intValue2;
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            x.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new l("", "", "", "", "", "", "", "", this.mSF, "", ""));
        aXS();
    }

    private boolean vO(int i) {
        return (this.hXx & ((long) i)) != 0;
    }

    private boolean vP(int i) {
        return (this.mSF & i) == 0;
    }

    private void r(boolean z, int i) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (z) {
            this.mSF &= i ^ -1;
        } else {
            this.mSF |= i;
        }
    }

    private void aXS() {
        for (Integer intValue : this.mSE.keySet()) {
            int intValue2 = intValue.intValue();
            if (this.mSD.containsKey(Integer.valueOf(intValue2)) && this.mSD.get(Integer.valueOf(intValue2)) != this.mSE.get(Integer.valueOf(intValue2))) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(15185, new Object[]{Integer.valueOf(intValue2), this.mSE.get(Integer.valueOf(intValue2))});
            }
        }
    }
}
