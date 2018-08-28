package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class EditSignatureUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EditSignatureUI mPP;

    EditSignatureUI$3(EditSignatureUI editSignatureUI) {
        this.mPP = editSignatureUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = EditSignatureUI.a(this.mPP).getText().toString().trim();
        String AD = b.AD();
        if (bi.oW(AD) || !trim.matches(".*[" + AD + "].*")) {
            EditSignatureUI editSignatureUI = this.mPP;
            ActionBarActivity actionBarActivity = this.mPP.mController.tml;
            this.mPP.getString(i.app_tip);
            EditSignatureUI.a(editSignatureUI, h.a(actionBarActivity, this.mPP.getString(i.contact_info_change_remarkimage_save), false, null));
            EditSignatureUI.a(this.mPP, q.q(18, trim));
            EditSignatureUI.f(this.mPP);
            this.mPP.YC();
            return true;
        }
        h.b(this.mPP.mController.tml, this.mPP.getString(i.invalid_input_character_toast, new Object[]{AD}), this.mPP.getString(i.app_tip), true);
        return false;
    }
}
