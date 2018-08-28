package com.tencent.mm.plugin.monitor;

import java.util.ArrayList;

public interface a {

    public static class a {
        int axZ;
        boolean dZm = false;
        long fileLenInvalidCount;
        long gTK;
        final String lrB;
        long lrC;
        long lrD;
        long lrE;
        ArrayList<b> lrF = new ArrayList(20);
        ArrayList<c> lrG = new ArrayList(20);

        a(String str) {
            this.lrB = str;
        }

        public final String toString() {
            return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.lrB, Boolean.valueOf(this.dZm), Long.valueOf(this.lrC), Long.valueOf(this.lrD), Long.valueOf(this.gTK), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.lrF.size()), Integer.valueOf(this.lrG.size()), Long.valueOf(this.lrE), Integer.valueOf(this.axZ)});
        }
    }

    public static class b {
        boolean dZm = false;
        long fileLenInvalidCount;
        long gTK;
        final String lrB;
        long lrC;
        long lrD;
        final int tag;

        b(String str, int i) {
            this.lrB = str;
            this.tag = i;
        }

        public final String toString() {
            return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.lrB, Boolean.valueOf(this.dZm), Long.valueOf(this.lrC), Long.valueOf(this.lrD), Long.valueOf(this.gTK), Long.valueOf(this.fileLenInvalidCount)});
        }
    }

    public static class c {
        boolean dZm = false;
        long gTK;
        final String lrB;
        long lrC;
        long lrD;
        long lrH;

        c(String str) {
            this.lrB = str;
        }

        public final String toString() {
            return String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.lrB, Boolean.valueOf(this.dZm), Long.valueOf(this.lrC), Long.valueOf(this.lrD), Long.valueOf(this.gTK), Long.valueOf(this.lrH)});
        }
    }

    void a(int i, a aVar);
}
