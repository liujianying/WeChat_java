package com.tencent.mm.ui.transmit;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMImageView;

class ShareImageSelectorUI$b {
    MMImageView jci;
    final /* synthetic */ ShareImageSelectorUI uET;
    TextView uEY;

    public ShareImageSelectorUI$b(ShareImageSelectorUI shareImageSelectorUI, View view) {
        this.uET = shareImageSelectorUI;
        this.jci = (MMImageView) view.findViewById(R.h.item_icon);
        this.uEY = (TextView) view.findViewById(R.h.item_text);
    }
}
