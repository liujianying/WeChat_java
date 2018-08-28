package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView extends LinearLayout {
    private ViewGroup goL;
    public MMEmojiView qNY;
    private ProgressBar qNZ;

    public PopEmojiView(Context context) {
        super(context);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.goL = (ViewGroup) inflate(getContext(), f.preview_emoji, null);
        this.qNY = (MMEmojiView) this.goL.findViewById(e.image);
        this.qNY.setIsMaxSizeLimit(true);
        this.qNY.setMaxSize(context.getResources().getDimensionPixelSize(c.emoji_view_image_size) - (context.getResources().getDimensionPixelSize(c.MiddlePadding) * 3));
        this.qNZ = (ProgressBar) this.goL.findViewById(e.progress);
        addView(this.goL, -1, -1);
    }

    public void setImageResource(int i) {
        if (this.qNY != null) {
            this.qNY.setImageResource(i);
        }
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        if (this.qNY != null) {
            this.qNY.a(emojiInfo, "");
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (this.qNY != null && bitmap != null && !bitmap.isRecycled()) {
            bitmap.setDensity(this.qNY.getEmojiDensity());
            this.qNY.setImageBitmap(bitmap);
        }
    }

    public final void Cq(int i) {
        switch (1.qOa[i - 1]) {
            case 1:
                this.qNY.setVisibility(4);
                this.qNZ.setVisibility(0);
                return;
            case 2:
                this.qNY.setVisibility(0);
                this.qNZ.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
