package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.graphics.Bitmap;
import com.tencent.mm.aa.c;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.sdk.platformtools.x;

class NewBizInfoMoreInofUI$2 implements Runnable {
    final /* synthetic */ String lVV;
    final /* synthetic */ NewBizInfoMoreInofUI lYT;

    NewBizInfoMoreInofUI$2(NewBizInfoMoreInofUI newBizInfoMoreInofUI, String str) {
        this.lYT = newBizInfoMoreInofUI;
        this.lVV = str;
    }

    public final void run() {
        if (NewBizInfoMoreInofUI.a(this.lYT) == null) {
            x.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
            return;
        }
        IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) NewBizInfoMoreInofUI.a(this.lYT).ZZ("contact_info_kf_worker");
        if (iconWidgetPreference != null && NewBizInfoMoreInofUI.a(this.lYT) != null) {
            Bitmap a = c.a(this.lVV, false, -1);
            if (a != null) {
                x.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", new Object[]{this.lVV});
                iconWidgetPreference.C(a);
                NewBizInfoMoreInofUI.a(this.lYT).notifyDataSetChanged();
            }
        }
    }
}
