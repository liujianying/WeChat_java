package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class BizContactEntranceView$2 implements OnTouchListener {
    final /* synthetic */ BizContactEntranceView uil;

    BizContactEntranceView$2(BizContactEntranceView bizContactEntranceView) {
        this.uil = bizContactEntranceView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (BizContactEntranceView.a(this.uil) instanceof MMActivity) {
            ((MMActivity) BizContactEntranceView.a(this.uil)).YC();
        }
        return false;
    }
}
