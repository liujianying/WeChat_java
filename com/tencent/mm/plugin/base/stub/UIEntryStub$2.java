package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

class UIEntryStub$2 implements a {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ UIEntryStub hdI;
    final /* synthetic */ Req hdJ;

    UIEntryStub$2(UIEntryStub uIEntryStub, Bundle bundle, Req req) {
        this.hdI = uIEntryStub;
        this.bAE = bundle;
        this.hdJ = req;
    }

    public final void dG(boolean z) {
        boolean isFinishing = this.hdI.isFinishing();
        x.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
        if (z && !isFinishing) {
            Intent intent = new Intent(this.hdI, SendAppMessageWrapperUI.class);
            intent.putExtras(this.bAE);
            intent.putExtra("Select_Conv_User", "weixinfile");
            intent.putExtra("SendAppMessageWrapper_Scene", this.hdJ.scene);
            this.hdI.startActivity(intent);
        }
        this.hdI.finish();
    }
}
