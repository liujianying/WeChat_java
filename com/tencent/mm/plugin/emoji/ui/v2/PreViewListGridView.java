package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ag;

public class PreViewListGridView extends ListView {
    private int OT;
    private WindowManager inU;
    private boolean isd = true;
    private LayoutParams isj;
    private int isk;
    private int isl;
    private int ism;
    private boolean isn;
    private volatile int iso = -1;
    private String isp;
    private PopEmojiView isq;
    private d isr;
    private ag mHandler = new ag();

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.isq = new PopEmojiView(getContext());
        this.isk = context.getResources().getDimensionPixelSize(R.f.emoji_preview_image_size);
        this.inU = (WindowManager) context.getSystemService("window");
        this.isj = new LayoutParams(-1, -1, 2, 8, 1);
        this.isj.width = this.isk;
        this.isj.height = this.isk;
        this.isj.gravity = 17;
        this.OT = getResources().getConfiguration().orientation;
        if (this.OT == 2) {
            this.isl = this.inU.getDefaultDisplay().getHeight();
            this.ism = this.inU.getDefaultDisplay().getWidth();
            return;
        }
        this.isl = this.inU.getDefaultDisplay().getWidth();
        this.ism = this.inU.getDefaultDisplay().getHeight();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.isr = (d) listAdapter;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.isn) {
                    aGu();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void aGu() {
        if (this.isn) {
            this.inU.removeView(this.isq);
            this.isn = false;
        }
        this.isp = "";
    }

    public void setEnablePreView(boolean z) {
        this.isd = z;
    }
}
