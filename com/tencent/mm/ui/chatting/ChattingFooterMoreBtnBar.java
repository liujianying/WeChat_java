package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private LayoutParams jZp;
    private ImageButton jfl;
    private ImageButton tJo;
    private ImageButton tJp;
    private ImageButton tJq;
    private ImageButton tJr;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.g.bottombar_bg);
        this.jZp = new LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0f);
        this.jZp.topMargin = a.fromDPToPix(getContext(), 0);
        this.tJo = new ImageButton(getContext());
        this.tJo.setImageResource(R.g.chat_more_tran_btn);
        this.tJo.setScaleType(ScaleType.CENTER);
        this.tJo.setBackgroundResource(0);
        this.tJo.setContentDescription(context.getString(R.l.chatting_more_share));
        this.tJr = new ImageButton(getContext());
        this.tJr.setImageResource(R.g.chat_more_fav_btn);
        this.tJr.setScaleType(ScaleType.CENTER);
        this.tJr.setBackgroundResource(0);
        this.tJr.setContentDescription(context.getString(R.l.chatting_more_favorite));
        this.jfl = new ImageButton(getContext());
        this.jfl.setImageResource(R.g.chat_more_del_btn);
        this.jfl.setScaleType(ScaleType.CENTER);
        this.jfl.setBackgroundResource(0);
        this.jfl.setContentDescription(context.getString(R.l.chatting_more_delete));
        this.tJq = new ImageButton(getContext());
        this.tJq.setImageResource(R.g.chat_more_more_btn);
        this.tJq.setScaleType(ScaleType.CENTER);
        this.tJq.setBackgroundResource(0);
        this.tJq.setContentDescription(context.getString(R.l.chatting_more));
        this.tJp = new ImageButton(getContext());
        this.tJp.setImageResource(R.g.chat_more_email_btn);
        this.tJp.setScaleType(ScaleType.CENTER);
        this.tJp.setBackgroundResource(0);
        this.tJp.setContentDescription(context.getString(R.l.chatting_more_email));
        ctt();
    }

    public final void ctt() {
        removeAllViews();
        addView(this.tJo, this.jZp);
        addView(this.tJr, this.jZp);
        addView(this.jfl, this.jZp);
        if (j.ctc().size() > 0) {
            addView(this.tJq, this.jZp);
        } else {
            addView(this.tJp, this.jZp);
        }
    }

    public final void EO(int i) {
        boolean z = i > 0;
        this.tJo.setClickable(z);
        this.tJo.setEnabled(z);
        if (j.ctc().size() > 0) {
            this.tJq.setClickable(z);
            this.tJq.setEnabled(z);
        } else {
            this.tJp.setClickable(z);
            this.tJp.setEnabled(z);
        }
        this.jfl.setClickable(z);
        this.jfl.setEnabled(z);
        this.tJr.setClickable(z);
        this.tJr.setEnabled(z);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.tJo.setOnClickListener(onClickListener);
                return;
            case 1:
                this.tJp.setOnClickListener(onClickListener);
                return;
            case 2:
                this.tJq.setOnClickListener(onClickListener);
                return;
            case 3:
                this.jfl.setOnClickListener(onClickListener);
                return;
            case 4:
                this.tJr.setOnClickListener(onClickListener);
                return;
            default:
                x.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }
}
