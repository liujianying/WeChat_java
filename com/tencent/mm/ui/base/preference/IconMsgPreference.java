package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String mQi;
    private int mQj;
    private int mQk;
    private int tBS;
    private int tBT;
    private int tBU;
    private ImageView tBV;
    private ViewGroup tBW;
    private TextView tBX;
    private String tBY;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQi = "";
        this.mQj = -1;
        this.mQk = 8;
        this.tBS = 8;
        this.tBT = 0;
        this.tBU = 8;
        this.tBV = null;
        this.tBW = null;
        this.height = -1;
        this.tBY = "";
        this.context = context;
        setLayoutResource(h.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.mm_preference_icon_msg, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(e.SmallListHeight));
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.image_iv);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.Hu != 0) {
                imageView.setImageResource(this.Hu);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.mm_preference_ll_id);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(g.text_tv_one);
        if (textView != null) {
            textView.setVisibility(this.mQk);
            textView.setText(this.mQi);
            if (this.mQj != -1) {
                textView.setBackgroundDrawable(a.f(this.context, this.mQj));
            }
        }
        this.tBV = (ImageView) view.findViewById(g.text_prospect);
        this.tBV.setVisibility(this.tBS);
        this.tBW = (ViewGroup) view.findViewById(g.right_rl);
        this.tBW.setVisibility(this.tBT);
        this.tBX = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(g.text_tv_right);
        if (bi.oW(this.tBY)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.tBY);
    }
}
