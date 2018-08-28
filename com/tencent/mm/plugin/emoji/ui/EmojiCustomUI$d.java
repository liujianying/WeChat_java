package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;

class EmojiCustomUI$d {
    View ilW;
    ImageView ilX;
    CheckBox ilY;

    public EmojiCustomUI$d(View view) {
        this.ilW = view.findViewById(R.h.item);
        this.ilX = (ImageView) view.findViewById(R.h.image);
        this.ilY = (CheckBox) view.findViewById(R.h.checked);
    }
}
