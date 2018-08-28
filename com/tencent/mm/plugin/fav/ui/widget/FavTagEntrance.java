package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements a {
    private long bVe = -1;
    private TextView jfC;
    private String jfD = String.valueOf(this.bVe);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jfC = (TextView) findViewById(e.tag_content);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", FavTagEntrance.this.bVe);
                b.a(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", intent);
            }
        });
    }

    public void setFavItemID(long j) {
        this.bVe = j;
        this.jfD = String.valueOf(j);
    }

    public void setTagContent(List<String> list) {
        if (this.jfC != null) {
            CharSequence charSequence;
            Context context = getContext();
            if (context == null || list == null || list.isEmpty()) {
                charSequence = "";
            } else {
                String str = (String) list.get(0);
                String string = context.getResources().getString(i.favorite_tag_delimiter);
                charSequence = str;
                for (int i = 1; i < list.size(); i++) {
                    charSequence = charSequence + string + ((String) list.get(i));
                }
            }
            if (bi.oW(charSequence)) {
                this.jfC.setText("");
                this.jfC.setHint(i.favorite_entrance_add_tag_tips);
                return;
            }
            this.jfC.setText(j.a(getContext(), charSequence, this.jfC.getTextSize()));
        }
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[]{str, this.jfD});
        if (this.jfD.equals(str)) {
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(this.bVe);
            if (dy == null) {
                x.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[]{Long.valueOf(this.bVe)});
                return;
            }
            setTagContent(dy.field_tagProto.rBX);
        }
    }
}
