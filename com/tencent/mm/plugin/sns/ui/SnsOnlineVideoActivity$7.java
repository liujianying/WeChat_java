package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.widget.a.d;

class SnsOnlineVideoActivity$7 implements OnLongClickListener {
    final /* synthetic */ SnsOnlineVideoActivity nZl;

    SnsOnlineVideoActivity$7(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.nZl = snsOnlineVideoActivity;
    }

    public final boolean onLongClick(View view) {
        SnsOnlineVideoActivity.a(this.nZl, new d(this.nZl.mController.tml, 1, false));
        SnsOnlineVideoActivity.l(this.nZl).ofp = this.nZl.nZk;
        SnsOnlineVideoActivity.l(this.nZl).ofq = this.nZl.hqV;
        SnsOnlineVideoActivity.l(this.nZl).uJQ = new 1(this);
        SnsOnlineVideoActivity.l(this.nZl).bXO();
        return true;
    }
}
