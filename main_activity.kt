package com.teegarcs.core_kotlin_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teegarcs.core_kotlin_android.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel

        //show an error any time this is hit.
        viewModel.errorLiveData.observe(this, {
            val toast = Toast.makeText(
                applicationContext,
                "Oops! We Let Chuck Norris Down...",
                Toast.LENGTH_LONG
            )

            toast.show()
        })


        mBinding.fullFetchJoke.setCustomClick {
            viewModel.getFullFetchJoke()
        }

        mBinding.fullFetchJoke.setLabel(getString(R.string.full_fetch_joke))


        mBinding.cachedJoke.setCustomClick {
            viewModel.getCachedJoke()
        }

        mBinding.cachedJoke.setLabel(getString(R.string.show_cached_joke))

        mBinding.cachedJoke.setCustomClick {
            viewModel.getRefreshJoke()
        }

        mBinding.cachedJoke.setLabel(getString(R.string.force_refresh_joke))

    }


}
