package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.m;
import com.tencent.mm.ac.m$a$a;
import com.tencent.mm.ac.z;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class BizInfoHeaderPreference extends Preference implements c, m$a$a, b {
    private MMActivity bGc;
    ab guS;
    private boolean iAc = false;
    private TextView jYA;
    private TextView kkF;
    private ImageView lUo;
    private ImageView lUp;
    private View lUq;
    String lUr;
    d lUs;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public final void onBindView(View view) {
        x.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.jYA = (TextView) view.findViewById(R.h.contact_info_nickname_tv);
        this.kkF = (TextView) view.findViewById(R.h.contact_info_username_tv);
        this.lUp = (ImageView) view.findViewById(R.h.biz_favor);
        this.lUo = (ImageView) view.findViewById(R.h.contact_info_avatar_iv);
        this.lUq = view.findViewById(R.h.contact_info_avatar_iv_mask);
        this.iAc = true;
        initView();
        super.onBindView(view);
    }

    private boolean bnm() {
        return this.iAc && this.guS != null;
    }

    final void initView() {
        boolean z = true;
        if (bnm()) {
            Bitmap d;
            this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.BK()) + " ", this.jYA.getTextSize()));
            if (this.lUs == null) {
                this.lUs = f.kH(this.guS.field_username);
            }
            if (this.lUs != null) {
                this.lUr = this.lUs.field_brandIconURL;
                d = m.d(this.lUs.field_username, this.lUs.field_brandIconURL, R.g.nosdcard_headimg);
            } else {
                d = com.tencent.mm.aa.c.a(this.guS.field_username, true, -1);
                if (!(d == null || d.isRecycled())) {
                    d = com.tencent.mm.sdk.platformtools.c.a(d, false, (float) (d.getWidth() / 2));
                }
                if (d == null && !TextUtils.isEmpty(this.lUr)) {
                    d = m.d(this.guS.field_username, this.lUr, R.g.nosdcard_headimg);
                }
            }
            if (d == null) {
                d = BitmapFactory.decodeResource(this.bGc.getResources(), R.g.brand_default_head);
            }
            if (!(d == null || d.isRecycled())) {
                this.lUo.setImageBitmap(d);
            }
            this.lUo.setTag(this.guS.field_username);
            this.lUq.setOnClickListener(new 1(this));
            if (a.gd(this.guS.field_type)) {
                if (this.lUs != null) {
                    z = this.lUs.Me();
                }
                if (z) {
                    if (!bi.oW(this.guS.wM())) {
                        this.kkF.setVisibility(0);
                        this.kkF.setText(this.mContext.getString(R.l.app_field_username) + this.guS.wM());
                    } else if (ab.XT(this.guS.field_username) || s.hd(this.guS.field_username)) {
                        this.kkF.setVisibility(8);
                    } else {
                        this.kkF.setText(this.mContext.getString(R.l.app_field_username) + bi.oV(this.guS.BM()));
                        this.kkF.setVisibility(0);
                    }
                    if (this.guS.BC()) {
                        this.lUp.setVisibility(8);
                        return;
                    } else {
                        this.lUp.setVisibility(0);
                        return;
                    }
                }
            }
            this.kkF.setVisibility(8);
            if (this.guS.BC()) {
                this.lUp.setVisibility(8);
                return;
            } else {
                this.lUp.setVisibility(0);
                return;
            }
        }
        x.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.iAc + "contact = " + this.guS);
    }

    public final void onDetach() {
        au.HU();
        com.tencent.mm.model.c.FR().b(this);
        q.Kp().e(this);
        z.Ni().b(this);
    }

    public final void jX(String str) {
        if (!bnm()) {
            x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.iAc + "contact = " + this.guS);
        } else if (bi.oV(str).length() <= 0) {
            x.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + str);
        } else if (str.equals(this.guS.field_username)) {
            initView();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        } else if (bnm()) {
            String str = (String) obj;
            if (bi.oV(str).length() > 0 && this.guS != null && this.guS.field_username.equals(str)) {
                au.HU();
                this.guS = com.tencent.mm.model.c.FR().Yg(str);
            }
        } else {
            x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.iAc + "contact = " + this.guS);
        }
    }

    public final void kX(String str) {
        if (this.guS != null && str != null && str.equals(this.guS.field_username)) {
            initView();
        }
    }
}
