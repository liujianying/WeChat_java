package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.conversation.i.4.1;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKContentType;
import java.io.File;

class i$4$1$1 implements OnClickListener {
    final /* synthetic */ 1 uqU;

    i$4$1$1(1 1) {
        this.uqU = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(this.uqU.uqT.uqS.sqp)), TMAssistantDownloadSDKContentType.CONTENT_TYPE_APK);
        i.a(this.uqU.uqT.uqR).startActivity(intent);
        h.mEJ.a(614, 50, 1, false);
        dialogInterface.dismiss();
    }
}
