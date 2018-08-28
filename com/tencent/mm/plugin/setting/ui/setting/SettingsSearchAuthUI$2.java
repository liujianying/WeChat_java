package com.tencent.mm.plugin.setting.ui.setting;

import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class SettingsSearchAuthUI$2 implements a {
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    SettingsSearchAuthUI$2(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    public final void aQC() {
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        x.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[]{str});
        if (bi.oW(str)) {
            SettingsSearchAuthUI.c(this.mTJ);
            return;
        }
        SettingsSearchAuthUI.a(this.mTJ);
        String string = this.mTJ.getString(i.app_search);
        k kVar = new k(string + " " + str.trim());
        kVar.setSpan(new ForegroundColorSpan(this.mTJ.getResources().getColor(c.green_text_color)), string.length(), kVar.length(), 33);
        SettingsSearchAuthUI.b(this.mTJ).setText(kVar);
    }

    public final void fg(boolean z) {
        x.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.mTJ.showVKB();
        } else {
            this.mTJ.YC();
        }
    }

    public final void onClickClearTextBtn(View view) {
        x.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(this.mTJ);
    }

    public final boolean anx() {
        x.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        CharSequence text = SettingsSearchAuthUI.d(this.mTJ).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(this.mTJ).setVisibility(8);
        SettingsSearchAuthUI.d(this.mTJ).getFtsEditText().getEditText().clearFocus();
        this.mTJ.YC();
        SettingsSearchAuthUI.e(this.mTJ);
        if (!bi.K(text)) {
            SettingsSearchAuthUI.a(this.mTJ, text.toString().trim());
        }
        return true;
    }
}
