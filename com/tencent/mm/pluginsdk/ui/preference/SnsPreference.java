package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private MMActivity bGc;
    private String cZH;
    private int iRP;
    private List<ate> list;
    private av nkT;
    private QDisFadeImageView qPt;
    private QDisFadeImageView qPu;
    private QDisFadeImageView qPv;
    private ImageView qPw;
    private ImageView qPx;
    private ImageView qPy;
    private a qPz;

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.bGc = (MMActivity) context;
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZH = "";
        this.qPt = null;
        this.qPu = null;
        this.qPv = null;
        this.qPw = null;
        this.qPx = null;
        this.qPy = null;
        this.iRP = 255;
        this.list = new LinkedList();
        this.qPz = new a();
        this.bGc = (MMActivity) context;
        this.cZH = context.getString(R.l.contact_info_sns_title);
        setLayoutResource(R.i.mm_preference);
    }

    private void cfg() {
        ImageView imageView;
        int i = 0;
        if (this.qPt != null) {
            this.qPt.setImageResource(R.e.white);
            this.qPt.setVisibility(4);
        }
        if (this.qPu != null) {
            this.qPu.setImageResource(R.e.white);
            this.qPu.setVisibility(4);
        }
        if (this.qPv != null) {
            this.qPv.setImageResource(R.e.white);
            this.qPv.setVisibility(4);
        }
        if (this.qPt != null && this.list.size() > 0) {
            int i2;
            ImageView imageView2;
            this.qPt.setVisibility(0);
            if (f.zZ()) {
                n.nkx.b((ate) this.list.get(0), this.qPt, this.bGc.hashCode(), this.nkT);
                imageView = this.qPw;
                if (((ate) this.list.get(0)).hcE == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            } else {
                this.qPt.setImageResource(R.g.nosdcard_app);
                imageView2 = this.qPw;
            }
            i2 = 8;
            imageView = imageView2;
            imageView.setVisibility(i2);
        }
        if (this.qPu != null && this.list.size() >= 2) {
            this.qPu.setVisibility(0);
            if (f.zZ()) {
                n.nkx.b((ate) this.list.get(1), this.qPu, this.bGc.hashCode(), this.nkT);
                this.qPx.setVisibility(((ate) this.list.get(1)).hcE == 6 ? 0 : 8);
            } else {
                this.qPu.setImageResource(R.g.nosdcard_app);
            }
        }
        if (this.qPv != null && this.list.size() >= 3) {
            this.qPv.setVisibility(0);
            if (f.zZ()) {
                n.nkx.b((ate) this.list.get(2), this.qPv, this.bGc.hashCode(), this.nkT);
                imageView = this.qPy;
                if (((ate) this.list.get(2)).hcE != 6) {
                    i = 8;
                }
                imageView.setVisibility(i);
                return;
            }
            this.qPv.setImageResource(R.g.nosdcard_app);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_album, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.qPt = (QDisFadeImageView) view.findViewById(R.h.image_iv1);
        this.qPt.setAlpha(this.iRP);
        this.qPt.setImageDrawable(this.qPz);
        this.qPu = (QDisFadeImageView) view.findViewById(R.h.image_iv2);
        this.qPu.setAlpha(this.iRP);
        this.qPu.setImageDrawable(this.qPz);
        this.qPv = (QDisFadeImageView) view.findViewById(R.h.image_iv3);
        this.qPv.setAlpha(this.iRP);
        this.qPv.setImageDrawable(this.qPz);
        TextView textView = (TextView) view.findViewById(R.h.album_title);
        if (!bi.oW(this.cZH)) {
            textView.setText(this.cZH);
            LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = a.ad(this.mContext, R.f.FixedTitleWidth);
            textView.setLayoutParams(layoutParams);
        }
        this.qPw = (ImageView) view.findViewById(R.h.sns_sight_icon1);
        this.qPx = (ImageView) view.findViewById(R.h.sns_sight_icon2);
        this.qPy = (ImageView) view.findViewById(R.h.sns_sight_icon3);
        this.qPw.setVisibility(8);
        this.qPx.setVisibility(8);
        this.qPy.setVisibility(8);
        cfg();
        if (view != null && this.list != null) {
            view.setContentDescription(this.mContext.getString(R.l.profile_photo_desc, new Object[]{Integer.valueOf(this.list.size())}));
        }
    }

    public final void TS(String str) {
        if (str != null) {
            this.list.clear();
            au.HU();
            ab Yg = c.FR().Yg(str);
            if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                this.nkT = av.tbq;
            } else if (str.equals(q.GF())) {
                this.nkT = av.tbq;
            } else {
                this.nkT = av.tbr;
            }
            mr mrVar = new mr();
            mrVar.bXC.username = str;
            com.tencent.mm.sdk.b.a.sFg.m(mrVar);
            if (mrVar.bXD.bXE != null) {
                this.list.add(mrVar.bXD.bXE);
            }
            if (mrVar.bXD.bXF != null) {
                this.list.add(mrVar.bXD.bXF);
            }
            if (mrVar.bXD.bXG != null) {
                this.list.add(mrVar.bXD.bXG);
            }
            cfg();
        }
    }
}
