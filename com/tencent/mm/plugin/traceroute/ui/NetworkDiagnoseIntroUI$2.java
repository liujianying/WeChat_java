package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.traceroute.a.a;

class NetworkDiagnoseIntroUI$2 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseIntroUI oDQ;

    NetworkDiagnoseIntroUI$2(NetworkDiagnoseIntroUI networkDiagnoseIntroUI) {
        this.oDQ = networkDiagnoseIntroUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.oDQ.getString(R.l.privacy_tip));
        intent.putExtra("rawUrl", this.oDQ.getString(R.l.url_agreement));
        intent.putExtra("showShare", false);
        a.ezn.j(intent, this.oDQ.mController.tml);
    }
}
