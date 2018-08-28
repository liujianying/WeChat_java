package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g extends BaseAdapter {
    private final Activity bOb;
    private final ag handler = new ag();
    private String kCA = "";
    final List<ate> list = new ArrayList();
    final Map<Integer, Integer> nKG = new HashMap();
    final Map<Integer, Integer> nKH = new HashMap();
    int nKI = 0;
    int nKJ = 0;
    private final b nKK;
    private final h nKL;
    final a nKM;

    public g(Activity activity, String str, b bVar, a aVar) {
        this.bOb = activity;
        this.kCA = str;
        this.nKK = bVar;
        this.nKM = aVar;
        this.nKL = new h(new 1(this));
        WT();
    }

    public final void WT() {
        if (this.nKL != null) {
            r.Qp();
            String Qm = n.Qm();
            x.d("MicroMsg.ArtistAdapter", "packgePath: " + Qm);
            this.nKL.eO(this.kCA, Qm);
        }
    }

    public final int getCount() {
        return this.nKI;
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c(this);
            view = View.inflate(this.bOb, com.tencent.mm.plugin.sns.i.g.sns_artist_item, null);
            cVar.eGX = (TextView) view.findViewById(f.sns_title);
            cVar.nKT = (TextView) view.findViewById(f.sns_title_en);
            cVar.nKU = (ImageView) view.findViewById(f.img1);
            cVar.nKV = (ImageView) view.findViewById(f.img2);
            cVar.nKW = (ImageView) view.findViewById(f.img3);
            cVar.nKX = (LinearLayout) view.findViewById(f.listener_keeper);
            cVar.nKY = view.findViewById(f.line_add);
            cVar.nKU.setOnClickListener(this.nKK.nKO);
            cVar.nKV.setOnClickListener(this.nKK.nKP);
            cVar.nKW.setOnClickListener(this.nKK.nKQ);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        int intValue = this.nKG.get(Integer.valueOf(i)) != null ? ((Integer) this.nKG.get(Integer.valueOf(i))).intValue() : -1;
        cVar.nKU.setVisibility(8);
        cVar.nKV.setVisibility(8);
        cVar.nKW.setVisibility(8);
        cVar.nKY.setVisibility(8);
        if (cVar.nKN.kCA.equals("en")) {
            cVar.eGX.setVisibility(8);
            cVar.nKT.setVisibility(4);
        } else {
            cVar.eGX.setVisibility(4);
            cVar.nKT.setVisibility(8);
        }
        if (intValue >= this.nKJ || intValue == -1) {
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            String str = "";
            if (intValue - 1 >= 0) {
                Object obj = ((ate) getItem(intValue - 1)).jOS;
            } else {
                String obj2 = str;
            }
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setVisibility(0);
            int intValue2 = this.nKH.get(Integer.valueOf(i)) != null ? ((Integer) this.nKH.get(Integer.valueOf(i))).intValue() : 1;
            ate ate = (ate) getItem(intValue);
            if (ate.jOS.equals("") || !ate.jOS.equals(obj2)) {
                if (this.kCA.equals("en")) {
                    cVar.nKT.setVisibility(0);
                    cVar.nKT.setText(ate.jOS);
                    cVar.nKY.setVisibility(0);
                } else {
                    cVar.eGX.setVisibility(0);
                    cVar.eGX.setText(ate.jOS);
                    cVar.nKY.setVisibility(0);
                }
            }
            if (intValue2 > 0) {
                a(intValue, cVar.nKU);
            }
            if (intValue2 >= 2) {
                a(intValue + 1, cVar.nKV);
            }
            if (intValue2 >= 3) {
                a(intValue + 2, cVar.nKW);
            }
        }
        return view;
    }

    private void a(int i, ImageView imageView) {
        ate ate = (ate) getItem(i);
        imageView.setVisibility(0);
        a aVar = new a();
        aVar.bSZ = "";
        aVar.position = i;
        imageView.setTag(aVar);
        af.byl().b(ate, imageView, this.bOb.hashCode(), av.tbu);
    }
}
