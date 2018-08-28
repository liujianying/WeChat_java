package com.tencent.mm.plugin.emoji.ui.v2;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;

class EmojiStoreV2RewardUI$4 implements TextWatcher {
    final /* synthetic */ EmojiStoreV2RewardUI iqC;

    EmojiStoreV2RewardUI$4(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.iqC = emojiStoreV2RewardUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (EmojiStoreV2RewardUI.h(this.iqC) != null) {
            if (editable != null && editable.length() > 0) {
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                    editable.delete(indexOf + 3, indexOf + 4);
                }
                float f = 0.0f;
                try {
                    f = Float.valueOf(editable.toString()).floatValue();
                } catch (NumberFormatException e) {
                }
                if (f > 200.0f || f < 1.0f) {
                    EmojiStoreV2RewardUI.e(this.iqC).getContentEditText().setTextColor(this.iqC.mController.tml.getResources().getColor(R.e.red));
                } else {
                    EmojiStoreV2RewardUI.e(this.iqC).getContentEditText().setTextColor(this.iqC.mController.tml.getResources().getColor(R.e.normal_text_color));
                    EmojiStoreV2RewardUI.h(this.iqC).setEnabled(true);
                    return;
                }
            }
            EmojiStoreV2RewardUI.h(this.iqC).setEnabled(false);
        }
    }
}
