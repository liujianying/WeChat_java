package com.tencent.mm.model;

import java.io.File;
import java.io.FilenameFilter;

class c$4 implements FilenameFilter {
    final /* synthetic */ c dAk;

    c$4(c cVar) {
        this.dAk = cVar;
    }

    public final boolean accept(File file, String str) {
        return str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg.db");
    }
}
