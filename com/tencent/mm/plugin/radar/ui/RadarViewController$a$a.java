package com.tencent.mm.plugin.radar.ui;

import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import b.c.b.e;
import b.i;
import com.tencent.mm.plugin.radar.ui.RadarViewController.a;
import com.tencent.mm.sdk.platformtools.ag;

public final class RadarViewController$a$a extends ag {
    final /* synthetic */ a mmO;

    RadarViewController$a$a(a aVar) {
        this.mmO = aVar;
    }

    public final void handleMessage(Message message) {
        e.i(message, "msg");
        if (message.obj instanceof View) {
            Object obj = message.obj;
            if (obj == null) {
                throw new i("null cannot be cast to non-null type android.view.View");
            }
            View view = (View) obj;
            view.setVisibility(0);
            view.clearAnimation();
            if (!this.mmO.mmL) {
                Object tag = view.getTag(this.mmO.mmN.mmI);
                if (!(tag instanceof Animation)) {
                    tag = null;
                }
                Animation animation = (Animation) tag;
                if (animation == null) {
                    animation = this.mmO.getInAnimation();
                }
                view.startAnimation(animation);
            }
        }
    }
}
