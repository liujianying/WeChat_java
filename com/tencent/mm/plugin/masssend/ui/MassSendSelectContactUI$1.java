package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class MassSendSelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendSelectContactUI lbx;

    MassSendSelectContactUI$1(MassSendSelectContactUI massSendSelectContactUI) {
        this.lbx = massSendSelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        List F = bi.F((String[]) MassSendSelectContactUI.a(this.lbx).toArray(new String[0]));
        if (F == null) {
            x.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
            return false;
        }
        F.remove(q.GF());
        String c = bi.c(F, ";");
        Intent intent = new Intent(this.lbx, MassSendMsgUI.class);
        intent.putExtra("mass_send_contact_list", c);
        this.lbx.startActivity(intent);
        return true;
    }
}
