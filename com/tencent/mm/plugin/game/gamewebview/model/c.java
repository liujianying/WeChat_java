package com.tencent.mm.plugin.game.gamewebview.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ba.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b {
    private TextView eBO;
    private ImageView gxd;

    public c(Context context) {
        super(context);
        if (this.view != null) {
            this.eBO = (TextView) this.view.findViewById(R.h.game_webview_banner_text_view);
            this.gxd = (ImageView) this.view.findViewById(R.h.game_webview_banner_icon_view);
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a aVar = a.erR;
                    String Ut = a.Ut();
                    if (!bi.oW(Ut)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", Ut);
                        intent.putExtra("is_from_keep_top", true);
                        intent.addFlags(268435456);
                        d.b((Context) c.this.qJS.get(), "game", ".gamewebview.ui.GameWebViewUI", intent);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.game_webview_banner_view;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.game_webview_banner_view).setVisibility(i);
        }
    }

    public final boolean anR() {
        x.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible");
        a aVar = a.erR;
        if (a.Us()) {
            x.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible, VISIBLE");
            aVar = a.erR;
            CharSequence Uu = a.Uu();
            if (this.eBO != null) {
                this.eBO.setText(Uu);
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
