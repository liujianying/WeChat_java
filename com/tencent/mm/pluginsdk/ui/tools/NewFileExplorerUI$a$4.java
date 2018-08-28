package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.k.b;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.io.File;

class NewFileExplorerUI$a$4 implements OnClickListener {
    final /* synthetic */ a qTo;

    NewFileExplorerUI$a$4(a aVar) {
        this.qTo = aVar;
    }

    public final void onClick(View view) {
        File file = this.qTo.qSh[((Integer) view.getTag()).intValue()];
        CheckBox checkBox = (CheckBox) view.findViewById(R.h.item_selector);
        if (a.a(this.qTo).contains(file)) {
            a.a(this.qTo).remove(file);
            checkBox.setChecked(false);
        } else if (a.a(this.qTo).size() >= 9) {
            s.makeText(this.qTo.qTk.mController.tml, this.qTo.qTk.getString(R.l.file_selector_too_more, new Object[]{Integer.valueOf(9)}), 0).show();
            checkBox.setChecked(false);
            return;
        } else {
            if (file.length() >= ((long) bi.getInt(g.AT().getValue("InputLimitFileSize"), 104857600))) {
                s.makeText(this.qTo.qTk.mController.tml, this.qTo.qTk.getString(R.l.file_selector_too_big, new Object[]{bi.bF(r2)}), 0).show();
                checkBox.setChecked(false);
                return;
            }
            if (a.au(file.getName())) {
                com.tencent.mm.pluginsdk.ui.c.a TQ = com.tencent.mm.pluginsdk.ui.c.a.TQ(file.getPath());
                TQ.fi = b.AC();
                if (TQ.cfa() == 1) {
                    h.i(this.qTo.qTk.mController.tml, R.l.video_selector_too_big, R.l.app_tip);
                    checkBox.setChecked(false);
                    return;
                }
            }
            checkBox.setChecked(true);
            a.a(this.qTo).add(file);
        }
        NewFileExplorerUI.h(this.qTo.qTk);
    }
}
