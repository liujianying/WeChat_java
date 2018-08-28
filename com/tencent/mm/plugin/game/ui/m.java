package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class m extends a<d> {
    protected int jNv = 0;
    private a jUR;
    protected d jWA;
    protected int jWv = 14;
    private b jWz = new 3(this);
    private OnClickListener jXk = new 5(this);
    protected View.OnClickListener jXl = new 4(this);
    protected int jZR;
    protected boolean jZS = true;
    protected boolean jZT = false;
    protected boolean jZU = false;
    protected int jZV;
    protected ConcurrentHashMap<String, n> jZW;
    protected SparseArray<View> jZX;
    protected Context mContext;

    abstract void a(d dVar, b bVar);

    abstract void a(d dVar, b bVar, int i);

    public m(Context context) {
        super(context);
        this.mContext = context;
        this.jZW = new ConcurrentHashMap();
        com.tencent.mm.plugin.game.model.m.a(this.jWz);
        this.jZX = new SparseArray();
        this.jWA = new d(context);
        this.jWA.jUg = this.jXk;
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }

    public void qT(int i) {
        this.jZV = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void O(LinkedList<d> linkedList) {
        if (linkedList != null) {
            g.Em().H(new 1(this, linkedList));
        }
    }

    public void P(LinkedList<d> linkedList) {
        if (linkedList != null) {
            e.post(new 2(this, linkedList), "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((d) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        d dVar = (d) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (dVar.type) {
                case 0:
                    i2 = this.jZR;
                    break;
                case 1:
                    i2 = f.game_ad_list;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.jUI = (ViewGroup) view.findViewById(com.tencent.mm.plugin.game.f.e.main_view);
            bVar2.kac = (TextView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_num);
            bVar2.kad = (ImageView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_icon);
            bVar2.jZe = (TextView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_name);
            bVar2.kae = (TextView) view.findViewById(com.tencent.mm.plugin.game.f.e.new_game_label);
            bVar2.kaf = (TextView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_info);
            bVar2.kag = (TextView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_desc);
            bVar2.kah = (Button) view.findViewById(com.tencent.mm.plugin.game.f.e.game_download_btn);
            bVar2.kai = (TextProgressBar) view.findViewById(com.tencent.mm.plugin.game.f.e.game_download_progress);
            bVar2.kal = (LinearLayout) view.findViewById(com.tencent.mm.plugin.game.f.e.game_ad_list);
            bVar2.kaj = (GameListSocialView) view.findViewById(com.tencent.mm.plugin.game.f.e.game_social);
            bVar2.kak = (ViewGroup) view.findViewById(com.tencent.mm.plugin.game.f.e.custom_view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (dVar.type) {
            case 0:
                a(dVar, bVar, i);
                if (this.jZV == 2 && !dVar.jLu) {
                    an.a(this.mContext, 10, 1004, dVar.position, dVar.field_appId, this.jNv, dVar.jLt);
                    dVar.jLu = true;
                    break;
                }
            case 1:
                a(dVar, bVar);
                break;
        }
        return view;
    }

    public void d(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.jZX = sparseArray;
        } else {
            this.jZX = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.jUR = aVar;
    }

    public void y(View view, int i) {
        b bVar = (b) view.getTag();
        d dVar = (d) this.jOb.get(i);
        if (bVar != null) {
            this.jWA.a(bVar.kai, bVar.kah, dVar, (n) this.jZW.get(dVar.field_appId));
            return;
        }
        x.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[]{Integer.valueOf(i)});
    }

    public void clear() {
        super.clear();
        com.tencent.mm.plugin.game.model.m.b(this.jWz);
    }

    public void DL(String str) {
        d dVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jOb.size()) {
                dVar = null;
                break;
            } else if (((d) this.jOb.get(i2)).field_appId.equals(str)) {
                dVar = (d) this.jOb.get(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (dVar != null) {
            if (this.jZW.containsKey(dVar.field_appId)) {
                this.jWA.a(dVar, (n) this.jZW.get(dVar.field_appId));
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        }
    }

    public void DK(String str) {
        if (!bi.oW(str) && this.jZW.containsKey(str)) {
            n nVar = (n) this.jZW.get(str);
            if (nVar != null) {
                nVar.aTT();
            }
        }
    }

    public void DJ(String str) {
        if (!bi.oW(str) && this.jZW.containsKey(str)) {
            n nVar = (n) this.jZW.get(str);
            if (nVar != null) {
                nVar.aTU();
            }
        }
    }
}
