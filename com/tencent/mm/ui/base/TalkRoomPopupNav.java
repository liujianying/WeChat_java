package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class TalkRoomPopupNav extends LinearLayout {
    public View iZk;
    private a tAY;
    public LinearLayout tAZ;
    private LinearLayout tBa;
    private ImageView tBb;
    public ImageView tBc;
    public ScaleAnimation tBd;
    public Animation tBe;
    public int tBf = 0;
    public int tBg = 0;
    private ScaleAnimation tBh;
    private Animation tBi;
    public AlphaAnimation tBj;
    public AlphaAnimation tBk;
    public LinearLayout toK;

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        if (talkRoomPopupNav.tBh == null) {
            talkRoomPopupNav.tBh = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.tBg) * 1.0f) / ((float) talkRoomPopupNav.tBf), 1.0f);
            talkRoomPopupNav.tBh.setDuration(300);
            talkRoomPopupNav.tBh.setAnimationListener(new 6(talkRoomPopupNav));
        }
        if (talkRoomPopupNav.tBi == null) {
            talkRoomPopupNav.tBi = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.fast_faded_out);
            talkRoomPopupNav.tBi.setFillAfter(true);
            talkRoomPopupNav.tBi.setAnimationListener(new 7(talkRoomPopupNav));
        }
        LayoutParams layoutParams = talkRoomPopupNav.iZk.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.tBf;
        talkRoomPopupNav.iZk.setLayoutParams(layoutParams);
        talkRoomPopupNav.iZk.startAnimation(talkRoomPopupNav.tBh);
        talkRoomPopupNav.tAZ.startAnimation(talkRoomPopupNav.tBi);
        talkRoomPopupNav.toK.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.fast_faded_in));
        talkRoomPopupNav.toK.setVisibility(0);
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void setOnClickListener(a aVar) {
        this.tAY = aVar;
    }

    public void setNavContent(String str) {
        ((TextView) findViewById(R.h.tv_nav_content)).setText(str);
    }

    public void setDialogContent(String str) {
        ((TextView) findViewById(R.h.tv_dialog_content)).setText(str);
    }

    public void setBgViewResource(int i) {
        if (this.iZk != null) {
            this.iZk.setBackgroundResource(i);
        }
    }

    public void setIconRes(int i) {
        if (this.tBb != null) {
            this.tBb.setImageResource(i);
        }
    }

    public void setIconAnim(int i) {
        if (i < 0) {
            if (this.tBc != null) {
                this.tBc.setVisibility(8);
            }
        } else if (this.tBc != null) {
            this.tBc.setImageResource(i);
            this.tBc.setVisibility(0);
        }
    }

    private void initView() {
        inflate(getContext(), R.i.talk_room_popup_nav, this);
        this.toK = (LinearLayout) findViewById(R.h.nav_layout);
        this.tAZ = (LinearLayout) findViewById(R.h.dialog_layout);
        this.tBa = (LinearLayout) findViewById(R.h.dialog_btn_layout);
        this.iZk = findViewById(R.h.nav_bg);
        this.tBb = (ImageView) findViewById(R.h.talk_scene_icon);
        this.tBc = (ImageView) findViewById(R.h.talk_scene_icon_anim);
        this.tBc.setVisibility(8);
        this.toK.setOnClickListener(new 1(this));
        ((Button) findViewById(R.h.btn_cancel)).setOnClickListener(new 2(this));
        ((Button) findViewById(R.h.btn_confirm)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TalkRoomPopupNav.b(TalkRoomPopupNav.this);
                if (TalkRoomPopupNav.this.tAY != null) {
                    TalkRoomPopupNav.this.tAY.csf();
                }
            }
        });
        this.tBf = this.iZk.getLayoutParams().height;
        this.tBg = this.tAZ.getLayoutParams().height;
    }

    public final void stop() {
        if (this.tBj != null && this.tBk != null) {
            a.c(this.tBc, this.tBj);
            a.c(this.tBc, this.tBk);
            this.tBc.clearAnimation();
            this.tBj = null;
            this.tBk = null;
        }
    }
}
