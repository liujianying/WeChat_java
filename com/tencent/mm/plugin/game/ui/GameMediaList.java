package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements OnClickListener {
    String appId = "";
    int iMP = -1;
    int jYI = 0;
    private int kam;
    private LinkedList<String> kan;
    Context mContext;

    public static class a {
        public String kao;
        public int type;
        public String url;
    }

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setItemLayout(int i) {
        this.kam = i;
    }

    public void setMediaList(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            return;
        }
        this.kan = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            a aVar = (a) linkedList.get(i);
            if (!bi.oW(aVar.url) && aVar.type == 0) {
                this.kan.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar2 = (a) linkedList.get(i2);
            if (!bi.oW(aVar2.kao)) {
                View inflate = layoutInflater.inflate(this.kam, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(e.media_thumb);
                com.tencent.mm.ak.a.a Pj = o.Pj();
                String str = aVar2.kao;
                com.tencent.mm.ak.a.a.c.a aVar3 = new com.tencent.mm.ak.a.a.c.a();
                aVar3.dXx = true;
                Pj.a(str, imageView, aVar3.Pt());
                if (aVar2.type == 1) {
                    inflate.findViewById(e.media_overlay).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.i("MicroMsg.GameMediaList", "Invalid tag");
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.kan.indexOf(aVar.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.kan.size()];
                this.kan.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.iMP);
                intent.putExtra("SOURCE_SCENE", this.jYI);
                getContext().startActivity(intent);
                return;
            case 1:
                c.an(getContext(), aVar.url);
                an.a(this.mContext, this.iMP, 1202, 1, 13, this.appId, this.jYI, null);
                return;
            default:
                return;
        }
    }
}
