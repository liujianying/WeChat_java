package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

class FTSSOSHomeWebViewUI$a extends BaseAdapter {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;
    private List<c> qeu;

    private FTSSOSHomeWebViewUI$a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
        this.qeu = new ArrayList();
    }

    /* synthetic */ FTSSOSHomeWebViewUI$a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, byte b) {
        this(fTSSOSHomeWebViewUI);
    }

    public final void clear() {
        ah.A(new 4(this));
    }

    public final int getCount() {
        return this.qeu.size() > 6 ? 6 : this.qeu.size();
    }

    /* renamed from: AW */
    public final c getItem(int i) {
        return (c) this.qeu.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this, (byte) 0);
            view = LayoutInflater.from(this.qeq.mController.tml).inflate(R.i.sos_suggest_item, null);
            aVar2.gmn = (ImageView) view.findViewById(R.h.icon_iv);
            aVar2.hPq = (TextView) view.findViewById(R.h.content_tv);
            aVar2.qey = (ImageView) view.findViewById(R.h.tail_iv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        c AW = getItem(i);
        AW.position = i;
        if (AW.icon != 0) {
            aVar.gmn.setVisibility(0);
            aVar.gmn.setImageResource(AW.icon);
        } else {
            aVar.gmn.setVisibility(4);
        }
        if (AW.qeF != 0) {
            aVar.qey.setVisibility(0);
            aVar.qey.setImageResource(AW.qeF);
            aVar.qey.setTag(AW);
            aVar.qey.setOnClickListener(FTSSOSHomeWebViewUI.x(this.qeq));
        } else {
            aVar.qey.setVisibility(4);
        }
        aVar.hPq.setText(AW.content);
        return view;
    }
}
