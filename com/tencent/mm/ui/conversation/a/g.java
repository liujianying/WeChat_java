package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends b {
    boolean tGg = false;
    String usd = null;
    String use = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        this.usd = str;
        this.use = str2;
        this.tGg = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.h.chatting_security_banner_text);
            CharSequence X = au.HU().Gu().X(this.usd, "wording");
            CharSequence X2 = au.HU().Gu().X(this.use, "wording");
            if (!bi.oW(X)) {
                textView.setText(X);
            } else if (!bi.oW(X2)) {
                textView.setText(X2);
            }
            X = au.HU().Gu().X(this.usd, "linkname");
            String X3 = au.HU().Gu().X(this.usd, "linksrc");
            textView = (TextView) this.view.findViewById(R.h.chatting_security_banner_expose_text);
            if (!bi.oW(X)) {
                textView.setText(X);
            }
            textView.setOnClickListener(new 1(this, X3));
            ((ImageView) this.view.findViewById(R.h.chatting_security_banner_delete)).setOnClickListener(new 2(this));
        }
    }

    public final int getLayoutId() {
        return R.i.chatting_security_banner;
    }

    public final void destroy() {
    }
}
