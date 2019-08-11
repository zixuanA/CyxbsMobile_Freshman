package com.mredrock.cyxbs.freshman.ui.acivity

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.doPermissionAction
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.data.ViewModel.CampusGuideViewModel
import com.mredrock.cyxbs.freshman.data.ViewModel.MoreFunctionViewModel
import com.mredrock.cyxbs.freshman.databinding.FreshmanActivityMoreFuntionBinding
import kotlinx.android.synthetic.main.freshman_activity_more_funtion.*
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class MoreFunctionActivity : BaseViewModelActivity<MoreFunctionViewModel>(){
    override val viewModelClass: Class<MoreFunctionViewModel> = MoreFunctionViewModel::class.java

    override val isFragmentActivity: Boolean = false
    var dialogOpen:ObservableBoolean = ObservableBoolean(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<FreshmanActivityMoreFuntionBinding>(this,R.layout.freshman_activity_more_funtion)

        bind.activity = this
        img_vx.setOnLongClickListener {
            this.doPermissionAction(Manifest.permission.WRITE_EXTERNAL_STORAGE){
                reason = "保存文件需要文件存储权限"
                doAfterGranted {
                    viewModel.savePicture()
                }
            }

            return@setOnLongClickListener true
        }
        common_toolbar.init(
            title = "更多功能"
        )

    }
    fun onLongClick(){

    }
    fun onClick(index:Int){
        when(index){
            0->{}
            1->{}
            2->{

                dialogOpen.set(!dialogOpen.get())
                LogUtils.d("MyTag","Click${dialogOpen.get()}")
            }
        }
    }
    fun initImg(){
        img_vx.setOnLongClickListener {

            return@setOnLongClickListener true
        }
    }
    fun dismissDialog(){
        dialogOpen.set(!dialogOpen.get())
    }
    fun nullClick(){}
    override fun onBackPressed() {
        if(dialogOpen.get()){
            dialogOpen.set(!dialogOpen.get())
        }
        else
            super.onBackPressed()
    }
}

