package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

class PreviewHdHeadImg$1 implements OnMenuItemClickListener {
    final /* synthetic */ PreviewHdHeadImg mQr;

    PreviewHdHeadImg$1(PreviewHdHeadImg previewHdHeadImg) {
        this.mQr = previewHdHeadImg;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.mQr, 1, false);
        dVar.ofp = new c() {
            public final void a(l lVar) {
                lVar.eR(1, i.settings_avatar_select_from_album);
                if (com.tencent.mm.aa.c.a(PreviewHdHeadImg.a(PreviewHdHeadImg$1.this.mQr), true, -1) != null) {
                    lVar.eR(2, i.get_hd_head_img_save_alert);
                }
            }
        };
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
