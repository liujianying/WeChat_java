package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private ImageView gwj;
    private int height;
    public OnClickListener mVS;
    private Bitmap qOJ;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.mm_preference_content_headimg, viewGroup2);
        this.gwj = (ImageView) onCreateView.findViewById(R.h.image_headimg);
        return onCreateView;
    }

    public final void O(Bitmap bitmap) {
        this.qOJ = null;
        if (this.gwj != null) {
            this.gwj.setImageBitmap(bitmap);
        } else {
            this.qOJ = bitmap;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.gwj == null) {
            this.gwj = (ImageView) view.findViewById(R.h.image_headimg);
        }
        if (this.mVS != null) {
            this.gwj.setOnClickListener(this.mVS);
        }
        if (this.qOJ != null) {
            this.gwj.setImageBitmap(this.qOJ);
            this.qOJ = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.mm_preference_ll_id);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
    }
}
