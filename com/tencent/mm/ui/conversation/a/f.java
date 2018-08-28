package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aa.c;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class f extends b {
    String usd = null;
    String use = null;

    public f(Context context, String str, String str2) {
        super(context);
        this.usd = str;
        this.use = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(R.h.chatting_banner_recom_icon);
            this.view.setOnClickListener(new 1(this));
            imageView.setImageBitmap(c.a(this.usd, true, -1));
        }
    }

    public final int getLayoutId() {
        return R.i.chatting_recom_friends_banner;
    }

    public final void destroy() {
    }
}
