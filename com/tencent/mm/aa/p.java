package com.tencent.mm.aa;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class p {
    private static List<String> dIg = null;
    private static int dIh = 0;
    private static a dIi = new a(new b());

    static class b implements com.tencent.mm.sdk.platformtools.al.a {
        Runnable dIk;

        b() {
        }

        public final boolean vD() {
            int size = p.dIg.size();
            x.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + size);
            if (size <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || p.dIh >= l.CTRL_BYTE) {
                if (this.dIk != null) {
                    this.dIk.run();
                }
                p.dIh = 0;
                return false;
            }
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            int i = size - 1;
            while (true) {
                int i2 = i;
                if (i2 >= size - 30) {
                    p.KF();
                    String str = (String) p.dIg.get(i2);
                    p.dIg.remove(i2);
                    q.Kp();
                    f.B(str, false);
                    q.Kp();
                    f.B(str, true);
                    q.KH().kd(str);
                    i = i2 - 1;
                } else {
                    g.Ei().dqq.gp(dO);
                    return true;
                }
            }
        }
    }

    static class a extends al {
        final b dIj;

        public a(b bVar) {
            super(bVar, true);
            this.dIj = bVar;
        }
    }

    static /* synthetic */ int KF() {
        int i = dIh;
        dIh = i + 1;
        return i;
    }

    public static void k(Runnable runnable) {
        if (g.Eg().Dx()) {
            k KH = q.KH();
            List arrayList = new ArrayList();
            Cursor b = KH.dCZ.b("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            b.close();
            dIg = arrayList;
            if (arrayList.size() > 0) {
                dIi.dIj.dIk = runnable;
                dIi.J(10, 10);
            }
        }
    }

    public static void KB() {
        dIh = 0;
        dIi.SO();
    }
}
