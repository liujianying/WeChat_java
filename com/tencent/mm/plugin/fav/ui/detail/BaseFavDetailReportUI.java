package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI extends MMActivity {
    public a jcb = new a();
    protected boolean jcc;
    private String jcd = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jcb.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.jcb.iVT = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.jcb.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        this.jcb.bWm = getIntent().getStringExtra("key_detail_fav_query");
        this.jcb.iVU = getIntent().getStringExtra("key_detail_fav_sessionid");
        this.jcb.iVW = getIntent().getStringExtra("key_detail_fav_tags");
        this.jcb.bWm = this.jcb.bWm == null ? "" : this.jcb.bWm;
        this.jcb.iVU = this.jcb.iVU == null ? "" : this.jcb.iVU;
        this.jcb.iVW = this.jcb.iVW == null ? "" : this.jcb.iVW;
        MMLoadScrollView aMI = aMI();
        if (aMI != null) {
            aMI.setOnTopOrBottomListerner(new 1(this));
        }
        if (this.jcb.scene == 0) {
            x.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
    }

    protected MMLoadScrollView aMI() {
        return null;
    }

    public void onResume() {
        super.onResume();
        if (bi.oW(this.jcd)) {
            this.jcd = f.RY().ejF;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[]{this.jcd});
    }

    public void onPause() {
        this.jcb.iVJ = cql();
        String str = f.RY().ejF;
        if (!(bi.fS(getClass().getName(), str) || bi.fS(str, this.jcd))) {
            a aVar = this.jcb;
            long j = aVar.iVK;
            f RY = f.RY();
            aVar.iVK = (RY.ejE != null ? ((Long) RY.ejE.get(f.RY().ejF)).longValue() : 0) + j;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[]{str, Long.valueOf(this.jcb.iVJ), Long.valueOf(this.jcb.iVK)});
        super.onPause();
    }

    public final void F(g gVar) {
        if (gVar != null && this.jcb.scene > 0) {
            this.jcb.iVH = (long) gVar.field_id;
            this.jcb.type = gVar.field_type;
            this.jcb.source = gVar.field_sourceType;
            this.jcb.timestamp = gVar.field_sourceCreateTime / 1000;
            if (this.jcb.timestamp == 0) {
                this.jcb.timestamp = gVar.field_updateTime / 1000;
            }
            if (this.jcb.timestamp == 0) {
                this.jcb.timestamp = gVar.field_edittime;
            }
            this.jcb.iVI = b.r(gVar);
            this.jcc = true;
        }
    }

    public final void dE(long j) {
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
        if (dy != null) {
            F(dy);
        }
    }

    public void onDestroy() {
        if (this.jcc) {
            e.post(new Runnable() {
                public final void run() {
                    BaseFavDetailReportUI.this.jcb.iVV = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().pL((int) BaseFavDetailReportUI.this.jcb.iVH) + 1;
                    h.a(BaseFavDetailReportUI.this.jcb);
                }
            }, "BaseFavReport");
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cql()));
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            a aVar = this.jcb;
            aVar.iVK += longExtra;
            x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[]{Long.valueOf(this.jcb.iVK), Long.valueOf(longExtra)});
        }
        super.onActivityResult(i, i2, intent);
    }
}
