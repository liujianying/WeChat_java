package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView extends RelativeLayout {
    private View icZ = null;
    private Context mContext;
    View uih;
    private TextView uii;
    private boolean uij = true;
    private boolean uik;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
        cyc();
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
        cyc();
    }

    public BizContactEntranceView(Context context) {
        super(context);
        this.mContext = context;
        init();
        cyc();
    }

    private void init() {
        this.uik = false;
        View.inflate(getContext(), R.i.biz_contact_entrance_view, this);
        this.icZ = findViewById(R.h.container);
        this.uih = this.icZ.findViewById(R.h.biz_contact_entrance_normal);
        LayoutParams layoutParams = this.uih.getLayoutParams();
        layoutParams.height = (int) (((float) a.ae(getContext(), R.f.ContactListHeight)) * a.fh(getContext()));
        this.uih.setLayoutParams(layoutParams);
        this.icZ.setOnClickListener(new 1(this));
        this.uih.setOnTouchListener(new 2(this));
        MaskLayout maskLayout = (MaskLayout) this.uih.findViewById(R.h.biz_contact_entrance_avatar_iv);
        ImageView imageView = (ImageView) maskLayout.getContentView();
        q.Kp();
        imageView.setImageBitmap(f.jV("service_officialaccounts"));
        this.uii = (TextView) maskLayout.findViewById(R.h.tipcnt_tv);
    }

    final void cyc() {
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        if (c.FR().clo() > 0) {
            this.uij = true;
        } else {
            this.uij = false;
        }
        this.uih.setVisibility(this.uij ? 0 : 8);
        if (this.uij) {
            au.Em().H(new 3(this));
        }
        x.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[]{Integer.valueOf(r4), Boolean.valueOf(this.uij), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public void setVisible(boolean z) {
        int i = 0;
        x.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.uij)});
        View view = this.icZ;
        if (!(z && this.uij)) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
