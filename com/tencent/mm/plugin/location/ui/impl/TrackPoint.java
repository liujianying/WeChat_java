package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a$e;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;

public class TrackPoint extends LinearLayout {
    private boolean YN = true;
    private double fTP = -1.0d;
    private double fTQ = -1.0d;
    private double fTR = -1.0d;
    private double fTS = -1.0d;
    public FrameLayout kKl;
    public ImageView kKm;
    private double kKn = 0.0d;
    private Context mContext;
    public ViewManager mViewManager;
    private String username;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(0);
    }

    public TrackPoint(Context context, ViewManager viewManager) {
        super(context);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(0);
    }

    public TrackPoint(Context context, ViewManager viewManager, int i) {
        super(context);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(i);
    }

    private void init(int i) {
        this.kKl = (FrameLayout) View.inflate(this.mContext, f.track_point_avatar, null);
        this.kKm = new ImageView(this.mContext);
        if (i > 0) {
            this.kKm.setImageResource(i);
        } else {
            this.kKm.setImageResource(d.location_track_point_icon_navigate);
        }
        this.kKm.setBackgroundResource(d.mm_trans);
        this.kKm.setFocusable(true);
        this.kKm.setFocusableInTouchMode(true);
    }

    public void setOnLocationOnClickListener(OnClickListener onClickListener) {
    }

    public void setOnAvatarOnClickListener(OnClickListener onClickListener) {
    }

    public void setAvatar(String str) {
        if (str.equals(this.username)) {
            x.i("MicroMsg.TrackPoint", "skip this set avatar");
            return;
        }
        this.username = str;
        b.n((ImageView) this.kKl.findViewById(a$e.anim_avatar), str);
        if (this.mViewManager != null) {
            this.mViewManager.updateMarkerView(this.kKl);
        }
    }

    public double getHeading() {
        return this.kKn;
    }

    public void setHeading(double d) {
        this.kKn = d;
    }

    public final void ban() {
        this.YN = false;
        this.kKl.setVisibility(4);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.kKl);
        }
    }

    public final void bao() {
        this.YN = true;
        this.kKl.setVisibility(0);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.kKl);
        }
    }

    public final void v(double d) {
        this.kKn = d;
        if (this.mViewManager != null) {
            this.mViewManager.updateRotation(this.kKm, (float) d);
        }
    }

    public double getLatOffest() {
        return this.fTP - this.fTR;
    }

    public double getLongOffset() {
        return this.fTQ - this.fTS;
    }

    public final void n(double d, double d2) {
        if (this.mViewManager != null) {
            this.mViewManager.updateViewLayout(this.kKl, d, d2, false);
            this.mViewManager.updateLocaitonPinLayout(this.kKm, d, d2, false);
        }
    }

    public final void o(double d, double d2) {
        if (this.mViewManager != null) {
            this.mViewManager.addView(this.kKl, d, d2);
            this.mViewManager.addView(this.kKm, d, d2);
        }
    }

    public final void set2Top() {
        if (this.mViewManager != null) {
            this.mViewManager.setMarker2Top(this.kKl);
            this.mViewManager.setMarker2Top(this.kKm);
        }
    }
}
