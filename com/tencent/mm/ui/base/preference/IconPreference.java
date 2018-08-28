package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconPreference extends Preference {
    private Context context;
    private String desc;
    public Drawable drawable;
    private TextView fAK;
    private int height;
    public ImageView kYT;
    private String mQi;
    private int mQj;
    private int mQk;
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
    public boolean tCn;
    private int tCo;
    public boolean tCp;
    public int tgw;
    private Bitmap tiW;

    public IconPreference(Context context) {
        this(context, null);
    }

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.tgw = -1;
        this.tCe = 8;
        this.tBT = 0;
        this.tBU = 8;
        this.tCf = 8;
        this.kYT = null;
        this.tBV = null;
        this.tBW = null;
        this.tCg = null;
        this.tCh = null;
        this.height = -1;
        this.tCm = false;
        this.tCn = false;
        this.tCo = -1;
        this.tCp = false;
        this.context = context;
        setLayoutResource(h.mm_preference);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.mm_preference_content_icon, viewGroup2);
        return onCreateView;
    }

    public final void dk(String str, int i) {
        this.mQi = str;
        this.mQj = i;
    }

    public final void dl(String str, int i) {
        ao(str, i, this.tCd);
    }

    public final void setDesc(String str) {
        this.desc = str;
        if (this.fAK != null) {
            this.fAK.setText(str);
        }
    }

    public final void ao(String str, int i, int i2) {
        this.tCa = str;
        this.tCb = i;
        this.tCd = i2;
        if (this.tCj != null) {
            this.tCj.setText(str);
            if (i != -1) {
                this.tCj.setBackgroundDrawable(a.f(this.context, i));
            }
            if (i2 != -1) {
                this.tCj.setTextColor(i2);
            }
        }
    }

    public final void Er(int i) {
        this.mQk = i;
        if (this.tCk != null) {
            this.tCk.setVisibility(i);
        }
    }

    public final void Es(int i) {
        this.tCc = i;
        if (this.tCj != null) {
            this.tCj.setVisibility(i);
        }
    }

    public final void csj() {
        this.tBZ = 0;
        if (this.fAK != null) {
            this.fAK.setVisibility(0);
        }
    }

    public final void lN(boolean z) {
        this.tCm = z;
        if (this.tCj == null) {
            return;
        }
        if (z) {
            this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.unread_dot_shape, 0);
            this.tCj.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.SmallPadding));
            return;
        }
        this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void Et(int i) {
        this.tBS = i;
        if (this.tBV != null) {
            this.tBV.setVisibility(i);
        }
    }

    public final void eV(int i, int i2) {
        this.tBS = i;
        this.tCo = i2;
    }

    public final void V(Bitmap bitmap) {
        this.tiW = bitmap;
        this.tgw = -1;
        if (this.kYT != null) {
            this.kYT.setImageBitmap(bitmap);
        }
    }

    public final void Eu(int i) {
        this.tgw = i;
        this.tiW = null;
        if (this.kYT != null) {
            this.kYT.setImageResource(i);
        }
    }

    public final void Ev(int i) {
        this.tCe = i;
        if (this.kYT != null) {
            this.kYT.setVisibility(this.tCe);
        }
    }

    public final void Ew(int i) {
        this.tBT = i;
        if (this.tBW != null) {
            this.tBW.setVisibility(this.tBT);
        }
    }

    public final void Ex(int i) {
        this.tBU = i;
        if (this.tCg != null) {
            this.tCg.setVisibility(this.tBU);
        }
    }

    public final void eW(int i, int i2) {
        this.tCi = new LayoutParams(i, i2);
        this.tCi.addRule(13);
        if (this.kYT != null) {
            this.kYT.setLayoutParams(this.tCi);
        }
    }

    public void onBindView(View view) {
        boolean z;
        super.onBindView(view);
        this.tCl = (ImageView) view.findViewById(g.image_iv);
        if (this.tCl != null) {
            if (this.drawable != null) {
                this.tCl.setImageDrawable(this.drawable);
                this.tCl.setVisibility(0);
            } else if (this.Hu != 0) {
                ImageView imageView = this.tCl;
                Drawable drawable = this.mContext.getResources().getDrawable(this.Hu);
                this.drawable = drawable;
                imageView.setImageDrawable(drawable);
                this.tCl.setVisibility(0);
            } else {
                this.tCl.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.mm_preference_ll_id);
        linearLayout.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.SmallListHeight)) * a.fh(this.context)));
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.tCk = (TextView) view.findViewById(g.text_tv_one);
        if (this.tCk != null) {
            if (this.tCn) {
                this.tCk.setCompoundDrawablesWithIntrinsicBounds(f.unread_dot_shape, 0, 0, 0);
                this.tCk.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.SmallPadding));
            } else {
                this.tCk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.tCk.setVisibility(this.mQk);
            this.tCk.setText(this.mQi);
            if (this.mQj != -1) {
                this.tCk.setBackgroundDrawable(a.f(this.context, this.mQj));
            }
        }
        this.tCj = (TextView) view.findViewById(g.text_tv_two);
        if (this.tCj != null) {
            this.tCj.setVisibility(this.tCc);
            this.tCj.setText(this.tCa);
            if (this.tCb != -1) {
                this.tCj.setBackgroundDrawable(a.f(this.context, this.tCb));
            }
            if (this.tCd != -1) {
                this.tCj.setTextColor(this.tCd);
            }
            if (this.tCm) {
                this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.unread_dot_shape, 0);
                this.tCj.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.SmallPadding));
            } else {
                this.tCj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.tBV = (ImageView) view.findViewById(g.text_prospect);
        this.tBV.setVisibility(this.tBS);
        if (this.tCo != -1) {
            this.tBV.setImageResource(this.tCo);
        }
        this.kYT = (ImageView) view.findViewById(g.image_right_iv);
        this.kYT.setScaleType(ScaleType.CENTER_CROP);
        this.tBW = (ViewGroup) view.findViewById(g.right_rl);
        this.tCh = view.findViewById(g.right_center_prospect);
        this.tCh.setVisibility(this.tCf);
        this.tCg = view.findViewById(g.right_prospect);
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
        this.tBX = (TextView) view.findViewById(16908310);
        this.fAK = (TextView) view.findViewById(g.desc);
        if (this.fAK != null) {
            this.fAK.setVisibility(this.tBZ);
            this.fAK.setText(this.desc);
            if (this.tCp) {
                this.fAK.setTextColor(this.context.getResources().getColor(d.disable_text_color));
            } else {
                this.fAK.setTextColor(this.context.getResources().getColor(d.hint_text_color));
            }
        }
        if (this.tBX != null) {
            if (this.tCp) {
                this.tBX.setTextColor(this.context.getResources().getColor(d.disable_text_color));
            } else {
                this.tBX.setTextColor(this.context.getResources().getColor(d.normal_text_color));
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
