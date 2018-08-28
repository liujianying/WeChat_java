package com.tencent.mm.ui.conversation;

import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.c.3;

class c$3$1 implements Runnable {
    final /* synthetic */ 3 unT;

    c$3$1(3 3) {
        this.unT = 3;
    }

    public final void run() {
        int firstVisiblePosition;
        int i;
        int i2;
        int abs;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.unT.unR >= 3000 || this.unT.unS < 0) {
            firstVisiblePosition = (this.unT.unP.unh.getFirstVisiblePosition() - this.unT.unP.unh.getHeaderViewsCount()) + 1;
            if (firstVisiblePosition < 0) {
                i = 0;
            } else {
                i = firstVisiblePosition;
            }
        } else {
            i = this.unT.unS;
        }
        g gVar = this.unT.unP.unL;
        if (this.unT.unP.unK > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int count = gVar.getCount();
        if (count > 0) {
            for (abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                ai aiVar = (ai) gVar.Dy(abs);
                if (aiVar != null && (aiVar.field_unReadCount > 0 || aiVar.field_unReadMuteCount > 0)) {
                    if (i2 == 0) {
                        i2 = abs;
                        break;
                    } else if (g.a(aiVar, gVar.i(aiVar)) == 2) {
                        i2 = abs;
                        break;
                    }
                }
            }
        }
        i2 = -1;
        if (i2 < 0) {
            c.a(this.unT.unP.unh);
        } else {
            ListView listView = this.unT.unP.unh;
            abs = this.unT.unP.unh.getHeaderViewsCount() + i2;
            if (listView != null) {
                if (VERSION.SDK_INT >= 11) {
                    bc bcVar = new bc();
                    int firstVisiblePosition2 = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition2 < abs && firstVisiblePosition2 + 10 < abs) {
                        listView.setSelectionFromTop(abs - 10, 0);
                    } else if (firstVisiblePosition2 > abs && firstVisiblePosition2 - 10 > abs) {
                        listView.setSelectionFromTop(abs + 10, 0);
                    }
                    if (VERSION.SDK_INT >= 11) {
                        listView.smoothScrollToPositionFromTop(abs, 0);
                    }
                } else {
                    bb bbVar = new bb();
                    listView.setSelectionFromTop(abs, 0);
                }
            }
        }
        this.unT.unR = currentTimeMillis;
        3 3 = this.unT;
        if (i2 < 0) {
            firstVisiblePosition = 0;
        } else {
            firstVisiblePosition = i2;
        }
        3.unS = firstVisiblePosition;
        x.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", new Object[]{Integer.valueOf(this.unT.unP.unh.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
