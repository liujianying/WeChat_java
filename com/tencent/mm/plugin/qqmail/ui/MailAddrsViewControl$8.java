package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.plugin.qqmail.b.i;

class MailAddrsViewControl$8 extends SimpleOnGestureListener {
    final /* synthetic */ MailAddrsViewControl mhb;

    MailAddrsViewControl$8(MailAddrsViewControl mailAddrsViewControl) {
        this.mhb = mailAddrsViewControl;
    }

    private void bpc() {
        i iVar = (i) MailAddrsViewControl.c(this.mhb).getTag();
        if (MailAddrsViewControl.g(this.mhb) != null) {
            MailAddrsViewControl.g(this.mhb);
            MailAddrsViewControl.c(this.mhb);
        }
        Intent intent = new Intent(this.mhb.getContext(), MailAddrProfileUI.class);
        intent.putExtra("name", iVar.name);
        intent.putExtra("addr", iVar.kCs);
        intent.putExtra("can_compose", !MailAddrsViewControl.h(this.mhb));
        this.mhb.getContext().startActivity(intent);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!MailAddrsViewControl.h(this.mhb)) {
            bpc();
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (MailAddrsViewControl.g(this.mhb) != null && MailAddrsViewControl.c(this.mhb) != null) {
            MailAddrsViewControl.g(this.mhb);
            MailAddrsViewControl.c(this.mhb);
            MailAddrsViewControl.c(this.mhb).getTag();
        }
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        bpc();
        return true;
    }
}
