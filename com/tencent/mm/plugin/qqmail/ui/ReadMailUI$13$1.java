package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13;
import com.tencent.mm.ui.base.h.c;

class ReadMailUI$13$1 implements c {
    final /* synthetic */ 13 miJ;

    ReadMailUI$13$1(13 13) {
        this.miJ = 13;
    }

    public final void ju(int i) {
        int i2 = 0;
        if (i == 3) {
            ReadMailUI.J(this.miJ.miD);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.miJ.miD, ComposeUI.class);
        intent.putExtra("mailid", ReadMailUI.a(this.miJ.miD));
        intent.putExtra("subject", ReadMailUI.K(this.miJ.miD));
        String[] a = ReadMailUI.L(this.miJ.miD).a(false, ReadMailUI.l(this.miJ.miD));
        String[] a2 = ReadMailUI.c(this.miJ.miD).a(true, ReadMailUI.l(this.miJ.miD));
        String[] a3 = ReadMailUI.d(this.miJ.miD).a(true, ReadMailUI.l(this.miJ.miD));
        switch (i) {
            case 0:
                intent.putExtra("composeType", 2);
                intent.putExtra("toList", a);
                break;
            case 1:
                int i3;
                intent.putExtra("composeType", 2);
                String[] strArr = new String[(a.length + a2.length)];
                int length = a.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    i3 = i5 + 1;
                    strArr[i5] = a[i4];
                    i4++;
                    i5 = i3;
                }
                i3 = a2.length;
                while (i2 < i3) {
                    i4 = i5 + 1;
                    strArr[i5] = a2[i2];
                    i2++;
                    i5 = i4;
                }
                intent.putExtra("toList", strArr);
                intent.putExtra("ccList", a3);
                break;
            case 2:
                intent.putExtra("composeType", 3);
                break;
            default:
                return;
        }
        this.miJ.miD.startActivity(intent);
    }
}
