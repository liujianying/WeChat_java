package com.tencent.mm.ui.chatting.b;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter$d;
import com.tencent.mm.sdk.platformtools.x;

class q$1 implements ChatFooter$d {
    private Animation tPV;
    private Animation tPW;
    final /* synthetic */ q tPX;

    q$1(q qVar) {
        this.tPX = qVar;
    }

    public final boolean kS(boolean z) {
        if (this.tPV == null) {
            this.tPV = AnimationUtils.loadAnimation(this.tPX.bAG.tTq.getContext(), R.a.push_up_in);
            this.tPW = AnimationUtils.loadAnimation(this.tPX.bAG.tTq.getContext(), R.a.push_down_out);
        }
        if (z) {
            x.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[]{this.tPX.tPJ});
            if (this.tPX.tPJ != null) {
                this.tPX.tPJ.startAnimation(this.tPW);
            }
            this.tPX.cvh();
            this.tPX.laA.startAnimation(this.tPV);
            this.tPX.laA.postInvalidateDelayed(this.tPV.getDuration());
        } else {
            this.tPX.bAG.YC();
            this.tPX.laA.startAnimation(this.tPW);
            this.tPX.cvg();
            if (this.tPX.tPJ != null) {
                this.tPX.tPJ.startAnimation(this.tPV);
                this.tPX.tPJ.postInvalidateDelayed(this.tPV.getDuration());
            }
        }
        return false;
    }
}
