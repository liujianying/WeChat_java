package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnItemClickListener {
    final /* synthetic */ i tDe;

    i$2(i iVar) {
        this.tDe = iVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= i.e(this.tDe).getHeaderViewsCount()) {
            x.i("MicroMsg.mmui.MMPreference", "click after resume %d", new Object[]{Long.valueOf(System.currentTimeMillis() - i.f(this.tDe))});
            if (System.currentTimeMillis() - i.f(this.tDe) < 400) {
                x.w("MicroMsg.mmui.MMPreference", "too quick click after resume, ignore");
                return;
            }
            Preference preference = (Preference) i.d(this.tDe).getItem(i - i.e(this.tDe).getHeaderViewsCount());
            if (preference.isEnabled() && preference.tDp && !(preference instanceof CheckBoxPreference)) {
                if (preference instanceof DialogPreference) {
                    DialogPreference dialogPreference = (DialogPreference) preference;
                    dialogPreference.showDialog();
                    dialogPreference.tBN = new 1(this, dialogPreference, preference);
                }
                if (preference instanceof EditPreference) {
                    EditPreference editPreference = (EditPreference) preference;
                    editPreference.showDialog();
                    editPreference.tBP = new 2(this, editPreference, preference);
                }
                if (preference.mKey != null) {
                    this.tDe.a(i.d(this.tDe), preference);
                }
            }
        }
    }
}
