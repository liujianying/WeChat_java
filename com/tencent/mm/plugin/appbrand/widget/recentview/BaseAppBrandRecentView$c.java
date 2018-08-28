package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class BaseAppBrandRecentView$c implements Runnable {
    final /* synthetic */ BaseAppBrandRecentView gPo;

    private BaseAppBrandRecentView$c(BaseAppBrandRecentView baseAppBrandRecentView) {
        this.gPo = baseAppBrandRecentView;
    }

    /* synthetic */ BaseAppBrandRecentView$c(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
        this(baseAppBrandRecentView);
    }

    public final void run() {
        List<LocalUsageInfo> jL = ((u) g.l(u.class)).jL(this.gPo.getLoadCount() + 1);
        this.gPo.getRecentItemList().clear();
        if (jL != null) {
            LocalUsageInfo alV = this.gPo.getSceneFactory() != null ? this.gPo.getSceneFactory().alV() : null;
            for (LocalUsageInfo localUsageInfo : jL) {
                if (alV == null || !localUsageInfo.username.equals(alV.username) || localUsageInfo.fmv != alV.fmv) {
                    this.gPo.getRecentItemList().add(new a(localUsageInfo));
                    if (this.gPo.getRecentItemList().size() > this.gPo.getLoadCount()) {
                        break;
                    }
                }
            }
        }
        this.gPo.as(this.gPo.getRecentItemList());
        x.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s data size:%s", new Object[]{this.gPo.getType(), Integer.valueOf(this.gPo.getRecentItemList().size())});
        ah.A(new 1(this));
    }
}
