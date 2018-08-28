package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.map.a.g;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class j$1 extends ag {
    final /* synthetic */ j kGm;

    j$1(j jVar, Looper looper) {
        this.kGm = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        j jVar;
        Message obtain;
        String gT;
        switch (message.what) {
            case 1:
                this.kGm.Dm.setText(this.kGm.kGl);
                return;
            case 2:
                x.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[]{Boolean.valueOf(this.kGm.kFQ), Boolean.valueOf(this.kGm.kGk)});
                if (!this.kGm.kFQ && !this.kGm.kGk) {
                    jVar = this.kGm;
                    jVar.Dm.setTextColor(jVar.kGh);
                    jVar.Dm.invalidate();
                    int intValue = ((Integer) message.obj).intValue();
                    if (intValue == 0) {
                        this.kGm.Dm.setText(this.kGm.context.getString(h.track_none_contact_num));
                        return;
                    }
                    this.kGm.Dm.setText(this.kGm.context.getResources().getQuantityString(g.track_contact_num, intValue, new Object[]{Integer.valueOf(intValue)}));
                    return;
                }
                return;
            case 3:
                if (this.kGm.kGk || this.kGm.kFQ) {
                    removeMessages(3);
                    obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = message.obj;
                    sendMessage(obtain);
                    return;
                }
                this.kGm.kGl = this.kGm.Dm.getText().toString();
                j.a(this.kGm);
                gT = r.gT((String) message.obj);
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_somebody_enter, new Object[]{gT}));
                if (this.kGm.kFQ || this.kGm.kGk) {
                    j.b(this.kGm);
                    return;
                }
                return;
            case 4:
                if (this.kGm.kGk || this.kGm.kFQ) {
                    removeMessages(4);
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = message.obj;
                    sendMessage(obtain);
                    return;
                }
                this.kGm.kGl = this.kGm.Dm.getText().toString();
                j.a(this.kGm);
                gT = r.gT((String) message.obj);
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_somebody_exit, new Object[]{gT}));
                if (this.kGm.kFQ || this.kGm.kGk) {
                    j.b(this.kGm);
                    return;
                }
                return;
            case 5:
                this.kGm.kGk = true;
                this.kGm.kFQ = false;
                j.a(this.kGm);
                gT = r.gT((String) message.obj);
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_somebody_saying, new Object[]{gT}));
                return;
            case 6:
                this.kGm.kFQ = true;
                this.kGm.kGk = false;
                j.a(this.kGm);
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_self_saying));
                return;
            case 7:
                this.kGm.kGk = true;
                jVar = this.kGm;
                jVar.Dm.setTextColor(jVar.kGi);
                jVar.Dm.invalidate();
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_talk_conflict));
                this.kGm.kGl = this.kGm.Dm.getText().toString();
                j.b(this.kGm);
                return;
            case 8:
                jVar = this.kGm;
                jVar.Dm.setTextColor(jVar.kGj);
                jVar.Dm.invalidate();
                this.kGm.Dm.setText(this.kGm.context.getString(h.track_talk_preparing));
                return;
            case 9:
                this.kGm.kFQ = false;
                if (!this.kGm.kGk) {
                    this.kGm.gh(true);
                    return;
                }
                return;
            case 10:
                this.kGm.kGk = false;
                this.kGm.gh(false);
                return;
            default:
                return;
        }
    }
}
