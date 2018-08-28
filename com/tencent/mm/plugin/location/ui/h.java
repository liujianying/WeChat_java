package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    Context context;
    private String hOr = "";
    a kFA;
    private int kFB;
    c kFC = null;
    MMHorList kFz;
    private ag mHandler = new ag(Looper.getMainLooper());
    private boolean mIsInit = false;

    public h(Context context, View view, String str) {
        this.context = context;
        this.kFz = (MMHorList) view;
        this.hOr = str;
        aZA();
    }

    private void aZA() {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[]{Integer.valueOf(l.aZj().ns(this.hOr).size())});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!bi.oW(str)) {
                arrayList.add(new b(this, str));
                arrayList2.add(str);
            }
        }
        C(arrayList);
        D(arrayList2);
        this.kFz.invalidate();
        this.kFA.notifyDataSetChanged();
    }

    private void C(ArrayList<b> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.kFG) {
                bVar.aZD();
            }
        }
        this.kFB = a.fromDPToPix(this.context, 60);
        this.kFz.setOverScrollEnabled(true);
        this.kFz.setItemWidth(this.kFB);
        this.kFz.setCenterInParent(true);
        this.kFz.setOnItemClickListener(new 1(this));
        this.kFA = new a(this, arrayList);
        this.kFz.setAdapter(this.kFA);
    }

    private void FO(String str) {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[]{str});
        if (!this.kFA.FS(str)) {
            b bVar = new b(this, str);
            a aVar = this.kFA;
            aVar.kFF.add(bVar);
            aVar.notifyDataSetChanged();
            this.kFz.invalidate();
        }
    }

    private void FP(String str) {
        int i = 0;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[]{str});
        if (this.kFA.FS(str)) {
            int i2;
            a aVar = this.kFA;
            while (true) {
                i2 = i;
                if (i2 >= aVar.kFF.size()) {
                    i2 = -1;
                    break;
                } else if (((b) aVar.kFF.get(i2)).username.equals(str)) {
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (i2 != -1) {
                aVar.kFF.remove(i2);
                aVar.notifyDataSetChanged();
            }
            this.kFz.invalidate();
        }
    }

    public final void FQ(String str) {
        int i = 0;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[]{str});
        if (this.kFA.FS(str)) {
            this.kFA.FR(str).aZD();
            this.kFA.notifyDataSetChanged();
            this.kFz.invalidate();
            if (!this.kFz.getIsTouching() && !bi.oW(str)) {
                a aVar = this.kFA;
                int i2 = 0;
                while (i2 < aVar.kFF.size()) {
                    if (((b) aVar.kFF.get(i2)).username.equals(str)) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[]{Integer.valueOf(i2)});
                if (i2 != -1) {
                    int i3 = i2 * this.kFB;
                    int currentPosition = this.kFz.getCurrentPosition();
                    if (i3 >= currentPosition) {
                        currentPosition = i3 > currentPosition + (this.kFB * 3) ? i3 - (this.kFB * 3) : 0;
                    }
                    if (i2 != 0) {
                        i = currentPosition;
                    }
                    this.mHandler.post(new 2(this, i));
                }
            }
        }
    }

    public final void aZB() {
        a aVar = this.kFA;
        Iterator it = aVar.kFF.iterator();
        while (it.hasNext()) {
            ((b) it.next()).aZE();
        }
        aVar.notifyDataSetChanged();
        this.kFz.invalidate();
    }

    public final void D(ArrayList<String> arrayList) {
        String str;
        Iterator it;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList aZC = this.kFA.aZC();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            if (aZC.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = aZC.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size())});
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                FO((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                FP((String) it.next());
            }
        }
    }
}
