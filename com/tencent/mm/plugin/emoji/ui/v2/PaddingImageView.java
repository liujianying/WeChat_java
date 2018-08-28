package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;

public class PaddingImageView extends FrameLayout {
    ImageView isa;
    ImageView isb;
    private int isc;

    public ImageView getImageView() {
        return this.isa;
    }

    public ImageView getImageViewFG() {
        return this.isb;
    }

    public PaddingImageView(Context context) {
        super(context);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.isc = a.ad(getContext(), R.f.NormalPadding);
        this.isa = new ImageView(context);
        this.isa.setPadding(this.isc, this.isc, this.isc, this.isc);
        this.isb = new ImageView(context);
    }
}
