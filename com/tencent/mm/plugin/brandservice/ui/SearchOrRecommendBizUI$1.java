package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class SearchOrRecommendBizUI$1 implements e {
    final /* synthetic */ SearchOrRecommendBizUI hpX;

    SearchOrRecommendBizUI$1(SearchOrRecommendBizUI searchOrRecommendBizUI) {
        this.hpX = searchOrRecommendBizUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
        } else if (lVar.getType() != 456) {
            x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
        } else {
            g.DF().b(456, this);
            x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                List auO = f.auO();
                f fVar = SearchOrRecommendBizUI.a(this.hpX) == null ? null : (f) SearchOrRecommendBizUI.a(this.hpX).getAdapter();
                if (fVar != null && auO != null && auO.size() > 0) {
                    int i3;
                    if (fVar.getCount() == 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    fVar.hpR = auO;
                    if (i3 != 0) {
                        ah.A(new 1(this, fVar));
                    }
                }
            }
        }
    }
}
