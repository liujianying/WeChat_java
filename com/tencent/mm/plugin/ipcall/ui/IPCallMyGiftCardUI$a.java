package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ccf;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;
import junit.framework.Assert;

class IPCallMyGiftCardUI$a extends BaseAdapter {
    List<ccf> jWl = null;
    private IPCallMyGiftCardUI kwH = null;
    ajw kwI = null;

    public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        Assert.assertTrue(iPCallMyGiftCardUI != null);
        this.kwH = iPCallMyGiftCardUI;
    }

    public final int getCount() {
        return this.jWl == null ? 0 : this.jWl.size();
    }

    public final Object getItem(int i) {
        if (this.jWl != null) {
            return this.jWl.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.kwH.getSystemService("layout_inflater")).inflate(R.i.ipcall_my_gift_card_item, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.kwJ = (TextView) view.findViewById(R.h.coupon_money_tv);
            aVar.kwK = (TextView) view.findViewById(R.h.data_wording_tv);
            aVar.kwL = (TextView) view.findViewById(R.h.expired_wording_tv);
            aVar.kwM = (CdnImageView) view.findViewById(R.h.header_icon);
            aVar.kwN = (ImageView) view.findViewById(R.h.default_header_icon);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ccf ccf = (ccf) getItem(i);
        if (ccf != null) {
            if (bi.oW(ccf.syj)) {
                aVar.kwJ.setVisibility(0);
                aVar.kwK.setVisibility(0);
                aVar.kwL.setVisibility(8);
                aVar.kwJ.setText(ccf.sdK);
                aVar.kwK.setText(ccf.syi);
            } else {
                aVar.kwJ.setVisibility(8);
                aVar.kwK.setVisibility(8);
                aVar.kwL.setVisibility(0);
                aVar.kwL.setText(ccf.syj);
            }
            b.a(aVar.kwN, "", 0.5f, false);
            if (bi.oW(ccf.jPM)) {
                aVar.kwN.setVisibility(0);
                aVar.kwM.setVisibility(4);
            } else {
                aVar.kwM.setVisibility(0);
                aVar.kwM.setUrl(ccf.jPM);
                aVar.kwN.setVisibility(4);
            }
        }
        return view;
    }
}
