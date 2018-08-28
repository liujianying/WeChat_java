package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.map.a$f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends BaseAdapter {
    String aAL = "";
    byte[] buffer = null;
    private Context context = null;
    boolean eMT = false;
    boolean hxu = false;
    String jbY = "";
    boolean kJb = false;
    List<f> kJo = new ArrayList();
    int kJp = 0;

    public e(Context context) {
        this.context = context;
    }

    public final void clean() {
        this.buffer = null;
        this.hxu = false;
        this.aAL = "";
        this.kJo.clear();
    }

    public final void FX(String str) {
        this.aAL = str;
        x.i("MicroMsg.PoiAdapter", "initdata key %s", new Object[]{str});
    }

    public final void b(f fVar) {
        if (this.kJo.size() >= 0) {
            this.kJo.add(0, fVar);
            notifyDataSetChanged();
        }
    }

    public final void a(List<f> list, byte[] bArr, boolean z, String str) {
        if (this.aAL == null || !this.aAL.equals(str)) {
            x.i("MicroMsg.PoiAdapter", "old key come pass it %s %s", new Object[]{this.aAL, str});
            return;
        }
        int size = this.kJo.size();
        int i = size;
        for (f fVar : list) {
            fVar.kJH = i;
            i++;
            this.kJo.add(fVar);
        }
        this.buffer = bArr;
        this.hxu = z;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.kJo.size();
    }

    /* renamed from: rU */
    public final f getItem(int i) {
        return (f) this.kJo.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(a$f.poi_list_item, null);
            aVar = new a();
            aVar.titleView = (TextView) view.findViewById(com.tencent.mm.plugin.map.a.e.title);
            aVar.kJq = (TextView) view.findViewById(com.tencent.mm.plugin.map.a.e.subtitle);
            aVar.kJr = (ImageView) view.findViewById(com.tencent.mm.plugin.map.a.e.tip_view);
            aVar.kJt = view.findViewById(com.tencent.mm.plugin.map.a.e.extend_view);
            aVar.kJs = view.findViewById(com.tencent.mm.plugin.map.a.e.info_view);
            aVar.gxT = (TextView) view.findViewById(com.tencent.mm.plugin.map.a.e.tip_location);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (((f) this.kJo.get(i)).type == 1 || ((f) this.kJo.get(i)).type == 2) {
            aVar.kJt.setVisibility(0);
            aVar.kJs.setVisibility(8);
            aVar.gxT.setText(bi.aG(((f) this.kJo.get(i)).kJu, ""));
        } else {
            aVar.kJt.setVisibility(8);
            aVar.kJs.setVisibility(0);
        }
        if (i != 0 || this.eMT) {
            CharSequence FY;
            f fVar = (f) this.kJo.get(i);
            String aG = bi.aG(fVar.mName, "");
            CharSequence aG2 = bi.aG(fVar.kJu, "");
            if (!this.eMT || bi.oW(this.jbY)) {
                Object FY2 = aG;
            } else {
                FY2 = FY(aG);
                aG2 = FY(aG2);
            }
            aVar.titleView.setText(FY2);
            aVar.kJq.setText(aG2);
            aVar.kJq.setVisibility(0);
        } else if (this.kJb) {
            aVar.titleView.setText(bi.aG(((f) this.kJo.get(0)).mName, ""));
            aVar.kJq.setVisibility(0);
            aVar.kJq.setText(bi.aG(((f) this.kJo.get(0)).kJu, ""));
        } else {
            aVar.kJq.setVisibility(8);
            if (!bi.oW(((f) this.kJo.get(0)).kJu)) {
                aVar.titleView.setText(bi.aG(((f) this.kJo.get(i)).kJu, ""));
            } else if (bi.oW(((f) this.kJo.get(0)).kJD)) {
                aVar.titleView.setText(bi.aG(((f) this.kJo.get(i)).mName, ""));
            } else {
                aVar.titleView.setText(bi.aG(((f) this.kJo.get(i)).kJD, ""));
            }
        }
        if (i == this.kJp) {
            aVar.kJr.setVisibility(0);
        } else {
            aVar.kJr.setVisibility(4);
        }
        return view;
    }

    private Spannable FY(String str) {
        return f.a(str, this.jbY);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        x.i("MicroMsg.PoiAdapter", "map notifyDataChange " + bi.cjd().toString() + " threadId : " + Thread.currentThread().getId());
    }
}
