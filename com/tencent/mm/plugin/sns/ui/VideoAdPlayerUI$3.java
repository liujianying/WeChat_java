package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.h;

class VideoAdPlayerUI$3 implements OnClickListener {
    final /* synthetic */ VideoAdPlayerUI oiz;

    VideoAdPlayerUI$3(VideoAdPlayerUI videoAdPlayerUI) {
        this.oiz = videoAdPlayerUI;
    }

    public final void onClick(View view) {
        String[] l;
        Context context = this.oiz;
        if (VideoAdPlayerUI.k(this.oiz)) {
            l = VideoAdPlayerUI.l(this.oiz);
        } else {
            l = VideoAdPlayerUI.m(this.oiz);
        }
        h.a(context, null, l, null, new 1(this));
    }
}
