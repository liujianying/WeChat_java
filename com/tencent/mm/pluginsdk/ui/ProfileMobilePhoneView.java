package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.k;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView gsY;
    private Context mContext;
    public String qGi;
    public String qGj;
    public String[] qGk;
    public LinearLayout qGr;
    public boolean qGs;

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, String str) {
        k kVar = new k(profileMobilePhoneView.mContext);
        kVar.hAv = new a(profileMobilePhoneView.mContext, bi.F(!profileMobilePhoneView.qGs ? new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.chatting_phone_use)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.chatting_phone_use), profileMobilePhoneView.mContext.getResources().getString(R.l.chatting_phone_use_by_ipcall)}));
        kVar.qRL = new 2(profileMobilePhoneView, kVar, str);
        kVar.setCancelable(true);
        kVar.show();
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qGs = false;
        this.mContext = context;
    }

    public int getLayout() {
        return R.i.profile_mobile_phone_layout;
    }

    public final void init() {
        this.gsY = (TextView) findViewById(R.h.phone_list_title);
        this.qGr = (LinearLayout) findViewById(R.h.phone_list);
        for (int i = 0; i < 5; i++) {
            this.qGr.getChildAt(i).setOnClickListener(new 1(this));
        }
    }

    @Deprecated
    public final boolean N(ab abVar) {
        return false;
    }

    public final boolean bnH() {
        if (this.gsY != null) {
            LayoutParams layoutParams = this.gsY.getLayoutParams();
            layoutParams.width = a.ad(getContext(), R.f.FixedTitleWidth);
            this.gsY.setLayoutParams(layoutParams);
        }
        if (this.qGr != null) {
            int i;
            int i2;
            View childAt;
            int i3;
            if (bi.oW(this.qGi) || !bi.Xd(this.qGi).booleanValue()) {
                if (!(this.qGi == null || bi.Xd(this.qGi).booleanValue())) {
                    x.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[]{this.qGi});
                }
                i = 0;
                i2 = 0;
            } else {
                childAt = this.qGr.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.qGi);
                }
                i = 1;
                i2 = 1;
            }
            if (!bi.oW(this.qGj)) {
                this.qGk = this.qGj.split(",");
                setVisibility(0);
                while (true) {
                    i3 = i2;
                    if (i3 >= this.qGk.length + i) {
                        break;
                    }
                    childAt = this.qGr.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.qGk[i3 - i]);
                    }
                    i2 = i3 + 1;
                }
            } else {
                i3 = i2;
            }
            while (i3 < 5) {
                this.qGr.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && bi.oW(this.qGj)) {
                setVisibility(8);
            }
        }
        return false;
    }
}
