package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class NewBizInfoMessagePreference$a$a extends t implements OnClickListener {
    public ImageView gxd;
    public TextView hND;
    public ImageView lWM;
    public LinearLayout lYQ;
    public b lYR;
    final /* synthetic */ a lYS;

    public NewBizInfoMessagePreference$a$a(a aVar, View view) {
        this.lYS = aVar;
        super(view);
        this.lWM = (ImageView) view.findViewById(R.h.new_bizinfo_message_image);
        this.gxd = (ImageView) view.findViewById(R.h.new_bizinfo_message_icon);
        this.hND = (TextView) view.findViewById(R.h.new_bizinfo_message_text);
        this.lYQ = (LinearLayout) view.findViewById(R.h.new_bizinfo_message_container);
        view.setOnClickListener(this);
    }

    static void e(String str, ImageView imageView) {
        o.Pj().a(str, imageView);
    }

    public final void onClick(View view) {
        x.i("MicroMsg.NewBizInfoMessagePreference", "onClick jump to url:%s", new Object[]{this.lYR.lZf});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lYR.lZf);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        d.b(a.a(this.lYS), "webview", ".ui.tools.WebViewUI", intent);
    }
}
