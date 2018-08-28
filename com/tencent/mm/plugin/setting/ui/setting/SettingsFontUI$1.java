package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ah;

class SettingsFontUI$1 implements a {
    final /* synthetic */ TextView mSh;
    final /* synthetic */ TextView mSi;
    final /* synthetic */ TextView mSj;
    final /* synthetic */ SettingsFontUI mSk;

    SettingsFontUI$1(SettingsFontUI settingsFontUI, TextView textView, TextView textView2, TextView textView3) {
        this.mSk = settingsFontUI;
        this.mSh = textView;
        this.mSi = textView2;
        this.mSj = textView3;
    }

    public final void vM(int i) {
        float f = 1.0f;
        switch (i) {
            case 0:
                f = 0.875f;
                break;
            case 2:
                f = 1.125f;
                break;
            case 3:
                f = 1.25f;
                break;
            case 4:
                f = 1.375f;
                break;
            case 5:
                f = 1.625f;
                break;
            case 6:
                f = 1.875f;
                break;
            case 7:
                f = 2.025f;
                break;
        }
        if (f != this.mSk.mSg) {
            SettingsFontUI.a(this.mSk, 1);
        } else {
            SettingsFontUI.a(this.mSk, 0);
        }
        com.tencent.mm.bp.a.g(this.mSk.mController.tml, f);
        ah.g(this.mSk.mController.tml, f);
        Editor edit = this.mSk.mController.tml.getSharedPreferences(ad.chY(), 0).edit();
        edit.putFloat("current_text_size_scale_key", f);
        edit.commit();
        SettingsFontUI.b(this.mSk, com.tencent.mm.bp.a.ff(this.mSk.mController.tml));
        float fe = com.tencent.mm.bp.a.fe(this.mSk.mController.tml);
        ActionBarActivity actionBarActivity = this.mSk.mController.tml;
        if (fe == 0.875f) {
            SettingsFontUI.c(this.mSk, com.tencent.mm.bp.a.ae(actionBarActivity, d.chatting_small_item_width));
        } else if (fe == 1.125f) {
            SettingsFontUI.c(this.mSk, com.tencent.mm.bp.a.ae(actionBarActivity, d.chatting_large_item_width));
        } else if (fe == 1.25f) {
            SettingsFontUI.c(this.mSk, com.tencent.mm.bp.a.ae(actionBarActivity, d.chatting_super_item_width));
        } else if (fe == 1.375f) {
            SettingsFontUI.c(this.mSk, com.tencent.mm.bp.a.ae(actionBarActivity, d.chatting_huge_item_width));
        } else if (fe == 1.625f || fe == 1.875f || fe == 2.025f) {
            SettingsFontUI.c(this.mSk, com.tencent.mm.bp.a.ae(actionBarActivity, d.chatting_huger_item_width));
        }
        this.mSh.setTextSize(1, SetTextSizeUI.ao(f));
        this.mSi.setTextSize(1, SetTextSizeUI.ao(f));
        this.mSj.setTextSize(1, SetTextSizeUI.ao(f));
        float ae = ((float) com.tencent.mm.bp.a.ae(actionBarActivity, d.ActionBarTextSize)) * com.tencent.mm.bp.a.fg(actionBarActivity);
        this.mSk.mController.tmq.setTextSize(0, ae);
    }
}
