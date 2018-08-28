package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer {

    private static class OptimizeWorker {
        private static String vtp = null;
        private final boolean vsL;
        private final File vtq;
        private final File vtr;
        private final ResultCallback vts;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.vtq = file;
            this.vtr = file2;
            this.vsL = z;
            this.vts = resultCallback;
            vtp = str;
        }

        public final boolean cGZ() {
            try {
                if (SharePatchFileUtil.ah(this.vtq) || this.vts == null) {
                    if (this.vts != null) {
                        this.vts.aa(this.vtq);
                    }
                    String m = SharePatchFileUtil.m(this.vtq, this.vtr);
                    if (this.vsL) {
                        String absolutePath = this.vtq.getAbsolutePath();
                        File file = new File(m);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        File file2 = new File(file.getParentFile(), "interpret.lock");
                        ShareFileLockHelper shareFileLockHelper = null;
                        try {
                            shareFileLockHelper = ShareFileLockHelper.ag(file2);
                            List arrayList = new ArrayList();
                            arrayList.add("dex2oat");
                            if (VERSION.SDK_INT >= 24) {
                                arrayList.add("--runtime-arg");
                                arrayList.add("-classpath");
                                arrayList.add("--runtime-arg");
                                arrayList.add("&");
                            }
                            arrayList.add("--dex-file=" + absolutePath);
                            arrayList.add("--oat-file=" + m);
                            arrayList.add("--instruction-set=" + vtp);
                            if (VERSION.SDK_INT > 25) {
                                arrayList.add("--compiler-filter=quicken");
                            } else {
                                arrayList.add("--compiler-filter=interpret-only");
                            }
                            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                            processBuilder.redirectErrorStream(true);
                            Process start = processBuilder.start();
                            StreamConsumer.A(start.getInputStream());
                            StreamConsumer.A(start.getErrorStream());
                            int waitFor = start.waitFor();
                            if (waitFor != 0) {
                                throw new IOException("dex2oat works unsuccessfully, exit code: " + waitFor);
                            }
                            try {
                                shareFileLockHelper.close();
                            } catch (IOException e) {
                            }
                        } catch (Throwable e2) {
                            throw new IOException("dex2oat is interrupted, msg: " + e2.getMessage(), e2);
                        } catch (Throwable th) {
                            if (shareFileLockHelper != null) {
                                try {
                                    shareFileLockHelper.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } else {
                        DexFile.loadDex(this.vtq.getAbsolutePath(), m, 0);
                    }
                    if (this.vts != null) {
                        this.vts.k(this.vtq, new File(m));
                    }
                    return true;
                }
                this.vts.b(this.vtq, new IOException("dex file " + this.vtq.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable e22) {
                new StringBuilder("Failed to optimize dex: ").append(this.vtq.getAbsolutePath());
                if (this.vts != null) {
                    this.vts.b(this.vtq, e22);
                    return false;
                }
            }
        }
    }

    public interface ResultCallback {
        void aa(File file);

        void b(File file, Throwable th);

        void k(File file, File file2);
    }

    private static class StreamConsumer {
        static final Executor vtt = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void A(final InputStream inputStream) {
            vtt.execute(new Runnable() {
                public final void run() {
                    if (inputStream != null) {
                        do {
                            try {
                            } catch (IOException e) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e2) {
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    inputStream.close();
                                } catch (Exception e3) {
                                }
                                throw th;
                            }
                        } while (inputStream.read(new byte[256]) > 0);
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                }
            });
        }
    }

    public static boolean a(Collection<File> collection, File file, ResultCallback resultCallback) {
        return a(collection, file, false, null, resultCallback);
    }

    public static boolean a(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        Object arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                long length = ((File) obj).length() - ((File) obj2).length();
                if (length > 0) {
                    return 1;
                }
                return length == 0 ? 0 : -1;
            }
        });
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker((File) it.next(), file, z, str, resultCallback).cGZ()) {
                return false;
            }
        }
        return true;
    }
}
