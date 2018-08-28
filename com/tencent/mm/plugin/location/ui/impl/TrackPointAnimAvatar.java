package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView eKk;
    private LinearLayout kKo;
    private Animation kKp;
    private Animation kKq;
    private Context mContext;
    private String username;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, f.track_point_avatar, this);
        this.kKo = (LinearLayout) inflate.findViewById(e.anim_avatar_layout);
        this.eKk = (ImageView) inflate.findViewById(e.anim_avatar);
        this.kKp = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.kKp.setDuration(500);
        this.kKp.setFillAfter(true);
        this.kKq = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.kKq.setDuration(500);
        this.kKq.setFillAfter(true);
        this.kKp.setAnimationListener(new 1(this));
        this.kKq.setAnimationListener(new 2(this));
    }

    public void setUser(String str) {
        if (!bi.oW(str)) {
            this.username = str;
            if (this.eKk != null) {
                b.n(this.eKk, this.username);
            }
        }
    }
}
