package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.dbbackup.d.5;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.d;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class c implements a {
    private d hZm;

    c(d dVar) {
        this.hZm = dVar;
    }

    private boolean cW(Context context) {
        if (g.Ei().DP() == null) {
            h.i(context, R.l.recover_db_no_datafile, R.l.app_tip);
        } else {
            context.getString(R.l.app_tip);
            p a = h.a(context, context.getString(R.l.recover_db_loading), false, null);
            bu cbe = ((b) g.l(b.class)).cbe();
            cbe.IK();
            d dVar = this.hZm;
            1 1 = new 1(this, cbe, a, context);
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ad.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(ad.getContext(), "MicroMsg.SubCoreDBBackup");
            5 5 = new 5(dVar, bVar, 1, wakerLock);
            x.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            com.tencent.mm.plugin.report.service.h.mEJ.a(181, 28, 1, true);
            try {
                bVar.createNewFile();
            } catch (IOException e) {
            }
            5.ov(-1);
        }
        return true;
    }

    private boolean b(Context context, String[] strArr) {
        int i = -1;
        int i2 = 0;
        String str = g.Ei().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = new String[]{"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (d.cn(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        return true;
                    }
                    au.HU();
                    com.tencent.mm.model.c.FO().coa().close();
                    d.mL(str2);
                    while (i2 < 5) {
                        String str6 = strArr2[i2];
                        d.av(str3 + str6, str4 + str6);
                        i2++;
                    }
                    d.cY(context);
                    return true;
                case 1:
                    if (d.cn(str2)) {
                        final Context context2 = context;
                        h.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", null, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                au.HU();
                                com.tencent.mm.model.c.FO().coa().close();
                                for (String str : strArr2) {
                                    d.deleteFile(str3 + str);
                                    d.av(str4 + str, str3 + str);
                                }
                                d.I(str2, false);
                                d.cY(context2);
                            }
                        }, null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                case 2:
                    if (d.cn(str2)) {
                        h.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", null, new 6(this, str2, context), null);
                        return true;
                    }
                    Toast.makeText(context, "Corruption test database not exist.", 0).show();
                    return true;
                default:
                    return false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        str3 = g.Ei().DP();
        stringBuilder.append("Corrupted DB: ");
        if (str3 == null) {
            stringBuilder.append("not exist");
        } else {
            stringBuilder.append(str3.contains("/ctest/") ? "test" : "exists");
            stringBuilder.append("\nCorrupted DB size: ").append(d.abQ(str3));
            stringBuilder.append("\nSaved master exists: ").append(d.cn(str3 + ".sm"));
            stringBuilder.append("\nContent backup exists: ").append(d.cn(str3 + ".bak"));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(8388627);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16744704);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMovementMethod(new ScrollingMovementMethod());
        i = context.getResources().getDimensionPixelSize(R.f.LargePadding);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        return true;
    }

    private static boolean cX(Context context) {
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (!(lastIOTraceStats == null || lastIOTraceStats.isEmpty())) {
            Object encodeToString;
            IOTraceStats iOTraceStats = (IOTraceStats) lastIOTraceStats.get(0);
            String str = "";
            try {
                au.HU();
                str = com.tencent.mm.a.g.u((q.zy() + com.tencent.mm.model.c.Df()).getBytes()).substring(0, 7);
            } catch (Exception e) {
            }
            CharSequence format = String.format("DB corrupted (line: %d, hash: %s) => %s", new Object[]{Integer.valueOf(lastErrorLine), str, iOTraceStats.toString()});
            Object obj = "";
            if (iOTraceStats.lastReadPage != null) {
                obj = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            String str2 = "";
            if (iOTraceStats.lastJournalReadPage != null) {
                encodeToString = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                String encodeToString2 = str2;
            }
            Map hashMap = new HashMap();
            hashMap.put("lastReadPage", obj);
            hashMap.put("lastJournalReadPage", encodeToString2);
            com.tencent.mm.plugin.report.service.h.mEJ.c("DBCorrupt", format, hashMap);
            View textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16744704);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.LargePadding);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, null, textView, null);
        }
        return true;
    }

    private static boolean c(Context context, String[] strArr) {
        CharSequence charSequence;
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    throw new NumberFormatException();
                }
                DT.set(89, Integer.valueOf(intValue));
                DT.lm(true);
                charSequence = "Recovery status set to " + intValue;
            } catch (NumberFormatException e) {
                charSequence = "Recovery status must be 0, 1 or 2";
            }
        } else {
            charSequence = "Recovery status is " + DT.getInt(89, 0);
        }
        Toast.makeText(context, charSequence, 0).show();
        return true;
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1955673212:
                if (str.equals("//recover")) {
                    z = true;
                    break;
                }
                break;
            case -1870250080:
                if (str.equals("//backupdb")) {
                    z = true;
                    break;
                }
                break;
            case -1832373669:
                if (str.equals("//recover-status")) {
                    z = true;
                    break;
                }
                break;
            case -1648083177:
                if (str.equals("//post-recover")) {
                    z = true;
                    break;
                }
                break;
            case -896707907:
                if (str.equals("//iotracedb")) {
                    z = true;
                    break;
                }
                break;
            case -398050965:
                if (str.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case -137452885:
                if (str.equals("//repairdb")) {
                    z = true;
                    break;
                }
                break;
            case 1483443294:
                if (str.equals("//recover-old")) {
                    z = false;
                    break;
                }
                break;
            case 1793722114:
                if (str.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
        }
        final long nanoTime;
        String str2;
        switch (z) {
            case false:
                return cW(context);
            case true:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            case true:
                au.HU();
                d.aCF();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                return true;
            case true:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final p a = h.a(context, "Backing database up. Please wait...", false, null);
                    final Context context2 = context;
                    if (this.hZm.a(z2, new b() {
                        public final void ov(int i) {
                            ah.A(new 1(this, i));
                        }
                    })) {
                        return true;
                    }
                    if (a != null) {
                        a.dismiss();
                    }
                    Toast.makeText(context, "Database is busy.", 0).show();
                    return true;
                }
                au.HU();
                com.tencent.mm.storage.x DT = com.tencent.mm.model.c.DT();
                if (strArr.length > 2) {
                    str = strArr[2];
                    z = true;
                    switch (str.hashCode()) {
                        case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (str.equals("0")) {
                                z = true;
                                break;
                            }
                            break;
                        case a$k.AppCompatTheme_actionButtonStyle /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3521:
                            if (str.equals("no")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3551:
                            if (str.equals("on")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109935:
                            if (str.equals("off")) {
                                z = true;
                                break;
                            }
                            break;
                        case 119527:
                            if (str.equals("yes")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                            DT.setInt(237571, 0);
                            DT.lm(true);
                            break;
                        case true:
                        case true:
                        case true:
                            DT.setInt(237571, 1);
                            DT.lm(true);
                            break;
                    }
                }
                Toast.makeText(context, "Database backup with cipher: " + (DT.getInt(237571, 0) == 0), 0).show();
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.app_tip);
                this.hZm.a(str2, new 3(this, h.a(context, context.getString(R.l.recover_db_loading), false, null), nanoTime, context));
                return true;
            case true:
                str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(R.l.app_tip);
                p a2 = h.a(context, context.getString(R.l.recover_db_loading), false, null);
                int b = this.hZm.b(str2, new 4(this, a2, nanoTime, context));
                if (b == 0) {
                    return true;
                }
                if (a2 != null) {
                    a2.dismiss();
                }
                switch (b) {
                    case -3:
                        b = R.l.recover_db_no_datafile;
                        break;
                    case -2:
                        b = R.l.recover_db_no_enough_space;
                        break;
                    default:
                        b = R.l.recover_db_fail;
                        break;
                }
                Toast.makeText(context, b, 1).show();
                return true;
            case true:
                return b(context, strArr);
            case true:
                return cX(context);
            case true:
                return c(context, strArr);
            default:
                return false;
        }
    }
}
