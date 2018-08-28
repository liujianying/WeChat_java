package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

class SelectContactUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$17(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List c = SelectContactUI.c(this.ulL, s.fb(SelectContactUI.a(this.ulL), 8192));
        c.remove(q.GF());
        boolean z = s.fb(SelectContactUI.a(this.ulL), Downloads.RECV_BUFFER_SIZE) && c.size() > 1;
        if (!z) {
            return SelectContactUI.b(this.ulL, SelectContactUI.a(this.ulL, s.fb(SelectContactUI.a(this.ulL), 8192)));
        }
        if (!SelectContactUI.c(this.ulL)) {
            SelectContactUI.d(this.ulL, true);
            SelectContactUI.d(this.ulL);
        }
        x.i("MicroMsg.SelectContactUI", "Create the chatroom");
        return true;
    }
}
