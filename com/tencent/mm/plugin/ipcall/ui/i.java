package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class i extends AlertDialog implements e {
    private TextView Dm;
    private MMDotView gKU;
    private View hyK;
    private b kyS;
    private IPCallShareViewPager kyT;
    private OnClickListener kyU;
    private LinkedList<Integer> kyV;
    private Context mContext;
    private CharSequence sn;

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.hyK);
    }

    public final void O(int i) {
        if (this.kyS.getCount() <= 1) {
            this.gKU.setVisibility(4);
            return;
        }
        this.gKU.setVisibility(0);
        this.gKU.setDotCount(this.kyS.getCount());
        this.gKU.setSelectedDot(i);
    }

    public final void N(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.sn = charSequence;
        } else {
            this.sn = null;
        }
    }

    public final void show() {
        int i = 0;
        if (this.kyV != null && this.kyV.size() != 0) {
            this.kyT.setOnPageChangeListener(this);
            b bVar = new b(this);
            bVar.kyW = this.kyU;
            bVar.kzb = this.kyV;
            if (bVar.kzb.size() > 0) {
                bVar.mCount = ((bVar.kzb.size() - 1) / 9) + 1;
            } else {
                bVar.mCount = 0;
            }
            while (true) {
                int i2 = i;
                if (i2 < bVar.mCount) {
                    View inflate = ((LayoutInflater) bVar.kzd.mContext.getSystemService("layout_inflater")).inflate(R.i.ipcall_share_grid_view, null);
                    GridView gridView = (GridView) inflate.findViewById(R.h.ipcall_share_list);
                    List arrayList = new ArrayList();
                    int i3 = i2 * 9;
                    while (i3 < bVar.kzb.size() && i3 < (i2 * 9) + 9) {
                        arrayList.add(bVar.kzb.get(i3));
                        i3++;
                    }
                    a aVar = new a(bVar.kzd.getContext());
                    aVar.kyW = bVar.kyW;
                    aVar.jWl = arrayList;
                    gridView.setAdapter(aVar);
                    bVar.kzc.add(inflate);
                    i = i2 + 1;
                } else {
                    this.kyS = bVar;
                    this.kyT.setAdapter(this.kyS);
                    this.Dm.setText(this.sn);
                    super.show();
                    return;
                }
            }
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
