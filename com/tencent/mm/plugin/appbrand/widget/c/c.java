package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

public final class c extends b {
    private final String fyq;
    private AuthorizeItemListView fyr;
    private LinearLayout fyt;
    private b gFP;
    private final String mAppName;
    private Context mContext;

    public c(Context context, LinkedList<bio> linkedList, String str, String str2, a aVar) {
        super(context, (byte) 0);
        this.mContext = context;
        this.mAppName = bi.oV(str);
        this.fyq = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            throw new IllegalArgumentException("scopeInfoList is empty or null");
        }
        ViewGroup viewGroup = (ViewGroup) y.gq(this.mContext).inflate(h.app_brand_auth_dialog, null);
        setContentView(viewGroup);
        b.Ka().a((ImageView) viewGroup.findViewById(g.app_icon_iv), this.fyq, a.JZ(), f.dGr);
        ((TextView) viewGroup.findViewById(g.app_name_tv)).setText(this.mContext.getString(j.login_auth_request_tips, new Object[]{this.mAppName}));
        this.fyr = (AuthorizeItemListView) viewGroup.findViewById(g.auth_content_list);
        this.gFP = new b(linkedList);
        this.fyr.setAdapter(this.gFP);
        if (linkedList.size() > 5) {
            this.fyr.Ma = linkedList.size();
            this.fyt = (LinearLayout) viewGroup.findViewById(g.auth_scope_list_layout);
            LayoutParams layoutParams = (LayoutParams) this.fyt.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.login_desc_list_height);
            this.fyt.setLayoutParams(layoutParams);
        }
        ((Button) viewGroup.findViewById(g.login_accept)).setOnClickListener(new 1(this, linkedList, aVar, this));
        ((Button) viewGroup.findViewById(g.login_reject)).setOnClickListener(new 2(this, linkedList, aVar, this));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new 3(this, aVar));
    }
}
