package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class SelfVuserPreference extends Preference {
    Drawable drawable;
    private String mQB;
    String text;

    public SelfVuserPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelfVuserPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(g.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, g.mm_preference_self_vuser, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(f.image_iv);
        if (imageView != null) {
            imageView.setImageDrawable(this.drawable);
            x.d("MicroMsg.SelfVuserPreference", "onBindView set icon=" + this.drawable);
            if (!bi.oW(this.mQB)) {
                imageView.setContentDescription(this.mQB);
            }
        }
        TextView textView = (TextView) view.findViewById(f.text_tv);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(this.text);
        }
    }
}
