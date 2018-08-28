package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    private View contentView;
    public TextView lWL;
    public boolean tCA;
    private boolean tCB;
    private boolean tCC;
    public boolean tCD;
    private int tCE;
    public int tCF;
    public int tCG;
    public ImageView tCH;
    public Drawable tCI;
    private List<View> tCJ;
    private Drawable tCz;
    public String tmc;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tCz = null;
        this.tCA = true;
        this.tCB = false;
        this.tmc = null;
        this.tCC = false;
        this.tCD = false;
        this.tCE = 17;
        this.tCF = 17;
        this.tCG = 0;
        this.tCH = null;
        this.tCI = null;
        this.tCJ = new LinkedList();
        setLayoutResource(h.mm_preference);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.mm_preference_content_keyvalue, viewGroup2);
        return onCreateView;
    }

    public void onBindView(View view) {
        LinearLayout linearLayout;
        super.onBindView(view);
        this.contentView = view.findViewById(g.content);
        if (this.tDk != null) {
            this.contentView.setOnClickListener(new 1(this));
        }
        this.lWL = (TextView) view.findViewById(16908304);
        this.lWL.setSingleLine(this.tCA);
        if (this.tCB) {
            setWidgetLayoutResource(h.mm_preference_submenu);
        }
        if (this.tCD) {
            linearLayout = (LinearLayout) view.findViewById(g.container);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout = (LinearLayout) view.findViewById(g.summary_container);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.getChildAt(0).setLayoutParams(layoutParams);
            this.lWL.setGravity(this.tCF);
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (!bi.oW(this.tmc)) {
            textView.setText(this.tmc);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = a.ad(this.mContext, e.FixedTitleWidth);
            textView.setLayoutParams(layoutParams2);
        }
        if (this.tCz != null) {
            ((ImageView) view.findViewById(g.icon_preference_imageview)).setImageDrawable(this.tCz);
        }
        this.tCH = (ImageView) view.findViewById(g.image_iv);
        if (this.tCI != null) {
            this.tCH.setVisibility(this.tCG);
            this.tCH.setImageDrawable(this.tCI);
        } else {
            this.tCH.setVisibility(8);
        }
        if (this.tCC) {
            linearLayout = (LinearLayout) view.findViewById(g.container);
            if (linearLayout != null) {
                linearLayout.setGravity(this.tCE);
            }
        }
        if (this.tCJ.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(g.summary_container);
            linearLayout.removeAllViews();
            for (View view2 : this.tCJ) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
    }

    public final void lO(boolean z) {
        this.tCB = z;
        if (this.tCB) {
            setWidgetLayoutResource(h.mm_preference_submenu);
        }
    }

    public final void csk() {
        this.tCJ.clear();
    }

    public final void dp(View view) {
        this.tCJ.add(view);
    }

    public final void csl() {
        this.tCC = true;
        this.tCE = 49;
    }
}
