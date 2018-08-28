package com.tencent.weui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.d;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;

public class IconPreference extends Preference {
    private Context context;
    private String desc;
    private Drawable drawable;
    private TextView fAK;
    private int height;
    protected ImageView kYT;
    private String mQi;
    private int mQj;
    private int mQk;
    private ImageView nDe;
    private int tBS;
    private int tBT;
    private int tBU;
    private ImageView tBV;
    private ViewGroup tBW;
    private TextView tBX;
    private int tBZ;
    private String tCa;
    private int tCb;
    private int tCc;
    private int tCd;
    private int tCe;
    private int tCf;
    private View tCg;
    private View tCh;
    LayoutParams tCi;
    private TextView tCj;
    private TextView tCk;
    private ImageView tCl;
    private boolean tCm;
    private boolean tCn;
    private int tCo;
    private boolean tCp;
    protected int tgw;
    private Bitmap tiW;
    private int vzy;

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tgw = -1;
        this.kYT = null;
        this.mQi = "";
        this.mQj = -1;
        this.mQk = 8;
        this.tBS = 8;
        this.tBZ = 8;
        this.desc = "";
        this.tCa = "";
        this.tCb = -1;
        this.tCc = 8;
        this.tCd = -1;
        this.tiW = null;
        this.tCe = 8;
        this.tBT = 8;
        this.tBU = 8;
        this.tCf = 8;
        this.vzy = 8;
        this.tBV = null;
        this.tBW = null;
        this.tCg = null;
        this.tCh = null;
        this.nDe = null;
        this.height = -1;
        this.tCm = false;
        this.tCn = false;
        this.tCo = -1;
        this.tCp = false;
        this.context = context;
        setLayoutResource(g.mm_preference);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), g.preference_content_icon, viewGroup2);
        return onCreateView;
    }

    protected void onBindView(View view) {
        boolean z;
        super.onBindView(view);
        this.tCl = (ImageView) view.findViewById(f.image_iv);
        if (this.tCl != null) {
            if (this.drawable != null) {
                this.tCl.setImageDrawable(this.drawable);
                this.tCl.setVisibility(0);
            } else if (getIcon() != null) {
                ImageView imageView = this.tCl;
                Drawable icon = getIcon();
                this.drawable = icon;
                imageView.setImageDrawable(icon);
                this.tCl.setVisibility(0);
            } else {
                this.tCl.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f.mm_preference_ll_id);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(d.SmallListHeight));
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.tCk = (TextView) view.findViewById(f.text_tv_one);
        if (this.tCk != null) {
            if (this.tCn) {
                this.tCk.setCompoundDrawablesWithIntrinsicBounds(e.unread_dot_shape, 0, 0, 0);
                this.tCk.setCompoundDrawablePadding((int) this.context.getResources().getDimension(d.SmallPadding));
            } else {
                this.tCk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.tCk.setVisibility(this.mQk);
            this.tCk.setText(this.mQi);
            if (this.mQj != -1) {
                this.tCk.setBackgroundDrawable(this.context.getResources().getDrawable(this.mQj));
            }
        }
        this.tCj = (TextView) view.findViewById(f.text_tv_two);
        if (this.tCj != null) {
            this.tCj.setVisibility(this.tCc);
            this.tCj.setText(this.tCa);
            if (this.tCb != -1) {
                this.tCj.setBackgroundDrawable(this.context.getResources().getDrawable(this.tCb));
            }
            if (this.tCd != -1) {
                this.tCj.setTextColor(this.tCd);
            }
            if (this.tCm) {
                this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.unread_dot_shape, 0);
                this.tCj.setCompoundDrawablePadding((int) this.context.getResources().getDimension(d.SmallPadding));
            } else {
                this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.tBV = (ImageView) view.findViewById(f.text_prospect);
        this.tBV.setVisibility(this.tBS);
        if (this.tCo != -1) {
            this.tBV.setImageResource(this.tCo);
        }
        this.kYT = (ImageView) view.findViewById(f.image_right_iv);
        this.tBW = (ViewGroup) view.findViewById(f.right_rl);
        this.tCh = view.findViewById(f.right_center_prospect);
        this.tCh.setVisibility(this.tCf);
        this.tCg = view.findViewById(f.right_prospect);
        this.tCg.setVisibility(this.tBU);
        this.nDe = (ImageView) view.findViewById(f.right_arrow);
        this.nDe.setVisibility(this.vzy);
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
        this.tBX = (TextView) view.findViewById(16908310);
        this.fAK = (TextView) view.findViewById(f.desc);
        if (this.fAK != null) {
            this.fAK.setVisibility(this.tBZ);
            this.fAK.setText(this.desc);
            if (this.tCp) {
                this.fAK.setTextColor(this.context.getResources().getColor(c.disable_text_color));
            } else {
                this.fAK.setTextColor(this.context.getResources().getColor(c.hint_text_color));
            }
        }
        if (this.tBX != null) {
            if (this.tCp) {
                this.tBX.setTextColor(this.context.getResources().getColor(c.disable_text_color));
            } else {
                this.tBX.setTextColor(this.context.getResources().getColor(c.normal_text_color));
            }
        }
        if (this.tCp) {
            z = false;
        } else {
            z = true;
        }
        view.setEnabled(z);
    }
}
