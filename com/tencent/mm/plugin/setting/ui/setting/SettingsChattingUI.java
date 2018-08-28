package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f eOE;
    private boolean isDeleteCancel = false;
    private ProgressDialog mQY = null;

    static /* synthetic */ void b(SettingsChattingUI settingsChattingUI) {
        List clE = ((i) g.l(i.class)).FW().clE();
        if (clE.size() > 0) {
            List E = l.E(clE);
            if (E != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= E.size()) {
                        break;
                    }
                    if (((Boolean) E.get(i2)).booleanValue()) {
                        b.ezo.cV((String) clE.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
        bd.a(new 3(settingsChattingUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            initView();
        } else {
            finish();
        }
    }

    protected final void initView() {
        setMMTitle(a.i.settings_chatting);
        this.eOE = this.tCL;
        if (g.Ei().DT().getInt(89, 0) != 2) {
            this.eOE.aaa("settings_recovery");
        }
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = ((Boolean) g.Ei().DT().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.tDr = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = ((Boolean) g.Ei().DT().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.tDr = false;
        }
        Preference ZZ = this.eOE.ZZ("settings_text_size");
        if (ZZ != null) {
            ZZ.setSummary(getString(SetTextSizeUI.ed(this)));
        }
        this.eOE.notifyDataSetChanged();
    }

    public final int Ys() {
        return k.settings_pref_chatting;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.mKey;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1776646462:
                if (str.equals("settings_chatting_bg")) {
                    z2 = true;
                    break;
                }
                break;
            case -1565531065:
                if (str.equals("settings_bak_chat")) {
                    z2 = true;
                    break;
                }
                break;
            case -1550690765:
                if (str.equals("settings_reset")) {
                    z2 = true;
                    break;
                }
                break;
            case -1439483675:
                if (str.equals("settings_voice_play_mode")) {
                    z2 = false;
                    break;
                }
                break;
            case -409015247:
                if (str.equals("settings_recovery")) {
                    z2 = true;
                    break;
                }
                break;
            case 624882802:
                if (str.equals("settings_enter_button_send")) {
                    z2 = true;
                    break;
                }
                break;
            case 1789437336:
                if (str.equals("settings_emoji_manager")) {
                    z2 = true;
                    break;
                }
                break;
        }
        Intent intent;
        switch (z2) {
            case false:
                boolean booleanValue = ((Boolean) g.Ei().DT().get(26, Boolean.valueOf(false))).booleanValue();
                String str2 = "MicroMsg.SettingsChattingUI";
                String str3 = "set voice mode from %B to %B";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                x.d(str2, str3, objArr);
                com.tencent.mm.storage.x DT = g.Ei().DT();
                if (!booleanValue) {
                    z = true;
                }
                DT.set(26, Boolean.valueOf(z));
                return true;
            case true:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("settings_enter_button_send");
                if (checkBoxPreference == null) {
                    return true;
                }
                x.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
                g.Ei().DT().set(66832, Boolean.valueOf(z2));
                return true;
            case true:
                MMWizardActivity.D(this.mController.tml, new Intent().setClassName(this.mController.tml, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI"));
                return true;
            case true:
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.tml.startActivity(intent);
                return true;
            case true:
                intent = new Intent();
                intent.putExtra("10931", 2);
                d.b(this.mController.tml, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            case true:
                h.a(this.mController.tml, getResources().getString(a.i.settings_reset_warning), "", getString(a.i.app_clear), getString(a.i.app_cancel), new 2(this), null);
                return true;
            case true:
                intent = new Intent().setClassName(this.mController.tml, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                intent.putExtra("scene", 1);
                this.mController.tml.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
