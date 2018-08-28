package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.b.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b {
    private Context context;
    public String fyq;
    AuthorizeItemListView fyr;
    private b fys;
    private LinearLayout fyt;
    public String mAppName = "";

    public b(Context context) {
        this.context = context;
    }

    public final boolean a(final LinkedList<bio> linkedList, final a aVar) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            return false;
        }
        final i iVar = new i(this.context);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(c.authorize_dialog_view, null);
        TextView textView = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.wechat_auth);
        if (!bi.oW(null)) {
            textView.setText(null);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.app_icon_iv);
        android.support.v4.b.a.i a = k.a(ad.getResources(), a.decodeResource(ad.getResources(), d.default_avatar));
        a.bH();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.b.b.Ka().a(imageView, this.fyq, a, f.dGr);
        }
        textView = (TextView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.app_name_tv);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(e.login_auth_request_tips, new Object[]{this.mAppName}));
        this.fyr = (AuthorizeItemListView) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.auth_content_list);
        this.fys = new b(this, linkedList);
        this.fyr.setAdapter(this.fys);
        if (linkedList.size() > 5) {
            this.fyr.Ma = linkedList.size();
            this.fyt = (LinearLayout) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.auth_scope_list_layout);
            LayoutParams layoutParams = (LayoutParams) this.fyt.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.appbrand.wxawidget.b.a.login_desc_list_height);
            this.fyt.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.login_accept)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < linkedList.size()) {
                        if (((bio) linkedList.get(i2)).sjd == 2 || ((bio) linkedList.get(i2)).sjd == 3) {
                            arrayList.add(((bio) linkedList.get(i2)).rjR);
                        }
                        i = i2 + 1;
                    } else {
                        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_scope", arrayList);
                        aVar.f(1, bundle);
                        iVar.dismiss();
                        return;
                    }
                }
            }
        });
        ((Button) linearLayout.findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.login_reject)).setOnClickListener(new 2(this, linkedList, aVar, iVar));
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnDismissListener(new 3(this));
        iVar.setOnCancelListener(new 4(this, aVar));
        iVar.setContentView(linearLayout);
        try {
            iVar.show();
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
