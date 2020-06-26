package com.aba.core.di

import com.aba.core.di.scope.PerApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import android.app.Application
import com.aba.core.ui.details.di.DetailFragmentBinding
import com.aba.core.ui.listing.di.ListingFragmentBinding
import com.aba.core.ui.main.di.MainActivityBinding
import dagger.BindsInstance
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@PerApplication
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidModule::class,
        ViewModelFactoryModule::class,
        RxModule::class,
        NetworkModule::class,
        PersistenceModule::class,
        DataModule::class,
        UseCaseModule::class,
        ServiceModule::class,
        MainActivityBinding::class,
        ListingFragmentBinding::class,
        DetailFragmentBinding::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}