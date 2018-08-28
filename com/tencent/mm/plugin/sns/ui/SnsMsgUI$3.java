package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$3 implements OnScrollListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$3(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (SnsMsgUI.g(this.nYl)) {
            x.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[]{Integer.valueOf(i)});
            if (i == 2) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.l(this.nYl));
                SnsMsgUI.b(this.nYl, HardCoderJNI.startPerformance(HardCoderJNI.hcSNSMsgScrollEnable, HardCoderJNI.hcSNSMsgScrollDelay, HardCoderJNI.hcSNSMsgScrollCPU, HardCoderJNI.hcSNSMsgScrollIO, HardCoderJNI.hcSNSMsgScrollThr ? Process.myTid() : 0, HardCoderJNI.hcSNSMsgScrollTimeout, 705, HardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI"));
                x.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[]{Integer.valueOf(SnsMsgUI.l(this.nYl))});
            }
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (af.byt().axd() > 0) {
                    af.byt().axe();
                } else {
                    SnsMsgUI.e(this.nYl).ayR();
                }
                SnsMsgUI.e(this.nYl).a(null, null);
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
