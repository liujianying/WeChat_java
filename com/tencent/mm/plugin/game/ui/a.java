package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.mm.a.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public abstract class a<T> extends BaseAdapter {
    private static int jTJ = 500;
    protected LinkedList<T> jOb;
    private a jTG;
    protected boolean jTH = false;
    private f<String, Bitmap> jTI;
    private al jTK = new al(new 2(this), false);
    private final com.tencent.mm.sdk.e.j.a jTL = new 3(this);
    protected Context mContext;

    public a(Context context) {
        this.mContext = context;
        this.jOb = new LinkedList();
        this.jTI = new f(20);
        com.tencent.mm.plugin.ac.a.bmf().c(this.jTL);
    }

    public void O(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.jOb.addAll(linkedList);
            if (this.jTG != null) {
                this.jOb.size();
            }
            super.notifyDataSetChanged();
        } else if (this.jTG != null) {
            this.jOb.size();
        }
    }

    public void P(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.jOb = linkedList;
            if (this.jTG != null) {
                this.jOb.size();
            }
            super.notifyDataSetChanged();
        } else if (this.jTG != null) {
            this.jOb.size();
        }
    }

    public void clear() {
        if (this.jOb != null) {
            this.jOb.clear();
        }
        if (this.jTI != null) {
            this.jTI.a(new 1(this));
        }
        this.jTI = null;
        com.tencent.mm.plugin.ac.a.bmf().d(this.jTL);
    }

    protected final Bitmap DI(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.jTI.bb(str)) {
            bitmap = (Bitmap) this.jTI.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bp.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.jTI.m(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.jOb.size();
    }

    public Object getItem(int i) {
        return this.jOb.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
