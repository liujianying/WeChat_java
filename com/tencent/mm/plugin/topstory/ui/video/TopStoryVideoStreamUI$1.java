package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.k;
import android.view.View;
import com.tencent.mm.plugin.topstory.ui.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.Log;

class TopStoryVideoStreamUI$1 extends k {
    public int oAY = 0;
    private long oAZ = -1;
    final /* synthetic */ TopStoryVideoStreamUI oBa;

    TopStoryVideoStreamUI$1(TopStoryVideoStreamUI topStoryVideoStreamUI) {
        this.oBa = topStoryVideoStreamUI;
    }

    public final void e(RecyclerView recyclerView, int i) {
        switch (i) {
            case 0:
                TopStoryVideoStreamUI topStoryVideoStreamUI = this.oBa;
                if (!topStoryVideoStreamUI.bHQ().jMc) {
                    Log.d("MicroMsg.TopStory.TopStoryTimeLineItemViewController", "onScrollStop");
                    c b = h.b(topStoryVideoStreamUI);
                    if (b != null) {
                        if (!topStoryVideoStreamUI.bHS().oCg) {
                            if (topStoryVideoStreamUI.bHR().aEY()) {
                                b.iE(false);
                            } else {
                                if (topStoryVideoStreamUI.bHR().isConnected()) {
                                    b.oCJ.bIn();
                                } else {
                                    b.oCJ.bIo();
                                }
                                topStoryVideoStreamUI.bHS().stopPlay();
                            }
                        }
                        b.bHK();
                    }
                    topStoryVideoStreamUI.bHU().bIe();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        int itemCount;
        int i3 = 0;
        TopStoryVideoStreamUI topStoryVideoStreamUI = this.oBa;
        if (!topStoryVideoStreamUI.bHQ().jMc) {
            RecyclerView bAt = topStoryVideoStreamUI.bAt();
            c a = h.a(topStoryVideoStreamUI);
            int i4 = a != null ? a.position : -1;
            if (i4 != topStoryVideoStreamUI.bHP() && topStoryVideoStreamUI.bHS().oCg) {
                topStoryVideoStreamUI.bHS().stopPlay();
            }
            topStoryVideoStreamUI.bHL();
            for (int i5 = 0; i5 < bAt.getChildCount(); i5++) {
                View childAt = bAt.getChildAt(i5);
                if (childAt.getTag() != null) {
                    a = (c) topStoryVideoStreamUI.bAt().aP(childAt);
                    n nVar;
                    if (a.position == i4) {
                        a.bIJ();
                        a.bHK();
                        if (!topStoryVideoStreamUI.bHS().oCg) {
                            nVar = a.oCJ;
                            x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "setListScrollPlayContainerStatus");
                            nVar.oBg.setVisibility(8);
                            nVar.oBp.setVisibility(0);
                            nVar.oBl.setVisibility(8);
                            nVar.oBe.setVisibility(8);
                            nVar.oBd.setVisibility(8);
                            nVar.oBz.setVisibility(8);
                        }
                    } else {
                        a.bII();
                        nVar = a.oCJ;
                        x.d("MicroMsg.TopStory.TopStoryVideoViewContainer", "setListScrollStopContainerStatus");
                        nVar.oBg.setVisibility(0);
                        nVar.oBp.setVisibility(0);
                        nVar.oBl.setVisibility(8);
                        nVar.oBe.setVisibility(8);
                        nVar.oBd.setVisibility(8);
                        nVar.oBz.setVisibility(8);
                        nVar.oBi.setVisibility(0);
                        nVar.oBh.setVisibility(8);
                        nVar.oBk.setVisibility(8);
                        nVar.oBq.setVisibility(0);
                        nVar.oBr.setVisibility(8);
                        nVar.oBu.setVisibility(8);
                    }
                }
            }
            topStoryVideoStreamUI.yg(i4);
        }
        this.oAY = TopStoryVideoStreamUI.a(this.oBa).fj();
        LinearLayoutManager a2 = TopStoryVideoStreamUI.a(this.oBa);
        a adapter = a2.Sa != null ? a2.Sa.getAdapter() : null;
        if (adapter != null) {
            itemCount = adapter.getItemCount();
        } else {
            itemCount = 0;
        }
        if (this.oAZ <= 0 || bi.bI(this.oAZ) >= 50) {
            this.oAZ = bi.VG();
            if (!this.oBa.oAQ.jMc) {
                if (TopStoryVideoStreamUI.b(this.oBa).oAv != 1) {
                    if (this.oAY >= itemCount - 1 && !TopStoryVideoStreamUI.b(this.oBa).oAu && bi.bI(TopStoryVideoStreamUI.c(this.oBa)) >= 50) {
                        itemCount = 1;
                    }
                    itemCount = 0;
                } else {
                    if (itemCount - this.oAY <= 2 && !TopStoryVideoStreamUI.b(this.oBa).oAu && bi.bI(TopStoryVideoStreamUI.c(this.oBa)) >= 50) {
                        itemCount = 1;
                    }
                    itemCount = 0;
                }
                if (this.oBa.bIh()) {
                    i3 = itemCount;
                }
                if (i3 != 0) {
                    TopStoryVideoStreamUI.d(this.oBa);
                }
            }
        }
    }
}
