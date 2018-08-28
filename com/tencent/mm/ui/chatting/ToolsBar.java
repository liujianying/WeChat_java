package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ToolsBar extends LinearLayout {
    private LayoutParams jZp = new LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0f);
    private ImageButton tJo = new ImageButton(getContext());
    private ImageButton tJr;
    private ImageButton tNr;

    public ToolsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.g.bottombar_bg);
        this.tJo.setImageResource(R.g.chat_more_tran_btn);
        this.tJo.setScaleType(ScaleType.CENTER);
        this.tJo.setBackgroundResource(0);
        this.tJo.setContentDescription(context.getString(R.l.chatting_more_share));
        this.tJr = new ImageButton(getContext());
        this.tJr.setImageResource(R.g.chat_more_fav_btn);
        this.tJr.setScaleType(ScaleType.CENTER);
        this.tJr.setBackgroundResource(0);
        this.tJr.setContentDescription(context.getString(R.l.chatting_more_favorite));
        this.tNr = new ImageButton(getContext());
        this.tNr.setImageResource(R.g.chat_more_remind_btn);
        this.tNr.setScaleType(ScaleType.CENTER);
        this.tNr.setBackgroundResource(0);
        this.tNr.setContentDescription(context.getString(R.l.chatting_more_favorite));
        removeAllViews();
        addView(this.tJo, this.jZp);
        addView(this.tJr, this.jZp);
        addView(this.tNr, this.jZp);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.tJo.setOnClickListener(onClickListener);
                return;
            case 1:
                this.tJr.setOnClickListener(onClickListener);
                return;
            case 2:
                this.tNr.setOnClickListener(onClickListener);
                return;
            default:
                x.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }
}
