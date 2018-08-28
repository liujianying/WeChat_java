package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.f;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class SettingsRingtoneUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsRingtoneUI mTC;

    SettingsRingtoneUI$2(SettingsRingtoneUI settingsRingtoneUI) {
        this.mTC = settingsRingtoneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String uri;
        Editor edit = this.mTC.getSharedPreferences(ad.chY(), 0).edit();
        if (SettingsRingtoneUI.a(this.mTC) != 0) {
            Uri a = SettingsRingtoneUI.a(this.mTC, SettingsRingtoneUI.a(this.mTC));
            x.d("RingtonePickerActivity", "set ringtone to " + a);
            if (a != null) {
                uri = a.toString();
                String a2 = SettingsRingtoneUI.a(this.mTC, a);
                edit.putString("settings.ringtone.name", a2);
                x.d("RingtonePickerActivity", "ringtone name: " + a2);
            } else {
                uri = f.dgL;
                edit.putString("settings.ringtone.name", this.mTC.getString(i.settings_notification_ringtone_sys));
                x.d("RingtonePickerActivity", "set ringtone follow system");
            }
        } else {
            uri = f.dgL;
            edit.putString("settings.ringtone.name", this.mTC.getString(i.settings_notification_ringtone_sys));
            x.d("RingtonePickerActivity", "set ringtone follow system");
        }
        edit.commit();
        f.fj(uri);
        this.mTC.finish();
        return true;
    }
}
