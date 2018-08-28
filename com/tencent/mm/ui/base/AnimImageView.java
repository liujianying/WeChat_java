package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

public class AnimImageView extends TextView {
    private boolean bgH = false;
    private Context context;
    private AlphaAnimation mtq;
    private AnimationDrawable mtr;
    private boolean tsk = false;
    private AnimationDrawable tsl;
    private int type = 1;

    public void setType(int i) {
        this.type = i;
        if (this.tsk) {
            if (i == 2) {
                setBackgroundResource(R.e.bubble_chat_from_bg_color);
            } else {
                setBackgroundDrawable(a.f(this.context, R.g.chatfrom_bg));
            }
        } else if (i == 2) {
            setBackgroundResource(R.e.bubble_chat_to_bg_color);
        } else {
            setBackgroundDrawable(a.f(this.context, R.g.chatto_bg));
        }
    }

    public final void cre() {
        switch (this.type) {
            case 0:
                if (this.tsk) {
                    setBackgroundDrawable(a.f(this.context, R.g.chatfrom_bg));
                } else {
                    setBackgroundDrawable(a.f(this.context, R.g.chatto_bg));
                }
                setAnimation(this.mtq);
                this.mtq.startNow();
                return;
            case 1:
                break;
            case 2:
                if (!this.tsk) {
                    setBackgroundResource(R.e.bubble_chat_to_bg_color);
                    break;
                } else {
                    setBackgroundResource(R.e.bubble_chat_from_bg_color);
                    break;
                }
            default:
                return;
        }
        if (!this.bgH) {
            this.bgH = true;
            if (this.tsk) {
                setCompoundDrawablesWithIntrinsicBounds(this.mtr, null, null, null);
                this.mtr.stop();
                this.mtr.start();
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.tsl, null);
            this.tsl.stop();
            this.tsl.start();
        }
    }

    public void setFromVoice(boolean z) {
        this.tsk = z;
    }

    public void setFromGroup(boolean z) {
    }

    public final void bqN() {
        if (this.mtq != null && this.mtq.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.bgH = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.mtr.stop();
            this.tsl.stop();
        }
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bqM();
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bqM();
    }

    private void bqM() {
        this.mtq = new AlphaAnimation(0.1f, 1.0f);
        this.mtq.setDuration(1000);
        this.mtq.setRepeatCount(-1);
        this.mtq.setRepeatMode(2);
        this.mtr = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        this.mtr.setOneShot(false);
        this.mtr.setVisible(true, true);
        this.tsl = new AnimationDrawable();
        drawable = getResources().getDrawable(R.k.chatto_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.tsl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatto_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.tsl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatto_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.tsl.addFrame(drawable, 300);
        this.tsl.setOneShot(false);
        this.tsl.setVisible(true, true);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
