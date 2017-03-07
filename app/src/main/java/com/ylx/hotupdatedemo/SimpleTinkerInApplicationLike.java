package com.ylx.hotupdatedemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/3/7  下午3:08
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
@DefaultLifeCycle(
        application = ".SimpleTinkerInApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false
)
public class SimpleTinkerInApplicationLike extends ApplicationLike {
    public SimpleTinkerInApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        Toast.makeText(base,"执行了",Toast.LENGTH_SHORT).show();

        /**
         * 默认修复成功后关闭程序，重新打开可以看到修复效果
         */
//        TinkerInstaller.install(this);

        /**
         * 更改修复成功后程序关闭的问题，但更改后，需要杀掉程序进程，重新打开可以看到修复效果
         */
        TinkerInstaller.install(this,
                new DefaultLoadReporter(base),
                new DefaultPatchReporter(base),
                new DefaultPatchListener(base),
                TinkerResultService.class,
                new UpgradePatch());
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
