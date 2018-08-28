package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.tencent.mm.ac.m.a.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoHeaderPreference extends Preference implements c, a, b {
    private MMActivity bGc;
    private ImageView eBM;
    private TextView eBO;
    private TextView fAK;
    ab guS;
    private boolean iAc = false;
    String lUr;
    d lUs;

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
    }

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
    }

    public final void onBindView(View view) {
        this.eBM = (ImageView) view.findViewById(R.h.bizinfo_avatar);
        this.eBO = (TextView) view.findViewById(R.h.bizinfo_title);
        this.fAK = (TextView) view.findViewById(R.h.bizinfo_desc);
        this.iAc = true;
        initView();
        super.onBindView(view);
    }

    final void initView() {
        boolean z = true;
        if (!this.iAc || this.guS == null) {
            x.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
            return;
        }
        Bitmap d;
        this.eBO.setText(j.a(this.bGc, bi.oV(this.guS.BK()), this.eBO.getTextSize()));
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
            if (d == null && !bi.oW(this.lUr)) {
                d = m.d(this.guS.field_username, this.lUr, R.g.nosdcard_headimg);
            }
        }
        if (d == null || d.isRecycled()) {
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            aVar.dXR = R.g.brand_default_head;
            aVar.dXx = false;
            aVar.dXW = true;
            o.Pj().a(this.lUr, this.eBM, aVar.Pt());
        } else {
            this.eBM.setImageBitmap(d);
        }
        this.eBM.setOnClickListener(new 1(this));
        if (bi.oV(this.guS.signature).trim().length() <= 0) {
            this.fAK.setVisibility(8);
            return;
        }
        this.fAK.setText(j.a(this.bGc, this.guS.signature));
        this.fAK.setVisibility(0);
        d = am.a.dBt != null ? BackwardSupportUtil.b.e(am.a.dBt.gX(this.guS.field_verifyFlag), 2.0f) : null;
        String str = "MicroMsg.NewBizInfoHeaderPreference";
        String str2 = "verify bmp is null ? %B";
        Object[] objArr = new Object[1];
        if (d != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.fAK.setCompoundDrawables(d != null ? new BitmapDrawable(this.bGc.getResources(), d) : null, null, null, null);
    }

    public final void onDetach() {
        au.HU();
        com.tencent.mm.model.c.FR().b(this);
        q.Kp().e(this);
        z.Ni().b(this);
    }

    public final void jX(String str) {
        x.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", new Object[]{str});
        if (bi.oW(str)) {
            x.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
        } else if (this.guS != null && str.equals(this.guS.field_username)) {
            initView();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        if (bi.oV(str).length() > 0 && this.guS != null && this.guS.field_username.equals(str)) {
            au.HU();
            this.guS = com.tencent.mm.model.c.FR().Yg(str);
        }
    }

    public final void kX(String str) {
        if (this.guS != null && str != null && str.equals(this.guS.field_username)) {
            initView();
        }
    }
}
