package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.m.b;
import com.tencent.mm.sdk.platformtools.ag;

class m$1 extends ag {
    final /* synthetic */ m qNl;

    m$1(m mVar) {
        this.qNl = mVar;
    }

    public final void handleMessage(Message message) {
        int i = 0;
        switch (message.what) {
            case 20001:
                this.qNl.hide();
                return;
            case 20002:
                removeMessages(20001);
                return;
            case 20003:
                m mVar = this.qNl;
                mVar.mHandler.removeMessages(20001);
                if (mVar.qNf) {
                    b bVar = mVar.qNh;
                    bVar.mData = mVar.inB;
                    bVar.notifyDataSetInvalidated();
                    if (mVar.inB != null && mVar.inB.size() > 2) {
                        mVar.qNa.setWidth(((int) (((double) mVar.qMY) * 2.5d)) + (mVar.qMZ * 2));
                    } else if (mVar.inB == null || mVar.inB.size() != 2) {
                        mVar.qNa.setWidth(mVar.qMY + (mVar.qMZ * 2));
                    } else {
                        mVar.qNa.setWidth((mVar.qMY * 2) + (mVar.qMZ * 2));
                    }
                    mVar.ceT();
                    if (mVar.inB == null || mVar.inB.size() < 3) {
                        mVar.mHandler.sendEmptyMessageDelayed(20001, 3000);
                    } else {
                        mVar.mHandler.sendEmptyMessageDelayed(20001, 5000);
                    }
                    h hVar = h.mEJ;
                    Object[] objArr = new Object[6];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = mVar.qNd;
                    objArr[2] = "";
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = "";
                    if (mVar.inB != null) {
                        i = mVar.inB.size();
                    }
                    objArr[5] = Integer.valueOf(i);
                    hVar.h(10994, objArr);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
