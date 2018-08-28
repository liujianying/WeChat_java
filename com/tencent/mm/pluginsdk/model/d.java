package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.fav.PluginFav;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.x;

public class d implements a {
    public final void k(Bundle bundle) {
        int i;
        int i2 = bundle.getInt("mm_rpt_fav_id", 0);
        int i3 = bundle.getInt("key_detail_fav_scene", 0);
        int i4 = bundle.getInt("key_detail_fav_sub_scene", 0);
        int i5 = bundle.getInt("key_detail_fav_index", 0);
        long j = bundle.getLong("key_activity_browse_time", -1);
        int i6 = bundle.getBoolean("mm_scroll_bottom") ? 1 : 0;
        int i7 = bundle.getInt("mm_send_friend_count", 0);
        int i8 = bundle.getInt("mm_share_sns_count", 0);
        if (bundle.getBoolean("mm_del_fav", false)) {
            i = 1;
        } else {
            i = 0;
        }
        int i9 = bundle.getInt("mm_edit_fav_count", 0);
        String string = bundle.getString("key_detail_fav_query", "");
        String string2 = bundle.getString("key_detail_fav_sessionid", "");
        String string3 = bundle.getString("key_detail_fav_tags", "");
        x.d("MicroMsg.FavWebRptCallback", "FavWebRptCallback uiBrowseTime[%d] isScrollBottom[%b] sendToFriendCount[%d] shareSnsCount[%d]  isDelFav[%b] clickEditFavTagCount[%d] favId[%s]", new Object[]{Long.valueOf(j), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i), Integer.valueOf(i9), Integer.valueOf(i2)});
        g dz = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) i2);
        if (dz == null) {
            x.w("MicroMsg.FavWebRptCallback", "fav web rpt but favitem info is null favid[%d]", new Object[]{Integer.valueOf(i2)});
            return;
        }
        long j2 = dz.field_sourceCreateTime != 0 ? dz.field_sourceCreateTime / 1000 : dz.field_updateTime / 1000;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3).append(",");
        stringBuffer.append(i5).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(dz.field_type).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(dz.field_sourceType).append(",");
        stringBuffer.append(j2).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append("0,");
        stringBuffer.append(i7).append(",");
        stringBuffer.append(i8).append(",");
        stringBuffer.append("0,");
        stringBuffer.append(i9).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(i6).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(string2).append(",");
        stringBuffer.append(((PluginFav) com.tencent.mm.kernel.g.n(PluginFav.class)).getFavItemInfoStorage().pL(i2) + 1).append(",");
        stringBuffer.append(string).append(",");
        stringBuffer.append(string3);
        x.d("MicroMsg.FavWebRptCallback", String.format("lxl, 15098, sid:%s, sourcepos:%s, query:%s, tag:%s", new Object[]{string2, Integer.valueOf(r2), string, string3}));
        x.v("MicroMsg.FavWebRptCallback", "FavWebRptCallback rpt id[%d] [%s]", new Object[]{Integer.valueOf(15098), stringBuffer.toString()});
        f.mDy.k(15098, stringBuffer.toString());
    }
}
