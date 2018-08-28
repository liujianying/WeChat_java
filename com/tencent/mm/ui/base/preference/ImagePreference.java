package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class ImagePreference extends Preference {
    private ImageView lWM;
    private e tCt;

    public ImagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lWM = null;
        this.tCt = new e();
        setLayoutResource(h.mm_preference_image);
        setWidgetLayoutResource(h.mm_preference_submenu);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ImagePreference);
        int resourceId = obtainStyledAttributes.getResourceId(m.ImagePreference_img, 0);
        if (resourceId > 0) {
            e eVar = this.tCt;
            eVar.jxE = resourceId;
            eVar.bitmap = null;
            this.tCt.e(this.lWM);
        }
        obtainStyledAttributes.recycle();
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content_ll);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.mm_preference_image, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lWM = (ImageView) view.findViewById(g.image_iv);
        this.tCt.e(this.lWM);
    }
}
