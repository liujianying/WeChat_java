package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.AppAttachFileListUI.c;
import junit.framework.Assert;

class AppAttachFileListUI$b extends BaseAdapter {
    final /* synthetic */ AppAttachFileListUI tGA;

    private AppAttachFileListUI$b(AppAttachFileListUI appAttachFileListUI) {
        this.tGA = appAttachFileListUI;
    }

    /* synthetic */ AppAttachFileListUI$b(AppAttachFileListUI appAttachFileListUI, byte b) {
        this(appAttachFileListUI);
    }

    public final int getCount() {
        return AppAttachFileListUI.a(this.tGA).size();
    }

    public final Object getItem(int i) {
        return AppAttachFileListUI.a(this.tGA).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppAttachFileListUI$d appAttachFileListUI$d;
        String str;
        if (view == null) {
            view = this.tGA.getLayoutInflater().inflate(R.i.app_attach_file_list_item, viewGroup, false);
            Assert.assertNotNull(view);
            appAttachFileListUI$d = new AppAttachFileListUI$d(this.tGA, (byte) 0);
            appAttachFileListUI$d.tGC = (MMImageView) view.findViewById(R.h.file_list_item_icon);
            appAttachFileListUI$d.tGD = (TextView) view.findViewById(R.h.file_list_item_title);
            appAttachFileListUI$d.tGE = (TextView) view.findViewById(R.h.file_list_item_from);
            appAttachFileListUI$d.tGF = (TextView) view.findViewById(R.h.file_list_item_time);
            view.setTag(appAttachFileListUI$d);
        } else {
            appAttachFileListUI$d = (AppAttachFileListUI$d) view.getTag();
        }
        Assert.assertNotNull(appAttachFileListUI$d);
        c cVar = (c) AppAttachFileListUI.a(this.tGA).get(i);
        appAttachFileListUI$d.tGD.setText(cVar.tGB.title);
        if (cVar.bXQ.field_isSend == 1) {
            str = "自己";
        } else {
            str = r.gT(cVar.tGB.bSS);
        }
        appAttachFileListUI$d.tGE.setText(String.format("大小：%s，来自：%s", new Object[]{bi.bF((long) cVar.tGB.dwo), str}));
        appAttachFileListUI$d.tGF.setText(h.c(this.tGA, cVar.bXQ.field_createTime, true));
        appAttachFileListUI$d.tGC.setImageResource(o.SQ(cVar.tGB.dwp));
        return view;
    }
}
