package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public TextView hEx;
    public View ido;
    public String idw;
    public ImageView idx;
    public ImageView idy;
    public Context mContext;

    public b(Context context, int i) {
        this.mContext = context;
        this.ido = y.gq(this.mContext).inflate(i, null);
        aDx();
    }

    public b(Context context, View view) {
        this.mContext = context;
        this.ido = view;
        aDx();
    }

    private void aDx() {
        if (this.ido == null) {
            x.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            return;
        }
        this.idx = (ImageView) this.ido.findViewById(R.h.item_icon);
        this.hEx = (TextView) this.ido.findViewById(R.h.item_title);
        this.idy = (ImageView) this.ido.findViewById(R.h.item_fg);
    }
}
