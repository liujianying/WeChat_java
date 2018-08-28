package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b.c.b.e;
import com.tencent.mm.plugin.radar.a.a;

final class RadarViewController$a {
    private int mmK;
    final boolean mmL;
    final a mmM = new a(this);
    final /* synthetic */ RadarViewController mmN;

    public RadarViewController$a(RadarViewController radarViewController) {
        this.mmN = radarViewController;
        g gVar = g.mmr;
        Context context = radarViewController.getContext();
        e.h(context, "context");
        this.mmL = g.ea(context);
    }

    public final Animation getInAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mmN.getContext(), a.radar_user_turn_out);
        e.h(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
        return loadAnimation;
    }

    public final int bpN() {
        this.mmK++;
        return this.mmK;
    }

    public final void g(int i, View view) {
        e.i(view, "view");
        Message obtainMessage = this.mmM.obtainMessage();
        obtainMessage.what = ct(view);
        obtainMessage.obj = view;
        view.setVisibility(4);
        this.mmM.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
    }

    final int ct(View view) {
        Object tag = view.getTag(RadarViewController.a(this.mmN));
        if (!(tag instanceof Integer)) {
            tag = null;
        }
        Integer num = (Integer) tag;
        return num != null ? num.intValue() : -1;
    }
}
