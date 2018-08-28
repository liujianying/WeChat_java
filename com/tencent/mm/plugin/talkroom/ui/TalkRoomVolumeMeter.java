package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class TalkRoomVolumeMeter extends FrameLayout {
    private a oyb;
    private ImageView oyc;
    private ImageView oyd;
    private ImageView oye;
    private FrameLayout oyf;

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        this.oyb = new a(this, getContext());
        this.oyc = new ImageView(getContext());
        this.oyc.setScaleType(ScaleType.FIT_XY);
        this.oyc.setImageResource(R.g.talk_room_volume_net);
        this.oyc.setVisibility(0);
        this.oyd = new ImageView(getContext());
        this.oyd.setScaleType(ScaleType.FIT_CENTER);
        this.oyd.setImageResource(R.g.talk_room_volume_mask);
        this.oyd.setVisibility(8);
        this.oye = new ImageView(getContext());
        this.oye.setScaleType(ScaleType.FIT_CENTER);
        this.oye.setImageResource(R.g.talk_room_volume_err);
        this.oye.setVisibility(8);
        this.oyf = new FrameLayout(getContext());
        this.oyf.addView(this.oyb);
        this.oyf.addView(this.oyd);
        this.oyf.setVisibility(8);
        addView(this.oyf);
        addView(this.oye);
        addView(this.oyc);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bringChildToFront(this.oyc);
    }

    private void setShowErr(boolean z) {
        this.oye.setVisibility(z ? 0 : 8);
    }

    public void setShowFlame(boolean z) {
        this.oyf.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.oyb;
            if (!aVar.started) {
                aVar.started = true;
                aVar.oyp.J(100, 100);
                return;
            }
            return;
        }
        a aVar2 = this.oyb;
        if (aVar2.started) {
            aVar2.started = false;
            if (aVar2.oys >= aVar2.oyg && aVar2.oys <= aVar2.oyh && aVar2.oyk != null && aVar2.oyj != null) {
                Canvas lockCanvas = aVar2.oyi.lockCanvas();
                if (!(lockCanvas == null || aVar2.oym == null)) {
                    lockCanvas.setDrawFilter(aVar2.oyt);
                    aVar2.oym.set(0, 0, aVar2.oyo, aVar2.oyn + 0);
                    lockCanvas.drawBitmap(aVar2.oyu ? aVar2.oyk : aVar2.oyj, null, aVar2.oym, aVar2.fBa);
                    aVar2.oyi.unlockCanvasAndPost(lockCanvas);
                }
            }
            aVar2.oyp.SO();
        }
    }

    private void setShowRed(boolean z) {
        this.oyb.oyu = z;
    }

    public void setMax(int i) {
        this.oyb.max = i;
    }

    public void setValue(int i) {
        a aVar = this.oyb;
        if (i < 0) {
            i = 0;
        } else if (i > aVar.max) {
            i = aVar.max;
        }
        aVar.value = i;
        aVar.oys = aVar.oyh - ((aVar.oyh - aVar.oyg) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
    }

    public void setMinPos(int i) {
        this.oyb.oyg = (float) i;
    }

    public void setMaxPos(int i) {
        this.oyb.oyh = (float) i;
    }
}
