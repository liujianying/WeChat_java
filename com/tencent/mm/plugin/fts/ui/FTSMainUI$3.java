package com.tencent.mm.plugin.fts.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView.b;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FTSMainUI$3 implements d {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$3(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void a(boolean z, bgd bgd, String str, String str2) {
        if (!this.jxp.bWm.equals(str2)) {
            x.i("MicroMsg.FTS.FTSMainUI", "IRelevantSearchCallback callback with query %s, current query is %s ", new Object[]{str2, this.jxp.bWm});
        } else if (!z) {
            FTSMainUI.a(this.jxp).setVisibility(8);
        } else if (FTSMainUI.l(this.jxp).getVisibility() == 0) {
            int i;
            FTSLocalPageRelevantView a = FTSMainUI.a(this.jxp);
            if (bgd == null || bgd.rdR == null) {
                x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
                i = 0;
            } else {
                List bm = FTSLocalPageRelevantView.bm(bgd.rdR);
                if (bm.size() <= 0) {
                    x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
                    i = 0;
                } else {
                    a.bWm = str2;
                    a.fuu = str;
                    a.jzG = bgd.rdR;
                    if (a.gxh == null) {
                        a.gxh = new RecyclerView(a.getContext());
                        RecyclerView recyclerView = a.gxh;
                        a.getContext();
                        recyclerView.setLayoutManager(new LinearLayoutManager());
                        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = -2;
                        a.addView(a.gxh, layoutParams);
                        a.jzH = new b(a);
                        a.gxh.setAdapter(a.jzH);
                    }
                    b bVar = a.jzH;
                    bVar.jzK = bm;
                    bVar.RR.notifyChanged();
                    a.requestLayout();
                    i = 1;
                }
            }
            if (i != 0) {
                FTSMainUI.a(this.jxp).setVisibility(0);
            }
        }
    }
}
