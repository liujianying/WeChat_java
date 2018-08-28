package com.tencent.mm.ui.tools;

import android.os.Parcelable;
import com.tencent.mm.ui.tools.ShareImgUI.4;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class ShareImgUI$4$1 implements Runnable {
    final /* synthetic */ ArrayList uBQ;
    final /* synthetic */ Parcelable uBR;
    final /* synthetic */ boolean[] uBS;
    final /* synthetic */ CountDownLatch uBT;
    final /* synthetic */ 4 uBU;

    ShareImgUI$4$1(4 4, ArrayList arrayList, Parcelable parcelable, boolean[] zArr, CountDownLatch countDownLatch) {
        this.uBU = 4;
        this.uBQ = arrayList;
        this.uBR = parcelable;
        this.uBS = zArr;
        this.uBT = countDownLatch;
    }

    public final void run() {
        if (!ShareImgUI.a(this.uBU.uBN, this.uBQ, this.uBR)) {
            this.uBS[0] = true;
        }
        this.uBT.countDown();
    }
}
