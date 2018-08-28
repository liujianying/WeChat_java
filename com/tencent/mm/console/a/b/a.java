package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.ak.e;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final int[] dhz = new int[]{0, 1};

    static /* synthetic */ bd B(String str, int i) {
        bd bdVar = new bd();
        bdVar.ep(str);
        bdVar.setContent("text_" + i);
        bdVar.setType(1);
        bdVar.eX(dhz[ga(dhz.length)]);
        if (bdVar.field_isSend == 1) {
            bdVar.setStatus(4);
        } else {
            bdVar.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        bdVar.ax(currentTimeMillis);
        bdVar.ay(currentTimeMillis);
        return bdVar;
    }

    static /* synthetic */ void C(List list) {
        if (list != null) {
            x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list begin,count:" + list.size());
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                ab A = A(str, i);
                if (!((i) g.l(i.class)).FR().Yi(str)) {
                    ((i) g.l(i.class)).FR().T(A);
                }
            }
            x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list end,count:%s", new Object[]{Integer.valueOf(list.size())});
        }
    }

    static /* synthetic */ bd b(String str, c cVar) {
        if (cVar == null) {
            return null;
        }
        bd bdVar = (bd) cVar.dhM;
        String str2 = str + bdVar.field_content.substring(bdVar.field_content.indexOf(":"));
        bdVar = new bd();
        bdVar.ep(str);
        bdVar.setContent(str2);
        bdVar.setType(43);
        bdVar.eX(dhz[ga(dhz.length)]);
        if (bdVar.field_isSend == 1) {
            bdVar.setStatus(4);
        } else {
            bdVar.setStatus(3);
        }
        bdVar.C(bi.WP("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        bdVar.ax(currentTimeMillis);
        bdVar.ay(currentTimeMillis);
        bdVar.eq(com.tencent.mm.a.g.u(aN(currentTimeMillis)));
        return bdVar;
    }

    static /* synthetic */ bd c(String str, c cVar) {
        if (cVar == null) {
            return null;
        }
        bd bdVar = (bd) cVar.dhM;
        EmojiInfo emojiInfo = (EmojiInfo) cVar.dhN;
        String str2 = bdVar.field_content;
        String str3 = str + str2.substring(str2.indexOf(":"));
        String str4 = "7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D";
        bd bdVar2 = new bd();
        bdVar2.ep(str);
        bdVar2.setContent(str3);
        bdVar2.setType(47);
        bdVar2.eX(dhz[ga(dhz.length)]);
        if (bdVar2.field_isSend == 1) {
            bdVar2.setStatus(4);
        } else {
            bdVar2.setStatus(3);
        }
        bdVar2.eq(bdVar.field_imgPath);
        bdVar2.C(bi.WP(str4));
        long currentTimeMillis = System.currentTimeMillis();
        bdVar2.ax(currentTimeMillis);
        bdVar2.ay(currentTimeMillis);
        EmojiInfo emojiInfo2 = new EmojiInfo();
        emojiInfo2.field_md5 = emojiInfo.Xh();
        emojiInfo2.field_svrid = emojiInfo.cnC();
        emojiInfo2.field_catalog = bi.a(Integer.valueOf(emojiInfo.field_catalog), 0);
        emojiInfo2.field_type = bi.a(Integer.valueOf(emojiInfo.field_type), 0);
        emojiInfo2.field_size = bi.a(Integer.valueOf(emojiInfo.field_size), 0);
        emojiInfo2.field_start = bi.a(Integer.valueOf(emojiInfo.field_start), 0);
        emojiInfo2.field_state = bi.a(Integer.valueOf(emojiInfo.field_state), 0);
        emojiInfo2.field_reserved3 = bi.a(Integer.valueOf(emojiInfo.field_reserved3), 0);
        emojiInfo2.field_reserved4 = bi.a(Integer.valueOf(emojiInfo.field_reserved4), 0);
        emojiInfo2.field_groupId = emojiInfo.field_groupId;
        emojiInfo2.field_lastUseTime = bi.a(Long.valueOf(emojiInfo.field_lastUseTime), 0);
        emojiInfo2.field_idx = bi.a(Integer.valueOf(emojiInfo.field_idx), 0);
        emojiInfo2.field_temp = bi.a(Integer.valueOf(emojiInfo.field_temp), 0);
        emojiInfo2.field_source = bi.a(Integer.valueOf(emojiInfo.field_source), 0);
        emojiInfo2.field_needupload = bi.a(Integer.valueOf(emojiInfo.field_needupload), 0);
        emojiInfo2.field_thumbUrl = emojiInfo.field_thumbUrl;
        emojiInfo2.field_cdnUrl = emojiInfo.field_cdnUrl;
        emojiInfo2.field_encrypturl = emojiInfo.field_encrypturl;
        emojiInfo2.field_aeskey = emojiInfo.field_aeskey;
        emojiInfo2.field_width = bi.a(Integer.valueOf(emojiInfo.field_width), 0);
        emojiInfo2.field_height = bi.a(Integer.valueOf(emojiInfo.field_height), 0);
        if (!com.tencent.mm.plugin.emoji.model.i.aEA().igx.ZA(emojiInfo.Xh())) {
            com.tencent.mm.plugin.emoji.model.i.aEA().igx.o(emojiInfo2);
        }
        return bdVar2;
    }

    static /* synthetic */ void gb(int i) {
        x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact begin,count:%s", new Object[]{Integer.valueOf(i)});
        x.i("MicroMsg.AgingTestCommand", "[oneliang]get exists count:%s", new Object[]{Integer.valueOf(s.Hw())});
        int Hw = s.Hw();
        for (int i2 = Hw; i2 < i + Hw; i2++) {
            String str = "rdgztest_atm" + i2;
            ab A = A("rdgztest_atm" + i2, i2);
            if (!((i) g.l(i.class)).FR().Yi(str)) {
                ((i) g.l(i.class)).FR().T(A);
            }
        }
        x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact end,count:%s", new Object[]{Integer.valueOf(i)});
    }

    static {
        try {
            Object newInstance = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
            if (newInstance != null && (newInstance instanceof com.tencent.mm.pluginsdk.cmd.a)) {
                b.a((com.tencent.mm.pluginsdk.cmd.a) newInstance, new String[]{"//aging"});
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AgingTestCommand", th, "", new Object[0]);
        }
    }

    private a() {
    }

    public final boolean a(final Context context, final String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length <= 1) {
            return false;
        }
        String GF = q.GF();
        final b bVar = new b();
        for (int i = 5001; i <= 6000; i++) {
            bVar.dhI.add("rdgztest_atm" + i);
        }
        h bdc = ((i) g.l(i.class)).bcY().bdc();
        Cursor b = bdc.b("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[]{GF}, 0);
        while (b.moveToNext()) {
            bd bdVar = new bd();
            bdVar.d(b);
            Cursor b2;
            switch (bdVar.getType()) {
                case 3:
                    b2 = bdc.b("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[]{String.valueOf(bdVar.field_msgSvrId)}, 0);
                    if (b2.moveToNext()) {
                        e eVar = new e();
                        eVar.d(b2);
                        bVar.dhJ.add(new c(bdVar, eVar));
                    }
                    b2.close();
                    break;
                case i$l.AppCompatTheme_dialogPreferredPadding /*43*/:
                    b2 = bdc.b("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[]{String.valueOf(bdVar.field_msgSvrId)}, 0);
                    if (b2.moveToNext()) {
                        r rVar = new r();
                        rVar.d(b2);
                        bVar.dhK.add(new c(bdVar, rVar));
                    }
                    b2.close();
                    break;
                case i$l.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    b2 = bdc.b("SELECT * FROM EmojiInfo WHERE md5=?", new String[]{bdVar.field_imgPath}, 0);
                    if (b2.moveToNext()) {
                        EmojiInfo emojiInfo = new EmojiInfo();
                        emojiInfo.d(b2);
                        bVar.dhL.add(new c(bdVar, emojiInfo));
                    }
                    b2.close();
                    break;
                default:
                    break;
            }
        }
        b.close();
        if (bVar.dhJ.isEmpty() && bVar.dhL.isEmpty() && bVar.dhK.isEmpty()) {
            Toast.makeText(context, "please send some data(img,video,emoji) to yourself", 1).show();
            return false;
        }
        x.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[]{Integer.valueOf(bVar.dhI.size()), Integer.valueOf(bVar.dhJ.size()), Integer.valueOf(bVar.dhL.size()), Integer.valueOf(bVar.dhK.size())});
        if (strArr.length == 2) {
            Toast.makeText(context, "aging begin", 1).show();
            au.Em().H(new Runnable() {
                public final void run() {
                    a.C(bVar.dhI);
                    a.a(a.this, null, bi.getInt(strArr[1], 0), bVar);
                    a.a(a.this, context);
                }
            });
            return true;
        } else if (strArr.length < 3) {
            return false;
        } else {
            int i2 = bi.getInt(strArr[2], 0);
            GF = strArr[1];
            Object obj = -1;
            switch (GF.hashCode()) {
                case i$l.AppCompatTheme_actionButtonStyle /*49*/:
                    if (GF.equals("1")) {
                        obj = null;
                        break;
                    }
                    break;
                case i$l.AppCompatTheme_buttonBarStyle /*50*/:
                    if (GF.equals("2")) {
                        obj = 1;
                        break;
                    }
                    break;
                case i$l.AppCompatTheme_buttonBarButtonStyle /*51*/:
                    if (GF.equals("3")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    au.Em().H(new 2(this, i2, context));
                    return true;
                case 1:
                    String str = null;
                    if (strArr.length == 4) {
                        str = strArr[3];
                    }
                    au.Em().H(new 3(this, str, i2, bVar, context));
                    return true;
                case 2:
                    return true;
                default:
                    return true;
            }
        }
    }

    private static int ga(int i) {
        int random = (int) (Math.random() * ((double) i));
        if (random >= i) {
            return 0;
        }
        return random;
    }

    private static ab A(String str, int i) {
        ab abVar = new ab();
        abVar.dhP = (long) (100000 + i);
        abVar.setUsername(str);
        abVar.du("alias_" + i);
        abVar.dx("nickName_" + i);
        abVar.dz("quanPin_" + i);
        abVar.dy("pyInitial_" + i);
        abVar.setType(3);
        return abVar;
    }

    private static byte[] aN(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }
}
