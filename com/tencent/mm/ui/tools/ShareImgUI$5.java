package com.tencent.mm.ui.tools;

import com.tencent.mm.ui.tools.ShareImgUI.b;
import java.util.ArrayList;

class ShareImgUI$5 implements Runnable {
    final /* synthetic */ ShareImgUI uBN;
    final /* synthetic */ b uBO;
    final /* synthetic */ ArrayList uBV;

    ShareImgUI$5(ShareImgUI shareImgUI, b bVar, ArrayList arrayList) {
        this.uBN = shareImgUI;
        this.uBO = bVar;
        this.uBV = arrayList;
    }

    public final void run() {
        this.uBO.ah(this.uBV);
    }
}
