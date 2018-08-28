package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class SnsAddressUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsAddressUI ulS;

    SnsAddressUI$1(SnsAddressUI snsAddressUI) {
        this.ulS = snsAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        List F = bi.F((String[]) SnsAddressUI.a(this.ulS).toArray(new String[0]));
        if (F == null || F.size() == 0) {
            intent.putExtra("Select_Contact", "");
        } else {
            intent.putExtra("Select_Contact", bi.c(F, ","));
        }
        this.ulS.setResult(-1, intent);
        this.ulS.finish();
        ah.i(new 1(this), 100);
        return true;
    }
}
