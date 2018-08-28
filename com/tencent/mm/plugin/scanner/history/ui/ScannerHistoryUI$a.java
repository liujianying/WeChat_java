package com.tencent.mm.plugin.scanner.history.ui;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class ScannerHistoryUI$a extends r<a> {
    final /* synthetic */ ScannerHistoryUI mFo;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        a aVar = (a) obj;
        if (aVar == null) {
            aVar = new a();
        }
        aVar.d(cursor);
        return aVar;
    }

    public ScannerHistoryUI$a(ScannerHistoryUI scannerHistoryUI) {
        this.mFo = scannerHistoryUI;
        super(scannerHistoryUI, new a());
        lB(true);
    }

    public final void WT() {
        setCursor(c.brZ().axc());
        notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        ScannerHistoryUI$b scannerHistoryUI$b;
        a aVar = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.mFo.mController.tml, R.i.scan_history_item_layout, null);
            ScannerHistoryUI$b scannerHistoryUI$b2 = new ScannerHistoryUI$b(this.mFo, (byte) 0);
            scannerHistoryUI$b2.gwj = (ImageView) view.findViewById(R.h.item_icon);
            scannerHistoryUI$b2.hFW = (TextView) view.findViewById(R.h.item_title);
            scannerHistoryUI$b2.hFX = (TextView) view.findViewById(R.h.item_time);
            scannerHistoryUI$b2.hFY = (TextView) view.findViewById(R.h.item_desc);
            view.setTag(scannerHistoryUI$b2);
            scannerHistoryUI$b = scannerHistoryUI$b2;
        } else {
            scannerHistoryUI$b = (ScannerHistoryUI$b) view.getTag();
        }
        n.a bY = i.bY(aVar.field_xmlContent, aVar.field_funcType);
        scannerHistoryUI$b.hFW.setText(bY.field_title);
        scannerHistoryUI$b.hFX.setText(h.c(this.mFo, aVar.field_ScanTime, true));
        scannerHistoryUI$b.hFY.setText(bY.field_subtitle);
        int dimensionPixelSize = this.mFo.getResources().getDimensionPixelSize(R.f.scan_history_icon_size);
        scannerHistoryUI$b.gwj.setImageResource(R.g.pic_thumb_bg);
        x.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + bY.field_thumburl);
        if (TextUtils.isEmpty(bY.field_thumburl)) {
            scannerHistoryUI$b.gwj.setImageResource(R.g.pic_thumb_bg);
        } else {
            String format;
            com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
            aVar2.dXB = e.bnE;
            o.Pk();
            aVar2.dXU = null;
            c brY = c.brY();
            String str = bY.field_thumburl;
            if (au.HX()) {
                format = String.format("%s/scanbook_%s", new Object[]{brY.dqp + "image/scan/img", g.u(str.getBytes())});
            } else {
                format = "";
            }
            aVar2.dXA = format;
            aVar2.dXy = true;
            aVar2.dXW = false;
            aVar2.dXw = true;
            aVar2.dXF = dimensionPixelSize;
            aVar2.dXE = dimensionPixelSize;
            aVar2.dXN = R.g.pic_thumb_bg;
            o.Pj().a(bY.field_thumburl, scannerHistoryUI$b.gwj, aVar2.Pt());
        }
        return view;
    }
}
