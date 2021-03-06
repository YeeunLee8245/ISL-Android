package kr.co.kumoh.d134.isl.view.activity

import android.util.Log
import android.view.Gravity
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseActivity
import kr.co.kumoh.d134.isl.base.ResponseResult
import kr.co.kumoh.d134.isl.databinding.ActivityMainBinding
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun subscribeUi() {
//        mDataBinding.constraint.setOnClickListener {
//            Log.d("터치","터치")
//        }
//        with(mViewModel) {
//
//        }
        with(mDataBinding) {
            vm = mViewModel
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
            val actionBar = supportActionBar
            actionBar?.apply {
                Log.d("동작 확인"," 툴바")
                setDisplayShowCustomEnabled(true)
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(true)
            }
            //changeDrawer()
            //drawerLayout.closeDrawers()
            toolbar.setNavigationOnClickListener {
                Log.d("서랍 엶1","작동")
                changeDrawer()
            }
        }
    }

    override fun onBackPressed() {
        if (mDataBinding.drawerLayout.isDrawerOpen(Gravity.LEFT))
            mDataBinding.drawerLayout.closeDrawer(Gravity.LEFT)
        else    // TODO: 초 시간 정의
            super.onBackPressed()
    }

    fun changeDrawer(){
        Log.d("서랍 엶","작동")
        if(!mDataBinding.drawerLayout.isDrawerOpen(Gravity.LEFT)){
            Log.d("서랍 엶","확인1")
            mDataBinding.drawerLayout.openDrawer(Gravity.LEFT)
        }else {
            Log.d("서랍 엶","확인2")
            mDataBinding.drawerLayout.closeDrawer(Gravity.LEFT)
        }
    }

    override fun loadResultCode(resResult: ResponseResult?) {
    }

    override fun loadErrorMessage(e: Throwable) {
    }

}