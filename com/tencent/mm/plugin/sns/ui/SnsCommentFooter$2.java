package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class SnsCommentFooter$2 implements TextWatcher {
    final /* synthetic */ SnsCommentFooter nVN;
    final /* synthetic */ List nVO;

    SnsCommentFooter$2(SnsCommentFooter snsCommentFooter, List list) {
        this.nVN = snsCommentFooter;
        this.nVO = list;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (SnsCommentFooter.a(this.nVN).getText() != null) {
            l lVar;
            boolean z;
            x.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.b(this.nVN));
            for (l lVar2 : this.nVO) {
                if (SnsCommentFooter.b(this.nVN).equals(lVar2.aAL)) {
                    x.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    lVar2.text = SnsCommentFooter.a(this.nVN).getText().toString();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                x.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                lVar2 = new l();
                lVar2.aAL = SnsCommentFooter.b(this.nVN);
                lVar2.text = SnsCommentFooter.a(this.nVN).getText().toString();
                if (lVar2.text != null && lVar2.text.length() > 0) {
                    this.nVO.add(lVar2);
                }
            }
            if (this.nVO.size() > 5) {
                x.d("MicroMsg.SnsCommentFooter", "comments remove");
                this.nVO.remove(0);
            }
            SnsCommentFooter.a(this.nVN).requestFocus();
            z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && this.nVN.kXL) {
                SnsCommentFooter.a(this.nVN, z);
                this.nVN.kXL = false;
            }
            if (!z) {
                SnsCommentFooter.a(this.nVN, z);
                this.nVN.kXL = true;
            }
        }
    }
}
