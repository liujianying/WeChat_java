package com.tencent.mm.plugin.backup.backupmoveui;

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
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    BackupMoveChooseUI gUU;
    HashSet<Integer> gUV;
    boolean gUW = false;

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        this.gUU = backupMoveChooseUI;
        this.gUV = new HashSet();
        this.gUW = false;
    }

    public final int getCount() {
        LinkedList arr = b.arv().arz().arr();
        if (arr != null) {
            return arr.size();
        }
        return 0;
    }

    private static f.b mD(int i) {
        return (f.b) b.arv().arz().arr().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.gUU.getLayoutInflater().inflate(R.i.bak_move_choose_item, viewGroup, false);
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
        f.b mD = mD(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, mD.gRI);
        if (s.fq(mD.gRI)) {
            aVar.eCm.setText(j.a(this.gUU, r.getDisplayName(mD.gRI, mD.gRI), aVar.eCm.getTextSize()));
        } else {
            aVar.eCm.setText(j.a(this.gUU, r.gT(mD.gRI), aVar.eCm.getTextSize()));
        }
        if (this.gUV.contains(Integer.valueOf(i))) {
            aVar.eCo.setChecked(true);
        } else {
            aVar.eCo.setChecked(false);
        }
        return view;
    }
}
