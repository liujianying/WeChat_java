package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class g extends u {
    private ArrayList<b> lSM;
    private boolean lSN;
    a lSO;
    private List<String> lSq;
    Context mContext;

    class b implements a {
        public ImageView bRk = null;
        public String url;

        public b(String str) {
            this.url = str;
            this.bRk = (ImageView) ((LayoutInflater) g.this.mContext.getSystemService("layout_inflater")).inflate(com.tencent.mm.plugin.wxpay.a.g.product_image_item, null);
            this.bRk.setImageBitmap(y.a(new c(str)));
            this.bRk.setOnClickListener(new 1(this, g.this));
            y.a(this);
        }

        public final void m(String str, final Bitmap bitmap) {
            x.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url != null && str.equals(this.url)) {
                this.bRk.post(new Runnable() {
                    public final void run() {
                        b.this.bRk.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b) {
        this.lSN = false;
        this.lSO = null;
        this.mContext = context;
        this.lSq = null;
        aK(this.lSq);
    }

    public final void aK(List<String> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.lSq = list;
            }
            if (this.lSM == null) {
                this.lSM = new ArrayList();
            } else {
                this.lSM.clear();
            }
            for (String bVar : this.lSq) {
                this.lSM.add(new b(bVar));
            }
        }
    }

    public final int getCount() {
        if (this.lSq == null) {
            return 0;
        }
        if (this.lSN) {
            return Integer.MAX_VALUE;
        }
        return this.lSq.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        x.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.lSM != null) {
            viewGroup.removeView(((b) this.lSM.get(i)).bRk);
        }
    }

    public final int k(Object obj) {
        return -2;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.lSM == null) {
            return super.b(viewGroup, i);
        }
        x.d("MicroMsg.MallProductImageAdapter", "data valid");
        viewGroup.addView(((b) this.lSM.get(i)).bRk, 0);
        return ((b) this.lSM.get(i)).bRk;
    }
}
