package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean gXb = false;
    HashSet<Integer> gUV = new HashSet();
    BackupPcChooseUI gXa;

    public a(BackupPcChooseUI backupPcChooseUI) {
        this.gXa = backupPcChooseUI;
        gXb = false;
    }

    public final int getCount() {
        LinkedList arr = b.arV().arZ().arr();
        if (arr != null) {
            return arr.size();
        }
        return 0;
    }

    private static String jl(int i) {
        LinkedList arr = b.arV().arZ().arr();
        return arr.get(i) == null ? null : ((f.b) arr.get(i)).gRI;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.gXa.getLayoutInflater().inflate(R.i.backup_pc_choose_item, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar2.eCm = (TextView) view.findViewById(R.h.title_tv);
            aVar2.eCo = (CheckBox) view.findViewById(R.h.select_cb);
            aVar2.gUY = (RelativeLayout) view.findViewById(R.h.select_cb_click_layout);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gUY.setOnClickListener(new 1(this, i));
        String jl = jl(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, jl);
        if (s.fq(jl)) {
            aVar.eCm.setText(j.a(this.gXa, r.getDisplayName(jl, jl), aVar.eCm.getTextSize()));
        } else {
            aVar.eCm.setText(j.a(this.gXa, r.gT(jl), aVar.eCm.getTextSize()));
        }
        if (this.gUV.contains(Integer.valueOf(i))) {
            aVar.eCo.setChecked(true);
        } else {
            aVar.eCo.setChecked(false);
        }
        return view;
    }
}
