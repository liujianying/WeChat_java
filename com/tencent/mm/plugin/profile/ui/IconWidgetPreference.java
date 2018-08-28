package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class IconWidgetPreference extends Preference {
    private ImageView lWX;
    private int lWY;
    private Bitmap lWZ;

    public IconWidgetPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconWidgetPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lWX = null;
        this.lWY = -1;
        this.lWZ = null;
        setLayoutResource(R.i.mm_preference);
        setWidgetLayoutResource(0);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.mm_preference_widget_icon, viewGroup2);
        return onCreateView;
    }

    public final void C(Bitmap bitmap) {
        this.lWZ = bitmap;
        if (this.lWX != null) {
            this.lWX.setImageBitmap(bitmap);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lWX = (ImageView) view.findViewById(R.h.pref_widget_right_icon);
        if (this.lWX != null) {
            this.lWX.setVisibility(8);
            if (this.lWY != -1) {
                this.lWX.setImageResource(this.lWY);
                this.lWX.setVisibility(0);
            } else if (this.lWZ != null) {
                this.lWX.setImageBitmap(this.lWZ);
                this.lWX.setVisibility(0);
            }
        }
    }
}
