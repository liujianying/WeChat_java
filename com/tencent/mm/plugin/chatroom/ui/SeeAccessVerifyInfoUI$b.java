package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class SeeAccessVerifyInfoUI$b extends BaseAdapter {
    private c hOC = null;
    final /* synthetic */ SeeAccessVerifyInfoUI hOz;
    List<SeeAccessVerifyInfoUI$a> hoC = new ArrayList();
    Context mContext;

    public SeeAccessVerifyInfoUI$b(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, Context context) {
        this.hOz = seeAccessVerifyInfoUI;
        this.mContext = context;
        aAS();
        a aVar = new a();
        aVar.dXy = true;
        aVar.dXV = true;
        aVar.dXN = R.k.default_avatar;
        this.hOC = aVar.Pt();
    }

    private void aAS() {
        String[] strArr = null;
        if (bi.oW(SeeAccessVerifyInfoUI.l(this.hOz))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
            return;
        }
        String[] split = SeeAccessVerifyInfoUI.l(this.hOz).split(",");
        if (bi.oW(SeeAccessVerifyInfoUI.m(this.hOz))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
            return;
        }
        String[] split2 = SeeAccessVerifyInfoUI.m(this.hOz).split(",");
        if (bi.oW(SeeAccessVerifyInfoUI.n(this.hOz))) {
            x.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
        } else {
            strArr = SeeAccessVerifyInfoUI.n(this.hOz).split(",");
        }
        this.hoC.clear();
        int i = 0;
        while (i < split.length) {
            List list = this.hoC;
            SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.hOz;
            String str = split[i];
            String str2 = (split2.length <= i || bi.oW(split2[i])) ? split[i] : split2[i];
            String str3 = (strArr == null || strArr.length <= i || bi.oW(strArr[i])) ? "" : strArr[i];
            list.add(new SeeAccessVerifyInfoUI$a(seeAccessVerifyInfoUI, str, str2, str3));
            i++;
        }
    }

    public final int getCount() {
        return this.hoC.size();
    }

    public final Object getItem(int i) {
        return this.hoC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SeeAccessVerifyInfoUI$c cp;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.roominfo_contact, null);
            cp = this.hOz.cp(view);
        } else {
            SeeAccessVerifyInfoUI$c seeAccessVerifyInfoUI$c = (SeeAccessVerifyInfoUI$c) view.getTag();
            cp = seeAccessVerifyInfoUI$c == null ? this.hOz.cp(view) : seeAccessVerifyInfoUI$c;
        }
        cp.eCl.setVisibility(0);
        cp.hOE.setVisibility(0);
        o.Pj().a(((SeeAccessVerifyInfoUI$a) this.hoC.get(i)).hOB, cp.eCl, this.hOC);
        cp.hOE.setText(j.a(this.mContext, bi.oV(((SeeAccessVerifyInfoUI$a) this.hoC.get(i)).nickname), cp.hOE.getTextSize()));
        view.setOnClickListener(new 1(this, i));
        return view;
    }
}
