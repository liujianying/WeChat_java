package com.tencent.mm.plugin.radar.ui;

import android.widget.ImageView;
import android.widget.TextView;
import b.c.b.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.c;

public final class RadarViewController$c$a {
    TextView mmW;
    ImageView mmX;
    RadarStateView mmY;
    RadarStateChooseView mmZ;
    ImageView mna;
    final /* synthetic */ c mnb;

    public RadarViewController$c$a(c cVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
        e.i(textView, "tvMemberName");
        e.i(imageView, "ivMemberAvatar");
        e.i(radarStateView, "vMemberState");
        e.i(radarStateChooseView, "vMemberChooseState");
        e.i(imageView2, "ivMemberAvatarMask");
        this.mnb = cVar;
        this.mmW = textView;
        this.mmX = imageView;
        this.mmY = radarStateView;
        this.mmZ = radarStateChooseView;
        this.mna = imageView2;
    }
}
