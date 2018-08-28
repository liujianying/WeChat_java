package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.1;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$4 implements a {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$4(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final boolean vD() {
        VoiceTipInfoView c = BaseVoicePrintUI.c(this.oFR);
        if (c.oGm.getAnimation() == null) {
            View view = c.oGm;
            Context context = c.getContext();
            1 1 = new 1(c);
            float width = (float) view.getWidth();
            x.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i = (int) (width + ((float) iArr[0]));
            x.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i)});
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.tip_scale);
            loadAnimation.setDuration(200);
            loadAnimation.setStartOffset(0);
            loadAnimation.setRepeatCount(0);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new a.1(1));
            view.startAnimation(loadAnimation);
        }
        return false;
    }
}
