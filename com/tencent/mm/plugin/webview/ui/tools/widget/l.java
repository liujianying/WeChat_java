package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.support.v4.b.a.k;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;

public final class l {
    private Context context;
    private String fyq;
    AuthorizeItemListView fyr;
    private LinearLayout fyt;
    private String mAppName = "";
    private b qlm;

    public l(Context context) {
        this.context = context;
    }

    public final boolean a(LinkedList<bio> linkedList, String str, String str2, String str3, a aVar) {
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.mAppName = str;
        this.fyq = str2;
        return a(str3, linkedList, aVar);
    }

    public final boolean a(LinkedList<bio> linkedList, String str, String str2, a aVar) {
        return a(linkedList, str, str2, null, aVar);
    }

    private boolean a(String str, LinkedList<bio> linkedList, a aVar) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            return false;
        }
        i iVar = new i(this.context, R.m.mmcustomdialog);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.i.authorize_dialog_view, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.wechat_auth);
        if (!bi.oW(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.app_icon_iv);
        android.support.v4.b.a.i a = k.a(ad.getResources(), a.decodeResource(ad.getResources(), R.k.default_avatar));
        a.bH();
        if (imageView != null) {
            b.Ka().a(imageView, this.fyq, a, f.dGr);
        }
        textView = (TextView) linearLayout.findViewById(R.h.app_name_tv);
        if (this.mAppName == null) {
            this.mAppName = "";
        }
        textView.setText(this.context.getString(R.l.login_auth_request_tips, new Object[]{this.mAppName}));
        this.fyr = (AuthorizeItemListView) linearLayout.findViewById(R.h.auth_content_list);
        this.qlm = new b(this, linkedList);
        this.fyr.setAdapter(this.qlm);
        if (linkedList.size() > 5) {
            this.fyr.Ma = linkedList.size();
            this.fyt = (LinearLayout) linearLayout.findViewById(R.h.auth_scope_list_layout);
            LayoutParams layoutParams = (LayoutParams) this.fyt.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(R.f.login_desc_list_height);
            this.fyt.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(R.h.login_accept)).setOnClickListener(new 1(this, linkedList, aVar, iVar));
        ((Button) linearLayout.findViewById(R.h.login_reject)).setOnClickListener(new 2(this, linkedList, aVar, iVar));
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
