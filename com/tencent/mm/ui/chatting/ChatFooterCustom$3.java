package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;

class ChatFooterCustom$3 implements OnClickListener {
    final /* synthetic */ ChatFooterCustom tHY;

    ChatFooterCustom$3(ChatFooterCustom chatFooterCustom) {
        this.tHY = chatFooterCustom;
    }

    public final void onClick(View view) {
        ChatFooterCustom.d(this.tHY).ctb();
        ImageView imageView = (ImageView) view;
        int i;
        View childAt;
        int i2;
        if (imageView.getTag() == null) {
            imageView.setTag(new Object());
            imageView.setImageResource(R.g.mmfooter_listtotext_arrow2);
            for (i = 0; i < ChatFooterCustom.e(this.tHY); i++) {
                childAt = ChatFooterCustom.f(this.tHY).getChildAt(i);
                if (i >= 3) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                childAt.setVisibility(i2);
            }
            return;
        }
        imageView.setTag(null);
        imageView.setImageResource(R.g.mmfooter_listtotext_arrow1);
        for (i = 0; i < ChatFooterCustom.e(this.tHY); i++) {
            childAt = ChatFooterCustom.f(this.tHY).getChildAt(i);
            if (i < 3) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            childAt.setVisibility(i2);
        }
    }
}
