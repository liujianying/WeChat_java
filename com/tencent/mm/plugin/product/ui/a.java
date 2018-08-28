package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {
    private Context lSg;
    private List<com.tencent.mm.plugin.product.c.a> lSh;
    private List<Boolean> lSi;
    private int lSj = 1;

    public a(Context context) {
        this.lSg = context;
    }

    public final void bG(List<com.tencent.mm.plugin.product.c.a> list) {
        this.lSh = list;
        this.lSj = 0;
        this.lSi = new ArrayList();
        if (this.lSh != null) {
            Set hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.lSi.add(Boolean.valueOf(false));
                hashSet.add(Integer.valueOf(aVar.hcE));
            }
            this.lSj = list.size();
        }
        if (this.lSj <= 0) {
            this.lSj = 1;
        }
    }

    public final void a(Activity activity, View view, int i) {
        b bVar = (b) view.getTag();
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.lSn);
        Intent intent;
        switch (bVar.type) {
            case 0:
                return;
            case 1:
                if (bVar.lSn instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.lSn);
                    intent.putExtra("showShare", false);
                    d.b(this.lSg, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 10000);
                    return;
                }
                return;
            case 2:
                if (bVar.lSn instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.lSn;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    return;
                }
                return;
            case 4:
            case 6:
                if (bVar.lSn instanceof String) {
                    String str = (String) bVar.lSn;
                    Intent intent2 = new Intent();
                    intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("data", str);
                    intent2.putExtra("QRDataFlag", false);
                    d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            case 5:
                if (((Boolean) this.lSi.get(i)).booleanValue()) {
                    this.lSi.set(i, Boolean.valueOf(false));
                } else {
                    this.lSi.set(i, Boolean.valueOf(true));
                }
                notifyDataSetChanged();
                return;
            default:
                x.w("MicroMsg.MallCustomActionAdapter", "not support type");
                return;
        }
    }

    public final int getCount() {
        return this.lSh != null ? this.lSh.size() : 0;
    }

    private com.tencent.mm.plugin.product.c.a uy(int i) {
        return (com.tencent.mm.plugin.product.c.a) this.lSh.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.lSj;
    }

    public final int getItemViewType(int i) {
        return uy(i).hcE;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.lSg, g.product_item_view, null);
            bVar = new b();
            bVar.gsY = (TextView) view.findViewById(f.title_tv);
            bVar.lSk = (TextView) view.findViewById(f.summary_tv);
            bVar.lSl = (ImageView) view.findViewById(f.indecator_iv);
            bVar.lSm = (HtmlTextView) view.findViewById(f.detail_htv);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a uy = uy(i);
        if (uy != null) {
            bVar.gsY.setText(uy.jPe);
            bVar.lSk.setText(uy.lRx);
            bVar.type = uy.hcE;
            bVar.lSn = uy.jSA;
            bVar.title = uy.jPe;
            switch (uy.hcE) {
                case 0:
                    bVar.lSl.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.lSi.get(i)).booleanValue()) {
                        bVar.lSm.setVisibility(0);
                    } else {
                        bVar.lSm.setVisibility(8);
                    }
                    if (!bVar.lSm.getText().equals(uy.jSA)) {
                        bVar.lSm.setText(uy.jSA);
                        break;
                    }
                    break;
            }
        }
        return view;
    }
}
