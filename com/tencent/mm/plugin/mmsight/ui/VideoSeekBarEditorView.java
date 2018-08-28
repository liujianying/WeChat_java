package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.ui.y;

public class VideoSeekBarEditorView extends LinearLayout {
    private Button iRz;
    RecyclerThumbSeekBar lqM;
    private Button lqN;
    private LinearLayout lqO;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lqO = (LinearLayout) y.gq(context).inflate(e.video_seek_bar_editor_view, this, true);
        this.lqM = (RecyclerThumbSeekBar) findViewById(d.video_thumb_seek_bar);
        this.iRz = (Button) findViewById(d.edit_text_cancel);
        this.lqN = (Button) findViewById(d.edit_text_ok);
    }

    public void setFinishButtonClickListener(OnClickListener onClickListener) {
        this.lqN.setOnClickListener(onClickListener);
    }

    public void setCancelButtonClickListener(OnClickListener onClickListener) {
        this.iRz.setOnClickListener(onClickListener);
    }

    public final void bft() {
        this.lqM.release();
        ViewParent parent = this.lqM.getParent();
        if (parent instanceof LinearLayout) {
            LayoutParams layoutParams = (LayoutParams) this.lqM.getLayoutParams();
            ((LinearLayout) parent).removeView(this.lqM);
            this.lqM = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.lqM, 0, layoutParams);
        }
    }
}
