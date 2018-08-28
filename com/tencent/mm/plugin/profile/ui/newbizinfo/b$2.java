package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

class b$2 implements OnMenuItemClickListener {
    final /* synthetic */ b lYu;

    b$2(b bVar) {
        this.lYu = bVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.lYu.lYs, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        c.bT(this.lYu.guS.field_username, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED);
        return false;
    }
}
