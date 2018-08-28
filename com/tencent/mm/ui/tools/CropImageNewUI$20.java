package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

class CropImageNewUI$20 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI uwf;

    CropImageNewUI$20(CropImageNewUI cropImageNewUI) {
        this.uwf = cropImageNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.uwf, 1, false);
        dVar.ofp = new c() {
            public final void a(l lVar) {
                lVar.eR(0, R.l.cropimg_share_sendmsg);
                lVar.eR(1, R.l.cropimg_share_to_sns);
            }
        };
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
