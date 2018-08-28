package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import java.util.List;

class CompressPreviewUI$b extends BaseAdapter {
    final /* synthetic */ CompressPreviewUI mfN;
    a mfR;
    List<a> mfS;

    private CompressPreviewUI$b(CompressPreviewUI compressPreviewUI) {
        this.mfN = compressPreviewUI;
        this.mfS = null;
    }

    /* synthetic */ CompressPreviewUI$b(CompressPreviewUI compressPreviewUI, byte b) {
        this(compressPreviewUI);
    }

    public final String boQ() {
        if (this.mfR == null || this.mfR.mfP == null) {
            return null;
        }
        if (this.mfR.mfP.length() == 0) {
            return "";
        }
        int indexOf = this.mfR.id.indexOf(this.mfR.mfP);
        if (indexOf >= 0) {
            return this.mfR.id.substring(0, indexOf) + this.mfR.mfP;
        }
        return null;
    }

    public final int getCount() {
        return this.mfS != null ? this.mfS.size() : 0;
    }

    /* renamed from: uY */
    public final a getItem(int i) {
        return (this.mfS == null || this.mfS.size() <= i) ? null : (a) this.mfS.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        int TY;
        if (view == null) {
            view = View.inflate(this.mfN.mController.tml, R.i.mail_compress_preview_item, null);
            a aVar = new a(this, (byte) 0);
            aVar.gmn = (ImageView) view.findViewById(R.h.file_icon_iv);
            aVar.eMe = (TextView) view.findViewById(R.h.file_name_tv);
            aVar.mfT = (TextView) view.findViewById(R.h.file_size_tv);
            aVar.mfU = (ImageView) view.findViewById(R.h.file_sub_tv);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        a uY = getItem(i);
        if (i != 0 || boQ() == null) {
            imageView = aVar2.gmn;
            TY = uY.boP() ? R.g.qqmail_attach_folder : FileExplorerUI.TY(uY.name);
        } else {
            imageView = aVar2.gmn;
            TY = R.g.qqmail_attach_back;
        }
        imageView.setImageResource(TY);
        aVar2.mfU.setVisibility(uY.YF ? 0 : 4);
        aVar2.eMe.setText(uY.name);
        aVar2.mfT.setText(uY.mfQ);
        return view;
    }
}
