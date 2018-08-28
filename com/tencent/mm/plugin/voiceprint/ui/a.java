package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    public interface a {
        void bJd();

        void bJe();
    }

    public static void a(View view, a aVar) {
        float width = (float) view.getWidth();
        x.d("MicroMsg.VoiceViewAnimationHelper", "target " + width);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = (int) (width + ((float) iArr[0]));
        x.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i)});
        view.getParent();
        Animation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new 2(aVar, i, view));
        view.startAnimation(translateAnimation);
    }

    public static void a(View view, Context context, a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.faded_out);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new 3(aVar));
        view.startAnimation(loadAnimation);
    }
}
