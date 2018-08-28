package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.a;
import java.util.List;

public final class e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int idB = R.i.emoji_sort_item;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int idC;
    public List<EmojiGroupInfo> idD;
    private Context mContext;

    public e(Context context, List<EmojiGroupInfo> list) {
        super(context, idB, list);
        this.idC = context.getResources().getDimensionPixelSize(R.f.emoji_item_list_height);
        this.mContext = context;
        this.idD = list;
    }

    public final void aDC() {
        if (this.idD != null) {
            int size = this.idD.size();
            for (int i = 0; i < size; i++) {
                ((EmojiGroupInfo) this.idD.get(i)).field_idx = i;
            }
            i.aEA().igy.ds(this.idD);
            EmojiGroupInfo br = i.aEA().igy.br(EmojiGroupInfo.tcz, false);
            br.field_sort = this.idD.size() + 2;
            a aVar = i.aEA().igy;
            if (!a.cnl()) {
                aVar = i.aEA().igy;
                if (br != null) {
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", br.field_packName, Long.valueOf(br.field_lastUseTime), Integer.valueOf(br.field_sort));
                    aVar.a(br);
                    aVar.b("event_update_group", 0, bi.cjd().toString());
                }
            }
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(idB, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.eCm.setText(R.l.emoji_store_tuzi_title);
        } else {
            aVar.eCm.setText(emojiGroupInfo.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.gmn.setImageResource(R.g.icon_002_cover);
        } else {
            o.Pj().a(emojiGroupInfo.field_packIconUrl, aVar.gmn, f.cr(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.idE.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        }
        view.setVisibility(0);
        return view;
    }
}
