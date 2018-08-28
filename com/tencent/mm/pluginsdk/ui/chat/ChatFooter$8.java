package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$8 implements OnTouchListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$8(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == ChatFooter.r(this.qMv)) {
            x.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
            switch (motionEvent.getAction()) {
                case 0:
                    x.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[]{Integer.valueOf(ChatFooter.ceP())});
                    if (ChatFooter.s(this.qMv) instanceof Activity) {
                        ((Activity) ChatFooter.s(this.qMv)).getWindow().addFlags(128);
                    }
                    if (!(ChatFooter.t(this.qMv) || ChatFooter.u(this.qMv))) {
                        ChatFooter.c(this.qMv, true);
                        ChatFooter.r(this.qMv).setBackgroundDrawable(a.f(this.qMv.getContext(), R.g.record_shape_press));
                        ChatFooter.r(this.qMv).setText(R.l.chatfooter_releasetofinish);
                        if (ChatFooter.j(this.qMv) != null) {
                            ChatFooter.j(this.qMv).bct();
                        }
                        ChatFooter.r(this.qMv).setContentDescription(this.qMv.getContext().getString(R.l.chat_footer_switch_press_btn));
                        break;
                    }
                case 1:
                case 3:
                    if (ChatFooter.s(this.qMv) instanceof Activity) {
                        ((Activity) ChatFooter.s(this.qMv)).getWindow().clearFlags(128);
                    }
                    x.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[]{Integer.valueOf(ChatFooter.ceP())});
                    ChatFooter.y(this.qMv);
                    x.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[]{Integer.valueOf(ChatFooter.ceQ())});
                    break;
                case 2:
                    if (ChatFooter.v(this.qMv) == null || ChatFooter.w(this.qMv) == null) {
                        x.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[]{ChatFooter.v(this.qMv), ChatFooter.w(this.qMv)});
                    }
                    if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-ChatFooter.x(this.qMv)) / 2)) && motionEvent.getX() < ((float) ChatFooter.r(this.qMv).getWidth())) {
                        if (ChatFooter.v(this.qMv) != null) {
                            ChatFooter.v(this.qMv).setVisibility(0);
                        }
                        if (ChatFooter.w(this.qMv) != null) {
                            ChatFooter.r(this.qMv).setText(R.l.chatfooter_releasetofinish);
                            ChatFooter.w(this.qMv).setVisibility(8);
                            break;
                        }
                    }
                    x.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", new Object[]{Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(ChatFooter.x(this.qMv)), Integer.valueOf(ChatFooter.r(this.qMv).getWidth()), Integer.valueOf(ChatFooter.r(this.qMv).getHeight())});
                    if (ChatFooter.v(this.qMv) != null) {
                        ChatFooter.v(this.qMv).setVisibility(8);
                    }
                    if (ChatFooter.w(this.qMv) != null) {
                        ChatFooter.r(this.qMv).setText(R.l.chatfooter_cancel_tips);
                        ChatFooter.w(this.qMv).setVisibility(0);
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
