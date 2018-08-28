package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a;
import com.tencent.mm.protocal.d;

class ReaderItemListView$a$2 implements OnClickListener {
    final /* synthetic */ a mop;
    final /* synthetic */ int moq;

    ReaderItemListView$a$2(a aVar, int i) {
        this.mop = aVar;
        this.moq = i;
    }

    public final void onClick(View view) {
        int i = this.moq;
        Intent intent = new Intent();
        intent.putExtra("mode", 1);
        String url = ((bi) ReaderItemListView.a(this.mop.moo).get(i)).getUrl();
        if (url.contains("?")) {
            url = url + "&dt=2&cv=0x" + Integer.toHexString(d.qVN) + "&w=" + ReaderItemListView.f(this.mop.moo).widthPixels;
        } else {
            url = url + "?dt=2&cv=0x" + Integer.toHexString(d.qVN) + "&w=" + ReaderItemListView.f(this.mop.moo).widthPixels;
        }
        intent.putExtra("rawUrl", url);
        intent.putExtra("webpageTitle", ((bi) ReaderItemListView.a(this.mop.moo).get(i)).getTitle());
        intent.putExtra("title", ReaderItemListView.g(this.mop.moo).getString(g.hardcode_plugin_readerappweibo_nick));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        Bundle bundle = new Bundle();
        if (((bi) ReaderItemListView.a(this.mop.moo).get(i)).type == 20) {
            bundle.putInt("snsWebSource", 3);
        } else {
            bundle.putInt("snsWebSource", 2);
        }
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("shortUrl", ((bi) ReaderItemListView.a(this.mop.moo).get(i)).Iw());
        intent.putExtra("type", ((bi) ReaderItemListView.a(this.mop.moo).get(i)).type);
        intent.putExtra("tweetid", ((bi) ReaderItemListView.a(this.mop.moo).get(i)).Iv());
        intent.putExtra("geta8key_username", "blogapp");
        com.tencent.mm.plugin.readerapp.b.a.ezn.j(intent, ReaderItemListView.g(this.mop.moo));
    }
}
