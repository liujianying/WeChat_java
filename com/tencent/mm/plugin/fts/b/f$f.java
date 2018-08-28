package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class f$f extends a {
    private int count;
    final /* synthetic */ f juX;

    public f$f(f fVar, int i) {
        this.juX = fVar;
        this.count = i;
    }

    public final boolean execute() {
        Throwable th;
        if (this.juX.juV == null) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream("/sdcard/test_insert_msg_words.txt");
                try {
                    String str = new String(e.g(fileInputStream));
                    this.juX.juV = str.split(",");
                    e.f(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    e.f(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                e.f(fileInputStream);
                throw th;
            }
        }
        if (this.juX.juW == null) {
            this.juX.juW = new ArrayList();
            Cursor clk = ((i) g.l(i.class)).FR().clk();
            while (clk.moveToNext()) {
                this.juX.juW.add(clk.getString(0));
            }
            clk.close();
        }
        if (this.juX.juV != null) {
            for (int i = 0; i < this.count; i++) {
                String w = w(this.juX.juV);
                bd bdVar = new bd();
                bdVar.setType(1);
                bdVar.eX(1);
                bdVar.setStatus(4);
                bdVar.setContent(w);
                List list = this.juX.juW;
                bdVar.ep((String) list.get(new Random().nextInt(list.size() - 1)));
                bdVar.ay(System.currentTimeMillis() - 250327040);
                ((i) g.l(i.class)).bcY().T(bdVar);
                x.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(w.length()), Long.valueOf(bdVar.field_msgId)});
            }
        }
        return true;
    }

    private static String w(String[] strArr) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE; i++) {
            stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
        }
        return stringBuffer.toString();
    }
}
