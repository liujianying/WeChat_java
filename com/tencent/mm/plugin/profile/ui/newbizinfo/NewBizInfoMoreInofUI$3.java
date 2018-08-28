package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;

class NewBizInfoMoreInofUI$3 implements OnClickListener {
    final /* synthetic */ String hGV;
    final /* synthetic */ NewBizInfoMoreInofUI lYT;

    NewBizInfoMoreInofUI$3(NewBizInfoMoreInofUI newBizInfoMoreInofUI, String str) {
        this.lYT = newBizInfoMoreInofUI;
        this.hGV = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.hGV).toString()));
        if (bi.k(this.lYT, intent)) {
            this.lYT.startActivity(intent);
        }
    }
}
