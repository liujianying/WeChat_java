package com.tencent.mm.plugin.setting.ui.setting;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.x;

class SettingsRingtoneUI$a extends BaseAdapter {
    Cursor bMC;
    int count = 0;
    final /* synthetic */ SettingsRingtoneUI mTC;
    int padding = 0;

    public SettingsRingtoneUI$a(SettingsRingtoneUI settingsRingtoneUI, Cursor cursor) {
        this.mTC = settingsRingtoneUI;
        this.bMC = cursor;
        this.count = cursor.getCount() + 1;
        x.d("RingtonePickerActivity", "count = " + this.count);
        this.padding = settingsRingtoneUI.getResources().getDimensionPixelSize(d.NormalPadding);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) this.mTC.mTy.inflate(g.select_dialog_singlechoice, null);
        if (i == 0) {
            checkedTextView.setBackgroundResource(e.comm_list_item_selector);
            checkedTextView.setText(i.settings_notification_ringtone_sys);
        } else {
            checkedTextView.setBackgroundResource(e.comm_list_item_selector);
            checkedTextView.setText(jl(i));
        }
        checkedTextView.setPadding(this.padding, 0, this.padding, 0);
        checkedTextView.setCheckMarkDrawable(e.round_selector);
        return checkedTextView;
    }

    public final int getCount() {
        return this.count;
    }

    private String jl(int i) {
        if (this.bMC.isClosed() || !this.bMC.moveToPosition(i - 1)) {
            return "";
        }
        return this.bMC.getString(this.bMC.getColumnIndex(SlookSmartClipMetaTag.TAG_TYPE_TITLE));
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
