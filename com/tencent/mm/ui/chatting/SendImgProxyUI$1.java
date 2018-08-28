package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class SendImgProxyUI$1 implements Runnable {
    final /* synthetic */ int eaN;
    final /* synthetic */ boolean tMR;
    final /* synthetic */ SendImgProxyUI tMS;

    SendImgProxyUI$1(SendImgProxyUI sendImgProxyUI, boolean z, int i) {
        this.tMS = sendImgProxyUI;
        this.tMR = z;
        this.eaN = i;
    }

    public final void run() {
        x.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(this.tMS, this.tMS.getIntent());
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(-1));
        au.Em().cik();
        x.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(this.tMS).dismiss();
        this.tMS.setResult(-1, this.tMS.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
        SendImgProxyUI.anB();
        this.tMS.finish();
        if (ao.isWifi(this.tMS) == this.tMR) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSendPicMsgEnable, this.eaN);
        }
    }
}
