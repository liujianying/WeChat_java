package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.plugin.report.service.h;

class ReaderAppUI$9 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ ReaderAppUI mnQ;
    final /* synthetic */ String mnR;
    final /* synthetic */ bi mnS;
    final /* synthetic */ int mnT;

    ReaderAppUI$9(ReaderAppUI readerAppUI, int i, String str, bi biVar, int i2) {
        this.mnQ = readerAppUI;
        this.bpX = i;
        this.mnR = str;
        this.mnS = biVar;
        this.mnT = i2;
    }

    public final void onClick(View view) {
        if (20 == this.bpX) {
            h.mEJ.h(15413, new Object[]{Integer.valueOf(8), this.mnR, this.mnS.getTitle()});
            Intent intent = new Intent();
            intent.putExtra("mode", 1);
            String url = this.mnS.getUrl();
            intent.putExtra("news_svr_id", this.mnS.dCW);
            intent.putExtra("news_svr_tweetid", this.mnS.Iv());
            intent.putExtra("rawUrl", ReaderAppUI.a(this.mnQ, url));
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.mnS.getName());
            intent.putExtra("webpageTitle", this.mnS.getTitle());
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            Bundle bundle = new Bundle();
            bundle.putInt("snsWebSource", 3);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("shortUrl", this.mnS.Iw());
            intent.putExtra("type", this.mnS.type);
            intent.putExtra("tweetid", this.mnS.Iv());
            intent.putExtra("geta8key_username", "newsapp");
            intent.putExtra("KPublisherId", "msg_" + Long.toString(this.mnS.dCW));
            intent.putExtra("pre_username", "newsapp");
            intent.putExtra("prePublishId", "msg_" + Long.toString(this.mnS.dCW));
            intent.putExtra("preUsername", "newsapp");
            intent.putExtra("preChatName", "newsapp");
            intent.putExtra("preMsgIndex", this.mnT);
            intent.putExtra("geta8key_scene", 16);
            intent.addFlags(536870912);
            a.ezn.j(intent, this.mnQ);
        }
    }
}
