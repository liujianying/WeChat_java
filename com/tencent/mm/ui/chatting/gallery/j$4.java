package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

class j$4 implements a {
    final /* synthetic */ j tXq;

    j$4(j jVar) {
        this.tXq = jVar;
    }

    public final void iy() {
        if (this.tXq.tTU != null) {
            this.tXq.tTU.tTE.cxt();
        }
    }

    public final void onError(int i, int i2) {
        x.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
        if (this.tXq.tTU != null) {
            this.tXq.tTU.tTE.eZ(i, i2);
        }
        h.mEJ.h(12084, new Object[]{Integer.valueOf(this.tXq.tXo), Integer.valueOf(this.tXq.nFC * TbsLog.TBSLOG_CODE_SDK_BASE), Integer.valueOf(0), Integer.valueOf(4), this.tXq.bSS, Integer.valueOf(this.tXq.tXp), this.tXq.fileId, Long.valueOf(this.tXq.createTime)});
    }

    public final void wd() {
        ah.A(new 1(this));
    }

    public final int ck(int i, int i2) {
        x.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.tXq.nFC), Integer.valueOf(i2), Integer.valueOf(this.tXq.tXo), Integer.valueOf(this.tXq.tXp), this.tXq.bSS});
        au.Em().H(new 2(this, i2, i));
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
