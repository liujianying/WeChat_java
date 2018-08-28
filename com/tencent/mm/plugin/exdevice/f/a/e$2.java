package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;

class e$2 implements d {
    final /* synthetic */ MMActivity ixt;

    e$2(MMActivity mMActivity) {
        this.ixt = mMActivity;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case 0:
                MMActivity mMActivity = this.ixt;
                Intent intent = new Intent();
                intent.putExtra("query_source_type", 9);
                intent.putExtra("query_media_type", 1);
                intent.putExtra("max_select_count", 1);
                com.tencent.mm.bg.d.b(mMActivity, "gallery", ".ui.AlbumPreviewUI", intent, 1001);
                return;
            default:
                return;
        }
    }
}
