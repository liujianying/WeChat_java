package com.tencent.mm.ui.widget.sortlist;

import android.os.Environment;
import com.tencent.mm.ui.ao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class DragSortListView$f {
    File fgV = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    StringBuilder mBuilder = new StringBuilder();
    int uOC = 0;
    int uOD = 0;
    boolean uOE = false;
    final /* synthetic */ DragSortListView uOr;

    DragSortListView$f(DragSortListView dragSortListView) {
        this.uOr = dragSortListView;
        if (!this.fgV.exists()) {
            try {
                if (!this.fgV.createNewFile()) {
                    ao.v("creat file fail!! file already exist", new Object[0]);
                }
                ao.s("file created", new Object[0]);
            } catch (IOException e) {
                ao.u("Could not create dslv_state.txt", new Object[0]);
                ao.s(e.getMessage(), new Object[0]);
            }
        }
    }

    public final void flush() {
        Throwable th;
        Writer writer;
        if (this.uOE) {
            boolean z = true;
            Writer bufferedWriter;
            try {
                if (this.uOD == 0) {
                    z = false;
                }
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.fgV, z), "UTF-8"));
                try {
                    bufferedWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    bufferedWriter.flush();
                    this.uOD++;
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                    }
                } catch (IOException e2) {
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    writer = bufferedWriter;
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e32) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                writer = null;
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e42) {
                    }
                }
                throw th;
            }
        }
    }
}
