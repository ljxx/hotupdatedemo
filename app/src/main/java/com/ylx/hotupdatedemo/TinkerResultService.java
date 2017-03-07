package com.ylx.hotupdatedemo;

import android.widget.Toast;

import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;

import java.io.File;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/3/7  下午5:08
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class TinkerResultService extends DefaultTinkerResultService {
    @Override
    public void onPatchResult(PatchResult result) {
        //        super.onPatchResult(result);   把这行注释掉，屏蔽掉父类中的方法
        if (result == null) {
            Toast.makeText(this,"====result==null===",Toast.LENGTH_LONG).show();
            return;
        }

        if(result.isSuccess){    //修复成功
            Toast.makeText(this,"修复成功了",Toast.LENGTH_LONG).show();
            deleteRawPatchFile(new File(result.rawPatchFilePath));  //删除补丁包
        } else {
            Toast.makeText(this,"修复失败了",Toast.LENGTH_LONG).show();
        }

    }
}
