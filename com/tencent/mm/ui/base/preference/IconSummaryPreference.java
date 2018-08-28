package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView kYT;
    private String mQi;
    private int mQj;
    public int mQk;
    private int tBT;
    private int tBU;
    private ViewGroup tBW;
    private int tCe;
    private View tCg;
    LayoutParams tCi;
    public int tCq;
    public TextView tCr;
    private int tCs;
    private int tgw;
    private Bitmap tiW;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQi = "";
        this.mQj = -1;
        this.mQk = 8;
        this.tiW = null;
        this.tgw = -1;
        this.tCe = 8;
        this.tBT = 0;
        this.tBU = 8;
        this.tCq = 8;
        this.kYT = null;
        this.tBW = null;
        this.tCg = null;
        this.tCr = null;
        this.tCs = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(h.mm_preference);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.mm_preference_content_icon_summary, viewGroup2);
        return onCreateView;
    }

    public final void dk(String str, int i) {
        this.mQi = str;
        this.mQj = i;
    }

    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (this.tCr != null && getSummary() != null && getSummary().length() > 0) {
            this.tCr.setText(getSummary());
        }
    }

    public final void setSummary(int i) {
        super.setSummary(i);
        if (this.tCr != null && getSummary() != null && getSummary().length() > 0) {
            this.tCr.setText(getSummary());
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.image_iv);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.hh != null) {
                imageView.setImageDrawable(this.hh);
                imageView.setVisibility(0);
            } else if (this.Hu != 0) {
                imageView.setImageResource(this.Hu);
                imageView.setVisibility(0);
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
        if (this.kYT == null) {
            this.kYT = (ImageView) view.findViewById(g.image_right_iv);
        }
        if (this.tBW == null) {
            this.tBW = (ViewGroup) view.findViewById(g.right_rl);
        }
        if (this.tCg == null) {
            this.tCg = view.findViewById(g.right_prospect);
        }
        this.tCg.setVisibility(this.tBU);
        if (this.tiW != null) {
            this.kYT.setImageBitmap(this.tiW);
        } else if (this.tgw != -1) {
            this.kYT.setImageResource(this.tgw);
        }
        this.kYT.setVisibility(this.tCe);
        this.tBW.setVisibility(this.tBT);
        if (this.tCi != null) {
            this.kYT.setLayoutParams(this.tCi);
        }
        this.tCr = (TextView) view.findViewById(g.right_summary);
        if (!(this.tCr == null || getSummary() == null || getSummary().length() <= 0)) {
            this.tCr.setText(getSummary());
            this.tCr.setVisibility(this.tCq);
        }
        if (this.tCr != null && this.tCs != -1) {
            this.tCr.setCompoundDrawablesWithIntrinsicBounds(this.tCs, 0, 0, 0);
            this.tCr.setCompoundDrawablePadding(b.b(this.mContext, 2.0f));
            this.tCr.setVisibility(this.tCq);
        }
    }
}
