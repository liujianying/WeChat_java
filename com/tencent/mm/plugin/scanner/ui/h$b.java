package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h$b extends BaseAdapter implements com.tencent.mm.platformtools.y.a {
    private LayoutInflater Bc = null;
    Map<String, WeakReference<ImageView>> mIH = new HashMap();
    private int mIK;
    List<com.tencent.mm.plugin.scanner.a.a.a> mIL = new ArrayList();
    final /* synthetic */ h mIM;

    class a {
        TextView hVS;
        ImageView mGO;

        a() {
        }
    }

    public h$b(h hVar) {
        this.mIM = hVar;
        this.Bc = LayoutInflater.from(h.a(hVar));
        y.a((com.tencent.mm.platformtools.y.a) this);
        this.mIK = h.a(hVar).getResources().getColor(R.e.grid_preference_thumb_bg_color);
    }

    public final int getCount() {
        return this.mIL.size();
    }

    public final Object getItem(int i) {
        return this.mIL.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.Bc.inflate(R.i.product_grid_preference_item, viewGroup, false);
            aVar = new a();
            aVar.mGO = (ImageView) view.findViewById(R.h.grid_preference_thumb);
            aVar.hVS = (TextView) view.findViewById(R.h.grid_preference_desc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) this.mIL.get(i);
        Bitmap a = y.a(new h$a(aVar2.iconUrl));
        if (a == null || a.isRecycled()) {
            aVar.mGO.setBackgroundColor(this.mIK);
            aVar.mGO.setImageBitmap(null);
        } else {
            aVar.mGO.setImageBitmap(a);
            aVar.mGO.setBackgroundColor(0);
        }
        aVar.mGO.setOnClickListener(new 1(this, aVar2.mFz, aVar2));
        aVar.mGO.setTag(aVar2.iconUrl);
        this.mIH.put(aVar2.iconUrl, new WeakReference(aVar.mGO));
        aVar.hVS.setText(aVar2.name);
        return view;
    }

    public final void m(String str, final Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && !bi.oW(str)) {
            x.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=" + str);
            if (((WeakReference) this.mIH.get(str)) != null) {
                final ImageView imageView = (ImageView) ((WeakReference) this.mIH.get(str)).get();
                if (imageView != null && str.equals((String) imageView.getTag())) {
                    ah.A(new Runnable() {
                        public final void run() {
                            imageView.setImageBitmap(bitmap);
                            imageView.setBackgroundColor(0);
                        }
                    });
                }
            }
        }
    }
}
