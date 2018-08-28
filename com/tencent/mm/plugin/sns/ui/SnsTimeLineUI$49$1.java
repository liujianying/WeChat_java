package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.49;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$49$1 implements OnClickListener {
    final /* synthetic */ String odH;
    final /* synthetic */ 49 odI;

    SnsTimeLineUI$49$1(49 49, String str) {
        this.odI = 49;
        this.odH = str;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
        Intent intent = new Intent(this.odI.odw, SnsCommentDetailUI.class);
        intent.putExtra("INTENT_TALKER", this.odI.nMf.field_userName);
        intent.putExtra("INTENT_SNS_LOCAL_ID", this.odI.nMf.nJc);
        intent.putExtra("INTENT_FROMGALLERY", false);
        intent.putExtra("intent_show_collapse_info", true);
        intent.putExtra("intent_content_collapse_hint", this.odH);
        this.odI.odw.startActivity(intent);
        i.fc(this.odI.nWp);
    }
}
