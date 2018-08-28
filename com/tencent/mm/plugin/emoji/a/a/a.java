package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import java.util.HashMap;

public abstract class a extends BaseAdapter {
    private final String TAG = "MicroMsg.BaseEmojiListAdapter";
    private final String dgc = "lock";
    private HashMap<String, com.tencent.mm.plugin.emoji.a.a> idY;
    public AbsListView iem;
    public c ien;
    public com.tencent.mm.plugin.emoji.model.h.a ieo;
    protected volatile boolean iep = false;
    private int ieq = 0;
    private int ier = 0;
    public Context mContext;

    public abstract int aDA();

    public abstract int aDB();

    public abstract int aDz();

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract com.tencent.mm.plugin.emoji.a.a c(Context context, View view);

    public abstract void oD(int i);

    public abstract void oE(int i);

    public abstract void oF(int i);

    public a(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.idY = new HashMap();
        }
    }

    public final void a(c cVar) {
        if (cVar != null && this.ien != cVar) {
            this.ien = cVar.aDE();
            notifyDataSetChanged();
        }
    }

    public void aDy() {
        if (this.idY != null) {
            this.idY.clear();
        }
        super.notifyDataSetChanged();
        this.iep = true;
    }

    public void notifyDataSetChanged() {
        Object[] objArr;
        int i;
        this.iep = false;
        if (this.ien != null) {
            this.ien.notifyDataSetChanged();
            objArr = new Object[1];
            i = this.ieq;
            this.ieq = i + 1;
            objArr[0] = Integer.valueOf(i);
            x.d("MicroMsg.BaseEmojiListAdapter", "xxx data Notify: %d", objArr);
        }
        objArr = new Object[1];
        i = this.ier;
        this.ier = i + 1;
        objArr[0] = Integer.valueOf(i);
        x.v("MicroMsg.BaseEmojiListAdapter", "xxx ui Notify: %d", objArr);
        aDy();
    }

    public final void b(f fVar) {
        ah.A(new 1(this, fVar));
    }

    public c a(f fVar) {
        return new c(fVar);
    }

    public int getCount() {
        return this.ien == null ? 0 : this.ien.size();
    }

    /* renamed from: oG */
    public f getItem(int i) {
        return this.ien == null ? null : this.ien.oJ(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.emoji.a.a aVar = null;
        if (view != null) {
            aVar = (com.tencent.mm.plugin.emoji.a.a) view.getTag();
        }
        f oG = getItem(i);
        if (aVar == null) {
            aVar = c(this.mContext, view);
            view = aVar.aDv();
            this.idY.put(a(oG), aVar);
        } else if (!bi.oW(a(oG))) {
            if (this.idY.containsValue(aVar)) {
                this.idY.remove(aVar.getProductId());
            }
            this.idY.put(a(oG), aVar);
        }
        aVar.mPosition = i;
        aVar.icY = oG;
        View b = b(i, view, viewGroup);
        aVar.aDu();
        return b;
    }

    public static String a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.iey == com.tencent.mm.plugin.emoji.a.a.f.a.ieH) {
            return fVar.ieA.bzI + "_cell";
        }
        return fVar.iez.rem;
    }

    public void clear() {
        if (this.idY != null) {
            this.idY.clear();
            this.idY = null;
        }
        if (this.ien != null) {
            this.ien.clear();
            this.ien = null;
        }
        this.iep = false;
    }

    public void be(String str, int i) {
        if (this.idY != null && this.ien != null && str != null) {
            f za = this.ien.za(str);
            if (za != null) {
                a(za, str, i);
            }
            if (!(za == null || this.ien == null || za.mStatus != -1)) {
                x.i("MicroMsg.BaseEmojiListAdapter", "force refresh status");
                za.a(this.ien.iew, this.ien.ze(str), this.ien.zc(str));
            }
            com.tencent.mm.plugin.emoji.a.a yZ = yZ(str);
            if (yZ != null) {
                String productId = yZ.getProductId() == null ? null : yZ.getProductId();
                if (productId != null && productId.equals(str)) {
                    yZ.aDu();
                }
            }
        }
    }

    public final com.tencent.mm.plugin.emoji.a.a yZ(String str) {
        if (this.idY == null) {
            return null;
        }
        return (com.tencent.mm.plugin.emoji.a.a) this.idY.get(str);
    }

    public final void bf(String str, int i) {
        if (this.idY != null && this.ien != null && str != null) {
            f za = this.ien.za(str);
            if (za != null) {
                if (i >= 0 && i < 100) {
                    a(za, str, 6);
                    za.pF = i;
                }
                if (i >= 100) {
                    a(za, str, 7);
                }
            }
            com.tencent.mm.plugin.emoji.a.a yZ = yZ(str);
            if (yZ != null) {
                String productId = yZ.getProductId() == null ? null : yZ.getProductId();
                if (productId != null && productId.equals(str)) {
                    yZ.aDu();
                }
            }
        }
    }

    public final void a(f fVar, String str, int i) {
        if (fVar != null && str != null) {
            fVar.setStatus(i);
            ao aoVar = (ao) this.ien.ieu.get(str);
            if (aoVar != null) {
                aoVar.Dl(i);
            }
        }
    }

    public final void aoV() {
        if (this.iep) {
            super.notifyDataSetChanged();
        }
    }
}
