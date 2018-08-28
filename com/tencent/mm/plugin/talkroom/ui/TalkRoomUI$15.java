package com.tencent.mm.plugin.talkroom.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a;
import com.tencent.mm.sdk.platformtools.bi;

class TalkRoomUI$15 implements OnTouchListener {
    final /* synthetic */ TalkRoomUI oxW;
    final /* synthetic */ a oxZ;

    TalkRoomUI$15(TalkRoomUI talkRoomUI, a aVar) {
        this.oxW = talkRoomUI;
        this.oxZ = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        a aVar = this.oxZ;
        int action = motionEvent.getAction();
        if (action == 0) {
            aVar.fto = motionEvent.getX();
            aVar.ftp = motionEvent.getY();
            aVar.oya = bi.VG();
            return true;
        }
        if (action == 1 || action == 3) {
            float abs = Math.abs(motionEvent.getX() - aVar.fto);
            float y = aVar.ftp - motionEvent.getY();
            if (y >= 100.0f && y / abs > 2.0f && y / ((float) bi.bI(aVar.oya)) > 0.6f) {
                aVar.bHr();
                return true;
            }
        }
        return false;
    }
}
