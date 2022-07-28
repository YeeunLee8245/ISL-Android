package kr.co.kumoh.d134.isl.view.activity

import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kr.co.kumoh.d134.isl.R
import kr.co.kumoh.d134.isl.base.BaseActivity
import kr.co.kumoh.d134.isl.base.ResponseResult
import kr.co.kumoh.d134.isl.databinding.ActivityMainBinding
import kr.co.kumoh.d134.isl.view.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    lateinit var navController : NavController

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
                setDisplayShowCustomEnabled(true)
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(true)
            }

            navView.itemIconTintList = null

            val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHost.findNavController()

            toolbar.setNavigationOnClickListener {
                Log.d("서랍 엶1","작동")
                changeDrawer()
            }
//            val btnResearch: ConstraintLayout = mDataBinding.drawerMain.findViewById(R.id.btn_research)
//            val btnMembers: ConstraintLayout = mDataBinding.drawerMain.findViewById(R.id.btn_members)
//            val btnGallery: ConstraintLayout = mDataBinding.drawerMain.findViewById(R.id.btn_gallery)
//            val btnCommunity: ConstraintLayout = mDataBinding.drawerMain.findViewById(R.id.btn_community)
//            btnResearch.setOnClickListener {
//                Log.d("동작 확인","리서치")
//            }
//            btnMembers.setOnClickListener {
//                Log.d("동작 확인","리서치")
//            }
//            btnGallery.setOnClickListener {
//                Log.d("동작 확인","리서치")
//            }
//            btnCommunity.setOnClickListener {
//                Log.d("동작 확인","리서치")
//            }
            navView.setNavigationItemSelectedListener { item ->
                when (item.itemId){
                    R.id.nav_research -> navView.setupWithNavController(navController)
                    else -> Log.d("리서치", "나머지")
                }
                return@setNavigationItemSelectedListener true
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