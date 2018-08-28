package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ai;

public class PickBottleUI extends FrameLayout implements OnClickListener, OnTouchListener {
    private float density;
    float fto;
    float ftp;
    ag handler = new ag();
    private boolean hasInit = false;
    BottleBeachUI hlO;
    SprayLayout hmj;
    PickedBottleImageView hmk;
    ImageView hml;
    private b hmm;
    Runnable hmn = new 1(this);
    Runnable hmo = new Runnable() {
        public final void run() {
            if (PickBottleUI.this.hmk != null && PickBottleUI.this.hmk.isShown()) {
                PickBottleUI.this.hlO.nm(0);
            }
        }
    };

    public PickBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlO = (BottleBeachUI) context;
    }

    public PickBottleUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlO = (BottleBeachUI) context;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public final void initView() {
        if (!this.hasInit) {
            this.hmk = (PickedBottleImageView) findViewById(R.h.bottle_picked_result_img);
            this.hmj = (SprayLayout) this.hlO.findViewById(R.h.bottle_spray_fl);
            this.hml = (ImageView) this.hlO.findViewById(R.h.bottle_close_frame_btn);
            this.hmk.setOnClickListener(this);
            if (!bi.ciW()) {
                setBackgroundResource(R.g.bottle_pick_bg_spotlight_night);
            }
            setOnClickListener(this);
            setOnTouchListener(this);
            this.hasInit = true;
        }
    }

    public void setVisibility(int i) {
        this.hmj.setVisibility(i);
        this.hmk.setVisibility(8);
        super.setVisibility(i);
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public void onClick(View view) {
        if (R.h.bottle_picked_result_img == view.getId()) {
            if (this.hmk.getBottleTalker() != null) {
                au.HU();
                c.FW().Ys(this.hmk.getBottleTalker());
                au.HU();
                ai Yq = c.FW().Yq("floatbottle");
                if (!(Yq == null || bi.oW(Yq.field_username))) {
                    Yq.eV(k.GB());
                    au.HU();
                    c.FW().a(Yq, Yq.field_username);
                }
            }
            this.hlO.onClick(view);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fto = motionEvent.getX();
            this.ftp = motionEvent.getY();
        } else if (action == 1) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            action = getHeight();
            int width = getWidth();
            action = (action * 550) / 800;
            int i = (width - ((width * 120) / 480)) / 2;
            width -= i;
            if (y > ((float) action)) {
                z = true;
            } else if (x < ((float) i) - ((((float) i) * y) / ((float) action))) {
                z = true;
            } else {
                z = x > ((((float) i) * y) / ((float) action)) + ((float) width);
            }
            if (z) {
                if (!this.hmk.isShown()) {
                    if (this.hmm != null) {
                        b bVar = this.hmm;
                        au.DF().b(155, bVar);
                        au.DF().b(156, bVar);
                        au.DF().c(bVar.hkc);
                        this.hmm = null;
                    }
                    this.handler.removeCallbacks(this.hmn);
                    this.handler.removeCallbacks(this.hmo);
                    this.hlO.nm(0);
                } else if (this.hmk.getBottleTalker() == null) {
                    this.hlO.nm(0);
                }
            } else if (F(x, y) && F(this.fto, this.ftp)) {
                if (this.hmk.getBottleTalker() != null) {
                    au.HU();
                    c.FW().Ys(this.hmk.getBottleTalker());
                    au.HU();
                    ai Yq = c.FW().Yq("floatbottle");
                    if (!(Yq == null || bi.oW(Yq.field_username))) {
                        Yq.eV(k.GB());
                        au.HU();
                        c.FW().a(Yq, Yq.field_username);
                    }
                }
                this.hlO.onClick(this.hmk);
            }
        }
        return true;
    }

    private boolean F(float f, float f2) {
        int height = getHeight();
        int width = getWidth();
        int i = (width * 180) / 480;
        int i2 = (height * 75) / 800;
        float f3 = f - ((float) ((width * aq.CTRL_BYTE) / 480));
        float f4 = f2 - ((float) ((height * 495) / 800));
        if (((f4 * f4) / ((float) (i2 * i2))) + ((f3 * f3) / ((float) (i * i))) <= 1.0f) {
            return true;
        }
        return false;
    }
}
