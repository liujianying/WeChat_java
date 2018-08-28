package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HeaderViewListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import java.util.Iterator;

class MassSendSelectContactUI$2 implements OnClickListener {
    final /* synthetic */ MassSendSelectContactUI lbx;

    MassSendSelectContactUI$2(MassSendSelectContactUI massSendSelectContactUI) {
        this.lbx = massSendSelectContactUI;
    }

    public final void onClick(View view) {
        boolean z;
        x.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        n nVar = (n) ((HeaderViewListAdapter) this.lbx.getContentLV().getAdapter()).getWrappedAdapter();
        if (MassSendSelectContactUI.b(this.lbx)) {
            MassSendSelectContactUI.c(this.lbx).setText(R.l.mass_send_select_all);
            Iterator it = MassSendSelectContactUI.a(this.lbx).iterator();
            while (it.hasNext()) {
                MassSendSelectContactUI.d(this.lbx).Ty((String) it.next());
            }
            MassSendSelectContactUI.a(this.lbx).clear();
        } else {
            MassSendSelectContactUI.c(this.lbx).setText(R.l.mass_send_clear_all);
            int count = nVar.getCount();
            for (int i = 0; i < count; i++) {
                a FM = nVar.FM(i);
                if (!(FM == null || FM.guS == null || MassSendSelectContactUI.a(this.lbx).contains(FM.guS.field_username))) {
                    MassSendSelectContactUI.a(this.lbx).add(FM.guS.field_username);
                    MassSendSelectContactUI.d(this.lbx).Ty(FM.guS.field_username);
                }
            }
        }
        MassSendSelectContactUI massSendSelectContactUI = this.lbx;
        if (MassSendSelectContactUI.b(this.lbx)) {
            z = false;
        } else {
            z = true;
        }
        MassSendSelectContactUI.a(massSendSelectContactUI, z);
        MassSendSelectContactUI.a(this.lbx, MassSendSelectContactUI.a(this.lbx).size());
        nVar.notifyDataSetChanged();
    }
}
