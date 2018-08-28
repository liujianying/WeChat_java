package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.l.a;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.plugin.fav.ui.m$f;
import com.tencent.mm.plugin.fav.ui.m.b;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements a, MMTagPanel.a {
    private Context context;
    private int jbU = b.normal_text_color;
    private int jbV = d.fav_tag_white_tab_selector;
    private Set<String> jbW = new HashSet();

    public abstract void BA(String str);

    public abstract void Bz(String str);

    public /* synthetic */ Object getItem(int i) {
        return ((ae) g.n(ae.class)).getFavTagSetMgr().pK(i);
    }

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        ((ae) g.n(ae.class)).getFavTagSetMgr();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, m$f.fav_tag_panel_item, null);
            a aVar2 = new a();
            aVar2.hoc = (TextView) view.findViewById(m$e.fav_panel_catalog);
            aVar2.jbX = (FavTagPanel) view.findViewById(m$e.fav_tag_panel);
            aVar2.jbX.setCallBack(this);
            aVar2.jbX.setTagNormalBG(this.jbV);
            aVar2.jbX.setTagNormalTextColorRes(this.jbU);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.jbX;
        Collection collection = this.jbW;
        List<wv> pK = ((ae) g.n(ae.class)).getFavTagSetMgr().pK(i);
        if (pK == null || pK.isEmpty()) {
            boolean z;
            String str = "MicroMsg.FavTagPanel";
            String str2 = "setTagListByTagInfo,null == tags ?%B,";
            Object[] objArr = new Object[1];
            if (pK == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", new Object[]{Integer.valueOf(pK.size())});
            List linkedList = new LinkedList();
            for (wv wvVar : pK) {
                linkedList.add(wvVar.qdu);
            }
            favTagPanel.a(collection, linkedList);
        }
        return view;
    }

    public final void zQ(String str) {
    }

    public final void zR(String str) {
    }

    public final void zS(String str) {
    }

    public final void aGt() {
    }

    public final void BE(String str) {
        this.jbW.add(str);
        notifyDataSetChanged();
    }

    public final void BF(String str) {
        this.jbW.remove(str);
        notifyDataSetChanged();
    }

    public final void bf(List<String> list) {
        this.jbW.clear();
        if (list != null) {
            this.jbW.addAll(list);
        }
    }

    public final void zP(String str) {
        BE(str);
        Bz(str);
    }

    public final void zO(String str) {
        BF(str);
        BA(str);
    }

    public final void aLo() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void aLp() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void i(boolean z, int i) {
    }
}
