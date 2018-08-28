package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7;
import com.tencent.mm.sdk.f.e;

class UnfamiliarContactDetailUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 mUW;

    UnfamiliarContactDetailUI$7$1(7 7) {
        this.mUW = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (UnfamiliarContactDetailUI.h(this.mUW.mUT) != null) {
            g.Ek();
            g.Eh().dpP.a(681, UnfamiliarContactDetailUI.h(this.mUW.mUT));
            Runnable h = UnfamiliarContactDetailUI.h(this.mUW.mUT);
            h.index = 0;
            h.lcB = 0;
            h.mVk = 0;
            h.mVl.clear();
            h.mVm.clear();
            e.remove(h);
            if (h.mVi != null) {
                h.mVi.buj();
            }
            e.post(h, "delete_contact_task");
        }
        UnfamiliarContactDetailUI.b(this.mUW.mUT, false);
    }
}
