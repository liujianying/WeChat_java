package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;

public class SettingsFontUI extends MMActivity {
    private int mSd = 0;
    private int mSe = 2;
    private int mSf = a.fromDPToPix(ad.getContext(), d.chatting_normal_item_width);
    final float mSg = SetTextSizeUI.ec(this.mController.tml);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return g.settings_font_ui;
    }

    protected final void initView() {
        setMMTitle(i.settings_text_size);
        x.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.mSg);
        TextView textView = (TextView) findViewById(f.settings_font_msg_to);
        TextView textView2 = (TextView) findViewById(f.settings_font_illustrate_one);
        TextView textView3 = (TextView) findViewById(f.settings_font_illustrate_two);
        b.a((ImageView) findViewById(f.chatting_avatar_iv_to), q.GF());
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(f.font_selector_view);
        float ec = SetTextSizeUI.ec(this.mController.tml);
        if (ec < 0.875f || ec > 2.025f) {
            ec = 1.0f;
        }
        int i = ec == 0.875f ? 0 : ec == 1.125f ? 2 : ec == 1.25f ? 3 : ec == 1.375f ? 4 : ec == 1.625f ? 5 : ec == 1.875f ? 6 : ec == 2.025f ? 7 : 1;
        fontSelectorView.setSliderIndex(i);
        fontSelectorView.setOnChangeListener(new 1(this, textView, textView2, textView3));
        setBackBtn(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        h.mEJ.h(11609, new Object[]{Integer.valueOf(this.mSd), Integer.valueOf(this.mSe), Integer.valueOf(0)});
        x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(this.mSd), Integer.valueOf(this.mSe)});
        finish();
        ap(this.mSg);
        return true;
    }

    private void ap(float f) {
        float f2 = this.mController.tml.getSharedPreferences(ad.chY(), 0).getFloat("current_text_size_scale_key", 1.0f);
        x.i("MicroMsg.SettingsFontUI", "fontSizeAfter=" + f2);
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.b.ezn.q(intent, this.mController.tml);
            gd gdVar = new gd();
            gdVar.bPn.bPo = f;
            gdVar.bPn.bPp = f2;
            com.tencent.mm.sdk.b.a.sFg.m(gdVar);
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(e.i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent2.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ad.getContext().sendBroadcast(intent2);
        }
    }
}
