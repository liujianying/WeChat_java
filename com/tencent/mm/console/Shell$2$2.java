package com.tencent.mm.console;

import com.tencent.mm.console.Shell.2;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Shell$2$2 implements Runnable {
    final /* synthetic */ 2 dhw;
    final /* synthetic */ String dhx;

    Shell$2$2(2 2, String str) {
        this.dhw = 2;
        this.dhx = str;
    }

    public final void run() {
        Throwable th;
        BufferedReader bufferedReader;
        SQLiteDatabase coa = g.Ei().dqq.coa();
        BufferedReader bufferedReader2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            bufferedReader2 = new BufferedReader(new FileReader(this.dhx));
            try {
                x.i("MicroMsg.Shell", "Executing SQL from file: " + this.dhx);
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    coa.execSQL(readLine);
                }
                x.i("MicroMsg.Shell", "Finish executing SQL in %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                }
                if (coa.inTransaction()) {
                    coa.endTransaction();
                }
            } catch (FileNotFoundException e2) {
                try {
                    x.e("MicroMsg.Shell", "Cannot find file to execute: " + this.dhx);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (coa.inTransaction()) {
                        coa.endTransaction();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (coa.inTransaction()) {
                        coa.endTransaction();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                bufferedReader = bufferedReader2;
                try {
                    x.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + this.dhx, new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (coa.inTransaction()) {
                        coa.endTransaction();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e42) {
                        }
                    }
                    if (coa.inTransaction()) {
                        coa.endTransaction();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            bufferedReader2 = null;
            x.e("MicroMsg.Shell", "Cannot find file to execute: " + this.dhx);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e32) {
                }
            }
            if (coa.inTransaction()) {
                coa.endTransaction();
            }
        } catch (Throwable th32) {
            th = th32;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.Shell", th, "Failed to execute file: " + this.dhx, new Object[0]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e52) {
                }
            }
            if (coa.inTransaction()) {
                coa.endTransaction();
            }
        } catch (Throwable th322) {
            th = th322;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e422) {
                }
            }
            if (coa.inTransaction()) {
                coa.endTransaction();
            }
            throw th;
        }
    }
}
